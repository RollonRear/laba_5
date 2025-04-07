package localcommands;

import common.MusicBand;
import common.Request;
import laba5.Writable;

public class LocalUpdate extends ToServerCommand {
	public LocalUpdate(String name) {
		super(name);
	}
	public LocalUpdate(String name, String description) {
		super(name, description);
	}
	@Override
	public Request getRequest(Writable scanner, String args) {
		try {
			int id = Integer.parseInt(args);
			
			Filler filler = new Filler();
			MusicBand band = filler.getBand(scanner);
			Request request = new Request(name);
			request.setBand(band);
			request.setArgs(id);
			
			return request;
		} catch (NumberFormatException e) {
			System.out.println("ID должно быть целым числом");
			return null;
		}
		
	}
}

