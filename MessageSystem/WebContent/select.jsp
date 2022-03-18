<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Model.MemberDTO"%>
<%@page import="Model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1.request영역에 저장된 정보를 가져오시오. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->

</head>
<style>
</style>
<body style="text-align: center;">
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Menu -->
		<nav id="Update">
		<table>
			<caption>
				<h2>회원관리페이지</h2>
			</caption>
			<tr>
				<td>Email</td>
				<td>Tel</td>
				<td>Address</td>
				<td>Delete</td>
			</tr>
			<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->


			<%
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			MemberDAO dao = new MemberDAO();

			// DB 연결

			// SQL문 준비 및 실행
			conn = dao.dbconn();
			try {
				String Sql = "select * from web_member2";
				psmt = conn.prepareStatement(Sql);
				rs = psmt.executeQuery();

				while (rs.next()) {
					String email = rs.getString(1);
					String tel = rs.getString(3);
					String address = rs.getString(4);

			// 반복문 안에서 RS 객체의 요소들을 TR 태그에 넣기
					out.print("<tr>");
					out.print("<td>" + email + "</td>");
					out.print("<td>" + tel + "</td>");
					out.print("<td>" + address + "</td>");
					String enEmail = URLEncoder.encode("email","UTF-8");
					out.print("<td><a href='DeleteServiceCon.do?email="+ email + "'> 삭제 </a> </td>");
					out.print("</tr>");
				}


			} catch (Exception e) {
				e.printStackTrace();
			// DB 연결 종료
			} finally {
				dao.dbclose();
			}


			//
			%>

		</table>
		</nav>
		<a href="goMain" class="button next scrolly">되돌아가기</a>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>

