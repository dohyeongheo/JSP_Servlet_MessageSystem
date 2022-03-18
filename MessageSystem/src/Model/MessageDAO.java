package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.e;

public class MessageDAO {

	// �������� ����
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberDTO dto = null;
	MessageDTO msgdto = null;
	int cnt = 0;
	

	// DB���� �޼ҵ�
	public Connection dbconn() {

		// 1. DB����(ojdbc.6.jar �־��ֱ�)
		// 1-1. Class ã�� : DB�� ��Ŭ������ �������ִ� Class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1-2. DB�� �����ϱ� ���� �ּ�, ���̵�, �н����� ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 1-3. Connection ��ü ����ؼ� DB����!
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// DB�������� �޼ҵ�
	public void dbclose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �޼��� ������ �޼ҵ�
	public int sendMsg(MessageDTO dto) {
		dbconn();
		try {
		String sql = "insert into web_message values(msg_num_seq.nextval, ?, ?, ?, sysdate)";	
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, dto.getSend_name());
		psmt.setString(2, dto.getReceive_email());
		psmt.setString(3, dto.getContent());
		
		cnt = psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		} return cnt;
	}
	
	public List<MessageDTO> selectMsg(String email) {
		// �޽��� ����ϴ� �޼ҵ�
		// List<E> -> ArrayList ���� Ŭ����
		// �� �������� ������ ����� �� ����
		// session ������ �� objec�� �����(object : �ֻ��� Ŭ����)
	
		List<MessageDTO> msglist = new ArrayList<MessageDTO>();
		
		try {
			dbconn();
			String sql = "select * from web_message where receive_email = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			    int num = rs.getInt(1);
			    String send_name = rs.getString(2);
			    String receive_email = email;
			    String content = rs.getString(4);
			    String sendDate = rs.getString(5);
			    
			    msgdto = new MessageDTO(num, send_name, receive_email, content, sendDate);
			    
			    msglist.add(msgdto);
			    
			}
			
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		dbclose();
	} return msglist;
	
		
	}
	
	
	
}
