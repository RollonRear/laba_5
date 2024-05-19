package laba5.checkers;

import laba5.Color;

public class ColorChecker extends Checker {

	@Override
	public boolean check(Object object) {
		Color[] colors = Color.values();
		if(object == null) {
			error = "Цвет не может быть пустым, повторите ввод: ";
			return false;
		} else if(object == "") {
			error = "Цвет не может быть пустым, повторите ввод: ";
			return false;
		} else { 
			for(int i = 0; i<colors.length; i++) {
				if(object.equals(colors[i].toString())) return true;
			}
			error = "Нет такого цвета, введите еще раз: ";
			return false;
		}
		
	}

	@Override
	public String getReq() {
		Color[] colors = Color.values();
		String strColors = "";
		for(int i = 0; i<colors.length; i++) {
			strColors = strColors + colors[i].toString() + " ";
		}
		return "Введите цвет волос (" + strColors + "): ";
	}

}
