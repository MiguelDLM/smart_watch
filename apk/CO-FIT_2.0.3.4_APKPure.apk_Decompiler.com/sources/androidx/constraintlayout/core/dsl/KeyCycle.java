package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public class KeyCycle extends KeyAttribute {
    private static final String TAG = "KeyCycle";
    private float mWaveOffset = Float.NaN;
    private float mWavePeriod = Float.NaN;
    private float mWavePhase = Float.NaN;
    private Wave mWaveShape = null;

    public enum Wave {
        SIN,
        SQUARE,
        TRIANGLE,
        SAW,
        REVERSE_SAW,
        COS
    }

    public KeyCycle(int i, String str) {
        super(i, str);
        this.TYPE = "KeyCycle";
    }

    public void attributesToString(StringBuilder sb) {
        super.attributesToString(sb);
        if (this.mWaveShape != null) {
            sb.append("shape:'");
            sb.append(this.mWaveShape);
            sb.append("',\n");
        }
        append(sb, TypedValues.CycleType.S_WAVE_PERIOD, this.mWavePeriod);
        append(sb, TypedValues.CycleType.S_WAVE_OFFSET, this.mWaveOffset);
        append(sb, TypedValues.CycleType.S_WAVE_PHASE, this.mWavePhase);
    }

    public float getOffset() {
        return this.mWaveOffset;
    }

    public float getPeriod() {
        return this.mWavePeriod;
    }

    public float getPhase() {
        return this.mWavePhase;
    }

    public Wave getShape() {
        return this.mWaveShape;
    }

    public void setOffset(float f) {
        this.mWaveOffset = f;
    }

    public void setPeriod(float f) {
        this.mWavePeriod = f;
    }

    public void setPhase(float f) {
        this.mWavePhase = f;
    }

    public void setShape(Wave wave) {
        this.mWaveShape = wave;
    }
}
