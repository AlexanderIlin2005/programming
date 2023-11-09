package custom.pokemons;

import custom.moves.Agility;
import custom.moves.Peck;
import custom.moves.Swagger;
import custom.moves.Thunder;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Zapdos extends Pokemon {
    public Zapdos(String name, int level){
        super(name, level);
        this.setType(Type.ELECTRIC, Type.FLYING);
        this.setStats(90, 90, 85, 125, 90, 100);
        this.setMove(new Agility(), new Swagger(), new Peck(), new Thunder());
    }
}
