package chapter25;

import java.util.List;

import bean.Customer;
import dao.CustomerDAO2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class UserRemoveAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		int id= Integer.parseInt(request.getParameter("id"));

		Customer customer = new Customer();
		customer.setId(id);
		
		CustomerDAO2 dao=new CustomerDAO2();
		List<Customer> list=dao.delete(customer);

		session.setAttribute("list", list);

		return "user.jsp";
	}
}
