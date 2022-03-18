package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import inter.Command;

public class DeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[DeleteServiceCon 立加]");
		request.setCharacterEncoding("utf-8");

		String Email = request.getParameter("email");

		MemberDAO dao = new MemberDAO();
		int cnt = dao.delete(Email);

		if (cnt > 0) {
			// response.sendRedirect("select.jsp");
			System.out.println("昏力 己傍");
		} else {
			// response.sendRedirect("select.jsp");
			System.out.println("昏力 角菩");
		}
		String nextpage = "select.jsp";
		return nextpage;
	}
}
