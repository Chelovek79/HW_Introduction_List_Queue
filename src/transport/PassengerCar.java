package transport;

import check.Check;
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

    public PassengerCar(String brand, String model, double engineVolume, CarBody carBody, T driver) {
        super(brand, model);
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 1.5);
        this.carBody = carBody;
        this.driver = driver;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 1.5);
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
}
