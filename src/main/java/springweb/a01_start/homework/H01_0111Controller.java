package springweb.a01_start.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a13_database.A06_PareparedDao;
import z01_vo.MemberVO;
import z01_vo.homework.CountVO;

@Controller
public class H01_0111Controller {
 private CountVO cv = new CountVO();
 private MemberVO mv = new MemberVO();
 private A06_PareparedDao dao = new A06_PareparedDao();
 
@GetMapping("/exp0111.do")
public String Start(MemberVO mv,Model d,CountVO cv) {
	if(mv.getName()==null) mv.setName("");
	   if(mv.getAuthority()==null) mv.setAuthority("");
	d.addAttribute("memList",dao.getMemberList(mv));
	
	 return "WEB-INF\\homework\\a03_0111.jsp";
}

@PostMapping("/exp0111.do")
 public String Count(CountVO cv,Model d) {
	/*
	  1. 요청값 cnt => VO : CountVO cnt
	  2. controller 로직 처리
	  	if(cntOb.getCnt()!=0){
	  		cntOb.setCnt(cntOb.getCnt()+1);
	  	}
	  3. 화면단
	  	<input type="hidden" name="cnt" value="${countVO.count}"/>
	  	<button>현재:${countVO.cnt} 다음카운트업</button>
	 */
	 
		 cv.setCount(cv.getCount()+1);
	
	 return "WEB-INF\\homework\\a03_0111.jsp";
 }

@RequestMapping("/exp0111_2.do")
public String persent(
		@RequestParam(value="xktjr", defaultValue="0") double xktjr,
		@RequestParam(value="dksxk", defaultValue="0") double dksxk,
		Model d
		) {
	d.addAttribute("xkdbf",dksxk/xktjr);
		
	return "WEB-INF\\homework\\a03_0111.jsp";
}

@RequestMapping("/exp0111_3.do")
public String memList(MemberVO ins,Model d) {
	d.addAttribute("insertmemval",dao.insertMember(ins));
	return "/exp0111_1.do";
}

@RequestMapping("/exp0111_4.do")
public String memLogin(MemberVO log,Model d) {
	String page =  "redirect:/mlist.do";
	if(log.getId()==null) { //입력아이디 값이 없을때
		page="WEB-INF\\homework\\a03_0111.jsp";
	}else if(dao.login(log)==null) {
		d.addAttribute("msg","일치하는 정보가 없습니다. 다시 시도해주세요");
		page="WEB-INF\\homework\\a03_0111.jsp";
	}
	return page;
}
@RequestMapping("/mlist.do")
public String login(MemberVO m) {
	return "WEB-INF\\homework\\a08_mList.jsp";
}
}
