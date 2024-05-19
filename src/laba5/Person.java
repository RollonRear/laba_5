package laba5;

import java.text.SimpleDateFormat;

public class Person implements Comparable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private Double weight; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Location location; //Поле не может быть null
    Person(String id, String name, String x, String y, java.util.Date date, String height, String weight, String passport, String color, String xL, String yL, String location){
    	this.id = Integer.valueOf(id);
    	this.name = name;
    	this.coordinates = new Coordinates(Integer.valueOf(x), Integer.valueOf(y)); 
    	this.creationDate = date;
    	this.height = Double.valueOf(height); 
    	this.weight = Double.valueOf(weight); 
    	this.passportID = passport; 
    	this.hairColor = Color.valueOf(color); 
    	this.location = new Location(Double.valueOf(xL),Integer.valueOf(yL), location);
    }
	public int getId() {
		return id;
	}
	public Color getColor() {
		return hairColor;
	}
	@Override
	public String toString() {
		String s = "";
		s = s + "*****" + "\n";
		s = s + "ID: " + id.toString()  + "\n";
		s = s + "name: " + name + "\n";
		s = s + "coordinates: " + coordinates.toString() + "\n";
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		s = s + "creationDate: " + df.format(creationDate) + "\n";
		s = s + "height: " + String.valueOf(height) + "\n";
		s = s + "weight: " + weight.toString() + "\n";
		s = s + "passportID: " + passportID + "\n";
		s = s + "hairColor: " + hairColor.toString() + "\n";
		s = s + "location: " + location.toString() + "\n";
		s = s + "*****";
		return s;
	}
	public String getPassport() {
		return passportID;
	}
	@Override
	public int compareTo(Object o) {
		if(hashCode() > o.hashCode()) {
			return 1;
		} else if(hashCode() < o.hashCode()) {
			return -1;
		}else return 0;
	}
	@Override
	public int hashCode() {
		return (int)(height*weight);
		
	}
	public void replace(Person person) {
		this.name = person.name;
		this.coordinates = person.coordinates;
		this.creationDate = person.creationDate;
		this.height = person.height;
		this.weight = person.weight;
		this.passportID = person.passportID;
		this.hairColor = person.hairColor;
		this.location = person.location;
	}
	public String toCSVFormat() {
		String s = id.toString();
		s = s + ";" + name;
		s = s + ";" + coordinates.toCSVFormat();
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		s = s + ";" + df.format(creationDate);
		s = s + ";" + height;
		s = s + ";" + weight;
		s = s + ";" + passportID;
		s = s + ";" + hairColor;
		s = s + ";" + location.toCSVFormat();
		return s;
	}
}








