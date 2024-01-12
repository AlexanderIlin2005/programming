package enums;

public enum Mood {
    NORMAL(""),
    HOPEFUL("с надеждой"),
    CONFUSED("растерянный"),
    ENTHUSIASTIC("с усердием"),
    PLEASED("ликующе"),
    VERY_HAPPY("особенно порадован"),
    HARD_BREATHE("тяжело дыша"),
    EXCITED("в удовольствии");


    private final String description;

    Mood(String description) {
        this.description = description;
    }

    public String getDecription(){
        return this.description;
    }
}
