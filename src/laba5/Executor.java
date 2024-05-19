package laba5;

import java.util.HashMap;

public class Executor {
	
	HashMap<String,Command> commands;
	Data data;
	Client client;
	
	Executor(HashMap<String, Command> commands, Data data){
		this.commands = commands;
		this.data = data;
	}
	
	public void accept(Client client, String text) {
		this.client = client;

		String[] comArg = text.split(" ");
		Command command = commands.get(comArg[0]);
		try {
			if (comArg.length > 1) {
				command.execute(this, data, comArg[1]);
			} else {
				command.execute(this, data);
			}
		} catch (NullPointerException e) {
			//System.out.println(e.getMessage());
			System.out.println("Нет такой команды, чтобы посмотреть список возможных команд, напишите help");
		}
		
	}
	public String reaction(String mass) {
		client.request(this, mass);
		return client.sendArg();
	}

	public HashMap<String, Command> getCommands() {
		return commands;
	}
}
