package com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class PerimeterPageTabs extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private int f7585a;
    private b b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, int i2, boolean z);
    }

    public PerimeterPageTabs(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(0);
        setGravity(16);
        Resources resources = context.getResources();
        resources.getDimensionPixelSize(R.dimen.navi_dimens_70dp);
        resources.getDimensionPixelSize(R.dimen.navi_dimens_30dp);
        resources.getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        resources.getDimensionPixelSize(R.dimen.navi_dimens_12dp);
        setOnClickListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        boolean isSelected = view.isSelected();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PerimeterPageTabs", "onClick: " + intValue + ", isPressed: " + isSelected + ", mRouteIndex: " + this.f7585a);
        }
        boolean z = !isSelected;
        view.setSelected(z);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f7585a, intValue, z);
        }
    }

    public void setOnTabClickListener(b bVar) {
        this.b = bVar;
    }

    public PerimeterPageTabs(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PerimeterPageTabs(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
