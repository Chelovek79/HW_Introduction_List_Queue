package drivers;

public class DriverD extends Driver {

    public DriverD(String fio, boolean driversLicense, double workExperience) {
        super(fio, driversLicense, workExperience);
    }

    @Override
    public void startDriving() {
        System.out.println("Полетели...");
    }

    @Override
    public void stopDriving() {
        System.out.println("Остановка...");
    }

    @Override
    public void refuel() {
        System.out.println("Заправка...");
    }

    @Override
    public String toString() {
        return super.toString() + " Категория - 'D'." ;
    }
}
