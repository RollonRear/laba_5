package localcommands;

import common.Request;
import laba5.Writable;

public abstract class AbstractLocalCommand implements LocalCommand {
	protected String name;
	protected String description;
	
	public AbstractLocalCommand(String name) {
		this.name = name;
	}
	public AbstractLocalCommand(String name, String description) {
		this.name = name;
		this.description = description;
	}
	@Override
	public String getDescription() {
		return name + " - " + description;
	}
	abstract public Request getRequest(Writable scanner, String args);

}
