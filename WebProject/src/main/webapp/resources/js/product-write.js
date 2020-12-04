/**
 * 
 */
var oEditors = []; 
nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors, 
	elPlaceHolder : "smarteditor", //저는 textarea의 id와 똑같이 적어줬습니다. 
	sSkinURI : "/ex/smarteditor/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요! 
	fCreator : "createSEditor2", 
	htParams : { 
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
		bUseToolbar : true, 
		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
		bUseVerticalResizer : true, 
		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
		bUseModeChanger : true
	}
	

	}); 
$(function() {
	$("#subButton").click(function() { 
		oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);  
		//textarea의 id를 적어줍니다.  // 에디터의 내용이 textarea에 적용된다.
		
		var title = $("#prodName").val(); 
		var content = document.getElementById("smarteditor").value; //textarea의 id를 적어줍니다. 
		if (title == null || title == "") { 
			alert("제목을 입력해주세요."); 
			$("#title").focus(); 
			return; 
		} 
		if(content == "" || content == null || content == '&nbsp;' || content == '<br>' || content == '<br/>' || content == '<p>&nbsp;</p>'){ 
			alert("본문을 작성해주세요."); 
			oEditors.getById["smarteditor"].exec("FOCUS"); //포커싱
			return; 
		} //이 부분은 스마트에디터 유효성 검사 부분이니 참고하시길 바랍니다. 
		
		var result = confirm("발행 하시겠습니까?"); 
		
		if(result){ 
			alert("발행 완료!"); 
			//elClicked.form.submit();
			$("#prodWriteForm").submit(); 
		}else{ 
			return; 
		} 
	}); 
	
})
