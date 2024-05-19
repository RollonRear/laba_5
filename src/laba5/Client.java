package laba5;

public abstract class Client {
	abstract public void request(Executor execute, String massage);
	
	abstract public void send(Executor execute);
	abstract public String sendArg();
}
