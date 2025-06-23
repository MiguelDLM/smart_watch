package com.baidu.navisdk.pronavi.ui.bucket.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.ui.widget.BNImageView;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.pronavi.ui.bucket.item.a {

    @DrawableRes
    private int f;

    @DrawableRes
    private int g;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.pronavi.style.c {
        public a(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGBucketItem" + b.this.getId() + HelpFormatter.DEFAULT_OPT_PREFIX + b.this.c;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(b.this.d(), "useDefaultStyle: " + str);
            }
            if (TextUtils.isEmpty(str) || "RGCommonWidget".equals(str)) {
                b.this.x();
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            ImageView w = b.this.w();
            if (w != null) {
                a((View) w);
                b(w);
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        @oOoXoXO
        public String d(@oOoXoXO String str) {
            if ("RGImageView".equals(str)) {
                return b.this.a(str);
            }
            return str;
        }
    }

    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, @DrawableRes int i) {
        this(bVar, dVar, i, R.drawable.nsdk_rg_selector_common_control_btn_bg);
    }

    public String a(String str) {
        return str;
    }

    @NonNull
    public Size d(int i) {
        Resources resources = JarUtils.getResources();
        if (i == 2) {
            return new Size(resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width), resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height));
        }
        return new Size(resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width_new), resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new));
    }

    @NonNull
    public Size e(int i) {
        Resources resources = JarUtils.getResources();
        if (i == 2) {
            int i2 = R.dimen.navi_dimens_34dp;
            return new Size(resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i2));
        }
        int i3 = R.dimen.navi_dimens_38dp;
        return new Size(resources.getDimensionPixelSize(i3), resources.getDimensionPixelSize(i3));
    }

    public void f(@DrawableRes int i) {
        this.g = i;
        BNImageView w = w();
        if (w != null) {
            com.baidu.navisdk.ui.util.b.a((ImageView) w, i);
            w.setPadding();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        BNImageView w = w();
        if (w != null) {
            w.changeSize(d(i), e(i));
        }
    }

    public String[] v() {
        return new String[]{"RGCommonWidget"};
    }

    public BNImageView w() {
        View view = getView();
        if (view instanceof BNImageView) {
            return (BNImageView) view;
        }
        return null;
    }

    public void x() {
        BNImageView w = w();
        if (w != null) {
            com.baidu.navisdk.ui.util.b.a((View) w, this.f);
            com.baidu.navisdk.ui.util.b.a((ImageView) w, this.g);
            w.setPadding();
        }
    }

    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, @DrawableRes int i, @DrawableRes int i2) {
        super(bVar, dVar);
        this.f = i2;
        this.g = i;
        setType(dVar.b);
        setItemLocation(dVar.e);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(ViewGroup viewGroup, int i, Context context) {
        return a(context, i);
    }

    private BNImageView a(Context context, int i) {
        BNImageView bNImageView = new BNImageView(context);
        Size d = d(i);
        bNImageView.setLayoutParams(new ViewGroup.MarginLayoutParams(d.getWidth(), d.getHeight()));
        com.baidu.navisdk.ui.util.b.a((View) bNImageView, this.f);
        com.baidu.navisdk.ui.util.b.a((ImageView) bNImageView, this.g);
        bNImageView.changeSize(d, e(i));
        return bNImageView;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean a(Integer... numArr) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "registerStyleChangeHelper: " + Arrays.toString(numArr));
        }
        if (this.e == null) {
            this.e = new a(numArr);
        }
        f.b.a(this.e, v());
        return true;
    }
}
