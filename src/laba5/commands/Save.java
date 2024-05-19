package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Save extends Command{
	public Save() {
		name = "save";
		description = "сохранить коллекцию в файл";
	}
	

	@Override
	public void execute(Executor executor, Data data) {
		data.save();
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		data.save();
		
	}
}
