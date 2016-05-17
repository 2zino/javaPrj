package net.answeris.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.answeris.web.model.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public List<Notice> getList(int page, String field, String query) {

		int pageSize = 10;
		int start = pageSize * (page - 1) + 1;
		int end = pageSize * page;
		// LIKE '%ABC%'

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "select * from(select rownum NUM,  NOTICE_VIEW. * from NOTICE_view " + "where " + field
				+ " like ?)where num between ? and ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, start);
			st.setInt(3, end);

			ResultSet rs = st.executeQuery();

			List<Notice> list = new ArrayList<>();
			while (rs.next()) { // 서버에서 레코드 하나 가져옴
				Notice n = new Notice();
				n.setCmtCnt(rs.getString("CMT_CNT"));
				n.setWriterName(rs.getString("WRITER_NAME"));
				n.setCode(rs.getString("CODE"));
				n.setTitle(rs.getString("TITLE"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setWriter(rs.getString("WRITER"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));

				list.add(n);
			}

			rs.close();
			st.close();
			con.close();
			return list;
		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub

		return getList(page, "TITLE", "");

	}

	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public Notice get(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getNext(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getPrev(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

}
