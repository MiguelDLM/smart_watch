package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.plate.layout.ItemInfoWidget;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.util.common.g;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class TruckInfoLayout extends BNLinearLayout implements ItemInfoWidget.c, View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private ItemInfoWidget f7420a;
    private ItemInfoWidget b;
    private ItemInfoWidget c;
    private ItemInfoWidget d;
    private ItemInfoWidget e;
    private ItemInfoWidget f;
    private ArrayList<ItemInfoWidget> g;
    private final String[] h;
    private final int[] i;
    private final String[] j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private final Context r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.module.plate.controller.a.e().a();
        }
    }

    public TruckInfoLayout(Context context) {
        this(context, null);
    }

    private void d() {
        for (int i = 0; i < this.i.length; i++) {
            this.g.get(i).setEditHint("0 ~ " + this.i[i]);
        }
    }

    private void e() {
        for (int i = 0; i < this.h.length; i++) {
            this.g.get(i).setTitle(this.h[i]);
        }
    }

    private void f() {
        for (int i = 0; i < this.j.length; i++) {
            this.g.get(i).setUnit(this.j[i]);
        }
    }

    private void initView() {
        this.g = new ArrayList<>();
        ItemInfoWidget itemInfoWidget = (ItemInfoWidget) findViewById(R.id.truck_total_weight);
        this.f7420a = itemInfoWidget;
        itemInfoWidget.setTag(1);
        this.f7420a.setOnTextChangedListener(this);
        this.f7420a.setHintOnFocusChangedListener(this);
        this.g.add(this.f7420a);
        ItemInfoWidget itemInfoWidget2 = (ItemInfoWidget) findViewById(R.id.truck_approved_load);
        this.b = itemInfoWidget2;
        itemInfoWidget2.setTag(2);
        this.b.setOnTextChangedListener(this);
        this.b.setHintOnFocusChangedListener(this);
        this.g.add(this.b);
        ItemInfoWidget itemInfoWidget3 = (ItemInfoWidget) findViewById(R.id.truck_length);
        this.c = itemInfoWidget3;
        itemInfoWidget3.setTag(3);
        this.c.setOnTextChangedListener(this);
        this.c.setHintOnFocusChangedListener(this);
        this.g.add(this.c);
        ItemInfoWidget itemInfoWidget4 = (ItemInfoWidget) findViewById(R.id.truck_width);
        this.d = itemInfoWidget4;
        itemInfoWidget4.setTag(4);
        this.d.setOnTextChangedListener(this);
        this.d.setHintOnFocusChangedListener(this);
        this.g.add(this.d);
        ItemInfoWidget itemInfoWidget5 = (ItemInfoWidget) findViewById(R.id.truck_height);
        this.e = itemInfoWidget5;
        itemInfoWidget5.setTag(5);
        this.e.setOnTextChangedListener(this);
        this.e.setHintOnFocusChangedListener(this);
        this.g.add(this.e);
        ItemInfoWidget itemInfoWidget6 = (ItemInfoWidget) findViewById(R.id.truck_axes);
        this.f = itemInfoWidget6;
        itemInfoWidget6.setEditTipHint("请输入轴数");
        this.f.setTag(6);
        this.g.add(this.f);
        this.f.setOnClickListener(new a());
        e();
        d();
        f();
    }

    public void a() {
        e();
        d();
        f();
        com.baidu.navisdk.module.plate.controller.a.e().a(0);
        setTruckAxleNum(0);
    }

    public boolean b() {
        if (this.l > this.m) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.l != 0.0f && this.m != 0.0f && this.k != 0.0f && this.o != 0.0f && this.n != 0.0f && this.p != 0) {
            return true;
        }
        return false;
    }

    public float getTruckApprovedLoad() {
        return this.m;
    }

    public int getTruckAxleNum() {
        return this.p;
    }

    public int getTruckEmission() {
        return this.q;
    }

    public float getTruckHeight() {
        return this.o;
    }

    public float getTruckLength() {
        return this.k;
    }

    public float getTruckTotalWeight() {
        return this.l;
    }

    public float getTruckWidth() {
        return this.n;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            com.baidu.navisdk.module.plate.controller.a.e().a("货车填写信息收起归属地");
        }
    }

    public void setTruckApprovedLoad(float f) {
        this.m = f;
    }

    public void setTruckAxleNum(int i) {
        this.p = i;
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("TruckInfoLayout", "setTruckAxleNum: truckAxleNum " + i);
        }
        if (i == 20) {
            this.f.setEditTipText("6轴以上");
        } else if (i == 0) {
            this.f.setEditTipText("");
            this.f.setEditTipHint("请输入轴数");
        } else {
            this.f.setEditTipText(i + "轴");
        }
        if (c()) {
            com.baidu.navisdk.module.plate.controller.a.e().a(true);
        }
    }

    public void setTruckEmission(int i) {
        this.q = i;
    }

    public void setTruckHeight(float f) {
        this.o = f;
    }

    public void setTruckLength(float f) {
        this.k = f;
    }

    public void setTruckTotalWeight(float f) {
        this.l = f;
    }

    public void setTruckWidth(float f) {
        this.n = f;
    }

    public TruckInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TruckInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = context;
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_truck_info, (ViewGroup) this, true);
        this.h = getResources().getStringArray(R.array.truck_title_array);
        this.i = getResources().getIntArray(R.array.truck_hint_array);
        this.j = getResources().getStringArray(R.array.truck_unit_array);
        initView();
    }

    @Override // com.baidu.navisdk.module.plate.layout.ItemInfoWidget.c
    public boolean a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.length() > 1 && str.charAt(0) == '0' && str.charAt(1) != '.') {
            str = str.substring(1);
        }
        if (str.equals(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            str = "0.";
        }
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("TruckInfoLayout", "onTextChanged: s " + str);
        }
        a(i, Float.parseFloat(str));
        if (gVar.d()) {
            gVar.e("TruckInfoLayout", "onTextChanged: truckInfoIsValid " + c());
        }
        com.baidu.navisdk.module.plate.controller.a.e().a(c());
        return false;
    }

    private void a(int i, float f) {
        if (i == 1) {
            int i2 = this.i[0];
            if (f > i2) {
                this.f7420a.setEditText(String.valueOf(i2));
                setTruckTotalWeight(this.i[0]);
                TipTool.onCreateToastDialog(this.r, "限制最大值为" + this.i[0]);
                return;
            }
            setTruckTotalWeight(f);
            return;
        }
        if (i == 2) {
            int i3 = this.i[1];
            if (f > i3) {
                this.b.setEditText(String.valueOf(i3));
                setTruckApprovedLoad(this.i[1]);
                TipTool.onCreateToastDialog(this.r, "限制最大值为" + this.i[1]);
                return;
            }
            setTruckApprovedLoad(f);
            return;
        }
        if (i == 3) {
            int i4 = this.i[2];
            if (f > i4) {
                this.c.setEditText(String.valueOf(i4));
                setTruckLength(this.i[2]);
                TipTool.onCreateToastDialog(this.r, "限制最大值为" + this.i[2]);
                return;
            }
            setTruckLength(f);
            return;
        }
        if (i == 4) {
            int i5 = this.i[3];
            if (f > i5) {
                this.d.setEditText(String.valueOf(i5));
                setTruckWidth(this.i[3]);
                TipTool.onCreateToastDialog(this.r, "限制最大值为" + this.i[3]);
                return;
            }
            setTruckWidth(f);
            return;
        }
        if (i != 5) {
            return;
        }
        int i6 = this.i[4];
        if (f > i6) {
            this.e.setEditText(String.valueOf(i6));
            setTruckHeight(this.i[4]);
            TipTool.onCreateToastDialog(this.r, "限制最大值为" + this.i[4]);
            return;
        }
        setTruckHeight(f);
    }
}
