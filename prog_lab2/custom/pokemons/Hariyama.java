package custom.pokemons;

import custom.moves.BulkUp;
import custom.moves.Confide;
import custom.moves.StoneEdge;
import custom.moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Hariyama extends Makuhita {
    public Hariyama(String name, int level){
        super(name, level);
        this.setType(Type.FIGHTING);
        this.setStats(144, 120, 60, 40, 60, 50);
        // this.setMove(new Swagger(), new Confide(), new BulkUp(), new StoneEdge());
        this.addMove(new StoneEdge());
    }
}
