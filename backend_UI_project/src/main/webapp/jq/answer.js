/**
 * 
 */
function target01(){
	$("#target01").css("background","blue");
}

function target02(){
	$("#target02 > span").text("바꿨다~");
}

function target03(){
	var span=$("#target03 > span").first().clone();
	console.log(span.prop("tagName"));
	$("#target03 > span").first().after(span);
}

function target04(){
	$(".target04").eq(1).css("background-color","red");
}

function target05(){
	$(".target05 > button").attr("disabled","disabled");
}

function target06(){
	$(".target06 > input").removeAttr("checked");
}

function target07(){
	$("#parent2").append($("#child"));
}

function target08(){
	$(".target08 select option").eq(1).attr("selected","selected");
}

function target09(){
	setTimeout(function(){
		$(".target09").css("font","15pt Castellar");		
	},2000);
}

function target10(){
	$("#target10 > select option:nth-child(odd)").css("background-color","yellow");
}

function target11(){
	$("#target11 > h2").siblings().remove();
}

function target12(){
//	$(".target12:not(:parent)").remove();
	$(".target12").each(function(){
		if($(this).children().length==0){
			$(this).remove();
		}
	});
}

function target13(){
	var count=parseInt($("#target13 input[name=countview]").val());
	setInterval(function(){
		$("input[name=countview]").val(count++);		
	},1000);
}

function target14(){
	$("#target14 table").append(
		$("#target14 tr").first()
	);
}

function target15(){
	var trs=$("#target15 tbody tr");
	trs.each(function(){
		$(this).children().last().text(
		parseInt($(this).children().eq(0).text())
		+parseInt($(this).children().eq(2).text())
	    )
	});
}

function target16(){
	$("#target16 td").each(function(){
		if($(this).text()>10){
			$(this).css("background-color","green");
		}
	});
}

function target17(){
	
	var num=1;
	setInterval(function(){
		if(num%2==0){
			$("#target17").css("background","red");		
		}else{
			$("#target17").css("background","yellow");
		}
		num++;		
	},1000);
}

function target18(){
	$("span:contains('bold')").css("font-weight","bold");
}

function target19(){
	$("#target19").empty();
}

function target20(){
	$("#target20 > input").css("color","red").attr("readonly","readonly");
}
















