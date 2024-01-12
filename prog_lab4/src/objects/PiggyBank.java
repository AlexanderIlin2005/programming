package objects;

import enums.Gender;
import enums.Money;
import enums.Tense;
import interfaces.MoneyReceivable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PiggyBank extends BaseObject {
    private final Place place;
    private final String[] properties;
    private final Place placeForRollingCoins;
    private List<Money> coinsList = new ArrayList<>();

    boolean is_open = false;


    public PiggyBank(String name, Gender gender, Place place, Place placeForRollingCoins, String [] properties){
        super(name, gender);
        //super(name, );
        this.place = place;
        this.placeForRollingCoins = placeForRollingCoins;
        this.properties = properties;
        {
            System.out.println("Предмет: " +  this.name);
            createBank();
        }
    }

    public void open(Human human, Knife knife){
        String add = this.name + " используя " + knife.name;
        System.out.println(makeSentence(human, "открыть", Tense.PAST, add));
        this.is_open = true;
    }

//    public Money removeCoin() {
//        Money result = null;
//        try {
//            result = coinsList.get(0);
//            System.out.println();
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Копилка опустошена");
//            return result;
//        }
//        this.coinsList.remove(0);
//        return result;
//    }

    public void makeEmpty(Human human1, Human human2){
        Random random = new Random();
        if (this.is_open){
            for (Money coin : this.coinsList){
                System.out.println("Монета в " + coin + " выкатилась на " + placeForRollingCoins.name);
                if (random.nextInt(2) == 0){
                    human1.get(coin);
                    human1.getMoney(coin);
                } else {
                    human2.get(coin);
                    human2.getMoney(coin);
                }
            }
            this.coinsList.clear();
            System.out.println(human1.name + " и " + human2.name + " опустошили копилку");
        } else {
            System.out.println("Копилка закрыта");
        }
    }

    private void createBank(){
        Random random = new Random();

        int piggyBankLen = random.nextInt(10) + 3;
        for (int i = 0; i < piggyBankLen; i++){
            int n = random.nextInt(3);
            coinsList.add(Money.values()[n]);
        }
        String str = coinsList.toString();
        str = str.substring(1, str.length() - 1);
        System.out.println("Содержание копилки:\n" +
                "- " + String.join("\n- ", str.split(", ")));
    }

    public boolean isEmpty(){
        return this.coinsList.isEmpty();
    }

    @Override
    public String toString(){
        String add = "на " + place.name + ", " + String.join(", ", properties);

        return makeSentence(this, "стоит", Tense.NOW, add);
    }

    public void addMoney(Kid kid, ArrayList<Money> coins){
        this.coinsList.addAll(coins);
    }

}
