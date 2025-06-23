package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import com.baidu.ar.fe;
import com.baidu.ar.fi;
import com.baidu.ar.fj;
import com.baidu.ar.fk;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class IMUController implements fe {
    private static final String TAG = "IMUController";
    private SensorManager sv;
    private HashMap<fi, fj> sw;

    @Override // com.baidu.ar.fe
    public void destroy() {
        HashMap<fi, fj> hashMap = this.sw;
        if (hashMap != null) {
            Iterator<fj> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
            this.sw.clear();
            this.sw = null;
        }
        this.sv = null;
    }

    @Override // com.baidu.ar.fe
    public void setContext(Context context) {
        if (context != null) {
            this.sv = (SensorManager) context.getSystemService("sensor");
        }
    }

    @Override // com.baidu.ar.fe
    public boolean start(fk fkVar, fi fiVar) {
        if (this.sv == null || fkVar == null || fiVar == null) {
            return false;
        }
        if (this.sw == null) {
            this.sw = new HashMap<>();
        }
        fj fjVar = this.sw.get(fiVar);
        if (fjVar == null) {
            fjVar = new fj();
            this.sw.put(fiVar, fjVar);
        }
        return fjVar.a(this.sv, fkVar, fiVar);
    }

    @Override // com.baidu.ar.fe
    public void stop(fi fiVar) {
        HashMap<fi, fj> hashMap;
        fj remove;
        if (fiVar == null || (hashMap = this.sw) == null || (remove = hashMap.remove(fiVar)) == null) {
            return;
        }
        remove.stop();
    }
}
