package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter3/hello2"})
public class Hello2 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
		// out.println("<meta charset=\"utf-8\">");
		// out.println("<title>Servlet/JSP Sample Programs>");
//		out.println("<style type=\"text/css\">");
//		out.println("p {font-size: 20px; color: red;}");
//		out.println("</style>");
//		out.println("</head>");
//		out.println("<body>");
//		out.print("<p>");
		out.print("ようこそ");
//		out.println("</p>");
//		out.print("<p>");
		out.print(new java.util.Date());
//		out.println("</p>");
//		out.println("</body>");
//		out.println("<html>");
	}
}
 