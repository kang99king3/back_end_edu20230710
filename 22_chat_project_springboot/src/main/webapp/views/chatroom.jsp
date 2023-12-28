<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<style type="text/css">
	#container{
		width:400px;
		margin: 0 auto;
	}
	#chatting{
		border:1px solid gray;
		width:300px;
		height:500px;
	}
	#chat{
		width:295px;
	}
	#id_content > p{
		width:50px;
		background-color: orange;
		border-radius:5px;
		padding:5px 5px;
		text-align: center;
	}
	#id_content > span{
		display:inline-block;
		width:100px;
		padding:5px 5px;
		border-radius:0px 7px 7px 7px;
		border:1px solid gray;
		margin-left: 80px;
	}
</style>
</head>
<body>
<div id="container">
	<h1>채팅하기</h1>
      <!-- Main Content-->
   	<label>ROOM:</label><input type="text" id="roomNo" value="${param.roomNo}"><br/>
  	<label>ID:</label><input type="text" id="userId" value="${param.userId}">
	<main>
   		<div class="container-fluid">
	    	<div>
		    	<div id="card">
	    			<div id="chatting">
	    			
		    		</div>
	    		</div>
	    		<div>
					<input id="chat" type="text" placeholder="메세지를 입력하세요">
					<div>
					 <button style="border-radius: 10px;width:100px;" id="send-btn"  onclick="send()" type="button">전송</button>
					</div>	
				</div>
			</div>
		</div>
    </main>
</div>
<script type="text/javascript">
	var ws;
	window.addEventListener("load", (event) => {
		if ($("#userId").val() == "unknown") {
			alert("권한이 없습니다.");
			location.href="/loginform";
		}
		ws = new WebSocket("ws://" + location.host + "/chatting/" + $("#roomNo").val());
		wsEvt();
		
// 		$("#chating").append("<p>" + $("#userid").val() + "님 환영합니다. </p>");	
	});
	function wsEvt() {
		//채팅이 시작되면 실행되는 함수
		ws.onopen = function(data){
			var option ={
				type : "wellcom",
	 			userId: $("#userId").val(),
	 			roomNo : $("#roomNo").val(),
	 			msg : $("#userId").val() + "님이 입장하셨습니다."
		 	}
			ws.send(JSON.stringify(option));
		}
		
		//서버에서 메시지를 받으면 실행하는 함수
		ws.onmessage = function(data) {
			//메시지를 받으면 동작
			var msg = data.data;
			console.log(msg);
			var json = JSON.parse(msg);
			if (json.type == "wellcom") {
				$("#chatting").append("<span id='ent_chat'> System : " + json.msg + "</span>");	
			} else {
				$("#chatting").append("<div id='id_content'><p>" + json.userId + "</p><span id='content'>" + json.msg + "</span></div>");	
			}
			var chatting = $('#card');
	 		chatting.scrollTop(chatting.prop('scrollHeight'));
		}

		//웹소켓 연결 종료되면 실행
		ws.onclose=function(){
			ws=null;//웹소켓 연결 끊고 null로 초기화
// 			alert("채팅종료");
		}
		
		//키보드를 누르면 함수 실행 --> 누른 키의 code가 13이면 enter 키임(enter키를 누르면 send()함수 실행)
		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}

	//메시지를 서버로 전송하는 함수
	function send() {
		//전송할 내용을 json으로 정의
		var option ={
			type : "msg",
			userId: $("#userId").val(),
 			roomNo : $("#roomNo").val(),
 			msg : $("#chat").val()
		}
		//서버로 전송한다.(json객체를 문자열로 변환하여 보낸다)
		//WebChatHandler.java에 
		ws.send(JSON.stringify(option));
		var chat = $('#chat'); //chat: 입력박스 엘리먼트 탐색
		chat.val("");//메시지 보냈으니 입력박스 초기화
// 		alert(chatting.prop('scrollHeight'));
	}
</script>
</body>
</html>