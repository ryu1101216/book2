package horse;

import java.util.List;

import bean.Horse;
import bean.Race;
import bean.Result;
import dao.HorseDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SearchAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
			
			String horse_name = request.getParameter("horse_name");
			String result = request.getParameter("result");
			String race = request.getParameter("race");
			String mode = "";
			
			if (horse_name != "") {
				HorseDAO dao=new HorseDAO();
				List<Horse> list=dao.horse_search(horse_name);
				request.setAttribute("list", list);
				mode = "horse_name";
			}
			else if (result != "") {
				HorseDAO dao=new HorseDAO();
				List<Result> list=dao.result_search(result);
				request.setAttribute("list", list);
				mode = "result";
			}
			else if (race != "") {
				HorseDAO dao=new HorseDAO();
				List<Race> list=dao.race_search(race);
				request.setAttribute("list", list);
				mode = "race";
			}
			else {
				request.setAttribute("list", "");
			}
			
			request.setAttribute("mode", mode);
						
			return "SearchAction.jsp";
			
	}
}

