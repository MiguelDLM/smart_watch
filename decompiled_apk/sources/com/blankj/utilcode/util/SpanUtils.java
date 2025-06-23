package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class SpanUtils {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_TOP = 3;
    private static final int COLOR_DEFAULT = -16777217;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private int alignImage;
    private int alignLine;
    private Layout.Alignment alignment;
    private int backgroundColor;
    private float blurRadius;
    private int bulletColor;
    private int bulletGapWidth;
    private int bulletRadius;
    private ClickableSpan clickSpan;
    private int first;
    private int flag;
    private String fontFamily;
    private int fontSize;
    private boolean fontSizeIsDp;
    private int foregroundColor;
    private Bitmap imageBitmap;
    private Drawable imageDrawable;
    private int imageResourceId;
    private Uri imageUri;
    private boolean isBold;
    private boolean isBoldItalic;
    private boolean isCreated;
    private boolean isItalic;
    private boolean isStrikethrough;
    private boolean isSubscript;
    private boolean isSuperscript;
    private boolean isUnderline;
    private int lineHeight;
    private SerializableSpannableStringBuilder mBuilder;
    private CharSequence mText;
    private TextView mTextView;
    private int mType;
    private final int mTypeCharSequence;
    private final int mTypeImage;
    private final int mTypeSpace;
    private float proportion;
    private int quoteColor;
    private int quoteGapWidth;
    private int rest;
    private Shader shader;
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;
    private float shadowRadius;
    private int spaceColor;
    private int spaceSize;
    private Object[] spans;
    private int stripeWidth;
    private BlurMaskFilter.Blur style;
    private Typeface typeface;
    private String url;
    private int verticalAlign;
    private float xProportion;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface Align {
    }

    /* loaded from: classes8.dex */
    public static class CustomBulletSpan implements LeadingMarginSpan {
        private final int color;
        private final int gapWidth;
        private final int radius;
        private Path sBulletPath;

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.color);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.sBulletPath == null) {
                        Path path = new Path();
                        this.sBulletPath = path;
                        path.addCircle(0.0f, 0.0f, this.radius, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i + (i2 * this.radius), (i3 + i5) / 2.0f);
                    canvas.drawPath(this.sBulletPath, paint);
                    canvas.restore();
                } else {
                    canvas.drawCircle(i + (i2 * r10), (i3 + i5) / 2.0f, this.radius, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return (this.radius * 2) + this.gapWidth;
        }

        private CustomBulletSpan(int i, int i2, int i3) {
            this.sBulletPath = null;
            this.color = i;
            this.radius = i2;
            this.gapWidth = i3;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class CustomDynamicDrawableSpan extends ReplacementSpan {
        static final int ALIGN_BASELINE = 1;
        static final int ALIGN_BOTTOM = 0;
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        private WeakReference<Drawable> mDrawableRef;
        final int mVerticalAlignment;

        private Drawable getCachedDrawable() {
            Drawable drawable;
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            if (weakReference != null) {
                drawable = weakReference.get();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawableRef = new WeakReference<>(drawable2);
                return drawable2;
            }
            return drawable;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            int height;
            float height2;
            if (canvas != null) {
                if (paint != null) {
                    Drawable cachedDrawable = getCachedDrawable();
                    Rect bounds = cachedDrawable.getBounds();
                    canvas.save();
                    if (bounds.height() < i5 - i3) {
                        int i6 = this.mVerticalAlignment;
                        if (i6 == 3) {
                            height2 = i3;
                        } else {
                            if (i6 == 2) {
                                height = ((i5 + i3) - bounds.height()) / 2;
                            } else if (i6 == 1) {
                                height2 = i4 - bounds.height();
                            } else {
                                height = i5 - bounds.height();
                            }
                            height2 = height;
                        }
                        canvas.translate(f, height2);
                    } else {
                        canvas.translate(f, i3);
                    }
                    cachedDrawable.draw(canvas);
                    canvas.restore();
                    return;
                }
                throw new NullPointerException("Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            throw new NullPointerException("Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public abstract Drawable getDrawable();

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int i3;
            if (paint != null) {
                Rect bounds = getCachedDrawable().getBounds();
                if (fontMetricsInt != null && (i3 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                    int i4 = this.mVerticalAlignment;
                    if (i4 == 3) {
                        fontMetricsInt.top = fontMetricsInt.top;
                        fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                    } else if (i4 == 2) {
                        int i5 = i3 / 4;
                        fontMetricsInt.top = ((-bounds.height()) / 2) - i5;
                        fontMetricsInt.bottom = (bounds.height() / 2) - i5;
                    } else {
                        int i6 = -bounds.height();
                        int i7 = fontMetricsInt.bottom;
                        fontMetricsInt.top = i6 + i7;
                        fontMetricsInt.bottom = i7;
                    }
                    fontMetricsInt.ascent = fontMetricsInt.top;
                    fontMetricsInt.descent = fontMetricsInt.bottom;
                }
                return bounds.right;
            }
            throw new NullPointerException("Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        private CustomDynamicDrawableSpan() {
            this.mVerticalAlignment = 0;
        }

        private CustomDynamicDrawableSpan(int i) {
            this.mVerticalAlignment = i;
        }
    }

    /* loaded from: classes8.dex */
    public static class CustomLineHeightSpan implements LineHeightSpan {
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        static Paint.FontMetricsInt sfm;
        private final int height;
        final int mVerticalAlignment;

        public CustomLineHeightSpan(int i, int i2) {
            this.height = i;
            this.mVerticalAlignment = i2;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = sfm;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                sfm = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i5 = this.height;
            int i6 = fontMetricsInt.descent;
            int i7 = fontMetricsInt.ascent;
            int i8 = i5 - (((i4 + i6) - i7) - i3);
            if (i8 > 0) {
                int i9 = this.mVerticalAlignment;
                if (i9 == 3) {
                    fontMetricsInt.descent = i6 + i8;
                } else if (i9 == 2) {
                    int i10 = i8 / 2;
                    fontMetricsInt.descent = i6 + i10;
                    fontMetricsInt.ascent = i7 - i10;
                } else {
                    fontMetricsInt.ascent = i7 - i8;
                }
            }
            int i11 = fontMetricsInt.bottom;
            int i12 = fontMetricsInt.top;
            int i13 = i5 - (((i4 + i11) - i12) - i3);
            if (i13 > 0) {
                int i14 = this.mVerticalAlignment;
                if (i14 == 3) {
                    fontMetricsInt.bottom = i11 + i13;
                } else if (i14 == 2) {
                    int i15 = i13 / 2;
                    fontMetricsInt.bottom = i11 + i15;
                    fontMetricsInt.top = i12 - i15;
                } else {
                    fontMetricsInt.top = i12 - i13;
                }
            }
            if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                sfm = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class CustomQuoteSpan implements LeadingMarginSpan {
        private final int color;
        private final int gapWidth;
        private final int stripeWidth;

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.color);
            canvas.drawRect(i, i3, i + (this.stripeWidth * i2), i5, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return this.stripeWidth + this.gapWidth;
        }

        private CustomQuoteSpan(int i, int i2, int i3) {
            this.color = i;
            this.stripeWidth = i2;
            this.gapWidth = i3;
        }
    }

    @SuppressLint({"ParcelCreator"})
    /* loaded from: classes8.dex */
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        private void apply(Paint paint, Typeface typeface) {
            int style;
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 == null) {
                style = 0;
            } else {
                style = typeface2.getStyle();
            }
            int i = style & (~typeface.getStyle());
            if ((i & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((i & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        private CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.newType = typeface;
        }
    }

    /* loaded from: classes8.dex */
    public static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }
    }

    /* loaded from: classes8.dex */
    public static class ShaderSpan extends CharacterStyle implements UpdateAppearance {
        private Shader mShader;

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.mShader);
        }

        private ShaderSpan(Shader shader) {
            this.mShader = shader;
        }
    }

    /* loaded from: classes8.dex */
    public static class ShadowSpan extends CharacterStyle implements UpdateAppearance {
        private float dx;
        private float dy;
        private float radius;
        private int shadowColor;

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.radius, this.dx, this.dy, this.shadowColor);
        }

        private ShadowSpan(float f, float f2, float f3, int i) {
            this.radius = f;
            this.dx = f2;
            this.dy = f3;
            this.shadowColor = i;
        }
    }

    /* loaded from: classes8.dex */
    public static class SpaceSpan extends ReplacementSpan {
        private final Paint paint;
        private final int width;

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            if (canvas != null) {
                if (paint != null) {
                    canvas.drawRect(f, i3, f + this.width, i5, this.paint);
                    return;
                }
                throw new NullPointerException("Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            throw new NullPointerException("Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            if (paint != null) {
                return this.width;
            }
            throw new NullPointerException("Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        private SpaceSpan(int i) {
            this(i, 0);
        }

        private SpaceSpan(int i, int i2) {
            Paint paint = new Paint();
            this.paint = paint;
            this.width = i;
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes8.dex */
    public static class VerticalAlignSpan extends ReplacementSpan {
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        final int mVerticalAlignment;

        public VerticalAlignSpan(int i) {
            this.mVerticalAlignment = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            if (canvas != null) {
                if (paint != null) {
                    CharSequence subSequence = charSequence.subSequence(i, i2);
                    Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                    canvas.drawText(subSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), paint);
                    return;
                }
                throw new NullPointerException("Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            throw new NullPointerException("Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            if (paint != null) {
                return (int) paint.measureText(charSequence.subSequence(i, i2).toString());
            }
            throw new NullPointerException("Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }

    private SpanUtils(TextView textView) {
        this();
        this.mTextView = textView;
    }

    private void apply(int i) {
        applyLast();
        this.mType = i;
    }

    private void applyLast() {
        if (this.isCreated) {
            return;
        }
        int i = this.mType;
        if (i == 0) {
            updateCharCharSequence();
        } else if (i == 1) {
            updateImage();
        } else if (i == 2) {
            updateSpace();
        }
        setDefault();
    }

    private void setDefault() {
        this.flag = 33;
        this.foregroundColor = COLOR_DEFAULT;
        this.backgroundColor = COLOR_DEFAULT;
        this.lineHeight = -1;
        this.quoteColor = COLOR_DEFAULT;
        this.first = -1;
        this.bulletColor = COLOR_DEFAULT;
        this.fontSize = -1;
        this.proportion = -1.0f;
        this.xProportion = -1.0f;
        this.isStrikethrough = false;
        this.isUnderline = false;
        this.isSuperscript = false;
        this.isSubscript = false;
        this.isBold = false;
        this.isItalic = false;
        this.isBoldItalic = false;
        this.fontFamily = null;
        this.typeface = null;
        this.alignment = null;
        this.verticalAlign = -1;
        this.clickSpan = null;
        this.url = null;
        this.blurRadius = -1.0f;
        this.shader = null;
        this.shadowRadius = -1.0f;
        this.spans = null;
        this.imageBitmap = null;
        this.imageDrawable = null;
        this.imageUri = null;
        this.imageResourceId = -1;
        this.spaceSize = -1;
    }

    private void updateCharCharSequence() {
        if (this.mText.length() == 0) {
            return;
        }
        int length = this.mBuilder.length();
        if (length == 0 && this.lineHeight != -1) {
            this.mBuilder.append((CharSequence) Character.toString((char) 2)).append((CharSequence) "\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
            length = 2;
        }
        this.mBuilder.append(this.mText);
        int length2 = this.mBuilder.length();
        if (this.verticalAlign != -1) {
            this.mBuilder.setSpan(new VerticalAlignSpan(this.verticalAlign), length, length2, this.flag);
        }
        if (this.foregroundColor != COLOR_DEFAULT) {
            this.mBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), length, length2, this.flag);
        }
        if (this.backgroundColor != COLOR_DEFAULT) {
            this.mBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), length, length2, this.flag);
        }
        if (this.first != -1) {
            this.mBuilder.setSpan(new LeadingMarginSpan.Standard(this.first, this.rest), length, length2, this.flag);
        }
        int i = this.quoteColor;
        if (i != COLOR_DEFAULT) {
            this.mBuilder.setSpan(new CustomQuoteSpan(i, this.stripeWidth, this.quoteGapWidth), length, length2, this.flag);
        }
        int i2 = this.bulletColor;
        if (i2 != COLOR_DEFAULT) {
            this.mBuilder.setSpan(new CustomBulletSpan(i2, this.bulletRadius, this.bulletGapWidth), length, length2, this.flag);
        }
        if (this.fontSize != -1) {
            this.mBuilder.setSpan(new AbsoluteSizeSpan(this.fontSize, this.fontSizeIsDp), length, length2, this.flag);
        }
        if (this.proportion != -1.0f) {
            this.mBuilder.setSpan(new RelativeSizeSpan(this.proportion), length, length2, this.flag);
        }
        if (this.xProportion != -1.0f) {
            this.mBuilder.setSpan(new ScaleXSpan(this.xProportion), length, length2, this.flag);
        }
        int i3 = this.lineHeight;
        if (i3 != -1) {
            this.mBuilder.setSpan(new CustomLineHeightSpan(i3, this.alignLine), length, length2, this.flag);
        }
        if (this.isStrikethrough) {
            this.mBuilder.setSpan(new StrikethroughSpan(), length, length2, this.flag);
        }
        if (this.isUnderline) {
            this.mBuilder.setSpan(new UnderlineSpan(), length, length2, this.flag);
        }
        if (this.isSuperscript) {
            this.mBuilder.setSpan(new SuperscriptSpan(), length, length2, this.flag);
        }
        if (this.isSubscript) {
            this.mBuilder.setSpan(new SubscriptSpan(), length, length2, this.flag);
        }
        if (this.isBold) {
            this.mBuilder.setSpan(new StyleSpan(1), length, length2, this.flag);
        }
        if (this.isItalic) {
            this.mBuilder.setSpan(new StyleSpan(2), length, length2, this.flag);
        }
        if (this.isBoldItalic) {
            this.mBuilder.setSpan(new StyleSpan(3), length, length2, this.flag);
        }
        if (this.fontFamily != null) {
            this.mBuilder.setSpan(new TypefaceSpan(this.fontFamily), length, length2, this.flag);
        }
        if (this.typeface != null) {
            this.mBuilder.setSpan(new CustomTypefaceSpan(this.typeface), length, length2, this.flag);
        }
        if (this.alignment != null) {
            this.mBuilder.setSpan(new AlignmentSpan.Standard(this.alignment), length, length2, this.flag);
        }
        ClickableSpan clickableSpan = this.clickSpan;
        if (clickableSpan != null) {
            this.mBuilder.setSpan(clickableSpan, length, length2, this.flag);
        }
        if (this.url != null) {
            this.mBuilder.setSpan(new URLSpan(this.url), length, length2, this.flag);
        }
        if (this.blurRadius != -1.0f) {
            this.mBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.blurRadius, this.style)), length, length2, this.flag);
        }
        if (this.shader != null) {
            this.mBuilder.setSpan(new ShaderSpan(this.shader), length, length2, this.flag);
        }
        if (this.shadowRadius != -1.0f) {
            this.mBuilder.setSpan(new ShadowSpan(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor), length, length2, this.flag);
        }
        Object[] objArr = this.spans;
        if (objArr != null) {
            for (Object obj : objArr) {
                this.mBuilder.setSpan(obj, length, length2, this.flag);
            }
        }
    }

    private void updateImage() {
        int length = this.mBuilder.length();
        this.mText = "<img>";
        updateCharCharSequence();
        int length2 = this.mBuilder.length();
        if (this.imageBitmap != null) {
            this.mBuilder.setSpan(new CustomImageSpan(this.imageBitmap, this.alignImage), length, length2, this.flag);
            return;
        }
        if (this.imageDrawable != null) {
            this.mBuilder.setSpan(new CustomImageSpan(this.imageDrawable, this.alignImage), length, length2, this.flag);
        } else if (this.imageUri != null) {
            this.mBuilder.setSpan(new CustomImageSpan(this.imageUri, this.alignImage), length, length2, this.flag);
        } else if (this.imageResourceId != -1) {
            this.mBuilder.setSpan(new CustomImageSpan(this.imageResourceId, this.alignImage), length, length2, this.flag);
        }
    }

    private void updateSpace() {
        int length = this.mBuilder.length();
        this.mText = "< >";
        updateCharCharSequence();
        this.mBuilder.setSpan(new SpaceSpan(this.spaceSize, this.spaceColor), length, this.mBuilder.length(), this.flag);
    }

    public static SpanUtils with(TextView textView) {
        return new SpanUtils(textView);
    }

    public SpanUtils append(@NonNull CharSequence charSequence) {
        if (charSequence != null) {
            apply(0);
            this.mText = charSequence;
            return this;
        }
        throw new NullPointerException("Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendImage(@NonNull Bitmap bitmap) {
        if (bitmap != null) {
            return appendImage(bitmap, 0);
        }
        throw new NullPointerException("Argument 'bitmap' of type Bitmap (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendLine() {
        apply(0);
        this.mText = LINE_SEPARATOR;
        return this;
    }

    public SpanUtils appendSpace(@IntRange(from = 0) int i) {
        return appendSpace(i, 0);
    }

    public SpannableStringBuilder create() {
        applyLast();
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(this.mBuilder);
        }
        this.isCreated = true;
        return this.mBuilder;
    }

    public SpannableStringBuilder get() {
        return this.mBuilder;
    }

    public SpanUtils setBackgroundColor(@ColorInt int i) {
        this.backgroundColor = i;
        return this;
    }

    public SpanUtils setBlur(@FloatRange(from = 0.0d, fromInclusive = false) float f, BlurMaskFilter.Blur blur) {
        this.blurRadius = f;
        this.style = blur;
        return this;
    }

    public SpanUtils setBold() {
        this.isBold = true;
        return this;
    }

    public SpanUtils setBoldItalic() {
        this.isBoldItalic = true;
        return this;
    }

    public SpanUtils setBullet(@IntRange(from = 0) int i) {
        return setBullet(0, 3, i);
    }

    public SpanUtils setClickSpan(@NonNull ClickableSpan clickableSpan) {
        if (clickableSpan != null) {
            TextView textView = this.mTextView;
            if (textView != null && textView.getMovementMethod() == null) {
                this.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.clickSpan = clickableSpan;
            return this;
        }
        throw new NullPointerException("Argument 'clickSpan' of type ClickableSpan (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setFlag(int i) {
        this.flag = i;
        return this;
    }

    public SpanUtils setFontFamily(@NonNull String str) {
        if (str != null) {
            this.fontFamily = str;
            return this;
        }
        throw new NullPointerException("Argument 'fontFamily' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setFontProportion(float f) {
        this.proportion = f;
        return this;
    }

    public SpanUtils setFontSize(@IntRange(from = 0) int i) {
        return setFontSize(i, false);
    }

    public SpanUtils setFontXProportion(float f) {
        this.xProportion = f;
        return this;
    }

    public SpanUtils setForegroundColor(@ColorInt int i) {
        this.foregroundColor = i;
        return this;
    }

    public SpanUtils setHorizontalAlign(@NonNull Layout.Alignment alignment) {
        if (alignment != null) {
            this.alignment = alignment;
            return this;
        }
        throw new NullPointerException("Argument 'alignment' of type Alignment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setItalic() {
        this.isItalic = true;
        return this;
    }

    public SpanUtils setLeadingMargin(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.first = i;
        this.rest = i2;
        return this;
    }

    public SpanUtils setLineHeight(@IntRange(from = 0) int i) {
        return setLineHeight(i, 2);
    }

    public SpanUtils setQuoteColor(@ColorInt int i) {
        return setQuoteColor(i, 2, 2);
    }

    public SpanUtils setShader(@NonNull Shader shader) {
        if (shader != null) {
            this.shader = shader;
            return this;
        }
        throw new NullPointerException("Argument 'shader' of type Shader (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setShadow(@FloatRange(from = 0.0d, fromInclusive = false) float f, float f2, float f3, int i) {
        this.shadowRadius = f;
        this.shadowDx = f2;
        this.shadowDy = f3;
        this.shadowColor = i;
        return this;
    }

    public SpanUtils setSpans(@NonNull Object... objArr) {
        if (objArr != null) {
            if (objArr.length > 0) {
                this.spans = objArr;
            }
            return this;
        }
        throw new NullPointerException("Argument 'spans' of type Object[] (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setStrikethrough() {
        this.isStrikethrough = true;
        return this;
    }

    public SpanUtils setSubscript() {
        this.isSubscript = true;
        return this;
    }

    public SpanUtils setSuperscript() {
        this.isSuperscript = true;
        return this;
    }

    public SpanUtils setTypeface(@NonNull Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
            return this;
        }
        throw new NullPointerException("Argument 'typeface' of type Typeface (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setUnderline() {
        this.isUnderline = true;
        return this;
    }

    public SpanUtils setUrl(@NonNull String str) {
        if (str != null) {
            TextView textView = this.mTextView;
            if (textView != null && textView.getMovementMethod() == null) {
                this.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.url = str;
            return this;
        }
        throw new NullPointerException("Argument 'url' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils setVerticalAlign(int i) {
        this.verticalAlign = i;
        return this;
    }

    public SpanUtils appendSpace(@IntRange(from = 0) int i, @ColorInt int i2) {
        apply(2);
        this.spaceSize = i;
        this.spaceColor = i2;
        return this;
    }

    public SpanUtils setBullet(@ColorInt int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        this.bulletColor = i;
        this.bulletRadius = i2;
        this.bulletGapWidth = i3;
        return this;
    }

    public SpanUtils setFontSize(@IntRange(from = 0) int i, boolean z) {
        this.fontSize = i;
        this.fontSizeIsDp = z;
        return this;
    }

    public SpanUtils setLineHeight(@IntRange(from = 0) int i, int i2) {
        this.lineHeight = i;
        this.alignLine = i2;
        return this;
    }

    public SpanUtils setQuoteColor(@ColorInt int i, @IntRange(from = 1) int i2, @IntRange(from = 0) int i3) {
        this.quoteColor = i;
        this.stripeWidth = i2;
        this.quoteGapWidth = i3;
        return this;
    }

    public SpanUtils() {
        this.mTypeCharSequence = 0;
        this.mTypeImage = 1;
        this.mTypeSpace = 2;
        this.mBuilder = new SerializableSpannableStringBuilder();
        this.mText = "";
        this.mType = -1;
        setDefault();
    }

    public SpanUtils appendImage(@NonNull Bitmap bitmap, int i) {
        if (bitmap != null) {
            apply(1);
            this.imageBitmap = bitmap;
            this.alignImage = i;
            return this;
        }
        throw new NullPointerException("Argument 'bitmap' of type Bitmap (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendLine(@NonNull CharSequence charSequence) {
        if (charSequence != null) {
            apply(0);
            this.mText = ((Object) charSequence) + LINE_SEPARATOR;
            return this;
        }
        throw new NullPointerException("Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    /* loaded from: classes8.dex */
    public static class CustomImageSpan extends CustomDynamicDrawableSpan {
        private Uri mContentUri;
        private Drawable mDrawable;
        private int mResourceId;

        @Override // com.blankj.utilcode.util.SpanUtils.CustomDynamicDrawableSpan
        public Drawable getDrawable() {
            Drawable drawable;
            Drawable drawable2 = this.mDrawable;
            if (drawable2 == null) {
                BitmapDrawable bitmapDrawable = null;
                if (this.mContentUri != null) {
                    try {
                        InputStream openInputStream = Utils.getApp().getContentResolver().openInputStream(this.mContentUri);
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(Utils.getApp().getResources(), BitmapFactory.decodeStream(openInputStream));
                        try {
                            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                            if (openInputStream != null) {
                                openInputStream.close();
                            }
                            return bitmapDrawable2;
                        } catch (Exception e) {
                            e = e;
                            bitmapDrawable = bitmapDrawable2;
                            Log.e("sms", "Failed to loaded content " + this.mContentUri, e);
                            return bitmapDrawable;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    try {
                        drawable = ContextCompat.getDrawable(Utils.getApp(), this.mResourceId);
                        try {
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            return drawable;
                        } catch (Exception unused) {
                            Log.e("sms", "Unable to find resource: " + this.mResourceId);
                            return drawable;
                        }
                    } catch (Exception unused2) {
                        drawable = null;
                    }
                }
            } else {
                return drawable2;
            }
        }

        private CustomImageSpan(Bitmap bitmap, int i) {
            super(i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(Utils.getApp().getResources(), bitmap);
            this.mDrawable = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        private CustomImageSpan(Drawable drawable, int i) {
            super(i);
            this.mDrawable = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        private CustomImageSpan(Uri uri, int i) {
            super(i);
            this.mContentUri = uri;
        }

        private CustomImageSpan(@DrawableRes int i, int i2) {
            super(i2);
            this.mResourceId = i;
        }
    }

    public SpanUtils setClickSpan(@ColorInt final int i, final boolean z, final View.OnClickListener onClickListener) {
        TextView textView = this.mTextView;
        if (textView != null && textView.getMovementMethod() == null) {
            this.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.clickSpan = new ClickableSpan() { // from class: com.blankj.utilcode.util.SpanUtils.1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                if (view != null) {
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("Argument 'widget' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                if (textPaint != null) {
                    textPaint.setColor(i);
                    textPaint.setUnderlineText(z);
                    return;
                }
                throw new NullPointerException("Argument 'paint' of type TextPaint (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        };
        return this;
    }

    public SpanUtils appendImage(@NonNull Drawable drawable) {
        if (drawable != null) {
            return appendImage(drawable, 0);
        }
        throw new NullPointerException("Argument 'drawable' of type Drawable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendImage(@NonNull Drawable drawable, int i) {
        if (drawable != null) {
            apply(1);
            this.imageDrawable = drawable;
            this.alignImage = i;
            return this;
        }
        throw new NullPointerException("Argument 'drawable' of type Drawable (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendImage(@NonNull Uri uri) {
        if (uri != null) {
            return appendImage(uri, 0);
        }
        throw new NullPointerException("Argument 'uri' of type Uri (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendImage(@NonNull Uri uri, int i) {
        if (uri != null) {
            apply(1);
            this.imageUri = uri;
            this.alignImage = i;
            return this;
        }
        throw new NullPointerException("Argument 'uri' of type Uri (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SpanUtils appendImage(@DrawableRes int i) {
        return appendImage(i, 0);
    }

    public SpanUtils appendImage(@DrawableRes int i, int i2) {
        apply(1);
        this.imageResourceId = i;
        this.alignImage = i2;
        return this;
    }
}
