package laba5;

import java.util.HashMap;
import java.util.Map;

import laba5.commands.*;

public class Main {
	public static void main(String[] args) {
		HashMap<String,Command> commands = new HashMap<>();
		
		Data data = new Data();
		
		Filler filler = new Filler();
		data = filler.getData(System.getenv("laba"));
		
		commands.put(new Add().getName(), new Add());
		commands.put(new Clear().getName(), new Clear());
		commands.put(new ExecuteScript().getName(), new ExecuteScript());
		commands.put(new Exit().getName(), new Exit());
		commands.put(new FilterGreaterThenHairColor().getName(), new FilterGreaterThenHairColor());
		commands.put(new Head().getName(), new Head());
		commands.put(new Help().getName(), new Help());
		commands.put(new Info().getName(), new Info());
		commands.put(new PrintDescending().getName(), new PrintDescending());
		commands.put(new PrintFieldAscendingPassportID().getName(), new PrintFieldAscendingPassportID());
		commands.put(new RemoveById().getName(), new RemoveById());
		commands.put(new RemoveGreater().getName(), new RemoveGreater());
		commands.put(new RemoveLower().getName(), new RemoveLower());
		commands.put(new Save().getName(), new Save());
		commands.put(new Show().getName(), new Show());
		commands.put(new Update().getName(), new Update());
		
		Executor executor = new Executor(commands, data);
		Reader reader = new Reader();
		while(true) {

			reader.request(executor, "Введите комманду: ");
			reader.send(executor);
		}
		
	}
}
