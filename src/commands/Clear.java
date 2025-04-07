package commands;

import java.util.Collection;

import common.MusicBand;
import common.Response;

public class Clear extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		collection.clear();
		Response response = new Response();
		response.setMassage("Коллекция успешно очищена");
		return response;
	}

}
