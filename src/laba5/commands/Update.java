package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;
import laba5.RedAlertCommand;

public class Update extends RedAlertCommand{
	public Update() {
		name = "update";
		description = "обновить значение элемента коллекции, id которого равен заданному";
	}

	@Override
	public void execute(Executor executor, Data data) {
		String id = executor.reaction("Введите ID: ");
		execute(executor, data, id);
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		try {
			int n = data.getPeople().size();
			for (int i = 0; i<n; i++) {
				if (data.getPeople().get(i).getId() == Integer.valueOf(arg)) {
					data.getPeople().get(i).replace(getPerson(executor, data));
				}
			}
			
		}catch(NumberFormatException e) {
			System.out.println("Невалидное значение id");
		}
	}
}
