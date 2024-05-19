package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Clear extends Command {
	public Clear (){
		name = "clear";
		description = "очистить коллекцию";
	}

	@Override
	public void execute(Executor executor, Data data) {
		data.getPeople().clear();
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		System.out.println("Для этой команды аргумент не нужен");
		data.getPeople().clear();
		
	}
}
