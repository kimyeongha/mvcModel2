<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import=" board.db.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
      int num=Integer.parseInt(request.getParameter("bno"));    
         System.out.println(num);
         BoardDao bdao = new BoardDao();
        BoardBean board = new BoardBean();
 	
      
        board = bdao.getContentBoard(num);
        System.out.println(board);

%>
  <h1>글수정입니다.</h1>
<form action="BoardModifyActionC.bo" method="post">
<table border="1">
        <tr>
        <td>글번호</td><td><input type="text"  name="bno" value=" <%= num%>"  readonly></td>  <td>제목</td><td><input type="text"  name="subject"value="<%=board.getSubject()%>"></td>
        </tr>
           <tr>
              <td>작성일자</td><td><input type="text"  name ="reg_date" value=" <%=board.getReg_date()%>"  readonly></td><td>작성자</td><td><input type="text"  name="writer"value=" <%=board.getWriter()%>"  ></td>
        </tr>
           <tr>
          <td>내용</td><td><textarea name="content"><%=board.getContent() %></textarea></td>
        </tr>
       <tr>
           <td colspan="4"><input type="submit" value="글수정"></td>
       </tr>
  
  </table>
</form>
</body>
</html>