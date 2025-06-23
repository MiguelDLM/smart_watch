package androidx.constraintlayout.core.parser;

public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLNumber)) {
            return false;
        }
        float f = getFloat();
        float f2 = ((CLNumber) obj).getFloat();
        if ((!Float.isNaN(f) || !Float.isNaN(f2)) && f != f2) {
            return false;
        }
        return true;
    }

    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = (float) Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        float f = this.mValue;
        if (f != 0.0f) {
            i = Float.floatToIntBits(f);
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public boolean isInt() {
        float f = getFloat();
        if (((float) ((int) f)) == f) {
            return true;
        }
        return false;
    }

    public void putValue(float f) {
        this.mValue = f;
    }

    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        float f = getFloat();
        int i3 = (int) f;
        if (((float) i3) == f) {
            sb.append(i3);
        } else {
            sb.append(f);
        }
        return sb.toString();
    }

    public String toJSON() {
        float f = getFloat();
        int i = (int) f;
        if (((float) i) == f) {
            return "" + i;
        }
        return "" + f;
    }

    public CLNumber(float f) {
        super((char[]) null);
        this.mValue = f;
    }
}
