package chapter25;

import java.util.List;

import bean.Customer;
import dao.CustomerDAO2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class InsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String login=request.getParameter("login");
		String password=request.getParameter("password");

		Customer customer = new Customer();
		customer.setLogin(login);
		customer.setPassword(password);
		
		CustomerDAO2 dao=new CustomerDAO2();
		List<Customer> list=dao.insert(customer);

		session.setAttribute("list", list);

		return "user.jsp";
	}
}
