package chapter25;

import bean.Purchase;
import dao.PurchaseDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class PurchaseUpdateAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idParam = request.getParameter("id");
		
		if (idParam == null || idParam.isEmpty()) {
			return "purchase-error.jsp";
		}
		
		int id = Integer.parseInt(idParam);
		PurchaseDAO dao = new PurchaseDAO();
		
		if ("GET".equals(request.getMethod())) {
			Purchase purchase = dao.findById(id);
			if (purchase == null) {
				return "purchase-error.jsp";
			}
			request.setAttribute("purchase", purchase);
			return "purchase-update2.jsp";
		} else {
			Purchase purchase = new Purchase();
			purchase.setId(id);
			purchase.setProductId(Integer.parseInt(request.getParameter("productId")));
			purchase.setProductName(request.getParameter("productName"));
			purchase.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
			purchase.setProductCount(Integer.parseInt(request.getParameter("productCount")));
			purchase.setCustomerName(request.getParameter("customerName"));
			purchase.setCustomerAddress(request.getParameter("customerAddress"));
			
			int result = dao.update(purchase);
			if (result > 0) {
				return "purchase-update-success.jsp";
			} else {
				return "purchase-error.jsp";
			}
		}
	}
}