package commands;

import java.util.Collection;

import common.MusicBand;
import common.Response;

public class Show extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		Response response = new Response();
		MusicBand[] bands = collection.stream()
                .toArray(MusicBand[]::new);
		response.setBands(bands);
		return response;
	}

}
