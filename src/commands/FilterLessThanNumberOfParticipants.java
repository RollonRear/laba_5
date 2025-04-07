package commands;

import java.util.Collection;

import common.MusicBand;
import common.Response;

public class FilterLessThanNumberOfParticipants extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		
		MusicBand[] bands = collection.stream()
				.filter(b -> b.getNumberOfParticipants() < Integer.parseInt(arg.toString()))
				.toArray(MusicBand[]::new);
		Response response = new Response();
		response.setMassage("Элементы с меньшим числом участников");
		response.setBands(bands);
		return response;
	}

}