package commands;


import exceptions.CollectionIsEmptyException;
import exceptions.NotFoundException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Checker;
import utility.Console;

public class RemoveGreaterKey extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveGreaterKey(Console console, CollectionManager collectionManager) {
        super("remove_greater_key", "удалить из коллекции все элементы, ключ которых превышает заданный");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var key = Integer.parseInt(arguments[1]);
            this.collectionManager.removeGreaterKey(key);
            this.console.println("Город успешно добавлен.");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("Ключ должен быть представлен числом!");
        }
        return false;
    }
}

