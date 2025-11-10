package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.STUDENTS;


public class STUDENTSDAO extends DAO {

	public List<STUDENTS> search(String keyword) throws Exception {
		List<STUDENTS> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from STUDENTS where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			STUDENTS p=new STUDENTS();
			
			p.setAge(rs.getInt("AGE"));
			p.setStudent_id(rs.getInt("STUDENT_ID"));
			p.setClassName(rs.getString("CLASSNAME"));
			p.setName(rs.getString("NAME"));

			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
	
//	public List<Product> search(String keyword,int PRICE) throws Exception {
//		List<Product> list=new ArrayList<>();
//
//		Connection con=getConnection();
//
//		PreparedStatement st=con.prepareStatement(
//			"select * from product where name like ? and PRICE = ?");
//		st.setString(1, "%"+keyword+"%");
//		st.setInt(2, PRICE);
//
//		ResultSet rs=st.executeQuery();
//
//		while (rs.next()) {
//			Product p=new Product();
//			p.setId(rs.getInt("id"));
//			p.setName(rs.getString("name"));
//			p.setPrice(rs.getInt("price"));
//			list.add(p);
//		}
//
//		st.close();
//		con.close();
//
//		return list;
//	}
//
//	public int insert(Product product) throws Exception {
//		Connection con=getConnection();
//
//		PreparedStatement st=con.prepareStatement(
//			"insert into product(name, price) values(?, ?)");
//		st.setString(1, product.getName());
//		st.setInt(2, product.getPrice());
//		int line=st.executeUpdate();
//
//		st.close();
//		con.close();
//		return line;
//	}
}
