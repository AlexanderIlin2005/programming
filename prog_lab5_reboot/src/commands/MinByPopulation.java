package commands;

import managers.CollectionManager;
import utility.Console;

public class MinByPopulation extends Command{

    private final Console console;
    private final CollectionManager collectionManager;

    public MinByPopulation(Console console, CollectionManager collectionManager) {
        super("min_by_population", "вывести город с наименьшим населением");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean apply(String[] arguments) {
        console.println(collectionManager.minByPopulation());
        return true;
    }
}
