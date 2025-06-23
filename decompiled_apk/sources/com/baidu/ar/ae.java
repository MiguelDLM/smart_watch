package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.au;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class ae {
    public static final String TAG = "ae";
    private static ae fS;
    private Timer fj;
    private TimerTask fk;
    private int fb = 0;
    private boolean fc = false;
    private ConcurrentHashMap<String, b> fT = new ConcurrentHashMap<>();
    private aq fV = new aq() { // from class: com.baidu.ar.ae.1
        @Override // com.baidu.ar.aq
        public void a(au.a aVar) {
            ae.this.b((a) null, true);
        }

        @Override // com.baidu.ar.aq
        public void aL() {
            ae.this.a((a) null, true);
        }
    };
    private Map<String, Integer> fU = new Hashtable();

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public static class b {
        String fZ;
        MediaPlayer fu;
        SurfaceTexture ga;
        int gb;
        boolean gc = false;
        ag fv = new ag();
    }

    private ae() {
        at.a(this.fV);
    }

    private MediaPlayer A(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap == null || concurrentHashMap.get(str) == null) {
            return null;
        }
        return this.fT.get(str).fu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aC() {
        if (this.fj == null) {
            this.fj = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.ar.ae.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    b bVar;
                    ag agVar;
                    if (ae.this.fT != null) {
                        for (Map.Entry entry : ae.this.fT.entrySet()) {
                            if (entry != null && (bVar = (b) entry.getValue()) != null && (agVar = bVar.fv) != null && agVar.gn == "playing") {
                                ae.a((b) entry.getValue());
                            }
                        }
                    }
                }
            };
            this.fk = timerTask;
            this.fj.scheduleAtFixedRate(timerTask, 0L, 200L);
        }
    }

    public static synchronized ae aK() {
        ae aeVar;
        synchronized (ae.class) {
            try {
                if (fS == null) {
                    fS = new ae();
                }
                aeVar = fS;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aeVar;
    }

    private static void releaseInstance() {
        fS = null;
    }

    private void z(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap == null || concurrentHashMap.get(str) == null) {
            return;
        }
        this.fT.remove(str);
    }

    public b B(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public int C(String str) {
        b B = B(str);
        if (B != null) {
            return B.gb;
        }
        return 0;
    }

    public SurfaceTexture D(String str) {
        b bVar;
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap == null || (bVar = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return bVar.ga;
    }

    public int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void aB() {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                if (entry != null) {
                    a((a) null, entry.getKey());
                    entry.getValue().ga = null;
                    entry.getValue().fv.gl = "STATUS";
                    entry.getValue().fv.gn = "unstarted";
                    entry.getValue().gc = false;
                    a(entry.getValue());
                    MediaPlayer mediaPlayer = entry.getValue().fu;
                    if (mediaPlayer != null) {
                        try {
                            ar.b(TAG, "releaseMediaPlayer");
                            mediaPlayer.release();
                        } catch (Exception unused) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.fT.clear();
        }
    }

    public void d(aj ajVar, final HashMap<String, Object> hashMap) {
        c(1028, hashMap);
        a(new a() { // from class: com.baidu.ar.ae.3
        }, ajVar.getId());
    }

    public synchronized void release() {
        try {
            Timer timer = this.fj;
            if (timer != null) {
                timer.cancel();
                this.fj.purge();
                this.fj = null;
                TimerTask timerTask = this.fk;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.fk = null;
                }
            }
            at.b(this.fV);
            aB();
            releaseInstance();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(a aVar, String str) {
        b B = B(str);
        if (B != null) {
            ag agVar = B.fv;
            agVar.gl = "STATUS";
            agVar.gn = "unstarted";
            a(B);
        }
        MediaPlayer A = A(str);
        if (A != null) {
            ar.b(TAG, "mMediaPlayer stopPlay");
            aa.a(A);
            z(str);
        }
    }

    public void b(a aVar, String str) {
        if (ARPEngine.getInstance().isPaused()) {
            return;
        }
        MediaPlayer A = A(str);
        b B = B(str);
        if (B == null) {
            return;
        }
        String str2 = B.fv.gn;
        if ((str2 == "paused" || str2 == "prepared") && A != null) {
            ar.b(TAG, "mMediaPlayer start");
            aC();
            A.start();
            ag agVar = B.fv;
            agVar.gl = "STATUS";
            agVar.gn = "playing";
            a(B);
        }
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        try {
            if (this.fT.containsKey(str)) {
                b bVar = this.fT.get(str);
                if (bVar == null) {
                    return;
                }
                MediaPlayer mediaPlayer = bVar.fu;
                if (mediaPlayer != null) {
                    mediaPlayer.reset();
                    bVar.fu.setDataSource(str2);
                    bVar.fu.setLooping(z);
                    bVar.fu.setOnCompletionListener(onCompletionListener);
                    bVar.fu.prepareAsync();
                    bVar.fZ = str2;
                }
            } else {
                final b bVar2 = new b();
                bVar2.fZ = str2;
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                bVar2.fu = mediaPlayer2;
                mediaPlayer2.setDataSource(str2);
                bVar2.gb = i;
                bVar2.ga = new SurfaceTexture(i);
                bVar2.fv.gh = Long.valueOf(str).longValue();
                bVar2.fv.gi = str3;
                bVar2.fu.setSurface(new Surface(bVar2.ga));
                bVar2.fu.setOnCompletionListener(onCompletionListener);
                bVar2.fu.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.ae.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer3, int i2, int i3) {
                        b bVar3 = bVar2;
                        ag agVar = bVar3.fv;
                        agVar.gl = com.baidu.mobads.sdk.internal.cb.l;
                        agVar.gm = i2;
                        ae.a(bVar3);
                        return true;
                    }
                });
                bVar2.fu.setLooping(z);
                bVar2.fu.prepareAsync();
                ar.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
                bVar2.fu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.ae.5
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer3) {
                        String str4 = ae.TAG;
                        ar.b(str4, "mMediaPlayer onPrepared");
                        b bVar3 = bVar2;
                        ag agVar = bVar3.fv;
                        agVar.gl = "STATUS";
                        agVar.gn = "prepared";
                        ae.a(bVar3);
                        if (ARPEngine.getInstance().isEngineCanAccess() && !ARPEngine.getInstance().isPaused()) {
                            ae.this.aC();
                            try {
                                if (bVar2.fu.getDuration() >= 0) {
                                    long duration = bVar2.fu.getDuration();
                                    long j2 = j;
                                    if (duration > j2 && j2 >= 0) {
                                        bVar2.fu.seekTo((int) j2);
                                    }
                                    bVar2.fu.seekTo(0);
                                }
                                ar.b(str4, "mMediaPlayer start");
                                bVar2.fu.start();
                                bVar2.fv.gn = "playing";
                            } catch (Exception e) {
                                e.fillInStackTrace();
                            }
                        }
                    }
                });
                bVar2.fu.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.ae.6
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer3, int i2) {
                        b bVar3 = bVar2;
                        ag agVar = bVar3.fv;
                        agVar.gl = "INFO";
                        agVar.gp = i2;
                        ae.a(bVar3);
                    }
                });
                bVar2.fu.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.ae.7
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer3, int i2, int i3) {
                        String str4;
                        b bVar3 = bVar2;
                        ag agVar = bVar3.fv;
                        agVar.gl = "INFO";
                        if (i2 == 701) {
                            str4 = "buffer_start";
                        } else {
                            if (i2 != 702) {
                                return false;
                            }
                            str4 = "buffer_end";
                        }
                        agVar.go = str4;
                        ae.a(bVar3);
                        return false;
                    }
                });
                ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
                if (concurrentHashMap != null && str != null) {
                    concurrentHashMap.put(str, bVar2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                if (!z || (entry != null && entry.getValue() != null && entry.getValue().gc)) {
                    b(aVar, entry.getKey());
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x003b -> B:21:0x003e). Please report as a decompilation issue!!! */
    private static void b(b bVar) {
        MediaPlayer mediaPlayer;
        if (bVar == null || (mediaPlayer = bVar.fu) == null) {
            return;
        }
        ag agVar = bVar.fv;
        String str = agVar.gn;
        if (str == "playing" || str == "paused") {
            try {
                int duration = mediaPlayer.getDuration();
                agVar.gj = duration;
                if (duration <= 0) {
                    agVar.gq = 0.0f;
                } else {
                    agVar.gq = (bVar.fu.getCurrentPosition() * 1.0f) / agVar.gj;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str == "finished") {
            agVar.gq = 1.0f;
        }
        if (agVar.gq > 1.0f) {
            agVar.gq = 1.0f;
        }
        if (agVar.gq < 0.0f) {
            agVar.gq = 0.0f;
        }
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    public void c(aj ajVar, final HashMap<String, Object> hashMap) {
        c(1026, hashMap);
        ar.b(TAG, "mMediaPlayer resumeVideo");
        b(new a() { // from class: com.baidu.ar.ae.2
        }, ajVar.getId());
    }

    private static void b(ag agVar) {
        if (agVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(agVar.gh));
        hashMap.put("target", agVar.gi);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", agVar.gn);
        hashMap2.put("buffer_status", agVar.go);
        hashMap2.put("duration", String.valueOf(agVar.gj));
        hashMap2.put("buffer_progress", String.valueOf(agVar.gp));
        hashMap2.put("play_progress", String.valueOf((int) (agVar.gq * 100.0f)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, hashMap);
    }

    public void a(a aVar, String str, boolean z) {
        MediaPlayer A = A(str);
        if (A != null) {
            try {
                if (A.isPlaying()) {
                    b B = B(str);
                    if (B != null) {
                        ag agVar = B.fv;
                        agVar.gl = "STATUS";
                        agVar.gn = "paused";
                        B.gc = z;
                        a(B);
                    }
                    ar.b(TAG, "mMediaPlayer pause");
                    A.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.fT;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, b>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                a(aVar, it.next().getKey(), z);
            }
        }
    }

    public void b(aj ajVar, final HashMap<String, Object> hashMap) {
        c(1024, hashMap);
        a(new a() { // from class: com.baidu.ar.ae.11
        }, ajVar.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        b(bVar);
        b(bVar.fv);
        ag agVar = bVar.fv;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf(ARPMessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(agVar.gh));
        hashMap2.put("platform", "android");
        hashMap2.put("type", agVar.gl);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(agVar.gm));
        hashMap3.put("buffer_status", agVar.go);
        hashMap3.put("buffer_progress", Integer.valueOf(agVar.gp));
        hashMap3.put("play_status", agVar.gn);
        hashMap3.put("play_progress", Integer.valueOf((int) (agVar.gq * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    public void a(final aj ajVar, final HashMap<String, Object> hashMap) {
        if (ajVar.aM() > 1) {
            this.fU.put(ajVar.getId(), Integer.valueOf(ajVar.aM()));
        }
        c(1022, hashMap);
        a(new a() { // from class: com.baidu.ar.ae.9
        }, ajVar.getId(), ajVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.ae.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                aj ajVar2;
                ae aeVar;
                int a2;
                if (ae.this.fU == null || (ajVar2 = ajVar) == null) {
                    return;
                }
                b B = ae.this.B(ajVar2.getId());
                if (B != null) {
                    ag agVar = B.fv;
                    agVar.gl = "STATUS";
                    agVar.gn = "finished";
                    ae.a(B);
                    if (ajVar.aO()) {
                        ae.this.a(ajVar, hashMap);
                        return;
                    }
                }
                if (ae.this.fU.size() <= 0 || (a2 = (aeVar = ae.this).a(aeVar.fU, ajVar.getId())) <= 1) {
                    ae.this.c(1030, hashMap);
                    return;
                }
                int i = a2 - 1;
                ae.this.fU.put(ajVar.getId(), Integer.valueOf(i));
                ajVar.f(i);
                ae.this.a(ajVar, hashMap);
            }
        }, ajVar.aP(), ajVar.aM(), ajVar.getTargetName(), ajVar.aN());
    }

    public void a(String str, int i) {
        b bVar = this.fT.get(str);
        if (bVar != null) {
            bVar.ga = new SurfaceTexture(i);
            try {
                bVar.fu.setSurface(new Surface(bVar.ga));
            } catch (Exception unused) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.gb = i;
        }
    }
}
