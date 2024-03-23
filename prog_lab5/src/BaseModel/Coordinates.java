package BaseModel;

import utility.Validatable;

public class Coordinates implements Validatable {
    private float x; //Значение поля должно быть больше -584
    private float y; // Значение поля должно быть больше -469

    public Coordinates(float x, float у) {
        this.x = x;
        this.y = у;
    }

    public float getX() {
        return x;
    }

    public float getУ() {
        return y;
    }

    @Override
    public boolean validate() {
        return (x > -584) && (y > -469);
    }
}
