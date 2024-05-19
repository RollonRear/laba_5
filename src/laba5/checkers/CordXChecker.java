package laba5.checkers;

public class CordXChecker extends Checker {

	@Override
	public boolean check(Object object) {
		if(object == null) {
			error = "Положение не может быть пустым, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "Положение не может быть пустым, повторите ввод: ";
			return false;
		} else {
			int num;
			try {
				num = Integer.valueOf((String) object);
			} catch (NumberFormatException e) {
				error = "Введите целое число: ";
				return false;
			}
			if (num > -765) {
				
				return true;
			}
			else
				error = "Положение по X не может не превышать -765, повторите ввод: ";
				return false;
		}
	}

	@Override
	public String getReq() {

		return "Введите положение по X: ";
	}

}
