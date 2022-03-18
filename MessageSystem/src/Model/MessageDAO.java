package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.e;

public class MessageDAO {

	// 전역변수 선언
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberDTO dto = null;
	MessageDTO msgdto = null;
	int cnt = 0;
	

	// DB연결 메소드
	public Connection dbconn() {

		// 1. DB연결(ojdbc.6.jar 넣어주기)
		// 1-1. Class 찾기 : DB와 이클립스를 연결해주는 Class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1-2. DB에 접속하기 위한 주소, 아이디, 패스워드 지정
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 1-3. Connection 객체 사용해서 DB연결!
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// DB연결종료 메소드
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
	
	// 메세지 보내는 메소드
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
		// 메시지 출력하는 메소드
		// List<E> -> ArrayList 상위 클래스
		// 더 포괄적인 변수를 사용할 수 있음
		// session 저장할 때 objec로 저장됨(object : 최상위 클래스)
	
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
