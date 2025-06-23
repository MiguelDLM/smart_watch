package com.baidu.navisdk.module.trucknavi.view.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.trucknavi.c;
import com.baidu.navisdk.module.trucknavi.logic.plate.d;
import com.baidu.navisdk.module.trucknavi.view.support.module.setting.widgets.TruckEditPlateView;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSelectItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class TruckVehicleInfoView extends LinearLayout implements BNSettingExplainSwitchItem.c, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private d f7591a;
    private View b;
    private View c;
    private TextView d;
    private TextView e;
    private BNSettingExplainSelectItem f;
    private BNSettingExplainSwitchItem g;
    private BNSettingExplainSwitchItem h;
    private View.OnClickListener i;
    private BNSettingExplainSwitchItem.c j;
    private BNSettingExplainSwitchItem.c k;
    private TruckEditPlateView l;
    private ImageView m;
    private boolean n;
    private int o;
    private int p;
    private View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id != R.id.truck_plate_bg && id != R.id.truck_edit_plate_edit_img) {
                if (id == R.id.truck_edit_plate_view && TruckVehicleInfoView.this.l != null) {
                    TruckVehicleInfoView.this.l.a();
                    return;
                }
                return;
            }
            if (TruckVehicleInfoView.this.l != null) {
                TruckVehicleInfoView.this.l.a(TruckVehicleInfoView.this.f7591a);
            }
        }
    }

    public TruckVehicleInfoView(Context context) {
        this(context, null);
    }

    private void setLimitDescribe(boolean z) {
        String str;
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.g;
        if (bNSettingExplainSwitchItem != null) {
            if (z) {
                str = "已为您避开限行路线和限行区域";
            } else {
                str = "开启后可避开限行路线和限行区域";
            }
            bNSettingExplainSwitchItem.setSubText(str);
        }
    }

    private void setWeightLimitDescribe(boolean z) {
        String str;
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.h;
        if (bNSettingExplainSwitchItem != null) {
            if (z) {
                str = "已为您避开道路限重区域";
            } else {
                str = "开启后可避开道路限重区域";
            }
            bNSettingExplainSwitchItem.setSubText(str);
        }
    }

    public String getCurrentPlateNum() {
        d dVar = this.f7591a;
        if (dVar == null) {
            return "";
        }
        return dVar.getPlate();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem.c
    public boolean onChecked(int i, boolean z) {
        if (i == R.id.truck_nav_plate_limit_item) {
            BNSettingExplainSwitchItem.c cVar = this.j;
            if (cVar != null) {
                cVar.onChecked(i, z);
            }
            setLimitDescribe(z);
            return true;
        }
        if (i == R.id.truck_nav_weight_limit_item) {
            BNSettingExplainSwitchItem.c cVar2 = this.k;
            if (cVar2 != null) {
                cVar2.onChecked(i, z);
            }
            setWeightLimitDescribe(z);
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if (view.getId() == R.id.truck_rr_navi_passport_item && (onClickListener = this.i) != null) {
            onClickListener.onClick(view);
        }
    }

    public void setLimitCheckedListener(BNSettingExplainSwitchItem.c cVar) {
        this.j = cVar;
    }

    public void setPassportItemClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void setPlateClickListener(TruckEditPlateView.b bVar) {
        TruckEditPlateView truckEditPlateView = this.l;
        if (truckEditPlateView != null) {
            truckEditPlateView.setPlateClickListener(bVar);
        }
    }

    public void setPlateLimitChecked(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.g;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
            setLimitDescribe(z);
        }
    }

    public void setPlateWeightLimitChecked(boolean z) {
        if (this.g != null) {
            this.h.setChecked(z);
            setWeightLimitDescribe(z);
        }
    }

    public void setWeightLimitCheckedListener(BNSettingExplainSwitchItem.c cVar) {
        this.k = cVar;
    }

    public TruckVehicleInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        b(context, attributeSet);
        int i = R.layout.bnav_layout_truck_setting_vehicle_info;
        if (this.n) {
            b.a(context, i, this);
        } else {
            JarUtils.inflate(context, i, this);
        }
        this.b = findViewById(R.id.truck_info_header);
        this.l = (TruckEditPlateView) findViewById(R.id.truck_edit_plate_view);
        this.c = findViewById(R.id.truck_plate_bg);
        this.d = (TextView) findViewById(R.id.truck_plate_title_text);
        this.e = (TextView) findViewById(R.id.truck_detail);
        this.m = (ImageView) findViewById(R.id.truck_edit_plate_edit_img);
        this.f = (BNSettingExplainSelectItem) findViewById(R.id.truck_rr_navi_passport_item);
        this.g = (BNSettingExplainSwitchItem) findViewById(R.id.truck_nav_plate_limit_item);
        this.h = (BNSettingExplainSwitchItem) findViewById(R.id.truck_nav_weight_limit_item);
        this.f.setOnClickListener(this);
        this.g.setOnCheckedListener(this);
        this.h.setOnCheckedListener(this);
        if (this.n) {
            b.a(this, R.color.nsdk_cl_bg_c);
            b.a(this.b, R.color.nsdk_cl_bg_d);
        } else {
            setBackgroundColor(JarUtils.getResources().getColor(R.color.nsdk_cl_bg_c));
            this.b.setBackgroundColor(JarUtils.getResources().getColor(R.color.nsdk_cl_bg_d));
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TruckVehicleInfoView)) == null) {
            return;
        }
        this.n = obtainStyledAttributes.getBoolean(R.styleable.TruckVehicleInfoView_nsdk_truck_vehicle_info_view_support_day_night, false);
        obtainStyledAttributes.recycle();
    }

    public TruckVehicleInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new a();
        a(context, attributeSet);
    }

    private void a(int i, boolean z) {
        Drawable f;
        int b;
        if (i == 1) {
            this.o = R.drawable.bnav_setting_truck_trailer_plate_info_bg;
            this.p = R.color.nsdk_setting_truck_trailer_plate_info_text;
        } else if (i == 3) {
            this.o = R.drawable.bnav_setting_truck_electric_plate_info_bg;
            this.p = R.color.nsdk_setting_truck_electric_plate_info_text;
        } else if (i == 4) {
            this.o = R.drawable.bnav_setting_truck_two_place_plate_info_bg;
            this.p = R.color.nsdk_setting_truck_two_place_plate_info_text;
        } else {
            this.o = R.drawable.bnav_setting_truck_normal_plate_info_bg;
            this.p = R.color.nsdk_setting_truck_normal_plate_info_text;
        }
        if (this.c == null || this.d == null || this.e == null) {
            return;
        }
        if (this.n) {
            f = JarUtils.getResources().getDrawable(this.o);
            b = JarUtils.getResources().getColor(this.p);
        } else {
            f = b.f(this.o);
            b = b.b(this.p);
        }
        this.c.setBackgroundDrawable(f);
        this.d.setTextColor(b);
        this.e.setTextColor(b);
    }

    private void a(float f, float f2, float f3, float f4) {
        if (this.e != null) {
            this.e.setText("总质量" + c.a(f) + "吨/长" + c.a(f2) + "米/宽" + c.a(f3) + "米/高" + c.a(f4) + "米");
        }
    }

    public void a(d dVar, boolean z) {
        View.OnClickListener onClickListener = z ? null : this.q;
        this.f7591a = dVar;
        if (dVar != null && !TextUtils.isEmpty(dVar.getPlate())) {
            this.l.setVisibility(8);
            this.c.setVisibility(0);
            this.m.setVisibility(z ? 8 : 0);
            this.d.setText(dVar.getPlate());
            a(dVar.e, dVar.f, dVar.g, dVar.h);
            this.m.setOnClickListener(onClickListener);
            a(dVar.d, dVar.f7582a == 5);
            this.c.setOnClickListener(onClickListener);
            this.l.setOnClickListener(null);
            return;
        }
        this.c.setVisibility(8);
        this.m.setVisibility(8);
        this.l.setVisibility(0);
        this.l.b();
        this.l.setOnClickListener(onClickListener);
        this.c.setOnClickListener(null);
    }

    public void a(boolean z) {
        if (this.n) {
            BNSettingExplainSelectItem bNSettingExplainSelectItem = this.f;
            if (bNSettingExplainSelectItem != null) {
                bNSettingExplainSelectItem.a(z);
            }
            BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.g;
            if (bNSettingExplainSwitchItem != null) {
                bNSettingExplainSwitchItem.a(z);
            }
            BNSettingExplainSwitchItem bNSettingExplainSwitchItem2 = this.h;
            if (bNSettingExplainSwitchItem2 != null) {
                bNSettingExplainSwitchItem2.a(z);
            }
            TruckEditPlateView truckEditPlateView = this.l;
            if (truckEditPlateView != null) {
                truckEditPlateView.a(z);
            }
        }
    }
}
