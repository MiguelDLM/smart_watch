package com.baidu.navisdk.pronavi.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.widget.BNImageTextBtn;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RGImageTextBtn extends BNImageTextBtn {

    @OOXIXo
    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f7962a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        @xoIox
        public final RGImageTextBtn a(@OOXIXo Context context, int i, @OOXIXo CharSequence content, int i2, int i3, int i4) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(content, "content");
            RGImageTextBtn rGImageTextBtn = new RGImageTextBtn(context, null, 0, i3, 6, null);
            rGImageTextBtn.f7962a = 0;
            rGImageTextBtn.a(i2);
            rGImageTextBtn.setTextContent(content);
            rGImageTextBtn.setIcon(i);
            rGImageTextBtn.setTextColor(i4);
            return rGImageTextBtn;
        }

        @OOXIXo
        public final Pair<Integer, Integer> b(int i) {
            if (i == 2) {
                Resources resources = JarUtils.getResources();
                int i2 = R.dimen.navi_dimens_28dp;
                return new Pair<>(Integer.valueOf(resources.getDimensionPixelSize(i2)), Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(i2)));
            }
            return new Pair<>(Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_img_width)), Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_img_height)));
        }

        public final float c(int i) {
            int dimensionPixelSize;
            if (i == 2) {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
            } else {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
            }
            return dimensionPixelSize;
        }

        public final int d(int i) {
            if (i == 2) {
                return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_button_text_margin_top);
            }
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_img_txt_padding);
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        @xoIox
        public final RGImageTextBtn a(@OOXIXo Context context, int i, @OOXIXo CharSequence content, int i2, int i3, int i4, int i5, int i6) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(content, "content");
            RGImageTextBtn rGImageTextBtn = new RGImageTextBtn(context, null, 0, i3, 6, null);
            rGImageTextBtn.f7962a = 0;
            rGImageTextBtn.a(i2, i4, i5);
            rGImageTextBtn.setTextContent(content);
            rGImageTextBtn.setIcon(i);
            rGImageTextBtn.setTextColor(i6);
            return rGImageTextBtn;
        }

        @OOXIXo
        @xoIox
        public final RGImageTextBtn a(@OOXIXo Context context, @OOXIXo Drawable iconDrawable, @OOXIXo CharSequence content, int i, int i2, int i3, int i4, int i5) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(iconDrawable, "iconDrawable");
            IIX0o.x0xO0oo(content, "content");
            RGImageTextBtn rGImageTextBtn = new RGImageTextBtn(context, null, 0, i2, 6, null);
            rGImageTextBtn.f7962a = 0;
            rGImageTextBtn.a(i, i3, i4);
            rGImageTextBtn.setTextContent(content);
            rGImageTextBtn.setIconDrawable(iconDrawable);
            rGImageTextBtn.setTextColor(i5);
            return rGImageTextBtn;
        }

        @OOXIXo
        public final Pair<Integer, Integer> a(int i) {
            if (i == 2) {
                int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
                int dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height);
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(a.class.getSimpleName(), "getBntWidthHeight: " + dimensionPixelSize + ':' + dimensionPixelSize2);
                    String simpleName = a.class.getSimpleName();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getBntWidthHeight:");
                    Resources resources = JarUtils.getResources();
                    IIX0o.oO(resources, "JarUtils.getResources()");
                    sb.append(resources.getDisplayMetrics());
                    gVar.e(simpleName, sb.toString());
                }
                return new Pair<>(Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize2));
            }
            return new Pair<>(Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width_new)), Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new)));
        }
    }

    @xoIox
    public RGImageTextBtn(@OOXIXo Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public final void b(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getIcon().getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.width != i || marginLayoutParams.height != i2 || marginLayoutParams.topMargin != i3) {
                marginLayoutParams.width = i;
                marginLayoutParams.height = i2;
                marginLayoutParams.topMargin = i3;
                requestLayout();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.baidu.navisdk.ui.widget.BNImageTextBtn
    public void inflateAndInitView(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        a();
        b.a(context, R.layout.nsdk_layout_rg_image_text_btn, this, true);
        View findViewById = findViewById(R.id.bn_img_txt_btn_icon);
        IIX0o.oO(findViewById, "findViewById(R.id.bn_img_txt_btn_icon)");
        setIcon((ImageView) findViewById);
        View findViewById2 = findViewById(R.id.bn_img_txt_btn_text);
        IIX0o.oO(findViewById2, "findViewById(R.id.bn_img_txt_btn_text)");
        setText((TextView) findViewById2);
    }

    @Override // com.baidu.navisdk.ui.widget.BNImageTextBtn
    public void inflateDone() {
        super.inflateDone();
        b.a(getText(), getTextColorResId());
    }

    public final void setBg(int i) {
        setBgResId(i);
        b.a(this, i);
    }

    @Override // com.baidu.navisdk.ui.widget.BNImageTextBtn
    public void setIcon(int i) {
        b.a(getIcon(), i);
    }

    public final void setIconDrawable(@oOoXoXO Drawable drawable) {
        if (drawable != null) {
            b.a(getIcon());
            getIcon().setImageDrawable(drawable);
        }
    }

    public final void setTextColor(@ColorRes int i) {
        setTextColorResId(i);
        b.a(getText(), i);
    }

    public final void setTextContent(@OOXIXo CharSequence content) {
        IIX0o.x0xO0oo(content, "content");
        getText().setText(content);
    }

    public final void setTextSize(float f) {
        getText().setTextSize(0, f);
    }

    @xoIox
    public RGImageTextBtn(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    private final void a() {
        if (getBgResId() == 0) {
            setBgResId(R.drawable.nsdk_rg_selector_common_control_btn_bg);
        }
        setTextColorResId(R.color.nsdk_cl_text_h);
        b.a(this, getBgResId());
        setVerticalGravity(17);
    }

    public final void setTextContent(int i) {
        getText().setText(i);
    }

    @xoIox
    public RGImageTextBtn(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    public /* synthetic */ RGImageTextBtn(Context context, AttributeSet attributeSet, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? R.drawable.nsdk_rg_selector_common_control_btn_bg : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public RGImageTextBtn(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i, int i2) {
        super(i2, context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f7962a = 1;
    }

    public final void a(int i) {
        Pair<Integer, Integer> a2 = b.a(i);
        a(i, a2.component1().intValue(), a2.component2().intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r6, int r7, int r8) {
        /*
            r5 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L51
            java.lang.Class<com.baidu.navisdk.pronavi.widget.RGImageTextBtn> r1 = com.baidu.navisdk.pronavi.widget.RGImageTextBtn.class
            java.lang.String r2 = r1.getSimpleName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onOrientationChange: "
            r3.append(r4)
            int r4 = r5.f7962a
            r3.append(r4)
            java.lang.String r4 = " -> "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r0.e(r2, r3)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onOrientationChange:"
            r2.append(r3)
            r2.append(r7)
            r3 = 58
            r2.append(r3)
            r2.append(r8)
            r3 = 32
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
        L51:
            int r0 = r5.f7962a
            if (r0 != r6) goto L56
            return
        L56:
            r5.f7962a = r6
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            r1 = 1
            if (r0 != 0) goto L69
            android.view.ViewGroup$MarginLayoutParams r0 = new android.view.ViewGroup$MarginLayoutParams
            r0.<init>(r7, r8)
            r5.setLayoutParams(r0)
        L67:
            r7 = 1
            goto L79
        L69:
            int r2 = r0.width
            if (r2 != r7) goto L74
            int r2 = r0.height
            if (r2 == r8) goto L72
            goto L74
        L72:
            r7 = 0
            goto L79
        L74:
            r0.width = r7
            r0.height = r8
            goto L67
        L79:
            com.baidu.navisdk.pronavi.widget.RGImageTextBtn$a r8 = com.baidu.navisdk.pronavi.widget.RGImageTextBtn.b
            kotlin.Pair r0 = r8.b(r6)
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            android.widget.ImageView r3 = r5.getIcon()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            int r4 = r3.width
            if (r4 == r2) goto La8
            int r4 = r3.height
            if (r4 == r0) goto La8
            r3.width = r2
            r3.height = r0
            r7 = 1
        La8:
            float r0 = r8.c(r6)
            r5.setTextSize(r0)
            android.widget.TextView r0 = r5.getText()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto Lcd
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r6 = r8.d(r6)
            int r8 = r0.topMargin
            if (r8 == r6) goto Lc6
            r0.topMargin = r6
            goto Lc7
        Lc6:
            r1 = r7
        Lc7:
            if (r1 == 0) goto Lcc
            r5.requestLayout()
        Lcc:
            return
        Lcd:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.widget.RGImageTextBtn.a(int, int, int):void");
    }
}
