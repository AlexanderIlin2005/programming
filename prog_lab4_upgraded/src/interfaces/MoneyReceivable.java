package interfaces;

import enums.Money;
import objects.Human;

import java.util.ArrayList;

public interface MoneyReceivable {
    public void get(Money money);
    public void getMoney(Money coin);
    public void getMoney(ArrayList<Money> coins);
    public void giveMoney(Money coin, Human human);
    public void giveMoney(ArrayList<Money> coins, Human human);
    public void giveAllMoney(Human human);
}
