<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import=" java.util.List" %>
      <%@ page  import=" board.db.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 list입니다.</title>
<%
   List<BoardBean> boardlist = (List) request.getAttribute("boardlist");

%>

</head>
<body>
  <form >
  <table border="1">
      <tr><td>번호</td><td>제목</td><td>작성자</td><td>작성일자</td></tr>   
   
         <%
           for(int i= 0; i<boardlist.size(); i++){
        	   BoardBean bl =(BoardBean)boardlist.get(i);
         
         %>
      <tr>
            <td><%= bl.getBno() %></td><td><a href="BoardContent.bo?bno=<%=bl.getBno() %>"><%= bl.getSubject() %></a></td>
            
            <td><%= bl.getWriter() %></td><td><%= bl.getReg_date() %></td>
          
            <%  } %>
            </tr>
  </table>
  <a href="BoardWrite.bo">글쓰기</a>
</form>
</body>
</html>