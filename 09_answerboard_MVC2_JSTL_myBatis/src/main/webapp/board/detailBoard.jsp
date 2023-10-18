<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답변형 게시판</h1>
<div id="container">
	<h2>상세보기</h2>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea readonly="readonly" rows="10" cols="60">${dto.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" disabled="disabled">답글</button>
				<button type="button"
						onclick="location.href='updateBoardForm.board?seq=${dto.seq}'">수정</button>
				<button type="button"
						onclick="location.href='mulDel.board?chk=${dto.seq}'">삭제</button>
				<button type="button"
				        onclick="location.href='boardList.board'">목록</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>










