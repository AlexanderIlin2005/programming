import enums.Gender;
import enums.Money;
import enums.Mood;
import enums.Product;
import exceptions.UnableToMakePurchaseException;
import exceptions.cannotSetPriceException;
import objects.*;
import objects.PiggyBank;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws UnableToMakePurchaseException, cannotSetPriceException {
        Place kitchen = new Place("Кухня", Gender.FEMALE);
        Place bookshelf = new Place("Книжная полка", Gender.FEMALE);
        Place home = new Place("Дом", Gender.FEMALE);
        Place diningRoom = new Place("Столовая", Gender.FEMALE);
        Place desk = new Place("Стол", Gender.MALE);
        Place room = new Place("Комната Малыша", Gender.FEMALE);
        Place roof = new Place("Крыша", Gender.FEMALE);
        Vase vase = new Vase("Вазочка", Gender.FEMALE);

        Knife knife = new Knife("Нож", kitchen);
        String [] piggyBankProperties = new String[]{"прекрасная", "тяжелая"};
        PiggyBank piggyBank = new PiggyBank("Копилка", Gender.FEMALE,
                bookshelf, desk, piggyBankProperties);

        Karlson carlson = new Karlson("Карлсон", Gender.MALE);
        Kid malish = new Kid("Малыш", Gender.MALE);
        Human salesman = new Human("Продавец", Gender.MALE);

        Human mother = new Human("Мама", Gender.FEMALE);
        Human father = new Human("Папа", Gender.MALE);
        Human betan = new Human("Бетан", Gender.FEMALE);
        Human bosse = new Human("Боссе", Gender.MALE);
        Family family = new Family("Семья",
                new ArrayList<>(Arrays.asList(mother, father, betan, bosse)));

        Shop shop = new Shop("Соседняя лавка", Gender.FEMALE, salesman);
        shop.getAccessToStock().addProduct(Product.CHOCOLATE, Money.FIVE);
        shop.getAccessToStock().addProduct(Product.LOLLIPOPS, Money.TEN);
        shop.getAccessToStock().addProduct(Product.SUGARED_NUT, Money.TWENTY_FIVE);
        //shop.getAccessToStock().removeProduct(Product.CHOCOLATE);
        //shop.getAccessToStock().removeProduct(Product.LOLLIPOPS);
        //shop.getAccessToStock().addProduct(Product.LOLLIPOPS, Money.TEN);
        //shop.getAccessToStock().addProduct(Product.CHOCOLATE, Money.FIVE);
        //shop.getAccessToStock().setPrice(Product.SUGARED_NUT, Money.TWENTY_FIVE);


        carlson.setMood(Mood.HOPEFUL);
        carlson.lookAt(malish);

        malish.setMood(Mood.CONFUSED);
        malish.stood();

        malish.becomeMotherTo(carlson, piggyBank);
        System.out.println(piggyBank);
        malish.moveTo(kitchen);
        knife.moveTo(malish, bookshelf);
        malish.moveTo(home);
        piggyBank.open(malish, knife);
        piggyBank.makeEmpty(malish, carlson);
        carlson.giveAllMoney(malish);
        malish.becomeMotherTo(carlson);

        System.out.println("\n------------------Добавленное------------------\n");

        malish.saveToPiggyBank(piggyBank);
        malish.moveTo(shop);
        malish.buySweetsForAllMoney(shop);
        malish.moveTo(home);

        family.moveAllMembersTo(diningRoom);
        family.drinkCoffeeAfterDinner();
        malish.noTimeToSpendWith(family);
        String reason = family.preventFromGoing(malish, carlson, roof);
        malish.toMeetFamilyWithCarlson(carlson, family, reason, roof);
        carlson.sayHeWantsCookies(malish);
        malish.takeSomeCookies(vase);
        malish.moveTo(room);
        carlson.calmDown(malish);
        carlson.setMood(Mood.EXCITED);
        malish.thinkAboutFlying(roof);


        //System.out.println("----------------Вывод ошибок-------------------");
        //carlson.giveAllMoney(malish);
        //malish.buySweetsForAllMoney(shop);
    }
}

