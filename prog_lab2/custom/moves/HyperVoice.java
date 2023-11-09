package custom.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class HyperVoice extends SpecialMove {
    public HyperVoice(){
        super(Type.NORMAL, 90, 100);
    }

    @Override
    protected String describe(){
        return "использует Hyper Voice";
    }
}
