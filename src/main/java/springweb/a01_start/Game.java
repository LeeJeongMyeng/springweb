package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import z01_vo.GameVO;

@Controller
public class Game {
	GameModel gm = new GameModel();
	GameVO gv = new GameVO();
	
		
	@RequestMapping("/playgame.do")
	public String start(Model d) {
		
		d.addAttribute("score",gm.scoreList());
		return "WEB-INF\\views\\JS_Game\\game.jsp";
	}
	
		@RequestMapping("/scoreins.do")
		public String game(GameVO gv) {
			gm.scoreins(gv);
			return "redirect:/playgame.do";
		}
	

}
