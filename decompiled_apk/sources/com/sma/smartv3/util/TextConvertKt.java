package com.sma.smartv3.util;

import android.app.Application;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.baidu.mobads.sdk.internal.cn;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.view.text.DINCondBold;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleRepeat;
import com.szabh.smable3.entity.BleSDCardInfo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Triple;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nTextConvert.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextConvert.kt\ncom/sma/smartv3/util/TextConvertKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,757:1\n13374#2,3:758\n*S KotlinDebug\n*F\n+ 1 TextConvert.kt\ncom/sma/smartv3/util/TextConvertKt\n*L\n147#1:758,3\n*E\n"})
/* loaded from: classes12.dex */
public final class TextConvertKt {
    public static final int I0Io(int i) {
        switch (i) {
            case 0:
            default:
                return 0;
            case 1:
                return 5;
            case 2:
                return 15;
            case 3:
                return 30;
            case 4:
                return 60;
            case 5:
                return 120;
            case 6:
                return 1440;
            case 7:
                return 2880;
            case 8:
                return 10080;
        }
    }

    @OXOo.OOXIXo
    public static final String I0X0x0oIo(double d, int i) {
        if (i == 0) {
            return oo((float) d, false, 2, null);
        }
        return oo((float) (d * 0.6213711d), false, 2, null);
    }

