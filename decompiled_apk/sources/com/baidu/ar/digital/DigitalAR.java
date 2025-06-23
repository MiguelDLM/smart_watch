package com.baidu.ar.digital;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.Cdo;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.EasyAudio;
import com.baidu.ar.audio.EasyAudioCallback;
import com.baidu.ar.d;
import com.baidu.ar.dm;
import com.baidu.ar.dn;
import com.baidu.ar.dq;
import com.baidu.ar.dr;
import com.baidu.ar.dumixhuman.dumix.DumixConstance;
import com.baidu.ar.dv;
import com.baidu.ar.dx;
import com.baidu.ar.dy;
import com.baidu.ar.dz;
import com.baidu.ar.ea;
import com.baidu.ar.eb;
import com.baidu.ar.kf;
import com.baidu.ar.kv;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class DigitalAR extends d implements IDigital, dz.a {
    private static final String TAG = "DigitalAR";
    private String ld;
    private IDigitalListener pc;
    private EasyAudio pd;
    private dn pe;
    private dx pf;
    private ScheduledExecutorService pg;
    private boolean pi;
    private dz pj;
    private String pl;
    private String pm;
    private Deque<Cdo> ph = new LinkedList();
    private boolean pk = true;
    private dv pn = new dv() { // from class: com.baidu.ar.digital.DigitalAR.1
        @Override // com.baidu.ar.dv
        public void a(dq dqVar) {
            if (dqVar == null) {
                if (DigitalAR.this.pc != null) {
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.SOCKET_RESPONSE_FAIL, null);
                    return;
                }
                return;
            }
            Cdo cdo = (Cdo) DigitalAR.this.ph.peekLast();
            if (cdo == null) {
                cdo = new Cdo();
                cdo.ac(dqVar.getBody());
                DigitalAR.this.ph.add(cdo);
            } else {
                cdo.ac(dqVar.getBody());
            }
            DigitalAR.this.pe.f(cdo.cV());
            DigitalAR.this.pe.start();
        }

        @Override // com.baidu.ar.dv
        public void ab(String str) {
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(DigitalState.SOCKET_SEND_MESSAGE, str);
            }
        }

        @Override // com.baidu.ar.dv
        public void b(int i, String str) {
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(DigitalState.SOCKET_ERROR, str);
            }
        }

        @Override // com.baidu.ar.dv
        public void u(boolean z) {
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(z ? DigitalState.SOCKET_OPEN : DigitalState.SOCKET_CLOSE, null);
            }
        }

        @Override // com.baidu.ar.dv
        public void a(final dr.a aVar) {
            if (aVar == null) {
                if (DigitalAR.this.pc != null) {
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.SOCKET_RESPONSE_FAIL, null);
                    return;
                }
                return;
            }
            String type = aVar.getType();
            type.hashCode();
            if (!type.equals(DumixConstance.SUBTITLE_TYPE_QUERY)) {
                if (type.equals(DumixConstance.SUBTITLE_TYPE_REPLY) && DigitalAR.this.pc != null) {
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.SUBTITLE_TYPE_REPLY, aVar.getContent());
                    return;
                }
                return;
            }
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(DigitalState.SUBTITLE_TYPE_QUERY, aVar.getContent());
                if (aVar.isCompleted()) {
                    DigitalAR.this.stopRecord();
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.RECORD_STOP, aVar.getContent());
                    kv.postDelayed(new Runnable() { // from class: com.baidu.ar.digital.DigitalAR.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DigitalAR.this.sendChatMessage(aVar.getContent());
                        }
                    }, 50L);
                }
            }
        }

        @Override // com.baidu.ar.dv
        public void a(dr.b bVar) {
            if (bVar == null) {
                if (DigitalAR.this.pc != null) {
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.SOCKET_RESPONSE_FAIL, null);
                }
            } else {
                if (bVar.dd() == null || bVar.dd().dh() == null || bVar.dd().dh().dg() == null) {
                    return;
                }
                dr.b.a dg = bVar.dd().dh().dg();
                if (dg.de() != null) {
                    byte[] decode = ea.decode(dg.de());
                    byte[] j = dy.j(decode);
                    DigitalAR.this.a(bVar, decode, j);
                    DigitalAR.this.ph.add(new Cdo(j, dg.df(), bVar.isLast()));
                }
            }
        }
    };
    private EasyAudioCallback po = new EasyAudioCallback() { // from class: com.baidu.ar.digital.DigitalAR.2
        @Override // com.baidu.ar.audio.EasyAudioCallback
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (DigitalAR.this.pf == null || byteBuffer == null) {
                return;
            }
            DigitalAR.this.pf.h(byteBuffer.array());
        }

        @Override // com.baidu.ar.audio.EasyAudioCallback
        public void onAudioStart(boolean z, AudioParams audioParams) {
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(z ? DigitalState.RECORD_START : DigitalState.RECORD_ERROR, null);
            }
        }

        @Override // com.baidu.ar.audio.EasyAudioCallback
        public void onAudioStop(boolean z) {
            if (DigitalAR.this.pc != null) {
                DigitalAR.this.pc.onDigitalCallback(DigitalState.RECORD_STOP, null);
            }
        }
    };
    private Runnable pp = new Runnable() { // from class: com.baidu.ar.digital.DigitalAR.3
        @Override // java.lang.Runnable
        public void run() {
            Cdo cdo;
            if (DigitalAR.this.pi || DigitalAR.this.pe == null || (cdo = (Cdo) DigitalAR.this.ph.poll()) == null) {
                return;
            }
            if (cdo.cV() != null) {
                DigitalAR.this.playAudio(cdo.cV());
            }
            if (cdo.cX() != null) {
                DigitalAR.this.setBlendShape(cdo.cX());
            }
            if (!TextUtils.isEmpty(cdo.cW())) {
                DigitalAR.this.pc.onDigitalCallback(DigitalState.WIDGET_DATA, cdo.cW());
            }
            if (cdo.isLast()) {
                DigitalAR.this.ph.clear();
                if (DigitalAR.this.pg != null) {
                    DigitalAR.this.pg.shutdown();
                }
                if (DigitalAR.this.pc != null) {
                    DigitalAR.this.pc.onDigitalCallback(DigitalState.AUDIO_PLAYER_FINISH, null);
                }
                DigitalAR.this.interruptReading();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void interruptReading() {
        dn dnVar = this.pe;
        if (dnVar != null) {
            dnVar.stop();
            this.ph.clear();
        }
    }

    private void t(int i) {
        ScheduledExecutorService scheduledExecutorService = this.pg;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.pg = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(this.pp, 0L, i, TimeUnit.MILLISECONDS);
    }

    @Override // com.baidu.ar.digital.IDigital
    public void initDigital(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            try {
                boolean z = true;
                if (hashMap.get("socket_enable") != null && Float.parseFloat(hashMap.get("socket_enable").toString()) <= 0.0f) {
                    z = false;
                }
                this.pk = z;
            } catch (Exception e) {
                Log.e(TAG, "setup params mSocketEnable :  " + e.toString());
            }
            this.pl = hashMap.get("socket_url") == null ? "wss://dusee.baidu.com/digitalhuman-ws" : (String) hashMap.get("socket_url");
            this.ld = hashMap.get("app_id") == null ? "i-kgqiz7g0gv22a" : (String) hashMap.get("app_id");
            this.pm = hashMap.get("app_key") == null ? "2p78v82ihj8cg04edt17" : (String) hashMap.get("app_key");
        }
        if (t() != null) {
            t().setRenderBlendInput(false);
        }
        if (this.pe == null) {
            this.pe = new dm();
        }
        if (this.pf == null && this.pk) {
            dx dxVar = new dx(this.pn);
            this.pf = dxVar;
            dxVar.c(this.pl, this.ld, this.pm);
        }
        if (this.pd == null) {
            this.pd = EasyAudio.getInstance();
        }
        if (this.pj == null) {
            dz m47do = dz.m47do();
            this.pj = m47do;
            m47do.a(this);
        }
        this.pj.dq();
    }

    @Override // com.baidu.ar.d
    public void onCaseCreate(String str) {
        super.onCaseCreate(str);
        kf.ci(TAG + " onCaseCreate casePath: " + str);
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
        kf.ci(TAG + "pause ");
        this.pi = true;
        dn dnVar = this.pe;
        if (dnVar != null) {
            dnVar.pause();
        }
        dx dxVar = this.pf;
        if (dxVar != null) {
            dxVar.pause();
        }
        EasyAudio easyAudio = this.pd;
        if (easyAudio != null) {
            easyAudio.stopAudio(this.po);
        }
        dz dzVar = this.pj;
        if (dzVar != null) {
            dzVar.dr();
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void playAudio(byte[] bArr) {
        dn dnVar = this.pe;
        if (dnVar != null) {
            if (!dnVar.isPlaying()) {
                this.pe.start();
            }
            this.pe.f(bArr);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        super.release();
        kf.ci(TAG + "release ");
        dn dnVar = this.pe;
        if (dnVar != null) {
            dnVar.release();
            this.pe = null;
        }
        dx dxVar = this.pf;
        if (dxVar != null) {
            dxVar.release();
            this.pf = null;
        }
        EasyAudio easyAudio = this.pd;
        if (easyAudio != null) {
            easyAudio.release();
            this.pd = null;
        }
        ScheduledExecutorService scheduledExecutorService = this.pg;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.pg = null;
        }
        dz dzVar = this.pj;
        if (dzVar != null) {
            dzVar.release();
            this.pj = null;
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        super.resume();
        kf.ci(TAG + "resume ");
        this.pi = false;
        dn dnVar = this.pe;
        if (dnVar != null) {
            dnVar.resume();
        }
        dx dxVar = this.pf;
        if (dxVar != null) {
            dxVar.resume();
        }
        dz dzVar = this.pj;
        if (dzVar != null) {
            dzVar.dq();
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void sendChatMessage(String str) {
        dx dxVar = this.pf;
        if (dxVar != null) {
            dxVar.i(str, "TEXT_QUERY");
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void sendReadingMessage(String str) {
        dx dxVar = this.pf;
        if (dxVar != null) {
            dxVar.i(str, "TEXT_RENDER");
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setBlendShape(HashMap<String, Double> hashMap) {
        if (t() != null) {
            t().setBlendShape(hashMap);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setDigitalListener(IDigitalListener iDigitalListener) {
        this.pc = iDigitalListener;
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setSkeletonData(HashMap<String, List<Double>> hashMap) {
        if (t() != null) {
            t().setSkeletonData(hashMap);
        }
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        kf.ci(TAG + "setup params:  " + hashMap);
        super.setup(hashMap);
        initDigital(hashMap);
    }

    @Override // com.baidu.ar.digital.IDigital
    public void startRecord() {
        EasyAudio easyAudio = this.pd;
        if (easyAudio != null) {
            easyAudio.startAudio(new AudioParams(), this.po);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void stop() {
        interruptReading();
    }

    @Override // com.baidu.ar.digital.IDigital
    public void stopRecord() {
        EasyAudio easyAudio = this.pd;
        if (easyAudio != null) {
            easyAudio.stopAudio(this.po);
        }
    }

    @Override // com.baidu.ar.dz.a
    public void updateRender() {
        if (t() != null) {
            t().render(-1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dr.b bVar, byte[] bArr, byte[] bArr2) {
        if (bVar.dc()) {
            eb i = dy.i(bArr);
            IDigitalListener iDigitalListener = this.pc;
            if (iDigitalListener != null) {
                iDigitalListener.onDigitalCallback(DigitalState.SOCKET_FIRST_AUDIO_FRAME, null);
            }
            if (i != null) {
                int u = i.u(bArr2.length);
                this.pe.start();
                t(u);
                if (this.pc != null) {
                    this.pc.onDigitalCallback(DigitalState.AUDIO_PLAYER_START, Integer.valueOf(bVar.getFrameSize() * u));
                }
            }
        }
    }
}
