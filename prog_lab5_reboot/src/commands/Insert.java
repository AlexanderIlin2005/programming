package commands;
import exceptions.WrongAmountOfElementsException;
import managers.CollectionManager;
import utility.Checker;
import utility.Console;

import java.util.Objects;

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

            int key = Integer.parseInt(arguments[1]);

            if (collectionManager.getByKey(key) != null){
                console.printError("Город с таким id уже есть. Возможно, стоит использовать команду update_id");
                return false;
            } else if (key == 0) {
                console.printError("id должен быть больше 0!");
            } else {
                this.collectionManager.insert(key, Checker.checkCity(console, key));
                this.console.println("Город успешно добавлен.");
            }
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (NumberFormatException exception) {
            console.printError("Ключ должен быть представлен числом!");
        } catch (Checker.CheckException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
