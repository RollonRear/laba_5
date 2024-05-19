package laba5.commands;

import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class PrintFieldAscendingPassportID extends Command{
	public PrintFieldAscendingPassportID() {
		name = "print_field_ascending_passport_i_d";
		description = "";
	}
	@Override
	public void execute(Executor executor, Data data) {
		int n = data.getPeople().size();
		for (int i = 0; i<n; i++) {
			System.out.println(data.getPeople().get(i).getPassport());
		}
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		execute(executor, data);
		
	}
}
