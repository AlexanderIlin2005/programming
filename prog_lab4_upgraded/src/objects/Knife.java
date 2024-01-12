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
        System.out.println(human.getName() + " переместил " + this.getName() + " из " + oldPlace.getName() + " в " + this.place.getName());
    }

    public void setPlace(Place newPlace){
        this.place = newPlace;
    }


}
