package transport;

import check.TransportTypeException;
import drivers.DbDrivers;

public class DbTransport {

    DbDrivers dbDrivers = new DbDrivers();

    PassengerCar<?>[] smallcar = {new PassengerCar<>("Toyota", "Chaser", 3.0, PassengerCar.CarBody.Sedan, dbDrivers.getDriverB(0)),
            new PassengerCar<>("BMW", "750iL", 5.4, PassengerCar.CarBody.Sedan, dbDrivers.getDriverB(2)),
            new PassengerCar<>(" ", "Калина", 1.5, PassengerCar.CarBody.NULL, dbDrivers.getDriverB(1)),
            new PassengerCar<>("ЗАЗ", "1.2 MT 968M", 1.2, PassengerCar.CarBody.OffRoad, dbDrivers.getDriverB(0))};

    Trucks<?>[] trucks = {new Trucks<>("КамАЗ", "43118", 10.85, "N3", dbDrivers.getDriverC(1)),
            new Trucks<>("ЗИЛ", "131", 6.96, null, dbDrivers.getDriverC(0)),
            new Trucks<>("Урал", null, 6.6, "N2", dbDrivers.getDriverC(2)),
            new Trucks<>("ГАЗ", "66", 0, "N1", dbDrivers.getDriverC(1))};

    Bus<?>[] buses = {new Bus<>("Ikarus", "250 SL", 10.4, "Large", dbDrivers.getDriverD(1)),
            new Bus<>("ЛиАЗ", "677", 6.96, null, dbDrivers.getDriverD(0)),
            new Bus<>("ЛАЗ", "695Н", 6.0, "Average", dbDrivers.getDriverD(2)),
            new Bus<>("VolgaBus", "Серпантин-10", 8.4, "Average", dbDrivers.getDriverD(2))};


    public void getDriverCarName(int i, String classCar) {
        switch (classCar) {
            case "B":
                System.out.println("Водитель " + dbDrivers.getNameDriverB(i) + " управляет автомобилем " + smallcar[i].getBrand()
                        + " " + smallcar[i].getModel() + " и будет участвовать в заезде 'легковых машин'.");
                break;
            case "C":
                System.out.println("Водитель " + dbDrivers.getNameDriverC(i) + " управляет автомобилем " + trucks[i].getBrand()
                        + " " + trucks[i].getModel() + " и будет участвовать в заезде 'грузовых машин'.");
                break;
            case "D":
                System.out.println("Водитель " + dbDrivers.getNameDriverD(i) + " управляет автобусом " + buses[i].getBrand()
                        + " " + buses[i].getModel() + " и будет участвовать в заезде 'автобусов'.");
                break;
        }
    }

    public void getDriverBbestLap(int i, String time) {
        System.out.print(dbDrivers.getNameDriverB(i) + " ");
        smallcar[i].bestTimeLap(time);
    }

    public void printType(int i, String classCar) {
        switch (classCar) {
            case "B":
                System.out.println(smallcar[i].printType());
                break;
            case "C":
                System.out.println(trucks[i].printType());
                break;
            case "D":
                System.out.println(buses[i].printType());
        }
    }

    public void testingAvto(int i, String classCar) throws TransportTypeException {
        switch (classCar) {
            case "B":
                System.out.println(smallcar[i].passDiagnostics());
                break;
            case "C":
                System.out.println(trucks[i].passDiagnostics());
                break;
            case "D":
                throw new TransportTypeException("'Автобусы' диагностику не проходят...");
        }

    }
}
