package objects;

import enums.Gender;
import enums.Tense;
import interfaces.WordAgreementable;

import java.util.List;

public class Family extends BaseObject implements WordAgreementable {
    private List<Human> members;

    public Family(String name, List<Human> members) {
        super(name, Gender.ALL);
        this.members = members;
        {
            StringBuilder out = new StringBuilder("Семья: ");
            for (Human member : this.members) {
                out.append(member.name);
                out.append(", ");
            }
            System.out.println(out.substring(0, out.length() - 2));
        }
    }


    private String execute(String verb, Tense tense, String adding) {
        StringBuilder res = new StringBuilder("");
        for (Human member : this.members){
            res.append(member.name);
            res.append(", ");
        }
        res = new StringBuilder(res.substring(0, res.length() - 2));
        res.append(" "+tense.start + (tense != Tense.NOW ? verb.substring(0, verb.length() - 2) : verb) +
                tense.ending + (tense != Tense.NOW ? this.gender.ending : ""));
        res.append(adding);
        return res.toString();
    }

    public void moveAllMembersTo(Place place){
        for (Human member:this.members){
            member.moveTo(place);
        }
    }

    public String preventFromGoing(Human human, Karlson carlson, Place place){
        return this.name + " может помешать " + human.name + " и " + carlson.name + " отправиться на " + place.name;
    }
    public void drinkCoffeeAfterDinner(){
        System.out.println(execute("пить", Tense.PAST, " послеобеденный кофе."));
    }


}
