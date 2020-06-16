package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardBean;
import board.db.BoardDao;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardDao bdao= new BoardDao();
		ActionForward forward = new ActionForward();
		BoardBean board = new BoardBean();
	    int num=Integer.parseInt(request.getParameter("bno"));    
    board	= bdao.getContentBoard(num);
	
	forward.setRedirect(false);
	forward.setPath("mvc/mvc_modify.jsp");
	return forward;
		
		
		
		
	}

}
