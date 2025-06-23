package com.baidu.navisdk.module.carlogo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class ThreeDColorLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.carlogo.datas.a[] f7084a;

    @ColorInt
    private int b;
    private SparseArray<ThreeDColorView> c;
    private a d;
    private int e;
    private int f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.navisdk.module.carlogo.datas.a aVar, int i);
    }

    public ThreeDColorLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
    }

    private void b() {
        SparseArray<ThreeDColorView> sparseArray = this.c;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i = 0; i < this.c.size(); i++) {
                ThreeDColorView valueAt = this.c.valueAt(i);
                if (valueAt != null) {
                    valueAt.a();
                }
            }
            this.c.clear();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDColorLayout", "onClick clickColor: " + intValue + ", mCurrentColor:" + this.b);
        }
        if (intValue == this.b) {
            return;
        }
        ThreeDColorView threeDColorView = this.c.get(intValue);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDColorLayout", "onClick clickColor: " + threeDColorView);
        }
        threeDColorView.setSelected(true);
        ThreeDColorView threeDColorView2 = this.c.get(this.b);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDColorLayout", "onClick mCurrentColor: " + threeDColorView2);
        }
        threeDColorView2.setSelected(false);
        this.b = intValue;
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(a(intValue), this.e);
        }
    }

    public void setOnColorChangeListener(a aVar) {
        this.d = aVar;
    }

    public ThreeDColorLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreeDColorLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(com.baidu.navisdk.module.carlogo.datas.a[] aVarArr, @ColorInt int i, int i2) {
        removeAllViews();
        b();
        this.f7084a = aVarArr;
        this.b = i;
        this.e = i2;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateColor(), gifModelArray = ");
            sb.append(aVarArr == null ? "null" : Arrays.toString(aVarArr));
            sb.append(" selectedColor = ");
            sb.append(i);
            LogUtil.e("ThreeDColorLayout", sb.toString());
        }
        if (aVarArr != null && aVarArr.length > 0) {
            setVisibility(0);
            this.c = new SparseArray<>(aVarArr.length);
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                com.baidu.navisdk.module.carlogo.datas.a aVar = aVarArr[i3];
                if (aVar != null) {
                    int i4 = aVar.c;
                    this.c.put(aVarArr[i3].c, a(i4, i3, i == i4));
                }
            }
            return;
        }
        setVisibility(8);
        this.c = null;
    }

    @RequiresApi(api = 21)
    public ThreeDColorLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private ThreeDColorView a(@ColorInt int i, int i2, boolean z) {
        ThreeDColorView threeDColorView = new ThreeDColorView(getContext());
        threeDColorView.a(a(0.2f, i), i, a(0.7f, i), z);
        threeDColorView.setTag(Integer.valueOf(i));
        threeDColorView.setOnClickListener(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        if (i2 != 0) {
            marginLayoutParams.leftMargin = this.f;
        }
        addView(threeDColorView, i2, marginLayoutParams);
        return threeDColorView;
    }

    private int a(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    private com.baidu.navisdk.module.carlogo.datas.a a(int i) {
        com.baidu.navisdk.module.carlogo.datas.a[] aVarArr = this.f7084a;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.navisdk.module.carlogo.datas.a aVar : aVarArr) {
                if (aVar != null && aVar.c == i) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public void a() {
        removeAllViews();
        b();
        this.c = null;
        this.f7084a = null;
        this.d = null;
    }
}
