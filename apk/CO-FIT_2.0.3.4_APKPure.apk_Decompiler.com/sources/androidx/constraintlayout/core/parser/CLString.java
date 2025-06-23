package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;

public class CLString extends CLElement {
    public CLString(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLString(cArr);
    }

    @NonNull
    public static CLString from(@NonNull String str) {
        CLString cLString = new CLString(str.toCharArray());
        cLString.setStart(0);
        cLString.setEnd((long) (str.length() - 1));
        return cLString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLString) || !content().equals(((CLString) obj).content())) {
            return super.equals(obj);
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append("'");
        sb.append(content());
        sb.append("'");
        return sb.toString();
    }

    public String toJSON() {
        return "'" + content() + "'";
    }
}
