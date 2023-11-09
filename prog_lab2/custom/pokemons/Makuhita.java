package custom.pokemons;


import custom.moves.BulkUp;
import custom.moves.Confide;
import custom.moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Makuhita extends Pokemon {
    public Makuhita(String name, int level){
        super(name, level);
        this.setType(Type.FIGHTING);
        this.setStats(72, 60, 30, 20, 30, 25);
        this.setMove(new Swagger(), new Confide(), new BulkUp());
    }
}
