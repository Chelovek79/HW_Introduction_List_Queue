package drivers;

public class DriverC extends Driver {

    public DriverC(String fio, boolean driversLicense, double workExperience) {
        super(fio, driversLicense, workExperience);
    }

    @Override
    public void startDriving() {
        System.out.println("Тронулись...");
    }

    @Override
    public void stopDriving() {
        System.out.println("Докатились...");
    }

    @Override
    public void refuel() {
        System.out.println("Заливаю топливо...");
    }

    @Override
    public String toString() {
        return super.toString() + " Категория - 'C'." ;
    }
}
