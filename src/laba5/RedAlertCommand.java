package laba5;

import java.util.Date;

import laba5.checkers.*;

public abstract class RedAlertCommand extends Command{
	protected Person getPerson(Executor executor, Data data){
		String id = String.valueOf(data.getLastId()+1);
		Date date = new Date();
		
		int powField = 10;
		
		String[] fields = new String[powField];
		Checker[] checkers = new Checker[powField];
		
		checkers[0] = new NameChecker();
		checkers[1] = new CordXChecker();
		checkers[2] = new CordYChecker();
		checkers[3] = new HeightChecker();
		checkers[4] = new WeightChecker();
		checkers[5] = new PassportChecker();
		checkers[6] = new ColorChecker();
		checkers[7] = new LocXChecker();
		checkers[8] = new LocYChecker();
		checkers[9] = new LocNameChecker();
		
		for(int i = 0; i<checkers.length; i++) {
			String field = executor.reaction(checkers[i].getReq());
			if(checkers[i].check(field)) {
				fields[i] = field;
			} else {
				while(!checkers[i].check(field)) {
					field = executor.reaction(checkers[i].getError());
				}
				fields[i] = field;
			}
		}
		
		Person person = new Person(id, fields[0], fields[1], fields[2], date, fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9]);
		
		return person;
	}
	
}
