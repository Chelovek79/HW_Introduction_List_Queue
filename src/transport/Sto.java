package transport;

import check.EnteringNumberToSto;

import java.util.*;

public class Sto {

    public Sto() {
    }

    Queue<Transport> sto = new LinkedList<>();

    public void addingToSto() throws EnteringNumberToSto {
        DbTransport a = new DbTransport();
        int countCarAddSto = 0;
        System.out.println("Укажите из списка какой автотранспорт требует прохождения 'ТО'.");
        for (int i = 0; i < a.participants.size(); i++) {
            if (a.enteringCarToSto(i)) {
                countCarAddSto++;
                System.out.println((i + 1) + ". " + a.participants.get(i).getBrand() + " " + a.participants.get(i).getModel());
            }
        }
        System.out.println("(укажите номера интересующей Вас техники без пробелов и запятых)");
        Scanner in = new Scanner(System.in);
        Deque<Integer> queueCars = new ArrayDeque<>();
        if (in.hasNextInt()) {
            int numCars = in.nextInt();
            while (numCars > 0) {
                int number = numCars % 10;
                if (number <= countCarAddSto) {
                    queueCars.addFirst(number);
                    numCars = numCars / 10;
                } else {
                    throw new EnteringNumberToSto("Ошибка. Указан номер несуществующего транспорта...");
                }
            }
        } else {
            throw new EnteringNumberToSto("Ошибка ввода номеров траспорта...");
        }
        int sizequeueCars = queueCars.size();
        for (int i = 0; i < sizequeueCars; i++) {
            sto.offer(a.participants.get(queueCars.pollFirst() - 1));
        }
    }

    public void testingOnSto() {
        int sizeListSto = sto.size();
        for (int i = 0; i < sizeListSto; i++) {
            System.out.println(sto.element().getBrand() + " " + sto.element().getModel() +
                    " - документы о пройденном 'ТО' готовы.");
            sto.remove();
        }
    }
}
