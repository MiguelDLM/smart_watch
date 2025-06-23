package jxl.biff.drawing;

/* loaded from: classes6.dex */
public class DrawingDataException extends RuntimeException {
    private static String message = "Drawing number exceeds available SpContainers";

    public DrawingDataException() {
        super(message);
    }
}
