package com.baidu.navcore.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, b> f6467a;
    private ArrayList<String> b;

    private String b(String str) {
        HashMap<String, b> hashMap;
        if (!TextUtils.isEmpty(str) && (hashMap = this.f6467a) != null && !hashMap.isEmpty()) {
            for (String str2 : this.f6467a.keySet()) {
                if (str.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public void a(Context context) {
        this.f6467a = new HashMap<>();
        this.f6467a.put("嘟嘟嘟", new b(context, R.raw.exit_high_speed));
        this.f6467a.put("吁吁吁", new b(context, R.raw.serious_over_speed));
        ArrayList<String> arrayList = new ArrayList<>();
        this.b = arrayList;
        arrayList.add("嘟嘟嘟");
        this.b.add("吁吁吁");
    }

    public String a(String str) {
        String b = b(str);
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        ArrayList<String> arrayList = this.b;
        String substring = (arrayList == null || !arrayList.contains(b)) ? null : str.substring(b.length());
        HashMap<String, b> hashMap = this.f6467a;
        b bVar = hashMap != null ? hashMap.get(b) : null;
        if (bVar != null) {
            bVar.a();
        }
        return substring;
    }

    public void a() {
        HashMap<String, b> hashMap = this.f6467a;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, b>> it = this.f6467a.entrySet().iterator();
        while (it.hasNext()) {
            b value = it.next().getValue();
            if (value != null) {
                value.b();
            }
        }
    }
}
