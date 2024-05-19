package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Info extends Command{
	public Info() {
		name = "info";
		description = "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
	}


	@Override
	public void execute(Executor executor, Data data) {
		System.out.println("Тип коллекции LinkedList, количество элементов: " + data.getPeople().size());
		
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
	}
}
