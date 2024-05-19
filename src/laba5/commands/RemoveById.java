package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class RemoveById extends Command{
	public RemoveById() {
		name = "remove_by_id";
		description = "удалить элемент из коллекции по его id";
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
					data.getPeople().remove(i);
					System.out.println("Элемент успешно удалён");
				}
			}
		}catch(NumberFormatException e) {
			System.out.println("Невалидное значение id");
		}
		
	}
}
