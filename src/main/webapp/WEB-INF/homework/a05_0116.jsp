<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
	.tablewrap{
		float: left;
    	position: absolute;
	}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#flip").click(function(){
			if($(this).text()=="열기"){
				$(this).text('닫기')
			}else{
				$(this).text('열기')
			}
			  $("#panel").slideToggle();
			});
	});
</script>
</head>

<body>
	 <button type="button" id="flip" class="btn btn-primary">닫기</button>
	
		<div id="panel" class="container tablewrap">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">회원번호</th>
		      <th scope="col">회원이름</th>
		      <th scope="col">직책</th>
		      <th scope="col">급여</th>
		      <th scope="col">부서번호</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="emp" items="${empList}" varStatus="s" >
		    <tr>
		      <th scope="row">${emp.empno }</th>
		    	<td>${emp.ename }</td>
		    	<td>${emp.job }</td>
		    	<td>${emp.sal }</td>
		    	<td>${emp.deptno }</td>
		    </tr>
		   </c:forEach>
		  </tbody>
	  </table>
	</div>

</body>
</html>