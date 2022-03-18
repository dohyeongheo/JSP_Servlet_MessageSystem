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
			// post ��� ���ڵ�
			request.setCharacterEncoding("UTF-8");

			// MultipartRequest ��ü�� �Ű����� ����
			// savePath : ������ ���� ���
			// ���� ���� ��ġ : webContent
			// getServletContext : ��û ���� ������ ����
			// getRealPath("ã�ư��� ���� ������ �����") : ������ ������
			//

			String savePath = request.getServletContext().getRealPath("./file");
			System.out.println(savePath);

			// maxsize : �̹����� ũ�� ����
			// 1mb = 1024kb = 1024*1024byte
			// 1kb = 1024byte

			int maxsize = 10 * 1024 * 1024;
			// 10mb

			// encoding : ���ڵ� ���
			String encoding = "utf-8";

			// filePolicy : ���� �̸� �ߺ�����
			// (���ϸ��� ��ĥ �� ���ڸ� �����ϰ� �ؼ� �ߺ������ϴ� ��ü)
			DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();

			MultipartRequest multi = new MultipartRequest(request, savePath, maxsize, encoding, filePolicy);
			// ������ ��������
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			// �����̸��� �ѱ��� ������ ���ڵ�
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
				System.out.println("���� ���ε� ����");
			} else {
				System.out.println("���Ͼ��ε� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardMain.jsp";

	}

}
