package springweb.homework.a0130;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.homework.a0127.A0127_Service;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Member111;

@Controller("homework0130")
public class A0130_Controller {
	@Autowired(required=false)
	private A0130_Service service;
	@Autowired(required=false)
	private A0127_Service service2;
	
	//2023-01-30
	//[1단계:개념] 1. form화면을 두개 사용하는 이유를 기술하세요
	/*
	 * 조회,수정/삭제를 위한 단일 화면에서 처리프로세스를 2개 이용하기 위해. 1. 위리스트 화면에서 클릭 시, id값을 통해 요청 화면 로딩
	 * controller, model(proc(schOne)), view 2. 화면 - 데이터 1) 단일 데이터 로딩키, 요청 id값을 기준으로
	 * 모달창 로딩 후, 2) model데이터 출력 jstl 처리
	 */
	//[2단계:확인] 2. 오늘 처리한 회원관리 화면에서 회원등록 처리를 다이얼로그 박스를 활용해 처리 해보세요.
	@RequestMapping("a0130ins.do")
	public String insertMem(@ModelAttribute("member11") Member111 ins,Model d) {
		service.insertMem(ins);
		return "redirect:a0127.do";
	}
	/*
	 <service>
	 @Service
public class A0130_Service {
	
	@Autowired(required=false)
	private A0130_Dao dao;
	
	public int insertMem(Member111 ins) {
		return dao.insertMem(ins);
	}
	
}

<dao>
public int insertMem(Member111 ins);
	 */
	
	
	//[1단계:개념] 3. 컨테이너에서 viewResolver를 선언하는 이유를 기술하세요.
				/*
				 view단의 여러가지 형식을 처리하기위해서 사용한다.
				 우선순위 및 일반 html,jsp뿐만아니라 json데이터처리 등이 파일다운로드 업로드형식처리까지 가능하다. 
				 
				 */
	//[1단계:개념] 4. jsp와 컨테이너에서 bean으로 선언된 view의 우선 순위 설정 방법을 기술하세요
				//<property="order" value="0,1,2,3...."/>
				//0이 가장 높은 우선순위를 가지며 InternalResourceViewResolver는 우선순위의 가장 마지막에 와야한다.
				// 앞의 우선순위 후에 가장 마지막에 나머지를 처리한다는 느낌
	//[1단계:확인] 5. Member객체를 json view로 출력하세요.
				
				@GetMapping("exp0130_5.do")
				public String exp0130_5(Model d) {
					d.addAttribute("exp0130_5",service2.getMemberList(new Member111()));  
					return "pageJsonReport";
				}
	//[1단계:확인] 6. select * from emp으로 데이터 처리(dao,mapper에 추가)하여 json view로 출력하세요.
				@GetMapping("exp0130_6.do")
				public String exp0130_6(Model d) {
					d.addAttribute("exp0130_6",service2.getEmpList(new Emp()));  
					return "pageJsonReport";
				}
}
