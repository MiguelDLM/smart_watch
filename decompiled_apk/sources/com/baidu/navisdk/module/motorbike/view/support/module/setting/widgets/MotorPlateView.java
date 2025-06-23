package com.baidu.navisdk.module.motorbike.view.support.module.setting.widgets;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class MotorPlateView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private c f7201a;
    private com.baidu.navisdk.module.motorbike.logic.plate.c b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;

    @DrawableRes
    private int g;

    @ColorRes
    private int h;

    @ColorRes
    private int i;

    @DrawableRes
    private int j;
    private boolean k;
    private boolean l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutPlateView", "onClick add plate: ");
            }
            if (MotorPlateView.this.f7201a != null) {
                MotorPlateView.this.f7201a.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutPlateView", "onClick edit plate: " + MotorPlateView.this.b);
            }
            if (MotorPlateView.this.f7201a != null && MotorPlateView.this.b != null) {
                MotorPlateView.this.f7201a.a(MotorPlateView.this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(com.baidu.navisdk.module.motorbike.logic.plate.c cVar);

        void b();
    }

    public MotorPlateView(Context context) {
        this(context, null);
    }

    public String getCurrentPlateNum() {
        com.baidu.navisdk.module.motorbike.logic.plate.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.getPlate();
    }

    public void setIsSupportDayNight(boolean z) {
        this.l = z;
    }

    public void setPlateClickListener(c cVar) {
        this.f7201a = cVar;
    }

    public MotorPlateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.motor_layout_setting_edit_plate, (ViewGroup) this, true);
        this.d = (TextView) findViewById(R.id.motor_edit_plate_title_text);
        this.c = (TextView) findViewById(R.id.motor_edit_plate_tips);
        this.e = (ImageView) findViewById(R.id.motor_edit_plate_img);
        this.f = (ImageView) findViewById(R.id.motor_edit_plate_edit_img);
    }

    public void b(boolean z) {
        TextView textView;
        com.baidu.navisdk.module.motorbike.logic.plate.c cVar = this.b;
        if (cVar == null || TextUtils.isEmpty(cVar.getPlate()) || (textView = this.c) == null) {
            return;
        }
        textView.setText(z ? R.string.motor_open_limit_tips : R.string.motor_not_open_limit_tips);
    }

    public MotorPlateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = true;
        this.l = true;
        a(context);
    }

    private void b(com.baidu.navisdk.module.motorbike.logic.plate.c cVar, boolean z) {
        this.f.setVisibility(0);
        this.e.setOnClickListener(null);
        this.j = R.drawable.motor_icon_plate_user;
        this.f.setOnClickListener(new b());
        this.d.setText(cVar.getPlate());
        if (cVar.a()) {
            this.g = R.drawable.motor_drawable_edit_blue_plate_bg;
            int i = R.color.motor_blue_plate_text_color;
            this.h = i;
            this.i = i;
        } else {
            this.g = R.drawable.motor_drawable_edit_yellow_plate_bg;
            int i2 = R.color.motor_yellow_plate_text_color;
            this.h = i2;
            this.i = i2;
        }
        b(z);
    }

    public void a(boolean z) {
        if (this.k == z) {
            return;
        }
        this.k = z;
        int i = this.g;
        if (i != 0) {
            setBackgroundDrawable(com.baidu.navisdk.ui.util.b.c(i, z));
        }
        int i2 = this.i;
        if (i2 != 0) {
            this.c.setTextColor(com.baidu.navisdk.ui.util.b.a(i2, z));
        }
        int i3 = this.h;
        if (i3 != 0) {
            this.d.setTextColor(com.baidu.navisdk.ui.util.b.a(i3, z));
        }
        int i4 = this.j;
        if (i4 != 0) {
            this.e.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i4, z));
        }
    }

    public void a(com.baidu.navisdk.module.motorbike.logic.plate.c cVar, boolean z) {
        this.b = cVar;
        if (cVar != null && !TextUtils.isEmpty(cVar.getPlate())) {
            b(cVar, z);
        } else {
            a();
        }
        if (this.l) {
            int i = this.g;
            if (i != 0) {
                setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            }
            int i2 = this.i;
            if (i2 != 0) {
                this.c.setTextColor(com.baidu.navisdk.ui.util.b.b(i2));
            }
            int i3 = this.h;
            if (i3 != 0) {
                this.d.setTextColor(com.baidu.navisdk.ui.util.b.b(i3));
            }
            int i4 = this.j;
            if (i4 != 0) {
                this.e.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i4));
                return;
            }
            return;
        }
        if (this.g != 0) {
            setBackgroundDrawable(JarUtils.getResources().getDrawable(this.g));
        }
        if (this.i != 0) {
            this.c.setTextColor(JarUtils.getResources().getColor(this.i));
        }
        if (this.h != 0) {
            this.d.setTextColor(JarUtils.getResources().getColor(this.h));
        }
        if (this.j != 0) {
            this.e.setImageDrawable(JarUtils.getResources().getDrawable(this.j));
        }
    }

    private void a() {
        this.f.setVisibility(8);
        this.g = R.drawable.motor_drawable_add_plate_bg;
        this.e.setOnClickListener(new a());
        this.j = R.drawable.motor_icon_plate_add;
        this.h = R.color.motor_add_plate_text_color;
        this.i = R.color.motor_add_plate_tips_color;
        this.d.setText(R.string.motor_add_plate);
        this.c.setText(R.string.motor_add_plate_avoid_limit);
    }
}
