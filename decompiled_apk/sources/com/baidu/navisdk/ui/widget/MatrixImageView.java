package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public class MatrixImageView extends ImageView {
    private static final String TAG = "MatrixImageView";
    private GestureDetector mGestureDetector;
    public float mImageHeight;
    public float mImageWidth;
    private Matrix mMatrix;

    /* loaded from: classes8.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private final MatrixTouchListener listener;

        public GestureListener(MatrixTouchListener matrixTouchListener) {
            this.listener = matrixTouchListener;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* loaded from: classes8.dex */
    public class MatrixTouchListener implements View.OnTouchListener {
        private static final int MODE_DRAG = 1;
        private static final int MODE_UNABLE = 3;
        private static final int MODE_ZOOM = 2;
        private float mStartDis;
        float mMaxScale = 6.0f;
        float mDobleClickScale = 2.0f;
        float mMinScale = 1.0f;
        private int mMode = 0;
        private Matrix mCurrentMatrix = new Matrix();
        private PointF startPoint = new PointF();

        public MatrixTouchListener() {
        }

        private float checkDxBound(float[] fArr, float f) {
            float width = MatrixImageView.this.getWidth();
            float f2 = MatrixImageView.this.mImageWidth;
            float f3 = fArr[0];
            if (f2 * f3 < width) {
                return 0.0f;
            }
            float f4 = fArr[2];
            if (f4 + f > 0.0f) {
                return -f4;
            }
            if (f4 + f < (-((f2 * f3) - width))) {
                return (-((f2 * f3) - width)) - f4;
            }
            return f;
        }

        private float checkDyBound(float[] fArr, float f) {
            float height = MatrixImageView.this.getHeight();
            float f2 = MatrixImageView.this.mImageHeight;
            float f3 = fArr[4];
            if (f2 * f3 < height) {
                return 0.0f;
            }
            float f4 = fArr[5];
            if (f4 + f > 0.0f) {
                return -f4;
            }
            if (f4 + f < (-((f2 * f3) - height))) {
                return (-((f2 * f3) - height)) - f4;
            }
            return f;
        }

        private float checkMaxScale(float f, float[] fArr) {
            float f2 = fArr[0];
            float f3 = f * f2;
            float f4 = this.mMaxScale;
            if (f3 > f4) {
                f = f4 / f2;
            } else {
                float f5 = f * f2;
                float f6 = this.mMinScale;
                if (f5 < f6) {
                    float f7 = f6 / f2;
                    this.mCurrentMatrix.setScale(f6, f6);
                    return f7;
                }
            }
            this.mCurrentMatrix.postScale(f, f, MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
            return f;
        }

        private boolean checkRest() {
            float[] fArr = new float[9];
            MatrixImageView.this.getImageMatrix().getValues(fArr);
            float f = fArr[0];
            MatrixImageView.this.mMatrix.getValues(fArr);
            if (f >= fArr[0]) {
                return false;
            }
            return true;
        }

        private float distance(MotionEvent motionEvent) {
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            return (float) Math.sqrt((x * x) + (y * y));
        }

        private void isMatrixEnable() {
            if (MatrixImageView.this.getScaleType() != ImageView.ScaleType.CENTER) {
                MatrixImageView.this.setScaleType(ImageView.ScaleType.MATRIX);
            } else {
                this.mMode = 3;
            }
        }

        private boolean isZoomChanged() {
            float[] fArr = new float[9];
            MatrixImageView.this.getImageMatrix().getValues(fArr);
            float f = fArr[0];
            MatrixImageView.this.mMatrix.getValues(fArr);
            if (f == fArr[0]) {
                return false;
            }
            return true;
        }

        private void reSetMatrix() {
            if (checkRest()) {
                this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
                MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
            }
        }

        private void setZoomMatrix(MotionEvent motionEvent) {
            if (motionEvent.getPointerCount() < 2) {
                return;
            }
            float distance = distance(motionEvent);
            if (distance > 10.0f) {
                float f = distance / this.mStartDis;
                this.mStartDis = distance;
                this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
                float[] fArr = new float[9];
                this.mCurrentMatrix.getValues(fArr);
                checkMaxScale(f, fArr);
                MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
                center(true, true);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0 < r7) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        
            if (r0 < r8) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void center(boolean r7, boolean r8) {
            /*
                r6 = this;
                android.graphics.Matrix r0 = new android.graphics.Matrix
                r0.<init>()
                android.graphics.Matrix r1 = r6.mCurrentMatrix
                r0.set(r1)
                android.graphics.RectF r1 = new android.graphics.RectF
                com.baidu.navisdk.ui.widget.MatrixImageView r2 = com.baidu.navisdk.ui.widget.MatrixImageView.this
                float r3 = r2.mImageWidth
                float r2 = r2.mImageHeight
                r4 = 0
                r1.<init>(r4, r4, r3, r2)
                r0.mapRect(r1)
                float r0 = r1.height()
                float r2 = r1.width()
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L45
                com.baidu.navisdk.ui.widget.MatrixImageView r8 = com.baidu.navisdk.ui.widget.MatrixImageView.this
                int r8 = r8.getHeight()
                float r8 = (float) r8
                int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r5 >= 0) goto L36
                float r8 = r8 - r0
                float r8 = r8 / r3
                float r0 = r1.top
            L34:
                float r8 = r8 - r0
                goto L46
            L36:
                float r0 = r1.top
                int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r5 <= 0) goto L3e
                float r8 = -r0
                goto L46
            L3e:
                float r0 = r1.bottom
                int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r5 >= 0) goto L45
                goto L34
            L45:
                r8 = 0
            L46:
                if (r7 == 0) goto L69
                com.baidu.navisdk.ui.widget.MatrixImageView r7 = com.baidu.navisdk.ui.widget.MatrixImageView.this
                int r7 = r7.getWidth()
                float r7 = (float) r7
                int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r0 >= 0) goto L5a
                float r7 = r7 - r2
                float r7 = r7 / r3
                float r0 = r1.left
            L57:
                float r4 = r7 - r0
                goto L69
            L5a:
                float r0 = r1.left
                int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r2 <= 0) goto L62
                float r4 = -r0
                goto L69
            L62:
                float r0 = r1.right
                int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r1 >= 0) goto L69
                goto L57
            L69:
                android.graphics.Matrix r7 = r6.mCurrentMatrix
                r7.postTranslate(r4, r8)
                com.baidu.navisdk.ui.widget.MatrixImageView r7 = com.baidu.navisdk.ui.widget.MatrixImageView.this
                android.graphics.Matrix r8 = r6.mCurrentMatrix
                r7.setImageMatrix(r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.MatrixImageView.MatrixTouchListener.center(boolean, boolean):void");
        }

        public void onDoubleClick() {
            float f;
            if (isZoomChanged()) {
                f = 1.0f;
            } else {
                f = this.mDobleClickScale;
            }
            this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
            this.mCurrentMatrix.postScale(f, f, MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
            MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                if (this.mMode == 3) {
                                    return true;
                                }
                                this.mMode = 2;
                                this.mStartDis = distance(motionEvent);
                            }
                        }
                    } else {
                        int i = this.mMode;
                        if (i == 2) {
                            setZoomMatrix(motionEvent);
                        } else if (i == 1) {
                            setDragMatrix(motionEvent);
                        }
                    }
                }
                reSetMatrix();
            } else {
                this.mMode = 1;
                this.startPoint.set(motionEvent.getX(), motionEvent.getY());
                isMatrixEnable();
            }
            return MatrixImageView.this.mGestureDetector.onTouchEvent(motionEvent);
        }

        public void setDragMatrix(MotionEvent motionEvent) {
            if (isZoomChanged()) {
                float x = motionEvent.getX() - this.startPoint.x;
                float y = motionEvent.getY() - this.startPoint.y;
                if (Math.sqrt((x * x) + (y * y)) > 10.0d) {
                    this.startPoint.set(motionEvent.getX(), motionEvent.getY());
                    this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
                    float[] fArr = new float[9];
                    this.mCurrentMatrix.getValues(fArr);
                    this.mCurrentMatrix.postTranslate(checkDxBound(fArr, x), checkDyBound(fArr, y));
                    MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
                }
            }
        }
    }

    public MatrixImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mMatrix.set(getImageMatrix());
        float[] fArr = new float[9];
        this.mMatrix.getValues(fArr);
        this.mImageWidth /= fArr[0];
        this.mImageHeight = (this.mImageHeight - (fArr[5] * 2.0f)) / fArr[4];
    }

    public void start(float f, float f2, float f3) {
        MatrixTouchListener matrixTouchListener = new MatrixTouchListener();
        matrixTouchListener.mMaxScale = f;
        matrixTouchListener.mDobleClickScale = f3;
        matrixTouchListener.mMinScale = f2;
        setOnTouchListener(matrixTouchListener);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(matrixTouchListener));
    }
}
