package custom.pokemons;


import custom.moves.BodySlam;
import custom.moves.DoubleTeam;
import custom.moves.StoneEdge;
import custom.moves.Waterfall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwhirl extends Poliwag {
    public Poliwhirl(String name, int level){
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(65, 65, 65, 50, 50, 90);
        //this.setMove(new DoubleTeam(), new Waterfall(), new BodySlam());
        this.addMove(new BodySlam());
    }
}
