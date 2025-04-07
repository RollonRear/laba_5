package commands;

import java.util.Collection;

import common.MusicBand;
import common.Response;

public abstract class AbstractCommand {
	String name;
	abstract public Response execute(Object arg, MusicBand band, Collection<MusicBand> collection);
	public void setName(String name) {
		this.name = name;
	}
}