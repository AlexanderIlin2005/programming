package custom.moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;

public class BodySlam extends PhysicalMove {
    public BodySlam(){
        super(Type.NORMAL, 85, 100);
    }
    double chance = Math.random();
    String add = "";
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        if (chance <= 0.3) {
            Effect.paralyze(pokemon);
            add = ", пытаясь парализовать оппонента";
        }
    }

    @Override
    protected String describe(){
        return "использует Body Slam" + add;
    }
}
// множественное наследование
// то, что через @ пишется
