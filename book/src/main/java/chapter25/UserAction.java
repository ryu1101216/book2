package chapter25;

import java.util.List;

import bean.Customer;
import dao.CustomerDAO2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class UserAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String keyword=request.getParameter("keyword");

		CustomerDAO2 dao=new CustomerDAO2();
		List<Customer> list=dao.search(keyword);

		session.setAttribute("list", list);

		return "user.jsp";
	}
}
