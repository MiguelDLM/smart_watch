package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    int mCount = 0;
    private int mHashSize = 16;
    int mHead = -1;
    int[] mKeys = new int[16];
    int[] mNext = new int[16];
    int[] mNextKeys = new int[16];
    private final int mNone = -1;
    int[] mPrevious = new int[16];
    private final ArrayRow mRow;
    private int mSize = 16;
    float[] mValues = new float[16];
    int[] mVariables = new int[16];

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.id % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.mNextKeys;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                }
                i3 = i4;
            }
            iArr[i3] = i;
        }
        this.mNextKeys[i] = -1;
    }

    private void addVariable(int i, SolverVariable solverVariable, float f) {
        this.mVariables[i] = solverVariable.id;
        this.mValues[i] = f;
        this.mPrevious[i] = -1;
        this.mNext[i] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i = 0; i < this.mHashSize; i++) {
            if (this.mKeys[i] != -1) {
                String str = hashCode() + " hash [" + i + "] => ";
                int i2 = this.mKeys[i];
                boolean z = false;
                while (!z) {
                    str = str + " " + this.mVariables[i2];
                    int i3 = this.mNextKeys[i2];
                    if (i3 != -1) {
                        i2 = i3;
                    } else {
                        z = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < this.mSize; i++) {
            if (this.mVariables[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i = this.mSize * 2;
        this.mVariables = Arrays.copyOf(this.mVariables, i);
        this.mValues = Arrays.copyOf(this.mValues, i);
        this.mPrevious = Arrays.copyOf(this.mPrevious, i);
        this.mNext = Arrays.copyOf(this.mNext, i);
        this.mNextKeys = Arrays.copyOf(this.mNextKeys, i);
        for (int i2 = this.mSize; i2 < i; i2++) {
            this.mVariables[i2] = -1;
            this.mNextKeys[i2] = -1;
        }
        this.mSize = i;
    }

    private void insertVariable(int i, SolverVariable solverVariable, float f) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f);
        if (i != -1) {
            this.mPrevious[findEmptySlot] = i;
            int[] iArr = this.mNext;
            iArr[findEmptySlot] = iArr[i];
            iArr[i] = findEmptySlot;
        } else {
            this.mPrevious[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.mNext[findEmptySlot] = this.mHead;
                this.mHead = findEmptySlot;
            } else {
                this.mNext[findEmptySlot] = -1;
            }
        }
        int i2 = this.mNext[findEmptySlot];
        if (i2 != -1) {
            this.mPrevious[i2] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFromHashMap(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.id
            int r0 = r5.mHashSize
            int r0 = r6 % r0
            int[] r1 = r5.mKeys
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.mVariables
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.mNextKeys
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.mNextKeys
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.removeFromHashMap(androidx.constraintlayout.core.SolverVariable):void");
    }

    public void add(SolverVariable solverVariable, float f, boolean z) {
        float f2 = sEpsilon;
        if (f <= (-f2) || f >= f2) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.mValues;
            float f3 = fArr[indexOf] + f;
            fArr[indexOf] = f3;
            float f4 = sEpsilon;
            if (f3 > (-f4) && f3 < f4) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z);
            }
        }
    }

    public void clear() {
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i3 = 0; i3 < this.mSize; i3++) {
            this.mVariables[i3] = -1;
            this.mNextKeys[i3] = -1;
        }
        for (int i4 = 0; i4 < this.mHashSize; i4++) {
            this.mKeys[i4] = -1;
        }
        this.mCount = 0;
        this.mHead = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    public void display() {
        int i = this.mCount;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f) {
        int i = this.mCount;
        int i2 = this.mHead;
        int i3 = 0;
        while (i3 < i) {
            float[] fArr = this.mValues;
            fArr[i2] = fArr[i2] / f;
            i2 = this.mNext[i2];
            if (i2 != -1) {
                i3++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.mValues[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int i) {
        int i2 = this.mCount;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.mHead;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.mCache.mIndexedVariables[this.mVariables[i3]];
            }
            i3 = this.mNext[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i) {
        int i2 = this.mCount;
        int i3 = this.mHead;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.mValues[i3];
            }
            i3 = this.mNext[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.mCount
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.id
            int r0 = r3.mHashSize
            int r0 = r4 % r0
            int[] r2 = r3.mKeys
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.mNextKeys
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.indexOf(androidx.constraintlayout.core.SolverVariable):int");
    }

    public void invert() {
        int i = this.mCount;
        int i2 = this.mHead;
        int i3 = 0;
        while (i3 < i) {
            float[] fArr = this.mValues;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.mNext[i2];
            if (i2 != -1) {
                i3++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f) {
        float f2 = sEpsilon;
        if (f <= (-f2) || f >= f2) {
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f);
                addToHashMap(solverVariable, 0);
                this.mHead = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.mValues[indexOf] = f;
                return;
            }
            if (this.mCount + 1 >= this.mSize) {
                increaseSize();
            }
            int i = this.mCount;
            int i2 = this.mHead;
            int i3 = -1;
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.mVariables[i2];
                int i6 = solverVariable.id;
                if (i5 == i6) {
                    this.mValues[i2] = f;
                    return;
                }
                if (i5 < i6) {
                    i3 = i2;
                }
                i2 = this.mNext[i2];
                if (i2 == -1) {
                    break;
                }
            }
            insertVariable(i3, solverVariable, f);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f = this.mValues[indexOf];
        if (this.mHead == indexOf) {
            this.mHead = this.mNext[indexOf];
        }
        this.mVariables[indexOf] = -1;
        int[] iArr = this.mPrevious;
        int i = iArr[indexOf];
        if (i != -1) {
            int[] iArr2 = this.mNext;
            iArr2[i] = iArr2[indexOf];
        }
        int i2 = this.mNext[indexOf];
        if (i2 != -1) {
            iArr[i2] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i2) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.mPrevious[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.mVariables[this.mPrevious[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.mNext[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.mVariables[this.mNext[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = 0;
        int i2 = 0;
        while (i < currentSize) {
            int i3 = solverVariableValues.mVariables[i2];
            if (i3 != -1) {
                add(this.mCache.mIndexedVariables[i3], solverVariableValues.mValues[i2] * f, z);
                i++;
            }
            i2++;
        }
        return f;
    }
}
