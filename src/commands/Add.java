package commands;

import java.time.LocalDate;
import java.util.Collection;
import java.util.OptionalLong;

import common.MusicBand;
import common.Response;

public class Add extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		long lastId = collection.stream()
                .mapToLong(MusicBand::getId)
                .max().orElse(1);
		band.setId(lastId+1);
		band.setDate(LocalDate.now());
		collection.add(band);
		Response response = new Response();
		response.setMassage("Группа успешно добавлена");
		return response;
	}

}
