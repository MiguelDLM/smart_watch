package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class LocalLimitMapOverlay extends InnerOverlay {
    private byte[] extData;
    private boolean isAccShow;
    private boolean isHasClearLayer;
    private float level;
    private List<byte[]> mLimitList;
    private int scene;
    private double x;
    private double y;

    public LocalLimitMapOverlay(AppBaseMap appBaseMap) {
        super(37, appBaseMap);
        this.isAccShow = false;
        this.isHasClearLayer = false;
    }

    private String generateJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ud", "");
            jSONObject.put("level", this.level);
            jSONObject.put("scene", this.scene);
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put("rs_add", 0);
            jSONObject.put("show_force", this.isAccShow ? 1 : 0);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void clear() {
        if (TextUtils.isEmpty(getData()) && this.extData != null) {
            setData("{}");
        }
        this.isHasClearLayer = true;
        super.clear();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getData() {
        byte[] bArr;
        List<byte[]> list = this.mLimitList;
        if ((list != null && list.size() > 0) || ((bArr = this.extData) != null && bArr.length > 0)) {
            return generateJson();
        }
        return "";
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return MapController.LOCAL_LIMIT_MAP_LAYER_TAG;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public Bundle getParam() {
        Bundle bundle = new Bundle();
        if (this.isHasClearLayer) {
            this.mLimitList = null;
            this.extData = null;
        }
        List<byte[]> list = this.mLimitList;
        if (list != null && list.size() > 0) {
            int size = this.mLimitList.size();
            Bundle[] bundleArr = new Bundle[size];
            for (int i = 0; i < size; i++) {
                byte[] bArr = this.mLimitList.get(i);
                this.extData = bArr;
                if (bArr != null && bArr.length > 1) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putByteArray("data", this.extData);
                    bundle2.putInt("len", this.extData.length);
                    bundleArr[i] = bundle2;
                    this.extData = null;
                }
            }
            bundle.putParcelableArray("imge_ext", bundleArr);
            this.mLimitList = null;
        } else {
            byte[] bArr2 = this.extData;
            if (bArr2 != null && bArr2.length > 1) {
                Bundle bundle3 = new Bundle();
                bundle3.putByteArray("data", this.extData);
                bundle3.putInt("len", this.extData.length);
                bundle.putParcelableArray("imge_ext", new Bundle[]{bundle3});
                this.extData = null;
            }
        }
        return bundle;
    }

    public void setIsAccShow(boolean z) {
        this.isAccShow = z;
    }

    public void setLevel(float f) {
        this.level = f;
    }

    public void setLimitList(List<byte[]> list) {
        this.mLimitList = list;
        this.isHasClearLayer = false;
    }

    public void setRouteExtData(byte[] bArr) {
        this.extData = bArr;
        this.isHasClearLayer = false;
    }

    public void setScene(int i) {
        this.scene = i;
    }

    public void setX(double d) {
        this.x = d;
    }

    public void setY(double d) {
        this.y = d;
    }
}
