package localcommands;

import common.Request;
import laba5.Writable;

public interface LocalCommand {
	String getDescription();
	Request getRequest(Writable scanner, String args);
}
