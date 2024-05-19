package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class Head extends Command{
	public Head(){
		name = "head";
		description  = "вывести первый элемент коллекции";
	}
	@Override
	public void execute(Executor executor, Data data) {
		System.out.println(data.getPeople().get(0).toString());
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
		
	}
}
