package com.baidu.navisdk.module.routeresultbase.view.support.widgit;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView;
import com.baidu.navisdk.util.common.LogUtil;
import com.tencent.connect.common.II0xO0;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes7.dex */
public class BNRRFutureTripDateTimePickerView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f7544a;
    private BNRRNumberPickerView b;
    private BNRRNumberPickerView c;
    private BNRRNumberPickerView d;
    private TextView e;
    private TextView f;
    private String[] g;
    private String[] h;
    private String[] i;
    private h j;
    private Object k;
    private int l;
    private int m;
    private int n;
    private BNRRNumberPickerView.OnValueChangeListener o;

    /* loaded from: classes7.dex */
    public class a implements BNRRNumberPickerView.OnValueChangeListener {
        public a() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListener
        public void onValueChange(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            synchronized (BNRRFutureTripDateTimePickerView.this.k) {
                try {
                    int id = bNRRNumberPickerView.getId();
                    if (id == R.id.bus_np_date) {
                        BNRRFutureTripDateTimePickerView.this.l = i2;
                    } else if (id == R.id.bus_np_hour) {
                        BNRRFutureTripDateTimePickerView.this.m = i2;
                    } else if (id == R.id.bus_np_minute) {
                        BNRRFutureTripDateTimePickerView.this.n = i2;
                    }
                    BNRRFutureTripDateTimePickerView.this.d();
                    BNRRFutureTripDateTimePickerView.this.a(true);
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
            if (BNRRFutureTripDateTimePickerView.this.j != null) {
                String timeStr = BNRRFutureTripDateTimePickerView.this.getTimeStr();
                BNRRFutureTripDateTimePickerView.this.j.a(timeStr, BNRRFutureTripDateTimePickerView.a(timeStr), BNRRFutureTripDateTimePickerView.this.l, BNRRFutureTripDateTimePickerView.this.m, BNRRFutureTripDateTimePickerView.this.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BNRRFutureTripDateTimePickerView.this.j != null) {
                String timeStr = BNRRFutureTripDateTimePickerView.this.getTimeStr();
                BNRRFutureTripDateTimePickerView.this.j.b(timeStr, BNRRFutureTripDateTimePickerView.a(timeStr), BNRRFutureTripDateTimePickerView.this.l, BNRRFutureTripDateTimePickerView.this.m, BNRRFutureTripDateTimePickerView.this.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public e() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DateTimePickerView", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public f() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DateTimePickerView", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BNRRNumberPickerView.OnValueChangeListenerInScrolling {
        public g() {
        }

        @Override // com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.OnValueChangeListenerInScrolling
        public void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DateTimePickerView", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void a(String str, Date date, int... iArr);

        void b(String str, Date date, int... iArr);
    }

    public BNRRFutureTripDateTimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new Object();
        this.m = -1;
        this.n = -1;
        this.o = new a();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTimeStr() {
        String a2;
        int i = this.l;
        if (i < 0) {
            return (String) DateFormat.format("yyyy年MM月dd日 HH:mm", System.currentTimeMillis());
        }
        if (i >= 0 && i < 24) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, this.l);
            String str = (String) DateFormat.format(DateFormatUtils.YYYY_MM_DD5, calendar.getTimeInMillis());
            int i2 = this.m;
            String str2 = "00";
            if (i2 < 0) {
                a2 = "00";
            } else {
                a2 = a(i2);
            }
            int i3 = this.n;
            if (i3 >= 0) {
                str2 = a(i3 * 15);
            }
            String str3 = str + " " + a2 + ":" + str2;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DateTimePickerView", "getTimeStr,finalStr:" + str3);
            }
            return str3;
        }
        return null;
    }

    private void h() {
        for (int i = 0; i < 4; i++) {
            this.i[i] = a(i * 15);
        }
        this.d.setDisplayedValues(this.i);
        this.d.setMinValue(0);
        this.d.setMaxValue(3);
        this.d.postInvalidate();
    }

    public void setFunctionBtnListener(h hVar) {
        this.j = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.g[this.l].contains("今天")) {
            this.c.setIgnoreStartIndex(-1);
            this.d.setIgnoreStartIndex(-1);
            this.c.invalidate();
            this.d.invalidate();
            return;
        }
        e();
        this.c.invalidate();
        this.d.invalidate();
        this.b.invalidate();
    }

    private void e() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date a2 = a(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(a2);
        int i = calendar2.get(6) - calendar.get(6);
        int i2 = calendar2.get(11);
        int i3 = calendar2.get(12) / 15;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DateTimePickerView", "setIgnoreStartIndex,dateIndex:" + i + ",hourIndex:" + i2 + ",minuteIndex:" + i3);
        }
        this.b.setIgnoreStartIndex(i);
        this.c.setIgnoreStartIndex(i2);
        if (this.m > i2) {
            this.d.setIgnoreStartIndex(-1);
        } else {
            this.d.setIgnoreStartIndex(i3);
        }
    }

    private void f() {
        Calendar calendar = Calendar.getInstance();
        String str = (String) DateFormat.format("MM月dd日 E", calendar.getTimeInMillis());
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, 1);
        String str2 = (String) DateFormat.format("MM月dd日 E", gregorianCalendar.getTimeInMillis());
        for (int i = 0; i < 7; i++) {
            String str3 = (String) DateFormat.format("MM月dd日 E", calendar);
            if (TextUtils.equals(str3, str)) {
                String str4 = (String) DateFormat.format(ExifInterface.LONGITUDE_EAST, calendar);
                this.g[i] = "今天 " + str4;
            } else if (TextUtils.equals(str3, str2)) {
                String str5 = (String) DateFormat.format(ExifInterface.LONGITUDE_EAST, calendar);
                this.g[i] = "明天 " + str5;
            } else {
                this.g[i] = str3;
            }
            calendar.add(6, 1);
        }
        this.b.setDisplayedValues(this.g);
        this.b.setMinValue(0);
        this.b.setMaxValue(6);
        this.b.postInvalidate();
    }

    private void g() {
        for (int i = 0; i < 24; i++) {
            this.h[i] = a(i);
        }
        this.c.setDisplayedValues(this.h);
        this.c.setMinValue(0);
        this.c.setMaxValue(23);
        this.c.postInvalidate();
    }

    private void b() {
        a(false, false, false);
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nsdk_future_trip_date_time_picker_layout, this);
        this.f7544a = inflate;
        inflate.setOnTouchListener(new b());
        BNRRNumberPickerView bNRRNumberPickerView = (BNRRNumberPickerView) this.f7544a.findViewById(R.id.bus_np_date);
        this.b = bNRRNumberPickerView;
        bNRRNumberPickerView.setTag("-date-");
        BNRRNumberPickerView bNRRNumberPickerView2 = (BNRRNumberPickerView) this.f7544a.findViewById(R.id.bus_np_hour);
        this.c = bNRRNumberPickerView2;
        bNRRNumberPickerView2.setTag("-hour-");
        BNRRNumberPickerView bNRRNumberPickerView3 = (BNRRNumberPickerView) this.f7544a.findViewById(R.id.bus_np_minute);
        this.d = bNRRNumberPickerView3;
        bNRRNumberPickerView3.setTag("-minute-");
        this.e = (TextView) this.f7544a.findViewById(R.id.bus_tv_time_cancel_btn);
        this.f = (TextView) this.f7544a.findViewById(R.id.bus_tv_time_ok_btn);
        this.e.setOnClickListener(new c());
        this.f.setOnClickListener(new d());
        this.g = new String[7];
        this.b.setOnValueChangedListener(this.o);
        this.b.setOnValueChangeListenerInScrolling(new e());
        this.h = new String[24];
        this.c.setOnValueChangedListener(this.o);
        this.c.setOnValueChangeListenerInScrolling(new f());
        this.i = new String[4];
        this.d.setOnValueChangedListener(this.o);
        this.d.setOnValueChangeListenerInScrolling(new g());
        a();
    }

    public static Date a(String str) {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm").parse(str, new ParsePosition(0));
    }

    public BNRRFutureTripDateTimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new Object();
        this.m = -1;
        this.n = -1;
        this.o = new a();
        c();
    }

    public static Date a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.get(11);
        int i = calendar.get(12);
        calendar.get(13);
        int i2 = 0;
        calendar.set(13, 0);
        if (i >= 0 && i < 15) {
            i2 = 15;
        } else if (i >= 15 && i < 30) {
            i2 = 30;
        } else if (i < 30 || i >= 45) {
            calendar.add(11, 1);
        } else {
            i2 = 45;
        }
        calendar.set(12, i2);
        Date date2 = new Date(calendar.getTimeInMillis());
        if (LogUtil.LOGGABLE) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LogUtil.e("DateTimePickerView", "change,dateIn:" + simpleDateFormat.format(date) + ",dateOut:" + simpleDateFormat.format(date2));
        }
        return date2;
    }

    private String a(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return "" + i;
    }

    public void a() {
        f();
        h();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.l <= 0) {
            b();
            return;
        }
        if (this.m < 0) {
            BNRRNumberPickerView bNRRNumberPickerView = this.c;
            bNRRNumberPickerView.smoothScrollToValueQuick(bNRRNumberPickerView.getValue(), 0, z, true);
        }
        if (this.n < 0) {
            BNRRNumberPickerView bNRRNumberPickerView2 = this.d;
            bNRRNumberPickerView2.smoothScrollToValueQuick(bNRRNumberPickerView2.getValue(), 0, z, true);
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        int i3 = (this.m * 60) + (this.n * 15);
        int i4 = (i * 60) + i2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DateTimePickerView", "setCurTimeOnTodaySelected，curHour:" + i + ",curMinute:" + i2);
            LogUtil.e("DateTimePickerView", "setCurTimeOnTodaySelected，mCurSelHourIndex:" + this.m + ",mCurSelMinuteIndex:" + this.n);
            LogUtil.e("DateTimePickerView", "setCurTimeOnTodaySelected，realMinutesCount:" + i4 + ",panelMinutesCount:" + i3);
        }
        if (z3) {
            if (i3 >= i4 && i3 - i4 < 15 && this.l == 0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("DateTimePickerView", "setCurTimeOnTodaySelected，time valid,just return ");
                    return;
                }
                return;
            }
        } else if (i3 > i4 && this.m >= 0 && this.n >= 0) {
            return;
        }
        int i5 = 1;
        int i6 = 0;
        if (i2 <= 15) {
            i5 = 0;
            i6 = 1;
        } else if (i2 <= 30) {
            i5 = 0;
            i6 = 2;
        } else if (i2 <= 45) {
            i5 = 0;
            i6 = 3;
        } else if (this.h[i].equalsIgnoreCase(II0xO0.f26768O0xxXxI)) {
            i = 0;
        } else {
            i++;
            i5 = 0;
        }
        if (z2) {
            a(i5, i, i6);
        } else {
            a(i5, i, i6, z);
        }
    }

    private void a(int i, int i2, int i3) {
        this.b.setValue(i);
        this.c.setValue(i2);
        this.d.setValue(i3);
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.b.postInvalidate();
        this.c.postInvalidate();
        this.d.postInvalidate();
    }

    private void a(int i, int i2, int i3, boolean z) {
        BNRRNumberPickerView bNRRNumberPickerView = this.b;
        bNRRNumberPickerView.smoothScrollToValueQuick(bNRRNumberPickerView.getValue(), i, z, true);
        BNRRNumberPickerView bNRRNumberPickerView2 = this.c;
        bNRRNumberPickerView2.smoothScrollToValueQuick(bNRRNumberPickerView2.getValue(), i2, z, true);
        BNRRNumberPickerView bNRRNumberPickerView3 = this.d;
        bNRRNumberPickerView3.smoothScrollToValueQuick(bNRRNumberPickerView3.getValue(), i3, z, true);
        if (z) {
            return;
        }
        this.l = i;
        this.m = i2;
        this.n = i3;
    }
}
