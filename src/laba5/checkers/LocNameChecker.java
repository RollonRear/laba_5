package laba5.checkers;

public class LocNameChecker extends Checker {

	@Override
	public boolean check(Object object) {
		if (object.toString().length() > 627) {
			error = "Название не может превышать длину 627";
			return false;
		}
		return true;
	}

	@Override
	public String getReq() {
		return "Введите название локации: ";
	}

}
