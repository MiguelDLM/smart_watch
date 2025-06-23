package androidx.constraintlayout.core.motion.utils;

import XIXIX.OOXIXo;
import java.io.PrintStream;

public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private int mBoundaryMode = 0;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    private void compute(double d) {
        if (d > OOXIXo.f29376XO) {
            double d2 = this.mStiffness;
            double d3 = this.mDamping;
            int sqrt = (int) ((9.0d / ((Math.sqrt(d2 / ((double) this.mMass)) * d) * 4.0d)) + 1.0d);
            double d4 = d / ((double) sqrt);
            int i = 0;
            while (i < sqrt) {
                float f = this.mPos;
                double d5 = this.mTargetPos;
                float f2 = this.mV;
                double d6 = d2;
                float f3 = this.mMass;
                double d7 = d3;
                double d8 = ((double) f2) + ((((((-d2) * (((double) f) - d5)) - (((double) f2) * d3)) / ((double) f3)) * d4) / 2.0d);
                double d9 = ((((-((((double) f) + ((d4 * d8) / 2.0d)) - d5)) * d6) - (d8 * d7)) / ((double) f3)) * d4;
                double d10 = ((double) f2) + (d9 / 2.0d);
                float f4 = f2 + ((float) d9);
                this.mV = f4;
                float f5 = f + ((float) (d10 * d4));
                this.mPos = f5;
                int i2 = this.mBoundaryMode;
                if (i2 > 0) {
                    if (f5 < 0.0f && (i2 & 1) == 1) {
                        this.mPos = -f5;
                        this.mV = -f4;
                    }
                    float f6 = this.mPos;
                    if (f6 > 1.0f && (i2 & 2) == 2) {
                        this.mPos = 2.0f - f6;
                        this.mV = -this.mV;
                    }
                }
                i++;
                d2 = d6;
                d3 = d7;
            }
        }
    }

    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        double d = this.mStiffness;
        return ((float) (((-d) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    public float getInterpolation(float f) {
        compute((double) (f - this.mLastTime));
        this.mLastTime = f;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public boolean isStopped() {
        double d = ((double) this.mPos) - this.mTargetPos;
        double d2 = this.mStiffness;
        double d3 = (double) this.mV;
        if (Math.sqrt((((d3 * d3) * ((double) this.mMass)) + ((d2 * d) * d)) / d2) <= ((double) this.mStopThreshold)) {
            return true;
        }
        return false;
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        PrintStream printStream = System.out;
        printStream.println((".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.mTargetPos = (double) f2;
        this.mDamping = (double) f6;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = (double) f3;
        this.mStiffness = (double) f5;
        this.mMass = f4;
        this.mStopThreshold = f7;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }

    public float getVelocity(float f) {
        return this.mV;
    }
}
