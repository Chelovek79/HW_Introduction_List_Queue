package transport;

import check.TransportTypeException;
import drivers.DbDrivers;

import java.util.*;

public class DbTransport {

    DbDrivers dbDrivers = new DbDrivers();

    PassengerCar<?>[] smallcar = {new PassengerCar<>("Toyota", "Chaser", 3.0, PassengerCar.CarBody.Sedan, "B"),
            new PassengerCar<>("BMW", "750iL", 5.4, PassengerCar.CarBody.Sedan, "B"),
            new PassengerCar<>(" ", "Калина", 1.5, PassengerCar.CarBody.NULL, "B"),
            new PassengerCar<>("ЗАЗ", "1.2 MT 968M", 1.2, PassengerCar.CarBody.OffRoad, "B")};

    Trucks<?>[] trucks = {new Trucks<>("КамАЗ", "43118", 10.85, "N3", "C"),
            new Trucks<>("ЗИЛ", "131", 6.96, null, "C"),
            new Trucks<>("Урал", null, 6.6, "N2", "C"),
            new Trucks<>("ГАЗ", "66", 0, "N1", "C")};

    Bus<?>[] buses = {new Bus<>("Ikarus", "250 SL", 10.4, "Large", "D"),
            new Bus<>("ЛиАЗ", "677", 6.96, null, "D"),
            new Bus<>("ЛАЗ", "695Н", 6.0, "Average", "D"),
            new Bus<>("VolgaBus", "Серпантин-10", 8.4, "Average", "D")};

    public List<Transport> participants = new ArrayList<>();

    {
        participants.addAll(Arrays.asList(smallcar).subList(0, 4));
        participants.addAll(Arrays.asList(trucks).subList(0, 4));
        participants.addAll(Arrays.asList(buses).subList(0, 4));
    }

    public void creationtListOfCompetition() {
        System.out.println("\n Участники соревнований: \n");
        for (Transport participant : participants) {
            System.out.println(participant.getBrand() + " " + participant.getModel() + ". " +
                    participant.getFioDriver() + " " + participant.getMechanic());
        }
    }

    public void repair(int i) {
        System.out.println("Авто - " + participants.get(i).getBrand() + ". " + participants.get(i).mechanicRepairCar() +
                " " + participants.get(i).getMechanic());
    }

    public void doingTo(int i) {
        System.out.println("Авто - " + participants.get(i).getBrand() + ". " + participants.get(i).mechanicToDoing() +
                " " + participants.get(i).getMechanic());
    }

    public void getDriverCarName(int i, String classCar) {
        switch (classCar) {
            case "B":
                System.out.println(smallcar[i].getFioDriver() + " управляет автомобилем " + smallcar[i].getBrand()
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
