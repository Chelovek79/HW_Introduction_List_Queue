package check;

public class TransportTypeException extends Exception {

    String message;

    public TransportTypeException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
