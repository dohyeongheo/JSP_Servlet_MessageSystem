package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MessageDAO;
import Model.MessageDTO;
import inter.Command;

public class MsgService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// �Ķ���� ����
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");

		// DTO ��ü ���� -> �Ű����� 3�� ���� �����ڷ� ȣ��
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		MessageDAO dao = new MessageDAO();
		int cnt = dao.sendMsg(dto);

		if (cnt > 0) {
			System.out.println("�޼��� ���� ����");
		} else {
			System.out.println("�޼��� ���� ����");
		}
		// response.sendRedirect("goMain");

		String nextpage = "goMain";
		return nextpage;

		// �޼��� ��� ������ ��

	}
}
