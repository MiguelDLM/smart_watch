package androidx.constraintlayout.core.parser;

public class CLToken extends CLElement {
    int mIndex = 0;
    char[] mTokenFalse = "false".toCharArray();
    char[] mTokenNull = "null".toCharArray();
    char[] mTokenTrue = "true".toCharArray();
    Type mType = Type.UNKNOWN;

    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    public String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c, long j) {
        int ordinal = this.mType.ordinal();
        boolean z = false;
        if (ordinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i = this.mIndex;
            if (cArr[i] == c) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i] == c) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i] == c) {
                this.mType = Type.NULL;
            }
            z = true;
        } else if (ordinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i2 = this.mIndex;
            if (cArr2[i2] == c) {
                z = true;
            }
            if (z && i2 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (ordinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i3 = this.mIndex;
            if (cArr3[i3] == c) {
                z = true;
            }
            if (z && i3 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (ordinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i4 = this.mIndex;
            if (cArr4[i4] == c) {
                z = true;
            }
            if (z && i4 + 1 == cArr4.length) {
                setEnd(j);
            }
        }
        this.mIndex++;
        return z;
    }
}
