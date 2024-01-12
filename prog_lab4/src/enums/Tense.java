package enums;

public enum Tense {
    NOW("", ""),
    FUTURE(" хочет ", "ть"),
    PAST("", "л");

    public final String start;
    public final String ending;


    Tense(String start, String ending) {
        this.ending = ending;
        this.start = start;
    }

    @Override
    public String toString() {
        return this.start + "глагол" +  this.ending;
    }

}
