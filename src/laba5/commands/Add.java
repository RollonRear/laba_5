package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;
import laba5.RedAlertCommand;

public class Add extends RedAlertCommand {
	
	public Add (){
		name = "add";
		description = "добавить новый элемент в коллекцию";
	}

	@Override
	public void execute(Executor executor, Data data) {
		data.add(getPerson(executor, data));
		
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		System.out.println("Для этой команды аргумент не нужен");
		data.add(getPerson(executor, data));
	}
}
