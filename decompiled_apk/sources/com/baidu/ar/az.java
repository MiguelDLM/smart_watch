package com.baidu.ar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes7.dex */
public class az {
    private String iO;
    private String iP;
    private String iQ;
    private String iR;

    public az(Context context) {
        this.iO = "default";
        this.iQ = "0";
        this.iR = "0";
        UUID hg = new kk(context).hg();
        if (hg != null) {
            this.iO = hg.toString();
        }
        this.iP = kg.n(context);
        for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
            if (sensor.getType() == 4) {
                this.iQ = "1";
            }
            if (sensor.getType() == 11) {
                this.iR = "1";
            }
        }
    }

    private void bn() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConstants.APP_VERSION, String.valueOf(kg.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put(HttpConstants.OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", this.iO);
        hashMap.put(ARConfigKey.EXTRA_INFO, ARConfig.getARExtraInfo());
        hashMap.put(HttpConstants.HTTP_OS_TYPE, "android");
        hashMap.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        hashMap.put("channel", this.iP);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("userinfo", hashMap);
    }

    private void bo() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.sensor.gyroscope", this.iQ);
        hashMap.put("android.sensor.rotation_vector", this.iR);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("deviceinfo", hashMap);
    }

    public void bm() {
        bn();
        bo();
    }

    public void setDataPipKV(String str, Object obj) {
        ARPScriptEnvironment.getInstance().setDataPipKV(str, obj);
    }
}
