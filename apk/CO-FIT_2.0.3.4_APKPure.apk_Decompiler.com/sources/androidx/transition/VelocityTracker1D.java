package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (((double) Math.signum(f)) * Math.sqrt((double) (Math.abs(f) * 2.0f)));
    }

    public void addDataPoint(long j, float f) {
        int i = (this.mIndex + 1) % 20;
        this.mIndex = i;
        this.mTimeSamples[i] = j;
        this.mDataSamples[i] = f;
    }

    public float calculateVelocity() {
        float kineticEnergyToVelocity;
        int i;
        int i2 = this.mIndex;
        if (i2 == 0 && this.mTimeSamples[i2] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j = this.mTimeSamples[i2];
        int i3 = 0;
        long j2 = j;
        while (true) {
            long j3 = this.mTimeSamples[i2];
            if (j3 != Long.MIN_VALUE) {
                float abs = (float) Math.abs(j3 - j2);
                if (((float) (j - j3)) > 100.0f || abs > 40.0f) {
                    break;
                }
                if (i2 == 0) {
                    i2 = 20;
                }
                i2--;
                i3++;
                if (i3 >= 20) {
                    break;
                }
                j2 = j3;
            } else {
                break;
            }
        }
        if (i3 < 2) {
            return 0.0f;
        }
        if (i3 == 2) {
            int i4 = this.mIndex;
            if (i4 == 0) {
                i = 19;
            } else {
                i = i4 - 1;
            }
            long[] jArr = this.mTimeSamples;
            float f = (float) (jArr[i4] - jArr[i]);
            if (f == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            kineticEnergyToVelocity = (fArr[i4] - fArr[i]) / f;
        } else {
            int i5 = this.mIndex;
            int i6 = ((i5 - i3) + 21) % 20;
            int i7 = (i5 + 21) % 20;
            long j4 = this.mTimeSamples[i6];
            float f2 = this.mDataSamples[i6];
            int i8 = i6 + 1;
            float f3 = 0.0f;
            for (int i9 = i8 % 20; i9 != i7; i9 = (i9 + 1) % 20) {
                long j5 = this.mTimeSamples[i9];
                float f4 = (float) (j5 - j4);
                if (f4 != 0.0f) {
                    float f5 = this.mDataSamples[i9];
                    float f6 = (f5 - f2) / f4;
                    f3 += (f6 - kineticEnergyToVelocity(f3)) * Math.abs(f6);
                    if (i9 == i8) {
                        f3 *= 0.5f;
                    }
                    f2 = f5;
                    j4 = j5;
                }
            }
            kineticEnergyToVelocity = kineticEnergyToVelocity(f3);
        }
        return kineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
