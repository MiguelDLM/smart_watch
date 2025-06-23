package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes8.dex */
public class RGExitServiceAreaTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f9104a;
    private Paint b;
    private boolean c;

    public RGExitServiceAreaTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private String b(String str) {
        String trim = str.trim();
        if (!l0.c(trim)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGExitServiceAreaTextView", "subExitDrName-> maxWidth= " + this.f9104a + "measureText= " + this.b.measureText(trim));
            }
            if (this.f9104a < this.b.measureText(trim) && trim.contains(" ")) {
                trim = b(trim.substring(0, trim.lastIndexOf(" ")));
            }
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGExitServiceAreaTextView", "subExitDrName-> text= " + str + ", newText= " + trim);
        }
        return trim;
    }

    public void a(String str) {
        if (!l0.c(str) && str.contains(" ")) {
            String b = b(str);
            if (!str.equals(b)) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGExitServiceAreaTextView", "handleExitDrNameText-> subExitDrName - text= " + str + ", newText= " + b);
                }
                setText(b);
                return;
            }
            this.c = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.c) {
            if (this.f9104a <= 0) {
                this.f9104a = getMeasuredWidth();
            }
            a(getText().toString());
        }
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        this.f9104a = i;
        super.setMaxWidth(i);
    }

    public void setSrcText(String str) {
        if (str != null) {
            this.c = false;
            setText(str);
        }
    }

    public RGExitServiceAreaTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.b = getPaint();
        this.f9104a = getMaxWidth();
    }
}
