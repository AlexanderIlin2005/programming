package objects;

import enums.Gender;
import enums.Money;
import enums.Mood;
import enums.Tense;

public class Karlson extends Human{

    public Karlson(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public void get(Money money) {
        this.setMood(Mood.PLEASED);
        String add = "монету в " + money;
        System.out.println(makeSentence(this, "достать", Tense.PAST, add));
        String s = this.getMood().getDecription();
        if (money == Money.FIVE){
            this.setMood(Mood.VERY_HAPPY);
            s += " и "+this.getMood().getDecription();
        }
        System.out.println(this.getName() + s);
    }

    public void lookAt(Human human){
        String add = " на " + human.getName() + " " + this.getMood().getDecription();
        System.out.println(makeSentence(this, "посмотреть", Tense.PAST, add));
    }

    public void sayHeWantsCookies(Human human){
        System.out.println(
                makeSentence(this,"сказать", Tense.PAST,
                        human+" что он хочет печенье."));
    }

    public void calmDown(Kid malish){
        this.setMood(Mood.NORMAL);
        //System.out.println(makeSentence(this, "быть", Tense.PAST,
        //        "тем, что "+malish+" приберег несколько монет."));
        //goodReaction();
    }

    //private void goodReaction(){
    //    this.setMood(Mood.EXCITED);
        //System.out.println(
        //        "Глаза "+this+" "+makeSentence(Gender.ALL, "засиять", Tense.PAST, "и он ")
        //                +makeSentence(Gender.MALE, "запрыгать", Tense.PAST,"на месте "+this.getMood().getDecription()));

    //}
}
