package server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

import common.MusicBand;

public class BandFileReader {
	public HashSet<MusicBand> readBandsFromFile(String filePath){
        HashSet<MusicBand> bands = new HashSet<>();
        Parser parser = new Parser();
        try (InputStreamReader streamReader = new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
        	
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                	line = line.replace("\uFEFF", "");
                    String[] lines = line.split(";");
                    MusicBand band = parser.getBand(lines);
                    bands.add(band);
                } catch (Exception e) {
                	System.out.println("Ошибка при чтении файла");
                }
            }
        } catch (IOException e) {
			System.out.println("Ошибка при открытии файла");
		}
        return bands;
    }
}
