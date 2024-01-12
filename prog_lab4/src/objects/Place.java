package objects;

import enums.Gender;

public class Place extends BaseObject{

    public Place(String name, Gender gender) {
        super(name, gender);
        {
            System.out.println("Место: " + this.name);
        }
    }
}
