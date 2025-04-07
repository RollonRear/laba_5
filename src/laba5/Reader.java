package laba5;

import java.util.Map;
import java.util.Scanner;

import common.Request;
import localcommands.LocalCommand;

public class Reader {
	Writable writer;
	Map<String, LocalCommand> commands;
	Reader(Writable writer, Map<String, LocalCommand> commands){
		this.writer = writer;
		this.commands = commands;
	}
	Request getRequest(){
		Request request;
		request = null;
		while (request == null) {
			LocalCommand command;
			String string = writer.getLine("Введите команду: ");
			String[] tokens = string.split(" ");
			try {
				command = commands.get(tokens[0]);
				if (tokens.length == 1) {
					request = command.getRequest(writer, "");
				} else {
					request = command.getRequest(writer, tokens[1]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Не существует такой команды! Воспользуйтесь help");
			} catch (NullPointerException e) {
				System.out.println("Не существует такой команды! Воспользуйтесь help!");		
			}
		}
		return request;
	}
}
