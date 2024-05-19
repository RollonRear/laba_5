package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;
import laba5.Person;
import laba5.RedAlertCommand;

public class RemoveLower extends RedAlertCommand {
	public RemoveLower() {
		name = "remove_lower";
		description = "удалить из коллекции все элементы, меньшие, чем заданный";
	}

	@Override
	public void execute(Executor executor, Data data) {
		Person person = getPerson(executor, data);
		int n = data.getPeople().size();
		for (int i = 0; i<n; i++) {
			if (data.getPeople().get(i).compareTo(person) == -1) {
				data.getPeople().remove(i);
				break;
			}
			System.out.println("Элементы успешно удалёны");
		}
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		Person person = getPerson(executor, data);
		int n = data.getPeople().size();
		for (int i = 0; i<n; i++) {
			if (data.getPeople().get(i).compareTo(person) == -1) {
				data.getPeople().remove(i);
				break;
			}
			System.out.println("Элементы успешно удалёны");
		}
	}
}
