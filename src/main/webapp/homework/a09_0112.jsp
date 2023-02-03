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
   
   
/* 2번문제 */
$('#tb01 td').css({background:"blue",textAlign:"center",color:"white"})

$('#tb01 td').click(function(){
   var fruit = $(this).text();
   var fruits = $('#fruitList').text();
   $('#fruitList').text(fruits+fruit);
})

/*3,5번문제*/   
    exp02()
    var cnt=0;
   function exp02(){   
   $('#tb02 td').each(function(index,td){
      if(index%2==0){
         $(this).css({"background":"skyblue",fontSize:"10pt"})
      }else if(index%2==1){
         $(this).css({"background":"white",fontSize:"10pt"})
      }
   })
   }
   $('#tb02 td').on({
      mouseenter:function(){
         $(this).css({"background":"pink",fontSize:"20pt"})
      },
       mouseleave:function(){
         exp02()
      },
      click:function(){
         cnt++
         $('#cnt').text(cnt)
      }
   }) 
   /*6번문제*/
   function exp06(){
   $('#frm06 input').each(function(index,ip){
      if(ip.text()=="" || ip.text()==null){
         alert("빈칸을 다 채워주세요")
         return false;
      }
      alert("원래는 알람이 아닌 submit입니다!!")
   })
   }
   
   $('#frm06#exp06id,#frm06#exp06pass,#frm06#exp06pass2').keyup(function(){
      var len = $(this).val().length;
      if(len<=5){
         $('#warning').text("5자 이상이어야합니다.")
      }else if(len>=17){
         alert("최대 16글자입니다.")
         
      }
      else{
         $('#warning').text("")
      }
   })
   
   /*7번문제*/
   $('#exp08Btn').click(function(){
      $('#exp08img').toggle('fast');
      var textval = $(this).text()
      if(textval=='이미지보기'){
         $(this).text('이미지닫기')
      }else{
         $(this).text('이미지보기')
      }
   })
});
</script>
</head>

<body>
<!-- 
[1단계:개념] 1. jquery의 선택자 선언형식과 특징을 기술하세요
         선언 형식 : $()
         특징: css선택자와 동일함 태그선택자, 혹은 class선택자일경우 자동으로 querySelectorAll과 같은 처리가 가능
         
[1단계:확인] 2. 1X4테이블에서 td의 배경색상을 파랑색, 글자정렬 중앙으로 처리하고, 판매하는 과일명을 리스트하고,
          클릭시마다 하단 p에 구매한 과일정보를 출력하세요> -->
          <hr>
          <h2>2번문제</h2>
          <table id="tb01" style="width:500px; height:200px;">
             <tr><td>사과</td><td>바나나</td><td>딸기</td><td>수박</td></tr>
          </table>
          <p id="fruitList">여기에 과일 나옴</p>
          
          
          
<!-- [1단계:확인] 3. 5X4테이블 행열단위로 짝/홀단위 배경색상을 다르게 처리하고, 커서에 따라 글자크기와 글자색상으로 다르게 처리하세요 -->
         <hr>
          <h2>3,5번문제 병합</h2>   
         <table id="tb02" style="width:500px; height:500px;">
            <c:forEach begin="0" end="3" step="1" varStatus="s">
               <tr><td>${s.index*4+1 }</td><td>${s.index*4+2 }</td>
               <td>${s.index*4+3 }</td><td>${s.index*4+4 }</td><td>${s.index*4+5 }</td></tr>
            </c:forEach>
         </table>
         count:<span id="cnt">0</span>
<!-- [1단계:개념] 4. jquery의 이벤트의 종류와 내용을 기술하세요.

         대표적으로 click/mouse/keyup등이 있다.
 -->
            

