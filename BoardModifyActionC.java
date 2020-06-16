package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardBean;
import board.db.BoardDao;

public class BoardModifyActionC implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); 
		
		  
		
		BoardDao bdao= new BoardDao();
		ActionForward forward = new ActionForward();
		BoardBean board = new BoardBean();

	board.setSubject(request.getParameter("subject"));
	board.setContent(request.getParameter("content"));
	board.setBno(Integer.parseInt(request.getParameter("bno").trim()));
	 bdao.boardUpdate(board);
	forward.setRedirect(false);
	forward.setPath("BoardList.bo");
	return forward;
		
		
		
		
	}

}
