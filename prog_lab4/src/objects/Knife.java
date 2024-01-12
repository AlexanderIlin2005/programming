package objects;

import enums.Gender;
import enums.Tense;

public class Knife extends BaseObject{

    private Place place;

    public Knife(String name, Place place) {
        super(name, Gender.MALE);
        this.place = place;
    }

    public void moveTo(Human human, Place newPlace){
        Place oldPlace = this.place;
        this.place = newPlace;
        System.out.println(human.name + " переместил " + this.name + " из " + oldPlace.name + " в " + this.place.name);
    }


}
