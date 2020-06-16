package board.action;

public class ActionForward {
     private boolean isRedirect=false;
     private String path = null;
	
     
     public boolean isRedirect() {  //boolean type 일경우 getter/setter 대신 is 가 들어감 효과는 똑같음.
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
