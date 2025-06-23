package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c {
    private final d api;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* loaded from: classes11.dex */
    public static class a {
        private final String aVo;
        private BusinessType aVp;
        private SubBusinessType aVq;
        private d aVr;
        private JSONObject aVs;
        private String aVt;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.aVo = str;
        }

        public static a OZ() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Pa() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Pb() {
            if (com.kwai.adclient.kscommerciallogger.a.OQ().isDebug()) {
                if (!TextUtils.isEmpty(this.aVo) && !TextUtils.isEmpty(this.mTag) && !TextUtils.isEmpty(this.aVt)) {
                    if (com.kwai.adclient.kscommerciallogger.a.OQ().OS() && !com.kwai.adclient.kscommerciallogger.b.ht(this.aVt)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else {
                    throw new IllegalArgumentException("param is error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.aVo) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aVt)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.OQ().OS() && !com.kwai.adclient.kscommerciallogger.b.ht(this.aVt)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.OQ().OR() != null) {
                this.aVs = com.kwai.adclient.kscommerciallogger.a.OQ().OR();
            }
            return new c(this, (byte) 0);
        }

        public final a hu(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a hv(@NonNull String str) {
            this.aVt = str;
            return this;
        }

        public final a b(BusinessType businessType) {
            this.aVp = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aVq = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aVr = dVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String OT() {
        return this.category;
    }

    public final SubBusinessType OU() {
        return this.subBiz;
    }

    public final d OV() {
        return this.api;
    }

    public final JSONObject OW() {
        return this.msg;
    }

    public final JSONObject OX() {
        return this.extraParam;
    }

    public final String OY() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.api;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private c(a aVar) {
        this.category = aVar.aVo;
        this.biz = aVar.aVp;
        this.subBiz = aVar.aVq;
        this.tag = aVar.mTag;
        this.api = aVar.aVr;
        this.extraParam = aVar.aVs;
        this.eventId = aVar.aVt;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }
}
