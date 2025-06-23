package com.baidu.ar;

import android.content.Context;
import android.content.IntentFilter;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.lr;
import com.baidu.ar.ly;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.vpas.VpasAR;
import com.facebook.login.widget.ToolTipPopup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class ls implements lr.a, lv, ly.a, w {
    private VpasAR EA;
    private Timer EB;
    private boolean EC;
    private boolean EE;
    private float EF;
    private int EH;
    private float EI;
    private a EK;
    private long EL;
    private boolean EM;
    private long EN;
    private lt EQ;
    private boolean ER;
    private float[] ES;
    private float[] ET;
    private ly Es;
    private boolean Ez;
    private TimerTask fk;
    private Context mContext;
    private float mScale;
    private int ED = 0;
    private float[] EG = new float[12];
    private float EJ = 0.0f;
    private int EO = 0;
    private lr EP = null;

    /* loaded from: classes7.dex */
    public static class a extends Handler {
        WeakReference<ls> EV;

        public a(ls lsVar) {
            this.EV = new WeakReference<>(lsVar);
        }

        public void detach() {
            WeakReference<ls> weakReference = this.EV;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && this.EV.get() != null) {
                this.EV.get().ab(12);
            }
        }
    }

    public ls(Context context, VpasAR vpasAR, ly lyVar, lt ltVar) {
        this.mContext = context;
        this.EA = vpasAR;
        this.Es = lyVar;
        this.EQ = ltVar;
        lyVar.a((ly.a) this);
        if (this.EK == null) {
            this.EK = new a(this);
        }
        this.EQ.cv(ARConfig.getARKey());
        this.Es.setUserID(new kk(context).hg().toString());
        this.Es.a((w) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "vps_toast_gather");
        hashMap.put("event_data", Integer.valueOf(i));
        this.EA.senMsg2Lua(hashMap);
    }

    private void ac(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "vps_cut_back_return");
        hashMap.put("event_data", Integer.valueOf(i));
        this.EA.senMsg2Lua(hashMap);
    }

    private void hW() {
        this.EO = -1;
    }

    private void hX() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "vps_cut_back");
        this.EA.senMsg2Lua(hashMap);
    }

    private void hY() {
        ly lyVar = this.Es;
        if (lyVar != null) {
            lyVar.resetVPSAlgo();
        }
    }

    private void ib() {
        if (this.EM) {
            return;
        }
        if (this.EP == null) {
            lr lrVar = new lr();
            this.EP = lrVar;
            lrVar.a(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this.EP, intentFilter);
        this.EM = true;
    }

    private void ic() {
        lr lrVar;
        if (!this.EM || (lrVar = this.EP) == null) {
            return;
        }
        lrVar.removeAllCallback();
        this.mContext.unregisterReceiver(this.EP);
        this.EP = null;
        this.EM = false;
    }

    private void id() {
        if (this.Ez) {
            this.ED = 0;
            ie();
            this.EF = 0.0f;
            if (this.EB == null) {
                this.EB = new Timer();
            }
            if (this.fk == null) {
                this.fk = new TimerTask() { // from class: com.baidu.ar.ls.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        ls lsVar;
                        int i;
                        ls.a(ls.this);
                        if (ls.this.EC) {
                            Log.e("time", "mTimerTask runner = " + ls.this.ED);
                            if (ls.this.ED == 10 || ls.this.ED == 20 || ls.this.ED == 30) {
                                if (ls.this.EH != 0) {
                                    ls lsVar2 = ls.this;
                                    lsVar2.EI = lsVar2.EF / ls.this.EJ;
                                    if (ls.this.EI > 0.0f) {
                                        ls.this.ab(3);
                                        return;
                                    } else {
                                        lsVar = ls.this;
                                        i = 2;
                                    }
                                }
                                ls.this.ie();
                            }
                            if (ls.this.ED != 40) {
                                return;
                            }
                            lsVar = ls.this;
                            i = 4;
                            lsVar.ab(i);
                            ls.this.EC = false;
                            ls.this.ie();
                        }
                    }
                };
            }
            this.EB.schedule(this.fk, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie() {
        TimerTask timerTask = this.fk;
        if (timerTask != null) {
            timerTask.cancel();
            this.fk = null;
            this.EB.cancel();
            this.EB.purge();
            this.EB = null;
        }
    }

    /* renamed from: if, reason: not valid java name */
    private void m48if() {
        this.Ez = false;
        ia();
        ie();
    }

    @Override // com.baidu.ar.lr.a
    public void aa(int i) {
        if (i == 2) {
            ab(6);
            a aVar = this.EK;
            if (aVar != null) {
                aVar.removeMessages(1);
            }
        }
    }

    public void hV() {
        ly lyVar;
        float[] fArr;
        float[] fArr2;
        if (this.Ez || (lyVar = this.Es) == null) {
            return;
        }
        this.Ez = true;
        if (lyVar.start()) {
            Log.e("VpasController", " algo system create success");
            if (this.Es.addTrackingVPS("")) {
                Log.e("VpasController", " vps create success");
                this.EC = true;
                id();
                hZ();
                if (this.EE || (fArr = this.ES) == null || (fArr2 = this.ET) == null) {
                    return;
                }
                this.EE = true;
                float f = this.mScale;
                Matrixf4x4 matrixf4x4 = new Matrixf4x4();
                Matrix.scaleM(matrixf4x4.getMatrix(), 0, f, f, f);
                Matrixf4x4 matrixf4x42 = new Matrixf4x4();
                matrixf4x42.setMatrix(new float[]{fArr[0], fArr[3], fArr[6], 0.0f, fArr[1], fArr[4], fArr[7], 0.0f, fArr[2], fArr[5], fArr[8], 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                Matrixf4x4 matrixf4x43 = new Matrixf4x4();
                Matrix.translateM(matrixf4x43.getMatrix(), 0, fArr2[0], fArr2[1], fArr2[2]);
                Matrixf4x4 matrixf4x44 = new Matrixf4x4();
                Matrix.multiplyMM(matrixf4x44.getMatrix(), 0, matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
                Matrixf4x4 matrixf4x45 = new Matrixf4x4();
                Matrix.multiplyMM(matrixf4x45.getMatrix(), 0, matrixf4x43.getMatrix(), 0, matrixf4x44.getMatrix(), 0);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("event_name", "vps_get_rts");
                hashMap.put("event_data", matrixf4x45);
                this.EA.senMsg2Lua(hashMap);
            }
        }
    }

    public void hZ() {
        this.Es.hV();
    }

    public void ia() {
        this.Es.m49if();
    }

    public void l(float[] fArr) {
        if (fArr == null || fArr.length < 12) {
            return;
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(new float[]{fArr[0], fArr[3], fArr[6], 0.0f, fArr[1], fArr[4], fArr[7], 0.0f, fArr[2], fArr[5], fArr[8], 0.0f, fArr[9], fArr[10], fArr[11], 1.0f});
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        matrixf4x42.setMatrix(new float[]{0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        com.baidu.ar.arplay.representation.Matrix.multiplyMM(matrixf4x43.getMatrix(), 0, matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        try {
            Class<?> cls = Class.forName("com.baidu.ar.arplay.core.engine3d.ARPCamera");
            ((IARPCamera) cls.getMethod("getDefaultCamera", null).invoke(cls, null)).setViewMatrix(matrixf4x43.getMatrix());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.lv
    public void m(float[] fArr) {
        this.ES = fArr;
    }

    @Override // com.baidu.ar.lv
    public void n(float[] fArr) {
        this.ET = fArr;
    }

    @Override // com.baidu.ar.lv
    public void o(byte[] bArr) {
        a aVar;
        ly lyVar = this.Es;
        if (lyVar != null && bArr != null) {
            lyVar.r(bArr);
        }
        if (((System.currentTimeMillis() - this.EL) / 1000) % 60 > 6 || (aVar = this.EK) == null) {
            return;
        }
        aVar.removeMessages(1);
    }

    public void onLuaMessage(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey("event_name")) {
            if (hashMap.get("event_name").equals("vps_open_algorithm")) {
                hV();
                return;
            }
            if (hashMap.get("event_name").equals("vps_close_algorithm")) {
                m48if();
            } else {
                if (!hashMap.get("event_name").equals("vps_recreate_session") || this.EQ == null || TextUtils.isEmpty(ARConfig.getARKey())) {
                    return;
                }
                this.EQ.cv(ARConfig.getARKey());
            }
        }
    }

    public void onPause() {
        ic();
        this.EN = System.currentTimeMillis();
        hX();
        m48if();
        hW();
    }

    public void onResume() {
        ib();
        hY();
        hZ();
        id();
        if (this.EN <= 0) {
            return;
        }
        ac((Math.abs(System.currentTimeMillis() - this.EN) / 1000) % 60 >= 30 ? 1 : 0);
    }

    @Override // com.baidu.ar.ly.a
    public void p(byte[] bArr) {
        this.EQ.q(bArr);
        this.EL = System.currentTimeMillis();
        a aVar = this.EK;
        if (aVar != null) {
            aVar.sendEmptyMessageDelayed(1, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
    }

    public void release() {
        ly lyVar = this.Es;
        if (lyVar != null) {
            lyVar.releaseVPS();
        }
        a aVar = this.EK;
        if (aVar != null) {
            aVar.detach();
            this.EK = null;
        }
        this.EE = false;
    }

    public static /* synthetic */ int a(ls lsVar) {
        int i = lsVar.ED;
        lsVar.ED = i + 1;
        return i;
    }

    @Override // com.baidu.ar.lv
    public void f(float f) {
        this.mScale = f;
    }

    @Override // com.baidu.ar.w
    public void a(int i, Object obj) {
        if (i != 1) {
            if (i == 2) {
                ab(11);
            }
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (this.EC) {
                this.EJ += 1.0f;
                this.EF += intValue;
            }
        }
    }

    public void a(ma maVar) {
        this.EH = maVar.ih().isTracked() ? 0 : -1;
        int i = this.EO;
        int i2 = this.EH;
        if (i != i2) {
            if (i2 == 0) {
                this.ER = true;
                StatisticApi.onEvent(StatisticConstants.VPS_SDKRECALL_SUCCESS);
                ab(1);
                ie();
            } else if (this.ER) {
                ab(5);
                id();
            }
        }
        this.EO = this.EH;
        l(maVar.ih().ii().getPose());
    }

    @Override // com.baidu.ar.lv
    public void a(boolean z, String str) {
        ly lyVar = this.Es;
        if (lyVar != null) {
            lyVar.setSession(str);
        }
        ab(z ? 13 : 14);
    }
}
