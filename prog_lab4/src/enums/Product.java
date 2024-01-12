package enums;

public enum Product {
    LOLLIPOPS("леденцы"),
    SUGARED_NUT("засахаренные орешки"),
    CHOCOLATE("шоколад");

    private final String value;

    Product(String value) {
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
