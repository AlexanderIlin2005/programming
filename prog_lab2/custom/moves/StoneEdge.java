package custom.moves;

import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge(){
        super(Type.ROCK, 100, 80);
    }

    @Override
    protected String describe(){
        return "использует Stone Edge";
    }

    @Override
    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        return super.calcCriticalHit(var1, var2) * 3;
    }
}


