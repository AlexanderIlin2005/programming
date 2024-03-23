package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Checker;
import utility.Console;

import java.util.Objects;

public class UpdateId extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public UpdateId(Console console, CollectionManager collectionManager) {
        super("update id", "обновить значение элемента коллекции, id которого равен заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var key = Integer.parseInt(arguments[1]);
            if (collectionManager.getByKey(key) != null){
                collectionManager.update(key, Objects.requireNonNull(Checker.checkCity(console, key)));
            }
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
