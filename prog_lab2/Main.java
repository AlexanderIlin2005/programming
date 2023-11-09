import ru.ifmo.se.pokemon.*;
import custom.pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle customBattle = new Battle();
        Hariyama har1 = new Hariyama("1", 100);
        Makuhita mak1 = new Makuhita("1", 100);
        Politoed pd1 = new Politoed("1", 100);
        Poliwag pg1 = new Poliwag("1", 100);
        Poliwhirl pl1 = new Poliwhirl("1", 100);
        Zapdos z1 = new Zapdos("1", 100);

        customBattle.addAlly(har1);
        customBattle.addAlly(mak1);
        customBattle.addAlly(pd1);
        customBattle.addAlly(pg1);
        customBattle.addAlly(pl1);
        customBattle.addAlly(z1);


        Poliwag pg2 = new Poliwag("2", 100);
        Poliwhirl pl2 = new Poliwhirl("2", 100);
        Zapdos z2 = new Zapdos("2", 100);
        Makuhita mak2 = new Makuhita("2", 100);
        Politoed pd2 = new Politoed("2", 100);
        Hariyama har2 = new Hariyama("2", 100);


        customBattle.addFoe(pg2);
        customBattle.addFoe(pl2);
        customBattle.addFoe(z2);
        customBattle.addFoe(mak2);
        customBattle.addFoe(pd2);
        customBattle.addFoe(har2);

        customBattle.go();
    }
}
