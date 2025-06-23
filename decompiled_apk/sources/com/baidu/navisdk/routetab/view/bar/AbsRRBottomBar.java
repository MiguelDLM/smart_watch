package com.baidu.navisdk.routetab.view.bar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes7.dex */
public abstract class AbsRRBottomBar extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected b f7976a;

    /* loaded from: classes7.dex */
    public enum a {
        TO_LIGHT_NAV(0),
        TO_PRO_NAV(1),
        REAL_DEPART_TIME(2),
        DEPART_RIGHT_NOW(3),
        ADD_TO_ASSISTANT(4),
        TO_COMMUTE(5),
        TO_EDOG_CHALLENGE(6),
        TO_PLATE_INPUT(7);


        /* renamed from: a, reason: collision with root package name */
        int f7977a;

        a(int i) {
            this.f7977a = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "ClickType{typeVal=" + this.f7977a + '}';
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(a aVar);
    }

    public AbsRRBottomBar(Context context) {
        super(context);
    }

    public void setBtnClickListener(b bVar) {
        this.f7976a = bVar;
    }

    public AbsRRBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsRRBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
