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


		// �������� ���

		System.out.println("[UpdateSeriveCon]");

		// post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");

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

		if (cnt > 0) {
			System.out.println("ȸ������ ���� ����");
			HttpSession session = request.getSession();
			session.setAttribute("info", dto);
			
 			// response.sendRedirect("goMain");

			// ������ session�� ���ο� ������ update
		} else {
			System.out.println("ȸ������ ���� ����");
		}

		String nextpage = "goMain";
		return nextpage;		
		// ȸ���������� ��� ������ ��

	}

}
