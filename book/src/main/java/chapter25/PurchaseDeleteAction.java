package chapter25;

import java.util.List;

import bean.Purchase;
import dao.PurchaseDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PurchaseDeleteAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isBlank()) {
			int id = Integer.parseInt(idParam);
			PurchaseDAO dao = new PurchaseDAO();
			dao.delete(id);
		}
		
		
		PurchaseDAO dao = new PurchaseDAO();
		List<Purchase> list;

		list = dao.search(null,null,null);

		session.setAttribute("list", list);
		return "purchaseList.jsp";
		
		
	}
}
