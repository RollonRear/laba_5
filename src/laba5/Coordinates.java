package laba5;

public class Coordinates {
    private int x; //Значение поля должно быть больше -765
    private Integer y; //Поле не может быть null
    Coordinates(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    public String toString() {
		String s = "";
		s = s + "(" + String.valueOf(x) + ", " + y.toString() + ")";
		return s;
	}
	public String toCSVFormat() {
		return x + "," + y.toString();
	}
}
