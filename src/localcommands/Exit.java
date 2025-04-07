package localcommands;

import common.Request;
import laba5.Writable;

public class Exit extends AbstractLocalCommand {
	public Exit(String name) {
		super(name);
	}
	public Exit(String name, String description) {
		super(name, description);
	}

	@Override
	public Request getRequest(Writable scanner, String args) {
		System.exit(0);
		return null;
	}


}
