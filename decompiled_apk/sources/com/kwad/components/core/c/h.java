package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class h implements i, Comparable<h> {
    private final String JB;
    private final String JK;
    private final String JL;
    private final String JM;
    private final long JN;
    private final long createTime;
    private final int ecpm;

    private h(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.JK = str;
        this.JB = str2;
        this.JL = str3;
        this.ecpm = i;
        this.JM = str4;
        this.createTime = j;
        this.JN = j2;
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long nc = (currentTimeMillis / 1000) + eVar.nc();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.ec(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.eg(next), adResultData.getDefaultAdScene().toJson().toString(), currentTimeMillis + size, nc));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    private static synchronized h c(@NonNull Cursor cursor) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (hVar.ni() == ni()) {
            return (int) (hVar.nj() - nj());
        }
        return hVar.ni() - ni();
    }

    public static AdResultData j(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<h> it = list.iterator();
        SceneImpl sceneImpl = null;
        while (it.hasNext()) {
            adResultData = c(it.next());
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        AdResultData adResultData2 = new AdResultData(adResultData, sceneImpl, arrayList);
        adResultData2.setAdSource("cache");
        return adResultData2;
    }

    private String nh() {
        return this.JL;
    }

    private int ni() {
        return this.ecpm;
    }

    private long nj() {
        return this.createTime;
    }

    private String nl() {
        return this.JM;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues nd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.JK);
        contentValues.put("posId", this.JB);
        contentValues.put("adJson", this.JL);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.JM);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.JN));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    public final String ng() {
        return this.JB;
    }

    public final long nk() {
        return this.JN;
    }

    public final String nm() {
        return this.JK;
    }

    @Nullable
    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.nh() != null && hVar.nl() != null) {
            try {
                String nl = hVar.nl();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(nl));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(hVar.nh(), sceneImpl);
                Iterator<AdTemplate> it = createFromResponseJson.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                return null;
            }
        }
        com.kwad.sdk.core.e.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        return arrayList;
    }
}
