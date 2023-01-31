package transport;

import check.Check;
import drivers.DriverC;

public class Trucks<T extends DriverC> extends Transport implements Competing {

    enum LoadCapacity {

        N1(0, 3.5f),
        N2(3.5f, 12f),
        N3(12f, 100f),
        NULL(0f, 0f);

        final float from;
        final float to;

        LoadCapacity(float from, float to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {

            if (this.from == 0 && this.to == 0) {
                return "Грузоподъёмность не установлена...";
            }
            if (this.from == 0 && this.to != 0) {
                return "Грузопдъёмность: <= " + this.to + "т.";
            } else {
                if (this.to == 100) {
                    return "Грузоподъёмность: > " + this.from + "т.";
                } else {
                    return "Грузоподъёмность: 3.5т < x <= 12т";
                }
            }
        }
    }

    private double engineVolume;
    private LoadCapacity loadCapacity;
    private T driver;

    public Trucks(String brand, String model, double engineVolume, String loadCapacity, T driver) {
        super(brand, model);
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 10.0);
        this.loadCapacity = LoadCapacity.valueOf(Check.checkingType(loadCapacity));
        this.driver = driver;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Check.checkingEngineVolume(engineVolume, 10.0);
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    @Override
    public String printType() {
        return getBrand() + " " + getModel() + ". " + loadCapacity;
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
