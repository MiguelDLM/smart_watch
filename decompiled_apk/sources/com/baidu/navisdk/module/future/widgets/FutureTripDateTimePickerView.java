package com.baidu.navisdk.module.future.widgets;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes7.dex */
public abstract class FutureTripDateTimePickerView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f7173a;
    private BNRRNumberPickerView b;
    private BNRRNumberPickerView c;
    private BNRRNumberPickerView d;
    private TextView e;
    private TextView f;
    private String[] g;
    private h h;
    private Object i;
    private int j;
    private int k;
    private int l;
    private TextView m;
    private int n;
    private Date o;
    private Date p;
    private int q;
    private BNRRNumberPickerView.OnValueChangeListener r;

    /* loaded from: classes7.dex */
    public class a implements BNRRNumberPickerView.OnValueChangeListener {
        public a() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListener
        public void onValueChange(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            int i3;
            synchronized (FutureTripDateTimePickerView.this.i) {
                try {
                    int id = bNRRNumberPickerView.getId();
                    if (id == R.id.bus_np_date) {
                        FutureTripDateTimePickerView.this.j = i2;
                        i3 = 0;
                    } else if (id == R.id.bus_np_hour) {
                        FutureTripDateTimePickerView.this.k = i2;
                        i3 = 1;
                    } else if (id == R.id.bus_np_minute) {
                        FutureTripDateTimePickerView.this.l = i2;
                        i3 = 2;
                    } else {
                        i3 = -1;
                    }
                    FutureTripDateTimePickerView.this.b();
                    FutureTripDateTimePickerView.this.a(i3, true);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FutureTripDateTimePickerView.this.h != null) {
                Date curSelectTime = FutureTripDateTimePickerView.this.getCurSelectTime();
                FutureTripDateTimePickerView.this.h.a(FutureTripDateTimePickerView.this.a(curSelectTime), curSelectTime, FutureTripDateTimePickerView.this.n, FutureTripDateTimePickerView.this.j, FutureTripDateTimePickerView.this.k, FutureTripDateTimePickerView.this.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FutureTripDateTimePickerView.this.h != null) {
                Date curSelectTime = FutureTripDateTimePickerView.this.getCurSelectTime();
                FutureTripDateTimePickerView.this.h.b(FutureTripDateTimePickerView.this.a(curSelectTime), curSelectTime, FutureTripDateTimePickerView.this.n, FutureTripDateTimePickerView.this.j, FutureTripDateTimePickerView.this.k, FutureTripDateTimePickerView.this.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public e() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            boolean z = LogUtil.LOGGABLE;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public f() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            boolean z = LogUtil.LOGGABLE;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public g() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            boolean z = LogUtil.LOGGABLE;
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void a(String str, Date date, int... iArr);

        void b(String str, Date date, int... iArr);
    }

    public FutureTripDateTimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new Object();
        this.k = -1;
        this.l = -1;
        this.r = new a();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Date getCurSelectTime() {
        int i = this.j;
        if (i < 0) {
            return new Date();
        }
        if (i >= 0 && i < 24) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, this.j);
            int i2 = this.k;
            int i3 = 0;
            if (i2 < 0) {
                i2 = 0;
            }
            calendar.set(11, i2);
            calendar.set(13, 0);
            calendar.set(14, 0);
            int i4 = this.l;
            if (i4 >= 0) {
                String[] strArr = this.g;
                if (strArr.length > i4) {
                    i3 = Integer.parseInt(strArr[i4]);
                }
            }
            calendar.set(12, i3);
            return calendar.getTime();
        }
        return null;
    }

    public abstract View a(View view);

    public abstract int getLayoutId();

    public void setCurShowingDate(Date date) {
        if (LogUtil.LOGGABLE && com.baidu.navisdk.module.future.a.f7166a) {
            LogUtil.e("DateTimePickerView", "setCurShowingDate,date:" + com.baidu.navisdk.module.future.controller.a.a(date));
        }
        this.p = date;
    }

    public void setDefaultValidDate(Date date) {
        if (LogUtil.LOGGABLE && com.baidu.navisdk.module.future.a.f7166a) {
            LogUtil.e("DateTimePickerView", "setDefaultValidDate,date:" + com.baidu.navisdk.module.future.controller.a.a(date));
        }
        this.o = date;
    }

    public void setEntryType(int i) {
        this.n = i;
    }

    public void setFunctionBtnListener(h hVar) {
        this.h = hVar;
    }

    private void d() {
        this.g = new String[4];
        for (int i = 0; i < 4; i++) {
            this.g[i] = a(i * 15);
        }
        this.d.resetDisplayValues();
        this.d.setMinValue(0);
        this.d.setDisplayedValues(this.g);
        this.d.setMaxValue(3);
        this.d.postInvalidate();
    }

    private void e() {
        int b2 = com.baidu.navisdk.module.future.controller.a.b(this.p);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            arrayList.add(a(i * 15));
        }
        arrayList.add((b2 / 15) + 1, a(b2));
        this.g = new String[5];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.g[i2] = (String) arrayList.get(i2);
        }
        this.d.resetDisplayValues();
        this.d.setMinValue(0);
        this.d.setDisplayedValues(this.g);
        this.d.setMaxValue(4);
        this.d.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int a2 = com.baidu.navisdk.module.future.controller.a.a(new Date(), this.o);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DateTimePickerView", "setIgnoreStartIndex,mDefaultValidDate:" + com.baidu.navisdk.module.future.controller.a.a(this.o));
            LogUtil.e("DateTimePickerView", "setIgnoreStartIndex,cur:" + com.baidu.navisdk.module.future.controller.a.a(new Date()));
            LogUtil.e("DateTimePickerView", "setIgnoreStartIndex,mCurSelDateIndex:" + this.j + ",targetDateIndex:" + a2);
        }
        this.b.setIgnoreStartIndex(a2);
        if (this.j > a2) {
            this.d.setIgnoreStartIndex(-1);
            this.c.setIgnoreStartIndex(-1);
        } else {
            c();
        }
        this.b.invalidate();
        this.c.invalidate();
        this.d.invalidate();
    }

    private void c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.o);
        int i = calendar.get(11);
        int i2 = calendar.get(12) / 15;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DateTimePickerView", "setIgnoreStartIndexSpecial,hourIndex:" + i + ",minuteIndex:" + i2);
        }
        this.c.setIgnoreStartIndex(i);
        if (this.k > i) {
            this.d.setIgnoreStartIndex(-1);
        } else {
            this.d.setIgnoreStartIndex(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Date date) {
        return date != null ? (String) DateFormat.format("yyyy年MM月dd日 HH:mm", date.getTime()) : "";
    }

    private void a() {
        this.f7173a = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        a((View) this);
        this.f7173a.setOnTouchListener(new b());
        this.m = (TextView) this.f7173a.findViewById(R.id.title);
        BNRRNumberPickerView bNRRNumberPickerView = (BNRRNumberPickerView) this.f7173a.findViewById(R.id.bus_np_date);
        this.b = bNRRNumberPickerView;
        bNRRNumberPickerView.setTag("-date-");
        BNRRNumberPickerView bNRRNumberPickerView2 = (BNRRNumberPickerView) this.f7173a.findViewById(R.id.bus_np_hour);
        this.c = bNRRNumberPickerView2;
        bNRRNumberPickerView2.setTag("-hour-");
        BNRRNumberPickerView bNRRNumberPickerView3 = (BNRRNumberPickerView) this.f7173a.findViewById(R.id.bus_np_minute);
        this.d = bNRRNumberPickerView3;
        bNRRNumberPickerView3.setTag("-minute-");
        this.e = (TextView) this.f7173a.findViewById(R.id.bus_tv_time_cancel_btn);
        this.f = (TextView) this.f7173a.findViewById(R.id.bus_tv_time_ok_btn);
        this.e.setOnClickListener(new c());
        this.f.setOnClickListener(new d());
        this.b.setOnValueChangedListener(this.r);
        this.b.setOnValueChangeListenerInScrolling(new e());
        this.c.setOnValueChangedListener(this.r);
        this.c.setOnValueChangeListenerInScrolling(new f());
        this.g = new String[4];
        this.d.setOnValueChangedListener(this.r);
        this.d.setOnValueChangeListenerInScrolling(new g());
    }

    public FutureTripDateTimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new Object();
        this.k = -1;
        this.l = -1;
        this.r = new a();
        a();
    }

    private String a(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return "" + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (this.q == 0) {
            a(z, calendar, this.o);
            return;
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(this.p);
        int i2 = calendar2.get(11);
        int i3 = (calendar2.get(12) / 15) + 1;
        if (calendar2.get(6) - calendar.get(6) == this.j && i2 == this.k) {
            if (this.g.length == 4) {
                e();
                if (i != 2) {
                    BNRRNumberPickerView bNRRNumberPickerView = this.d;
                    bNRRNumberPickerView.smoothScrollToValueQuick(bNRRNumberPickerView.getValue(), i3, false, true);
                }
            }
            a(z, calendar, this.o);
            return;
        }
        if (this.g.length > 4) {
            d();
            a(this.j, this.k, 0);
        }
        a(z, calendar, this.o);
    }

    private void a(boolean z, Calendar calendar, Date date) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        int i = calendar2.get(11);
        int i2 = calendar2.get(12) / 15;
        int i3 = calendar2.get(6) - calendar.get(6);
        if (this.j < i3) {
            BNRRNumberPickerView bNRRNumberPickerView = this.b;
            bNRRNumberPickerView.smoothScrollToValueQuick(bNRRNumberPickerView.getValue(), i3, z, true);
        }
        if (this.j <= i3 && this.k < i) {
            BNRRNumberPickerView bNRRNumberPickerView2 = this.c;
            bNRRNumberPickerView2.smoothScrollToValueQuick(bNRRNumberPickerView2.getValue(), i, z, true);
        }
        if (this.j > i3 || this.k > i || this.l >= i2) {
            return;
        }
        BNRRNumberPickerView bNRRNumberPickerView3 = this.d;
        bNRRNumberPickerView3.smoothScrollToValueQuick(bNRRNumberPickerView3.getValue(), i2, z, true);
    }

    private void a(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DateTimePickerView", "selectIndexDirectly,dateIndex:" + i + ",hourIndex:" + i2 + ",minuteIndex:" + i3);
        }
        this.b.setValue(i);
        this.c.setValue(i2);
        this.d.setValue(i3);
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.b.postInvalidate();
        this.c.postInvalidate();
        this.d.postInvalidate();
    }
}
