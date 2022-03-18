package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import inter.Command;

public class UpdateService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// 정보수정 기능

		System.out.println("[UpdateSeriveCon]");

		// post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 값 4개 받아오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);

		MemberDTO dto = new MemberDTO(email, pw, tel, address);
//		MemberDAO dao = new MemberDAO();
//		dao.update(dto);

//		int cnt = new MemberDAO().update(new MemberDTO(email, pw, tel, address));
		int cnt = new MemberDAO().update(dto);

		if (cnt > 0) {
			System.out.println("회원정보 수정 성공");
			HttpSession session = request.getSession();
			session.setAttribute("info", dto);
			
 			// response.sendRedirect("goMain");

			// 성공시 session에 새로운 정보로 update
		} else {
			System.out.println("회원정보 수정 실패");
		}

		String nextpage = "goMain";
		return nextpage;		
		// 회원정보수정 기능 마지막 줄

	}

}
