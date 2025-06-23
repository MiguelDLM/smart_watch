package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;

public abstract class Guideline extends Helper {
    private int mEnd = Integer.MIN_VALUE;
    private float mPercent = Float.NaN;
    private int mStart = Integer.MIN_VALUE;

    public Guideline(String str) {
        super(str, new Helper.HelperType(""));
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i) {
        this.mEnd = i;
        this.configMap.put("end", String.valueOf(i));
    }

    public void setPercent(float f) {
        this.mPercent = f;
        this.configMap.put("percent", String.valueOf(f));
    }

    public void setStart(int i) {
        this.mStart = i;
        this.configMap.put("start", String.valueOf(i));
    }
}
