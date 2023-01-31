package check;

public class Check {

    public static String checkingString(String value, String otherValue) {
        if (value == null || value.isBlank()) {
            return otherValue;
        } else {
            return value;
        }
    }
    public static double checkingEngineVolume(double value, double otherValue) {
        if (value <= 0) {
            return otherValue;
        } else {
            return value;
        }
    }
    public static String checkingType(String type) {
        if (type == null || type.isBlank()) {
            return "NULL";
        } else {
            return type;
        }
    }
}
