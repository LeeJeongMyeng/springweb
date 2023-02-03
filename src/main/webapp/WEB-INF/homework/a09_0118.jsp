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
		/*2,4번 동시*/
		$('#frm01 input').keyup(function(){
			if(event.keyCode==13){
				memList()
			}
			
		})
		$('#memschBtn').click(function(){
			memList()
		})
				
				function memList(){
				
					var str = $('#frm01').serialize()
					$.ajax({
						url:'/exp2_0118.do',
						type:"post",
						data:str,
						dataType:"json",
						success:function(data){
							var addhtml = "";
							$(data).each(function(idx,mem){
								addhtml+="<tr>"
								addhtml+="<td>"+mem.id+"</td>"
								addhtml+="<td>"+mem.authority+"</td>"
								addhtml+="<td>"+mem.name+"</td>"
								addhtml+="<td>"+mem.pass+"</td>"
								addhtml+="<td>"+mem.point+"</td>"						
								addhtml+="</tr>"
							})
							$('#tb02 tbody').html(addhtml)
						}
						
					})
				
			}
		
		/*3번 */
		$('#frm2 input').keyup(function(){
			if(event.keyCode==13){
				tot()
			}
		})
		$('#totBtn').click(function(){
			tot()
		})
		
		function tot(){
			var str2 = $('#frm02').serialize()
			$.ajax({
				url:'/exp3_0118.do',
				type:'post',
				data:str2,
				dataType:'text',
				success:function(data){
					alert(data)
				},
				error:function(xhr,status,error){
	                  console.LOG(xhr)
	                  console.LOG(status)
	                  console.LOG(error)
	               }

			})
		}
		
		
		/*6번 */
		$('#frm03 input').keyup(function(){
			if(event.keyCode==13){
				deptList()
			}
		})
		
		$('#deptschBtn').click(function(){ 
			deptList()
		})
		
		function deptList(){
				
					var str = $('#frm03').serialize()
					$.ajax({
						url:'/exp6_0118.do',
						type:"post",
						data:str,
						dataType:"json",
						success:function(data){
							var addhtml = "";
							$(data).each(function(idx,d){
								addhtml+="<tr>"
								addhtml+="<td>"+d.deptno+"</td>"
								addhtml+="<td>"+d.dname+"</td>"
								addhtml+="<td>"+d.loc+"</td>"						
								addhtml+="</tr>"
							})
							$('#tb06 tbody').html(addhtml)
						},
						error:function(xhr,status,error){
			                  console.LOG(xhr)
			                  console.LOG(status)
			                  console.LOG(error)
			               }
						
					})
				
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
	    <input name="name" class="form-control mr-sm-2" placeholder="이름" />
	    <input name="authority" class="form-control mr-sm-2" placeholder="권한" />
	    <button class="btn btn-info" type="button" id="memschBtn">Search</button>
 	</nav>
	</form>
   <table id="tb02" class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>권한</th>
        <th>이름</th>
        <th>비밀번호</th>
        <th>포인트</th>
      </tr>
    </thead>	
    <tbody>
    	
    </tbody>
	</table>    
    
</div>
<hr><h2>3번문제</h2>

<div class="container">
	<form id="frm02" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="pname" class="form-control mr-sm-2" placeholder="이름" />
	    <input name="price" class="form-control mr-sm-2" placeholder="가격" />
	    <input name="cnt" class="form-control mr-sm-2" placeholder="갯수" />
	    <button class="btn btn-info" type="button" id="totBtn">Search</button>
 	</nav>
	</form>   
</div>

<hr><h2>6번문제</h2>
<div class="container">
	<form id="frm03" class="form-inline"  method="post">
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		    <input name="dname" class="form-control mr-sm-2" placeholder="부서이름" />
		    <input name="loc" class="form-control mr-sm-2" placeholder="부서위치" />
		    <button class="btn btn-info" type="button" id="deptschBtn">Search</button>
	 	</nav>
	</form>
   <table id="tb06" class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서이름</th>
        <th>위치</th>
      </tr>
    </thead>	
    <tbody>
    	
    </tbody>
	</table>    
    
</div>

</body>
</html>