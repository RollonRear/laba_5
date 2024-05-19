package laba5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ImaginaryClient extends Client {
	String buffer;
	private ArrayList<String> commands;
	private int step;
	public boolean active;

	public ImaginaryClient(ArrayList<String> commandList) throws IOException {
		this.commands = commandList;
		step = 0;
		active = true;
	}

	@Override
	public void request(Executor execute, String massage) {
		
		buffer = commands.get(step);
		step++;
		if (step == commands.size()) {
			active = false;
		}
	}

	@Override
	public void send(Executor execute) {
		execute.accept(this, buffer);
	}

	@Override
	public String sendArg() {
		return buffer;
	}

}
