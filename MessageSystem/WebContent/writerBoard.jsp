<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assetsBoard/css/main.css" />
<link rel="stylesheet" href="assetsBoard/css/board.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body>

   <div id="board">
   <!-- post방식으로 데이터를 보낼 때 content type
   1. 기본값 application/x-www-form-urlencoded-> key = value 
   2. text : text/plain
   3. 파일 전송 시 :  multipart/form-data -->
      <form action="WriteBoardService.do" method="post" enctype = "multipart/form-data">
         <table id="list">
            <tr>
               <td>제목</td>
               <td><input type="text" name="title"></td>
            </tr>
            <tr>
               <td>작성자</td>
               <td><input type="text" name="writer"></td>
            </tr>
            <tr>
               <td colspan="2">내용</td>
            </tr>
            <tr>
               <td colspan="2">
               <input name="fileName" type="file" style="float: right;"> 
                  <textarea name="content" rows="10" style="resize: none;"></textarea></td>
            </tr>
            <tr>
               <td colspan="2"><input type="reset" value="초기화"> <input
                  type="submit" value="작성하기"></td>
            </tr>
         </table>
      </form>
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