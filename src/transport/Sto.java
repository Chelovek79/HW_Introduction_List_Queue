package transport;

import java.util.*;
import static check.Check.*;

public class Sto {

    public Sto() {
    }

    Queue<Transport> sto = new LinkedList<>();
    DbTransport car = new DbTransport();
    int numberTestOnSto = 0;

    public void addingToSto(int numberCar) {
        if (testAvtoToSto(car.participants.get(numberCar).getCategory())) {
            sto.offer(car.participants.get(numberCar));
            System.out.println("Автообиль - " + car.participants.get(numberCar).getBrand() + " " + car.participants.get(numberCar).getModel() +
                    " добавлен на прохождение 'ТО'.");
        } else {
            System.out.println("Автобусы не проходят 'ТО'");
        }
    }

    public void testingOnSto() {
        if (sto.size() != 0) {
            System.out.println(sto.element().passDiagnostics());
            sto.poll();
        } else {
            numberTestOnSto++;
            if (numberTestOnSto == 1) {
                System.out.println("Все автомобили прошли 'ТО'. Список автомобилей пуст.");
            } else System.out.print("");
        }
    }
}
