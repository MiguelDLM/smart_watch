package com.baidu.navisdk.module.plate.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.y;
import java.util.List;

/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<e> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7380a;
    private int b;
    private int c;
    private int d = 0;
    private d e;
    private com.baidu.navisdk.module.plate.c f;
    private List<com.baidu.navisdk.module.plate.base.a> g;

    /* renamed from: com.baidu.navisdk.module.plate.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0273a implements View.OnClickListener {
        public ViewOnClickListenerC0273a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!y.d(a.this.f7380a)) {
                TipTool.onCreateToastDialog(a.this.f7380a, "当前无网络，车牌限行不可用");
            } else {
                if (a.this.b < 10) {
                    if (a.this.e != null) {
                        a.this.e.c();
                        return;
                    }
                    return;
                }
                TipTool.onCreateToastDialog(a.this.f7380a, "添加车辆已达上限，请删除车辆后添加");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7382a;

        public b(int i) {
            this.f7382a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = a.this.d;
            int i2 = this.f7382a;
            if (i != i2) {
                a.this.d = i2;
                if (!y.d(a.this.f7380a)) {
                    TipTool.onCreateToastDialog(a.this.f7380a, "当前无网络，车牌限行不可用");
                } else {
                    a aVar = a.this;
                    aVar.a(aVar.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7383a;

        public c(int i) {
            this.f7383a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e != null && a.this.g != null) {
                if (!y.d(a.this.f7380a)) {
                    TipTool.onCreateToastDialog(a.this.f7380a, "当前无网络，请稍后再试");
                } else {
                    a.this.e.a(((com.baidu.navisdk.module.plate.base.a) a.this.g.get(this.f7383a)).f7385a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(String str);

        void c();
    }

    /* loaded from: classes7.dex */
    public static class e extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f7384a;
        private final TextView b;
        private final RelativeLayout c;
        private final ImageView d;
        private final ImageView e;
        private final View f;
        private final View g;
        private final View h;

        public e(@NonNull View view) {
            super(view);
            this.h = view.findViewById(R.id.plate_limit_setting_recycle_container);
            this.f7384a = (TextView) view.findViewById(R.id.plate_title);
            this.b = (TextView) view.findViewById(R.id.plate_title_default);
            this.c = (RelativeLayout) view.findViewById(R.id.plate_btn_edit_layout);
            this.d = (ImageView) view.findViewById(R.id.plate_car_type_image);
            this.f = view.findViewById(R.id.plate_edit_container);
            this.g = view.findViewById(R.id.plate_add_container);
            this.e = (ImageView) view.findViewById(R.id.plate_edit_add);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, int i) {
            float dimension;
            View view = this.h;
            if (view == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i > 2) {
                dimension = context.getResources().getDimension(R.dimen.navi_dimens_138dp);
            } else {
                dimension = context.getResources().getDimension(R.dimen.navi_dimens_155dp);
            }
            layoutParams.width = (int) dimension;
            layoutParams.height = (int) context.getResources().getDimension(R.dimen.navi_dimens_106dp);
            this.h.setLayoutParams(layoutParams);
        }
    }

    public a(Context context, int i, int i2, int i3) {
        this.f7380a = context;
        this.b = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new e(LayoutInflater.from(this.f7380a).inflate(R.layout.bnav_plate_limit_setting_panel_recycle_layout, viewGroup, false));
    }

    private boolean b() {
        return this.c == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i) {
        int adapterPosition = eVar.getAdapterPosition();
        eVar.a(this.f7380a, getItemCount());
        int i2 = this.b;
        if (i2 >= 1) {
            if (i2 != adapterPosition) {
                eVar.g.setVisibility(8);
                eVar.f.setVisibility(0);
                eVar.f.setOnClickListener(new b(adapterPosition));
                if (this.g != null) {
                    eVar.f7384a.setText(this.g.get(adapterPosition).f7385a);
                    if (!b()) {
                        eVar.b.setText(this.g.get(adapterPosition).i == 1 ? "默认车辆" : "待选车辆");
                        if (this.g.get(adapterPosition).i == 1) {
                            eVar.f.setBackground(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_select_bg));
                        } else {
                            eVar.f.setBackground(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_no_select_bg));
                        }
                    } else {
                        eVar.b.setText(this.g.get(adapterPosition).l == 1 ? "默认车辆" : "待选车辆");
                        if (this.g.get(adapterPosition).l == 1) {
                            eVar.f.setBackground(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_energy_select_bg));
                        } else {
                            eVar.f.setBackground(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_energy_no_select_bg));
                        }
                    }
                    if (b()) {
                        eVar.d.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_energy_image));
                    } else if (this.g.get(adapterPosition).j == 1) {
                        if (this.g.get(adapterPosition).k == 1) {
                            eVar.d.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_pickup_image));
                        } else {
                            eVar.d.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_car_image));
                        }
                    } else if (this.g.get(adapterPosition).j == 2) {
                        eVar.d.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_motor_image));
                    } else if (this.g.get(adapterPosition).j == 3) {
                        eVar.d.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_truck_image));
                    }
                }
                eVar.c.setOnClickListener(new c(adapterPosition));
                return;
            }
            eVar.f.setVisibility(8);
            eVar.g.setVisibility(0);
            if (b()) {
                eVar.e.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_energy_limit_setting_add));
            } else {
                eVar.e.setImageDrawable(this.f7380a.getResources().getDrawable(R.drawable.bnav_plate_limit_setting_add));
            }
            eVar.g.setOnClickListener(new ViewOnClickListenerC0273a());
        }
    }

    public void a() {
        if (this.e != null) {
            this.e = null;
        }
        this.f = null;
    }

    public void a(List<com.baidu.navisdk.module.plate.base.a> list) {
        this.g = list;
        this.b = list.size();
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("vehicle", this.g.get(i).j);
        bundle.putInt("ext_tag", this.g.get(i).k);
        bundle.putString("plate", this.g.get(i).f7385a);
        bundle.putInt("electric_plate_type", this.c);
        com.baidu.navisdk.framework.b.e(bundle, this.f);
    }
}
