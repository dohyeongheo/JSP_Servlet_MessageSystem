package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import inter.Command;
import inter.idcheckCommand;

public class idcheckService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[idcheckServiceCon]");
		request.setCharacterEncoding("utf-8");

		// ���̵� �ߺ�üũ ��ư�� ������ �� ajax�� ���� email �� �޾ƿ���
		String email = request.getParameter("email");
		System.out.println("email : " + email);

		// ���̵� �ߺ�üũ �޼ҵ� ȣ���ϱ�
		boolean result = new MemberDAO().idCheck(email);

		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();

		// ���̵� �ߺ�üũ ��� ������ ��

		String nextpage = "goMain";

		return null;
	}
}
