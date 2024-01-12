package objects;


import enums.Gender;
import enums.Money;
import enums.Tense;
import exceptions.NoMoneyException;
import interfaces.MoneyReceivable;

import java.util.ArrayList;

public class Human extends BaseObject implements MoneyReceivable {
    Place place;
    protected ArrayList<Money> wallet;
    //private Place place = null;
    public Human(String name, Gender gender) {
        super(name, gender);
        {
            System.out.println("Персонаж типа "+this.getClass().getName() + " " + this.name + " создан");
        }
        this.wallet = new ArrayList<>();
        this.place = null;
    }

    @Override
    public void getMoney(Money coin){
        System.out.println(makeSentence(this, "получить", Tense.PAST,
                "монету в "+coin));
        this.wallet.add(coin);
    }

    @Override
    public void getMoney(ArrayList<Money> coins){
            StringBuilder add = joinListOfCoins(coins);
            System.out.println(makeSentence(this, "получить", Tense.PAST,
                    "монеты: " + add));
            this.wallet.addAll(coins);
    }

    @Override
    public void giveMoney(Money coin, Human human) throws NoMoneyException{
        if (this.wallet.contains(coin)) {
            this.wallet.remove(coin);
            human.getMoney(coin);
            String add = "монету в " + coin.getValue() + " на баланс к " + human;
            System.out.println(makeSentence(this, "передать", Tense.PAST, add));
        } else throw new NoMoneyException(this, human);
    }

    @Override
    public void giveMoney(ArrayList<Money> coins, Human human) {
        StringBuilder add = joinListOfCoins(coins);
        System.out.println(makeSentence(this, "передать", Tense.PAST, "монеты: "+add));
        this.wallet.removeAll(coins);

    }

    @Override
    public void giveAllMoney(Human human) {
        try{
            human.getMoney(this.wallet);
            this.wallet.clear();
            System.out.println(makeSentence(this, "отдать", Tense.PAST,
                    "все деньги персонажу " + human.name));
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
//            System.out.println(new NoMoneyException(this, human));
        }
    }

    public void moveTo(Place newPlace){
        this.place = newPlace;
        System.out.println("Новое местоположение персонажа "+this.name+": "+this.place.name);
    }

    private StringBuilder joinListOfCoins(ArrayList<Money> coins){
        StringBuilder add = new StringBuilder();
        for (Money coin : coins) {
            add.append(", ").append(coin.getValue());
        }
        return add;
    }

    @Override
    public void get(Money money){}


}
