import BaseModel.City;
import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;
import utility.*;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Interrogator.setUserScanner(new Scanner(System.in));
        Console console = new StandardConsole();
        System.out.println("123123123");

        if (args.length == 0) {
            console.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        DumpManager dumpManager = new DumpManager(console, args[0]);
        CollectionManager collectionManager = new CollectionManager(dumpManager, console);

        City.updateNextId(collectionManager);
        collectionManager.validateAll(console);

        CommandManager commandManager = new CommandManager() {{
            register("clear", new Clear(console, collectionManager));
            register("count_by_meters_above_sea_level", new CountByMetersAboveSeaLevel(console, collectionManager));
            register("exit", new Exit(console));
            register("group_counting_by_area", new GroupCountingByArea(console, collectionManager));
            register("help", new Help(console, this));
            register("info", new Info(console, collectionManager));
            register("insert", new Insert(console, collectionManager));
            register("min_by_population", new MinByPopulation(console, collectionManager));
            register("remove_greater_key", new RemoveGreaterKey(console, collectionManager));
            register("remove_key", new RemoveGreaterKey(console, collectionManager));
            register("replace_if_greater", new ReplaceIfGreater(console, collectionManager));
            register("replace_if_lower", new ReplaceIfLower(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("update_id", new UpdateId(console, collectionManager));
            register("execute_script", new ExecuteScript(console));
        }};

        new Runner(console, commandManager).interactiveMode();
    }
}