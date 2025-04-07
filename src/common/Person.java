package common;

public class Person implements Comparable<Person> {
	private String name; //Поле не может быть null, Строка не может быть пустой
	private float height; //Значение поля должно быть больше 0
	private String passportID; //Длина строки должна быть не меньше 7, Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
	private Color eyeColor; //Поле может быть null
	private Location location; //Поле может быть null
    public Person (String name, float height, String passportID, Color eyeColor, Location location){
    	this.name = name;
    	this.height = height;
    	this.passportID = passportID;
    	this.eyeColor = eyeColor;
    	this.location = location;
    }
    @Override
    public String toString() {
    	String string;
    	string = "Имя солиста: " + this.name + "\n";
    	string = string + "Рост солиста: " + this.height + "\n";
    	string = string + "Паспорт солиста: " + this.passportID + "\n";
    	string = string + "Цвет глаз солиста: " + this.eyeColor + "\n";
    	string = string + "Место нахождения солиста: " + this.location;
    	return string;
    }
	public String toCSV() {
		
		return name + ";" + height + ";" + passportID + ";" + eyeColor.toString() + ";" + location.toCSV();
	}
	@Override
	public int compareTo(Person person) {
		return (int) (this.height - person.height);
	}

}