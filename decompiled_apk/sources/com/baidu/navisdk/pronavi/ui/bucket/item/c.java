package com.baidu.navisdk.pronavi.ui.bucket.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.pronavi.ui.bucket.item.a {

    @DrawableRes
    protected int f;
    protected CharSequence g;

    @DrawableRes
    protected int h;

    @ColorRes
    protected int i;
    protected com.baidu.navisdk.pronavi.style.view.a j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a(view);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.pronavi.style.c {
        public b(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGBucketItem" + c.this.getId() + HelpFormatter.DEFAULT_OPT_PREFIX + c.this.c;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(c.this.d(), "useDefaultStyle: " + str);
            }
            c.this.x();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            c.this.a(this);
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        @Nullable
        public String d(@Nullable String str) {
            return c.this.a(str);
        }
    }

    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, @DrawableRes int i, @StringRes int i2) {
        this(bVar, dVar, i, JarUtils.getResources().getString(i2));
    }

    public String a(String str) {
        return str;
    }

    public void d(@DrawableRes int i) {
        this.f = i;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        this.j = null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        RGImageTextBtn v = v();
        if (v != null) {
            v.a(i);
        }
    }

    @Nullable
    public RGImageTextBtn v() {
        View view = getView();
        if (view instanceof RGImageTextBtn) {
            return (RGImageTextBtn) view;
        }
        return null;
    }

    public String[] w() {
        return new String[]{"RGCommonWidget"};
    }

    public void x() {
        RGImageTextBtn v = v();
        if (v != null) {
            v.setBg(this.h);
            v.setTextColor(this.i);
            v.setIcon(this.f);
        }
    }

    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, @DrawableRes int i, CharSequence charSequence) {
        super(bVar, dVar);
        this.h = R.drawable.nsdk_rg_selector_common_control_btn_bg;
        this.i = R.color.nsdk_cl_text_h;
        this.f = i;
        this.g = charSequence;
        setType(dVar.b);
        setItemLocation(dVar.e);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        return RGImageTextBtn.b.a(context, this.f, this.g, i, this.h, this.i);
    }

    public void a(View view) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGImgTextBucketItem", "onClicked: " + toString());
        }
    }

    public void a(CharSequence charSequence) {
        this.g = charSequence;
    }

    public void a(@DrawableRes int i, int i2) {
        RGImageTextBtn v = v();
        if (v != null) {
            String string = JarUtils.getResources().getString(i2);
            this.g = string;
            this.f = i;
            v.setTextContent(string);
            v.setIcon(i);
        }
    }

    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, @DrawableRes int i, @StringRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this(bVar, dVar, i, JarUtils.getResources().getString(i2));
        this.h = i3;
        this.i = i4;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean a(Integer... numArr) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGImgTextBucketItem", "registerStyleChangeHelper: " + Arrays.toString(numArr));
        }
        if (this.e == null) {
            this.e = new b(numArr);
        }
        f.b.a(this.e, w());
        return true;
    }

    public void a(com.baidu.navisdk.pronavi.style.i.a aVar) {
        RGImageTextBtn v = v();
        if (v == null || aVar == null) {
            return;
        }
        aVar.a(v.text);
        aVar.a(v);
        aVar.b(v.icon);
    }

    public void a(com.baidu.navisdk.pronavi.style.i.a aVar, String str) {
        RGImageTextBtn v = v();
        if (v == null || aVar == null) {
            return;
        }
        if (this.j == null) {
            this.j = new com.baidu.navisdk.pronavi.style.view.a();
        }
        this.j.setBgView(v);
        this.j.setImageView(v.icon);
        this.j.setStrTextView(v.text);
        this.j.setColorTextView(v.text);
        aVar.a(str, (String) this.j);
    }
}
