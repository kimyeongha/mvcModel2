package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardBean;
import board.db.BoardDao;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	     //DB연결 관련객체 
		  BoardDao bdao= new  BoardDao();  // 이안에 연결시켜주는 과정이 담겨 있음. 
		  BoardBean bdata = new BoardBean();  // 맴버변수의getter setter 에 여기 잇으므로 호출.
		  ActionForward forward = new ActionForward();
		
                request.setCharacterEncoding("utf-8");
             
		  bdata.setSubject( request.getParameter("subject"));  //제목 
		  bdata.setContent(request.getParameter("content"));  //작성자
		  bdata.setWriter(request.getParameter("writer"));  //내용
		   
		  bdao.boardInsert(bdata);
		  forward.setRedirect(true);
		// forward.setPath("mvc/mvc_list.jsp");  //그대로 가면 결과가 반영 안됨으로 
		  forward.setPath("BoardList.bo");  
		  
		
		return forward;
	}
   
}
