package board.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardBean;
import board.db.BoardDao;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		BoardDao bdao= new BoardDao();
		ActionForward forward = new ActionForward();
		BoardBean board = new BoardBean();
	    int num=Integer.parseInt(request.getParameter("bno"));    
    board	= bdao.getContentBoard(num);
	
	forward.setRedirect(false);
	forward.setPath("mvc/mvc_content.jsp");
	return forward;
	}
    
}
