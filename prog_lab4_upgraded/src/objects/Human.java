package objects;


import enums.*;
import exceptions.NoMoneyException;
import interfaces.MoneyReceivable;

import java.util.ArrayList;

public class Human extends BaseObject implements MoneyReceivable {
    Place place;
    private ArrayList<Product> products = new ArrayList<>();
    private Mood mood = Mood.NORMAL;
    protected ArrayList<Money> wallet;
    public Human(String name, Gender gender) {
        super(name, gender);
        {
            System.out.println("Персонаж типа "+this.getClass().getName() + " " + this.getName() + " создан");
        }
        this.wallet = new ArrayList<>();
        this.place = null;
    }

    public Mood getMood(){
        return this.mood;
    }

    public void setMood(Mood newMood){
        if (!newMood.equals(this.getMood())) {
            System.out.println("Настроение " + this.getName() + " изменено:" + newMood.getDecription());
        }
        this.mood = newMood;
    }

    @Override
    public void getMoney(Money coin){
        //System.out.println(makeSentence(this, "получить", Tense.PAST,
        //        "монету в "+coin));
        this.wallet.add(coin);
    }

    @Override
    public void getMoney(ArrayList<Money> coins){
            StringBuilder add = joinListOfCoins(coins);
            //System.out.println(makeSentence(this, "получить", Tense.PAST,
            //        "монеты: " + add));
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
                    "все деньги персонажу " + human.getName()));
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
//            System.out.println(new NoMoneyException(this, human));
        }
    }

    public void moveTo(Place newPlace){
        this.place = newPlace;
        System.out.println("Новое местоположение персонажа "+ this.getName() +": "+ this.place.getName());
    }

    private StringBuilder joinListOfCoins(ArrayList<Money> coins){
        StringBuilder add = new StringBuilder();
        for (Money coin : coins) {
            add.append(", ").append(coin.getValue());
        }
        return add;
    }

    public void receiveProduct(Product product){
        this.products.add(product);
        System.out.println(makeSentence(this, "получить", Tense.PAST, "товар: "+product));
    }

    public int getWalletSize(){
        return this.wallet.size();
    }
    @Override
    public void get(Money money){}


}
