package server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import common.Color;
import common.Coordinates;
import common.Location;
import common.MusicBand;
import common.MusicGenre;
import common.Person;

public class Parser {
	public MusicBand getBand(String[] line) {
		
		long id = Long.parseLong(line[0]);
		String name = line[1];
		Coordinates cords = new Coordinates(Double.parseDouble(line[2]), Double.parseDouble(line[3]));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate date = LocalDate.parse(line[4], formatter);
		Integer numberOfParticipants = Integer.parseInt(line[5]);
		MusicGenre genre = MusicGenre.valueOf(line[6]);
		Location loc = new Location(Double.parseDouble(line[11]), Double.parseDouble(line[12]), line[13]);
		Person frontMan = new Person(line[7], Float.parseFloat(line[8]), line[9], Color.valueOf(line[10]), loc);
		
		MusicBand band = new MusicBand(id, name, cords, date, numberOfParticipants, genre, frontMan);
		
		return band;
	}
}
