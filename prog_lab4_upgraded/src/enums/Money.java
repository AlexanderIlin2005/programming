package enums;

public enum Money {
    FIVE("пять эре"),
    TEN("десять эрэ"),
    TWENTY_FIVE("двадцать пять эре");

    private final String value;

    Money(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}