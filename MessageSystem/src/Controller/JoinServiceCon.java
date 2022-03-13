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

@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[JoinServiceCon]");

		// 1. post��� ���ڵ�
		request.setCharacterEncoding("EUC-KR");

		// 2. ������ �޾ƿ���
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);

		// 3. ������ DTO�� ����
		MemberDTO dto = new MemberDTO(email, pw, tel, address);

		// 4. DB ������ DAO ȣ��
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);

		// ���� ����
		HttpSession Session = request.getSession();
		
		// 5. ������ Ȯ��
		if (cnt > 0) {
			System.out.println("ȸ�������� �����Ͽ����ϴ�.");
			
			// email session���� �����!
			Session.setAttribute("email", email);
			response.sendRedirect("join_success.jsp");
			
		} else {
			System.out.println("ȸ�������� �����Ͽ����ϴ�.");
			response.sendRedirect("main.jsp");
		}

	}

}
