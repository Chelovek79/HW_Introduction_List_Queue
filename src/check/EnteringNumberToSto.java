package check;

public class EnteringNumberToSto extends Exception{

    String message;

    public EnteringNumberToSto(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
