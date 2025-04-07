package commands;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;

import common.MusicBand;
import common.Response;

public class AddIfMin extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		MusicBand minimal = collection.stream()
                .min(Comparable::compareTo)
                .orElse(band);

		Response response = new Response();
		
		
		if (band.compareTo(minimal) > 0) {
			long lastId = collection.stream()
			              .mapToLong(MusicBand::getId)
			              .max()
			              .orElse(0L);
			
			band.setId(lastId + 1);
			band.setDate(LocalDate.now());
			collection.add(band);
			
			response.setMassage("Группа добавлена");
		} else {
			response.setMassage("Группа не добавлена");
		}
		
		return response;
	}

}
