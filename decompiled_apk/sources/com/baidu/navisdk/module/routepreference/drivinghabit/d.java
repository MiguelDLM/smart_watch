package com.baidu.navisdk.module.routepreference.drivinghabit;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.drivinghabit.c;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7482a;
    private ArrayList<c.a> b;
    private a c;
    private ImageView[] d;
    private int e = 0;
    private int f = -1;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, int i);
    }

    public d(boolean z) {
        this.f7482a = z;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        boolean z = false;
        if (this.f7482a) {
            int i = this.b.get(intValue).c;
            int i2 = this.e;
            if ((i & i2) == i) {
                z = true;
            }
            if (z) {
                this.e = i2 ^ i;
                this.d[intValue].setImageResource(R.drawable.nsdk_drawable_driving_habit_unselect);
            } else {
                this.e = i2 | i;
                this.d[intValue].setImageResource(R.drawable.nsdk_drawable_driving_habit_selected);
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(!z, i);
                return;
            }
            return;
        }
        if (this.f == intValue) {
            this.d[intValue].setImageResource(R.drawable.nsdk_drawable_driving_habit_unselect);
            this.f = -1;
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(false, this.b.get(intValue).c);
                return;
            }
            return;
        }
        this.d[intValue].setImageResource(R.drawable.nsdk_drawable_driving_habit_selected);
        a aVar3 = this.c;
        if (aVar3 != null) {
            aVar3.a(true, this.b.get(intValue).c);
        }
        int i3 = this.f;
        if (i3 >= 0) {
            this.d[i3].setImageResource(R.drawable.nsdk_drawable_driving_habit_unselect);
            a aVar4 = this.c;
            if (aVar4 != null) {
                aVar4.a(false, this.b.get(this.f).c);
            }
        }
        this.f = intValue;
    }

    public void a(Context context, ViewGroup viewGroup, ArrayList<c.a> arrayList, int i) {
        if (arrayList != null && arrayList.size() != 0 && viewGroup != null && context != null) {
            this.b = arrayList;
            int size = arrayList.size();
            this.d = new ImageView[size];
            int i2 = 0;
            while (i2 < size) {
                boolean z = i2 != size + (-1);
                c.a aVar = arrayList.get(i2);
                int i3 = aVar.c;
                a(context, viewGroup, aVar, (i & i3) == i3, z, i2);
                i2++;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("HabitItemGroupControlle", "addGroupItem habitItems == null || parentView == null || context == null");
        }
    }

    private void a(Context context, ViewGroup viewGroup, c.a aVar, boolean z, boolean z2, int i) {
        View inflate;
        int i2;
        if (aVar == null || viewGroup == null || (inflate = JarUtils.inflate(context, R.layout.nsdk_layout_route_sort_habit_item, null)) == null) {
            return;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.nsdk_driving_habit_item_tv);
        TextView textView2 = (TextView) inflate.findViewById(R.id.nsdk_driving_habit_item_summary_tv);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.nsdk_driving_habit_item_select);
        View findViewById = inflate.findViewById(R.id.nsdk_driving_habit_item_underline);
        textView.setText(aVar.f7481a);
        if (TextUtils.isEmpty(aVar.b)) {
            textView2.setVisibility(4);
        } else {
            textView2.setText(aVar.b);
        }
        if (z) {
            i2 = R.drawable.nsdk_drawable_driving_habit_selected;
        } else {
            i2 = R.drawable.nsdk_drawable_driving_habit_unselect;
        }
        imageView.setImageResource(i2);
        if (!z2) {
            findViewById.setVisibility(8);
        }
        inflate.setOnClickListener(this);
        inflate.setTag(Integer.valueOf(i));
        Resources resources = context.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.navi_dimens_59dp));
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.navi_dimens_15dp);
        inflate.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        viewGroup.addView(inflate, layoutParams);
        this.d[i] = imageView;
        if (z) {
            this.e |= aVar.c;
            this.f = i;
        }
    }

    public void a() {
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
