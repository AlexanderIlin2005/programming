package exceptions;

import objects.Human;
import objects.Shop;

public class UnableToMakePurchaseException extends Exception{
    private final Human human;
    private final Shop shop;

    public UnableToMakePurchaseException(Human human, Shop shop){
        this.human = human;
        this.shop = shop;
    }
    @Override
    public String toString() {
        return this.human.getName() + " не находится в магазине " + this.shop.getName() + ", покупка невозможна";
    }
}
