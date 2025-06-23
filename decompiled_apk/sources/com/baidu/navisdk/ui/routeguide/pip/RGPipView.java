package com.baidu.navisdk.ui.routeguide.pip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import java.util.List;

/* loaded from: classes8.dex */
public class RGPipView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f9080a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private RGPipConditionView e;
    private TextView f;
    private View g;

    public RGPipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_layout_pip, this);
        this.f9080a = (TextView) findViewById(R.id.remain_start);
        this.b = (TextView) findViewById(R.id.remain_end);
        this.c = (TextView) findViewById(R.id.next_road);
        this.d = (ImageView) findViewById(R.id.turn_icon);
        this.e = (RGPipConditionView) findViewById(R.id.condition_view);
        this.f = (TextView) findViewById(R.id.single_text);
        this.g = findViewById(R.id.next_layout);
    }

    public void b() {
        this.f.setVisibility(8);
        this.g.setVisibility(0);
    }

    public void setRemainDistEnd(String str) {
        this.b.setText(str);
    }

    public void setRemainDistStart(String str) {
        this.f9080a.setText(str);
    }

    public void setSecondLineText(String str) {
        this.c.setText(str);
    }

    public void setSingleText(String str) {
        this.f.setText(str);
    }

    public void setTurnIcon(Drawable drawable) {
        if (drawable == null) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        this.d.setImageDrawable(drawable);
    }

    public void setTurnIconResource(int i) {
        this.d.setImageResource(i);
    }

    public void a() {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
    }

    public void a(List<m> list) {
        this.e.a(list);
        this.e.invalidate();
    }

    public void a(double d) {
        this.e.a(d);
        this.e.invalidate();
    }
}
