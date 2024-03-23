package utility;

import BaseModel.City;
import BaseModel.Climate;
import BaseModel.Coordinates;
import BaseModel.StandardOfLiving;
import BaseModel.Human;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class Checker {
    public static class CheckException extends Exception{}

    public static City checkCity(Console console, Integer id) throws CheckException{
        try {

            console.print("name: ");
            String name;
            while (true) {
                name = console.readln().trim();
                if (name.equals("exit")) throw new CheckException();
                if (!name.isEmpty()) break;
                console.print("name: ");
            }

            var coordinates = checkCoordinates(console);
            long area = checkArea(console);
            long population = checkPopulation(console);
            Integer metersAboveSeaLevel = checkMetersAboveSeaLevel(console);
            boolean capital = checkCapital(console);
            Climate climate = checkClimate(console);
            StandardOfLiving standard = checkStandardOfLiving(console);
            Integer governorAge = checkGovernorAge(console);



            return new City(name, coordinates, area, population, metersAboveSeaLevel, capital, climate, standard, new Human(governorAge));



        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    private static Integer checkGovernorAge(Console console) throws CheckException{
        try {
            console.print("governor.age: ");
            Integer age;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { age = Integer.parseInt(line); if (age > 0) break; } catch (NumberFormatException e) { }
                }
                console.print("population: ");
            }

            return age;

        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения. ");
            return checkMetersAboveSeaLevel(console);
        }
    }

    private static StandardOfLiving checkStandardOfLiving(Console console) throws CheckException {
        try {
            console.print("StandardOIfLiving ("+ Arrays.toString(StandardOfLiving.values()) +"): ");
            StandardOfLiving climate;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { climate = StandardOfLiving.valueOf(line); break; } catch (NullPointerException | IllegalArgumentException  e) { }
                }
                console.print("StandardOIfLiving: ");
            }
            return climate;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    private static Climate checkClimate(Console console) throws CheckException {
        try {
            console.print("Climate ("+ Arrays.toString(Climate.values()) +"): ");
            Climate climate;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { climate = Climate.valueOf(line); break; } catch (NullPointerException | IllegalArgumentException  e) { }
                }
                console.print("Climate: ");
            }
            return climate;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    private static boolean checkCapital(Console console) throws CheckException{
        try {
            console.print("population: ");
            boolean meters;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { meters = Boolean.parseBoolean(line); break; } catch (InputMismatchException e) { }
                }
                console.print("population: ");
            }

            return meters;

        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения. ");
            return checkCapital(console);
        }

    }

    private static Integer checkMetersAboveSeaLevel(Console console) throws CheckException{
        try {
            console.print("population: ");
            Integer meters;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { meters = Integer.parseInt(line); break; } catch (NumberFormatException e) { }
                }
                console.print("population: ");
            }

            return meters;

        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения. ");
            return checkMetersAboveSeaLevel(console);
        }
    }

    private static long checkPopulation(Console console) throws CheckException{
        try {
            console.print("population: ");
            long population;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { population = Long.parseLong(line); if (population>0) break; } catch (NumberFormatException e) { }
                }
                console.print("population: ");
            }

            return population;

        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения. ");
            return checkPopulation(console);
        }
    }

    private static long checkArea(Console console) throws CheckException{
        try {
            console.print("area: ");
            long area;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { area = Long.parseLong(line); if (area>0) break; } catch (NumberFormatException e) { }
                }
                console.print("area: ");
            }

          return area;

        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения. ");
            return checkArea(console);
        }
    }

    private static Coordinates checkCoordinates(Console console) throws CheckException{
        try {
            // private Integer x; //Значение поля должно быть больше -485, Поле не может быть null
            // private Double y; //Максимальное значение поля: 907, Поле не может быть null
            console.print("coordinates.x: ");
            float x;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { x = Float.parseFloat(line); if (x>-584) break; } catch (NumberFormatException e) { }
                }
                console.print("coordinates.x: ");
            }
            console.print("coordinates.y: ");
            float y;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new CheckException();
                if (!line.equals("")) {
                    try { y = Float.parseFloat(line); if (y>-469) break; } catch (NumberFormatException e) { }
                }
                console.print("coordinates.y: ");
            }

            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
}
