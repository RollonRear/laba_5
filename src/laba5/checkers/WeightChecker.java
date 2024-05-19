package laba5.checkers;

public class WeightChecker extends Checker{

	@Override
	public boolean check(Object object) {
		if(object == null) {
			error = "Вес не может быть пустым, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "Вес не может быть пустым, повторите ввод: ";
			return false;
		} else {
			Double num;
			try {
				num = Double.valueOf((String) object);
			} catch (NumberFormatException e) {
				error = "Введите число: ";
				return false;
			}
			if (num < 0 || num > 1000) {
				error = "Недопустимое значение веса, повторите ввод: ";
				return false;
				
			}
			else
				return true;
		}
	}


	@Override
	public String getReq() {
		// TODO Auto-generated method stub
		return "Введите вес: ";
	}

}
