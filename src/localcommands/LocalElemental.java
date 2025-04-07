package localcommands;

import java.util.Map;

import common.MusicBand;
import common.Request;
import laba5.Writable;

public class LocalElemental extends ToServerCommand {
	public LocalElemental(String name) {
		super(name);
	}
	public LocalElemental(String name, String description) {
		super(name, description);
	}
	@Override
	public Request getRequest(Writable scanner, String args) {
		Filler filler = new Filler();
		MusicBand band = filler.getBand(scanner);
		Request request = new Request(name);
		request.setBand(band);
		
		return request;
	}
}
