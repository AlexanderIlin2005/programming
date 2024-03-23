package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.NotFoundException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Checker;
import utility.Console;

public class Insert extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Insert(Console console, CollectionManager collectionManager) {
        super("insert  null", "добавить новый элемент с заданным ключом");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var key = Integer.parseInt(arguments[1]);
            this.collectionManager.insert(key, Checker.checkCity(console, key));
            this.console.println("Город успешно добавлен.");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("Ключ должен быть представлен числом!");
        } catch (Checker.CheckException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
