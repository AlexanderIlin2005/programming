package custom.pokemons;

import custom.moves.BodySlam;
import custom.moves.DoubleTeam;
import custom.moves.HyperVoice;
import custom.moves.Waterfall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Politoed extends Poliwhirl {
    public Politoed(String name, int level){
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(90, 75, 75, 90, 100, 70);
        //this.setMove(new DoubleTeam(), new Waterfall(), new BodySlam(), new HyperVoice());
        this.addMove(new HyperVoice());
    }
}
