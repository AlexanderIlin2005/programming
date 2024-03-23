package managers;

import BaseModel.City;

import java.io.*;
import java.util.TreeMap;
import utility.Console;

public class DumpManager {

    private Console console;
    private String fileName;

    public DumpManager(Console console, String fileName) {
        this.console = console;
        this.fileName = fileName;
    }

    public void writeCollection(TreeMap<Integer, City> cityMap){
        try {
            if(fileName.isEmpty()){
                console.printError("Пустое имя файла");
                return;
            }

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
                 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(cityMap);
                console.println("Коллекция успешно сохранена в файле " + fileName);
            } catch (IOException e) {
                console.printError("Ошибка при записи коллекции в файл");
            }

        } catch (Exception e){
            console.printError("Произошла ошибка");
        }
    }

    public TreeMap<Integer, City> readCollection(){
        try {
            if(fileName.isEmpty()){
                console.printError("Пустое имя файла");
                return null;
            }

            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                TreeMap<Integer, City> cityMap = (TreeMap<Integer, City>) ois.readObject();
                console.println("Коллекция успешно загружена из файла " + fileName);
                return cityMap;
            } catch (IOException | ClassNotFoundException e) {
                return new TreeMap<>();
                //console.printError("Ошибка при чтении коллекции из файла");
            }

        } catch (Exception e){
            console.printError("Произошла ошибка");
        }

        return new TreeMap<>();
    }
}
