package transport;

import check.Check;

public abstract class Transport {

    private final String brand;
    private final String model;

    public Transport(String brand, String model) {
        this.brand = Check.checkingString(brand, "Самоделка");
        this.model = Check.checkingString(model, "1");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public static void startMoving() {
        System.out.println("Поехали ;)");
    }

    public static void stopMoving() {
        System.out.println("Тпруу... ;)");
    }

    public abstract String printType();

    public abstract String passDiagnostics ();

    @Override
    public String toString() {
        return brand + " " + model;
    }

}
