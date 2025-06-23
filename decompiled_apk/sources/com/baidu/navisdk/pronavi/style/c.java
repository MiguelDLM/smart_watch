package com.baidu.navisdk.pronavi.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.xoIox;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.util.common.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public abstract class c implements com.baidu.navisdk.pronavi.style.i.a {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f7816a;
    private final List<Integer> b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<ConcurrentHashMap<String, HashSet<WeakReference<? super View>>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7817a = new b();

        public b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final ConcurrentHashMap<String, HashSet<WeakReference<? super View>>> invoke() {
            return new ConcurrentHashMap<>(8);
        }
    }

    static {
        new a(null);
    }

    public c(@OOXIXo Integer... scenes) {
        IIX0o.x0xO0oo(scenes, "scenes");
        this.f7816a = XIxXXX0x0.oIX0oI(b.f7817a);
        this.b = new ArrayList();
        for (Integer num : scenes) {
            if (num != null) {
                this.b.add(num);
            }
        }
        c();
    }

    private final ConcurrentHashMap<String, HashSet<WeakReference<? super View>>> f() {
        return (ConcurrentHashMap) this.f7816a.getValue();
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void a(@oOoXoXO String str, @oOoXoXO HashMap<String, ? super d> hashMap) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleHelper", "updateStyle: " + this);
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            if (h(str, hashMap)) {
                if (gVar.d()) {
                    gVar.e("RGEnableChangeStyleHelper", "updateStyleBySelf: true");
                    return;
                }
                return;
            }
            for (Map.Entry<String, HashSet<WeakReference<? super View>>> entry : f().entrySet()) {
                d dVar = hashMap.get(d(entry.getKey()));
                if (dVar != null) {
                    if (dVar instanceof d.C0334d) {
                        a(entry.getValue(), (d.C0334d) dVar);
                    } else if (dVar instanceof d.h) {
                        a(entry.getValue(), (d.h) dVar);
                    } else if (dVar instanceof d.i) {
                        a(entry.getValue(), (d.i) dVar);
                    } else if (dVar instanceof d.a) {
                        a(entry.getValue(), (d.a) dVar);
                    } else if (dVar instanceof d.b) {
                        a(entry.getValue(), (d.b) dVar);
                    } else if (dVar instanceof d.c) {
                        a(entry.getKey(), entry.getValue(), (d.c) dVar);
                    } else if (dVar instanceof d.g) {
                        a(entry.getKey(), entry.getValue(), (d.g) dVar);
                    }
                } else {
                    a(entry.getValue());
                }
            }
            return;
        }
        b(str);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public <V extends View> void b(@OOXIXo String key, @oOoXoXO V v) {
        HashSet<WeakReference<? super View>> hashSet;
        IIX0o.x0xO0oo(key, "key");
        if (TextUtils.isEmpty(key) || v == null || (hashSet = f().get(key)) == null) {
            return;
        }
        Iterator<WeakReference<? super View>> it = hashSet.iterator();
        IIX0o.oO(it, "changeStyleViewList.iterator()");
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null && view.equals(v)) {
                it.remove();
                return;
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    @oOoXoXO
    public String c(@oOoXoXO String str) {
        return str;
    }

    @xoIox
    @ColorRes
    public final int d(@OOXIXo String str, @OOXIXo HashMap<String, ? super d> hashMap) {
        return a(this, str, hashMap, 0, 4, null);
    }

    public boolean e() {
        return true;
    }

    @oOoXoXO
    public final d.i g(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        return (d.i) a(key, styleMap, d.i.class);
    }

    public boolean h(@oOoXoXO String str, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(styleMap, "styleMap");
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void onDestroy() {
        f().clear();
        this.b.clear();
    }

    @OOXIXo
    public String toString() {
        return super.toString() + this.b;
    }

    public <V extends View> void c(@OOXIXo String key, @oOoXoXO V v) {
        IIX0o.x0xO0oo(key, "key");
        a(key, (String) v, 2);
    }

    @oOoXoXO
    public String d(@oOoXoXO String str) {
        return str;
    }

    @DrawableRes
    public final int e(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        d.f fVar = (d.f) a(key, styleMap, d.f.class);
        if (fVar != null) {
            return fVar.a();
        }
        return 0;
    }

    @oOoXoXO
    public final d.a f(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        return (d.a) a(key, styleMap, d.a.class);
    }

    @oOoXoXO
    public final d.e c(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        return (d.e) a(key, styleMap, d.e.class);
    }

    public boolean d(@OOXIXo String key, @oOoXoXO View view) {
        IIX0o.x0xO0oo(key, "key");
        return true;
    }

    private final void c(HashSet<WeakReference<? super View>> hashSet, d.b bVar) {
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof ImageView) {
                    Object obj = weakReference.get();
                    if (!(obj instanceof ImageView)) {
                        obj = null;
                    }
                    ImageView imageView = (ImageView) obj;
                    if (imageView != null) {
                        imageView.setImageAlpha(bVar.a());
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateImageSrcAlpha & view not match: " + weakReference.get() + " : " + bVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    @OOXIXo
    public List<Integer> d() {
        return this.b;
    }

    private final void d(HashSet<WeakReference<? super View>> hashSet, d.b bVar) {
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof View) {
                    Object obj = weakReference.get();
                    if (!(obj instanceof View)) {
                        obj = null;
                    }
                    View view = (View) obj;
                    if (view != null) {
                        view.setAlpha(bVar.a() / 255.0f);
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateViewAlpha & view not match: " + weakReference.get() + " : " + bVar);
                    }
                }
            }
        }
    }

    @oOoXoXO
    public final d.C0334d b(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        return (d.C0334d) a(key, styleMap, d.C0334d.class);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void b(@oOoXoXO ImageView imageView) {
        if (imageView == null) {
            return;
        }
        a("RGImageView", (String) imageView);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void b() {
        for (Map.Entry<String, HashSet<WeakReference<? super View>>> entry : f().entrySet()) {
            a(entry.getValue());
            HashSet<WeakReference<? super View>> value = entry.getValue();
            if (value != null) {
                value.clear();
            }
        }
        f().clear();
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void b(@oOoXoXO View view) {
        a("RGBgAlpha", (String) view);
    }

    private final void b(HashSet<WeakReference<? super View>> hashSet, d.b bVar) {
        Drawable background;
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof View) {
                    Object obj = weakReference.get();
                    if (!(obj instanceof View)) {
                        obj = null;
                    }
                    View view = (View) obj;
                    if (view != null && (background = view.getBackground()) != null) {
                        background.setAlpha(bVar.a());
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateBgAlpha & view not match: " + weakReference.get() + " : " + bVar);
                    }
                }
            }
        }
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet, d.b bVar) {
        int b2 = bVar.b();
        if (b2 == 1) {
            b(hashSet, bVar);
        } else if (b2 == 2) {
            c(hashSet, bVar);
        } else {
            if (b2 != 3) {
                return;
            }
            d(hashSet, bVar);
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public <V extends View> void a(@OOXIXo String key, @oOoXoXO V v) {
        IIX0o.x0xO0oo(key, "key");
        if (TextUtils.isEmpty(key) || v == null) {
            return;
        }
        a(key, (String) v, 1);
    }

    public <V extends View> void a(@OOXIXo String key, @oOoXoXO V v, int i) {
        boolean z;
        IIX0o.x0xO0oo(key, "key");
        if (TextUtils.isEmpty(key) || v == null) {
            return;
        }
        v.setTag(R.id.bnav_rg_view_style_type, Integer.valueOf(i));
        HashSet<WeakReference<? super View>> hashSet = f().get(key);
        if (hashSet == null) {
            HashSet<WeakReference<? super View>> hashSet2 = new HashSet<>(4);
            f().put(key, hashSet2);
            hashSet2.add(new WeakReference<>(v));
            return;
        }
        Iterator<WeakReference<? super View>> it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            View view = it.next().get();
            if (!(view instanceof View)) {
                view = null;
            }
            View view2 = view;
            if (view2 != null) {
                Object tag = view2.getTag(R.id.bnav_rg_view_style_type);
                Integer num = (Integer) (tag instanceof Integer ? tag : null);
                z = true;
                if ((num != null ? num.intValue() : 1) == i && IIX0o.Oxx0IOOO(view2, v)) {
                    break;
                }
            }
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleHelper", "addNeedChangeStyleView: " + key + org.apache.commons.text.oIX0oI.f33048oxoX + i + org.apache.commons.text.oIX0oI.f33048oxoX + v + ", has same view: " + z);
        }
        if (z) {
            return;
        }
        hashSet.add(new WeakReference<>(v));
    }

    @Nullable
    @oOoXoXO
    public final <T extends d> T a(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap, @OOXIXo Class<T> type) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        IIX0o.x0xO0oo(type, "type");
        d dVar = styleMap.get(d(key));
        if (type.isInstance(dVar)) {
            return type.cast(dVar);
        }
        return null;
    }

    public static /* synthetic */ int a(c cVar, String str, HashMap hashMap, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return cVar.a(str, (HashMap<String, ? super d>) hashMap, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColorResId");
    }

    @xoIox
    @ColorRes
    public final int a(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> styleMap, @ColorRes int i) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(styleMap, "styleMap");
        d.e c = c(key, styleMap);
        int a2 = c != null ? c.a() : 0;
        return a2 == 0 ? i : a2;
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void a(@oOoXoXO TextView textView) {
        if (textView == null) {
            return;
        }
        a("RGTextView", (String) textView);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void a(@oOoXoXO View view) {
        if (view == null) {
            return;
        }
        a("RGCommonBgView", (String) view);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void a(@oOoXoXO String str) {
        com.baidu.navisdk.pronavi.style.i.b g = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g == null) {
            b(str);
        } else {
            g.b(str, this);
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.a
    public void a(@oOoXoXO ImageView imageView) {
        a("RGImgTintColor", (String) imageView);
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator<WeakReference<? super View>> it = hashSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference<? super View> next = it.next();
            if (next.get() instanceof View) {
                View view = next.get();
                if (!(view instanceof View)) {
                    view = null;
                }
                View view2 = view;
                if (view2 != null) {
                    if (!z) {
                        Object tag = view2.getTag(R.id.bnav_rg_view_style_type);
                        Integer num = (Integer) (tag instanceof Integer ? tag : null);
                        if (num == null || num.intValue() != 2) {
                            return;
                        } else {
                            z = true;
                        }
                    }
                    if (view2.getAnimation() != null) {
                        view2.getAnimation().cancel();
                        view2.clearAnimation();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final void a(String str, HashSet<WeakReference<? super View>> hashSet, d.c cVar) {
        if (hashSet == null || hashSet.isEmpty() || cVar.a() == null) {
            return;
        }
        Iterator<WeakReference<? super View>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<? super View> next = it.next();
            if (next.get() instanceof View) {
                View view = next.get();
                if (!(view instanceof View)) {
                    view = null;
                }
                View view2 = view;
                if (view2 != null && (view2.getAnimation() == null || !view2.getAnimation().hasStarted() || view2.getAnimation().hasEnded())) {
                    if (view2.getVisibility() == 0 && view2.isShown() && d(str, view2)) {
                        if (view2.getAnimation() != null) {
                            view2.getAnimation().cancel();
                            view2.clearAnimation();
                        }
                        view2.startAnimation(cVar.a());
                    }
                }
            }
        }
    }

    private final void a(String str, HashSet<WeakReference<? super View>> hashSet, d.g gVar) {
        int b2 = gVar.b();
        if (b2 == 1) {
            if (hashSet != null) {
                Iterator<T> it = hashSet.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() instanceof View) {
                        Object obj = weakReference.get();
                        if (!(obj instanceof View)) {
                            obj = null;
                        }
                        View view = (View) obj;
                        if (view != null) {
                            view.setBackgroundDrawable(com.baidu.navisdk.util.common.e.a(view.getBackground(), gVar.a()));
                        }
                    }
                }
                return;
            }
            return;
        }
        if (b2 == 2 && hashSet != null) {
            Iterator<T> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference2 = (WeakReference) it2.next();
                if (weakReference2.get() instanceof ImageView) {
                    Object obj2 = weakReference2.get();
                    if (!(obj2 instanceof ImageView)) {
                        obj2 = null;
                    }
                    ImageView imageView = (ImageView) obj2;
                    if (imageView != null) {
                        imageView.setImageDrawable(com.baidu.navisdk.util.common.e.a(imageView.getDrawable(), gVar.a()));
                    }
                }
            }
        }
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet, d.i iVar) {
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof TextView) {
                    if (e()) {
                        Object obj = weakReference.get();
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                        }
                        com.baidu.navisdk.ui.util.b.a((TextView) obj, iVar.a());
                    } else {
                        Object obj2 = weakReference.get();
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                        }
                        ((TextView) obj2).setTextColor(com.baidu.navisdk.ui.util.b.b(iVar.a()));
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateTextView & view not match: " + weakReference.get() + " : " + iVar);
                    }
                }
            }
        }
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet, d.a aVar) {
        HashMap<String, TextView> textColorViewMap;
        HashMap<String, View> bgViewMap;
        TextView strTextView;
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof com.baidu.navisdk.pronavi.style.view.a) {
                    Object obj = weakReference.get();
                    if (obj != null) {
                        com.baidu.navisdk.pronavi.style.view.a aVar2 = (com.baidu.navisdk.pronavi.style.view.a) obj;
                        if (aVar.f() != 0 && (strTextView = aVar2.getStrTextView()) != null) {
                            strTextView.setText(aVar.f());
                        }
                        boolean e = e();
                        if (aVar.d() != 0 && aVar2.getColorTextView() != null) {
                            if (e) {
                                com.baidu.navisdk.ui.util.b.a(aVar2.getColorTextView(), aVar.d());
                            } else {
                                TextView colorTextView = aVar2.getColorTextView();
                                if (colorTextView != null) {
                                    colorTextView.setTextColor(com.baidu.navisdk.ui.util.b.b(aVar.d()));
                                }
                            }
                        }
                        if (aVar.a() != 0 && aVar2.getBgView() != null) {
                            if (e) {
                                com.baidu.navisdk.ui.util.b.a(aVar2.getBgView(), aVar.a());
                            } else {
                                View bgView = aVar2.getBgView();
                                if (bgView != null) {
                                    bgView.setBackground(com.baidu.navisdk.ui.util.b.f(aVar.a()));
                                }
                            }
                        }
                        HashMap<String, Integer> b2 = aVar.b();
                        if (b2 != null && !b2.isEmpty() && (bgViewMap = aVar2.getBgViewMap()) != null && !bgViewMap.isEmpty()) {
                            if (e) {
                                HashMap<String, Integer> b3 = aVar.b();
                                IIX0o.ooOOo0oXI(b3);
                                for (Map.Entry<String, Integer> entry : b3.entrySet()) {
                                    HashMap<String, View> bgViewMap2 = aVar2.getBgViewMap();
                                    View view = bgViewMap2 != null ? bgViewMap2.get(entry.getKey()) : null;
                                    if (view != null) {
                                        com.baidu.navisdk.ui.util.b.a(view, entry.getValue().intValue());
                                    }
                                }
                            } else {
                                HashMap<String, Integer> b4 = aVar.b();
                                IIX0o.ooOOo0oXI(b4);
                                for (Map.Entry<String, Integer> entry2 : b4.entrySet()) {
                                    HashMap<String, View> bgViewMap3 = aVar2.getBgViewMap();
                                    View view2 = bgViewMap3 != null ? bgViewMap3.get(entry2.getKey()) : null;
                                    if (view2 != null) {
                                        view2.setBackground(com.baidu.navisdk.ui.util.b.f(entry2.getValue().intValue()));
                                    }
                                }
                            }
                        }
                        HashMap<String, Integer> e2 = aVar.e();
                        if (e2 != null && !e2.isEmpty() && (textColorViewMap = aVar2.getTextColorViewMap()) != null && !textColorViewMap.isEmpty()) {
                            if (e) {
                                HashMap<String, Integer> e3 = aVar.e();
                                IIX0o.ooOOo0oXI(e3);
                                for (Map.Entry<String, Integer> entry3 : e3.entrySet()) {
                                    HashMap<String, TextView> textColorViewMap2 = aVar2.getTextColorViewMap();
                                    TextView textView = textColorViewMap2 != null ? textColorViewMap2.get(entry3.getKey()) : null;
                                    if (textView != null) {
                                        com.baidu.navisdk.ui.util.b.a(textView, entry3.getValue().intValue());
                                    }
                                }
                            } else {
                                HashMap<String, Integer> e4 = aVar.e();
                                IIX0o.ooOOo0oXI(e4);
                                for (Map.Entry<String, Integer> entry4 : e4.entrySet()) {
                                    HashMap<String, TextView> textColorViewMap3 = aVar2.getTextColorViewMap();
                                    TextView textView2 = textColorViewMap3 != null ? textColorViewMap3.get(entry4.getKey()) : null;
                                    if (textView2 != null) {
                                        textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(entry4.getValue().intValue()));
                                    }
                                }
                            }
                        }
                        if (aVar.c() != 0 && aVar2.getImageView() != null) {
                            if (e) {
                                com.baidu.navisdk.ui.util.b.a(aVar2.getImageView(), aVar.c());
                            } else {
                                ImageView imageView = aVar2.getImageView();
                                if (imageView != null) {
                                    imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(aVar.c()));
                                }
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.pronavi.style.view.RGItemAllStyleView");
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateItemAllStyle & view not match: " + a() + "- " + weakReference.get() + " : " + aVar);
                    }
                }
            }
        }
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet, d.C0334d c0334d) {
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof View) {
                    if (e()) {
                        Object obj = weakReference.get();
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                        com.baidu.navisdk.ui.util.b.a((View) obj, c0334d.a());
                    } else {
                        Object obj2 = weakReference.get();
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                        ((View) obj2).setBackground(com.baidu.navisdk.ui.util.b.f(c0334d.a()));
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateViewBg & view not match: " + weakReference.get() + " : " + c0334d);
                    }
                }
            }
        }
    }

    private final void a(HashSet<WeakReference<? super View>> hashSet, d.h hVar) {
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() instanceof ImageView) {
                    if (e()) {
                        Object obj = weakReference.get();
                        com.baidu.navisdk.ui.util.b.a((ImageView) (obj instanceof ImageView ? obj : null), hVar.a());
                    } else {
                        Object obj2 = weakReference.get();
                        ImageView imageView = (ImageView) (obj2 instanceof ImageView ? obj2 : null);
                        if (imageView != null) {
                            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(hVar.a()));
                        }
                    }
                } else {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGEnableChangeStyleHelper", "updateImageView & view not match: " + weakReference.get() + " : " + hVar);
                    }
                }
            }
        }
    }
}
