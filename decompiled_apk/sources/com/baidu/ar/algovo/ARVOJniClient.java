package com.baidu.ar.algovo;

import com.baidu.ar.algo.ARAlgoJniClient;
import com.baidu.ar.algo.FrameType;
import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.slam.TrackParams;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ARVOJniClient {
    private static List<String> sModelIds;
    private static int sTrackerId;

    public static int calModelPosition(float[] fArr, float f, float[] fArr2, float[] fArr3) {
        return ARAlgoJniClient.calModelPosition(fArr, f, fArr2, fArr3);
    }

    public static synchronized ArrayList<TrackModel> fetchModelPose() {
        ArrayList<TrackModel> arrayList;
        synchronized (ARVOJniClient.class) {
            arrayList = new ArrayList<>();
            List<String> list = sModelIds;
            if (list != null) {
                for (String str : list) {
                    float[] fArr = new float[16];
                    if (ARAlgoJniClient.getAlgoInstance().getModelPose(sTrackerId, str, fArr) == 0) {
                        TrackModel trackModel = new TrackModel();
                        trackModel.setId(str);
                        trackModel.setPose(fArr);
                        arrayList.add(trackModel);
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized int insertModel(String str, int i, int i2, float[] fArr, float f) {
        int insertModel;
        synchronized (ARVOJniClient.class) {
            try {
                insertModel = ARAlgoJniClient.getAlgoInstance().insertModel(sTrackerId, i, i2, str, f, fArr);
                if (insertModel == 0) {
                    if (sModelIds == null) {
                        sModelIds = new ArrayList();
                    }
                    sModelIds.add(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return insertModel;
    }

    public static synchronized int removeAllModel() {
        int removeAllModels;
        List<String> list;
        synchronized (ARVOJniClient.class) {
            removeAllModels = ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
            if (removeAllModels == 0 && (list = sModelIds) != null) {
                list.clear();
            }
        }
        return removeAllModels;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        com.baidu.ar.algovo.ARVOJniClient.sModelIds.remove(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int removeModel(java.lang.String r5) {
        /*
            java.lang.Class<com.baidu.ar.algovo.ARVOJniClient> r0 = com.baidu.ar.algovo.ARVOJniClient.class
            monitor-enter(r0)
            com.baidu.ar.algo.ARAlgoJniClient r1 = com.baidu.ar.algo.ARAlgoJniClient.getAlgoInstance()     // Catch: java.lang.Throwable -> L2e
            int r2 = com.baidu.ar.algovo.ARVOJniClient.sTrackerId     // Catch: java.lang.Throwable -> L2e
            int r1 = r1.removeModel(r2, r5)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L33
            java.util.List<java.lang.String> r2 = com.baidu.ar.algovo.ARVOJniClient.sModelIds     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L33
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L2e
            r3 = 0
        L18:
            if (r3 >= r2) goto L33
            java.util.List<java.lang.String> r4 = com.baidu.ar.algovo.ARVOJniClient.sModelIds     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L2e
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L30
            java.util.List<java.lang.String> r5 = com.baidu.ar.algovo.ARVOJniClient.sModelIds     // Catch: java.lang.Throwable -> L2e
            r5.remove(r3)     // Catch: java.lang.Throwable -> L2e
            goto L33
        L2e:
            r5 = move-exception
            goto L35
        L30:
            int r3 = r3 + 1
            goto L18
        L33:
            monitor-exit(r0)
            return r1
        L35:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.algovo.ARVOJniClient.removeModel(java.lang.String):int");
    }

    public static synchronized void reset() {
        synchronized (ARVOJniClient.class) {
            if (sTrackerId >= 0) {
                ARAlgoJniClient.getAlgoInstance().removeAllModels(sTrackerId);
            }
        }
    }

    public static synchronized boolean start(int i, int i2, float[] fArr, float[] fArr2) {
        synchronized (ARVOJniClient.class) {
            if (ARAlgoJniClient.getAlgoInstance().createTrackingSystem(i, i2, fArr, fArr2) != 0) {
                return false;
            }
            int addTrackerVO = ARAlgoJniClient.getAlgoInstance().addTrackerVO("");
            sTrackerId = addTrackerVO;
            return addTrackerVO >= 0;
        }
    }

    public static synchronized void stop() {
        synchronized (ARVOJniClient.class) {
            ARAlgoJniClient.getAlgoInstance().release();
            sModelIds = null;
        }
    }

    public static synchronized TrackParams track(ByteBuffer byteBuffer, float[] fArr) {
        TrackParams trackParams;
        synchronized (ARVOJniClient.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int trackFrame = ARAlgoJniClient.getAlgoInstance().trackFrame(byteBuffer, ((float) currentTimeMillis) * 1.0f, fArr, FrameType.TYPE_YUV);
            trackParams = new TrackParams();
            trackParams.processTime = (float) (System.currentTimeMillis() - currentTimeMillis);
            trackParams.trackQuality = trackFrame;
        }
        return trackParams;
    }
}
