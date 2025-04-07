package commands;

import java.time.LocalDate;
import java.util.Collection;

import common.MusicBand;
import common.Response;

public class Info extends AbstractCommand{

	@Override
	public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection) {
		Response response = new Response();
		String mass = "";
		mass = mass + "Тип коллекции HashSet \n";
		mass = mass + "Дата инициализации " + LocalDate.now() + "\n";
		mass = mass + "Количество элементов " + collection.size() + "\n";
		response.setMassage(mass);
		return response;
	}
	
}
