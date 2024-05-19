package laba5.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import laba5.Command;
import laba5.Data;
import laba5.Executor;
import laba5.ImaginaryClient;
import laba5.Reader;

public class ExecuteScript extends Command {
	
	static private ArrayList<String> BANfilenames = new ArrayList<>();
	
	public ExecuteScript (){
		name = "execute_script";
		description = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
	}
	@Override
	public void execute(Executor executor, Data data){
		String script =  executor.reaction("Введите имя файла: ");
		
		execute(executor, data, script);
		
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		if (BANfilenames.size() == 0) {
			BANfilenames.add(arg);
		}
		else {
			for (int i = 0; i<BANfilenames.size(); i++) {
				if(BANfilenames.get(i).equals(arg)) {
					System.out.println("Скрипт файла содержит вызов самого себя, поэтому мы вынуждены завержить программу");
					System.exit(0);
				}
			}
		}
		BANfilenames.add(arg);
		
		File file = new File(arg);
		
		ArrayList<String> commandList = new ArrayList<>();
	    try
        {
	    	Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                
                commandList.add(str);
            }
            sc.close();
        }catch (FileNotFoundException e) {
        	e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
	    
	    try{
	    	if(commandList.size() != 0) {
		    	ImaginaryClient client = new ImaginaryClient(commandList);
		    	while(client.active) {
		    		client.request(executor, "Введите комманду: ");
		    		client.send(executor);
				}
	    	}
	    } catch(IOException e) {
	    	e.getMessage();
	    }
	}
}
