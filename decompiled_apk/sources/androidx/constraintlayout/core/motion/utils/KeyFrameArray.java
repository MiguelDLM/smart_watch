package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyFrameArray {

    /* loaded from: classes.dex */
    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomAttribute[] mValues = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customAttribute;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            printStream.print("K: [");
            for (int i = 0; i < this.mCount; i++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.mCount;
                if (i2 < i4) {
                    int[] iArr = this.mKeys;
                    if (i == iArr[i2]) {
                        iArr[i2] = 999;
                        i3++;
                    }
                    if (i2 != i3) {
                        iArr[i2] = iArr[i3];
                    }
                    i3++;
                    i2++;
                } else {
                    this.mCount = i4 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomVariable[] mValues = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customVariable;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            printStream.print("K: [");
            for (int i = 0; i < this.mCount; i++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.mCount;
                if (i2 < i4) {
                    int[] iArr = this.mKeys;
                    if (i == iArr[i2]) {
                        iArr[i2] = 999;
                        i3++;
                    }
                    if (i2 != i3) {
                        iArr[i2] = iArr[i3];
                    }
                    i3++;
                    i2++;
                } else {
                    this.mCount = i4 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    /* loaded from: classes.dex */
    public static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        float[][] mValues = new float[101];

        public FloatArray() {
            clear();
        }

        public void append(int i, float[] fArr) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = fArr;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            printStream.print("K: [");
            for (int i = 0; i < this.mCount; i++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(Arrays.toString(valueAt(i)));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.mCount;
                if (i2 < i4) {
                    int[] iArr = this.mKeys;
                    if (i == iArr[i2]) {
                        iArr[i2] = 999;
                        i3++;
                    }
                    if (i2 != i3) {
                        iArr[i2] = iArr[i3];
                    }
                    i3++;
                    i2++;
                } else {
                    this.mCount = i4 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }
}
