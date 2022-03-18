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
		// �α׾ƿ� -> �α��� �� ���� ����
		HttpSession session = request.getSession();

		// 1. ���� ���� -> ���� ����
		// session.invalidate();

		// 2. ���� ���� -> Ư�� ���� ����
		session.removeAttribute("info");
		

		System.out.println("�α׾ƿ� ����");
		
		String nextpage = "goMain";
		return nextpage;

	}

}
