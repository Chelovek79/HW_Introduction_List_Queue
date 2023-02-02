package transport;

import check.Check;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Transport<T extends Mechanic> {

    private final String brand;
    private final String model;
    private final T mechanic;

    public Transport(String brand, String model, T mechanic) {
        this.brand = Check.checkingString(brand, "Самоделка");
        this.model = Check.checkingString(model, "1");
        this.mechanic = mechanic;
    }

    static List<Mechanic> mechanics = new ArrayList<>(Arrays.asList(
            new Mechanic("Cидоров Иван", "Таксопарк №3"),
            new Mechanic("Фролов Никита", "Гаражный кооператив 'Орбита'"),
            new Mechanic("Север Илья", "на все руки ...")));

    public static void addingMechanics(String name, String company) {
        Mechanic newMechanic = new Mechanic();
        newMechanic.setMechanicName(name);
        newMechanic.setCompany(company);
        mechanics.add(newMechanic);
    }

    public static int RndMechanic() {
        return (int) (Math.random() * (mechanics.size()));
    }

    public String getMechanic() {
        return mechanic.toString();
    }

    public String mechanicRepairCar() {
        return mechanic.repairCar();
    }

    public String mechanicToDoing() {
        return mechanic.doingTO();
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

    public abstract String passDiagnostics();

    @Override
    public String toString() {
        return brand + " " + model + " " + mechanic;
    }

    public String getFioDriver() {
        return "Водитель ";
    }
}
