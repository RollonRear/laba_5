package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class PrintDescending extends Command {
	public PrintDescending() {
		name = "print_descending";
		description = "вывести элементы коллекции в порядке убывания";
	}
	
	@Override
	public void execute(Executor executor, Data data) {
		int n = data.getPeople().size();
		for (int i = n-1; i>=0; i--) {
			System.out.println(data.getPeople().get(i).toString());
		}
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
		
	}
}
