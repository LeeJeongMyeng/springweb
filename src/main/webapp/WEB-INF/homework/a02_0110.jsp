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
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
<%--
2022-01-10
[1단계:개념] 1. 스프링의 요청값 처리방식을 요청 키와 값을 기준으로 controller단에 선언하는 내용을 기술하세요
					
				@GetMapping - get방식으로 받았을시 처리
				@PostMapping - Post방식으로 받을시 처리
				@RequestMapping - 둘다 받음	
					
[1단계:개념] 2. 스프링의 모델데이터 선언방식을 예제를 통해서 기술하세요.
				<일반 데이터 request를 통한 방식>
					public String product(
							@RequestParam(value="pname", defaultValue="") String pname,
							@RequestParam(value="price", defaultValue="0") int price,
							@RequestParam(value="cnt", defaultValue="0") int cnt,
							Model d
							) {
						d.addAttribute("pname",pname);
						d.addAttribute("price",price);
						d.addAttribute("cnt",cnt);
						d.addAttribute("total",price*cnt);
						return "WEB-INF\\views\\a01_start\\a12_product.jsp";
					}
				
				<VO를 통한 방식>
				@RequestMapping("/person.do")
				public String callPerson(Person person) {
					// 요청값이 없더라도 해당 메서드가 호출되고,
					// type에 맞게 호출하면 해당 요청값을 Person객체에 할당된다.
					System.out.println("요청값:"+person.getName());
					System.out.println("요청값:"+person.getAge());
					System.out.println("요청값:"+person.getLoc());
					return "WEB-INF\\views\\a01_start\\a14_InsertPerson.jsp";
				}
				
				
