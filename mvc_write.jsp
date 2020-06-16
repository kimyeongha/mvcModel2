<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../BoardAddAction.bo" method="post">
<table>
   <tr>
      <td>제목</td>
      <td><input type="text" name="subject"></td>
   </tr>
     <tr>
      <td>내용</td>
      <td><textarea name="content"></textarea></td>
   </tr>
     <tr>
      <td>작성자 </td>
      <td><input type="text" name="writer"></td>
   </tr>
   <tr>
          <td colspan="2"><input type="submit" value="제출하기">
   </tr>
</table>
</form>
</body>
</html>