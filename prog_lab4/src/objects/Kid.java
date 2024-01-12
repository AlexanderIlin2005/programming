package objects;

import enums.Gender;
import enums.Money;
import enums.Product;
import enums.Tense;
import exceptions.UnableToMakePurchaseException;

import java.util.ArrayList;
import java.util.Random;

public class Kid extends Human{
    PiggyBank savedBank;
    String savedNumanName = "";
    public Kid(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public void get(Money money) {
        String add = "монету в " + money;
        System.out.println(makeSentence(this, "достать", Tense.PAST, add));
    }

    private void emptyPiggyBank(PiggyBank bank){
        System.out.println(makeSentence(this, "опустошить", Tense.FUTURE, bank.name));
    }
    public void becomeMotherTo(Human human, PiggyBank bank){
        savedNumanName=human.name;
        savedBank = bank;
        String add = "матерью для " + human.name + "а";
        if (bank.isEmpty()){
            System.out.println(makeSentence(this, "стать", Tense.PAST, add));
        } else {
            System.out.println(makeSentence(this, "стать", Tense.FUTURE, add));
            System.out.print("Но для этого ");
            emptyPiggyBank(bank);
        }
    }

    public void becomeMotherTo(Human human){
        becomeMotherTo(human, savedBank);
    }

    public void stoodConfused(){
        System.out.println(this.name + " стоял совершенно растерянный");
    }

    public void buySweetsForAllMoney(Shop shop) throws UnableToMakePurchaseException {
        shop.buy(this, this.wallet);
        String add = Product.LOLLIPOPS + ", " + Product.SUGARED_NUT + " и " + Product.CHOCOLATE + " на все деньги";
        System.out.println(makeSentence(this, "купить", Tense.PAST, add));
        String add2 = "персонажу " + shop.salesman.name + " весь свой капитал.";
        System.out.println(makeSentence(this, "отдать", Tense.PAST, add2));
        this.thinkAboutDog();
    }

    public void thinkAboutDog(){
        String add = "о том, что "+
                makeSentence(this.gender, "копить", Tense.PAST, "эти деньги на собаку, и ")+
                makeSentence(this.gender, "тяжело вздохнуть",Tense.PAST, "");
        System.out.println(makeSentence(this, "вспомнить", Tense.PAST, add));
        String sentence = "Но он "+makeSentence(this.gender, "тут же подумать", Tense.PAST,"что тот, кто ")
                +makeSentence(this.gender, "решить", Tense.PAST, "что ")
                +makeSentence(this.gender, "стать", Tense.FUTURE, "матерью для "+savedNumanName)
                +makeSentence(this.gender, "не может позволить", Tense.NOW, "себе роскошь - иметь собаку");
        System.out.println(sentence);
    }

    public void toMeetFamilyWithCarlson(Karlson carlson, Family family,String reason, Place roof){
        String sentence = makeSentence(this, "подумать", Tense.PAST, "о том, чтобы ")
                +"пригласить всех членов "+family+" познакомиться с "+carlson.name
                +",\nно "+makeSentence(this.gender, "решить", Tense.PAST, "этого не делать, потому что ")
                +family.preventFromGoing(this, carlson, roof)+".\n"
                +makeSentence(this, "решить", Tense.PAST, "отложить знакомство до другого раза.");

        System.out.println(sentence);
    }

    public void noTimeToSpendWith(Family family){
        System.out.println("Но у "+this.name+" "+makeSentence(Gender.MIDDlE, "не быть", Tense.PAST, "времени посидеть с "+family.name));
    }

    public void takeSomeCookies(Vase vase) {
        Random rnd = new Random();
        for (int i=0; i<=rnd.nextInt(3)+1; i++){
            vase.getCookie();
        }
    }

    public void saveToPiggyBank(PiggyBank bank){
        Random rnd = new Random();
        ArrayList<Money> someCoins = new ArrayList<>();
        for (int i=0; i<=rnd.nextInt(2)+1; i++){
            someCoins.add(this.wallet.get(i));
            this.wallet.remove(i);
        }
        bank.addMoney(this, someCoins);
        System.out.println(this + " приберег несколько монет.");
    }

    public void thinkAboutFlying(Place roof){
        System.out.println(makeSentence(this, "подумать", Tense.PAST, ":")
                +"как же он попадет на "+roof+", если он не умеет летать");
    }
}
