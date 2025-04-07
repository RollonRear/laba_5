package common;

public class Request {
	public String command;
	public Object arg;
	public MusicBand band;
	
	public Request (String command){
		this.command = command;
	}
	public void setArgs(Object arg) {
		this.arg = arg;
	}
	public void setBand(MusicBand band) {
		this.band = band;
	}
}
