package commands;

import managers.CollectionManager;
import utility.Console;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

public class Save extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean apply(String[] arguments){
        if (!arguments[1].isEmpty()) {
            console.println("Использование: '" + getName() + "'");
        }
        String filename = arguments[1];
        try {
            collectionManager.saveCollection(filename, console);
        } catch (JAXBException e) {
            console.println("\n");
            return false;
        }
        return true;
    }
}
