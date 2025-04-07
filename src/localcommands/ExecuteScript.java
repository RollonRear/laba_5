package localcommands;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import common.Request;
import laba5.VirtualWriter;
import laba5.Writable;

public class ExecuteScript extends AbstractLocalCommand{
	
	
	public ExecuteScript(String name) {
		super(name);

	}
	public ExecuteScript(String name, String description) {
		super(name, description);

	}

	@Override
	public Request getRequest(Writable scanner, String args){
		scanner.setScript(args);
		return null;
	}

}
