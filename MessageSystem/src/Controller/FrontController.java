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

//.do�� ������ ���ڿ� ���ΰ��� �� ���Խ�Ŵ

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// FrontController Pattern
		// 1. ��� ��û�� �ϳ��� servlet���� �����ϴ� ����
		// 2. �ߺ��Ǵ� �ڵ带 ���� �� �ְ�, ������ ������ �� �ϳ��� servlet���� ������ �� �ִ�.
		// 3.

		System.out.println("[FrontController]");
		String nextpage = "";
		Command com = null;

		// � ����� �����ϴ� ���ڿ����� �Ǵ�
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		System.out.println(path);

		// URI�� ����
		String command = uri.substring(path.length() + 1);
		System.out.println(command);

		// ������ü�� �ҷ��� �ʿ� ����
		// �θ�Ŭ������ ������ �ִ� �޼ҵ带
		// ���� Ŭ������ ������ (�������̵�)

		if (command.equals("LoginServiceCon.do")) {
			// �α��� ���
			com = new LoginService();
			nextpage = com.execute(request, response);

		} else if (command.equals("JoinServiceCon.do")) {
			// ȸ������ ���
			com = new JoinService();
			nextpage = com.execute(request, response);

		} else if (command.equals("LogoutServiceCon.do")) {
			// �α׾ƿ� ���
			com = new LogoutService();
			nextpage = com.execute(request, response);

		} else if (command.equals("idcheckServiceCon.do")) {
			// ���̵� �ߺ�üũ ���
			com = new idcheckService();
			nextpage = com.execute(request, response);
			
		if(nextpage != null) {
			response.sendRedirect(nextpage);
		}

		} else if (command.equals("UpdateServiceCon.do")) {
			// ȸ���������� ���
			com = new UpdateService();
			nextpage = com.execute(request, response);

		} else if (command.equals("DeleteServiceCon.do")) {
			// ȸ������ ���
			com = new DeleteService();
			nextpage = com.execute(request, response);

		} else if (command.equals("MsgCon.do")) {
			// �޽��� ���
			com = new MsgService();
			nextpage = com.execute(request, response);

		} else if (command.equals("WriteBoardService.do")) {
			// �Խñ� �ۼ� ���
			 com = new WriteBoardService();
			 nextpage = com.execute(request, response);
			
		}
		
		if (nextpage != null) {
			response.sendRedirect(nextpage);
		}
		// else if ������ ��

		// ������ �̵�
	}

}
