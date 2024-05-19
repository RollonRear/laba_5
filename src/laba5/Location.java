package laba5;

public class Location {
    private double x;
    private Integer y; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 627, Поле может быть null
    Location(double x, int y, String name){
    	this.x = x;
    	this.y = y;
    	this.name = name;
    }
    public String toString() {
		String s = "";
		s = s + name + " (" + String.valueOf(x) + ", " + y.toString() + ")";
		return s;
	}
	public String toCSVFormat() {

		return x + "," + y.toString() + "," + name;
	}
}
