package exceptions;

import objects.Human;

public class NoMoneyException extends IndexOutOfBoundsException{
    private final Human h1;
    private final Human h2;

    public NoMoneyException(Human h1, Human h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public String toString() {
        return this.h1.name + " не имеет денег чтобы отдать их "+h2.name;
    }
}
