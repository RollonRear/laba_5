package localcommands;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import common.Request;
import laba5.Writable;

public class LocalHelp extends AbstractLocalCommand {
	Map<String, LocalCommand> commands;
	public LocalHelp(String name) {
		super(name);
	}
	public LocalHelp(String name, String description) {
		super(name, description);
	}
	public void setCommands(Map<String, LocalCommand> commands) {
		this.commands = commands;
	}

	@Override
	public Request getRequest(Writable scanner, String args) {
		commands.values().forEach(value -> System.out.println(value.getDescription()));
		return null;
	}

}
