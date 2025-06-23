package com.baidu.navisdk.module.routepreference.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class RoutePreferSeekBarView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private SeekBar f7487a;
    private TextView b;
    private TextView c;
    private c d;
    private RelativeLayout e;

    /* loaded from: classes7.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (RoutePreferSeekBarView.this.d != null) {
                RoutePreferSeekBarView.this.d.a(i);
            }
            RoutePreferSeekBarView routePreferSeekBarView = RoutePreferSeekBarView.this;
            routePreferSeekBarView.a(routePreferSeekBarView.b);
            RoutePreferSeekBarView routePreferSeekBarView2 = RoutePreferSeekBarView.this;
            routePreferSeekBarView2.a(routePreferSeekBarView2.c);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            RoutePreferSeekBarView.this.b.setVisibility(8);
            if (RoutePreferSeekBarView.this.c != null) {
                RoutePreferSeekBarView.this.c.setVisibility(0);
            }
            RoutePreferSeekBarView.this.f7487a.setThumb(RoutePreferSeekBarView.this.getContext().getResources().getDrawable(R.drawable.nsdk_route_prefer_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            RoutePreferSeekBarView.this.b.setVisibility(0);
            if (RoutePreferSeekBarView.this.c != null) {
                RoutePreferSeekBarView.this.c.setVisibility(8);
            }
            if (RoutePreferSeekBarView.this.d != null) {
                RoutePreferSeekBarView.this.d.b(RoutePreferSeekBarView.this.f7487a.getProgress());
            }
            RoutePreferSeekBarView.this.f7487a.setThumb(RoutePreferSeekBarView.this.getContext().getResources().getDrawable(R.drawable.nsdk_route_prefer_seekbar_thumb_normal));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLayoutChangeListener {

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RoutePreferSeekBarView routePreferSeekBarView = RoutePreferSeekBarView.this;
                routePreferSeekBarView.a(routePreferSeekBarView.b);
            }
        }

        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            RoutePreferSeekBarView.this.post(new a());
            RoutePreferSeekBarView.this.b.removeOnLayoutChangeListener(this);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i);

        void b(int i);
    }

    public RoutePreferSeekBarView(@NonNull Context context) {
        super(context);
        a();
    }

    private ImageView getTagView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nsdk_route_prefer_seekbar_tag));
        return imageView;
    }

    public void setBottomHintViewText(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCallBack(c cVar) {
        this.d = cVar;
    }

    public void setProgress(int i) {
        this.f7487a.setProgress(i);
    }

    public void setTopHintView(TextView textView) {
        this.c = textView;
    }

    public void setTopHintViewText(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public RoutePreferSeekBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_route_prefer_seekbar_view, this);
        this.f7487a = (SeekBar) findViewById(R.id.seekbar);
        this.b = (TextView) findViewById(R.id.bottomHintView);
        this.e = (RelativeLayout) findViewById(R.id.progressTag);
        this.f7487a.setOnSeekBarChangeListener(new a());
        this.b.addOnLayoutChangeListener(new b());
    }

    public RoutePreferSeekBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.f7487a == null || view == null) {
            return;
        }
        int width = view.getWidth();
        int width2 = ((this.f7487a.getWidth() * this.f7487a.getProgress()) / 100) - (width / 2);
        int width3 = (this.f7487a.getWidth() - this.f7487a.getPaddingRight()) - width;
        int paddingLeft = this.f7487a.getPaddingLeft();
        if (view == this.c) {
            width3 += ScreenUtil.getInstance().dip2px(15);
            paddingLeft -= ScreenUtil.getInstance().dip2px(20);
        }
        if (width2 < paddingLeft) {
            width2 = paddingLeft;
        }
        if (width2 <= width3) {
            width3 = width2;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = width3;
            view.setLayoutParams(layoutParams);
        }
    }
}
