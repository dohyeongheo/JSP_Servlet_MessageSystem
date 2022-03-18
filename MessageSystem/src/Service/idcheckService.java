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

		// 아이디 중복체크 버튼을 눌렀을 때 ajax로 보낸 email 값 받아오기
		String email = request.getParameter("email");
		System.out.println("email : " + email);

		// 아이디 중복체크 메소드 호출하기
		boolean result = new MemberDAO().idCheck(email);

		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();

		// 아이디 중복체크 기능 마지막 줄

		String nextpage = "goMain";

		return null;
	}
}
