package enums;

public enum Gender {
    MALE(""), FEMALE("а"), MIDDlE("о"), ALL("и");

    private final String ending;
    Gender(String ending) {
        this.ending = ending;
    }

    public String getEnding(){
        return this.ending;
    }

    //public String getEnding() {
    //    return ending;
    //}
}
