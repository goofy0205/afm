<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.afm.user.model.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.kh.afm.user.model.service.UserService"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user.css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
</head>
<body>

	<section id=enroll-container>
		<h2>회원 정보 보기</h2>
		<form 
			name="userUpdateFrm" 
			action="<%=request.getContextPath()%>/user/userUpdate" 
			method="POST">
			<table>
				<tr>
					<th>이메일</th>
					<td>	
						<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%= loginUser.getUserEmail() != null ? loginUser.getUserEmail() : "" %>"><br>
					</td>
				</tr>
				<tr>
					<th>아이디<sup>*</sup></th>
					<td>
						<input type="text" placeholder="3글자이상" name="userId" id="_userId" value="<%= loginUser.getUserId() %>" readonly required>
					</td>
				</tr>
				<%-- 
				<tr>
					<th>패스워드<sup>*</sup></th>
					<td>
						<input type="password" name="password" id="_password" value="<%= loginMember.getPassword() %>" required><br>
					</td>
				</tr>
				<tr>
					<th>패스워드확인<sup>*</sup></th>
					<td>	
						<input type="password" id="password2" value="<%= loginMember.getPassword() %>" required><br>
					</td>
				</tr>   
				--%>
				<tr>
					<th>이름<sup>*</sup></th>
					<td>	
					<input type="text"  name="userName" id="userName" value="<%= loginUser.getUserName() %>" readonly="readonly"><br>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>	
					<input type="date" name="birthday" id="birthday" value="<%= loginUser.getBirthday() != null ? loginUser.getBirthday() : "" %>" readonly="readonly" ><br />
					</td>
				</tr> 
				<tr>
					<th>휴대폰<sup>*</sup></th>
					<td>	
						<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%= loginUser.getPhone() %>" required><br>
					</td>
				</tr>
				
			<%--	
				<tr>
					<th>주소</th>
					<td>	
						 <input type="text" placeholder="" name="address" id="address" value="<%= loginUser.getAddress() != null ? loginUser.getAddress() : "" %>"><br> 
					</td>
				</tr>
				<tr>
					<th>계좌 </th>
					<td>
						<input type="text" placeholder="" name="banknum" id="banknum" maxlength="11" value="<%= loginUser.getAccount() %>" required><br>
					</td>
				</tr>
			 --%>

			</table>
			<input type="submit" value="저장" >
			<input type="button" onclick="location.href='<%= request.getContextPath() %>/user/updatePassword';" value="비밀번호변경" />
			<input type="button" onclick="deleteUser();" value="탈퇴">
		</form>
	</section>	
	
	<!-- 회원탈퇴폼 -->
	<form name="userDelFrm"
		action="<%=request.getContextPath()%>/user/userDelete"
		method="POST">
		<input type="hidden" name="userId"
			value="<%=loginUser.getUserId()%>" />
	</form>
	<script type="text/javascript">
		function deleteUser() {
			if (confirm("정말로 탈퇴하시겠습니까?")) {
				$(document.userDelFrm).submit();
			}
		}
		
		/**
		* userUpdateFrm 유효성 검사
		* 1. 필수항목 값입력 확인
		* 2. 아이디/비번 4글자이상
		* 3. 비밀번호 일치 확인
		*/
		$("[name=userUpdateFrm]").submit((e) => {
			//userName
			const $userName = $("#userName");
			if(/^[가-힣]{2,}$/.test($userName.val()) == false){
				alert("이름은 한글 2글자 이상이어야 합니다.");
				$userName.select();
				return false;
			}
			
			//phone
			const $phone = $("#phone");
			//-제거하기
			$phone.val($phone.val().replace(/[^0-9]/g, ""));//숫자아닌 문자(복수개)제거하기
			
			if(/^010[0-9]{8}$/.test($phone.val()) == false){
				alert("유효한 전화번호가 아닙니다.");
				$phone.select();
				return false;
			}
			
			return true;
		});
		

		</script>
</body>
</html>
	