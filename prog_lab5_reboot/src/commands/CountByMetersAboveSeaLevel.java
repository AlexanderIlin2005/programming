package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.NotFoundException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Checker;
import utility.Console;

public class CountByMetersAboveSeaLevel extends Command{

    private final Console console;
    private final CollectionManager collectionManager;

    public CountByMetersAboveSeaLevel(Console console, CollectionManager collectionManager) {
        super("count_by_meters_above_sea_level",
                " вывести количество элементов, значение поля metersAboveSeaLevel которых равно заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            int metersAboveSeaLevel = Integer.parseInt(arguments[1]);

            console.println(collectionManager.countByMetersAboveSeaLevel(console, metersAboveSeaLevel));
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("Параметр <высота над уровнем моря> должен быть представлен числом!");
            return false;
        }
        return false;
    }
}
