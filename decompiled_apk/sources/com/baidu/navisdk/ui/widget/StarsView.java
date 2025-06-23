package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.embed.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class StarsView extends LinearLayout {
    private SeleteListener listener;
    private int seleteItem;
    private int starCount;
    private int starHeight;
    private int starIcon;
    private int starMargin;
    private int starSeleteIcon;
    private int starWidth;
    private List<ImageView> stars;

    /* loaded from: classes8.dex */
    public interface SeleteListener {
        void selete(int i);
    }

    public StarsView(Context context) {
        super(context);
        this.stars = new ArrayList();
        this.seleteItem = -1;
        this.listener = null;
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StarsView);
        this.starHeight = obtainStyledAttributes.getLayoutDimension(R.styleable.StarsView_nsdk_starHeight, this.starHeight);
        this.starWidth = obtainStyledAttributes.getLayoutDimension(R.styleable.StarsView_nsdk_starWidth, this.starWidth);
        this.starMargin = obtainStyledAttributes.getLayoutDimension(R.styleable.StarsView_nsdk_starMargin, this.starMargin);
        this.starIcon = obtainStyledAttributes.getResourceId(R.styleable.StarsView_nsdk_starIcon, this.starIcon);
        this.starSeleteIcon = obtainStyledAttributes.getResourceId(R.styleable.StarsView_nsdk_starSeleteIcon, this.starSeleteIcon);
        this.starCount = obtainStyledAttributes.getInteger(R.styleable.StarsView_nsdk_starCount, this.starCount);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.navi_view_startview_linearlayout, this);
        int i = 0;
        while (true) {
            int i2 = this.starCount;
            if (i2 == 0) {
                i2 = 5;
            }
            if (i < i2) {
                ImageView imageView = new ImageView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.starWidth, this.starHeight);
                if (i == this.starCount - 1) {
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, this.starMargin, 0);
                }
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(this.starIcon);
                imageView.setTag(Integer.valueOf(i));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.StarsView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        StarsView.this.selete(((Integer) view.getTag()).intValue());
                    }
                });
                addView(imageView);
                this.stars.add(imageView);
                i++;
            } else {
                return;
            }
        }
    }

    public int getSeleteCount() {
        return this.seleteItem;
    }

    public void quietSelete(int i) {
        if (this.stars.size() != this.starCount) {
            return;
        }
        this.seleteItem = i + 1;
        for (int i2 = 0; i2 < this.starCount; i2++) {
            if (i2 <= i) {
                this.stars.get(i2).setImageResource(this.starSeleteIcon);
            } else {
                this.stars.get(i2).setImageResource(this.starIcon);
            }
        }
    }

    public void selete(int i) {
        quietSelete(i);
        SeleteListener seleteListener = this.listener;
        if (seleteListener != null) {
            seleteListener.selete(i + 1);
        }
    }

    public void setSeleteListener(SeleteListener seleteListener) {
        this.listener = seleteListener;
    }

    public StarsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.stars = new ArrayList();
        this.seleteItem = -1;
        this.listener = null;
        initialize(context, attributeSet);
    }

    public StarsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.stars = new ArrayList();
        this.seleteItem = -1;
        this.listener = null;
        initialize(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public StarsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.stars = new ArrayList();
        this.seleteItem = -1;
        this.listener = null;
        initialize(context, attributeSet);
    }
}
