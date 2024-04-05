package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Console;

public class GroupCountingByArea extends Command{

    private final Console console;
    private final CollectionManager collectionManager;

    public GroupCountingByArea(Console console, CollectionManager collectionManager) {
        super("group_counting_by_area",
                "сгруппировать элементы коллекции по значению поля аrеа, вывести количество элементов в каждой группе");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            collectionManager.groupCountingByArea(console);
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");

        }
        return false;
    }

}
