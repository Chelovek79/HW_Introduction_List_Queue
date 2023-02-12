package transport;

import check.Check;
import drivers.DbDrivers;
import drivers.DriverB;

public class PassengerCar<T extends DriverB> extends Transport implements Competing {

    enum CarBody {
        Sedan("седан"),
        Hatchback("хэтчбек"),
        CopeBody("купе"),
        Wagon("универсал"),
        OffRoad("внедорожник"),
        SUV("кроссовер"),
        Pickup("пикап"),
        Van("фургон"),
        MiniVan("минивен"),
        NULL("данные не предоставлены...");

        final String bodyName;

        CarBody(String bodyName) {
            this.bodyName = bodyName;
        }

        @Override
        public String toString() {
            return "Тип кузова - " + CarBody.this.bodyName + ".";
        }
    }

    private double engineVolume;
    CarBody carBody;
    private T driver;
    private final String id = "PassengerCar";

    public PassengerCar(String brand,
                        String model,
                        double engineVolume,
                        CarBody carBody,
                        String category) {
        super(brand, model, category);
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 1.5);
        this.carBody = carBody;
        this.driver = (T) setDriverB(category);
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 1.5);
    }

    public DriverB setDriverB(String category) {
        DbDrivers driverB = new DbDrivers();
        if (category == null || category.isBlank()) {
            return driverB.getDriverB(0);
        } else {
            return driverB.getDriverB((int) (Math.random() * 3));
        }
    }

    public String getId() {
        return id;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    @Override
    public String printType() {
        return getBrand() + " " + getModel() + ". " + carBody;
    }

    @Override
    public String passDiagnostics() {
        return getBrand() + " " + getModel() + " диагностику прошёл.";
    }

    @Override
    public String toString() {
        return super.toString() + ". Объём двигателя " + engineVolume + " " + driver;
    }

    @Override
    public void pit_stop() {
        System.out.println("Пит-стоп...");
    }

    @Override
    public void bestTimeLap(String timeLap) {
        System.out.println("Лучшее время проезда круга " + timeLap);
    }

    @Override
    public void maxSpeed(int speed) {
        System.out.println("Максимальная скорость - " + speed + " км/ч");
    }

    @Override
    public String getFioDriver() {
        return super.getFioDriver() + driver.getFio();
    }
}
