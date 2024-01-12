import enums.Gender;
import enums.Money;
import exceptions.UnableToMakePurchaseException;
import objects.*;
import objects.PiggyBank;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws UnableToMakePurchaseException {
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

        carlson.lookAtWithHope(malish);
        malish.stoodConfused();

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
        malish.thinkAboutFlying(roof);


        System.out.println("----------------Вывод ошибок-------------------");
        carlson.giveAllMoney(malish);
        malish.buySweetsForAllMoney(shop);
    }
}

