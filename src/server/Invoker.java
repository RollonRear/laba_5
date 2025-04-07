package server;

import java.util.Collection;
import java.util.Map;

import commands.AbstractCommand;
import common.Request;
import common.Response;

public class Invoker {
	Map<String, AbstractCommand> commands;
	
	public Response getResponse(Request request, Collection bands) {
		return  commands.get(request.command).execute(request.arg, request.band, bands);
	}

	public void setCommands(Map<String, AbstractCommand> commandsServer) {
		this.commands = commandsServer;
		
	}
}
