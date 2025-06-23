package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.LibExKt;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.XIxXXX0x0;
import oIxOXo.oxoX;

@XX({"SMAP\nWeightMeasureData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightMeasureData.kt\ncom/sma/smartv3/model/WeightMeasureDataKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,475:1\n1#2:476\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightMeasureDataKt {
    public static final double centigradeFilter(double d) {
        return Double.parseDouble(keepOneDecimal(d));
    }

    @SuppressLint({"SimpleDateFormat"})
    public static final int getAgeByBirth(@OOXIXo String birthdayString) {
        Date parse;
        String str;
        IIX0o.x0xO0oo(birthdayString, "birthdayString");
        try {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.OoO()) {
                if (projectManager.x0XOIxOo() == DateTimeFormat.MMddyyyy) {
                    str = xoIox.f24683IIXOooo;
                } else {
                    str = xoIox.f24693OxxIIOOXO;
                }
                parse = new SimpleDateFormat(str).parse(birthdayString);
            } else {
                parse = new SimpleDateFormat("dd.MM.yyyy").parse(birthdayString);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(parse);
            if (calendar2.after(calendar)) {
                return 0;
            }
            int i = calendar.get(1) - calendar2.get(1);
            int i2 = calendar.get(2) - calendar2.get(2);
            int i3 = calendar.get(5) - calendar2.get(5);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(TokenParser.SP);
            sb.append(i2);
            sb.append(TokenParser.SP);
            sb.append(i3);
            System.out.println((Object) sb.toString());
            if (i2 > 0) {
                if (i2 > 6 || (i2 == 6 && i3 >= 0)) {
                    return i + 1;
                }
            } else if (i2 < -6 || (i2 == -6 && i3 < 0)) {
                return i - 1;
            }
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final int getLevel(double d, @OOXIXo List<Double> levelRange) {
        IIX0o.x0xO0oo(levelRange, "levelRange");
        if (levelRange.isEmpty()) {
            return (int) d;
        }
        int i = 0;
        if (levelRange.size() == 1) {
            if (d < levelRange.get(0).doubleValue()) {
                return 1;
            }
            if (d == levelRange.get(0).doubleValue()) {
                return 2;
            }
            return 3;
        }
        Iterator<Double> it = levelRange.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i + 1;
            if (d <= it.next().doubleValue()) {
                return i;
            }
            int i4 = i;
            i = i3;
            i2 = i4;
        }
        return i2;
    }

    public static /* synthetic */ int getLevel$default(double d, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return getLevel(d, list);
    }

    @OOXIXo
    public static final LevelType getLevelType(int i, int i2) {
        if (i2 < i) {
            return LevelType.LOW;
        }
        if (i2 > i) {
            return LevelType.HIGH;
        }
        return LevelType.STANDARD;
    }

    public static final double getWeightValue(double d, int i) {
        if (i == 1) {
            return kg2Lbs(d);
        }
        return d;
    }

    @OOXIXo
    public static final String keepOneDecimal(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String format = decimalFormat.format(d);
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final double kg2Lbs(double d) {
        return d * 2.20462f;
    }

    public static final void setBarView(@OOXIXo SegmentedBarView sbv, double d, @OOXIXo List<Double> levelRange, @OOXIXo String[] levelRangeText, @OOXIXo int[] levelColor, boolean z) {
        float doubleValue;
        float doubleValue2;
        double d2 = d;
        IIX0o.x0xO0oo(sbv, "sbv");
        IIX0o.x0xO0oo(levelRange, "levelRange");
        IIX0o.x0xO0oo(levelRangeText, "levelRangeText");
        IIX0o.x0xO0oo(levelColor, "levelColor");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (!levelRange.isEmpty()) {
            int length = levelRangeText.length;
            while (i < length && i <= levelRange.size()) {
                if (i == 0) {
                    doubleValue = 0.0f;
                } else {
                    doubleValue = (float) levelRange.get(i).doubleValue();
                }
                if (i == levelRange.size() - 1) {
                    doubleValue2 = ((float) (doubleValue - levelRange.get(i - 1).doubleValue())) + doubleValue;
                } else {
                    doubleValue2 = (float) levelRange.get(i + 1).doubleValue();
                }
                o0Xo.oIX0oI x0XOIxOo2 = new o0Xo.oIX0oI(doubleValue, doubleValue2, levelRangeText[i], levelColor[i]).x0XOIxOo("");
                if (z) {
                    if (i == 0) {
                        x0XOIxOo2.x0XOIxOo(String.valueOf(doubleValue));
                    } else if (i == levelRangeText.length - 1) {
                        x0XOIxOo2.x0XOIxOo(String.valueOf(doubleValue2));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(doubleValue);
                        sb.append(XIxXXX0x0.f29558oxoX);
                        sb.append(doubleValue2);
                        x0XOIxOo2.x0XOIxOo(sb.toString());
                    }
                } else if (levelRangeText.length == 2) {
                    if (i == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(doubleValue);
                        sb2.append(XIxXXX0x0.f29558oxoX);
                        x0XOIxOo2.x0XOIxOo(sb2.toString());
                    }
                } else if (i != 0 && i != levelRangeText.length - 1) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(doubleValue);
                    sb3.append(XIxXXX0x0.f29558oxoX);
                    sb3.append(doubleValue2);
                    x0XOIxOo2.x0XOIxOo(sb3.toString());
                }
                IIX0o.ooOOo0oXI(x0XOIxOo2);
                arrayList.add(x0XOIxOo2);
                i++;
            }
            sbv.setShowDescriptionText(true);
            if (d2 > levelRange.get(levelRange.size() - 1).doubleValue()) {
                d2 = levelRange.get(levelRange.size() - 1).doubleValue();
            }
            sbv.setValue(Float.valueOf((float) d2));
        } else {
            int length2 = levelRangeText.length;
            while (i < length2) {
                int i2 = i + 1;
                o0Xo.oIX0oI x0XOIxOo3 = new o0Xo.oIX0oI(i, i2, levelRangeText[i], levelColor[i]).x0XOIxOo("");
                IIX0o.ooOOo0oXI(x0XOIxOo3);
                arrayList.add(x0XOIxOo3);
                i = i2;
            }
        }
        sbv.setSegments(arrayList);
        sbv.setDescriptionTextColor(oxoX.I0Io(sbv.getContext(), R.color.text_color));
        sbv.setDescriptionTopTextColor(oxoX.I0Io(sbv.getContext(), R.color.text_color));
    }

    public static /* synthetic */ void setBarView$default(SegmentedBarView segmentedBarView, double d, List list, String[] strArr, int[] iArr, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        setBarView(segmentedBarView, d, list, strArr, iArr, z2);
    }

    public static final void setLevelView(@OOXIXo TextView view, int i, @OOXIXo String[] levelRangeText, @OOXIXo int[] levelColor) {
        boolean z;
        int i2;
        IIX0o.x0xO0oo(view, "view");
        IIX0o.x0xO0oo(levelRangeText, "levelRangeText");
        IIX0o.x0xO0oo(levelColor, "levelColor");
        boolean z2 = true;
        if (levelRangeText.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (i >= 0 && i < levelRangeText.length) {
                view.setText(levelRangeText[i]);
            } else {
                view.setVisibility(8);
            }
        }
        if (levelColor.length != 0) {
            z2 = false;
        }
        if (!z2) {
            if (i >= 0 && i < levelColor.length) {
                i2 = levelColor[i];
            } else {
                i2 = levelColor[0];
            }
            view.setTextColor(i2);
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.shape_measure_state_bg);
            IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setStroke((int) XIXIX.OOXIXo.X0o0xo(1.0f), i2);
            LibExKt.xX0IIXIx0(view, gradientDrawable);
            view.invalidateDrawable(gradientDrawable);
        }
    }
}
