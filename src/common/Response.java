package common;

public class Response {
	public String massage;
	public MusicBand[] bands;
	public void setMassage (String massage){
		this.massage = massage;
	}
	public void setBands (MusicBand[] bands){
		this.bands = bands;
	}
}
