package common;

public class Coordinates {
    private double x;
    private double y; //Значение поля должно быть больше -200
    public Coordinates(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    @Override
    public String toString() {
		return "(" + x + ", " + y + ")";
    }
	public String toCSV() {
		
		return x + ";" + y;
	}
}