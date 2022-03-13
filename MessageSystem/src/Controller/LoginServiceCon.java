package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;

@WebServlet("/LoginServiceCon")
public class LoginServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[LoginServiceCon ����]");

		// 1. post ��� ���ڵ�
		request.setCharacterEncoding("euc-kr");

		// 2. eamil, pw �޾ƿ���
		String email = request.getParameter("loginemail");
		String pw = request.getParameter("pw");

		// 3. login �޼ҵ� ȣ��
		MemberDTO dto = new MemberDAO().login(email, pw);

		// 4. �������п���
		if (dto != null) {
			System.out.println("�α��� ����");
			System.out.println(dto.getEmail());
			HttpSession session = request.getSession();
			session.setAttribute("info", dto);
		} else {
			System.out.println("�α��� ����");
		}
		// 5. ������������ ���ư���		
		response.sendRedirect("main.jsp");

	}

}
