package chapter16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.STUDENTS;
import dao.STUDENTSDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter16/search_st"})
public class Search_st extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			String keyword=request.getParameter("keyword");

			STUDENTSDAO dao=new STUDENTSDAO();
			List<STUDENTS> list=dao.search(keyword);

			request.setAttribute("list", list);
			
			request.getRequestDispatcher("attribute_st.jsp")
				.forward(request, response);
			
			

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
