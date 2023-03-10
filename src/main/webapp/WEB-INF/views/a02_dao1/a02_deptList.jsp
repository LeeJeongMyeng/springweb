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
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal">부서정보조회</h2>

</div>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="dname" value="${dept.dname}" class="form-control mr-sm-2" placeholder="부서명" />
	    <input name="loc" value="${dept.loc}"class="form-control mr-sm-2" placeholder="위치" />
	    <button class="btn btn-info" type="submit">Search</button>
	    <button class="btn btn-primary" type="button"
	     data-target="#exampleModalCenter" data-toggle="modal">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
    <thead>
    
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책</th>
      </tr>
    </thead>	
    <tbody>
    <c:forEach var="dept" items="${deptList}">
    	<tr>
    	<td>${dept.deptno }</td>
    	<td>${dept.dname }</td>
    	<td>${dept.loc }</td>

    	</tr>
    </c:forEach>	
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">부서정보등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form action="deptInsert.do" id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" name="deptno" class="form-control" placeholder="부서번호 입력">
	      </div>
	      <div class="col">
	        <input type="text" name="dname" class="form-control" placeholder="부서명 입력">
	      </div>
	      <div class="col">
	        <input type="text" name="loc" class="form-control" placeholder="위치 입력">
	      </div>
	     </div>
	    </form> 
	    <script>
	    	function insertDept(){
	    		$('#frm02').submit();
	    	}
	    </script>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>&nbsp;&nbsp;
        <button type="button" onclick="insertDept()" class="btn btn-primary">등록하기</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>