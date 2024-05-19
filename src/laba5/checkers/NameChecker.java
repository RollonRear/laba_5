package laba5.checkers;

public class NameChecker extends Checker {

	@Override
	public boolean check(Object object) {
		if(object == null) {
			error = "Имя не может быть пустым, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "Имя не может быть пустым, повторите ввод: ";
			return false;
		} else return true;
		
	}

	@Override
	public String getReq() {
		return "Введите имя: ";
	}

}
