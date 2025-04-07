package commands;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import common.MusicBand;
import common.Response;

public class Save extends AbstractCommand {
	public String filePath;
	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		Response response = new Response();
		try (FileOutputStream file = new FileOutputStream(filePath)) {
            for (MusicBand daBand : collection) {
                String line = daBand.toCSV() + "\n";
                file.write(line.getBytes(StandardCharsets.UTF_8));
            }
            response.setMassage("Коллекция успешно сохранена");
        } catch (IOException e) {
        	response.setMassage("Возникла ошибка");
		}
		return response;
	}

}
