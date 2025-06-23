package com.baidu.navisdk.module.trucknavi.view.support.module.setting.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.trucknavi.logic.plate.d;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class TruckEditPlateView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private b f7588a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private ImageView e;

    @DrawableRes
    private int f;

    @ColorRes
    private int g;

    @ColorRes
    private int h;

    @DrawableRes
    private int i;
    private boolean j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckSettingLayoutPlateView", "onClick add plate: ");
            }
            TruckEditPlateView.this.a();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(d dVar);

        void b();
    }

    public TruckEditPlateView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.motor_layout_setting_edit_plate, (ViewGroup) this, true);
        this.c = (TextView) findViewById(R.id.motor_edit_plate_title_text);
        this.b = (TextView) findViewById(R.id.motor_edit_plate_tips);
        this.d = (ImageView) findViewById(R.id.motor_edit_plate_img);
        this.e = (ImageView) findViewById(R.id.motor_edit_plate_edit_img);
    }

    public void b() {
        this.e.setVisibility(8);
        this.f = R.drawable.motor_drawable_add_plate_bg;
        int i = R.drawable.motor_icon_plate_add;
        this.i = i;
        this.d.setOnClickListener(new a());
        this.d.setImageResource(i);
        this.g = R.color.motor_add_plate_text_color;
        this.h = R.color.motor_add_plate_tips_color;
        this.c.setText(R.string.truck_add_plate);
        this.b.setText(R.string.truck_add_plate_avoid_limit);
        int i2 = this.f;
        if (i2 != 0) {
            setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i2));
        }
        int i3 = this.h;
        if (i3 != 0) {
            this.b.setTextColor(com.baidu.navisdk.ui.util.b.b(i3));
        }
        int i4 = this.g;
        if (i4 != 0) {
            this.c.setTextColor(com.baidu.navisdk.ui.util.b.b(i4));
        }
        int i5 = this.i;
        if (i5 != 0) {
            this.d.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i5));
        }
    }

    public void setIsSupportDayNight(boolean z) {
    }

    public void setPlateClickListener(b bVar) {
        this.f7588a = bVar;
    }

    public TruckEditPlateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TruckEditPlateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = true;
        a(context);
    }

    public void a(d dVar) {
        b bVar = this.f7588a;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void a() {
        b bVar = this.f7588a;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        int i = this.f;
        if (i != 0) {
            setBackgroundDrawable(com.baidu.navisdk.ui.util.b.c(i, z));
        }
        int i2 = this.h;
        if (i2 != 0) {
            this.b.setTextColor(com.baidu.navisdk.ui.util.b.a(i2, z));
        }
        int i3 = this.g;
        if (i3 != 0) {
            this.c.setTextColor(com.baidu.navisdk.ui.util.b.a(i3, z));
        }
        int i4 = this.i;
        if (i4 != 0) {
            this.d.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i4));
        }
    }
}
