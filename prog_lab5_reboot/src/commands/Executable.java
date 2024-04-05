package commands;

import javax.xml.parsers.ParserConfigurationException;

public interface Executable {
    boolean apply(String[] arguments);
}
