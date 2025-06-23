package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class DefaultLoadMoreView extends BaseLoadMoreView {
    private int mCircleOffset;
    private int mCircleSize;
    private int mProgress;
    private RectF oval;
    private Paint paint;

    public DefaultLoadMoreView(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
        this.mCircleSize = 25;
        this.mProgress = 30;
        this.mCircleOffset = 70;
        this.paint = new Paint();
        this.oval = new RectF();
        setLoadmoreString("加载中...");
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView
    public void onDrawLoadMore(Canvas canvas, RecyclerView recyclerView) {
        super.onDrawLoadMore(canvas, recyclerView);
        int i = this.mProgress + 5;
        this.mProgress = i;
        if (i == 100) {
            this.mProgress = 0;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin + (getLoadMorePadding() / 2);
        this.paint.setAntiAlias(true);
        this.paint.setFlags(1);
        this.paint.setColor(-7829368);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setStyle(Paint.Style.STROKE);
        int i2 = (measuredWidth - paddingLeft) / 2;
        canvas.drawCircle(i2 - this.mCircleOffset, bottom, this.mCircleSize, this.paint);
        this.paint.setColor(-16711936);
        RectF rectF = this.oval;
        int i3 = i2 - this.mCircleOffset;
        int i4 = this.mCircleSize;
        rectF.set(i3 - i4, bottom - i4, i3 + i4, i4 + bottom);
        canvas.drawArc(this.oval, -90.0f, (this.mProgress / 100.0f) * 360.0f, false, this.paint);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setFlags(1);
        this.paint.setStrokeWidth(3.0f);
        this.paint.setTextSize(40.0f);
        this.paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawText(getLoadmoreString(), i2, bottom + 10, this.paint);
    }
}
