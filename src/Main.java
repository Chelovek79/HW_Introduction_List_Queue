import check.TransportTypeException;
import drivers.DbDrivers;
import transport.DbTransport;
import transport.Sto;
import transport.Transport;

public class Main {

    public static void main(String[] args) {

        DbTransport transport = new DbTransport();
        DbDrivers drivers = new DbDrivers();
        Sto s = new Sto();

        transport.getDriverCarName(0, "C"); // Общие сведения и готовность;
        transport.getDriverCarName(2, "D");
        System.out.println(" ");

        transport.getDriverCarName(1, "B");
        drivers.getStartDrivingB(1);
        transport.getDriverBbestLap(1, "5m 36sec");
        drivers.getRefuelB(1);
        Transport.startMoving();
        drivers.getStopB(1);
        System.out.println("Финиш \n");

        transport.printType(2, "B");        // Определение типа авто;
        transport.printType(0, "C");
        transport.printType(3, "D");
        System.out.println(" ");

        try {                                         // Прохождение диагностики;
            transport.testingAvto(0, "B");
            transport.testingAvto(1, "C");
            transport.testingAvto(3, "D");
        } catch (TransportTypeException e) {
//            System.err.println(e + "\n");           // Exception на диагностику "Bus";
        }

        transport.creationtListOfCompetition();       // Лист участников соревнований.
        System.out.println(" ");

        transport.repair(1);                       // Ремонт произведён;
        transport.doingTo(4);                      // "ТО" произведено;
        System.out.println(" ");

        s.addingToSto();                              // Добавляем в очередь на "ТО";
        System.out.println(" ");

        s.testingOnSto();                             // Проходим "ТО" с удалением из списка;
    }
}