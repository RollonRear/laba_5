package laba5.checkers;

public abstract class Checker {
	protected String error;
	public abstract boolean check(Object object) ;
	public abstract String getReq() ;
	public String getError() {
		return error;
	}
}
