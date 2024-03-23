package BaseModel;

import managers.CollectionManager;
import utility.Element;
import utility.Validatable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.time.ZoneId;

public class City extends Element implements Validatable, Serializable {
    private final Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private long population; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer metersAboveSeaLevel;
    private boolean capital;
    private Climate climate; //Поле может быть null
    private StandardOfLiving standard0fLiving; //Поле может быть null
    private Human governor; //Поле не может быть null

    private static int nextId = 1;

    public City(String name, Coordinates coordinates, long area, Long population,
                Integer metersAboveSeaLevel, boolean capital, Climate climate,
                StandardOfLiving standard0fLiving, Human governor){
        this.id = nextId;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.capital = capital;
        this.climate = climate;
        this.standard0fLiving = standard0fLiving;

        this.governor = governor;
    }
    @Override
    public boolean validate() {
        if (id == null || id <= 0) {
            return false;
        }

        if (name == null || name.isEmpty()) {
            return false;
        }

        if (coordinates == null) {
            return false;
        }

        if (creationDate == null) {
            return false;
        }

        if (area <= 0) {
            return false;
        }

        if (population <= 0) {
            return false;
        }

        // standard0fLiving can be null

        if (governor == null) {
            return false;
        }

        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return area == city.area &&
                capital == city.capital &&
                Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(coordinates, city.coordinates) &&
                Objects.equals(creationDate, city.creationDate) &&
                Objects.equals(population, city.population) &&
                Objects.equals(metersAboveSeaLevel, city.metersAboveSeaLevel) &&
                climate == city.climate &&
                standard0fLiving == city.standard0fLiving &&
                Objects.equals(governor, city.governor);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, capital, climate, standard0fLiving, governor);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long newPopulation) {
        this.population = newPopulation;
    }

    public Integer getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public boolean isCapital() {
        return capital;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate newClimate) {
        this.climate = newClimate;
    }

    public void setStandard0fLiving(StandardOfLiving standard0fLiving) {
        this.standard0fLiving = standard0fLiving;
    }

    public StandardOfLiving getStandard0fLiving() {
        return standard0fLiving;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    public Human getGovernor() {
        return governor;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getArea() {
        return area;
    }


    public static void touchNextId() {
        nextId++;
    }

    public static int getMaxId(){
        return nextId;
    }

    public static void updateNextId(CollectionManager collectionManager) {
        var maxId = 0;
        try {
            maxId = collectionManager.getCollection().lastKey();
        } catch (NoSuchElementException exc) {
            maxId = 0;
        }
        nextId = maxId + 1;
    }

    @Override
    public int compareTo(Element element) {
        return (int)(this.id - element.getId());
    }

    @Override public String toString() {
        return "id: " + id + "\n" + "name: " + name + "\n" + "coordinates: " + coordinates + "\n"
                + "creationDate: " + creationDate + "\n" + "area: " + area + "\n" + "population: " + population
                + "\n" + "metersAboveSeaLevel: " + metersAboveSeaLevel + "\n" + "capital: " + capital + "\n"
                + "climate: " + climate + "\n" + "standardOfLiving: " + standard0fLiving + "\n" + "governor: " + governor;
    }

}
