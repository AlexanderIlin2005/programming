package custom.moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Peck extends PhysicalMove {
    public Peck(){
        super(Type.FLYING, 35, 100);
    }

    @Override
    protected String describe(){
        return "использует Peck";
    }
}
