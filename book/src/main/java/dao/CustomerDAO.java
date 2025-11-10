package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO {
	public Customer search(String login, String password)
			throws Exception {
		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return customer;
	}

	public java.util.List<Customer> getAll()
			throws Exception {
		java.util.List<Customer> list = new java.util.ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer order by id");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
			list.add(customer);
		}

		st.close();
		con.close();
		return list;
	}

	public java.util.List<Customer> searchByKeyword(String keyword)
			throws Exception {
		java.util.List<Customer> list = new java.util.ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer where login like ? order by id");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
			list.add(customer);
		}

		st.close();
		con.close();
		return list;
	}

	public int delete(int id)
			throws Exception {
		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"delete from customer where id=?");
		st.setInt(1, id);
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

	public int insert(String login, String password)
			throws Exception {
		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"insert into customer(login, password) values(?, ?)");
		st.setString(1, login);
		st.setString(2, password);
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

	public Customer findById(int id)
			throws Exception {
		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer where id=?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return customer;
	}

	public int update(int id, String login, String password)
			throws Exception {
		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"update customer set login=?, password=? where id=?");
		st.setString(1, login);
		st.setString(2, password);
		st.setInt(3, id);
		int result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

}
