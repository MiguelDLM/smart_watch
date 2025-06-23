package com.baidu.ar;

import com.baidu.ar.capture.ICapture;
import com.baidu.ar.cloud.ICloudIR;
import com.baidu.ar.digital.IDigital;
import com.baidu.ar.face.IFace;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.recg.IOnDeviceIR;
import com.baidu.ar.track2d.ITrack2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARProxyManager {
    private HashMap<String, e> u = new HashMap<>();

    private e c(String str) {
        if (!d(str)) {
            return null;
        }
        if (this.u == null) {
            this.u = new HashMap<>();
        }
        e eVar = this.u.get(str);
        if (eVar == null) {
            eVar = e(str);
        }
        if (eVar != null) {
            this.u.put(str, eVar);
        }
        return eVar;
    }

    private e e(String str) {
        if ("com.baidu.ar.face.FaceAR".equals(str)) {
            return new ei();
        }
        if ("com.baidu.ar.track2d.Track2DAR".equals(str)) {
            return new jj();
        }
        if ("com.baidu.ar.track3d.Track3DAR".equals(str)) {
            return new jz();
        }
        if ("com.baidu.ar.cloud.CloudAR".equals(str)) {
            return new cn();
        }
        if ("com.baidu.ar.recg.RecgAR".equals(str)) {
            return new gw();
        }
        if ("com.baidu.ar.capture.FamilyWithChildAR".equals(str)) {
            return new ck();
        }
        if ("com.baidu.ar.vps.marker.MarkerAR".equals(str)) {
            return new fy();
        }
        if ("com.baidu.ar.digital.DigitalAR".equals(str)) {
            return new dl();
        }
        return null;
    }

    public void a(d dVar, String str) {
        e c = c(str);
        if (c != null) {
            c.a(dVar);
        }
    }

    public boolean d(String str) {
        return "com.baidu.ar.face.FaceAR".equals(str) || "com.baidu.ar.track2d.Track2DAR".equals(str) || "com.baidu.ar.track3d.Track3DAR".equals(str) || "com.baidu.ar.cloud.CloudAR".equals(str) || "com.baidu.ar.recg.RecgAR".equals(str) || "com.baidu.ar.vps.marker.MarkerAR".equals(str) || "com.baidu.ar.capture.FamilyWithChildAR".equals(str) || "com.baidu.ar.digital.DigitalAR".equals(str);
    }

    public void f() {
        HashMap<String, e> hashMap = this.u;
        if (hashMap != null) {
            Iterator<e> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().a(null);
            }
        }
    }

    public ICapture getCaptureAR() {
        return (ICapture) c("com.baidu.ar.capture.FamilyWithChildAR");
    }

    public ICloudIR getCloudIRAR() {
        return (ICloudIR) c("com.baidu.ar.cloud.CloudAR");
    }

    public IDigital getDigitalAR() {
        return (IDigital) c("com.baidu.ar.digital.DigitalAR");
    }

    public IFace getFaceAR() {
        return (IFace) c("com.baidu.ar.face.FaceAR");
    }

    public IMarker getMarkerAR() {
        return (IMarker) c("com.baidu.ar.vps.marker.MarkerAR");
    }

    public IOnDeviceIR getOnDeviceIRAR() {
        return (IOnDeviceIR) c("com.baidu.ar.recg.RecgAR");
    }

    public ITrack2D getTrack2DAR() {
        return (ITrack2D) c("com.baidu.ar.track2d.Track2DAR");
    }

    public jx getTrack3DAR() {
        return (jx) c("com.baidu.ar.track3d.Track3DAR");
    }

    public void release() {
        f();
        HashMap<String, e> hashMap = this.u;
        if (hashMap != null) {
            Iterator<Map.Entry<String, e>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().release();
            }
            this.u.clear();
            this.u = null;
        }
    }

    public void f(String str) {
        e eVar;
        HashMap<String, e> hashMap = this.u;
        if (hashMap == null || (eVar = hashMap.get(str)) == null) {
            return;
        }
        eVar.a(null);
    }
}
