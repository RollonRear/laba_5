package common;

import java.time.format.DateTimeFormatter;

public class MusicBand implements Comparable<MusicBand> {
	private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
	private String name; //Поле не может быть null, Строка не может быть пустой
	private Coordinates coordinates; //Поле не может быть null
	private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
	private Integer numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
	private MusicGenre genre; //Поле не может быть null
	private Person frontMan; //Поле не может быть null
    public MusicBand (long id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Integer numberOfParticipants, MusicGenre genre, Person frontMan){
    	this.id = id;
    	this.name = name;
    	this.coordinates = coordinates;
    	this.creationDate = creationDate;
    	this.numberOfParticipants = numberOfParticipants;
    	this.genre = genre;
    	this.frontMan = frontMan;
    }
    public MusicBand (String name, Coordinates coordinates, Integer numberOfParticipants, MusicGenre genre, Person frontMan){
    	this.name = name;
    	this.coordinates = coordinates;
    	this.numberOfParticipants = numberOfParticipants;
    	this.genre = genre;
    	this.frontMan = frontMan;
    }
    public void setId(long id) {
    	this.id = id;
    }
    public void setDate(java.time.LocalDate creationDate) {
    	this.creationDate = creationDate;
    }
    @Override
    public String toString() {
    	String string;
    	string = "------------------------------" + "\n";
    	string = string + "ID: " + this.id + "\n";
    	string = string + "Название: " + this.name + "\n";
    	string = string + "Координаты: " + this.coordinates + "\n";
    	string = string + "Дата создания: " + this.creationDate + "\n";
    	string = string + "Количество участников: " + this.numberOfParticipants + "\n";
    	string = string + "Жанр: " + this.genre + "\n";
    	string = string + this.frontMan + "\n";
    	return string;
    }
    @Override
    public int hashCode() {
    	return super.hashCode();
    }
    public String toCSV() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	String date = creationDate.format(formatter);
    	return id + ";" + name + ";" + coordinates.toCSV() + ";" + date + ";" + numberOfParticipants + ";" + genre.toString() + ";" + frontMan.toCSV();
    }
    public long getId() {
    	return id;
    }
	@Override
	public int compareTo(MusicBand band) {
		return this.frontMan.compareTo(band.frontMan);
	}
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public Person getFrontMan() {
		return frontMan;
	}
}
