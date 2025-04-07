package commands;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

import common.MusicBand;
import common.Response;

public class Update extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		long id = Long.parseLong(arg.toString());
		band.setId(id);
		band.setDate(LocalDate.now());
		
		Iterator<MusicBand> iterator = collection.iterator();
	    while (iterator.hasNext()) {
	        MusicBand lastBand = iterator.next();
	        if (lastBand.getId() == id) {
	            iterator.remove();
	            break;
	        }
	    }
	    collection.add(band);
		
		Response response = new Response();
		response.setMassage("Группа успешно обновлена");
		return response;
	}

}
