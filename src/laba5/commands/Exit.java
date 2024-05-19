package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Exit extends Command {
	public Exit(){
		name = "exit";
		description = "завершить программу (без сохранения в файл)";
	}
	@Override
	public void execute(Executor executor, Data data) {
		System.exit(0);
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		System.exit(0);
		
	}
}
