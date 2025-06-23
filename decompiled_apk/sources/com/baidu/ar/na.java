package com.baidu.ar;

import com.baidu.ar.marker.model.LocationMarkerData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class na extends mi implements nb {
    public boolean Fs;
    public boolean Fu;
    public float Fw;
    private int GV;
    private int GW;
    public List<mz> GX;
    public double GY;
    public boolean GZ;

    public na(String str, int i) {
        super(str, i);
        this.GV = 16;
        this.GW = 12;
    }

    @Override // com.baidu.ar.nb
    public void B(float[] fArr) {
        this.FB = fArr;
        this.Fx = true;
        mr mrVar = this.FD;
        if (mrVar != null) {
            mrVar.a(this);
        }
    }

    @Override // com.baidu.ar.nb
    public void C(float[] fArr) {
        this.FF = fArr;
        this.GZ = true;
    }

    @Override // com.baidu.ar.nb
    public void a(String str, double d) {
        this.GY = d;
        this.Fw = 0.0f;
        this.Fu = true;
    }

    public void b(mr mrVar) {
        this.FD = mrVar;
    }

    @Override // com.baidu.ar.nb
    public void a(String str, mj mjVar) {
    }

    @Override // com.baidu.ar.nb
    public void a(boolean z, String str, List<LocationMarkerData> list) {
        this.Fs = z;
        if (z) {
            this.GX = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                LocationMarkerData locationMarkerData = list.get(i);
                mz mzVar = new mz();
                mzVar.floorId = locationMarkerData.floorId;
                mzVar.mapTag = locationMarkerData.mapTag;
                mzVar.buildingId = locationMarkerData.buildingId;
                mj mjVar = new mj();
                double[] dArr = locationMarkerData.locationPoints;
                mjVar.FG = (float) dArr[0];
                mjVar.FH = (float) dArr[1];
                this.GX.add(mzVar);
            }
        }
    }
}
