package localcommands;

import common.MusicBand;
import common.Request;
import laba5.Writable;

public class LocalIntArg extends ToServerCommand {
	public LocalIntArg(String name) {
		super(name);
	}
	public LocalIntArg(String name, String description) {
		super(name, description);
	}
	@Override
	public Request getRequest(Writable scanner, String args) {
		try {
			int id = Integer.parseInt(args);
			
			Request request = new Request(name);
			request.setArgs(id);
			
			return request;
		} catch (NumberFormatException e) {
			System.out.println("Аргумент должен быть целым числом");
			return null;
		}
		
	}
}