[1단계:확인] 3. 스프링 요청값, 모델, 뷰 연습(RequestParam으로 요청처리)  
               1) 점수를 입력하고 점수에 따른 등급분류(A~F)를 모델로 처리하고  화면에 출력하세요.(get/post 구분)--%>
               	<form action ="exp0110_1.do" id="frm01" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					    <input name="point" class="form-control mr-sm-2" placeholder="성적" />
					    <button class="btn btn-info" type="submit">성적입력</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>성적</th>
				        <th>등급</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${param.point}</td><td>${grade }</td></tr>
				    </tbody>
					</table>   
               			
        <%-- 2) 아이디와 패스워드를 입력하여 인증 여부 모델로 설정하고 화면에 출력하세요(get/post 구분) --%>
        			<form action ="exp0110_2.do" id="frm02" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					    <input name="id" class="form-control mr-sm-2" placeholder="아이디" />
					    <input name="pass" class="form-control mr-sm-2" placeholder="비밀번호" />
					    <button class="btn btn-info" type="submit">로그인</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>로그인 여부</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${LoginResult}</td></tr>
				    </tbody>
					</table> 
        			
        
        <%--       3) 초기화면에 임의의 구구단이 나오게 하고 정답을 입력하면 그 결과에 따라 정답/오답 출력되게 처리하세요(get/post 통합) --%>
        				<form action ="exp0110_3.do" id="frm03" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  		<div style="color:white;">&nbsp;&nbsp;${num01 } x ${num02 } = ?&nbsp;&nbsp;&nbsp; </div>
					    <input type="hidden" name="num01" class="form-control mr-sm-2" value="${num01 }" />
					    <input type="hidden" name="num02" class="form-control mr-sm-2" value="${num02 }" />
					    <input name="num03" class="form-control mr-sm-2" placeholder="정답입력" />
					    <button class="btn btn-info" type="submit">로그인</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>결과</th>
				        
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${GuguResult}</td></tr>
				    </tbody>
					</table> 
        <%--       4) 컴퓨터와 하는 가위바위보라는 타이틀로 해당 내용을 선택했을 때, 컴퓨터와 나의 결과에 따라 승/무/패가 처리되게 하세요.(get/post 통합)--%>
        				<form action ="exp0110_4.do" id="frm04" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					  	<select name="me" onchange="send()" class="form-control">
						  <option value="-1">선택</option>
						  <option value="0">가위</option>
						  <option value="1">바위</option>
						  <option value="2">보</option>
						</select>
				 	</nav>
					</form>
					<script>
					function send(){
					 $("#frm04").submit()
					 }
					</script>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>나</th>
				        <th>컴</th>
				        <th>결과</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${my}</td><td>${com}</td><td>${galbaresult}</td></tr>
				    </tbody>
					</table> 
        			
 <%-- [1단계:확인] 4. 스프링 요청값, 모델, 뷰 연습(VO객체로 요청처리)                 
               1) 프리미어리그 팀의 정보(팀명, 승,무,패,골득실)를 VO객체를 만들고, form으로 등록 처리했을 때, 입력된 정보를 vo를 통해서 하단에 출력되게 하세요. --%>
               		<form action ="exp0110_5.do" id="frm05" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  		<input name="teamname" class="form-control mr-sm-2" placeholder="팀이름" />
				  		<input name="win" class="form-control mr-sm-2" placeholder="승" />
				  		<input name="qe" class="form-control mr-sm-2" placeholder="무" />
				  		<input name="def" class="form-control mr-sm-2" placeholder="패" />
				  		<input name="point" class="form-control mr-sm-2" placeholder="승점" />
					    <button class="btn btn-info" type="submit">등록</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>팀</th>
				        <th>승</th>
				        <th>무</th>
				        <th>패</th>
				        <th>포인트</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${team.teamname}</td><td>${team.win}</td><td>${team.qe}</td>
				    	<td>${team.def}</td><td>${team.point}</td></tr>
				    </tbody>
					</table> 
               
               
               
            <%--   2) 회원정보(회원아이디, 이름, 패스워드, 권한, 포인트 )를 vo객체 만들고, 등록시 등록되게 하세요.--%>
            <form action ="exp0110_6.do" id="frm06" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  		<input name="id" class="form-control mr-sm-2" placeholder="아이디" />
				  		<input name="pass" class="form-control mr-sm-2" placeholder="비밀번호" />
				  		<input name="authority" class="form-control mr-sm-2" placeholder="권한" />
				  		<input name="name" class="form-control mr-sm-2" placeholder="이름" />
				  		<input name="point" class="form-control mr-sm-2" placeholder="포인트" />
					    <button class="btn btn-info" type="submit">회원등록</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>결과</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>${InsertSuccess}</td></tr>
				    </tbody>
					</table> 
            
            
            
            
            <%--   3) 김밥의 갯수나 가격   가격[0] 갯수 @ 총계 @@@  [다음 1개 확인] 초기화면이고 클릭시 마다 입력된 가격에서 한개씩 갯수가 올라가
                  계산되게 하세요..
                  [3000] 갯수 1  총계 3000  [다음 2개 확인-버튼] 
                  [3000] 갯수 2  총계 6000  [다음 3개 확인-버튼] --%>
					<form action ="exp0110_7.do" id="frm07" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  			<input type="hidden" name="totalcnt" value="${totalcnt}"/>
				  			<input type="hidden" name="price" value="3000"/>
							  <select name="check" class="selectpicker">
							    <option value="plus">추가</option>
							    <option value="minus">빼기</option>
							  </select>
					    갯수<input type="number" name="cnt" />
					    <button class="btn btn-info" type="submit">계산</button>
				 	</nav>
					</form>
				   <table class="table table-hover table-striped">
				    <thead>
				      <tr class="table-success text-center">
				        <th>음식</th>
				        <th>가격</th>
				        <th>총갯수</th>
				        <th>총계</th>
				      </tr>
				    </thead>	
				    <tbody>
				    	<tr><td>김밥</td><td>3000</td><td>${totalcnt}</td><td>${totalpay}</td></tr>
				    </tbody>
					</table> 
					
					
					<%--스앵님 풀이 김밥vo --%>
					<form action ="exp0110_8.do" id="frm08" class="form-inline"  method="post">
				  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  			<input name="price" value="${kimbap.price}" class="form-control mr-sm-2"/>
				  			<input name="cnt" value="${kimbap.cnt}" class="form-control mr-sm-2"/>
				  			<input value="${kimbap.tot}" class="form-control mr-sm-2"/>
					    <button class="btn btn-info" type="submit">다음 ${kimbap.cnt+1}개 확인</button>
				 	</nav>
					</form>
			
					
				


 
    
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
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
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
</body>
</html>