package laba5.checkers;

public class CordYChecker extends Checker {

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

			return true;
		}
	}

	@Override
	public String getReq() {
		return "Введите положение по Y: ";
	}

}
