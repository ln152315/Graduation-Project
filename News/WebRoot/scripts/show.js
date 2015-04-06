

function showRank(dataRank,rankname,factornumber){
//	alert(JSON.stringify(dataRank));
	var rankName =document.getElementById("rankname");
	rankName.textContent = rankname;
	var factorNumber =document.getElementById("factor");
	factorNumber.textContent = factornumber;
	var rank1 =document.getElementById("rank1");
	rank1.children[0].children[1].textContent=dataRank["1"]["title"];
	rank1.children[1].textContent=dataRank["1"]["rankValue"];
	
	var rank2 =document.getElementById("rank2");
	rank2.children[0].children[1].textContent=dataRank["2"]["title"];
	rank2.children[1].textContent=dataRank["2"]["rankValue"];
	
	var rank3 =document.getElementById("rank3");
	rank3.children[0].children[1].textContent=dataRank["3"]["title"];
	rank3.children[1].textContent=dataRank["3"]["rankValue"];
	
	var rank4 =document.getElementById("rank4");
	rank4.children[0].children[1].textContent=dataRank["4"]["title"];
	rank4.children[1].textContent=dataRank["4"]["rankValue"];
	
	var rank5 =document.getElementById("rank5");
	rank5.children[0].children[1].textContent=dataRank["5"]["title"];
	rank5.children[1].textContent=dataRank["5"]["rankValue"];
	
	var rank6 =document.getElementById("rank6");
	rank6.children[0].children[1].textContent=dataRank["6"]["title"];
	rank6.children[1].textContent=dataRank["6"]["rankValue"];
	
	var rank7 =document.getElementById("rank7");
	rank7.children[0].children[1].textContent=dataRank["7"]["title"];
	rank7.children[1].textContent=dataRank["7"]["rankValue"];
	
	var rank8 =document.getElementById("rank8");
	rank8.children[0].children[1].textContent=dataRank["8"]["title"];
	rank8.children[1].textContent=dataRank["8"]["rankValue"];
	
	var rank9 =document.getElementById("rank9");
	rank9.children[0].children[1].textContent=dataRank["9"]["title"];
	rank9.children[1].textContent=dataRank["9"]["rankValue"];
	
	var rank10 =document.getElementById("rank10");
	rank10.children[0].children[1].textContent=dataRank["10"]["title"];
	rank10.children[1].textContent=dataRank["10"]["rankValue"];
};




function showColorBlock(dataColor){
	var colorWord =document.getElementById("colorWord");
	var tmp="";
	for(var o in dataColor){
		tmp+= "<dl class = 'words'>";
	//	var dl=document.createElement("dl");
	//	dl.className = "words";
		for(var i=0;i<dataColor[o].length;i++){
			tmp += "<dd class = '"+dataColor[o][i]["color"]+"'>"+dataColor[o][i]["word"]+"</dd>";
		//	alert(i);
		//	var pt=document.createElement("dd");
		//	pt.textContent = dataColor[o][i]["word"]; 
		//    pt.className = dataColor[o][i]["color"];
		    
		    

		//    dl.appendChild(pt);
			
		}
	//	colorWord.appendChild(dl);
		tmp+= "</dl>";
		
	}
	colorWord.innerHTML = tmp;
	

};

function showNerColorBlock(dataColor){
//	alert("4.1");
//	alert(JSON.stringify(dataColor));
//	alert("4.2");
	var colorWord =document.getElementById("colorNerWord");
	var tmp="";
	for(var o in dataColor){
		tmp+= "<dl class = 'words'>";
	//	var dl=document.createElement("dl");
	//	dl.className = "words";
		for(var i=0;i<dataColor[o].length;i++){
			tmp += "<dd class = '"+dataColor[o][i]["color"]+"'>"+dataColor[o][i]["word"]+"</dd>";
		//	alert(i);
		//	var pt=document.createElement("dd");
		//	pt.textContent = dataColor[o][i]["word"]; 
		//    pt.className = dataColor[o][i]["color"];
		    
		    

		//    dl.appendChild(pt);
			
		}
	//	colorWord.appendChild(dl);
		tmp+= "</dl>";
		
	}
	colorWord.innerHTML = tmp;
	

};


function showSenColorBlock(dataColor){
//	alert("4.1");
//	alert(JSON.stringify(dataColor));
//	alert("4.2");
	var colorWord =document.getElementById("colorSenWord");
	var tmp="";
	for(var o in dataColor){
		tmp+= "<dl class = 'words'>";
	//	var dl=document.createElement("dl");
	//	dl.className = "words";
		for(var i=0;i<dataColor[o].length;i++){
			tmp += "<dd class = '"+dataColor[o][i]["color"]+"'>"+dataColor[o][i]["word"]+"</dd>";
		//	alert(i);
		//	var pt=document.createElement("dd");
		//	pt.textContent = dataColor[o][i]["word"]; 
		//    pt.className = dataColor[o][i]["color"];
		    
		    

		//    dl.appendChild(pt);
			
		}
	//	colorWord.appendChild(dl);
		tmp+= "</dl>";
		
	}
	colorWord.innerHTML = tmp;
	

};