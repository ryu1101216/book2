package chapter20;

import java.io.IOException;

import bean.Horse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter20/horse_name"})
public class Horse_Name extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		Horse h = new Horse();

		request.setAttribute("horses", h);
		request.getRequestDispatcher("horse_name.jsp")
			.forward(request, response);
	}
}
