package laba5.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Help extends Command {
	public Help() {
		name = "help";
		description = "вывести справку по доступным командам";
	}

	@Override
	public void execute(Executor executor, Data data) {
		Object[] commands =  executor.getCommands().values().toArray();
		for (int i = 0; i < commands.length; i++) {
			System.out.println(commands[i]);
		}
		
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
	}
	
}
