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

@WebServlet("/UpdateServiceCon")
public class UpdateServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[UpdateSeriveCon]");
		
		// post��� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		
	// �� 4�� �޾ƿ���
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
		
		if(cnt>0) {
			System.out.println("ȸ������ ���� ����");
			HttpSession session = request.getSession();
			session.setAttribute("info", dto);
			response.sendRedirect("main.jsp");
			
		
		// ������ session�� ���ο� ������ update
		} else {
			System.out.println("ȸ������ ���� ����");
		}
	}

}
