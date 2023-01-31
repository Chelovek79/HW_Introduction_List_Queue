package drivers;

public class DriverB extends Driver {

    public DriverB (String fio, boolean driversLicense, double workExperience) {
        super(fio, driversLicense, workExperience);
    }

    @Override
    public void startDriving() {
        System.out.println("Он сказал поехали и махнул рукой...");
    }

    @Override
    public void stopDriving() {
        System.out.println("Стоп. Приехали...");
    }

    @Override
    public void refuel() {
        System.out.println("Заправляем...");
    }

    @Override
    public String toString() {
        return super.toString() + " Категория - 'B'." ;
    }


}
