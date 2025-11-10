package chapter25;

import bean.Customer;
import dao.CustomerDAO;
import tool.Action;
import jakarta.servlet.http.*;

public class UserUpdateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String id = request.getParameter("id");
		
		if (id != null && !id.isEmpty()) {
			CustomerDAO dao = new CustomerDAO();
			Customer customer = dao.findById(Integer.parseInt(id));
			request.setAttribute("customer", customer);
		}
		
		return "userUpdate.jsp";
	}
}
