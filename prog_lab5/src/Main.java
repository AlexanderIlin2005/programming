import BaseModel.City;
import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;
import utility.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Interrogator.setUserScanner(new Scanner(System.in));
        var console = new StandardConsole();

        if (args.length == 0) {
            console.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        var dumpManager = new DumpManager(console, args[0]);
        var collectionManager = new CollectionManager(dumpManager);

        City.updateNextId(collectionManager);
        collectionManager.validateAll(console);

        var commandManager = new CommandManager() {{
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
            register("UpdateId", new UpdateId(console, collectionManager));
        }};

        new Runner(console, commandManager).interactiveMode();
    }
}