package exceptions;

public class JsonParsingException extends RuntimeException {

    private final String message;

    public JsonParsingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
