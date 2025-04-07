package laba5;

import java.util.LinkedList;
import java.util.Scanner;

public class Writer extends ScannerWriter  {
	private VirtualWriter scripter;

	Writer(Scanner scanner) {
		super(scanner);
	}
	@Override
	public void setScript(String script) {
		if (scripter == null)
			scripter = new VirtualWriter(script, new LinkedList<String>());
		else
			scripter.setScript(script);
	}
	
	@Override
	public String getLine(String massage) {
		if (scripter != null) {
			if (scripter.isAlive()) {
				return scripter.getLine(massage);
			}
			else {
				scripter = null;
				return super.getLine(massage);
			}
		} else {
			return super.getLine(massage);
		}
	}





}
