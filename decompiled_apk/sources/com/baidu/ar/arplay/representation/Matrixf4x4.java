package com.baidu.ar.arplay.representation;

import android.util.Log;

/* loaded from: classes7.dex */
public class Matrixf4x4 {
    public static final String TAG = "Matrixf4x4";
    public static final int[] MAT_IND_COL_IN9_WITH3X3 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int[] MAT_IND_COL_IN16_WITH3X3 = {0, 1, 2, 4, 5, 6, 8, 9, 10};
    public static final int[] MAT_IND_ROW_IN9_WITH3X3 = {0, 3, 6, 1, 4, 7, 3, 5, 8};
    public static final int[] MAT_IND_ROW_IN16_WITH3X3 = {0, 4, 8, 1, 5, 9, 2, 6, 10};
    public static final int[] MAT_IND_COL_IN16_WITH4X4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int[] MAT_IND_ROW_IN16_WITH4X4 = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
    private boolean colMaj = true;
    private boolean matrixValid = false;
    public float[] matrix = new float[16];

    public Matrixf4x4() {
        loadIndentity();
    }

    public static Matrixf4x4 lookAtLH(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f == null || vector3f2 == null || vector3f3 == null) {
            return null;
        }
        Vector3f vector3f4 = new Vector3f(vector3f2);
        vector3f4.subtract(vector3f);
        vector3f4.normalize();
        Vector3f vector3f5 = new Vector3f();
        new Vector3f(vector3f3).crossProduct(vector3f4, vector3f5);
        vector3f5.normalize();
        Vector3f vector3f6 = new Vector3f();
        new Vector3f(vector3f4).crossProduct(vector3f5, vector3f6);
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setX0(vector3f5.getX());
        matrixf4x4.setY0(vector3f5.getY());
        matrixf4x4.setZ0(vector3f5.getZ());
        matrixf4x4.setX1(vector3f6.getX());
        matrixf4x4.setY1(vector3f6.getY());
        matrixf4x4.setZ1(vector3f6.getZ());
        matrixf4x4.setX2(vector3f4.getX());
        matrixf4x4.setY2(vector3f4.getY());
        matrixf4x4.setZ2(vector3f4.getZ());
        matrixf4x4.setW0(-vector3f5.dotProduct(vector3f));
        matrixf4x4.setW1(-vector3f6.dotProduct(vector3f));
        matrixf4x4.setW2(-vector3f4.dotProduct(vector3f));
        return matrixf4x4;
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public boolean isColumnMajor() {
        return this.colMaj;
    }

    public boolean isMatrixValid() {
        return this.matrixValid;
    }

    public final void loadIndentity() {
        Matrix.setIdentityM(this.matrix, 0);
        this.matrixValid = true;
    }

