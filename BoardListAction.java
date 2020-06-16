package board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.db.BoardDao;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception { // 항상 Boardbao랑 forwoard는 글을쓰던 리스트를 하던 전부 사용하니까 action 이라는 interface 만들어서 그거 상속하게함01
		System.out.println("aaaaa");
		List boardlist = new ArrayList();
		BoardDao bdao= new BoardDao();
		ActionForward forward = new ActionForward();
            boardlist = bdao.getBoardList();
          
            request.setAttribute("boardlist", boardlist);
            forward.setRedirect(false);  //sendRidirect 가 false를 안하겠다는 -> forward 방식으로 으로 화면 이동하겠다.  
            forward.setPath("mvc/mvc_list.jsp");  //이게 셀렉트 된 결과를 forward 형식으로 가져감.  mvc_list로
            return forward;
            
		
	}

}
