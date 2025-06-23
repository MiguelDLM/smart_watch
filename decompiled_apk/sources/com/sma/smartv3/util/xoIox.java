package com.sma.smartv3.util;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.format.DateFormat;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.garmin.fit.OxXXx0X;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayerTimeSettings;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nDateTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTime.kt\ncom/sma/smartv3/util/DateTimeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,725:1\n1#2:726\n18#3,2:727\n15#3:729\n18#3,2:730\n15#3:732\n*S KotlinDebug\n*F\n+ 1 DateTime.kt\ncom/sma/smartv3/util/DateTimeKt\n*L\n697#1:727,2\n697#1:729\n706#1:730,2\n706#1:732\n*E\n"})
/* loaded from: classes12.dex */
public final class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24679I0Io = "h:mm \n a";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24680II0XooXoX = "h:mm a MM/dd/yyyy";

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24681II0xO0 = "h:mm a";

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24682IIX0o = "h \n a";

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24683IIXOooo = "dd/MM/yyyy";

    /* renamed from: IO, reason: collision with root package name */
    public static final int f24684IO = 43200000;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24685IXxxXO = "MM/dd/yyyy HH:mm:ss";

    /* renamed from: IoOoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24686IoOoX = "yyyy-MM-dd";

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24687O0xOxO = "HH:mm \n MM/dd/yyyy";

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24688OOXIXo = "MM/dd/yyyy HH:mm";

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24689Oo = "yyyy/MM/dd HH:mm:ss";

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24690OxI = "MM/yyyy";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24691Oxx0IOOO = "h:mm a yyyy/MM/dd";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24692Oxx0xo = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24693OxxIIOOXO = "MM/dd/yyyy";

    /* renamed from: X00IoxXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24694X00IoxXI = "/";

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24695X0IIOO = "hh:mm a \n MM/dd/yyyy";

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24696X0o0xo = "HH:mm MM/dd/yyyy";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24697XI0IXoo = "HH:mm MM/dd";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24698XIxXXX0x0 = "HH:mm dd/MM";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24699XO = "HH:mm dd/MM/yyyy";

    /* renamed from: Xx000oIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24700Xx000oIo = "yyyy-MM-dd HH:mm:ss.SSSZ";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24701XxX0x0xxx = "hh:mm a dd/MM";

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24702o00 = "dd/MM";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24703oI0IIXIo = "yyyy/MM/dd";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24704oIX0oI = "HH:mm";

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24705oO = "dd/MM/yyyy h:mm a";

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24706oOXoIIIo = "yyyyMMdd";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24707oOoXoXO = "dd/MM/yyyy HH:mm";

    /* renamed from: oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24708oo = "yyyy-MM-dd'T'HH:mm:ss";

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24709oo0xXOI0I = "HH:mm:ss";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24710ooOOo0oXI = "yyyy/MM/dd h:mm a";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24711ooXIXxIX = "hh:mm \n MM/dd a";

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24712oxoX = "HH:mm yyyy/MM/dd";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24713x0XOIxOo = "MM/dd/yyyy h:mm a";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24714x0xO0oo = "'photo'yyyyMMdd_HHmmss";

    /* renamed from: xI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24715xI = "HH:mm \n MM/dd";

    /* renamed from: xII, reason: collision with root package name */
    public static final int f24716xII = 604800000;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24717xXxxox0I = "H";

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24718xoIox = "yyyy/MM/dd HH:mm";

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24719xoXoI = "MM/dd";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24720xxIXOIIO = "h:mm a dd/MM/yyyy";

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24721xxX = "hh:mm a MM/dd";

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends CountDownTimer {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Context f24722II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ TextView f24723oIX0oI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(long j, long j2, TextView textView, Context context) {
            super(j, j2);
            this.f24723oIX0oI = textView;
            this.f24722II0xO0 = context;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.f24723oIX0oI.isShown()) {
                this.f24723oIX0oI.setEnabled(true);
                this.f24723oIX0oI.setText(R.string.get_verification_code);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (this.f24723oIX0oI.isShown()) {
                this.f24723oIX0oI.setEnabled(false);
                TextView textView = this.f24723oIX0oI;
                kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
                String string = this.f24722II0xO0.getString(R.string.d_s);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j / 1000)}, 1));
                kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                textView.setText(format);
            }
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f24724II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f24725oIX0oI;

        static {
            int[] iArr = new int[DateTimeFormat.values().length];
            try {
                iArr[DateTimeFormat.yyyyMMdd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DateTimeFormat.ddMMyyyy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DateTimeFormat.MMddyyyy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f24725oIX0oI = iArr;
            int[] iArr2 = new int[TimePeriod.values().length];
            try {
                iArr2[TimePeriod.HALF_HOUR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TimePeriod.HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TimePeriod.DAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TimePeriod.WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[TimePeriod.MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TimePeriod.YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            f24724II0xO0 = iArr2;
        }
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat I0Io() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
    }

    public static /* synthetic */ SimpleDateFormat I0X0x0oIo(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return XX0(z);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat I0oOIX(boolean z) {
        if (z) {
            return new SimpleDateFormat(f24687O0xOxO, Locale.getDefault());
        }
        return new SimpleDateFormat(f24695X0IIOO, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat I0oOoX(boolean z, boolean z2) {
        SimpleDateFormat simpleDateFormat;
        String str;
        String str2;
        if (z) {
            int i = oIX0oI.f24725oIX0oI[ProjectManager.f19822oIX0oI.x0XOIxOo().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Application app = Utils.getApp();
                        kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
                        if (UtilsKt.X00IoxXI(app)) {
                            str2 = f24688OOXIXo;
                        } else {
                            str2 = f24696X0o0xo;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    Application app2 = Utils.getApp();
                    kotlin.jvm.internal.IIX0o.oO(app2, "getApp(...)");
                    if (UtilsKt.X00IoxXI(app2)) {
                        str2 = f24707oOoXoXO;
                    } else {
                        str2 = f24699XO;
                    }
                }
            } else {
                Application app3 = Utils.getApp();
                kotlin.jvm.internal.IIX0o.oO(app3, "getApp(...)");
                if (UtilsKt.X00IoxXI(app3)) {
                    str2 = f24718xoIox;
                } else {
                    str2 = f24712oxoX;
                }
            }
            simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        } else {
            int i2 = oIX0oI.f24725oIX0oI[ProjectManager.f19822oIX0oI.x0XOIxOo().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Application app4 = Utils.getApp();
                        kotlin.jvm.internal.IIX0o.oO(app4, "getApp(...)");
                        if (UtilsKt.X00IoxXI(app4)) {
                            str = f24713x0XOIxOo;
                        } else {
                            str = f24680II0XooXoX;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    Application app5 = Utils.getApp();
                    kotlin.jvm.internal.IIX0o.oO(app5, "getApp(...)");
                    if (UtilsKt.X00IoxXI(app5)) {
                        str = f24705oO;
                    } else {
                        str = f24720xxIXOIIO;
                    }
                }
            } else {
                Application app6 = Utils.getApp();
                kotlin.jvm.internal.IIX0o.oO(app6, "getApp(...)");
                if (UtilsKt.X00IoxXI(app6)) {
                    str = f24710ooOOo0oXI;
                } else {
                    str = f24691Oxx0IOOO;
                }
            }
            simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        }
        return simpleDateFormat;
    }

    @OXOo.OOXIXo
    public static final String II0XooXoX(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo String zSplit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(obj, "obj");
        kotlin.jvm.internal.IIX0o.x0xO0oo(zSplit, "zSplit");
        String format = new SimpleDateFormat(f24700Xx000oIo, Locale.getDefault()).format(obj);
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return new Regex("(\\d{2})(\\d{2})$").replace(format, "$1" + zSplit + "$2");
    }

    public static final List<O00XxXI> II0xO0(List<O00XxXI> list) {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.IxX00() && projectManager.IxX00() && !list.isEmpty() && kotlin.jvm.internal.IIX0o.Oxx0IOOO(list.get(0).XO(), UtilsKt.oI0IIXIo(R.string.weekday7_s))) {
            List<O00XxXI> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(list);
            o0Xo0XII.remove(0);
            o0Xo0XII.add(list.get(0));
            return o0Xo0XII;
        }
        return list;
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat IIX0o() {
        return new SimpleDateFormat(f24709oo0xXOI0I, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final String IIXOooo(@OXOo.OOXIXo Calendar target, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timePeriod, "timePeriod");
        Object clone = target.clone();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        int i2 = oIX0oI.f24724II0xO0[timePeriod.ordinal()];
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 5) {
                    return "";
                }
                oOXoIIIo.II0xO0.xoXoI(calendar, oOXoIIIo.II0xO0.xoIox(calendar) + i);
                String format = xII().format(calendar.getTime());
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
                return format;
            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(target.getTimeInMillis());
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar2);
            oOXoIIIo.II0xO0.X0IIOO(calendar2, oOXoIIIo.II0xO0.x0XOIxOo(calendar2) + i);
            calendar2.set(7, 2);
            String format2 = xI().format(calendar2.getTime());
            oOXoIIIo.II0xO0.IXxxXO(calendar2, oOXoIIIo.II0xO0.II0xO0(calendar2) + 6);
            return format2 + " ~ " + xI().format(calendar2.getTime());
        }
        oOXoIIIo.II0xO0.IXxxXO(calendar, oOXoIIIo.II0xO0.II0xO0(calendar) + i);
        String format3 = oo0xXOI0I().format(calendar.getTime());
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(format3);
        return format3;
    }

    @OXOo.OOXIXo
    public static final String IO(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((i2 - i3) / 60), Integer.valueOf(i3)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final String IXxxXO(@OXOo.OOXIXo String dayOfMonth) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dayOfMonth, "dayOfMonth");
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(dayOfMonth, new String[]{"/"}, false, 0, 6, null);
        return ((String) XXoO0oX2.get(0)) + IOUtils.DIR_SEPARATOR_UNIX + ((String) XXoO0oX2.get(2));
    }

    @OXOo.OOXIXo
    public static final String Io(int i) {
        int i2 = i / 3600;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf((i - (i2 * 3600)) / 60), Integer.valueOf(i % 60)}, 3));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final String IoOoX(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf((i2 - (i3 * 3600)) / 60), Integer.valueOf(i2 % 60)}, 3));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final String IoOoo(int i) {
        int i2 = i % 60;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((i - i2) / 60), Integer.valueOf(i2)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    public static /* synthetic */ SimpleDateFormat O0Xx(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return XoI0Ixx0(z);
    }

    @OXOo.OOXIXo
    public static final String O0xOxO(int i, int i2, boolean z) {
        int i3;
        if (z) {
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            return format;
        }
        Application app = Utils.getApp();
        int i4 = i % 12;
        if (i4 == 0) {
            i4 = 12;
        }
        if (i < 12) {
            i3 = R.string.am;
        } else {
            i3 = R.string.pm;
        }
        String string = app.getString(i3);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.oxxXoxO oxxxoxo2 = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format2 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4), Integer.valueOf(i2)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
        sb.append(format2);
        sb.append(TokenParser.SP);
        sb.append(string);
        return sb.toString();
    }

    public static final int OI0(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        return (oOXoIIIo.II0xO0.Oxx0IOOO(calendar) * 3600) + (oOXoIIIo.II0xO0.xxIXOIIO(calendar) * 60) + oOXoIIIo.II0xO0.ooOOo0oXI(calendar);
    }

    public static final boolean OO(@OXOo.OOXIXo Calendar target, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timePeriod, "timePeriod");
        Object clone = target.clone();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 23);
        calendar2.set(12, 59);
        calendar2.set(13, 59);
        int i2 = oIX0oI.f24724II0xO0[timePeriod.ordinal()];
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    oOXoIIIo.II0xO0.xoXoI(calendar, oOXoIIIo.II0xO0.xoIox(calendar) + i);
                }
            } else {
                oOXoIIIo.II0xO0.X0IIOO(calendar, oOXoIIIo.II0xO0.x0XOIxOo(calendar) + i);
            }
        } else {
            oOXoIIIo.II0xO0.IXxxXO(calendar, oOXoIIIo.II0xO0.II0xO0(calendar) + i);
        }
        return !calendar.after(calendar2);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat OO0x0xX() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public static final int OOXIXo(@OXOo.OOXIXo String date1, @OXOo.OOXIXo String date2, @OXOo.OOXIXo String pattern) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(date1, "date1");
        kotlin.jvm.internal.IIX0o.x0xO0oo(date2, "date2");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pattern, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return (int) ((simpleDateFormat.parse(date2).getTime() - simpleDateFormat.parse(date1).getTime()) / TimeUnit.DAYS.toMillis(1L));
    }

    @OXOo.OOXIXo
    public static final List<String> Oo(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        SimpleDateFormat oo0xXOI0I2 = oo0xXOI0I();
        ArrayList arrayList = new ArrayList();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        int oxoX2 = oOXoIIIo.II0xO0.oxoX(calendar);
        int i = 1;
        if (1 <= oxoX2) {
            while (true) {
                calendar.set(5, i);
                String format = oo0xXOI0I2.format(calendar.getTime());
                kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                arrayList.add(format);
                if (i == oxoX2) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ long[] OxI(Calendar calendar, TimePeriod timePeriod, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            calendar = Calendar.getInstance();
            kotlin.jvm.internal.IIX0o.oO(calendar, "getInstance(...)");
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return o00(calendar, timePeriod, i);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat Oxx0IOOO() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final long[] Oxx0xo(int i) {
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        long timeInMillis = calendar.getTimeInMillis();
        TimeUnit timeUnit = TimeUnit.DAYS;
        return new long[]{calendar.getTimeInMillis() - timeUnit.toMillis(i), (timeInMillis + timeUnit.toMillis(1L)) - TimeUnit.MINUTES.toMillis(1L)};
    }

    public static final long OxxIIOOXO(@OXOo.OOXIXo Calendar calendar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(calendar, "calendar");
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        return calendar.getTimeInMillis();
    }

    @OXOo.OOXIXo
    public static final String X00IoxXI(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%03d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((i2 - i3) / 60), Integer.valueOf(i3)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    public static /* synthetic */ String X0IIOO(int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = ooXIXxIX();
        }
        return O0xOxO(i, i2, z);
    }

    @OXOo.OOXIXo
    public static final String X0o0xo(int i, int i2) {
        String str;
        if (i == 0) {
            str = TimeModel.NUMBER_FORMAT;
        } else {
            str = "%+d";
        }
        if (i2 != 0) {
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format(str + " %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), UtilsKt.oI0IIXIo(i2)}, 2));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            return format;
        }
        kotlin.jvm.internal.oxxXoxO oxxxoxo2 = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
        return format2;
    }

    @OXOo.OOXIXo
    public static final List<O00XxXI> XI0IXoo(long j) {
        boolean add;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        SimpleDateFormat oo0xXOI0I2 = oo0xXOI0I();
        if (ProjectManager.f19822oIX0oI.IxX00()) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
            oOXoIIIo.II0xO0.Oxx0xo(calendar, firstDayOfWeek + 1);
        } else {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
            oOXoIIIo.II0xO0.Oxx0xo(calendar, firstDayOfWeek);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(7);
        for (int i = 0; i < 7; i++) {
            oOXoIIIo.II0xO0.Oxx0xo(calendar, firstDayOfWeek + i);
            try {
                String displayName = calendar.getDisplayName(7, 1, Locale.getDefault());
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(displayName);
                String format = oo0xXOI0I2.format(calendar.getTime());
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
                add = arrayList.add(new O00XxXI(displayName, format));
            } catch (Exception unused) {
                add = arrayList.add(new O00XxXI(null, null, 3, null));
            }
            arrayList2.add(Boolean.valueOf(add));
        }
        return II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public static final O00XxXI XIxXXX0x0(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.Oxx0xo(calendar, oOXoIIIo.II0xO0.I0Io(calendar) + i);
        SimpleDateFormat oo0xXOI0I2 = oo0xXOI0I();
        try {
            String displayName = calendar.getDisplayName(7, 1, Locale.getDefault());
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(displayName);
            String format = oo0xXOI0I2.format(calendar.getTime());
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
            return new O00XxXI(displayName, format);
        } catch (Exception unused) {
            return new O00XxXI(null, null, 3, null);
        }
    }

    public static /* synthetic */ String XO(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return X0o0xo(i, i2);
    }

    public static final void XOxIOxOx(@OXOo.OOXIXo Context context, long j, long j2, @OXOo.OOXIXo TextView view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        new II0xO0(j, j2, view, context).start();
    }

    @OXOo.OOXIXo
    public static final String XX(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d.%02d", Arrays.copyOf(new Object[]{Integer.valueOf((i2 - i3) / 60), Integer.valueOf(i3)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat XX0(boolean z) {
        SimpleDateFormat simpleDateFormat;
        String str;
        String str2;
        if (z) {
            if (ProjectManager.f19822oIX0oI.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
                str2 = f24698XIxXXX0x0;
            } else {
                str2 = f24697XI0IXoo;
            }
            simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        } else {
            if (ProjectManager.f19822oIX0oI.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
                str = f24701XxX0x0xxx;
            } else {
                str = f24721xxX;
            }
            simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        }
        return simpleDateFormat;
    }

    public static /* synthetic */ SimpleDateFormat Xo0(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return oX(z);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat XoI0Ixx0(boolean z) {
        if (z) {
            return new SimpleDateFormat("HH:mm", Locale.getDefault());
        }
        return new SimpleDateFormat(f24679I0Io, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat XoX(boolean z) {
        if (z) {
            return new SimpleDateFormat("HH:mm", Locale.getDefault());
        }
        return new SimpleDateFormat(f24681II0xO0, Locale.getDefault());
    }

    public static final int Xx000oIo(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        return (i3 * 60) + ((i2 - (i3 * 3600)) / 60);
    }

    @OXOo.OOXIXo
    public static final IIX0o XxX0x0xxx(int i, int i2, int i3) {
        int i4;
        if (i <= 1582 && ((i != 1582 || i2 <= 10) && (i != 1582 || i2 != 10 || i3 <= 14))) {
            i4 = ((i * 367) - ((((i + 5001) + ((i2 - 9) / 7)) * 7) / 4)) + ((i2 * 275) / 9) + i3 + 1729777;
        } else {
            int i5 = (i2 - 14) / 12;
            i4 = (((((((i + 4800) + i5) * OxXXx0X.f13129XoX) / 4) + ((((i2 - 2) - (i5 * 12)) * 367) / 12)) - (((((i + 4900) + i5) / 100) * 3) / 4)) + i3) - 32075;
        }
        int i6 = (int) ((i4 - 1948440) + 10632);
        int i7 = (i6 - (((i6 - 1) / 10631) * 10631)) + 354;
        int i8 = (((10985 - i7) / 5316) * ((i7 * 50) / 17719)) + ((i7 / 5670) * ((i7 * 43) / 15238));
        int i9 = ((i7 - (((30 - i8) / 15) * ((i8 * 17719) / 50))) - ((i8 / 16) * ((i8 * 15238) / 43))) + 29;
        int i10 = (i9 * 24) / 709;
        return new IIX0o(((r4 * 30) + i8) - 30, i10, i9 - ((i10 * 709) / 24));
    }

    @OXOo.OOXIXo
    public static final List<String> o0(@OXOo.OOXIXo String time) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(time, "time");
        return StringsKt__StringsKt.XXoO0oX(time, new String[]{"/"}, false, 0, 6, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0102, code lost:
    
        return r0;
     */
    @OXOo.OOXIXo
    @androidx.annotation.Size(2)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long[] o00(@OXOo.OOXIXo java.util.Calendar r6, @OXOo.OOXIXo com.sma.smartv3.util.TimePeriod r7, int r8) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.util.xoIox.o00(java.util.Calendar, com.sma.smartv3.util.TimePeriod, int):long[]");
    }

    @OXOo.OOXIXo
    public static final long[] oI0IIXIo(int i) {
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        long timeInMillis = calendar.getTimeInMillis();
        TimeUnit timeUnit = TimeUnit.HOURS;
        long millis = timeInMillis + timeUnit.toMillis(1L);
        return new long[]{millis - timeUnit.toMillis(i), millis};
    }

    public static final int oIX0oI() {
        return 1440;
    }

    @OXOo.OOXIXo
    public static final String oO(long j, int i) {
        IIX0o ooOOo0oXI2 = ooOOo0oXI(j, i);
        StringBuilder sb = new StringBuilder();
        sb.append(ooOOo0oXI2.II0XooXoX());
        sb.append('-');
        sb.append(ooOOo0oXI2.Oxx0IOOO());
        sb.append('-');
        sb.append(ooOOo0oXI2.XO());
        return sb.toString();
    }

    @OXOo.OOXIXo
    public static final String oOXoIIIo(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d:%02d.%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf((i2 - (i3 * 3600)) / 60), Integer.valueOf(i2 % 60), Integer.valueOf((i % 1000) / 10)}, 4));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final int oOoXoXO(@OXOo.OOXIXo String date1, @OXOo.OOXIXo String date2, @OXOo.OOXIXo String pattern) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(date1, "date1");
        kotlin.jvm.internal.IIX0o.x0xO0oo(date2, "date2");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pattern, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return (int) ((simpleDateFormat.parse(date2).getTime() - simpleDateFormat.parse(date1).getTime()) / TimeUnit.HOURS.toMillis(1L));
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat oX(boolean z) {
        if (z) {
            return new SimpleDateFormat(f24715xI, Locale.getDefault());
        }
        return new SimpleDateFormat(f24711ooXIXxIX, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final Pair<Integer, Integer> oo(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf((i2 - (i3 * 3600)) / 60));
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat oo0xXOI0I() {
        String str;
        int i = oIX0oI.f24725oIX0oI[ProjectManager.f19822oIX0oI.x0XOIxOo().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    str = f24693OxxIIOOXO;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                str = f24683IIXOooo;
            }
        } else {
            str = "yyyy/MM/dd";
        }
        return new SimpleDateFormat(str, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final IIX0o ooOOo0oXI(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j + (i * TimeUnit.DAYS.toMillis(1L)));
        return XxX0x0xxx(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static final boolean ooXIXxIX() {
        try {
            if (oIxOXo.oxoX.f31821II0XooXoX) {
                return true;
            }
            return DateFormat.is24HourFormat(Utils.getApp());
        } catch (Exception e) {
            e.printStackTrace();
            Application app = Utils.getApp();
            kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
            return UtilsKt.X00IoxXI(app);
        }
    }

    public static /* synthetic */ SimpleDateFormat oxXx0IX(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return XoX(z);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat oxoX() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    }

    public static /* synthetic */ SimpleDateFormat oxxXoxO(boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        if ((i & 2) != 0) {
            Application app = Utils.getApp();
            kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
            z2 = UtilsKt.X00IoxXI(app);
        }
        return I0oOoX(z, z2);
    }

    public static /* synthetic */ IIX0o x0XOIxOo(long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
            if (fromJson == null) {
                fromJson = PrayerTimeSettings.class.newInstance();
            }
            i = ((PrayerTimeSettings) fromJson).getHijriDateAdjustment();
        }
        return ooOOo0oXI(j, i);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat x0o() {
        return new SimpleDateFormat(f24714x0xO0oo, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat x0xO() {
        return new SimpleDateFormat(f24685IXxxXO, Locale.getDefault());
    }

    public static /* synthetic */ String x0xO0oo(long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
            if (fromJson == null) {
                fromJson = PrayerTimeSettings.class.newInstance();
            }
            i = ((PrayerTimeSettings) fromJson).getHijriDateAdjustment();
        }
        return oO(j, i);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xI() {
        String str;
        if (ProjectManager.f19822oIX0oI.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
            str = f24702o00;
        } else {
            str = f24719xoXoI;
        }
        return new SimpleDateFormat(str, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xII() {
        return new SimpleDateFormat(f24690OxI, Locale.getDefault());
    }

    public static /* synthetic */ SimpleDateFormat xXOx(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return xo0x(z);
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xXxxox0I() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xo0x(boolean z) {
        if (z) {
            return new SimpleDateFormat(f24717xXxxox0I, Locale.getDefault());
        }
        return new SimpleDateFormat(f24682IIX0o, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xoIox() {
        return new SimpleDateFormat(f24708oo, Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final SimpleDateFormat xoIxX() {
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    }

    @OXOo.OOXIXo
    public static final long[] xoXoI(@OXOo.OOXIXo String date, @OXOo.OOXIXo String pattern) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(date, "date");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pattern, "pattern");
        long[] jArr = new long[2];
        Date parse = new SimpleDateFormat(pattern, Locale.getDefault()).parse(date);
        if (parse != null) {
            long time = parse.getTime();
            jArr[0] = time;
            jArr[1] = time + TimeUnit.DAYS.toMillis(1L);
        }
        return jArr;
    }

    public static /* synthetic */ SimpleDateFormat xoxXI(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ooXIXxIX();
        }
        return I0oOIX(z);
    }

    public static /* synthetic */ String xxIXOIIO(Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "";
        }
        return II0XooXoX(obj, str);
    }

    @OXOo.OOXIXo
    public static final String xxX(@OXOo.OOXIXo List<O00XxXI> weekDay) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(weekDay, "weekDay");
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(weekDay.get(0).X0o0xo(), new String[]{"/"}, false, 0, 6, null);
        return (((String) XXoO0oX2.get(0)) + IOUtils.DIR_SEPARATOR_UNIX + ((String) XXoO0oX2.get(1))) + " ~ " + weekDay.get(weekDay.size() - 1).X0o0xo();
    }
}
