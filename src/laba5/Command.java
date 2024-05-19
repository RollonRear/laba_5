package laba5;

public abstract class Command {
	protected String name;
	protected String description;
	
	public abstract void execute(Executor executor, Data data);
	
	public abstract void execute(Executor executor, Data data, String arg);
	
	public String getName() {
		return name;	
	}
	public String getDescription() {
		return description;	
	}
	@Override
	public String toString() {
		return name + ": " + description;
		
	}
}
