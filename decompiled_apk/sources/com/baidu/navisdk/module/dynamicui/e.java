package com.baidu.navisdk.module.dynamicui;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.imageloader.config.ImageDiskCacheStrategy;
import com.baidu.navisdk.imageloader.interfaces.ImageLoaderRequestListener;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {
    private static e c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<d>> f7160a = new HashMap();
    private Set<String> b = new HashSet();

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f7161a;
        final /* synthetic */ Map b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Map map, Map map2) {
            super(str);
            this.f7161a = map;
            this.b = map2;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            e.this.b((Map<String, String>) this.f7161a, (Map<String, String>) this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : e.this.f7160a.entrySet()) {
                List list = (List) entry.getValue();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        e.this.a((d) it.next());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ImageLoaderRequestListener<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7163a;

        public c(e eVar, d dVar) {
            this.f7163a = dVar;
        }

        @Override // com.baidu.navisdk.imageloader.interfaces.ImageLoaderRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Drawable drawable, Object obj) {
            this.f7163a.b = true;
            g gVar = g.DYNA_DATA;
            if (gVar.d()) {
                gVar.e("DynamicUIDataPreload", "onResourceReady(), " + this.f7163a);
            }
        }

        @Override // com.baidu.navisdk.imageloader.interfaces.ImageLoaderRequestListener
        public void onFail(Throwable th, Object obj) {
            this.f7163a.b = false;
            g gVar = g.DYNA_DATA;
            if (gVar.c()) {
                gVar.c("DynamicUIDataPreload", "onException(), " + this.f7163a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        String f7164a;
        boolean b = false;

        public d(e eVar, String str) {
            this.f7164a = str;
        }

        public String toString() {
            return "UrlModel{url='" + this.f7164a + "', isDownloaded=" + this.b + '}';
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, String> map, Map<String, String> map2) {
        if (com.baidu.navisdk.framework.a.c().b() == null) {
            g.DYNA_DATA.d("DynamicUIDataPreload", "DynamicUIDataPreload e activity is null");
            return;
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                c(entry.getValue(), entry.getKey());
                this.b.add(entry.getKey());
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                b(entry2.getValue(), entry2.getKey());
                this.b.add(entry2.getKey());
            }
        }
        com.baidu.navisdk.util.worker.lite.a.c(new b("DynamicUIDataPreload"));
    }

    private void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("templates");
            for (int i = 0; i < jSONArray.length(); i++) {
                b(jSONArray.getJSONObject(i), str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static e a() {
        if (c == null) {
            c = new e();
        }
        return c;
    }

    public boolean a(String str) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("DynamicUIDataPreload", "isPreLoaded(), name = " + str + " urlMap = " + this.f7160a + " parsedSet = " + this.b);
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!this.b.contains(str)) {
            return false;
        }
        List<d> list = this.f7160a.get(str);
        if (list == null) {
            return true;
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().b) {
                return false;
            }
        }
        return true;
    }

    private boolean c(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("src");
            if (!TextUtils.isEmpty(optString) && Pattern.matches("https?://.+\\.(jpg|gif|png|webp)", optString)) {
                a(str, optString);
            }
            String optString2 = optJSONObject.optString("bgImg");
            if (!TextUtils.isEmpty(optString2) && Pattern.matches("https?://.+\\.(jpg|gif|png|webp)", optString2)) {
                a(str, optString2);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b(optJSONArray.optJSONObject(i), str);
            }
        }
    }

    public void a(Map<String, String> map, Map<String, String> map2) {
        if (BNSettingManager.getDynaPreload()) {
            com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new a("DynamicUIDataPreload", map, map2), 10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        ImageLoader.with(com.baidu.navisdk.framework.a.c().a()).load(dVar.f7164a).diskCacheStrategy(ImageDiskCacheStrategy.SOURCE).setImageLoaderRequestListener(new c(this, dVar)).preload();
    }

    private void a(JSONArray jSONArray, String str) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.getJSONObject(i), str);
        }
    }

    private void a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String string = jSONObject.getString(keys.next());
                if (!TextUtils.isEmpty(string)) {
                    if (Pattern.matches("https?://.+\\.(jpg|gif|png|webp)", string)) {
                        a(str, string);
                    } else if (c(string)) {
                        a(new JSONObject(string), str);
                    } else if (b(string)) {
                        a(new JSONArray(string), str);
                    }
                }
            }
        }
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str).getJSONArray("cards"), str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void a(String str, String str2) {
        List<d> list = this.f7160a.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d(this, str2));
            this.f7160a.put(str, arrayList);
            return;
        }
        list.add(new d(this, str2));
    }
}
