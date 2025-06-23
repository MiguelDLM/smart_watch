package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class EllipsizingTextView extends TextView {
    private static final CharSequence k = "…";
    private static final Pattern l = Pattern.compile("[\\.!?,;:…]*$", 32);

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f9101a;
    private g b;
    private boolean c;
    private boolean d;
    private boolean e;
    private CharSequence f;
    private int g;
    private float h;
    private float i;
    private Pattern j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9102a;

        static {
            int[] iArr = new int[TextUtils.TruncateAt.values().length];
            f9102a = iArr;
            try {
                iArr[TextUtils.TruncateAt.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9102a[TextUtils.TruncateAt.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9102a[TextUtils.TruncateAt.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9102a[TextUtils.TruncateAt.MARQUEE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends g {
        private b() {
            super(EllipsizingTextView.this, null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.subview.widget.EllipsizingTextView.g
        public CharSequence a(CharSequence charSequence) {
            int lastIndexOf;
            int lineEnd = b(charSequence).getLineEnd(EllipsizingTextView.this.g - 1);
            int length = charSequence.length();
            int i = length - lineEnd;
            if (i < EllipsizingTextView.k.length()) {
                i = EllipsizingTextView.k.length();
            }
            String trim = TextUtils.substring(charSequence, 0, length - i).trim();
            String e = e(trim);
            while (true) {
                if (c(e + ((Object) EllipsizingTextView.k)) || (lastIndexOf = trim.lastIndexOf(32)) == -1) {
                    break;
                }
                trim = trim.substring(0, lastIndexOf).trim();
                e = e(trim);
            }
            String str = e + ((Object) EllipsizingTextView.k);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (charSequence instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) charSequence, 0, str.length(), null, spannableStringBuilder, 0);
            }
            return spannableStringBuilder;
        }

        public String e(CharSequence charSequence) {
            return EllipsizingTextView.this.j.matcher(charSequence).replaceFirst("");
        }

        public /* synthetic */ b(EllipsizingTextView ellipsizingTextView, a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class d extends g {
        private d() {
            super(EllipsizingTextView.this, null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.subview.widget.EllipsizingTextView.g
        public CharSequence a(CharSequence charSequence) {
            SpannableStringBuilder spannableStringBuilder;
            int lineEnd = b(charSequence).getLineEnd(EllipsizingTextView.this.g - 1);
            int length = charSequence.length();
            int i = length - lineEnd;
            if (i < EllipsizingTextView.k.length()) {
                i = EllipsizingTextView.k.length();
            }
            int i2 = i + (lineEnd % 2);
            int i3 = length / 2;
            int i4 = i2 / 2;
            String trim = TextUtils.substring(charSequence, 0, i3 - i4).trim();
            String trim2 = TextUtils.substring(charSequence, i3 + i4, length).trim();
            while (true) {
                if (!c(trim + ((Object) EllipsizingTextView.k) + trim2)) {
                    int lastIndexOf = trim.lastIndexOf(32);
                    int indexOf = trim2.indexOf(32);
                    if (lastIndexOf == -1 || indexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf).trim();
                    trim2 = trim2.substring(indexOf, trim2.length()).trim();
                } else {
                    break;
                }
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(trim);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(trim2);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                TextUtils.copySpansFrom(spanned, 0, trim.length(), null, spannableStringBuilder2, 0);
                spannableStringBuilder = spannableStringBuilder3;
                TextUtils.copySpansFrom(spanned, length - trim2.length(), length, null, spannableStringBuilder, 0);
            } else {
                spannableStringBuilder = spannableStringBuilder3;
            }
            return TextUtils.concat(spannableStringBuilder2, EllipsizingTextView.k, spannableStringBuilder);
        }

        public /* synthetic */ d(EllipsizingTextView ellipsizingTextView, a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends g {
        private e() {
            super(EllipsizingTextView.this, null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.subview.widget.EllipsizingTextView.g
        public CharSequence a(CharSequence charSequence) {
            return charSequence;
        }

        public /* synthetic */ e(EllipsizingTextView ellipsizingTextView, a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public class f extends g {
        private f() {
            super(EllipsizingTextView.this, null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.subview.widget.EllipsizingTextView.g
        public CharSequence a(CharSequence charSequence) {
            int indexOf;
            int lineEnd = b(charSequence).getLineEnd(EllipsizingTextView.this.g - 1);
            int length = charSequence.length();
            int i = length - lineEnd;
            if (i < EllipsizingTextView.k.length()) {
                i = EllipsizingTextView.k.length();
            }
            String trim = TextUtils.substring(charSequence, i, length).trim();
            while (true) {
                if (c(((Object) EllipsizingTextView.k) + trim) || (indexOf = trim.indexOf(32)) == -1) {
                    break;
                }
                trim = trim.substring(indexOf, trim.length()).trim();
            }
            String str = ((Object) EllipsizingTextView.k) + trim;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (charSequence instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) charSequence, length - str.length(), length, null, spannableStringBuilder, 0);
            }
            return spannableStringBuilder;
        }

        public /* synthetic */ f(EllipsizingTextView ellipsizingTextView, a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public abstract class g {
        private g() {
        }

        public int a() {
            return ((EllipsizingTextView.this.getHeight() - EllipsizingTextView.this.getCompoundPaddingTop()) - EllipsizingTextView.this.getCompoundPaddingBottom()) / b("").getLineBottom(0);
        }

        public abstract CharSequence a(CharSequence charSequence);

        public Layout b(CharSequence charSequence) {
            return new StaticLayout(charSequence, EllipsizingTextView.this.getPaint(), (EllipsizingTextView.this.getMeasuredWidth() - EllipsizingTextView.this.getPaddingLeft()) - EllipsizingTextView.this.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, EllipsizingTextView.this.h, EllipsizingTextView.this.i, false);
        }

        public boolean c(CharSequence charSequence) {
            if (b(charSequence).getLineCount() <= b()) {
                return true;
            }
            return false;
        }

        public CharSequence d(CharSequence charSequence) {
            if (!c(charSequence)) {
                return a(charSequence);
            }
            return charSequence;
        }

        public /* synthetic */ g(EllipsizingTextView ellipsizingTextView, a aVar) {
            this();
        }

        public int b() {
            if (!EllipsizingTextView.this.a()) {
                return EllipsizingTextView.this.g;
            }
            int a2 = a();
            if (a2 == -1) {
                return 1;
            }
            return a2;
        }
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.g;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.d) {
            c();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (a()) {
            this.d = true;
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        a aVar = null;
        if (truncateAt == null) {
            this.b = new e(this, aVar);
            return;
        }
        int i = a.f9102a[truncateAt.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        this.b = new e(this, aVar);
                        return;
                    }
                    super.setEllipsize(truncateAt);
                    this.d = false;
                    this.b = new e(this, aVar);
                    return;
                }
                this.b = new d(this, aVar);
                return;
            }
            this.b = new f(this, aVar);
            return;
        }
        this.b = new b(this, aVar);
    }

    public void setEndPunctuationPattern(Pattern pattern) {
        this.j = pattern;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f2, float f3) {
        this.i = f2;
        this.h = f3;
        super.setLineSpacing(f2, f3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.g = i;
        this.d = true;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (a()) {
            this.d = true;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.e) {
            this.f = charSequence;
            this.d = true;
        }
        super.setText(charSequence, bufferType);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9101a = new ArrayList();
        this.h = 1.0f;
        this.i = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.maxLines}, i, 0);
        setMaxLines(obtainStyledAttributes.getInt(0, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
        setEndPunctuationPattern(l);
    }

    private void c() {
        boolean z;
        int maxLines = getMaxLines();
        CharSequence charSequence = this.f;
        if (maxLines != -1) {
            if (this.b == null) {
                setEllipsize(null);
            }
            charSequence = this.b.d(this.f);
            z = !this.b.c(this.f);
        } else {
            z = false;
        }
        if (!charSequence.equals(getText())) {
            this.e = true;
            try {
                setText(charSequence);
            } finally {
                this.e = false;
            }
        }
        this.d = false;
        if (z != this.c) {
            this.c = z;
            Iterator<c> it = this.f9101a.iterator();
            while (it.hasNext()) {
                it.next().a(z);
            }
        }
    }

    public boolean a() {
        return this.g == Integer.MAX_VALUE;
    }
}
