package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.NotFoundException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Console;

public class RemoveKey extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveKey(Console console, CollectionManager collectionManager) {
        super("remove_key", "удалить элемент по ключу");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var key = Integer.parseInt(arguments[1]);
            var cityToRemove = collectionManager.getByKey(key);
            if (cityToRemove == null) throw new NotFoundException();

            collectionManager.removeFromCollectionByKey(key);
            console.println("Продукт успешно удален.");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("Ключ должен быть представлен числом!");
        } catch (NotFoundException exception) {
            console.printError("Города с таким ключом в коллекции нет!");
        }
        return false;
    }
}
