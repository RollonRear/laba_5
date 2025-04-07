package localcommands;

import common.Request;
import laba5.Writable;

public class ToServerCommand extends AbstractLocalCommand {
	public ToServerCommand(String name) {
		super(name);
	}
	public ToServerCommand(String name, String description) {
		super(name, description);
	}


	@Override
	public Request getRequest(Writable scanner, String args) {
		Request request = new Request(name);
		request.setArgs(args);
		return request;
	}


}
