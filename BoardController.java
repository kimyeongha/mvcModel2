package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardController() {
        super();
 
    }
    protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	 String RequestURI= request.getRequestURI();    ///kyh_dy(프로젝트명)/BoardList.bo(내가 실행할것)
    	 String contextPath = request.getContextPath();    // /kyh_dy 6자리
    	 String command= RequestURI.substring(contextPath.length());  //6자리 자름
    	 ActionForward  forward=null;
    	  Action action= null;
    	
    	 
    	if(command.equals("/BoardWrite.bo")) {  // 글쓰기 화면(form)이동 -mvc_write,jsp (insert항목을 먼저 입력하고  다음 action으로 이동)
    		 // action = new BoardAddAction(); //db연결할떄 필요한데 우리는 그냥 단순 화면만 하니까 이거 필요없음
    		  try {
    			  forward = new ActionForward();
    			  forward.setRedirect(true);
    			  forward.setPath("mvc/mvc_write.jsp");
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }	
    	
    	}
    	if(command.equals("/BoardContent.bo")) { //a 태그로 보내도 ? 뒤는 안들어온다.
    		  action = new BoardContentAction();
    		try {
    			  forward = action.execute(request, response); // forward로 보냇으니까 아직 num값 보내놧다.
    			 
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }	
    	}   
    	if(command.equals("/BoardModify.bo")) { // content 처럼 select 함하고.
  		  action = new BoardModifyAction();
  		try {
  			  forward = action.execute(request, response); // forward로 보냇으니까 아직 num값 보내놧다.
  			 
  		  }catch(Exception e) {
  			  e.printStackTrace();
  		  }	
  	
  	}
     	if(command.equals("/BoardModifyActionC.bo")) { // content 처럼 select 함하고.
    		  action = new BoardModifyActionC();
    		try {
    			  forward = action.execute(request, response); // forward로 보냇으니까 아직 num값 보내놧다.
    			 
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }	
    	
    	}	  
    	  
    	  if(command.equals("/BoardAddAction.bo")) {    //글쓰기 Action 실행
    		  action = new BoardAddAction();
    		  try {
    			  forward = action.execute(request, response);
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }
    	  }else if(command.equals("/BoardList.bo")){
    		  action = new BoardListAction();
    		  try {
    			  forward = action.execute(request, response);
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }
    	  }else if(command.equals("/BoardDelete.bo")) {  //글삭제에서 화면 안만들생각. 바로 글삭제 db 처리
    		    action = new BoardDeleteAction();
    		    try {
      			  forward = action.execute(request, response);
      		  }catch(Exception e) {
      			  e.printStackTrace();
      		  }
    	  }
    		  
    	  
    	  if(forward !=null) {   //이것떄문에 foward return 할떄 아 null아니구나 그러면 여기서 보고 보낸다.
    		  if(forward.isRedirect()) {
    			  response.sendRedirect( forward.getPath());
    		  }else {
    			  RequestDispatcher dispatcher=
    					  request.getRequestDispatcher(forward.getPath());
    			    dispatcher.forward(request, response);
    		  }
    	  }
    	  
    	 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doProcess(request,response);
		
	}

}
