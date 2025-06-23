package com.baidu.ar.vpas;

import com.baidu.ar.d;
import com.baidu.ar.dc;
import com.baidu.ar.df;
import com.baidu.ar.dk;
import com.baidu.ar.fd;
import com.baidu.ar.fh;
import com.baidu.ar.fi;
import com.baidu.ar.fk;
import com.baidu.ar.ls;
import com.baidu.ar.lt;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.ly;
import com.baidu.ar.lz;
import com.baidu.ar.ma;
import com.baidu.ar.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class VpasAR extends d implements LuaMsgListener {
    private lz Er;
    private ly Es;
    private float[] Et;
    private a Eu;
    private lt Ev;
    private ls Ew;
    private fi sW;
    private df vE;

    /* loaded from: classes7.dex */
    public class a implements v {
        private WeakReference<VpasAR> Ey;

        public a(VpasAR vpasAR) {
            this.Ey = new WeakReference<>(vpasAR);
        }

        @Override // com.baidu.ar.v
        public float[] av() {
            WeakReference<VpasAR> weakReference = this.Ey;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return this.Ey.get().Et;
        }
    }

    private void hE() {
        fk fkVar = new fk();
        fkVar.a(fd.WORLD);
        fkVar.C(0);
        fkVar.y(false);
        fkVar.z(true);
        fkVar.A(true);
        fi fiVar = new fi() { // from class: com.baidu.ar.vpas.VpasAR.2
            @Override // com.baidu.ar.fi
            public void onImuUpdate(fh fhVar) {
                if (VpasAR.this.Es != null) {
                    VpasAR.this.Es.a(fhVar);
                }
                if (fhVar != null) {
                    VpasAR.this.Et = fhVar.dV();
                }
            }
        };
        this.sW = fiVar;
        a(fkVar, fiVar);
    }

    private void hU() {
        hE();
        ls lsVar = this.Ew;
        if (lsVar != null) {
            lsVar.onResume();
        }
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public List<String> getMsgKeyListened() {
        return Arrays.asList("event_name");
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        ls lsVar = this.Ew;
        if (lsVar != null) {
            lsVar.onLuaMessage(hashMap);
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
        ls lsVar = this.Ew;
        if (lsVar != null) {
            lsVar.onPause();
        }
        a(this.sW);
    }

    @Override // com.baidu.ar.d
    public void release() {
        lz lzVar = this.Er;
        if (lzVar != null) {
            lzVar.release();
            a(this.Er);
        }
        super.release();
        ls lsVar = this.Ew;
        if (lsVar != null) {
            lsVar.release();
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        super.resume();
        hU();
    }

    public void senMsg2Lua(HashMap<String, Object> hashMap) {
        super.d(hashMap);
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        a aVar = new a(this);
        this.Eu = aVar;
        this.Es = new ly(this.mInputWidth, this.mInputHeight, aVar);
        this.Er = new lz(this.Es);
        this.Ev = new lt();
        ls lsVar = new ls(getContext(), this, this.Es, this.Ev);
        this.Ew = lsVar;
        this.Ev.a(lsVar, this.Es);
        df dfVar = new df() { // from class: com.baidu.ar.vpas.VpasAR.1
            private int vG = 0;

            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (dcVar == null || !(dcVar instanceof ma)) {
                    return;
                }
                ma maVar = (ma) dcVar;
                if (VpasAR.this.Ew != null) {
                    VpasAR.this.Ew.a(maVar);
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                this.vG = 0;
            }
        };
        this.vE = dfVar;
        a(this.Er, dfVar);
        a((LuaMsgListener) this);
        hU();
    }
}
