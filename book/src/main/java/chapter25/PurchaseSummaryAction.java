package chapter25;

import java.util.List;

import bean.Customer;
import bean.Purchase_Summary;
import dao.PurchaseSummaryDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PurchaseSummaryAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();


		if (session.getAttribute("customer")==null) {
			return "purchase-error-login.jsp";
		}
		
		Customer customer = (Customer)session.getAttribute("customer");
		String cusomer_name = customer.getLogin();
		
		PurchaseSummaryDAO dao=new PurchaseSummaryDAO();
		List<Purchase_Summary> list=dao.search(cusomer_name);

		session.setAttribute("list", list);

		return "purchase-summary.jsp";
	}
}
