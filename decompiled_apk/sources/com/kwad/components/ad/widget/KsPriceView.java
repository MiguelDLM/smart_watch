package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class KsPriceView extends TextView implements d {
    private static String IH = "¥%s 到手约 ¥%s";
    private static String II = "¥%s  ¥%s";
    private static String IJ = "¥%s";
    private a IG;
    private String IK;
    private String IL;
    private boolean IM;

    /* loaded from: classes11.dex */
    public static class a {
        private int IN;

        /* renamed from: IO, reason: collision with root package name */
        private int f18452IO;
        private int IP;
        private int IQ;
        private int IR;
        private int IS;

        public final a ae(int i) {
            this.f18452IO = i;
            return this;
        }

        public final a af(int i) {
            this.IR = i;
            return this;
        }

        public final a ag(int i) {
            this.IS = i;
            return this;
        }

        public final int mK() {
            return this.IP;
        }

        public final int mL() {
            return this.IR;
        }

        public final int mM() {
            return this.IQ;
        }

        public final int mN() {
            return this.IS;
        }

        public final int mO() {
            return this.IN;
        }

        public final int mP() {
            return this.f18452IO;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.IG = new a();
        P(context);
    }

    private void P(Context context) {
        setMaxLines(1);
        a aVar = this.IG;
        Resources resources = context.getResources();
        int i = R.color.ksad_reward_main_color;
        aVar.IP = resources.getColor(i);
        a aVar2 = this.IG;
        Resources resources2 = context.getResources();
        int i2 = R.dimen.ksad_reward_order_price_size;
        aVar2.IQ = resources2.getDimensionPixelSize(i2);
        this.IG.IR = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.IG.IS = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.IG.IN = context.getResources().getColor(i);
        this.IG.f18452IO = context.getResources().getDimensionPixelSize(i2);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(IJ, str);
        } else {
            format = String.format(z ? II : IH, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.mO()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mP()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.mK()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.mM()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.mL()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mN()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.IK = str;
        this.IL = str2;
        this.IM = z;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.IL = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.IG.mK());
        try {
            spannableString = a(str, this.IL, z, this.IG);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    @NonNull
    public a getConfig() {
        return this.IG;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IG = new a();
        P(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.IG = new a();
        P(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.IG = new a();
        P(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.IG.IP = eVar.tX();
        d(this.IK, this.IL, this.IM);
    }
}
