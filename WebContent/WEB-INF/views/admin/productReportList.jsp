<%@page import="java.util.List"%>
<%@page import="com.kh.afm.product.model.vo.Report"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/adminHeader.jsp" %>
<%
	List<Report> list = (List<Report>) request.getAttribute("list");
%>
<section id="productReportList-container" class="admin-container">

<table id="tbl-report">
    <thead>
        <tr>
			<th>신고번호</th>
			<th>신고제목</th>
			<th>신고유형</th>
			<th>신고내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>상품번호</th>
			<th>처리상태</th>
			<th>상품노출수정</th>
        </tr>
    </thead>
    
    <tbody>

<%
	for(Report report : list){
%>
	<tr>
		<td><%= report.getReportNo() %></td>
		<td><%= report.getReportTitle() %></td>
		<td><%= report.getReportType() %></td>
		<td><%= report.getReportContent() %></td>
		<td><%= report.getUserId() %></td>
		<td><%= report.getReportRegDate() %></td>
		<td><%= report.getpNo() %></td>
		<td><%= "N".equals(report.getReportStatus()) ? "미처리" : "처리완료" %></td>
		
		<td> <!-- 상품노출수정 select-option태그 -->	
			<select>
				<option value="Y">노출</option>
				<option value="N">비공개</option>
			</select>
		</td>
	</tr>
<%
    }
%>
	</tbody>	
</table>

<!-- 페이지바 영역 -->
<div id="pageBar">
	<%= request.getAttribute("pagebar") %>
</div>	


</section>

<script>


</script>

<%@ include file="/WEB-INF/views/admin/adminFooter.jsp" %>