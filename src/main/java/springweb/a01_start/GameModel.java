package springweb.a01_start;

import java.util.List;

import org.springframework.stereotype.Service;

import springweb.a13_database.GameDao;
import z01_vo.GameVO;
@Service
public class GameModel {
	
	GameDao dao = new GameDao();
	
	public void scoreins(GameVO gv) {
		if(dao.CheckGameUser(gv)) {
			dao.updateScore(gv);
		}else {
			dao.insertScore(gv);
		}
		
	}
	public List<GameVO> scoreList() {
		return dao.getScoreList();
	}

}
