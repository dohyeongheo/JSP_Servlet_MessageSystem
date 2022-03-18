package Service;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.BoardDAO;
import Model.BoardDTO;
import inter.Command;

public class WriteBoardService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// post 방식 인코딩
			request.setCharacterEncoding("UTF-8");

			// MultipartRequest 객체의 매개변수 정리
			// savePath : 파일의 저장 경로
			// 서블릿 실행 위치 : webContent
			// getServletContext : 요청 들어온 서블릿의 정보
			// getRealPath("찾아가고 싶은 파일의 상대경로") : 서블릿의 절대경로
			//

			String savePath = request.getServletContext().getRealPath("./file");
			System.out.println(savePath);

			// maxsize : 이미지의 크기 지정
			// 1mb = 1024kb = 1024*1024byte
			// 1kb = 1024byte

			int maxsize = 10 * 1024 * 1024;
			// 10mb

			// encoding : 인코딩 방식
			String encoding = "utf-8";

			// filePolicy : 파일 이름 중복제거
			// (파일명이 겹칠 때 숫자를 증가하게 해서 중복제거하는 객체)
			DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();

			MultipartRequest multi = new MultipartRequest(request, savePath, maxsize, encoding, filePolicy);
			// 데이터 꺼내오기
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			// 파일이름에 한글이 있으면 인코딩
			String fileName = URLEncoder.encode(multi.getFilesystemName("fileName"), "utf-8");
			// String fileName = multi.getFilesystemName("fileName");
			String content = multi.getParameter("content");

			System.out.println("title : " + title);
			System.out.println("writer : " + writer);
			System.out.println("fileName : " + fileName);
			System.out.println("content : " + content);

			BoardDTO dto = new BoardDTO(0, title, writer, fileName, content, "");
			int cnt = new BoardDAO().insertBoard(dto);

			if (cnt > 0) {
				System.out.println("파일 업로드 성공");
			} else {
				System.out.println("파일업로드 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardMain.jsp";

	}

}
