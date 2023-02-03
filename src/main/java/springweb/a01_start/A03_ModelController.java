package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import z01_vo.Kimbap;
import z01_vo.MemberVO;
import z01_vo.Team;




// springweb.a01_start.A03_ModelController
@Controller
public class A03_ModelController {
	DeptService dservice = new DeptService();
		//http:localhost:8084/spingweb/model01.do
		//Model데이터의 처리
		//1. 메서드의 매배변수 값을 Model d를 설정
		//2. d.addAttribute("모델명",모델값)
		//3. view단에서 ${모델명}
	@RequestMapping("/model01.do")
	public String model01(Model d) {
		d.addAttribute("md_name","홍길동");
		d.addAttribute("md_age",25);
		d.addAttribute("md_loc","서울");
		return "WEB-INF\\views\\a01_start\\a03_modelView.jsp";
	}
	
	/*
	 # a03_modelView.jsp
	  <h2>이름: ${md_name}</h2>	 
	  <h2>나이: ${md_age}</h2>	 
	  <h2>위치: ${md_loc}</h2>	 
	 */
	
	//mapping url은 중복을하면 에러가난다.
	// 하디만 get,post방식으로하면 에러가 나지 않는다.
	//get방식으로 화면 호출
	//http://localhost:8084/spingweb/call10.do
	@GetMapping("/call10.do")
	public String call10() {
		return "WEB-INF\\views\\a01_start\\a10_callCalcu.jsp";
	}
	
	@PostMapping("/call10.do")
	public String call10(
			@RequestParam("price") int price,
			@RequestParam("cnt")int cnt,
			Model d
			){
		d.addAttribute("calcu",price*cnt);
		return "WEB-INF\\views\\a01_start\\a10_callCalcu.jsp";
	
	}
	
	@GetMapping("/student.do")
	public String student01() {
		return "WEB-INF\\views\\a01_start\\a11_student.jsp";
	}
	
	@PostMapping("/student.do")
	public String student01(
			@RequestParam("kor") int kor,
			@RequestParam("eng")int eng,
			@RequestParam("math")int math,
			Model d
			){
		d.addAttribute("total",kor+eng+math);
		d.addAttribute("avg",((kor+eng+math)/3));
		return "WEB-INF\\views\\a01_start\\a11_student.jsp";
	
	}
	
	/*
	 RequestMapping : get방식과 post방식 둘다 사용할 때 활용한다.
	 RequestParam(value="kor", defaultValue="0") int kor
	 요청값이 없을떄 default값으로 0을 설정하고, 요청 값이 있을떄는 해당 요청 값을
	 처리함으로 get방식과 post방식 둘다 처리가 가능하게 하는 메서드 선언이다.
	  */
	@RequestMapping("/studentPt.do")
	public String student03(
			@RequestParam(value="kor", defaultValue="0") int kor,
			@RequestParam(value="eng", defaultValue="0") int eng,
			@RequestParam(value="math", defaultValue="0") int math,
			Model d
			) {		
		d.addAttribute("total",kor+eng+math);
		d.addAttribute("avg",((kor+eng+math)/3));
		return "WEB-INF\\views\\a01_start\\a11_student.jsp";
	}
	
	@RequestMapping("/buyProduct.do")
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
	
	
	@GetMapping("/exp0110_1.do")
	public String exp0110_0(Model d) {		
		d.addAttribute("num01",(int)(Math.random()*9)+2);
		d.addAttribute("num02",(int)(Math.random()*9)+1);
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	
	
	@PostMapping("/exp0110_1.do")
	public String exp0110(
			@RequestParam(value="point", defaultValue="0") int point,
			Model d
			) {
		String grade;
		if(point>=90){grade="A등급";}
		else if(point>=80){grade="B등급";}
		else if(point>=60){grade="C등급";}
		else if(point>=40){grade="D등급";}
		else {grade="E등급";}
		d.addAttribute("grade",grade);
		
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	
	
	@PostMapping("/exp0110_2.do")
	public String exp0110_2(
			@RequestParam("id") String id,
			@RequestParam("pass")String pass,
			Model d
			){
		d.addAttribute("LoginResult",dservice.Login(id, pass));
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	
	
	@PostMapping("/exp0110_3.do")
	public String exp0110_3(
			@RequestParam("num01") int num01,
			@RequestParam("num02") int num02,
			@RequestParam("num03") int num03,
			Model d
			){
			int answer = num01*num02;
			String guguresult = answer==num03?"정답":"오답" ;
		d.addAttribute("GuguResult",guguresult);
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
    @RequestMapping("/gugu100.do")
    public String gugu100(
             @RequestParam(value="grade", defaultValue="0") int grade,
             @RequestParam(value="cnt", defaultValue="0") int cnt,
             @RequestParam(value="inRelpy", defaultValue="0") int inRelpy,
             Model d
          ) {
       //rGrade, rCnt
       d.addAttribute("rGrade", (int)(Math.random()*8+2));
       d.addAttribute("rCnt", (int)(Math.random()*9+1));
       if(grade!=0) { // 초기화면과 구분
          String msg = grade*cnt==inRelpy?"정답":"오답";
          d.addAttribute("msg", msg);
                
       }
       return "WEB-INF\\homework\\a02_0110.jsp";
    }
	
	@PostMapping("/exp0110_4.do")
	public String exp0110_4(
			@RequestParam(value="me",defaultValue="-1") int me,
			Model d
			){
		
		if(me!=-1) { //초가기화면 구분
		int comnum = (int)(Math.random()*3);
		String galbaresult ="";
		String[] comval= {"가위","바위","보"};
		
		  if(comnum==me){
			  galbaresult = "무승부";
		  } else if((comnum+1)%3==me){
			  galbaresult="승";
		  } else{
			  galbaresult="패";
		  }
		  /*
		   if(comnum==me){ galbaresult = "무승부";}
		   else if(comnum==0 && me==1){galbaresult="승"}
		   else if(comnum==1 && me==2){galbaresult="승"}
		   else if(comnum==2 && me==0){galbaresult="승"}
		   else{galbaresult="패"}
		   */
		  String com = comval[comnum];
		  String my = comval[me];
		  d.addAttribute("com",com);
		  d.addAttribute("my",my);
		d.addAttribute("galbaresult",galbaresult);
		}
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	@PostMapping("/exp0110_5.do")
	public String exp0110_5(Team team){
		
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	@PostMapping("/exp0110_6.do")
	public String exp0110_6(MemberVO mem,Model d){
		String success="";
		int meminsert=dservice.InsertMember(mem);
		if(meminsert==1) {success="등록완료";}
		else {success="등록실패";}
		
		d.addAttribute("InsertSuccess",success);
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	@PostMapping("/exp0110_7.do")
	public String exp0110_7(
				@RequestParam(value="cnt", defaultValue="0") int cnt,
				@RequestParam(value="totalcnt", defaultValue="0") int totalcnt,
				@RequestParam("check") String check,
				@RequestParam(value="price", defaultValue="0") int price,
				Model d
			){
		
		if(check.equals("minus")) {cnt = cnt*-1;}
		
		totalcnt+=cnt;
		d.addAttribute("totalcnt",totalcnt);
		d.addAttribute("totalpay",totalcnt*price);
		
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	@PostMapping("/exp0110_8.do")
	public String exp0110_8(Kimbap kb,Model d){
		
		if(kb.getPrice()>0) {
			kb.setCnt(kb.getCnt()+1);
			kb.setTot(kb.getPrice()*kb.getCnt());
		}
		
		return "WEB-INF\\homework\\a02_0110.jsp";
	}
	
	
	
		
}

