package transport;

import java.util.LinkedList;
import java.util.Queue;

public class Sto {

    public Sto() {
    }

    Queue<Transport> sto = new LinkedList<>();

    public void addingToSto() {
        DbTransport a = new DbTransport();
        for (int i = 0; i < a.participants.size(); i++) {
            if (a.enteringCarToSto(i)) {
                sto.offer(a.participants.get(i));
                System.out.println("Автомобиль : " + a.participants.get(i).getBrand() + " " +
                        a.participants.get(i).getModel() + " - добавлен в очередь на 'ТО'.");
            }
        }
    }

    public void testingOnSto() {
        int h = sto.size();
        for (int i = 0; i < h; i++) {
            System.out.println(sto.element().getBrand() + " " + sto.element().getModel() +
                    " - документы о пройденном 'ТО' готовы.");
            sto.remove();
        }
    }
}
