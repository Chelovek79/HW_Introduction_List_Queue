package transport;

public class Mechanic {

    private String mechanicName;
    private String company;

    public Mechanic(String mechanicName, String company) {
        this.mechanicName = mechanicName;
        this.company = company;
    }

    public Mechanic() {
    }

    public String doingTO() {
        return "ТО произведено.";
    }

    public String repairCar() {
        return "Ремонт произведён.";
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Механик " + mechanicName + " - " + company;
    }
}
