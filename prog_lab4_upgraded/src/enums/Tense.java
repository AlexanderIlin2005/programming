package enums;

public enum Tense {
    NOW("", ""),
    FUTURE(" хочет ", "ть"),
    PAST("", "л");

    private final String start;
    private final String ending;


    Tense(String start, String ending) {
        this.ending = ending;
        this.start = start;
    }

    @Override
    public String toString() {
        return this.start + "глагол" +  this.ending;
    }

    public String getStart(){
        return this.start;
    }

    public String getEnding(){
        return this.ending;
    }

}
