package objects;

import enums.Gender;
import enums.Money;
import enums.Product;
import exceptions.UnableToMakePurchaseException;

import java.util.ArrayList;

public class Shop extends Place {
    final Human salesman;

    public Shop(String name, Gender gender, Human salesman) {
        super(name, gender);
        this.salesman=salesman;
        {
            System.out.println("Ассортимент магазина " + "'" + this.name + "':");
            System.out.println(Product.LOLLIPOPS + ", " + Product.SUGARED_NUT + " и " + Product.CHOCOLATE);
        }
    }

    public void buy(Human human, ArrayList<Money> coins) throws UnableToMakePurchaseException {
        if (human.place == this) {
            human.giveMoney(coins, salesman);
        } else throw new UnableToMakePurchaseException(human, this);

    }
}
