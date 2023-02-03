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
		
		/* 2023-01-31
		[1단계:개념] 1. 부트스트랩의 모달창 로딩 방식을 예제를 통해 기술하세요 
			data-toggle="modal" data-target="#exampleModalCenter"
			data-target="변수명" 변수명과 일치하는 id값을 가진 modal창이 열린다.

		[1단계:확인] 2. 사원 아이디로 사원 정보를 json데이터로 로딩을 위한 DB및 controller단 get방식 처리를 하세요*/
				$('[name=ename]').keyup(function(){
							
						console.log("dddd")
					      $.ajax({   
					         url:"exp01312.do", 
					         type:"post",
					         data:$("#frm01").serialize(),
					         dataType:"json",
					         success:function(data){
					            console.log(data)
					            var empList = data.empList0131
					            var show = ""
					            	$("#exp0131 tbody").html('')
					            $(empList).each(function(idx, emp){
					            	  show += "<tr>"
					            	  show += "<td>"+emp.empno+"</td>"
					            	  show += "<td>"+emp.ename+"</td>"
					            	  show += "<td>"+emp.sal+"</td>"
					            	  show += "<td>"+emp.hiredate+"</td>"
					            	  show += "<td>"+emp.deptno+"</td>"
					            	  show += "</tr>"
					            }) 
					            $("#exp0131 tbody").html(show)
					         },
					         error:function(err){
					            console.log(err)
					         }
					      })
				})
				
				$('#seachSGBtn').click(function(){
					      $.ajax({   
					         url:"exp01313.do", 
					         type:"post",					     
					         dataType:"json",
					         success:function(data){
					            console.log(data)
					            var gradeList = data.gradeList
					            var show = ""
					            	$("#exp0131 tbody").html('')
					            $(gradeList).each(function(idx, grade){
					            	  show += "<tr>"
					            	  show += "<td ondblclick='GradeInfo("+grade.grade+")'>"+grade.grade+"</td>"
					            	  show += "</tr>"
					            }) 
					            $("#exp0131 tbody").html(show)
					         },
					         error:function(err){
					            console.log(err)
					         }
					      })
				})
						
		//[1단계:확인] 4. 부서 상세화면에서 ajax로 부서정보를 수정/삭제 처리하세요.
				/*
				1) DB처리
					sql
						update dept100	set dname=#{dname}
						loc=#{loc}
						where deptno=${deptno}
						
						delete dept100
						where deptno=${deptno}
					vo
					공통
					dao
					public void updateDept(Dept upt);
					public void deleteDept(int deptno);
					
					service
					
					controller
					/updateDept.do
					/delteDept.do
				2)화면 구현
				*/
		//[1단계:개념] 5. vue의 개발환경을 위한 설정 방법을 기술하세요.
				/*CDN방식으로 vue script코드 추가*/
				// 1.model데이터
				var model = {name:"이름:홍길동",age:"나이:6살",loc:"사는곳:서울"}
				// 3. view model : view와 model을 연결
				var vm = new Vue({
					el:"#exp06", //vue를 적용할 요소객체 최상위범위
					data:model //모델데이터
				})
		//[1단계:확인] 6. vue의 MVVM패턴을 이용하여 모델로 선언한 name, age, loc를 통해서 화면에 이름 나이 사는 곳에 출력되게하세요.
	});
	//[1단계:확인] 3. salgrade 테이블을 ajax로 로딩된 데이터를 출력하고, 행별 등급을 클릭시, 등급상세화면이 ajax로 로딩되게 처리하세요.
	function GradeInfo(grade){
		$.ajax({
				url:"exp013133.do",
				type:"post",
				data:"grade="+grade,
				dataType:"json",
				success:function(data){
	 				var gradeInfo=data.gradeInfo
	 				$("#frm02 [name=deptno]").val(gradeInfo.grade)
	 				$("#frm02 [name=dname]").val(gradeInfo.losal)
	 				$("#frm02 [name=loc]").val(gradeInfo.hisal) 
	 				$("p").click();
	 				
				},
				error:function(err){
					console.log(err)
				}
				
			})
}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline" onSubmit="return false;" method="post" action="exp01312.do">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="ename" class="form-control mr-sm-2" placeholder="사원명"  />
	    <button class="btn btn-info" type="button" id="seachBtn">검색</button>
	    <button class="btn btn-info" type="button" id="seachSGBtn">등급검색</button>
	    <button class="btn btn-info" type="button" id="seachDeptBtn">등급검색</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped" id="exp0131">
   	<col width="15%">
   	<col width="30%">
   	<col width="15%">
   	<col width="30%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>급여</th>
        <th>입사일</th>
        <th>부서번호</th>
      </tr>
    </thead>	
    <tbody>
    	
    </tbody>
	</table>    
    
</div>

<p data-toggle="modal" data-target="#exampleModalCenter2"></p>
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
	        <input type="text" class="form-control" placeholder="등급" name="deptno" >
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="시작연봉" name="dname">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="끝연봉" name="loc">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<div id="exp06">
	<h2>{{name}}</h2>
	<h2>{{age}}</h2>
	<h2>{{loc}}</h2>
</div>

</body>
</html>