package localcommands;

import java.io.IOException;

import common.Color;
import common.Coordinates;
import common.Location;
import common.MusicBand;
import common.MusicGenre;
import common.Person;
import laba5.Writable;

public class Filler {
	MusicBand getBand(Writable writer){
		MusicBand band;
		String name; 
		Coordinates cords;
		double cordx, cordy;
		Integer numberOfParticipants;
		MusicGenre genre;
		Person frontMan;
		String frontName;
		float height;
		String passportID;
		Color eyeColor;
		Location location;
		double locx, locy;
		String nameLoc;
		while (true) {
			name = writer.getLine("Введите название группы: ");
			if (name.length() != 0) {
				break;
			} else {
				System.out.println("Имя не может быть пустым");
			}
		}
		while (true) {
			String str = writer.getLine("Введите координаты группы по x: ");
			if (str.length() == 0) {
				cordx = 0;
				break;
			} else {
				try {
					cordx = Double.parseDouble(str);
					break;
				} catch(NumberFormatException e) {
					System.out.println("Это должно быть число");
				}
			} 
			
		}
		while (true) {
			String str = writer.getLine("Введите координаты группы по y: ");
			if (str.length() == 0) {
				cordy = 0;
				break;
			} else {
				try {
					cordy = Double.parseDouble(str);
					if (cordy > -200)
						break;
					else
						System.out.println("Значение должно быть больше -200");
				} catch(NumberFormatException e) {
					System.out.println("Это должно быть число");
				}
			} 
		}
		while (true) {
			String str = writer.getLine("Сколько людей в группе: ");
			try {
				numberOfParticipants = Integer.parseInt(str);
				if (numberOfParticipants > 0)
					break;
				else
					System.out.println("Значение должно быть больше 0");
			} catch(NumberFormatException e) {
				System.out.println("Это должно быть натуральное число");
			}
		
		}
		while (true) {
			try {
				String str = writer.getLine("Жанр: ");
	            genre = MusicGenre.valueOf(str);
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Нет такого жанра!");
	        }
		}
		while (true) {
			frontName = writer.getLine("Введите имя солиста: ");
			if (frontName.length() != 0) {
				break;
			} else {
				System.out.println("Имя не может быть пустым");
			}
		}
		while (true) {
			String str = writer.getLine("Введите рост солиста: ");
			try {
				height = Float.parseFloat(str);
				if (height > 0)
					break;
				else
					System.out.println("Значение должно быть больше 0");
			} catch(NumberFormatException e) {
				System.out.println("Это должно быть число");
			}
		
		}
		while (true) {
			passportID = writer.getLine("Введите паспорт солиста: ");
			if (passportID.length() >= 7) {
				break;
			} else {
				System.out.println("Длина ID должна быть не менее 7");
			}
		}
		while (true) {
			try {
				String str = writer.getLine("Цвет глаз: ");
				eyeColor = Color.valueOf(str);
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Нет такого цвета!");
	        }
		}
		while (true) {
			String str = writer.getLine("Введите координаты солиста по x: ");
			if (str.length() == 0) {
				locx = 0;
				break;
			} else {
				try {
					locx = Double.parseDouble(str);
					break;
				} catch(NumberFormatException e) {
					System.out.println("Это должно быть число");
				}
			} 
			
		}
		while (true) {
			String str = writer.getLine("Введите координаты солиста по y: ");
			if (str.length() == 0) {
				locy = 0;
				break;
			} else {
				try {
					locy = Double.parseDouble(str);
					break;
				} catch(NumberFormatException e) {
					System.out.println("Это должно быть число");
				}
			} 
			
		}
		while (true) {
			nameLoc = writer.getLine("Введите название места: ");
			if (nameLoc.length() != 0) {
				break;
			} else {
				System.out.println("Имя не может быть пустым");
			}
		}
		
		cords = new Coordinates(cordx, cordy);
		location = new Location(locx, locy, nameLoc);
		frontMan = new Person(frontName, height, passportID, eyeColor, location);
		band = new MusicBand(name, cords, numberOfParticipants, genre, frontMan);
		
		return band;
	}
}
