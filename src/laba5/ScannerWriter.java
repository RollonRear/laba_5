package laba5;

import java.util.Scanner;

public class ScannerWriter implements Writable {
	
	protected Scanner scanner;
	
	ScannerWriter(Scanner scanner){
		this.scanner = scanner;
	}

	@Override
	public String getLine(String massage) {
		System.out.print(massage);
		String string = scanner.nextLine();
		
		return string;
	}


	@Override
	public void setScript(String script) {
		// TODO Auto-generated method stub
		
	}

}
