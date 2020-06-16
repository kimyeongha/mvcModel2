<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import=" board.db.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
      int num=Integer.parseInt(request.getParameter("bno"));    
         System.out.println(num);
         BoardDao bdao = new BoardDao();
        BoardBean board = new BoardBean();
 	
      
        board = bdao.getContentBoard(num);
        System.out.println(board);

%>

<body>

  <table border="1">
        <tr>
        <td>글번호</td><td><input type="text" value=" <%= num%>"  readonly></td>  <td>제목</td><td><input type="text" value="<%=board.getSubject()%>"></td>
        </tr>
           <tr>
              <td>작성일자</td><td><input type="text" value=" <%=board.getReg_date()%>"  readonly></td> <td>작성자</td><td><input type="text" value=" <%=board.getWriter()%>"  readonly></td>
        </tr>
           <tr>
          <td>내용</td><td><textarea readonly ><%=board.getContent()%></textarea></td>
        </tr>
       <tr>
           <td colspan="4"> <a href="BoardModify.bo?bno=<%= num%>">글수정</a><a href="BoardDelete.bo?bno=<%= num%>">글삭제</a><a href="BoardList.bo">글목록 </a></td>
       </tr>
  
  
  
  
  
  </table>

</body>
</html>