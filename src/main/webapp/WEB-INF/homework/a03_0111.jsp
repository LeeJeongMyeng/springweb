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
	#frm05>.emprow{
      margin:15px -10px;
   }
   
  
   #frm05>.emprow .col{
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
		var insertmemval=${insertmemval}
		if(insertmemval!=null){
			if(insertmemval==1){
				alert("등록감사합니다.")
			}else{
				alert("등록실패")
			}
		}
	});
</script>
</head>

<body id="exp0111">



<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">메인화면</h2>

</div>

<div class="container">
<h3>[1단계:개념] 1. 스프링에서 매개변수로 VO객체를 선언하는 의미를 기술하세요.</h3>
				
				VO객체에 할당함으로써 DAO의 메서드와 손쉽게 연동이 가능
				즉, 데이터데이스의 연동이 수월해짐
				조건= 전송시 VO의 각 변수명과 일치해야 자동할당.
				다를경우 = VO.set매개변수("")로 개별할당해줘야함
</div>			


 <div class="container">              
      
<h3>[1단계:개념] 3. 스프링을 데이터베이스를 처리시, 처리 순서를 기술하세요.</h3>
1. DAO : sql ==> 메서드
 	2. controller 초기화면 구성
 	3. 등록 처리 controller 기능메서드 추가
 		1) 등록요청값 vo
 		2) 등록 후, 처리할 controller선언.
 		
 	4. 화면에서 등록할 데이터 form만들기
 		- action = "/등록컨트롤러메서드.do"
 		
</div>

<%--
[1단계:확인] 2. VO 객체 요청 활용
      1) 카운트 클릭시, 모델단에서 증가되게 하여 증가된 카운트 버튼을 출력되게 하세요
         [카운트: @@] 
 --%>
 <
<div class="container">
<h2>문제1</h2>
	<form action="exp0111.do" id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="count" type="hidden" class="form-control mr-sm-2" value="${countVO.count}" />
	    <button class="btn btn-info" type="submit">현재${countVO.count}클릭시 증가</button>
 	</nav>
	</form>
</div>
<br><br>
<%--
선수이름, 타석과 안타를 입력시, 선수명과 타율(모델에서 계산)이 출력되게 하세요.

 --%>
 
<div class="container">
<h2>문제2</h2>
	<form action="exp0111_2.do" id="frm02" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="xktjr" class="form-control mr-sm-2" value="${param.xktjr}" />
	    <input name="dksxk" class="form-control mr-sm-2" value="${param.dksxk}" />
	    <button class="btn btn-info" type="submit">타율계산</button>
 	</nav>
	</form>
	<table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>타율</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td><fmt:formatNumber value="${xkdbf}" pattern="0.000" /></td></tr>
				    </tbody>
					</table> 
</div>

<%--
[1단계:확인] 4. DAO에 있는 회원리스트 화면을 구현하세요.
 --%>
 
 <div class="container">
 <h2>문제3,4</h2>
	<form action="exp0111.do" id="frm02" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="name" class="form-control mr-sm-2" value="${memberVO.name}" />
	    <input name="authority" class="form-control mr-sm-2" value="${memberVO.authority}" />
	    <button class="btn btn-info" type="submit">회원리스트 검색</button>
	    <button class="btn btn-info" type="button"
	    data-toggle="modal" data-target="#exampleModalCenter">회원등록</button>
 	</nav>
	</form>
	<table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>아이디</th>
				        <th>권한</th>
				        <th>이름</th>
				        <th>포인트</th>
				      </tr>
				    </thead>	
				    <tbody>
				    <c:forEach var="mem" items="${memList}">
				    	<tr>
				    	<td>${mem.id}</td>
				    	<td>${mem.authority}</td>
				    	<td>${mem.name}</td>
				    	<td>${mem.point}</td>
				    	</tr>
				    </c:forEach>
				    </tbody>
					</table> 
</div>

<%--
[1단계:확인] 5. 회원 등록 처리를 구현하세요
 --%>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">회원가입</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form action="exp0111_3.do" id="frm05" class="form"  method="post">
	     <div class="emprow">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="아이디 입력" name="id">
	      </div>
	      <div class="col">
	        <select class="form-control" name="authority">
	        	<option>관리자</option>
	        	<option>회원</option>
	        </select>
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="이름 입력" name="name">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="비밀번호 입력" name="pass">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" value="1000" name="point" readOnly>
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" onclick="insertMem()"class="btn btn-primary">등록하기</button>
      </div>
    </div>
  </div>
</div>

<div class="container">
<div class="container">
 <h2>문제3,4</h2>
	<form action="exp0111_4.do" id="frm06" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="id" class="form-control mr-sm-2"  />
	    <input name="pass" class="form-control mr-sm-2"  />
	    <button class="btn btn-info" type="submit">로그인</button>

 	</nav>
	</form>
</div>




</div>
</body>
<script>
function insertMem(){
	$('#frm05').submit();
}
</script>
</html>