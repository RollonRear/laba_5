package laba5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import commands.*;
import common.*;
import localcommands.*;
import server.BandFileReader;
import server.Invoker;
public class Main {

	public static void main(String[] args) {
		Request request;
		Scanner scanner = new Scanner(System.in);
		Writer writer = new Writer(scanner);
		HashSet<MusicBand> bands;
		String fileName = System.getenv("band");
		System.out.println(fileName);
		
		BandFileReader fileReader = new BandFileReader();
		bands = fileReader.readBandsFromFile(fileName);
		
		Invoker invoker = new Invoker();
		
		Map<String, AbstractCommand> commandsServer = new HashMap<>();
		commandsServer.put("add", new Add());
		Save save = new Save();
		save.filePath = fileName;
		commandsServer.put("save", save);
		commandsServer.put("show", new Show());
		commandsServer.put("info", new Info());
		commandsServer.put("update", new Update());
		commandsServer.put("remove_by_id", new RemoveById());
		commandsServer.put("clear", new Clear());
		commandsServer.put("add_if_min", new AddIfMin ());
		commandsServer.put("remove_greater", new RemoveGreater ());
		commandsServer.put("remove_lower", new RemoveLower ());
		commandsServer.put("average_of_number_of_participants", new AverageOfNumberOfParticipants ());
		commandsServer.put("filter_less_than_number_of_participants", new FilterLessThanNumberOfParticipants ());
		commandsServer.put("print_field_ascending_front_man", new PrintFieldAscendingFrontMan ());
		
		invoker.setCommands(commandsServer);
		
		Map<String, LocalCommand> commands = new HashMap<>();
		commands.put("info", new ToServerCommand("info", "вывести в стандартный поток вывода информацию о коллекции"));
		commands.put("show", new ToServerCommand("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"));
		commands.put("clear", new ToServerCommand("clear", "очистить коллекцию"));
		commands.put("save", new ToServerCommand("save", "сохранить коллекцию в файл"));
		commands.put("print_field_ascending_front_man", new ToServerCommand("print_field_ascending_front_man", "вывести значения поля frontMan всех элементов в порядке возрастания"));
		commands.put("average_of_number_of_participants", new ToServerCommand("average_of_number_of_participants", "вывести среднее значение поля numberOfParticipants для всех элементов коллекции"));
		commands.put("add", new LocalElemental("add", "добавить новый элемент в коллекцию"));
		commands.put("add_if_min", new LocalElemental("add_if_min", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции"));
		commands.put("remove_greater", new LocalElemental("remove_greater", "удалить из коллекции все элементы, превышающие заданный"));
		commands.put("remove_lower", new LocalElemental("remove_lower", " удалить из коллекции все элементы, меньшие, чем заданный"));
		commands.put("update", new LocalUpdate("update", "обновить значение элемента коллекции, id которого равен заданному"));
		commands.put("remove_by_id", new LocalIntArg("remove_by_id", "удалить элемент из коллекции по его id"));
		commands.put("filter_less_than_number_of_participants", new LocalIntArg("filter_less_than_number_of_participants", "вывести элементы, значение поля numberOfParticipants которых меньше заданного"));
		commands.put("exit", new Exit("exit", "завершить программу (без сохранения в файл)"));
		commands.put("execute_script", new ExecuteScript("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."));
		
		LocalHelp localHelp = new LocalHelp("help", "вывести справку по доступным командам");
		localHelp.setCommands(commands);
		
		commands.put("help", localHelp);
		
		Reader reader = new Reader(writer, commands);
		ResponseReader responseReader = new ResponseReader(); 
		while (true){
			request = reader.getRequest();
			Response response = invoker.getResponse(request, bands);
			responseReader.readResponse(response);
		}
	}

}
