package chapter22;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter22/jstl2"})
public class JSTL2 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			request.setAttribute("age", 21);
			request.setAttribute("point", 70);
			request.setAttribute("kyouka", "国語");
			request.getRequestDispatcher("jstl2.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
