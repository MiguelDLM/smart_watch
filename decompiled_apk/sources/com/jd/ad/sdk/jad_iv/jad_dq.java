package com.jd.ad.sdk.jad_iv;

import android.graphics.Rect;
import android.os.Message;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.jad_iv.jad_er;
import com.jd.ad.sdk.jad_jt.jad_iv;
import com.jd.ad.sdk.jad_ly.jad_bo;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_vi.jad_iv;
import com.jd.ad.sdk.jad_wj.jad_fs;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_dq implements jad_er.jad_an {
    public WeakReference<View> jad_an;
    public jad_er jad_bo;
    public volatile JADExposureListener jad_cp;
    public int jad_dq;
    public final com.jd.ad.sdk.jad_wj.jad_bo jad_er = new com.jd.ad.sdk.jad_wj.jad_bo();
    public WeakReference<String> jad_fs;

    @Override // com.jd.ad.sdk.jad_iv.jad_er.jad_an
    public void jad_an(Message message) {
        com.jd.ad.sdk.jad_wj.jad_bo jad_boVar;
        int i;
        int jad_an;
        com.jd.ad.sdk.jad_wj.jad_bo jad_boVar2;
        int jad_an2;
        int i2;
        int i3 = message.what;
        int i4 = 0;
        if (i3 == 1) {
            View jad_bo = jad_bo();
            if (jad_bo == null) {
                jad_er jad_erVar = this.jad_bo;
                if (jad_erVar != null) {
                    jad_erVar.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo.getVisibility() != 0) {
                jad_er jad_erVar2 = this.jad_bo;
                if (jad_erVar2 != null) {
                    jad_erVar2.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            }
            if (this.jad_cp != null && (jad_boVar = this.jad_er) != null && !jad_boVar.jad_an) {
                Rect rect = new Rect();
                if (jad_bo.getGlobalVisibleRect(rect)) {
                    int width = rect.width();
                    int height = rect.height();
                    i = width;
                    i4 = height;
                } else {
                    i = 0;
                }
                int i5 = this.jad_dq;
                int width2 = jad_bo.getWidth();
                int height2 = jad_bo.getHeight();
                if (i5 == 1) {
                    int screenWidth = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                    int screenHeight = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                    jad_an = jad_iv.jad_an(height2 * width2, screenWidth * screenHeight);
                    i4 = height2;
                    height2 = screenHeight;
                    i = width2;
                    width2 = screenWidth;
                } else {
                    jad_an = jad_iv.jad_an(i4 * i, width2 * height2);
                }
                JADExposureListener jADExposureListener = this.jad_cp;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible_area", jad_an);
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, width2);
                    jSONObject.put("height", height2);
                    jSONObject.put("visible_width", i);
                    jSONObject.put("visible_height", i4);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jADExposureListener.onPreExposure(jSONObject.toString());
                this.jad_er.jad_an = true;
            }
            jad_er jad_erVar3 = this.jad_bo;
            if (jad_erVar3 != null) {
                jad_erVar3.sendEmptyMessage(2);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                View jad_bo2 = jad_bo();
                if (jad_bo2 == null) {
                    jad_er jad_erVar4 = this.jad_bo;
                    if (jad_erVar4 != null) {
                        jad_erVar4.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
                if (jad_bo2.getVisibility() != 0) {
                    jad_er jad_erVar5 = this.jad_bo;
                    if (jad_erVar5 != null) {
                        jad_erVar5.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                if (!jad_an()) {
                    jad_er jad_erVar6 = this.jad_bo;
                    if (jad_erVar6 != null) {
                        jad_erVar6.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    }
                    return;
                }
                jad_er jad_erVar7 = this.jad_bo;
                if (jad_erVar7 != null) {
                    jad_erVar7.sendEmptyMessageDelayed(4, 1000L);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            View jad_bo3 = jad_bo();
            if (jad_bo3 == null) {
                jad_er jad_erVar8 = this.jad_bo;
                if (jad_erVar8 != null) {
                    jad_erVar8.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo3.getVisibility() != 0) {
                jad_er jad_erVar9 = this.jad_bo;
                if (jad_erVar9 != null) {
                    jad_erVar9.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            if (!jad_an()) {
                jad_er jad_erVar10 = this.jad_bo;
                if (jad_erVar10 != null) {
                    jad_erVar10.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            com.jd.ad.sdk.jad_wj.jad_bo jad_boVar3 = this.jad_er;
            if (jad_boVar3 != null && !jad_boVar3.jad_cp) {
                jad_an(false, CommonConstants.ExposureType.EXPOSURE_VALID.getIndex());
            }
            jad_er jad_erVar11 = this.jad_bo;
            if (jad_erVar11 != null) {
                jad_erVar11.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        View jad_bo4 = jad_bo();
        if (jad_bo4 == null) {
            jad_er jad_erVar12 = this.jad_bo;
            if (jad_erVar12 != null) {
                jad_erVar12.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        if (jad_bo4.getVisibility() != 0) {
            jad_er jad_erVar13 = this.jad_bo;
            if (jad_erVar13 != null) {
                jad_erVar13.sendEmptyMessage(1);
                return;
            }
            return;
        }
        if (!jad_cp()) {
            jad_er jad_erVar14 = this.jad_bo;
            if (jad_erVar14 != null) {
                jad_erVar14.sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            return;
        }
        if (this.jad_cp != null && (jad_boVar2 = this.jad_er) != null && !jad_boVar2.jad_bo) {
            Rect rect2 = new Rect();
            jad_bo4.getGlobalVisibleRect(rect2);
            int i6 = this.jad_dq;
            int width3 = rect2.width();
            int height3 = rect2.height();
            int width4 = jad_bo4.getWidth();
            int height4 = jad_bo4.getHeight();
            if (i6 == 1) {
                int screenWidth2 = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                int screenHeight2 = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                jad_an2 = jad_iv.jad_an(height4 * width4, screenWidth2 * screenHeight2);
                height3 = height4;
                height4 = screenHeight2;
                i2 = screenWidth2;
            } else {
                jad_an2 = jad_iv.jad_an(height3 * width3, width4 * height4);
                i2 = width4;
                width4 = width3;
            }
            JADExposureListener jADExposureListener2 = this.jad_cp;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("visible_area", jad_an2);
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i2);
                jSONObject2.put("height", height4);
                jSONObject2.put("visible_width", width4);
                jSONObject2.put("visible_height", height3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jADExposureListener2.onExposure(jSONObject2.toString());
            this.jad_er.jad_bo = true;
        }
        jad_er jad_erVar15 = this.jad_bo;
        if (jad_erVar15 != null) {
            jad_erVar15.sendEmptyMessage(3);
        }
    }

    public final View jad_bo() {
        WeakReference<View> weakReference = this.jad_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean jad_cp() {
        View jad_bo = jad_bo();
        if (jad_bo != null) {
            Rect rect = new Rect();
            boolean globalVisibleRect = jad_bo.getGlobalVisibleRect(rect);
            if (jad_bo.isShown() && globalVisibleRect && rect.width() >= 1 && rect.height() >= 1) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void jad_an(boolean z, int i) {
        int jad_an;
        String[] strArr;
        List<String> list;
        View jad_bo = jad_bo();
        if (this.jad_cp == null || jad_bo == null) {
            return;
        }
        if (jad_an() || z) {
            com.jd.ad.sdk.jad_wj.jad_bo jad_boVar = this.jad_er;
            if (jad_boVar != null) {
                jad_boVar.jad_cp = true;
            }
            JADExposureListener jADExposureListener = this.jad_cp;
            Rect rect = new Rect();
            jad_bo.getGlobalVisibleRect(rect);
            int i2 = this.jad_dq;
            int width = rect.width();
            int height = rect.height();
            int width2 = jad_bo.getWidth();
            int height2 = jad_bo.getHeight();
            if (i2 == 1) {
                int screenWidth = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                int screenHeight = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                jad_an = jad_iv.jad_an(height2 * width2, screenWidth * screenHeight);
                width = width2;
                width2 = screenWidth;
                height = height2;
                height2 = screenHeight;
            } else {
                jad_an = jad_iv.jad_an(height * width, width2 * height2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("visible_area", jad_an);
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, width2);
                jSONObject.put("height", height2);
                jSONObject.put("visible_width", width);
                jSONObject.put("visible_height", height);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jADExposureListener.onDelayExposure(1000L, jSONObject.toString(), i);
            WeakReference<String> weakReference = this.jad_fs;
            if (weakReference != null && weakReference.get() != null) {
                jad_fs jad_cp = jad_bo.jad_an.jad_an.jad_cp(jad_cp.jad_an.jad_an.jad_an(this.jad_fs.get()));
                if (jad_cp != null && (list = jad_cp.jad_jw) != null) {
                    strArr = (String[]) list.toArray(new String[0]);
                } else {
                    strArr = new String[0];
                }
                jad_iv.jad_cp.jad_an.jad_an(strArr);
            } else {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.EXPOSURE_SERVER_REPORT_ERROR;
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            }
            this.jad_cp = null;
            jad_er jad_erVar = this.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                this.jad_bo = null;
            }
        }
    }

    public final boolean jad_an() {
        int jad_an;
        if (this.jad_dq == 1) {
            return jad_cp();
        }
        View jad_bo = jad_bo();
        if (jad_bo != null) {
            Rect rect = new Rect();
            if (jad_bo.getGlobalVisibleRect(rect) && jad_bo.isShown()) {
                int i = this.jad_dq;
                int width = rect.width();
                int height = rect.height();
                int width2 = jad_bo.getWidth();
                int height2 = jad_bo.getHeight();
                if (i == 1) {
                    jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height2 * width2, JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an()) * JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
                    width = width2;
                } else {
                    jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height * width, width2 * height2);
                    height2 = height;
                }
                if (i == 1) {
                    if (width >= 1 && height2 >= 1) {
                        return true;
                    }
                } else if (jad_an >= 50) {
                    return true;
                }
            }
        }
        return false;
    }
}
