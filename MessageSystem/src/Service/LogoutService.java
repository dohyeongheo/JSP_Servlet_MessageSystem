package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inter.Command;

public class LogoutService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[LogoutServiceCon]");
		request.setCharacterEncoding("utf-8");
		// 로그아웃 -> 로그인 한 정보 삭제
		HttpSession session = request.getSession();

		// 1. 세션 삭제 -> 세션 종료
		// session.invalidate();

		// 2. 세션 삭제 -> 특정 세션 삭제
		session.removeAttribute("info");
		

		System.out.println("로그아웃 성공");
		
		String nextpage = "goMain";
		return nextpage;

	}

}
