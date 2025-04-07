package commands;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.MusicBand;
import common.Person;
import common.Response;

public class PrintFieldAscendingFrontMan extends AbstractCommand{

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		String mass = collection.stream().map(b -> b.getFrontMan())
				.sorted()
				.map(Object::toString)
				.collect(Collectors.joining("\n"));
		Response response = new Response();
		response.setMassage(mass);
		return response;
	}

}
