var  dataRank,timelinessRank,sensitivenessRank,clarityRank,consequenceRank;

$(document).ready(function(){
   
    $("#btn").click(function(e){
    	e.preventDefault();
    	//alert($('#timelinessWeight').attr("value"));ֵ
   // 	alert($('#timelinessWeight').val());
        $.ajax({
            url: "InputAction.action",
       
            type: "post",
           
            dataType : "json",
       
            data : {
            	news:$('#txt').val(),
            	timelinessWeight:$('#timelinessWeight').val(),
        		sensitivenessWeight:$('#sensitivenessWeight').val(),
        		clarityWeight:$('#clarityWeight').val(),
        		consequenceWeight:$('#consequenceWeight').val()
            },
    //  ֵ
            success : show ,
            error: errorMes
        });
        return false;
    });
    
    $("#rd-c1").click(function(e){
    	e.preventDefault();
    	//alert($('#txt-analysis').attr('value'));
        // ���л��?��ֵ
    	showRank(timelinessRank,"新闻时效性排行榜","时效指数");
    	
        
        return false;
    });
    $("#rd-c2").click(function(e){
    	e.preventDefault();
    	//alert($('#txt-analysis').attr('value'));
        // ���л��?��ֵ
    	showRank(sensitivenessRank,"新闻敏感性排行榜","敏感指数");
        
        return false;
    });
    $("#rd-c3").click(function(e){
    	e.preventDefault();
    	//alert($('#txt-analysis').attr('value'));
        // ���л��?��ֵ
    	showRank(dataRank,"新闻价值排行榜","价值指数");
        
        return false;
    });
    $("#rd-c4").click(function(e){
    	e.preventDefault();
    	//alert($('#txt-analysis').attr('value'));
        // ���л��?��ֵ
    	showRank(clarityRank,"新闻清晰性排行榜","清晰指数");
        return false;
    });
    $("#rd-c5").click(function(e){
    	e.preventDefault();
    	//alert($('#txt-analysis').attr('value'));
        // ���л��?��ֵ
    	showRank(consequenceRank,"新闻严重性排行榜","严重指数");
        
        return false;
    });
});
 
function show(result){
    //����result�Ƿ�ӷ������˷��ظ�ͻ���
	//alert(JSON.stringify(result.dataRank));
//	alert("1");
	dataRank = result.dataRank;
	timelinessRank = result.timelinessRank;
	sensitivenessRank = result.sensitivenessRank;
	clarityRank = result.clarityRank;
	consequenceRank = result.consequenceRank;
	showResult(result.dataMap);
//	alert("2");
	showRank(dataRank,"新闻价值排行榜","价值指数");
//	alert("3");
	showColorBlock(result.dataColor);
//	alert("4");
	showNerColorBlock(result.dataNerColor);
//	alert(JSON.stringify(timelinessRank));
	showSenColorBlock(result.dataSenColor);
//	alert("5");
    //����json����
 //   var json = eval("("+result+")");
 //   var obj = "����: "+json.news;
 //   $("#result").html(obj);
}

function errorMes(result){
	alert("请求失败");
}