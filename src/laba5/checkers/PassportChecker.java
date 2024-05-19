package laba5.checkers;

public class PassportChecker extends Checker {

	@Override
	public boolean check(Object object) {
		if(object == null) {
			error = "У него не может не быть паспорта, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "У него не может не быть паспорта, повторите ввод: ";
			return false;
		} else return true;
	}

	@Override
	public String getReq() {
		return "Введите паспортные данные: ";
	}

}
