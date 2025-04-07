package common;

public class Location {
	private Double x; //Поле не может быть null
	private double y;
	private String name; //Поле не может быть null
	public Location(Double x, double y, String name){
		this.x = x;
		this.y = y;
		this.name = name;
	}
	@Override
    public String toString() {
		return "(" + x + ", " + y + ", " + name + ")";
    }
	public String toCSV() {
		return x + ";" + y + ";" + name;
	}
}
