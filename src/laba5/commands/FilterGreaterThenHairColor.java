package laba5.commands;

import laba5.Color;
import laba5.Command;
import laba5.Data;
import laba5.Executor;

public class FilterGreaterThenHairColor extends Command {
	public FilterGreaterThenHairColor(){
		name = "filter_greater_than_hair_color";
		description = "вывести элементы, значение поля hairColor которых больше заданного";
	}
	@Override
	public void execute(Executor executor, Data data) {
		String color =  executor.reaction("Введите цвет: ");
		
		execute(executor, data, color);
		
	}

	@Override
	public void execute(Executor executor, Data data, String arg) {
		try {
			int n = data.getPeople().size();
			Color[] colors = Color.values();
			for (int i = 0; i<n; i++) {
				int k = 0;
				for(int j = 0; j<colors.length; j++) {
					if (colors[j].equals(data.getPeople().get(i).getColor())) {
						k=j;
						break;
					}
				}
				for(int j = 0; j<colors.length; j++) {
					if (colors[j].equals(Color.valueOf(arg))) {
						if (k>j) {
							System.out.println(data.getPeople().get(i).toString());
						}
						break;
					}
				}
			}
		}catch (IllegalArgumentException e) {
			e.getMessage();
		}
	}
}