<!-- [1단계:확인] 5. 3X3테이블에 각 td마다 마우스 커서와 커서를 벗어났을 때, 배경색상을 변경하고, 클릭시 마다 카운트가 증가되게 처리하세요 -->
<!-- [1단계:확인] 6. member테이블의 항목을 회원정보 등록 화면 form으로 만들고 유효성을 처리하세요
            (모두 입력처리, 아이디(5~16), 패스워드, 패스워드 확인 ) -->
            <hr>
              <h2>6번문제 </h2>
              <div id="warning"></div>
            <div style="width:500px;">
            <form id="frm06" class="form"  method="post">
              <input type="text" id="exp6id" class="form-control " placeholder="아이디 입력" name="id" maxlength="16">
              <select class="form-control " name="authority">
                 <option>회원</option>
                 <option>관리자</option>
              </select>
              <input type="text"  class="form-control " placeholder="이름 입력" name="name">
              <input type="text" id="exp6pass" class="form-control " placeholder="비밀번호 입력" name="pass" maxlength="16">
              <input type="text" id="exp6pass2" class="form-control " placeholder="비밀번호 입력" name="pass" maxlength="16">
              <input type="text" class="form-control " placeholder="포인트 입력" name="point">
             </form> 
            </div>
            
<!-- [1단계:개념] 7. jquery의 속성 선언 형식을 기술하세요.
               $("객체").on("이벤트",function(){처리할 내용});
         $("객체").on({
            이벤트1:function(){},
            이벤트2:function(){},
            이벤트3:function(){}
         })
         호출한 객체에 대해 여러개의 이벤트를 처리할때 사용한다.
      */
      
      /*
      #다중의 속성 지정하기 json형식 처리
      1. 기본 속성 다중으로 처리
         $("#tab01").attr("속성","속성값")
         $("#tab01").attr({"속성":"속성값","속성2":"속성값2","속성3":"속성값3"})
      2. css속성 다중처리
         $("#tab01").css({"속성":"속성값","속성2":"속성값2","속성3":"속성값3"}) -->
         
<!-- [1단계:확인] 8. 회원등록화면에서 회원이미지를 [이미지보이기/보이지않게]로 클릭하면서 확인했다가/사라졌다를 클릭에 따라 반복하게 하세요. -->
               <hr>
                <h2>8번문제 </h2>
               <button type="button" id="exp08Btn">이미지보기</button>
               <p id="exp08img">원래는 이미지 보여야하는자리임^^</p>
<!-- [1단계:개념] 9. 모델어트리뷰트란 무엇인가? 개념과 실제 사용 방법에 대하여 기술하세요.
1. select형태의 콤보형선택은 DB연결되어서 처리되는 경우가 많다.
 2. controller단에서 공통으로 사용되는 key/value형식의 데이터는 ModelAttribute로 선언하여 사용한다.
 -->
            
<!-- [1단계:확인] 10. 부서정보를 DB와 연동된 콤보박스를 만들어 a01_empList.jsp에 적용하여 출력하세요.(부서정보 추가등록으로 확인) 
<sql>
SELECT deptno code, dname val 
FROM dept100
ORDER BY code;

<controller>
   @ModelAttribute("deptCode")
   public List<Code> getdeptInfo(){
      return ddao.getDeptInfo();
   }

<view>
         <select name="deptno" class="form-control">
              <option value="00">부서정보선택</option>
               <c:forEach var="cd" items="${deptCode}">
                <option value="${cd.key}">${cd.value}</option>
             </c:forEach>
           </select>

-->
               
<!-- [1단계:확인] 11. 급여등급(등급,시작범위)-salgrade을 콤보박스 만들어서 선택하게 처리할려고 한다. sql부터시작하여 화면단 출력까지 처리하세요 
            
 -->
 <hr>
       <h2>11번문제 </h2>
           <select name="deptno" class="form-control">
              <option value="00">셀그레이드</option>
               <c:forEach var="cd" items="${salGradeCode}">
                <option value="${cd.key}">${cd.value}</option>
             </c:forEach>
           </select>
           <script>
           	$("[name=frSal]").val($Psch.frSal))
           </script>
          <!-- 
<sql>
SELECT grade code, losal val 
FROM SALGRADE ORDER BY code
<controller>
 @ModelAttribute("salGradeCode")
   public List<Code> getsalGradeInfo(){
      return dao.getSGradeInfo();
   }
   
   
          
           -->
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
<script>

</script>
</html>