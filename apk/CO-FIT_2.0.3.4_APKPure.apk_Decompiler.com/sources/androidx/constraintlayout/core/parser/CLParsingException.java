package androidx.constraintlayout.core.parser;

import XXO0.oIX0oI;

public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, CLElement cLElement) {
        super(str);
        this.mReason = str;
        if (cLElement != null) {
            this.mElementClass = cLElement.getStrClass();
            this.mLineNumber = cLElement.getLine();
            return;
        }
        this.mElementClass = "unknown";
        this.mLineNumber = 0;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + oIX0oI.I0Io.f17331I0Io;
    }

    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
