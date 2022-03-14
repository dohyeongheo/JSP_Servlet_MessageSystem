package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/LogoutServiceCon")
public class LogoutServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[LogoutServiceCon]");
		
		// 로그아웃 -> 로그인 한 정보 삭제
		HttpSession session = request.getSession();
		
		// 1. 세션 삭제 -> 세션 종료
		// session.invalidate();
		
		// 2. 세션 삭제 -> 특정 세션 삭제
		session.removeAttribute("info");
		
		System.out.println("로그아웃 성공");
		response.sendRedirect("main.jsp");
		
		
	}

}
