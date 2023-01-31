package drivers;

public class Driver {

    private final String fio;
    private boolean driversLicense;
    private double workExperience;


    public Driver(String fio, boolean driversLicense, double workExperience) {
        this.fio = fio;
        this.driversLicense = driversLicense;
        this.workExperience = workExperience;
    }

    public void startDriving() {}
    public void stopDriving() {}
    public void refuel() {}

    public String getFio() {
        return fio;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return fio + " Водительский стаж " + workExperience + ".";
    }
}
