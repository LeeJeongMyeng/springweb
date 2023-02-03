<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%--server설정의 path를 가져와서 고정시켜줌 ㅇㅇ --%>
<c:set var="css" value="${path}/resources"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@animxyz/core">
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
	body{
	height:900px;
	}
	td{text-align:center;}
	#game{
		position: absolute;
   		 top: 250px;
    	left: 8%;
	}
	#title{
		text-align: center;
    margin: 71px 0px 0 250px;
    width: 463px;
    font-weight: bold;
	}
	.gamestart{
	    width: 700px;
    margin-left: 227px;
    margin-top: 25px;
	}
	.gamestart>.btn{
		width: 160px;
   		height: 45px;
    	font-size: 30px;
    	padding: 0px;
	}
	#count{
		box-sizing: border-box;
	    position: absolute;
	    width: 600px;
	    height: 300px;
	    top: 38%;
	    left: 8%;
	    z-index: 100;
	    color: wheat;
	    font-size: 165px;
	    text-align: center;
	}
  .item-group {
    --xyz-translate-y: -350%;
    --xyz-ease: cubic-bezier(0.5, -1.5, 0.5, 1.5);
  }
  
  .score{
    float: right;
    width: 660px;
    position: absolute;
    top: 25%;
    right: 2%;
  }
  
  .score .table-dark th{
  	text-align:center;
  }
  
  #info{
  	width: 552px;
    background: wheat;
    position: absolute;
    top: 25%;
    right: 34%;
    border-radius: 10px;
  }
  #info h2{
  	text-align:center;
  }
  
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>

</head>
<body>

<div id="info">
	<h2 style="color:red;">!필독!</h2>
	<ul>
		<li>게임시작전 <b style="color:red;">새로고침(F5)</b>을 한 번만 눌러주세요!
		<li> 이미지 업데이트가 정상적이지 않습니다. 빠르게 수정하겟습니다..*^^*
	</ul>
	<br><br>
	<h3>&nbsp;&nbsp;&#91;조작법&#93;</h3>
	<ol>
		<li> 좌우 방향키로 이동(위아래는 이동이 불가합니다.)
		<li> 스페이스바로 공격
		<li> 외계인 제거시 1점 획득
	</ol>
	<br><br>
	<h3>&nbsp;&nbsp;&#91;기록남기기&#93;</h3>
	<ul>
		<li>게임 종료후 이름을 등록할 수 있습니다.
		<li>이름이 중복될경우 업데이트가 되니 신중하게 기입 부탁드립니다.
	</ul>
</div>


 <h1 id="title">외계인 침공을 막아라!!</h1>
	  <div id="count"></div>
	  <div id="game"></div><br>
	  <div class="gamestart">
	  <button type="button" class="btn btn-primary " name=start value="1">EASY</button>
	  <button type="button" class="btn btn-success" name=start value="2">NORMAL</button>
	  <button type="button" class="btn btn-danger" name=start  value="3">HARD</button>
	  </div>
		<div class="container score">
		<table class="table table-dark table-striped">
		<tr><th>유저</th><th>점수</th><th>기록일</th></tr>
  		<c:forEach var="sc" items="${score}">
	    	<tr>
		    	<td>${sc.name }</td>
		    	<td>${sc.score }</td>
		    	<td>${sc.date }</td>
	    	</tr>
	    </c:forEach> 
		</table>
		</div>
		<form id="scorefrm" action="scoreins.do" method="post">
			<input type="hidden" name="name"/>
			<input type="hidden" name="score"/>
		</form>
		
	 
	  
<script src="${css }/game/js/main.js">
</script>

</body>
</html>