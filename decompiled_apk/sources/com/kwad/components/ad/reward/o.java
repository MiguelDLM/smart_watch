package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.baidu.platform.comapi.UIMsg;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class o {

    /* loaded from: classes11.dex */
    public static class a {
        private String errorMsg;
        private boolean qt;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = HelpFormatter.DEFAULT_OPT_PREFIX;
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qt = false;
                this.errorMsg = UIMsg.UI_TIP_DATA_ANALYSIS_FAILD;
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qt = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qt;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bP = com.kwad.sdk.core.response.b.a.bP(adInfo);
        com.kwad.sdk.core.e.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bP);
        if (!bh.isNullString(bP)) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.o.1
                private void E(String str) {
                    com.kwad.components.core.o.a.qI().g(adTemplate, 1, str);
                }

                private void gp() {
                    com.kwad.components.core.o.a.qI().g(adTemplate, 0, "success");
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.kwad.sdk.core.network.c doGet = com.kwad.sdk.g.yy().doGet(bP, null);
                        if (doGet == null) {
                            E("Network Error: url invalid");
                            return;
                        }
                        if (doGet.code == 200) {
                            a aVar = new a(doGet.awE);
                            if (aVar.isValid()) {
                                gp();
                                return;
                            } else {
                                E(aVar.errorMsg);
                                return;
                            }
                        }
                        E("Network Error: " + doGet.awE);
                    } catch (Throwable th) {
                        E("Request Error: " + th.getMessage());
                    }
                }
            });
        }
    }
}
