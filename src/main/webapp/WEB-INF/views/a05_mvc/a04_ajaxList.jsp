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
		
		$(".sch").keyup(function(){
			   var dnameVal = $("[name=dname]").val()
			      var locVal = $("[name=loc]").val()
			      $.ajax({   
			         url:"deptAjaxInit2.do",
			         type:"post",
			         //data:"dname="+dnameVal+"&loc="+locVal,
			         data:$("#frm01").serialize(),
			         //오타나면 적용이안되서  default인 text로 적용된다.
			         dataType:"json",
			         success:function(data){
			            console.log(typeof(data)) //문자열 string,object
			            // d.addAttribute("dlist",service.getdept())
			            var dlist = data.dlist 
			            var show = ""
			            //object일떄 가능..
			            // dlist.forEach(function(dept,idx{}))
			            $(dlist).each(function(idx, dept){
			               console.log(dept) 
			               show+="<tr ondblclick='goPage("+dept.deptno+")'>"
			               show+="<td>"+dept.deptno+"</td>"
			               show+="<td>"+dept.dname+"</td>"
			               show+="<td>"+dept.loc+"</td>"
			               show+="</tr>"
			            })
			            $("#dataTab tbody").html(show)
			         },
			         error:function(err){
			            console.log(err)
			         }
			      })
			})//keyup
		
			
			
			
	})//ready
	function goPage(deptno){
		$.ajax({
				url:"DeptAjAX.do",
				type:"post",
				data:"deptno="+deptno,
				dataType:"json",
				success:function(data){
	 				var deptajax=data.DeptAjax
	 				//console.log("data:"+typeof(data))
	 				//console.log("data.DeptAjax:"+data.DeptAjax)
	 				//console.log("data.DeptAjax:"+deptajax)
	 				//console.log(deptajax)
	 				$("#frm02 [name=deptno]").val(dept.deptno)
	 				$("#frm02 [name=dname]").val(dept.dname)
	 				$("#frm02 [name=loc]").val(dept.loc)
	 				$("p").click();
	 				
				},
				error:function(err){
					console.log(err)
				}
				
			})
}
	
	$('#uptdept').click(function(){
		$.ajax({
			url:"updateDept.do",
			type:"post",
			data:$('#frm02').serialize(),
			dataType:"json",
			success:function(data){
 				if(data!=null){
 					alert("수정완료")
 				}
 				
 				
			},
			error:function(err){
				console.log(err)
			}
			
		})
	})
	
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post" action="deptAjaxInit.do">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="dname" class="form-control mr-sm-2 sch" placeholder="부서명" />
	    <input name="loc" class="form-control mr-sm-2 sch" placeholder="부서위치" />
	    <button class="btn btn-info" type="button" id="deptajaxsch">검색</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped" id="dataTab">
	   	<col width="33%">
	   	<col width="33%">
	   	<col width="33%">
    <thead>  
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>위치</th>
      </tr>
    </thead>
    	
    <tbody> 	
    </tbody>
	</table>    
    
</div>
<p data-toggle="modal" data-target="#exampleModalCenter2">zzzz</p>
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">상세부서정보</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="deptno" readonly >
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="dname">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="loc">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="deldept">삭제</button>
        <button type="button" class="btn btn-primary" id="uptdept">수정</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>