    public static final int I0oOIX(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        String[] stringArray = Utils.getApp().getResources().getStringArray(R.array.referee_roles);
        kotlin.jvm.internal.IIX0o.oO(stringArray, "getStringArray(...)");
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(stringArray[i], value)) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        return 0;
    }

    @OXOo.oOoXoXO
    public static final String I0oOoX(@OXOo.OOXIXo CharSequence charSequence) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(charSequence, "charSequence");
        if (charSequence.length() == 0) {
            return null;
        }
        return new Regex("\n+").replace(new Regex("(\\s+$|^\\s+)").replace(charSequence.toString(), ""), "\n");
    }

    @OXOo.OOXIXo
    public static final String II0XooXoX(int i) {
        Application app = Utils.getApp();
        if (i != 0) {
            if (i != 1) {
                String string = app.getString(R.string.double_press);
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
                return string;
            }
            String string2 = app.getString(R.string.long_press);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
            return string2;
        }
        String string3 = app.getString(R.string.short_press);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
        return string3;
    }

    public static /* synthetic */ String II0xO0(float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oIX0oI(f, z);
    }

    public static /* synthetic */ void IIX0o(int i, DINCondBold dINCondBold, Context context, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i2 = 40;
        }
        if ((i4 & 16) != 0) {
            i3 = R.color.line_color;
        }
        xXxxox0I(i, dINCondBold, context, i2, i3);
    }

    @OXOo.OOXIXo
    public static final ArrayList<SportData> IIXOooo(@OXOo.OOXIXo List<Location> locationList, int i) {
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        ArrayList<SportData> arrayList = new ArrayList<>();
        int size = locationList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < size) {
            Location location = locationList.get(i3);
            if (i3 < locationList.size() - 1) {
                i2 = i3;
                int distance = (int) DistanceUtil.getDistance(new LatLng(location.getMLatitude(), location.getMLongitude()), new LatLng(locationList.get(r12).getMLatitude(), locationList.get(r12).getMLongitude()));
                i4 += (int) ((locationList.get(i3 + 1).getMTime() - location.getMTime()) / 1000);
                int i7 = distance + i5;
                if (i4 >= i) {
                    i6++;
                    int mAltitude = location.getMAltitude();
                    long mTime = location.getMTime();
                    String mLocalTime = location.getMLocalTime();
                    com.sma.smartv3.ui.sport.XIo0oOXIx xIo0oOXIx = com.sma.smartv3.ui.sport.XIo0oOXIx.f23889oIX0oI;
                    SportData sportData = new SportData(0, mTime, mLocalTime, 0, i7, 0, i4, 0, mAltitude, 0, xIo0oOXIx.II0xO0(i4, i7), xIo0oOXIx.I0Io(i7, i4), 0, 0, 0, 29321, null);
                    arrayList.add(sportData);
                    LogUtils.i(" getLocationListData size=" + i6 + "  time" + i4 + "  sportData" + sportData);
                    i4 = 0;
                    i5 = 0;
                } else {
                    i5 = i7;
                }
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String IO(int i, int i2) {
        if (i2 == 0) {
            return String.valueOf(i);
        }
        String format = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(i * 3.28d);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
        return format;
    }

    @OXOo.OOXIXo
    public static final String IXxxXO(int i) {
        Application app = Utils.getApp();
        if (i == 0) {
            String string = app.getString(R.string.off);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        String string2 = app.getString(R.string.on);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
        return string2;
    }

    @OXOo.OOXIXo
    public static final String Io(int i) {
        final Application app = Utils.getApp();
        if ((i & 127) == 0) {
            String string = app.getString(R.string.once);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            return string;
        }
        if (i == 127) {
            String string2 = app.getString(R.string.every_day);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            return string2;
        }
        if (i == 31) {
            String string3 = app.getString(R.string.weekdays);
            kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
            return string3;
        }
        if (i == 96) {
            String string4 = app.getString(R.string.weekends);
            kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
            return string4;
        }
        return BleRepeat.INSTANCE.toWeekdayText(i, new Oox.oOoXoXO<Integer, String>() { // from class: com.sma.smartv3.util.TextConvertKt$repeatToWeekdayText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OXOo.OOXIXo
            public final String invoke(int i2) {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append(TokenParser.SP);
                if (i2 == 1) {
                    str = app.getString(R.string.weekday1_s) + TokenParser.SP;
                } else if (i2 == 2) {
                    str = app.getString(R.string.weekday2_s) + TokenParser.SP;
                } else if (i2 == 4) {
                    str = app.getString(R.string.weekday3_s) + TokenParser.SP;
                } else if (i2 == 8) {
                    str = app.getString(R.string.weekday4_s) + TokenParser.SP;
                } else if (i2 == 16) {
                    str = app.getString(R.string.weekday5_s) + TokenParser.SP;
                } else if (i2 == 32) {
                    str = app.getString(R.string.weekday6_s) + TokenParser.SP;
                } else if (i2 != 64) {
                    str = " ";
                } else {
                    str = app.getString(R.string.weekday7_s) + TokenParser.SP;
                }
                sb.append(str);
                return sb.toString();
            }
        });
    }

    @OXOo.OOXIXo
    public static final String IoOoX(float f, boolean z) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            if (!z) {
                decimalFormat.setRoundingMode(RoundingMode.DOWN);
            }
            String format = decimalFormat.format(new BigDecimal(String.valueOf(f)));
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
            return format;
        }
        return "0.00";
    }

    @OXOo.OOXIXo
    public static final String IoOoo(int i) {
        Application app = Utils.getApp();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    String string = app.getString(R.string.d_times, Integer.valueOf(i));
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    return string;
                }
                String string2 = app.getString(R.string.twice);
                kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                return string2;
            }
            String string3 = app.getString(R.string.once);
            kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
            return string3;
        }
        String string4 = app.getString(R.string.off);
        kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
        return string4;
    }

    @OXOo.OOXIXo
    public static final String O0Xx(float f, int i, int i2) {
        float f2 = (((48 * f) * i) / 10000) / 1000.0f;
        if (i2 == 0) {
            return oo(f2, false, 2, null);
        }
        return oo(Xx000oIo.XO.oxoX(f2), false, 2, null);
    }

    @OXOo.OOXIXo
    public static final String O0xOxO(@OXOo.OOXIXo Context context, float f, boolean z) {
        StringBuilder sb;
        String string;
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (z) {
            sb = new StringBuilder();
            sb.append(OOXIXo(f));
            sb.append(TokenParser.SP);
            string = context.getString(R.string.fahrenheit);
        } else {
            sb = new StringBuilder();
            sb.append(f);
            sb.append(TokenParser.SP);
            string = context.getString(R.string.degree_centigrade);
        }
        sb.append(string);
        return sb.toString();
    }

    @OXOo.OOXIXo
    public static final String OI0(int i, int i2) {
        String valueOf;
        if (i2 == 1) {
            i = (int) (i / 0.6213712f);
        }
        int i3 = i % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(i / 60);
        sb.append('\'');
        if (i3 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(i3);
            valueOf = sb2.toString();
        } else {
            valueOf = String.valueOf(i3);
        }
        sb.append(valueOf);
        sb.append("''");
        return sb.toString();
    }

    public static /* synthetic */ String OO(int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z = xoIox.ooXIXxIX();
        }
        return xoxXI(i, i2, i3, i4, z);
    }

    public static /* synthetic */ String OO0x0xX(BleSDCardInfo bleSDCardInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return x0xO(bleSDCardInfo, z);
    }

    public static final float OOXIXo(float f) {
        return Float.parseFloat(oo((f * 1.8f) + 32, false, 2, null));
    }

    public static /* synthetic */ String Oo(int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return x0xO0oo(i, i2, z);
    }

    public static /* synthetic */ ArrayList OxI(ArrayList arrayList, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        return o00(arrayList, f, i);
    }

    @OXOo.OOXIXo
    public static final String Oxx0IOOO(float f, float f2) {
        return oo(f / ((f2 * f2) / 10000), false, 2, null);
    }

    public static final float Oxx0xo(int i, boolean z) {
        return XIxXXX0x0(i / 10.0f, z);
    }

    public static final int OxxIIOOXO(int i) {
        return i == 0 ? R.string.weather_km : R.string.weather_mi;
    }

    @OXOo.OOXIXo
    public static final String X00IoxXI(int i, int i2) {
        if (i2 == 0) {
            return String.valueOf(i);
        }
        String format = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(i * 3.28d);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
        return format;
    }

    @OXOo.OOXIXo
    public static final String X0IIOO(@OXOo.OOXIXo Context context, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (z) {
            return ((int) OOXIXo(i)) + context.getString(R.string.fahrenheit);
        }
        return i + context.getString(R.string.degree_centigrade);
    }

    @OXOo.OOXIXo
    public static final String X0o0xo(int i) {
        Application app = Utils.getApp();
        if (i != 0) {
            if (i != 5) {
                if (i != 15) {
                    if (i != 30) {
                        if (i != 60) {
                            if (i != 120) {
                                if (i != 1440) {
                                    if (i != 2880) {
                                        if (i != 10080) {
                                            String string = app.getString(R.string.at_time_of_event);
                                            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                                            return string;
                                        }
                                        String string2 = app.getString(R.string.a_week_before);
                                        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                                        return string2;
                                    }
                                    String string3 = app.getString(R.string.two_day_before);
                                    kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
                                    return string3;
                                }
                                String string4 = app.getString(R.string.one_day_before);
                                kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
                                return string4;
                            }
                            String string5 = app.getString(R.string.two_hours_before);
                            kotlin.jvm.internal.IIX0o.oO(string5, "getString(...)");
                            return string5;
                        }
                        String string6 = app.getString(R.string.one_hour_before);
                        kotlin.jvm.internal.IIX0o.oO(string6, "getString(...)");
                        return string6;
                    }
                    String string7 = app.getString(R.string.thirty_minutes_before);
                    kotlin.jvm.internal.IIX0o.oO(string7, "getString(...)");
                    return string7;
                }
                String string8 = app.getString(R.string.fifteen_minutes_before);
                kotlin.jvm.internal.IIX0o.oO(string8, "getString(...)");
                return string8;
            }
            String string9 = app.getString(R.string.five_minutes_before);
            kotlin.jvm.internal.IIX0o.oO(string9, "getString(...)");
            return string9;
        }
        String string10 = app.getString(R.string.at_time_of_event);
        kotlin.jvm.internal.IIX0o.oO(string10, "getString(...)");
        return string10;
    }

    public static final int XI0IXoo(int i) {
        if (ProductManager.f20544oIX0oI.xXIX0Xo()) {
            return BleCache.getInt$default(BleCache.INSTANCE, BleKey.TEMPERATURE_UNIT, 0, null, 6, null);
        }
        return i;
    }

    public static final float XIxXXX0x0(float f, boolean z) {
        if (z) {
            return OOXIXo(f);
        }
        return xoIox(f);
    }

    @OXOo.OOXIXo
    public static final Triple<Integer, Integer, Integer> XO(@OXOo.OOXIXo String birthday) {
        int i;
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(birthday, "birthday");
        int i3 = 1;
        if (StringsKt__StringsKt.o00xOoIO(birthday, HelpFormatter.DEFAULT_OPT_PREFIX, false, 2, null)) {
            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(birthday, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, null);
            i = Integer.parseInt((String) XXoO0oX2.get(0));
            i3 = Integer.parseInt((String) XXoO0oX2.get(1));
            i2 = Integer.parseInt((String) XXoO0oX2.get(2));
        } else if (StringsKt__StringsKt.o00xOoIO(birthday, "/", false, 2, null)) {
            List XXoO0oX3 = StringsKt__StringsKt.XXoO0oX(birthday, new String[]{"/"}, false, 0, 6, null);
            int parseInt = Integer.parseInt((String) XXoO0oX3.get(0));
            int parseInt2 = Integer.parseInt((String) XXoO0oX3.get(1));
            i = Integer.parseInt((String) XXoO0oX3.get(2));
            i2 = parseInt2;
            i3 = parseInt;
        } else {
            i = 2000;
            i2 = 1;
        }
        return new Triple<>(Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
    }

    @OXOo.OOXIXo
    public static final String XOxIOxOx(int i) {
        String valueOf;
        int i2 = i % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(i / 60);
        sb.append('\'');
        if (i2 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(i2);
            valueOf = sb2.toString();
        } else {
            valueOf = String.valueOf(i2);
        }
        sb.append(valueOf);
        sb.append("''");
        return sb.toString();
    }

    @OXOo.OOXIXo
    public static final String XX(@OXOo.OOXIXo String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        if (!ProductManager.f20544oIX0oI.o0xIIX0()) {
            String replaceAll = Pattern.compile("[\\-\\s]").matcher(text).replaceAll("");
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(replaceAll);
            return replaceAll;
        }
        return text;
    }

    @OXOo.OOXIXo
    public static final String XX0(double d, int i) {
        if (i == 0) {
            return oo((float) d, false, 2, null);
        }
        return oo((float) (d * 0.03937d), false, 2, null);
    }

    @OXOo.OOXIXo
    public static final String Xo0(double d, int i) {
        if (i == 0) {
            return oo((float) d, false, 2, null);
        }
        return oo((float) (d * 3.2808399d), false, 2, null);
    }

    @OXOo.OOXIXo
    public static final String XoI0Ixx0(int i, float f, int i2) {
        int i3;
        if (i == 1) {
            i3 = 55;
        } else {
            i3 = 46;
        }
        return oo((((i3 * f) * i2) / 10) / 10000, false, 2, null);
    }

    @OXOo.OOXIXo
    public static final String XoX(int i) {
        Application app = Utils.getApp();
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i / 60)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(app.getString(R.string.minute_abrv));
        String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i % 60)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
        sb.append(format2);
        sb.append(app.getString(R.string.second_abrv));
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public static final double Xx000oIo(int i) {
        return i * 0.1450377d;
    }

    public static final float XxX0x0xxx(float f, int i) {
        if (i == 1) {
            return Xx000oIo.XO.I0Io(f);
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final String o0(@OXOo.OOXIXo String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        if (!ProductManager.f20544oIX0oI.o0xIIX0()) {
            String replaceAll = Pattern.compile("[\\-]").matcher(text).replaceAll("");
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(replaceAll);
            return replaceAll;
        }
        return text;
    }

    @OXOo.OOXIXo
    public static final ArrayList<CustomLatLng> o00(@OXOo.OOXIXo ArrayList<CustomLatLng> locationList, float f, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        ArrayList<CustomLatLng> arrayList = new ArrayList<>();
        int size = locationList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            CustomLatLng customLatLng = locationList.get(i3);
            kotlin.jvm.internal.IIX0o.oO(customLatLng, "get(...)");
            CustomLatLng customLatLng2 = customLatLng;
            if (i3 < locationList.size() - 1) {
                int i4 = i3 + 1;
                int distance = (int) DistanceUtil.getDistance(new LatLng(customLatLng2.getLatitude(), customLatLng2.getLongitude()), new LatLng(locationList.get(i4).getLatitude(), locationList.get(i4).getLongitude()));
                if (arrayList.isEmpty()) {
                    arrayList.add(locationList.get(i4));
                }
                i2 += distance;
                float x0XOIxOo2 = x0XOIxOo(i2, i);
                if (x0XOIxOo2 >= f) {
                    arrayList.add(locationList.get(i4));
                    LogUtils.d(" SegmentLocation " + i3 + TokenParser.SP + x0XOIxOo2 + TokenParser.SP);
                    i2 = 0;
                }
            }
        }
        return arrayList;
    }

    public static final int oI0IIXIo(int i) {
        return i == 0 ? R.string.km : R.string.mi;
    }

    @OXOo.OOXIXo
    public static final String oIX0oI(float f, boolean z) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        if (!z) {
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
        }
        String format = decimalFormat.format(new BigDecimal(String.valueOf(f)));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final int oO(int i) {
        return i / 10000;
    }

    public static /* synthetic */ String oOXoIIIo(float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return IoOoX(f, z);
    }

    public static final float oOoXoXO(int i, int i2, boolean z) {
        return Float.parseFloat(x0xO0oo(i, i2, z));
    }

    @OXOo.OOXIXo
    public static final String oX(int i, int i2, int i3) {
        return I0X0x0oIo((i / i2) * 3.6d, i3);
    }

    public static /* synthetic */ String oo(float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oo0xXOI0I(f, z);
    }

    @OXOo.OOXIXo
    public static final String oo0xXOI0I(float f, boolean z) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            if (!z) {
                decimalFormat.setRoundingMode(RoundingMode.DOWN);
            }
            String format = decimalFormat.format(new BigDecimal(String.valueOf(f)));
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(format);
            return format;
        }
        return cn.d;
    }

    public static /* synthetic */ float ooOOo0oXI(int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return oOoXoXO(i, i2, z);
    }

    @OXOo.OOXIXo
    public static final String ooXIXxIX(int i) {
        return (i / 60) + Utils.getApp().getString(R.string.h) + (i % 60) + Utils.getApp().getString(R.string.h_m);
    }

    @OXOo.OOXIXo
    public static final String oxXx0IX(int i) {
        Application app = Utils.getApp();
        if (i == 0) {
            return ProductManager.f20544oIX0oI.XIxXXX0x0();
        }
        String string = app.getString(R.string.d_seconds, Integer.valueOf(i));
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
        return string;
    }

    public static final int oxoX(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 5) {
            return 1;
        }
        if (i == 15) {
            return 2;
        }
        if (i == 30) {
            return 3;
        }
        if (i == 60) {
            return 4;
        }
        if (i == 120) {
            return 5;
        }
        if (i == 1440) {
            return 6;
        }
        if (i != 2880) {
            return i != 10080 ? 0 : 8;
        }
        return 7;
    }

    @OXOo.OOXIXo
    public static final String oxxXoxO(int i) {
        Application app = Utils.getApp();
        if (i == 0) {
            String string = app.getString(R.string.always_on);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        String string2 = app.getString(R.string.turn_wrist);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
        return string2;
    }

    public static final float x0XOIxOo(int i, int i2) {
        if (i2 == 0) {
            return i / 1000.0f;
        }
        return Xx000oIo.XO.oxoX(i / 1000.0f);
    }

    public static final int x0o(float f, int i) {
        return (int) (i / f);
    }

    @OXOo.OOXIXo
    public static final String x0xO(@OXOo.oOoXoXO BleSDCardInfo bleSDCardInfo, boolean z) {
        long j;
        long j2;
        long j3;
        double d;
        if (bleSDCardInfo != null) {
            j = bleSDCardInfo.getMFreeSize();
        } else {
            j = 0;
        }
        long j4 = j * 1024;
        if (bleSDCardInfo != null) {
            j2 = bleSDCardInfo.getMTotalSize();
        } else {
            j2 = 0;
        }
        long j5 = j2 * 1024;
        if (j5 <= com.garmin.fit.O0Xx.f12382xxX) {
            d = 0.5d;
        } else if (j5 <= 1073741824) {
            d = 1.0d;
        } else {
            long j6 = 1073741824;
            if (j5 % j6 == 0) {
                j3 = j5 / j6;
            } else {
                j3 = (j5 / j6) + 1;
            }
            d = j3;
        }
        long j7 = (long) (1073741824 * d);
        long j8 = j7 - j4;
        StringBuffer stringBuffer = new StringBuffer();
        if (!z) {
            j4 = j8;
        }
        stringBuffer.append(ConvertUtils.byte2FitMemorySize(j4, 0));
        stringBuffer.append("/");
        stringBuffer.append(ConvertUtils.byte2FitMemorySize(j7, 0));
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("(%.0fGb)", Arrays.copyOf(new Object[]{Double.valueOf(d * 8)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        stringBuffer.append(format);
        String stringBuffer2 = stringBuffer.toString();
        kotlin.jvm.internal.IIX0o.oO(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    @OXOo.OOXIXo
    public static final String x0xO0oo(int i, int i2, boolean z) {
        if (ProductManager.f20544oIX0oI.Ioxxx()) {
            return IoOoX(x0XOIxOo(i, i2), z);
        }
        return oo0xXOI0I(x0XOIxOo(i, i2), z);
    }

    @OXOo.OOXIXo
    public static final String xI(int i) {
        Application app = Utils.getApp();
        if (i < 60) {
            String string = app.getString(R.string.d_minutes, Integer.valueOf(i));
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        String string2 = app.getString(R.string.d_hours, Integer.valueOf(i / 60));
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
        return string2;
    }

    @OXOo.OOXIXo
    public static final String xII(int i) {
        Application app = Utils.getApp();
        if (i != 0) {
            if (i != 1) {
                String string = app.getString(R.string.daylight);
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
                return string;
            }
            String string2 = app.getString(R.string.high_visibility);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
            return string2;
        }
        String string3 = app.getString(R.string.original);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
        return string3;
    }

    public static final float xXOx(int i, int i2, int i3) {
        return Float.parseFloat(oX(i, i2, i3));
    }

    public static final void xXxxox0I(int i, @OXOo.OOXIXo DINCondBold showValue, @OXOo.OOXIXo Context context, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(showValue, "showValue");
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        SpanUtils.with(showValue).append(String.valueOf(i / 60)).setFontSize(i2, true).append(context.getString(R.string.h)).setFontSize(16, true).setForegroundColor(ContextCompat.getColor(context, i3)).append(String.valueOf(i % 60)).setFontSize(i2, true).append(context.getString(R.string.h_m)).setFontSize(16, true).setForegroundColor(ContextCompat.getColor(context, i3)).create();
    }

    public static final float xo0x(double d, int i) {
        return Float.parseFloat(I0X0x0oIo(d, i));
    }

    public static final float xoIox(float f) {
        return Float.parseFloat(oo(f, false, 2, null));
    }

    @OXOo.OOXIXo
    public static final String xoIxX(int i) {
        Application app = Utils.getApp();
        if (i == 0) {
            String string = app.getString(R.string.off);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        return String.valueOf(i);
    }

    public static /* synthetic */ ArrayList xoXoI(List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 60;
        }
        return IIXOooo(list, i);
    }

    @OXOo.OOXIXo
    public static final String xoxXI(int i, int i2, int i3, int i4, boolean z) {
        Application app = Utils.getApp();
        SimpleDateFormat XoX2 = xoIox.XoX(z);
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, i);
        oOXoIIIo.II0xO0.IIXOooo(calendar, i2);
        Calendar calendar2 = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar2);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar2, i3);
        oOXoIIIo.II0xO0.IIXOooo(calendar2, i4);
        String string = app.getString(R.string.time_range, XoX2.format(calendar.getTime()), XoX2.format(calendar2.getTime()));
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        return string;
    }

    public static final int xxIXOIIO(int i) {
        return i / 10000;
    }

    public static final int xxX(int i) {
        return i == 0 ? R.string.kg : R.string.lbs;
    }
}
