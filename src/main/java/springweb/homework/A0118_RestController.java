package springweb.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import z01_vo.Dept;
import z01_vo.MemberVO;

@RestController
public class A0118_RestController {
	@Autowired
	private A0118_Service service;
/*
[1단계:개념] 1. ajax처리를 위하여 백엔드단에서 처리할 부분과, 프런트단 처리할 부분을 구분하여 기술하세요.
		
		- @RestController를 통한 문자열 데이터 호출 및  json데이터 호출 처리.
			1)Gson 변수명 = new Gson();
			2) return 변수명.toJson(데이터)
		
		-jquery를 활용 처리
			- $.ajax ({속성1:속성값,...})
			- 속성
				1)url : 요청 주소, 자원을 호출하는 것을 말한다.
					ex) $.ajax({"url":"${path}/empAjax.do"})
					
				2)data : 요청값 전달(query string 형식)
					1번) : data:"id="+$("#id").val()+"pass="+$("pass").val()
					
					2번) : date:$("from").serialize() // 폼객체에 포함된 요소객체를 name,value에의해
							자동 query string으로 만들어 준다.
							
				3)type : get/post
				
				4) dataType : 결과로 받은 데이터 유형
					json,xml,text
					
				5) success: 서버에서 전달 받았을떄, 에러가 없을 시,
					즉, readyState==4, status==200일때 사용하는 메서드
					
						success:function(date){
							data:받은 데이터/객체
						}
						
					error : 에러발생시 사용할 기능 메서드
							error:function(xhr,status,error){}
		
[1단계:확인] 2. dao에 회원정보 처리 메서드 확인해서, json데이터를 가져오는 처리를 하세요
[1단계:확인] 4. 초기화면을 로딩해서 회원명과 권한으로 조회해서 회원 정보를 ajax로 출력하여 처리를 하세요.*/
			@RequestMapping(value="/exp2_0118.do", produces="text/plain;charset=UTF-8")
			public String exp2_0118(MemberVO sch) {
				
				Gson g = new Gson();
				if(sch.getName()==null) sch.setName("");
				if(sch.getAuthority()==null) sch.setAuthority("");
	
				return g.toJson(service.getMemList(sch)) ;
			}
			

//[1단계:확인] 3. jquery ajax를 이용해서 물건가격과 갯수를 입력시, 결과로 컨트롤에서 총계를 받아서 alert으로 처리하게 하세요.
			@RequestMapping(value="/exp3_0118.do", produces="text/plain;charset=UTF-8")
			public String exp3_0118(
					@RequestParam(value="pname", defaultValue="") String pname,
					@RequestParam(value="price", defaultValue="") int price,
					@RequestParam(value="cnt", defaultValue="") int cnt
					) {
					
				String answer = pname+"를 "+cnt+"개 구매하여 총 "+(price*cnt)+"원 입니다.";
	
				return answer;
			}
//[1단계:개념] 5. 소스로 코드상 의존성 자동 주입을 할려면 사전에 어떤 처리를 하여야 하고, 실제 처리 예제를 기술하세요
			/* <context:component-scan base-package="springweb" >
		      	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		      	<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
		      	<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
		      	<!-- <context:include-filter type="annotation" expression="org.springframework.stereotype.RestController"/> -->
		      </context:component-scan>
		      
		      <컨트롤러단>
		      @Controller ==> 최우선선언
		      @Autowired
		      private 클래스 변수명  ==> 해당 클래스를 new생성자 없이, 이어주는 역할
		      <ajax컨트롤러>
		      @RestController 최우선 선언
		      <모델 서비스단>
		      @Service
		      
		      
		      
		     */
//[1단계:확인] 6. Service단에 Dept객체를 리턴하고, 코드상 의존성 자동주입을 해서 화면단에 부서정보를 출력하게 처리하세요
			@RequestMapping(value="/exp6_0118.do", produces="text/plain;charset=UTF-8")
			public String exp6_0118(Dept d) {
					
				Gson g = new Gson();
				if(d.getDname()==null) d.setDname("");
				if(d.getLoc()==null)d.setLoc("");
				
	
				return g.toJson(service.getdeptList(d));
			}
}
