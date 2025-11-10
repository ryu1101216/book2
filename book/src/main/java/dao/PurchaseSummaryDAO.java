package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Purchase_Summary;

public class PurchaseSummaryDAO extends DAO {

	public List<Purchase_Summary> search(String keyword) throws Exception {
		
		List<Purchase_Summary> list=new ArrayList<>();
		
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from purchase_summary where customer_name = ?");
		st.setString(1, keyword);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Purchase_Summary p=new Purchase_Summary();
			p.setProduct_id(rs.getInt("product_id"));
			p.setProduct_name(rs.getString("product_name"));
			p.setCount(rs.getInt("count"));
			p.setUnit_price(rs.getInt("unit_price"));
			p.setTotal_price(rs.getInt("total_price"));
			p.setCustomer_name(rs.getString("customer_name"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
	
}
