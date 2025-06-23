package com.jd.ad.sdk.jad_xk;

import com.jd.ad.sdk.jad_xk.jad_kx;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public class jad_cp extends jad_dq implements Runnable {
    public jad_an jad_cp;

    /* loaded from: classes10.dex */
    public interface jad_an {
    }

    public jad_cp(jad_kx jad_kxVar) {
        super(jad_kxVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.jd.ad.sdk.jad_xk.jad_an jad_anVar = this.jad_bo;
            if (jad_anVar == null) {
                jad_an jad_anVar2 = this.jad_cp;
                if (jad_anVar2 != null) {
                    com.jd.ad.sdk.jad_yl.jad_an jad_anVar3 = com.jd.ad.sdk.jad_yl.jad_an.NET_CONNECTION_IS_NULL_ERROR;
                    ((jad_iv) jad_anVar2).jad_an(jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
                }
                com.jd.ad.sdk.jad_xk.jad_an jad_anVar4 = this.jad_bo;
                if (jad_anVar4 != null) {
                    try {
                        jad_anVar4.jad_an();
                        return;
                    } catch (Exception e) {
                        Logger.w("Exception while async req: ", e.getMessage());
                        return;
                    }
                }
                return;
            }
            jad_ly jad_bo = jad_anVar.jad_bo(this.jad_an);
            if (jad_bo == null) {
                jad_an jad_anVar5 = this.jad_cp;
                if (jad_anVar5 != null) {
                    com.jd.ad.sdk.jad_yl.jad_an jad_anVar6 = com.jd.ad.sdk.jad_yl.jad_an.NET_HTTP_RESPONSE_IS_NULL_ERROR;
                    ((jad_iv) jad_anVar5).jad_an(jad_anVar6.jad_an, jad_anVar6.jad_an(new String[0]));
                }
            } else {
                jad_an jad_anVar7 = this.jad_cp;
                if (jad_anVar7 != null) {
                    jad_kx.jad_an jad_anVar8 = ((jad_iv) jad_anVar7).jad_an.jad_hu;
                    if (jad_anVar8 != null) {
                        jad_anVar8.jad_an(jad_bo);
                    } else {
                        jad_bo.close();
                    }
                }
            }
            com.jd.ad.sdk.jad_xk.jad_an jad_anVar9 = this.jad_bo;
            if (jad_anVar9 != null) {
                try {
                    jad_anVar9.jad_an();
                } catch (Exception e2) {
                    Logger.w("Exception while async req: ", e2.getMessage());
                }
            }
        } catch (Throwable th) {
            try {
                jad_an jad_anVar10 = this.jad_cp;
                if (jad_anVar10 == null) {
                    com.jd.ad.sdk.jad_xk.jad_an jad_anVar11 = this.jad_bo;
                    if (jad_anVar11 != null) {
                        try {
                            jad_anVar11.jad_an();
                            return;
                        } catch (Exception e3) {
                            Logger.w("Exception while async req: ", e3.getMessage());
                            return;
                        }
                    }
                    return;
                }
                com.jd.ad.sdk.jad_yl.jad_an jad_anVar12 = com.jd.ad.sdk.jad_yl.jad_an.NET_HTTP_OTHER_ERROR;
                ((jad_iv) jad_anVar10).jad_an(jad_anVar12.jad_an, jad_anVar12.jad_an(th.getMessage()));
                com.jd.ad.sdk.jad_xk.jad_an jad_anVar13 = this.jad_bo;
                if (jad_anVar13 != null) {
                    try {
                        jad_anVar13.jad_an();
                    } catch (Exception e4) {
                        Logger.w("Exception while async req: ", e4.getMessage());
                    }
                }
            } catch (Throwable th2) {
                com.jd.ad.sdk.jad_xk.jad_an jad_anVar14 = this.jad_bo;
                if (jad_anVar14 != null) {
                    try {
                        jad_anVar14.jad_an();
                    } catch (Exception e5) {
                        Logger.w("Exception while async req: ", e5.getMessage());
                    }
                }
                throw th2;
            }
        }
    }
}
