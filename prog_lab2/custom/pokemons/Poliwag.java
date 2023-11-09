package custom.pokemons;


import custom.moves.DoubleTeam;
import custom.moves.Waterfall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int level){
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(40, 50, 40, 40, 40, 90);
        this.setMove(new DoubleTeam(), new Waterfall());
    }
}
