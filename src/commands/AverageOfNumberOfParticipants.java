package commands;

import java.util.Collection;
import java.util.stream.Collectors;

import common.MusicBand;
import common.Response;

public class AverageOfNumberOfParticipants extends AbstractCommand {

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		
		double average = collection.stream()
	               .mapToInt(MusicBand::getNumberOfParticipants)
	               .average().orElse(0);
		Response response = new Response();
		response.setMassage("Среднее количество учасников " + average);
		return response;
	}

}
