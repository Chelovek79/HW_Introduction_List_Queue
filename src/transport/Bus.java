package transport;

import check.Check;
import drivers.DbDrivers;
import drivers.DriverD;

public class Bus<T extends DriverD> extends Transport implements Competing {

    enum NumberOfSeats {
        EspeciallySmall(0, 10),
        Small(10, 25),
        Average(25, 50),
        Large(50, 80),
        EspeciallyLarge(80, 120),
        NULL(0, 0);

        final int from;
        final int to;

        NumberOfSeats(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {

            if (this.from == 0 && this.to == 0) {
                return "Вместимость автобуса не определена...";
            }
            if (this.from == 0 && this.to != 0) {
                return "Вместимость автобуса: <= 10 мест.";
            } else {
                return "Вместимость автобуса: от " + this.from + " до " + this.to + " мест.";
            }
        }
    }

    private double engineVolume;
    private NumberOfSeats numberOfSeats;
    private T driver;
    private final String id = "Bus";

    public Bus(String brand,
               String model,
               double engineVolume,
               String seats,
               String category) {
        super(brand, model, category);
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 5.0);
        this.numberOfSeats = NumberOfSeats.valueOf(Check.checkingType(seats));
        this.driver = (T) setDriverD(category);
    }

    public DriverD setDriverD(String category) {
        DbDrivers driverD = new DbDrivers();
        if (category == null || category.isBlank()) {
            return driverD.getDriverD(0);
        } else {
            return driverD.getDriverD((int) (Math.random() * 3));
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 5.0);
    }

    @Override
    public String getId() {
        return id;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    @Override
    public String printType() {
        return getBrand() + " " + getModel() + ". " + numberOfSeats;
    }

    @Override
    public String passDiagnostics() {
        return null;
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
    public void bestTimeLap(String timelap) {
        System.out.println("Лучшее время проезда круга " + timelap);
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
