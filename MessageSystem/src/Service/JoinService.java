package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import inter.Command;

public class JoinService implements Command {

	// 1. Command 인터페이스 구현

	// 2. 인터페이스에 있는 execute() 메소드 오버라이딩
	// 자동완성 -> 편리함

	// 3. 페이지 이동 response ... 삭제
	// String nextpage = "이동할 주소"

	// 4. 메소드 return 값으로 nextpage

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 회원가입 기능

		System.out.println("[JoinServiceCon]");

		// 1. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 2. 데이터 받아오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);

		// 3. 데이터 DTO로 묶기
		MemberDTO dto = new MemberDTO(email, pw, tel, address);

		// 4. DB 연결할 DAO 호출
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);

		// 세션 선언
		HttpSession Session = request.getSession();

		String nextpage = "";
		
		// 5. 실행결과 확인
		if (cnt > 0) {
			System.out.println("회원가입이 성공하였습니다.");

			// email session으로 만들기!
			Session.setAttribute("email", email);
			// response.sendRedirect("join_success.jsp");
			nextpage = "join_success.jsp";

		} else {
			System.out.println("회원가입이 실패하였습니다.");
			// response.sendRedirect("goMain");
			nextpage = "goMain";
		}

		return nextpage;
		// 회원가입 기능 마지막 줄

	}
}
