package com.baidu.navisdk.module.future.panel.bottom;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class FutureTripMainPanelTopView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<d> f7167a;
    private ArrayList<c> b;
    private b c;

    /* loaded from: classes7.dex */
    public interface b {
        String a(int i);
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private View f7168a;
        private ImageView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private ImageView f;

        private c() {
        }

        public c a(View view) {
            this.f7168a = view;
            return this;
        }

        public c b(ImageView imageView) {
            this.b = imageView;
            return this;
        }

        public final ImageView c() {
            return this.b;
        }

        public final TextView d() {
            return this.d;
        }

        public final View e() {
            return this.f7168a;
        }

        public final TextView a() {
            return this.e;
        }

        public final TextView b() {
            return this.c;
        }

        public c c(TextView textView) {
            this.d = textView;
            return this;
        }

        public c a(TextView textView) {
            this.e = textView;
            return this;
        }

        public c b(TextView textView) {
            this.c = textView;
            return this;
        }

        public c a(ImageView imageView) {
            this.f = imageView;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        @StringRes
        int f7169a;

        @DrawableRes
        int b;

        private d() {
        }
    }

    public FutureTripMainPanelTopView(Context context) {
        super(context);
        this.f7167a = new ArrayList<>(2);
        this.b = new ArrayList<>(2);
        d dVar = new d();
        dVar.f7169a = R.string.nsdk_future_trip_depart_time;
        dVar.b = R.drawable.nsdk_bg_future_trip_panel_top_green_timing_section;
        d dVar2 = new d();
        dVar2.f7169a = R.string.nsdk_future_trip_arrive_time;
        dVar2.b = R.drawable.nsdk_bg_future_trip_panel_top_red_timing_section;
        this.f7167a.add(0, dVar);
        this.f7167a.add(1, dVar2);
        b();
    }

    private void a(c cVar, int i) {
        View findViewById = findViewById(i);
        cVar.a(findViewById);
        cVar.b((ImageView) findViewById.findViewById(R.id.desc_img));
        cVar.b((TextView) findViewById.findViewById(R.id.desc));
        cVar.c((TextView) findViewById.findViewById(R.id.time));
        cVar.a((TextView) findViewById.findViewById(R.id.date));
        cVar.a((ImageView) findViewById.findViewById(R.id.arrow));
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_future_trip_main_panel_top, this);
        c cVar = new c();
        c cVar2 = new c();
        a(cVar, R.id.left_timing_layout);
        a(cVar2, R.id.right_timing_layout);
        setDividerDrawable(getResources().getDrawable(R.drawable.bnav_bg_future_trip_timing_panel_divider));
        setOrientation(0);
        setShowDividers(2);
        this.b.add(0, cVar);
        this.b.add(1, cVar2);
        c();
    }

    private void c() {
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = this.b.get(i);
            cVar.e().setOnClickListener(this);
            cVar.b().setText(this.f7167a.get(i).f7169a);
            cVar.c().setBackgroundResource(this.f7167a.get(i).b);
        }
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        b bVar = this.c;
        if (bVar != null) {
            if (view.getId() == R.id.left_timing_layout) {
                i = 0;
            } else {
                i = 1;
            }
            String a2 = bVar.a(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("FutureTripMainPanelTopView", "onClick,ret->" + a2);
                return;
            }
            return;
        }
        if (!LogUtil.LOGGABLE) {
        } else {
            throw new IllegalStateException("mActionListener should not be null!!!");
        }
    }

    public void setActionListener(@NonNull b bVar) {
        this.c = bVar;
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.get(i).d().setText("--:--");
        } else {
            this.b.get(i).d().setText(str);
        }
    }

    public final void a() {
        b(1, "");
        a(1, "--:--");
        b(0, "");
        a(0, "--:--");
    }

    public FutureTripMainPanelTopView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7167a = new ArrayList<>(2);
        this.b = new ArrayList<>(2);
        d dVar = new d();
        dVar.f7169a = R.string.nsdk_future_trip_depart_time;
        dVar.b = R.drawable.nsdk_bg_future_trip_panel_top_green_timing_section;
        d dVar2 = new d();
        dVar2.f7169a = R.string.nsdk_future_trip_arrive_time;
        dVar2.b = R.drawable.nsdk_bg_future_trip_panel_top_red_timing_section;
        this.f7167a.add(0, dVar);
        this.f7167a.add(1, dVar2);
        b();
    }

    private final void b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.get(i).a().setVisibility(8);
        } else {
            this.b.get(i).a().setVisibility(0);
            this.b.get(i).a().setText(str);
        }
    }

    public FutureTripMainPanelTopView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7167a = new ArrayList<>(2);
        this.b = new ArrayList<>(2);
        d dVar = new d();
        dVar.f7169a = R.string.nsdk_future_trip_depart_time;
        dVar.b = R.drawable.nsdk_bg_future_trip_panel_top_green_timing_section;
        d dVar2 = new d();
        dVar2.f7169a = R.string.nsdk_future_trip_arrive_time;
        dVar2.b = R.drawable.nsdk_bg_future_trip_panel_top_red_timing_section;
        this.f7167a.add(0, dVar);
        this.f7167a.add(1, dVar2);
        b();
    }
}
