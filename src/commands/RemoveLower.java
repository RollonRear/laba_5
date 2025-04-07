package commands;

import java.util.Collection;

import common.MusicBand;
import common.Response;

public class RemoveLower extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		collection.removeIf(element -> element.compareTo(band) < 0);
		Response response = new Response();
		response.setMassage("Элементы успешно удалены");
		return response;
	}

}
