package laba5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Filler {
	private Data readFile(String filename){
		Data data = new Data();
		data.setFilename(filename);
		File starting = new File(System.getProperty("user.dir"));
		File file = new File(starting, filename);
		 
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8))
        {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                if(str == "") break;
                try {
                	data.add(create(str.split(";")));
                }catch(Exception e) {
                	System.out.println("Недопустимый формат файла");
                	System.exit(0);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return data;
	}
	
	private Person create(String[] str){
		Person person = null;
		try {
			String[] cords = str[2].split(",");
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			Date date = null;
			try{
				date = df.parse(str[3]);
			} catch(ParseException e){
				e.getMessage();
			}
			String[] loc;
			
			loc = str[8].split(",");
			person = new Person(str[0], str[1], cords[0], cords[1], date, str[4], str[5],str[6],str[7],loc[0], loc[1], loc[2]);
		}catch(Exception e) {
			System.out.println("Недопустимый формат файла");
			System.exit(0);
		}
		
		
		
		return person;
	}
	
	Data getData(String filename){
		Data data = readFile(filename);
		
		
		return data;	
	}
}
