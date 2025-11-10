package chapter25;

import dao.CustomerDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UserUpdateExecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		
		if (login != null && !login.isEmpty() && password != null && !password.isEmpty() && id != null && !id.isEmpty()) {
			CustomerDAO dao = new CustomerDAO();
			int result = dao.update(Integer.parseInt(id), login, password);
			
			if (result > 0) {
				return "userUpdate.jsp";
			}
		}
		
		return "userUpdate.jsp";
	}
}
