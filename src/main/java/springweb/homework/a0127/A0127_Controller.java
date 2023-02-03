package springweb.homework.a0127;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_vo.Code;
import springweb.z01_vo.Member111;

@Controller("homework0127")
public class A0127_Controller {
	@Autowired(required=false)
	private A0127_Service service;
	
	/*
	 2023-01-27
[1단계:개념] 1. db가 연결된 스프링 MVC패턴의 개발 순서를 기술하세요.
			1. DI컨테이너에서 1)mybatis.xml과 연동 , 2)sql서버연동 ,3)spring 어노테이션 할당 등록
            2. mybatis.xml에서 mapper 연동 및 vo연동
            3. mapper에서 sql구문 작성
            4. interface dao에서 mapper에서 작성한 sql구문의 id와 맞게 객체화
            5. service단에서 get/set조건 처리 및 interface dao의 메서드 결과값 return
               * service단은 @Service어노테이션을 명시함으로써, DI컨테이너가 서버시작시 호출할수 있도록한다.
               * 이떄 interface dao는 @Autowired어노테이션 자동주입 처리 연결
               * @Autowired(required=false)로 null에러 방지
            6. controller단에서 @Autowired로 service단과 자동주입처리 연결
               *controller는 @Controller어노테이션 명시함으로써, DI컨테이너가 호출할수 있도록한다.
               *중복 방지를 위해 해당 어노테이션에 변수명 할당
               *@Request/Get/PostMapping으로 url값 할당
               *해당 메서드 return처리로 설정한 jsp로 데이터 할당
               *이때, 전송하기위해서는 @ModelAttibute나 Model내장 객체를 호출하여  앞의 데이터를 할당하여 view단에 출력한다.
               *
[1단계:확인] 2. 회원관리 화면을 처리하세요(member테이블 활용하여 리스트)
[1단계:확인] 3. 회원관리 화면을 처리하세요(member테이블 활용하여 단일 데이터 조회)*/
	@RequestMapping("a0127.do")
	public String mem111List(@ModelAttribute("sch") Member111 sch,Model d) {
		d.addAttribute("memList",service.getMemberList(sch));
		return "WEB-INF\\homework\\a10_0127.jsp";
	}

			
//[1단계:확인] 4. 회원관리 화면을 처리하세요(member테이블 활용하여 수정)
	@RequestMapping("a0127upt.do")
	public String updateMem(Member111 upt) {
		service.updateMem(upt);
		return "redirect:a0127.do";
	}
//[1단계:확인] 5. 회원관리 화면을 처리하세요(member테이블 활용하여 삭제)
	@RequestMapping("a0127del.do")
	public String deleteMem(Member111 upt) {
		service.deleteMem(upt);
		return "redirect:a0127.do";
	}
//[1단계:개념] 6. 모델어트리뷰트로 콤보박스를 사용하는 경우 처리하는 순서를 기술하세요. 
//[1단계:확인] 7. 회원테이블(member)에 권한을 콤보박스를 사용하여 검색조건으로 추가하여 처리하세요. 
	@ModelAttribute("authCode")
	 public List<String> getAuthInfo(){
		 return service.getAuthInfo();
		 }
	/*
	1. 어트리뷰트 어노테이션의 변수명으로 하여 콤보박스를 만들 데이터를 List형식으로 할당받는다.
		mapper -> dao -> service -> controller
	2. view단에서는 어노테이션의 변수명으로 해당 데이터를 출력한다.
	 */
	
}
