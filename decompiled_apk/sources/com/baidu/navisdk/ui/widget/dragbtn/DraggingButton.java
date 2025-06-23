package com.baidu.navisdk.ui.widget.dragbtn;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNFrameLayout;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class DraggingButton extends BNFrameLayout {
    private static final String TAG = "DraggingButton";
    private int attachMarginBottom;
    private int attachMarginLeft;
    private int attachMarginRight;
    private int attachMarginTop;
    private boolean attachable;
    private boolean draggable;
    private boolean isDragged;
    private boolean isDragging;
    private ImageView mCloseBtn;
    private ImageView mImageBtn;
    private float mLastRawX;
    private float mLastRawY;
    private int mRootMeasuredHeight;
    private int mRootMeasuredWidth;
    private int mRootTopY;

    public DraggingButton(Context context) {
        this(context, null);
    }

    private void autoLeft() {
        animate().setInterpolator(new AccelerateInterpolator()).setDuration(100L).x(this.attachMarginLeft).setListener(new Animator.AnimatorListener() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DraggingButton.this.mCloseBtn != null) {
                    DraggingButton.this.mCloseBtn.setVisibility(0);
                    DraggingButton.this.mCloseBtn.setRotation(180.0f);
                    ((RelativeLayout.LayoutParams) DraggingButton.this.mCloseBtn.getLayoutParams()).removeRule(11);
                    ((RelativeLayout.LayoutParams) DraggingButton.this.mCloseBtn.getLayoutParams()).addRule(9);
                    DraggingButton.this.mCloseBtn.requestLayout();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void autoRight() {
        animate().setInterpolator(new AccelerateInterpolator()).setDuration(100L).x((this.mRootMeasuredWidth - getWidth()) - this.attachMarginRight).setListener(new Animator.AnimatorListener() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DraggingButton.this.mCloseBtn != null) {
                    DraggingButton.this.mCloseBtn.setVisibility(0);
                    DraggingButton.this.mCloseBtn.setRotation(0.0f);
                    ((RelativeLayout.LayoutParams) DraggingButton.this.mCloseBtn.getLayoutParams()).removeRule(9);
                    ((RelativeLayout.LayoutParams) DraggingButton.this.mCloseBtn.getLayoutParams()).addRule(11);
                    DraggingButton.this.mCloseBtn.requestLayout();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_dragging_button_layout, this);
        this.mCloseBtn = (ImageView) findViewById(R.id.close_btn);
        this.mImageBtn = (ImageView) findViewById(R.id.dragging_image);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DraggingButton);
        this.attachable = obtainStyledAttributes.getBoolean(R.styleable.DraggingButton_nsdk_attachable, true);
        this.draggable = obtainStyledAttributes.getBoolean(R.styleable.DraggingButton_nsdk_draggable, true);
        this.attachMarginLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DraggingButton_nsdk_attach_margin_left, 0);
        this.attachMarginRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DraggingButton_nsdk_attach_margin_right, 0);
        this.attachMarginTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DraggingButton_nsdk_attach_margin_top, 0);
        this.attachMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DraggingButton_nsdk_attach_margin_bottom, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initParentView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            this.mRootMeasuredHeight = viewGroup.getMeasuredHeight();
            this.mRootMeasuredWidth = viewGroup.getMeasuredWidth();
            this.mRootTopY = iArr[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBtnAttachLeft() {
        if (getX() - this.attachMarginLeft < ((this.mRootMeasuredWidth - getWidth()) - this.attachMarginRight) - getX()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.BNFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public ImageView getDraggingImageView() {
        return this.mImageBtn;
    }

    public boolean isDragged() {
        if (this.draggable && this.isDragged) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.BNFrameLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.draggable) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && rawX >= 0.0f && rawX <= this.mRootMeasuredWidth) {
                        if (rawY >= this.mRootTopY && rawY <= this.mRootMeasuredHeight + r4) {
                            float f = rawX - this.mLastRawX;
                            float f2 = rawY - this.mLastRawY;
                            if (!this.isDragging) {
                                if (Math.sqrt((f * f) + (f2 * f2)) >= 2.0d) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                this.isDragging = z;
                                if (LogUtil.LOGGABLE) {
                                    LogUtil.e(TAG, "onTouchEvent() --> isDragging = " + this.isDragging);
                                }
                                if (this.isDragging) {
                                    ImageView imageView = this.mCloseBtn;
                                    if (imageView != null) {
                                        imageView.setVisibility(8);
                                    }
                                    this.isDragged = true;
                                }
                            }
                            float x = getX() + f;
                            float y = getY() + f2;
                            float width = (this.mRootMeasuredWidth - getWidth()) - this.attachMarginRight;
                            float height = (this.mRootMeasuredHeight - getHeight()) - this.attachMarginBottom;
                            float f3 = this.attachMarginLeft;
                            if (x >= f3) {
                                f3 = Math.min(x, width);
                            }
                            float f4 = this.attachMarginTop;
                            if (y >= f4) {
                                f4 = Math.min(y, height);
                            }
                            setX(f3);
                            setY(f4);
                            this.mLastRawX = rawX;
                            this.mLastRawY = rawY;
                        }
                    }
                } else if (this.attachable && this.isDragging) {
                    if (this.mLastRawX <= this.mRootMeasuredWidth / 2.0f) {
                        autoLeft();
                    } else {
                        autoRight();
                    }
                }
            } else {
                this.isDragging = false;
                this.mLastRawX = rawX;
                this.mLastRawY = rawY;
                initParentView();
            }
        }
        if (!this.isDragging && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public void setAttachMarginBottom(final int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setAttachMarginBottom() --> attachMarginBottom = " + i + ", isDragged = " + this.isDragged);
        }
        this.attachMarginBottom = i;
        if (this.isDragged) {
            post(new Runnable() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.6
                @Override // java.lang.Runnable
                public void run() {
                    DraggingButton.this.initParentView();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(DraggingButton.TAG, "setAttachMarginBottom() --> mRootMeasuredHeight = " + DraggingButton.this.mRootMeasuredHeight + ", getY = " + DraggingButton.this.getY() + ", getHeight = " + DraggingButton.this.getHeight() + ", attachMarginBottom = " + i);
                    }
                    if (DraggingButton.this.mRootMeasuredHeight > 0 && DraggingButton.this.getY() != 0.0f && DraggingButton.this.getY() > (DraggingButton.this.mRootMeasuredHeight - DraggingButton.this.getHeight()) - i) {
                        DraggingButton.this.setY((r0.mRootMeasuredHeight - DraggingButton.this.getHeight()) - i);
                    }
                }
            });
        }
    }

    public void setAttachMarginLeft(final int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setAttachMarginLeft() --> attachMarginLeft = " + i);
        }
        this.attachMarginLeft = i;
        post(new Runnable() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.3
            @Override // java.lang.Runnable
            public void run() {
                DraggingButton.this.initParentView();
                if (DraggingButton.this.mRootMeasuredWidth > 0 && DraggingButton.this.isBtnAttachLeft()) {
                    DraggingButton.this.setX(i);
                }
            }
        });
    }

    public void setAttachMarginRight(final int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setAttachMarginRight() --> attachMarginRight = " + i);
        }
        this.attachMarginRight = i;
        post(new Runnable() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.4
            @Override // java.lang.Runnable
            public void run() {
                DraggingButton.this.initParentView();
                if (DraggingButton.this.mRootMeasuredWidth > 0 && DraggingButton.this.isBtnAttachLeft()) {
                    DraggingButton.this.setX((r0.mRootMeasuredWidth - DraggingButton.this.getWidth()) - i);
                }
            }
        });
    }

    public void setAttachMarginTop(final int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setAttachMarginTop() --> attachMarginTop = " + i + ", isDragged = " + this.isDragged);
        }
        this.attachMarginTop = i;
        if (this.isDragged) {
            post(new Runnable() { // from class: com.baidu.navisdk.ui.widget.dragbtn.DraggingButton.5
                @Override // java.lang.Runnable
                public void run() {
                    DraggingButton.this.initParentView();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(DraggingButton.TAG, "setAttachMarginTop() --> mRootMeasuredHeight = " + DraggingButton.this.mRootMeasuredHeight + ", getY = " + DraggingButton.this.getY() + ", attachMarginTop = " + i);
                    }
                    if (DraggingButton.this.mRootMeasuredHeight > 0 && DraggingButton.this.getY() != 0.0f) {
                        float y = DraggingButton.this.getY();
                        float f = i;
                        if (y < f) {
                            DraggingButton.this.setY(f);
                        }
                    }
                }
            });
        }
    }

    public void setAttachable(boolean z) {
        this.attachable = z;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mCloseBtn;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public DraggingButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DraggingButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDragging = false;
        this.isDragged = false;
        this.mRootMeasuredWidth = 0;
        this.mRootMeasuredHeight = 0;
        this.mRootTopY = 0;
        initAttrs(context, attributeSet);
    }
}
