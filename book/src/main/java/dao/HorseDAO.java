package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Horse;
import bean.Race;
import bean.Result;

public class HorseDAO extends DAO {

	public List<Horse> horse_search(String keyword) throws Exception {
		List<Horse> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		String sql = "select * from horse_view where 馬名 like ?";
		st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		st.setString(1, "%" + keyword + "%");
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Horse h=new Horse();
			h.set馬名(rs.getString("馬名"));
			h.set誕生日(rs.getDate("誕生日"));
			h.set性別(rs.getString("性別"));
			h.set毛色(rs.getString("毛色"));
			
			list.add(h);
		}

		st.close();
		con.close();

		return list;
	}

	public List<Race> race_search(String keyword) throws Exception {
		List<Race> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		String sql;
		int distance;
		
		try {
			distance = Integer.parseInt(keyword);
			sql = "select * from race_view where 距離 = ?";
			st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setInt(1, distance);
		} catch (Exception e) {
			sql = "select * from race_view where レース名 like ? or 競馬場 like ? or グレード like ? or コース like ?";
			st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setString(1, "%" + keyword + "%");
			st.setString(2, "%" + keyword + "%");
			st.setString(3, "%" + keyword + "%");
			st.setString(4, "%" + keyword + "%");
		}
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Race r=new Race();
			r.setレース名(rs.getString("レース名"));
			r.setグレード(rs.getString("グレード"));
			r.set競馬場(rs.getString("競馬場"));
			r.setコース(rs.getString("コース"));
			r.set距離(rs.getInt("距離"));
			r.set条件(rs.getString("条件"));
			r.set現行(rs.getString("現行"));
			r.set創設年(rs.getInt("創設年"));
			list.add(r);
		}

		st.close();
		con.close();

		return list;
	}
	
	public List<Result> result_search(String keyword) throws Exception {
		List<Result> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		String sql;
		int distance;

		try {
			distance = Integer.parseInt(keyword);
			sql = "select * from result_view where 距離 = ?";
			st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setInt(1, distance);
		} catch (Exception e) {
			sql = "select * from result_view where 優勝馬 like ? or レース名 like ? or 競馬場 like ? or グレード like ? or コース like ?";
			st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setString(1, "%" + keyword + "%");
			st.setString(2, "%" + keyword + "%");
			st.setString(3, "%" + keyword + "%");
			st.setString(4, "%" + keyword + "%");
			st.setString(5, "%" + keyword + "%");
		}
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Result r=new Result();
			r.set回(rs.getString("回"));
			r.set開催日(rs.getDate("開催日"));
			r.setレース名(rs.getString("レース名"));
			r.setグレード(rs.getString("グレード"));
			r.set競馬場(rs.getString("競馬場"));
			r.setコース(rs.getString("コース"));
			r.set距離(rs.getInt("距離"));
			r.set条件(rs.getString("条件"));
			r.set優勝馬(rs.getString("優勝馬"));
			r.set誕生日(rs.getDate("誕生日"));
			r.set性別(rs.getString("性別"));
			r.set年齢(rs.getInt("年齢"));
			r.set毛色(rs.getString("毛色"));
			
			list.add(r);
		}

		st.close();
		con.close();

		return list;
	}
}
