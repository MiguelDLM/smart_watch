package com.baidu.navisdk.ugc.eventdetails.model;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.s;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bb;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f8074a;
    public int b;
    public int c;
    public boolean d;
    public long e;
    public String f;
    public String g;
    public ArrayList<a> h;
    public ArrayList<a> i;
    public ArrayList<a> j;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f8075a;
        public long b;
        public String c;
        public String e;
        public boolean f;
        public String g;
        public String[] h;
        public long i;
        public long j;
        public long k;
        public int l;
        public int m;
        public int n;
        public boolean o;
        public b p;
        public int d = 0;
        public boolean q = false;
        public int r = 0;

        public String toString() {
            return "Comment{showTime='" + this.f8075a + "', sourceTime=" + this.b + ", user='" + this.c + "', userLevel=" + this.d + ", picUrl='" + this.e + "', isLocalPic=" + this.f + ", content='" + this.g + "', labels=" + Arrays.toString(this.h) + ", id=" + this.i + ", encryptId=" + this.j + ", groupId=" + this.k + ", useful=" + this.l + ", useless=" + this.m + ", voted=" + this.n + ", videoInfo=" + this.p + '}';
        }
    }

    public boolean a(JSONObject jSONObject, boolean z) {
        ArrayList<a> arrayList;
        ArrayList<a> arrayList2;
        ArrayList<a> arrayList3;
        if (jSONObject == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_EventDetails", "EventCommentsData parseCommentsData dataObject is null");
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.d()) {
            gVar2.e("UgcModule_EventDetails", "EventCommentsData parseCommentsData data:" + jSONObject.toString());
        }
        try {
            this.f8074a = jSONObject.optInt("total_num");
            this.b = jSONObject.optInt("total_page");
            int optInt = jSONObject.optInt("next_page");
            this.c = optInt;
            this.d = optInt == 1;
            this.e = jSONObject.optLong("last_comment_id");
            this.f = jSONObject.optString("top_ids");
            this.g = jSONObject.optString("good_ids");
            ArrayList<a> a2 = a(jSONObject, "good_list", 2);
            if (z && (arrayList3 = this.h) != null) {
                arrayList3.clear();
            }
            if (a2 != null && a2.size() > 0) {
                if (this.h == null) {
                    this.h = new ArrayList<>(2);
                }
                this.h.addAll(a2);
            }
            ArrayList<a> a3 = a(jSONObject, "top_list", 1);
            if (z && (arrayList2 = this.i) != null) {
                arrayList2.clear();
            }
            if (a3 != null && a3.size() > 0) {
                if (this.i == null) {
                    this.i = new ArrayList<>(2);
                }
                this.i.addAll(a3);
            }
            ArrayList<a> a4 = a(jSONObject, "comment_list", 0);
            if (z && (arrayList = this.j) != null) {
                arrayList.clear();
            }
            if (a4 != null && a4.size() > 0) {
                if (this.j == null) {
                    this.j = new ArrayList<>(8);
                }
                this.j.addAll(a4);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar3.c()) {
                gVar3.c("UgcModule_EventDetails", "EventCommentsData " + e.toString());
            }
            return false;
        }
    }

    public String toString() {
        return "EventCommentsData{totalNum=" + this.f8074a + ", totalPage=" + this.b + ", nextPage=" + this.c + ", hasNextPage=" + this.d + ", lastCommentId=" + this.e + ", topIds=" + this.f + ", goodIds" + this.g + ", topList=" + this.i + ", commentList=" + this.j + '}';
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int c;

        /* renamed from: a, reason: collision with root package name */
        public String f8076a = null;
        public String b = null;
        public String d = null;
        public String e = null;

        public void a(b bVar) {
            if (bVar == null) {
                return;
            }
            this.f8076a = bVar.f8076a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.e = bVar.e;
            this.d = bVar.d;
        }

        public void b() {
            if (!TextUtils.isEmpty(this.e)) {
                try {
                    s.a(this.e);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    s.a(this.b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.d)) {
                try {
                    s.a(this.d);
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
            try {
                s.a(this.f8076a);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }

        public String c() {
            if (!TextUtils.isEmpty(this.f8076a) && !TextUtils.isEmpty(this.b)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("video_url", this.f8076a);
                    jSONObject.put("cover_url", this.b);
                    jSONObject.put("duration", this.c);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public boolean d() {
            if (!TextUtils.isEmpty(this.f8076a) && !TextUtils.isEmpty(this.b)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "VideoInfo{videoUrl='" + this.f8076a + "', coverUrl='" + this.b + "', duration=" + this.c + '}';
        }

        public void a() {
            this.f8076a = null;
            this.b = null;
            this.c = 0;
            this.d = null;
            this.e = null;
        }
    }

    private ArrayList<a> a(JSONObject jSONObject, String str, int i) throws JSONException {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONArray jSONArray;
        ArrayList<a> arrayList = null;
        if (jSONObject != null && !TextUtils.isEmpty(str) && (optJSONArray = jSONObject.optJSONArray(str)) != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            arrayList = new ArrayList<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                aVar.q = false;
                aVar.r = i;
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                aVar.f8075a = jSONObject2.getString("show_time");
                aVar.b = jSONObject2.optLong("sourcetime");
                aVar.c = jSONObject2.getString("user");
                aVar.d = jSONObject2.optInt("user_level");
                if (jSONObject2.has("event_pic")) {
                    aVar.e = jSONObject2.getString("event_pic");
                    aVar.f = false;
                }
                aVar.g = jSONObject2.getString("content");
                if (jSONObject2.has(TTDownloadField.TT_LABEL) && (jSONArray = jSONObject2.getJSONArray(TTDownloadField.TT_LABEL)) != null) {
                    aVar.h = new String[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        aVar.h[i3] = jSONArray.getString(i3);
                    }
                }
                aVar.i = jSONObject2.optLong("id");
                aVar.j = jSONObject2.optLong("id_encrypt");
                aVar.k = jSONObject2.optLong("groupid");
                aVar.l = jSONObject2.optInt("useful");
                aVar.m = jSONObject2.optInt("useless");
                int optInt = jSONObject2.optInt("voted");
                aVar.n = optInt;
                aVar.o = optInt == 1;
                if (jSONObject2.has(bb.aO) && (optJSONObject = jSONObject2.optJSONObject(bb.aO)) != null) {
                    b bVar = new b();
                    aVar.p = bVar;
                    bVar.b = optJSONObject.optString("cover_url");
                    aVar.p.f8076a = optJSONObject.optString("video_url");
                    aVar.p.c = optJSONObject.optInt("duration");
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void a() {
        this.f8074a = 0;
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = 0L;
        this.f = null;
        this.g = null;
        ArrayList<a> arrayList = this.h;
        if (arrayList != null) {
            arrayList.clear();
            this.h = null;
        }
        ArrayList<a> arrayList2 = this.i;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.i = null;
        }
        ArrayList<a> arrayList3 = this.j;
        if (arrayList3 != null) {
            arrayList3.clear();
            this.j = null;
        }
    }
}
