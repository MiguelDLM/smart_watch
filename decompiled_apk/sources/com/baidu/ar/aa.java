package com.baidu.ar;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public final class aa {
    private static aa fa;
    private static ConcurrentHashMap<String, a> fd;
    private static HandlerThread fe;
    private static b fg;

    /* renamed from: fi, reason: collision with root package name */
    private static Map<String, Integer> f5561fi;
    private static Timer fj;
    private static TimerTask fk;
    private Map<String, Integer> fh;
    private Handler mHandler;
    private static Handler ff = new Handler(Looper.getMainLooper());
    public static final String TAG = aa.class.getSimpleName();
    private static Runnable fl = new Runnable() { // from class: com.baidu.ar.aa.1
        @Override // java.lang.Runnable
        public void run() {
            if (aa.fe != null) {
                aa.fe.quit();
                HandlerThread unused = aa.fe = null;
            }
        }
    };
    private int fb = 0;
    private boolean fc = false;
    private Handler.Callback fm = new Handler.Callback() { // from class: com.baidu.ar.aa.8
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (!ARPEngine.getInstance().isEngineCanAccess()) {
                return false;
            }
            switch (message.what) {
                case 3004:
                    aa.this.a(message);
                    break;
                case 3005:
                    aa.this.b(message);
                    break;
                case 3006:
                    aa.this.c(message);
                    break;
                case 3007:
                    aa.this.e(message);
                    break;
                case 3008:
                    aa.this.f(message);
                    break;
                case 3009:
                    aa.this.d(message);
                    break;
            }
            return false;
        }
    };

    /* loaded from: classes7.dex */
    public static class a {
        MediaPlayer fu;
        ag fv = new ag();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(Exception exc);

        void onResult(boolean z);
    }

    /* loaded from: classes7.dex */
    public class c implements b {
        public c(b bVar) {
            b unused = aa.fg = bVar;
        }

        @Override // com.baidu.ar.aa.b
        public void a(final Exception exc) {
            if (aa.fg == null) {
                return;
            }
            aa.ff.post(new Runnable() { // from class: com.baidu.ar.aa.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (aa.fg != null) {
                        aa.fg.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.ar.aa.b
        public void onResult(final boolean z) {
            if (aa.fg == null) {
                return;
            }
            aa.ff.post(new Runnable() { // from class: com.baidu.ar.aa.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aa.fg != null) {
                        aa.fg.onResult(z);
                    }
                }
            });
        }
    }

    private aa() {
        synchronized (aa.class) {
            try {
                if (fe == null) {
                    HandlerThread handlerThread = new HandlerThread("MediaPlayerThread");
                    fe = handlerThread;
                    handlerThread.start();
                } else {
                    ff.removeCallbacks(fl);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mHandler = new Handler(fe.getLooper(), this.fm);
        this.fh = new Hashtable();
        f5561fi = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static synchronized aa aA() {
        aa aaVar;
        synchronized (aa.class) {
            try {
                if (fa == null) {
                    fa = new aa();
                }
                aaVar = fa;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void aC() {
        synchronized (aa.class) {
            if (fj == null) {
                fj = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.baidu.ar.aa.14
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        a aVar;
                        ag agVar;
                        if (aa.fd != null) {
                            for (Map.Entry entry : aa.fd.entrySet()) {
                                if (entry != null && (aVar = (a) entry.getValue()) != null && (agVar = aVar.fv) != null && agVar.gn == "playing") {
                                    aa.a((a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                fk = timerTask;
                fj.scheduleAtFixedRate(timerTask, 0L, 200L);
            }
        }
    }

    public void aB() {
        this.fm = null;
        Timer timer = fj;
        if (timer != null) {
            timer.cancel();
            fj.purge();
            fj = null;
            fk.cancel();
            fk = null;
        }
        Map<String, Integer> map = f5561fi;
        if (map != null) {
            map.clear();
        }
        ConcurrentHashMap<String, a> concurrentHashMap = fd;
        if (concurrentHashMap != null) {
            try {
                for (a aVar : concurrentHashMap.values()) {
                    ag agVar = aVar.fv;
                    agVar.gl = "STATUS";
                    agVar.gn = "unstarted";
                    a(aVar.fu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ConcurrentHashMap<String, a> concurrentHashMap2 = fd;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
        }
        Map<String, Integer> map2 = this.fh;
        if (map2 != null) {
            map2.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        f5561fi.put(str, 3005);
        a y = y(str);
        if (y != null) {
            try {
                ag agVar = y.fv;
                agVar.gl = "STATUS";
                agVar.gn = "unstarted";
                a(y);
                ar.b(TAG, "mMediaPlayer stopPlay");
                a(y.fu);
                y.fu = null;
                z(str);
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 2) {
            return;
        }
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        f5561fi.put(str, 3009);
        try {
            a y = y(str);
            if (y == null || y.fv.gn == "unstarted") {
                return;
            }
            y.fu.seekTo(0);
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(e);
            }
        }
    }

    public void e(Message message) {
        String str;
        long j;
        if (ARPEngine.getInstance().isPaused()) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 5) {
            return;
        }
        b bVar = (b) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (objArr.length > 6) {
            String str4 = (String) objArr[5];
            j = ((Long) objArr[6]).longValue();
            str = str4;
        } else {
            str = null;
            j = 0;
        }
        f5561fi.put(str2, 3007);
        try {
            a y = y(str2);
            if (y != null && !y.fu.isPlaying()) {
                ag agVar = y.fv;
                if (agVar.gn != "unstarted") {
                    agVar.gl = "STATUS";
                    agVar.gn = "playing";
                    a(y);
                    ar.b(TAG, "MediaPlayer resume");
                    MediaPlayer mediaPlayer = y.fu;
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition());
                    y.fu.start();
                }
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b(bVar, str2, str3, onCompletionListener, intValue, str, j);
        }
    }

    public void f(Message message) {
        b bVar = (b) ((Object[]) message.obj)[0];
        this.fc = false;
        this.fb = 0;
        ConcurrentHashMap<String, a> concurrentHashMap = fd;
        if (concurrentHashMap != null) {
            try {
                for (a aVar : concurrentHashMap.values()) {
                    if (aVar != null) {
                        aVar.fu.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fd.clear();
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public a y(String str) {
        if (fd == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return fd.get(str);
    }

    public void z(String str) {
        if (fd == null || TextUtils.isEmpty(str) || !fd.containsKey(str)) {
            return;
        }
        fd.remove(str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x003b -> B:21:0x003e). Please report as a decompilation issue!!! */
    private static void b(a aVar) {
        MediaPlayer mediaPlayer;
        if (aVar == null || (mediaPlayer = aVar.fu) == null) {
            return;
        }
        ag agVar = aVar.fv;
        String str = agVar.gn;
        if (str == "playing" || str == "paused") {
            try {
                int duration = mediaPlayer.getDuration();
                agVar.gj = duration;
                if (duration <= 0) {
                    agVar.gq = 0.0f;
                } else {
                    agVar.gq = (aVar.fu.getCurrentPosition() * 1.0f) / agVar.gj;
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

    public void c(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        f5561fi.put(str, 3006);
        try {
            a y = y(str);
            MediaPlayer mediaPlayer = y.fu;
            if (mediaPlayer != null && y.fv.gn != "unstarted" && mediaPlayer.isPlaying()) {
                ag agVar = y.fv;
                agVar.gl = "STATUS";
                agVar.gn = "paused";
                a(y);
                ar.b(TAG, "mMediaPlayer pause");
                y.fu.pause();
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(e);
            }
        }
    }

    public void d(af afVar, final HashMap<String, Object> hashMap) {
        c(1008, hashMap);
        b(new b() { // from class: com.baidu.ar.aa.6
            @Override // com.baidu.ar.aa.b
            public void a(Exception exc) {
                aa.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.aa.b
            public void onResult(boolean z) {
            }
        }, afVar.getId());
    }

    public void e(af afVar, final HashMap<String, Object> hashMap) {
        c(1013, hashMap);
        c(new b() { // from class: com.baidu.ar.aa.7
            @Override // com.baidu.ar.aa.b
            public void a(Exception exc) {
                aa.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.aa.b
            public void onResult(boolean z) {
            }
        }, afVar.getId());
    }

    private a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        ar.b(TAG, "initMediaPlayerInMsg start()");
        try {
            final a aVar = new a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            aVar.fu = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.aa.9
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                        ar.b(aa.TAG, "initMediaPlayerInMsg onCompletion()");
                        if (mediaPlayer2 != null) {
                            mediaPlayer2.release();
                        }
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.aa.10
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                        ar.b(aa.TAG, "onError: " + i);
                        a aVar2 = aVar;
                        ag agVar = aVar2.fv;
                        agVar.gl = com.baidu.mobads.sdk.internal.cb.l;
                        agVar.gm = i;
                        aa.a(aVar2);
                        aa.this.b(new b() { // from class: com.baidu.ar.aa.10.1
                            @Override // com.baidu.ar.aa.b
                            public void a(Exception exc) {
                                aa.this.c(1010, (HashMap<String, Object>) null);
                            }

                            @Override // com.baidu.ar.aa.b
                            public void onResult(boolean z) {
                            }
                        }, aVar.fv.gk);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3005);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public static a a(final a aVar, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((TextUtils.isEmpty(str2) && assetFileDescriptor == null) || aVar == null) {
            return aVar;
        }
        aVar.fv.gh = as.a((Object) str, 0L);
        ag agVar = aVar.fv;
        agVar.gk = str;
        agVar.gi = str3;
        MediaPlayer mediaPlayer = aVar.fu;
        if (onCompletionListener != null) {
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        }
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.seekTo(0);
                mediaPlayer.stop();
            }
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.reset();
            if (!TextUtils.isEmpty(str2)) {
                mediaPlayer.setDataSource(str2);
            } else if (assetFileDescriptor != null) {
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            mediaPlayer.prepareAsync();
            mediaPlayer.setLooping(false);
            ar.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.aa.11
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    String str4 = aa.TAG;
                    ar.b(str4, "mMediaPlayer onPrepared");
                    a aVar2 = a.this;
                    ag agVar2 = aVar2.fv;
                    agVar2.gl = "STATUS";
                    agVar2.gn = "prepared";
                    aa.a(aVar2);
                    if (ARPEngine.getInstance().isPaused() || aa.f5561fi == null || aa.f5561fi.get(str) == null) {
                        return;
                    }
                    if (((Integer) aa.f5561fi.get(str)).intValue() == 3004 || ((Integer) aa.f5561fi.get(str)).intValue() == 3007) {
                        aa.aC();
                        try {
                            if (a.this.fu.getDuration() >= 0) {
                                long duration = a.this.fu.getDuration();
                                long j2 = j;
                                if (duration > j2 && j2 >= 0) {
                                    a.this.fu.seekTo((int) j2);
                                }
                                a.this.fu.seekTo(0);
                            }
                            ar.b(str4, "mMediaPlayer start");
                            a.this.fu.start();
                            a.this.fv.gn = "playing";
                        } catch (Exception e) {
                            aa.a(a.this.fu);
                            e.printStackTrace();
                        }
                    }
                }
            });
            aVar.fu.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.aa.12
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                    a aVar2 = a.this;
                    ag agVar2 = aVar2.fv;
                    agVar2.gl = "INFO";
                    agVar2.gp = i2;
                    aa.a(aVar2);
                }
            });
            aVar.fu.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.aa.13
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                    String str4;
                    a aVar2 = a.this;
                    ag agVar2 = aVar2.fv;
                    agVar2.gl = "INFO";
                    if (i2 == 701) {
                        str4 = "buffer_start";
                    } else {
                        if (i2 != 702) {
                            return false;
                        }
                        str4 = "buffer_end";
                    }
                    agVar2.go = str4;
                    aa.a(aVar2);
                    return false;
                }
            });
        } catch (IOException e) {
            e = e;
            e.printStackTrace();
            return aVar;
        } catch (IllegalArgumentException e2) {
            e = e2;
            e.printStackTrace();
            return aVar;
        } catch (IllegalStateException e3) {
            e = e3;
            e.printStackTrace();
            return aVar;
        } catch (SecurityException e4) {
            e = e4;
            e.printStackTrace();
            return aVar;
        }
        return aVar;
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        a y = y(str);
        z(str);
        if (y != null) {
            try {
                MediaPlayer mediaPlayer = y.fu;
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
        }
        try {
            a a2 = a(str, onCompletionListener, null);
            if (a2 != null) {
                a(a2, str, str2, null, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (bVar != null) {
                bVar.a(e2);
            }
        }
    }

    public void c(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3009);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = fd;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            return fd.get(str);
        }
        a a2 = a(onCompletionListener, onErrorListener);
        if (a2 == null) {
            return null;
        }
        if (fd == null) {
            fd = new ConcurrentHashMap<>();
        }
        fd.put(str, a2);
        return a2;
    }

    public void b(af afVar, final HashMap<String, Object> hashMap) {
        c(1004, hashMap);
        a(new b() { // from class: com.baidu.ar.aa.3
            @Override // com.baidu.ar.aa.b
            public void a(Exception exc) {
                aa.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.aa.b
            public void onResult(boolean z) {
            }
        }, afVar.getId());
    }

    public void c(final af afVar, final HashMap<String, Object> hashMap) {
        c(1006, hashMap);
        a(new b() { // from class: com.baidu.ar.aa.4
            @Override // com.baidu.ar.aa.b
            public void a(Exception exc) {
                aa.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.aa.b
            public void onResult(boolean z) {
            }
        }, afVar.getId(), afVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.aa.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                int a2;
                if (aa.this.fh == null) {
                    return;
                }
                a y = aa.this.y(afVar.getId());
                if (y != null) {
                    ag agVar = y.fv;
                    agVar.gl = "STATUS";
                    agVar.gn = "finished";
                    aa.a(y);
                    if (afVar.aO()) {
                        aa.this.a(afVar, hashMap);
                        return;
                    }
                }
                if (aa.this.fh.size() <= 0 || (a2 = aa.a((Map<String, Integer>) aa.this.fh, afVar.getId())) <= 1) {
                    aa.this.c(1009, hashMap);
                    return;
                }
                aa.this.a(afVar, hashMap);
                int i = a2 - 1;
                aa.this.fh.put(afVar.getId(), Integer.valueOf(i));
                afVar.f(i);
            }
        }, afVar.aM());
    }

    public static void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        String str3 = (String) objArr[5];
        long longValue = ((Long) objArr[6]).longValue();
        f5561fi.put(str, 3004);
        a(bVar, str, str2, null, onCompletionListener, null, intValue, str3, longValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        b(aVar);
        a(aVar.fv);
        ag agVar = aVar.fv;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf(ARPMessageType.MSG_TYPE_AUDIO));
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

    public void a(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3006);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        try {
            a a2 = a(str, onCompletionListener, onErrorListener);
            if (a2 != null) {
                a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            a y = y(str);
            z(str);
            try {
                MediaPlayer mediaPlayer = y.fu;
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                try {
                    a a3 = aA().a(str, onCompletionListener, onErrorListener);
                    if (a3 != null) {
                        a(a3, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                    }
                    if (bVar != null) {
                        bVar.onResult(true);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e2);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (bVar != null) {
                    bVar.a(e3);
                }
            }
        }
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(3007);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i)};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(3004);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)};
        obtainMessage.sendToTarget();
    }

    public void a(final af afVar, final HashMap<String, Object> hashMap) {
        if (afVar.aM() > 1) {
            this.fh.put(afVar.getId(), Integer.valueOf(afVar.aM()));
        }
        c(1002, hashMap);
        a(new b() { // from class: com.baidu.ar.aa.15
            @Override // com.baidu.ar.aa.b
            public void a(Exception exc) {
                aa.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.aa.b
            public void onResult(boolean z) {
            }
        }, afVar.getId(), afVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.aa.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                int a2;
                String str = aa.TAG;
                ar.b(str, "openAudio mMediaPlayer onCompletion");
                if (aa.this.fh == null) {
                    return;
                }
                a y = aa.this.y(afVar.getId());
                if (y == null || y.fv.gn != "paused") {
                    if (y != null) {
                        ag agVar = y.fv;
                        agVar.gl = "STATUS";
                        agVar.gn = "finished";
                        aa.a(y);
                        if (afVar.aO()) {
                            ar.b(str, "openAudio mMediaPlayer onCompletion  isLoopForever open！");
                            aa.this.a(afVar, hashMap);
                            return;
                        }
                    }
                    if (aa.this.fh.size() <= 0 || (a2 = aa.a((Map<String, Integer>) aa.this.fh, afVar.getId())) <= 1) {
                        aa.this.c(1009, hashMap);
                        mediaPlayer.release();
                        return;
                    }
                    ar.b(str, "openAudio mMediaPlayer onCompletion  count open ！");
                    aa.this.a(afVar, hashMap);
                    int i = a2 - 1;
                    aa.this.fh.put(afVar.getId(), Integer.valueOf(i));
                    afVar.f(i);
                }
            }
        }, afVar.aM(), afVar.getTargetName(), afVar.aN());
    }

    private static void a(ag agVar) {
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
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }
}
