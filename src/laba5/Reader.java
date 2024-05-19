package laba5;

import java.util.Scanner;

public class Reader extends Client {
	private Scanner scanner;
	
	@Override
	public void request(Executor executor, String massage) {
		
		scanner = new Scanner(System.in);
		System.out.print(massage);
		
	}
	@Override
	public String sendArg() {
		String text = scanner.nextLine();
		return text;
		
	}
	
	
	@Override
	public void send(Executor executor) {
		String text = scanner.nextLine();
		executor.accept(this, text);
		
	}
}
