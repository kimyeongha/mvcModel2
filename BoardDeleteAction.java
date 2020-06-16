package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardBean;
import board.db.BoardDao;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		                 BoardDao bdao = new BoardDao();
		                 BoardBean board = new BoardBean();
		             	ActionForward forward = new ActionForward();
		            request.setCharacterEncoding("utf-8");  //form tag일때 post방식일때 깨져서 오는데 encoding 시킨다.
		            response.setContentType("text/html; charset=UTF-8"); //server에서 client 로 reponse 할때 (.java ->jsp )일떄 .jsp contentType 으로 셋팅해서 가라.
		               //위에 꺼 안하면 메세지창에 ???라고 뜸.
		             	
		             	int num =Integer.parseInt(request.getParameter("bno"));
		             
		              
		                 int result= bdao.boardDelete(num);
		                 if(result>0) {  //delete가성공했으면 
		                	 PrintWriter out = response.getWriter();// java에서jsp로 데이터를 출력할때 Printwrite 클래스에서 getWriter()메소드를 사용했다.입출력을 담당하는 클래스
		                	 out.println("<script>");// 서버에서는구동안한다.  그래서 클라이언트쪽에 html 스크립트로 실행함.
		                	 out.println("alert('삭제되었습니다')");  // 내가 여기서 삭제가 완료됬어 근데 알림창을 띄우고 싶다 이거지 
		                	 out.println("location.href='BoardList.bo'");//그러면 자바스크립 문법을 써야겟네 이것을 넣자 
		                	 out.println("</script>");
		                 }
		                 //forward.setRedirect(true);
		                 //forward.setPath("BoardContentAction.bo?bno="+board.getBno());
		               //  forward.setRedirect(true);
		                 //forward.setPath("BoardList.bo");
		return  forward;
	}

}