    public void multiplyMatrix(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = i2 + i4;
                float f = fArr2[i5];
                float[] fArr3 = this.matrix;
                int i6 = (i3 * 4) + i4;
                fArr2[i5] = f + (fArr3[i6] * fArr[i + i3]);
                int i7 = i2 + 4 + i4;
                fArr2[i7] = fArr2[i7] + (fArr3[i6] * fArr[i + 4 + i3]);
                int i8 = i2 + 8 + i4;
                fArr2[i8] = fArr2[i8] + (fArr3[i6] * fArr[i + 8 + i3]);
                int i9 = i2 + 12 + i4;
                fArr2[i9] = fArr2[i9] + (fArr3[i6] * fArr[i + 12 + i3]);
            }
        }
    }

    public void multiplyMatrix4x4ByMatrix(Matrixf4x4 matrixf4x4) {
        if (this.matrixValid && matrixf4x4.isMatrixValid()) {
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            multiplyMatrix(matrixf4x4.getMatrix(), 0, fArr, 0);
            matrixf4x4.setMatrix(fArr);
            return;
        }
        Log.e(TAG, "matrixMatrix is invalid, internal is " + this.matrix.length + " long , input matrix is " + matrixf4x4.getMatrix().length + " long");
    }

    @Deprecated
    public void multiplyVector3fByMatrix(Vector3f vector3f) {
        float f;
        float f2;
        if (!this.matrixValid || this.matrix.length != 9) {
            Log.e(TAG, "matrixMatrix is invalid, is " + this.matrix.length + " long, this function expects the internal matrix to be of size 9");
            return;
        }
        float[] array = vector3f.toArray();
        int i = 0;
        float f3 = 0.0f;
        if (this.colMaj) {
            f = 0.0f;
            f2 = 0.0f;
            while (i < 3) {
                float[] fArr = this.matrix;
                float f4 = fArr[i];
                float f5 = array[i];
                f3 += f4 * f5;
                f += fArr[i + 3] * f5;
                f2 += fArr[i + 6] * f5;
                i++;
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
            while (i < 3) {
                int i2 = i * 3;
                float[] fArr2 = this.matrix;
                float f6 = fArr2[i2];
                float f7 = array[i];
                f3 += f6 * f7;
                f += fArr2[i2 + 1] * f7;
                f2 += fArr2[i2 + 2] * f7;
                i++;
            }
        }
        vector3f.setX(f3);
        vector3f.setY(f);
        vector3f.setZ(f2);
    }

    public void multiplyVector4fByMatrix(Vector4f vector4f) {
        float f;
        float f2;
        float f3;
        if (!this.matrixValid || this.matrix.length != 16) {
            Log.e(TAG, "matrixMatrix is invalid, is " + this.matrix.length + " long, this equation expects a 16 value matrix");
            return;
        }
        float[] array = vector4f.toArray();
        int i = 0;
        float f4 = 0.0f;
        if (this.colMaj) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            while (i < 4) {
                int i2 = i * 4;
                float[] fArr = this.matrix;
                float f5 = fArr[i2];
                float f6 = array[i];
                f4 += f5 * f6;
                f += fArr[i2 + 1] * f6;
                f2 += fArr[i2 + 2] * f6;
                f3 += fArr[i2 + 3] * f6;
                i++;
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            while (i < 4) {
                float[] fArr2 = this.matrix;
                float f7 = fArr2[i];
                float f8 = array[i];
                f4 += f7 * f8;
                f += fArr2[i + 4] * f8;
                f2 += fArr2[i + 8] * f8;
                f3 += fArr2[i + 12] * f8;
                i++;
            }
        }
        vector4f.setX(f4);
        vector4f.setY(f);
        vector4f.setZ(f2);
        vector4f.setW(f3);
    }

    public void setColumnMajor(boolean z) {
        this.colMaj = z;
    }

    public void setMatrix(float[] fArr) {
        this.matrix = fArr;
        if (fArr.length == 16 || fArr.length == 9) {
            this.matrixValid = true;
            return;
        }
        this.matrixValid = false;
        Log.e(TAG, "matrixMatrix set is invalid, size is " + fArr.length + " expected 9 or 16");
    }

    public void setMatrixValues(float[] fArr) {
        if (this.matrix.length != fArr.length) {
            Log.e(TAG, "matrixMatrix set is invalid, size is " + fArr.length + " expected 9 or 16");
        }
        for (int i = 0; i < fArr.length; i++) {
            this.matrix[i] = fArr[i];
        }
    }

    public void setW0(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[12]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[12]] = f;
                }
            }
        }
    }

    public void setW1(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[13]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[13]] = f;
                }
            }
        }
    }

    public void setW2(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[14]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[14]] = f;
                }
            }
        }
    }

    public void setW3(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[15]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[15]] = f;
                }
            }
        }
    }

    public void setX0(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[0]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[0]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[0]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[0]] = f;
            }
        }
    }

    public void setX1(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[1]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[1]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[1]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[1]] = f;
            }
        }
    }

    public void setX2(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[2]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[2]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[2]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[2]] = f;
            }
        }
    }

    public void setX3(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[3]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[3]] = f;
                }
            }
        }
    }

    public void setY0(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[3]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[3]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[3]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[3]] = f;
            }
        }
    }

    public void setY1(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[4]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[4]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[4]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[4]] = f;
            }
        }
    }

    public void setY2(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[5]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[5]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[5]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[5]] = f;
            }
        }
    }

    public void setY3(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[7]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[7]] = f;
                }
            }
        }
    }

    public void setZ0(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[6]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[6]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[6]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[6]] = f;
            }
        }
    }

    public void setZ1(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[7]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[7]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[7]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[7]] = f;
            }
        }
    }

    public void setZ2(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[8]] = f;
                    return;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[8]] = f;
                    return;
                }
            }
            if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[8]] = f;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[8]] = f;
            }
        }
    }

    public void setZ3(float f) {
        if (this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[11]] = f;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[11]] = f;
                }
            }
        }
    }

    public int size() {
        return this.matrix.length;
    }

    public void transpose() {
        if (this.matrixValid) {
            int i = 0;
            if (this.matrix.length != 16) {
                float[] fArr = new float[9];
                while (i < 3) {
                    int i2 = i * 3;
                    float[] fArr2 = this.matrix;
                    fArr[i2] = fArr2[i];
                    fArr[i2 + 1] = fArr2[i + 3];
                    fArr[i2 + 2] = fArr2[i + 6];
                    i++;
                }
                this.matrix = fArr;
                return;
            }
            float[] fArr3 = new float[16];
            while (i < 4) {
                int i3 = i * 4;
                float[] fArr4 = this.matrix;
                fArr3[i3] = fArr4[i];
                fArr3[i3 + 1] = fArr4[i + 4];
                fArr3[i3 + 2] = fArr4[i + 8];
                fArr3[i3 + 3] = fArr4[i + 12];
                i++;
            }
            this.matrix = fArr3;
        }
    }
}
