package com.sma.smartv3.view.text;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes12.dex */
public class FontTextView extends SkinCompatTextView {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final Typeface oIX0oI(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
            Typeface oIX0oI2;
            IIX0o.x0xO0oo(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FontTextView);
            IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
            int integer = obtainStyledAttributes.getInteger(0, 0);
            if (integer != 1) {
                if (integer != 2) {
                    if (integer != 3) {
                        if (integer != 4) {
                            if (integer != 5) {
                                oIX0oI2 = null;
                            } else {
                                oIX0oI2 = OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_REGULAR, context);
                            }
                        } else {
                            oIX0oI2 = OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_MEDIUM, context);
                        }
                    } else {
                        oIX0oI2 = OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_EXTRA_LIGHT, context);
                    }
                } else {
                    oIX0oI2 = OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_BOLD, context);
                }
            } else {
                oIX0oI2 = OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.DIN_COND_BOLD, context);
            }
            obtainStyledAttributes.recycle();
            return oIX0oI2;
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontTextView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontTextView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ FontTextView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontTextView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        setTypeface(Companion.oIX0oI(context, attributeSet));
    }
}
