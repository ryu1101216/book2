package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;

public class CustomerDAO2 extends DAO {

	public List<Customer> search(String keyword) throws Exception {
		List<Customer> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		String sql;
		if (keyword == null) {
			sql = "select * from Customer";
			st=con.prepareStatement(sql);
		}
		else {
					
			try {
				int id = Integer.parseInt(keyword);
				sql = "select * from Customer where id = ?";
				st=con.prepareStatement(sql);
				st.setInt(1, id);
			} catch (Exception e) {
				sql = "select * from Customer where login like ? or password like ?";
				st=con.prepareStatement(sql);
				st.setString(1, "%" + keyword + "%");
				st.setString(2, "%" + keyword + "%");
			}
		}
		
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Customer p=new Customer();
			p.setId(rs.getInt("id"));
			p.setLogin(rs.getString("login"));
			p.setPassword(rs.getString("password"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public List<Customer> insert(Customer Customer) throws Exception {
		Connection con=getConnection();
		
		List<Customer> list=new ArrayList<>();

		PreparedStatement st=con.prepareStatement(
			"insert into Customer(login, password) values(?, ?)");
		st.setString(1, Customer.getLogin());
		st.setString(2, Customer.getPassword());
		int line=st.executeUpdate();
		
		String sql;
		sql = "select * from Customer";
		st=con.prepareStatement(sql);	
		
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Customer p=new Customer();
			p.setId(rs.getInt("id"));
			p.setLogin(rs.getString("login"));
			p.setPassword(rs.getString("password"));
			list.add(p);
		}	

		st.close();
		con.close();
		return list;
	}
	
	public int update(Customer Customer) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"update Customer set password = ? where login = ?");;
		st.setString(1, Customer.getLogin());
		st.setString(2, Customer.getPassword());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
	public List<Customer> delete(Customer Customer) throws Exception {
		Connection con=getConnection();
		
		List<Customer> list=new ArrayList<>();

		PreparedStatement st=con.prepareStatement(
			"delete from Customer where id = ?");
		st.setInt(1, Customer.getId());
		st.executeUpdate();
		
		String sql;
		sql = "select * from Customer";
		st=con.prepareStatement(sql);	
		
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Customer p=new Customer();
			p.setId(rs.getInt("id"));
			p.setLogin(rs.getString("login"));
			p.setPassword(rs.getString("password"));
			list.add(p);
		}	

		st.close();
		con.close();
		return list;
	}
	
}
