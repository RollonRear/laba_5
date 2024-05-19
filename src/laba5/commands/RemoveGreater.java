package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;
import laba5.Person;
import laba5.RedAlertCommand;

public class RemoveGreater extends RedAlertCommand {
	public RemoveGreater() {
		name = "remove_greater";
		description = "удалить из коллекции все элементы, превышающие заданный";
	}
	@Override
	public void execute(Executor executor, Data data) {
		Person person = getPerson(executor, data);
		int n = data.getPeople().size();
		for (int i = 0; i<n; i++) {
			if (data.getPeople().get(i).compareTo(person) == 1) {
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
			if (data.getPeople().get(i).compareTo(person) == 1) {
				data.getPeople().remove(i);
				break;
			}
			System.out.println("Элементы успешно удалёны");
		}
	}
}
