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
		
	$('.sch').click(function(){
		var textval = $(this).text()
		if(textval=='검색'){
			$('#frm01').attr("action","a0127.do").submit();
		}else if(textval=="삭제"){
			var midval1 = $('#frm01 input[name=mid]').val()
			if(midval1==null || midval1==""){
				alert("삭제할 아이디를 입력해주세요.");
			}else{
				$('#frm01').attr("action","a0127del.do").submit();
			}
		}else{
		var midval2 = $('#frm02 input[name=mid]').val()
			if(midval2==null || midval2==""){
				alert("아이디는 필수로 입력해주세요.");
			}else{
				$('#frm02').attr("action","a0127upt.do").submit();
			}
		}
	})
	
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="mid" class="form-control mr-sm-2" placeholder="아이디" />
	    <input name="name" class="form-control mr-sm-2" placeholder="이름" />
	    <select name="auth" class="form-control mr-sm-2">
	    	<option value="">권한선택</option>
	    	<c:forEach var="a" items="${authCode }">
	    		<option>${a}</option>
	    	</c:forEach>
	    	
	    </select>
	    <button class="btn btn-info sch" type="button">검색</button>
	    <button class="btn btn-info sch" type="button">삭제</button>
	    <button class="btn btn-info sch" type="button" data-toggle="modal" data-target="#insertMember111">등록하기</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
 
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>권한</th>
      </tr>
    </thead>	
    <tbody>
    <c:forEach var="mem" items="${memList}">
    	<tr><td>${mem.mid }</td><td>${mem.pass }</td><td>${mem.name }</td><td>${mem.auth }</td></tr>
    </c:forEach>
    </tbody>
	</table>    
</div>


<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="아이디" name="mid">
	      </div>
	      <div class="col">
	        <input  type="text" class="form-control" placeholder="패스워드" name="pass">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary sch">수정</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="insertMember111" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form id="frm02" class="form"  method="post" action="a0130ins.do">
      <div class="modal-body">
		
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="아이디" name="mid" required>
	      </div>
	      <div class="col">
	        <input  type="text" class="form-control" placeholder="패스워드" name="pass" required>
	      </div>
	      <div class="col">
	        <input  type="text" class="form-control" placeholder="이름" name="name" required>
	      </div>
	      <div class="col">
	        <input  type="text" class="form-control" placeholder="권한" name="auth" required>
	      </div>
	     </div>
	    
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary sch">등록</button>
      </div>
      </form> 
    </div>
  </div>
</div>


</body>
</html>