package horse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Horse;
import bean.Race;
import bean.Result;
import dao.HorseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/horse/search2"})
public class Search2 extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			
			String horse_name = request.getParameter("horse_name");
			String result = request.getParameter("result");
			String race = request.getParameter("race");
			
			if (horse_name != "") {
				HorseDAO dao=new HorseDAO();
				List<Horse> list=dao.horse_search(horse_name);
				
				request.setAttribute("mode", "horse_name");
				request.setAttribute("list", list);
				request.getRequestDispatcher("horse5.jsp")
				.forward(request, response);;
			}
			else if (result != "") {
				HorseDAO dao=new HorseDAO();
				List<Result> list=dao.result_search(result);
				
				request.setAttribute("mode", "result");
				request.setAttribute("list", list);
				request.getRequestDispatcher("horse5.jsp")
				.forward(request, response);;
			}
			else if (race != "") {
				HorseDAO dao=new HorseDAO();
				List<Race> list=dao.race_search(race);

				request.setAttribute("mode", "race");
				request.setAttribute("list", list);
				request.getRequestDispatcher("horse5.jsp")
				.forward(request, response);
			
			}
			else {
				request.setAttribute("list", "");
				request.getRequestDispatcher("horse5.jsp")
				.forward(request, response);
			}
			

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}

