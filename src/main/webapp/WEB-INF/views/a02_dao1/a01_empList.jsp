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
	#frm02>.emprow{
		margin:15px -10px;
	}
	#frm02>.emprow .col{
		margin: 15px 0;
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
		var msg ="${check}"
		if(msg!=""){
			alert(msg);
		}
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>사원정보조회</h2>

</div>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="ename" value="${sch.ename}" class="form-control mr-sm-2" placeholder="사원명" />
	    <input name="job" value="${sch.job}"class="form-control mr-sm-2" placeholder="직책명" />
	    <select name="frSal" class="form-control">
              <option value="00">시작연봉선택</option>
               <c:forEach var="cd" items="${salGradeCode}">
                <option value="${cd.value}">${cd.key}등급</option>
               </c:forEach>
           </select>
	    <input name="toSal" value="${sch.toSal }" class="form-control mr-sm-2" placeholder="끝연봉" />
	       
           <script>
           // 검색시 선택된것을 선택
           	$("select[name=frSal]").val(${sch.frSal});
           </script>
	    <button class="btn btn-info" type="submit">Search</button>
	    <button class="btn btn-info" type="button"
	     data-toggle="modal" data-target="#exampleModalCenter">사원등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
    <thead>
    
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책</th>
        <th>급여</th>
        <th>부서번호</th>
      </tr>
    </thead>	
    <tbody>
    <c:forEach var="emp" items="${empList}">
    	<tr>
    	<td>${emp.empno }</td>
    	<td>${emp.ename }</td>
    	<td>${emp.job }</td>
    	<td>${emp.sal }</td>
    	<td>${emp.deptno }</td>
    	</tr>
    </c:forEach>	
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"
        style="font-weight:900;">회원정보 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form action="empInsert.do" id="frm02" class="form"  method="post">
	     <div class="emprow">
	      <div class="col">
	      사원번호
	        <input type="text" class="form-control" placeholder="사원번호 입력" name="empno">
	      </div>
	      <div class="col">
	      사원명
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	      직책
	        <input type="text" class="form-control" placeholder="직책 입력" name="job">
	      </div>
	      <div class="col">
	      입사일
	         <input type="text" class="form-control" 
                 placeholder="입사일 입력" 
                 onfocus="this.type='date'"
                 onblur="this.type='text'"
                 name="hiredateS">
	      </div>
	      <div class="col">
	      담당자
	         <select name="mgr" class="form-control">
	           <option value="0000">관리자선택</option>
 				<c:forEach var="cd" items="${mgrCode}">
 					<option value="${cd.key}">${cd.value}</option>
 				</c:forEach>
	        </select>
	      </div>
	      <div class="col">
	      급여
	        <input type="text" class="form-control" placeholder="급여 입력" name="sal">
	      </div>
	      <div class="col">
	      보너스
	        <input type="text" class="form-control" placeholder="보너스 입력" name="comm">
	      </div>
	      <div class="col">
	      	부서번호
	        <select name="deptno" class="form-control">
	           <option value="00">부서정보선택</option>
               <c:forEach var="cd" items="${deptCode}">
 					<option value="${cd.key}">${cd.value}</option>
 				</c:forEach>
	        </select>
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" onclick="insertEmp()" class="btn btn-primary">등록하기</button>
      </div>
    </div>
  </div>
</div>
</body>
<script>
function insertEmp(){
	$("#frm02").submit();
}

</script>
</html>