package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes11.dex */
public class bb {
    private static volatile bb aQT;
    private SensorManager aQU;
    private final Map<String, a> aQV = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> aQW = new ConcurrentHashMap();

    /* loaded from: classes11.dex */
    public static class a implements SensorEventListener {
        private final WeakReference<bb> YG;
        private final String key;

        public a(String str, bb bbVar) {
            this.key = str;
            this.YG = new WeakReference<>(bbVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bb bbVar = this.YG.get();
            if (bbVar != null) {
                bbVar.a(this.key, sensorEvent);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onFailed();
    }

    private bb() {
    }

    private static String A(int i, int i2) {
        return i + "_" + i2;
    }

    @NonNull
    public static bb Nn() {
        if (aQT == null) {
            synchronized (bb.class) {
                try {
                    if (aQT == null) {
                        aQT = new bb();
                    }
                } finally {
                }
            }
        }
        return aQT;
    }

    @Nullable
    private Sensor ef(int i) {
        if (getSensorManager() == null) {
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return getSensorManager().getDefaultSensor(9);
                }
                return getSensorManager().getDefaultSensor(1);
            }
            return getSensorManager().getDefaultSensor(4);
        }
        return getSensorManager().getDefaultSensor(10);
    }

    private static int eg(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    private void gW(String str) {
        a aVar = this.aQV.get(str);
        if (aVar != null) {
            this.aQV.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a gX(String str) {
        a aVar = this.aQV.get(str);
        if (aVar == null) {
            a aVar2 = new a(str, this);
            this.aQV.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private SensorManager getSensorManager() {
        if (this.aQU == null) {
            this.aQU = (SensorManager) ServiceProvider.getContext().getSystemService("sensor");
        }
        return this.aQU;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor ef = ef(i);
        if (ef == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String A = A(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aQW.get(A);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aQW.put(A, copyOnWriteArraySet);
            a(A, i2, ef);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        try {
            for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.aQW.entrySet()) {
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                Iterator<SensorEventListener> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SensorEventListener next = it.next();
                    if (next.equals(sensorEventListener)) {
                        value.remove(next);
                        break;
                    }
                }
                if (value.size() == 0) {
                    gW(entry.getKey());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(String str, int i, Sensor sensor) {
        getSensorManager().registerListener(gX(str), sensor, eg(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aQW.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
