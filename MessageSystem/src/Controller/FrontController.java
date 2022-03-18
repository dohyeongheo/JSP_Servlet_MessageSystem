package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.MessageDAO;
import Model.MessageDTO;
import Service.DeleteService;
import Service.JoinService;
import Service.LoginService;
import Service.LogoutService;
import Service.MsgService;
import Service.UpdateService;
import Service.WriteBoardService;
import Service.idcheckService;
import inter.Command;
import inter.idcheckCommand;

//.do로 끝나는 문자열 맵핑값을 다 포함시킴

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// FrontController Pattern
		// 1. 모든 요청을 하나의 servlet으로 정의하는 패턴
		// 2. 중복되는 코드를 줄일 수 있고, 보안을 적용할 때 하나의 servlet에서 적용할 수 있다.
		// 3.

		System.out.println("[FrontController]");
		String nextpage = "";
		Command com = null;

		// 어떤 기능을 수행하는 문자열인지 판단
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		System.out.println(path);

		// URI만 선택
		String command = uri.substring(path.length() + 1);
		System.out.println(command);

		// 여러객체를 불러올 필요 없이
		// 부모클래스가 가지고 있는 메소드를
		// 하위 클래스가 재정의 (오버라이딩)

		if (command.equals("LoginServiceCon.do")) {
			// 로그인 기능
			com = new LoginService();
			nextpage = com.execute(request, response);

		} else if (command.equals("JoinServiceCon.do")) {
			// 회원가입 기능
			com = new JoinService();
			nextpage = com.execute(request, response);

		} else if (command.equals("LogoutServiceCon.do")) {
			// 로그아웃 기능
			com = new LogoutService();
			nextpage = com.execute(request, response);

		} else if (command.equals("idcheckServiceCon.do")) {
			// 아이디 중복체크 기능
			com = new idcheckService();
			nextpage = com.execute(request, response);
			
		if(nextpage != null) {
			response.sendRedirect(nextpage);
		}

		} else if (command.equals("UpdateServiceCon.do")) {
			// 회원정보수정 기능
			com = new UpdateService();
			nextpage = com.execute(request, response);

		} else if (command.equals("DeleteServiceCon.do")) {
			// 회원삭제 기능
			com = new DeleteService();
			nextpage = com.execute(request, response);

		} else if (command.equals("MsgCon.do")) {
			// 메시지 기능
			com = new MsgService();
			nextpage = com.execute(request, response);

		} else if (command.equals("WriteBoardService.do")) {
			// 게시글 작성 기능
			 com = new WriteBoardService();
			 nextpage = com.execute(request, response);
			
		}
		
		if (nextpage != null) {
			response.sendRedirect(nextpage);
		}
		// else if 마지막 줄

		// 페이지 이동
	}

}
