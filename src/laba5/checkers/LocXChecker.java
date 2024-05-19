package laba5.checkers;

public class LocXChecker extends Checker {

	@Override
	public boolean check(Object object) {
		if(object == null) {
			error = "Положение не может быть пустым, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "Положение не может быть пустым, повторите ввод: ";
			return false;
		} else {
			Double num;
			try {
				num = Double.valueOf((String) object);
			} catch (NumberFormatException e) {
				error = "Введите число: ";
				return false;
			}
			return true;
		}
	}

	@Override
	public String getReq() {

		return "Введите положение локации по X: ";
	}

}
