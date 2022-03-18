package Model;

public class MessageDTO {

	// 필드명 선언할 때 테이블 컬럼명과 같아야 좋다
	
	private int num;
	private String send_name;
	private String receive_email;
	private String content;
	
	// 날짜 계산 안하기 때문에 String 타입 사용
	
	private String sendDate;
	
	public MessageDTO(int num, String send_name, String receive_email, String content, String sendDate) {
		this.num = num;
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
		this.sendDate = sendDate;
	}

	public MessageDTO(String send_name, String receive_email, String content) {
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getReceive_email() {
		return receive_email;
	}

	public void setReceive_email(String receive_email) {
		this.receive_email = receive_email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	
	
}
