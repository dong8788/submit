<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<title>Insert title here</title>
</head>
<script type="text/javascript">

function execPostCode() {
	new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=addr1]").val(data.zonecode);
                $("[name=addr2]").val(fullRoadAddr);
                
               
            }
         }).open();

}

let chk1 = false, chk2 = false;
var chk3;
function fn_sellerIdChk(){
	$.ajax({
		url : "${pageContext.request.contextPath}/user/sellerIdChk",
		type : "post",
		dataType : "json",
		data : {"id" : $("#id").val()},
		success : function(data){
			if(data == 1){
				alert("중복된 아이디입니다");
			} else if(data == 0){
				$("#sellerIdChk").attr("value", "Y");
				alert("사용가능한 아이디입니다.");
				chk1 = true;
			}
			if(chk1&&chk2){
				$('#submitBtn').removeAttr('disabled');
			}
		}
	})
};

function fn_emailChk(){
	$.ajax({
		url : "${pageContext.request.contextPath}/user/emailChk",
		type : "post",
		dataType : "json",
		data : {"email" : $("#email").val()},
		success : function(data){
			console.log(data);
			chk3 = data;
		}
	});
};

function fn_authkeyChk(){
	if($('#authkey').val() == chk3){
		alert("인증되었습니다.")
		chk2 = true;
	}else{
		alert("인증번호를 다시 확인하세요")
	}
	if(chk1&&chk2){
		$('#submitBtn').removeAttr('disabled');
	}
	
	
};

</script>



<body>
	<div style="max-width:70%;margin-top:250px;margin-left:auto;margin-right:auto">
			<h4>로그인</h4>
   			<form id="registerForm" action="<c:url value='/user/sellerRegister'/>" method="post">
   			<input id="address"type="hidden" name="addr" value="">
			<table style="width:400px;margin-left:auto;margin-right:auto">
     			<tbody>
      				<tr style="height: 3em">
      				      <td>업체명</td>
      				      <td><input type="text" name="businessName" placeholder="업체명" max="20" required="required"></td>
      				      <td></td>
      				</tr>
				    <tr style="height: 3em">
           				<td>사업자 번호</td>
 				        <td><input type="text" id="businessNum" name="businessNum" placeholder="사업자 번호" max="50" required="required"></td>
         				<td class="check_font" id="businessNum_check"></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>판매자 이름</td>
            			<td><input type="text" name="name" placeholder="판매자 이름" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>아이디</td>
            			<td><input type="text" id="id" name="id" placeholder="아이디" max="20" required="required"></td>
            			<td><button class="sellerIdChk" type="button" id="sellerIdChk" onclick="fn_sellerIdChk();" value="N" style="width: 100%; height: 100%;">중복확인</button></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>비밀번호</td>
            			<td><input type="password" id="password" name="password" placeholder="비밀번호" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>비밀번호 확인</td>
            			<td><input type="password" id="passwordCheck" name="passwordCheck" placeholder="비밀번호 확인" max="20" required="required"></td>
            			<td style="vertical-align: middle;"><font id="chkNotice" size="1"></font></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>휴대전화</td>
            			<td><input type="text" name="phone" placeholder="휴대 전화 번호" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
         				
         				<td>주소</td>
         				<td><input type="text" name="addr1" id="addr1" readonly="readonly" placeholder="우편번호"></td>
         				<td><button type="button" onclick="execPostCode();">우편번호 찾기</button></td>
         				<td></td>
         			</tr>
         			<tr style="height: 3em">
         				<td></td>
            			<td><input type="text" name="addr2" id="addr2" placeholder="도로명 주소" readonly="readonly" max="50"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
         				<td></td>
            			<td><input type="text" name="addr3" id="addr3" placeholder="상세주소" max="50"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>이메일</td>
            			<td><input id="email" type="email" name="email" placeholder="이메일" max="20" required="required"></td>
            			<td><button class="authkey" type="button" id="emailChk" onclick="fn_emailChk();" style="width: 100%; height: 100%;">인증번호 받기</button></td>
         			</tr>
        			<tr style="height: 3em">
            			<td>인증번호</td>
            			<td><input type="text" id="authkey" name="authkey" placeholder="인증번호" max="20" required="required"></td>
            			<td><button class="authkey" type="button" id="authkeyChk" onclick="fn_authkeyChk();" style="width: 100%; height: 100%;">인증확인</button></td>
         			</tr>
         			<tr style="height: 3em">
            			<td colspan="3" align="right"><input id="submitBtn" type="submit" value="가입하기"></td>
         			</tr>
      			</tbody>
		</table>
   		</form>
	</div>
</body>
</html>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$( "#registerForm" ).submit(function(event){
    $('#address').val(addr1.value + addr2.value + addr3.value);
});
</script>

<script type="text/javascript">

$(function(){
    $('#password').keyup(function(){
      $('#chkNotice').html('');
    });

    $('#passwordCheck').keyup(function(){

        if($('#password').val() != $('#passwordCheck').val()){
          $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
          $('#chkNotice').attr('color', '#f82a2aa3');
        } else{
          $('#chkNotice').html('비밀번호 일치함<br><br>');
          $('#chkNotice').attr('color', '#199894b3');
        }

    });
});
</script>

<jsp:include page="../include/footer.jsp" />