package enums;

public enum Gender {
    MALE(""), FEMALE("а"), MIDDlE("о"), ALL("и");

    public final String ending;
    Gender(String ending) {
        this.ending = ending;
    }

    //public String getEnding() {
    //    return ending;
    //}
}
