package practice.javaprogramming.navi;

public class OpernationNotAllowed extends Exception {
    private String message;

    OpernationNotAllowed(String message) {
        this.message = message;
    }
}
