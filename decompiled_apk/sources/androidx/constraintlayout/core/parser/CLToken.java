package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = "null".toCharArray();
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

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (CLParser.sDebug) {
            return "<" + content() + ">";
        }
        return content();
    }

    public boolean validate(char c, long j) {
        int ordinal = this.mType.ordinal();
        boolean z = false;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        char[] cArr = this.mTokenNull;
                        int i = this.mIndex;
                        if (cArr[i] == c) {
                            z = true;
                        }
                        if (z && i + 1 == cArr.length) {
                            setEnd(j);
                        }
                    }
                } else {
                    char[] cArr2 = this.mTokenFalse;
                    int i2 = this.mIndex;
                    if (cArr2[i2] == c) {
                        z = true;
                    }
                    if (z && i2 + 1 == cArr2.length) {
                        setEnd(j);
                    }
                }
            } else {
                char[] cArr3 = this.mTokenTrue;
                int i3 = this.mIndex;
                if (cArr3[i3] == c) {
                    z = true;
                }
                if (z && i3 + 1 == cArr3.length) {
                    setEnd(j);
                }
            }
        } else {
            char[] cArr4 = this.mTokenTrue;
            int i4 = this.mIndex;
            if (cArr4[i4] == c) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i4] == c) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i4] == c) {
                this.mType = Type.NULL;
            }
            z = true;
        }
        this.mIndex++;
        return z;
    }
}
