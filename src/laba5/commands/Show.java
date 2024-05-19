package laba5.commands;

import laba5.Color;
import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Show extends Command {
	public Show(){
		name = "show";
		description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
	}

	@Override
	public void execute(Executor executor, Data data) {
		int n = data.getPeople().size();
		for (int i = 0; i<n; i++) {
			System.out.println(data.getPeople().get(i).toString());
		}
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
		
	}
}
