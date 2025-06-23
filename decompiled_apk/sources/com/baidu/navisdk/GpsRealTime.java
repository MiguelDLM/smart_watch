package com.baidu.navisdk;

import android.location.Location;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* loaded from: classes7.dex */
public class GpsRealTime {
    private float maxV = 0.0f;
    private float maxAcc = 0.0f;
    private long lastGpsTime = 0;
    private long firstPointTime = 0;
    private Location lastGps = null;
    private Location lastLastGps = null;
    private byte[] cuidByte = null;
    private byte[] versionByte = new byte[4];
    private List<Byte> mGpsData = null;
    private int mGpsNum = 0;
    private boolean isStarted = false;
    private boolean inBackground = false;
    private LongLinkClient mLongLinkClient = null;
    private LongLinkDataCallback mLongLinkDataCallback = null;
    private com.baidu.navisdk.comapi.geolocate.b mLocationListener = new com.baidu.navisdk.comapi.geolocate.b() { // from class: com.baidu.navisdk.GpsRealTime.1
        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
            Location location = new Location("GPS");
            location.setTime(System.currentTimeMillis());
            location.setLongitude(gVar.b);
            location.setLatitude(gVar.f6926a);
            location.setSpeed(gVar.c);
            location.setBearing(gVar.e);
            GpsRealTime.this.updateLocation(location);
        }
    };

    private void addFirstGps(Location location) {
        this.firstPointTime = System.currentTimeMillis();
        addInt((int) (location.getTime() / 1000));
        addInt((int) (location.getLongitude() * 1000000.0d));
        addInt((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        if (i > 0) {
            this.mGpsData.add((byte) 32);
        } else {
            this.mGpsData.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (i2 > 0) {
            this.mGpsData.add(Byte.MIN_VALUE);
        } else {
            this.mGpsData.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
        this.lastGps = location;
    }

    private void addInt(int i) {
        byte[] intToByte = intToByte(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.mGpsData.add(Byte.valueOf(intToByte[i2]));
        }
    }

    private void addNextGps(Location location) {
        char c;
        char c2;
        byte b;
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.lastGps.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.lastGps.getLatitude()) * 1000000.0d);
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        if (longitude > 0) {
            c = 0;
        } else {
            c = 1;
        }
        int abs = Math.abs(longitude);
        if (latitude > 0) {
            c2 = 0;
        } else {
            c2 = 1;
        }
        int abs2 = Math.abs(latitude);
        if (this.mGpsNum > 1) {
            this.lastLastGps = this.lastGps;
        }
        this.lastGps = location;
        if (this.lastLastGps != null && location.getTime() > this.lastLastGps.getTime() && this.lastGps.getTime() - this.lastLastGps.getTime() < 5000) {
            long time = this.lastGps.getTime() - this.lastLastGps.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.lastGps.getAltitude(), this.lastGps.getLongitude(), this.lastLastGps.getLatitude(), this.lastLastGps.getLongitude(), fArr);
            double speed = ((fArr[0] - (this.lastLastGps.getSpeed() * ((float) time))) * 2.0f) / ((float) (time * time));
            if (speed > this.maxAcc) {
                this.maxAcc = (float) speed;
            }
        }
        this.mGpsData.add(Byte.valueOf((byte) (abs & 255)));
        this.mGpsData.add(Byte.valueOf((byte) ((abs & 65280) >> 8)));
        this.mGpsData.add(Byte.valueOf((byte) (abs2 & 255)));
        this.mGpsData.add(Byte.valueOf((byte) ((abs2 & 65280) >> 8)));
        if (i > 0) {
            if (c2 > 0) {
                b = (byte) 96;
            } else {
                b = 32;
            }
            if (c > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            this.mGpsData.add(Byte.valueOf(b));
        } else {
            byte bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c2 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c > 0) {
                bearing = (byte) (bearing | Byte.MIN_VALUE);
            }
            this.mGpsData.add(Byte.valueOf(bearing));
        }
        if (i2 > 0) {
            this.mGpsData.add(Byte.MIN_VALUE);
        } else {
            this.mGpsData.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
    }

    private void checkNetwork() {
        List<Byte> list;
        if (this.firstPointTime != 0 && System.currentTimeMillis() - this.firstPointTime >= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS && (list = this.mGpsData) != null) {
            int size = list.size();
            this.mGpsData.set(0, Byte.valueOf((byte) (size & 255)));
            this.mGpsData.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
            this.mGpsData.set(3, Byte.valueOf((byte) (this.mGpsNum & 255)));
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.mGpsData.get(i).byteValue();
            }
            uploadData(bArr);
            reset();
        }
    }

    private byte[] encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return bArr;
    }

    private void init() {
        String[] split = j.b().split("\\.");
        int length = split.length;
        byte[] bArr = this.versionByte;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.versionByte[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.cuidByte = encode(a0.g() + ":" + a0.e());
    }

    private void initGpsData() {
        this.mGpsData.add((byte) 0);
        this.mGpsData.add((byte) 0);
        if (this.inBackground) {
            this.mGpsData.add((byte) -73);
        } else {
            this.mGpsData.add((byte) -66);
        }
        this.mGpsData.add((byte) 0);
        this.mGpsData.add(Byte.valueOf(this.versionByte[0]));
        this.mGpsData.add(Byte.valueOf(this.versionByte[1]));
        this.mGpsData.add(Byte.valueOf(this.versionByte[2]));
        this.mGpsData.add(Byte.valueOf(this.versionByte[3]));
        int length = this.cuidByte.length;
        this.mGpsData.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.mGpsData.add(Byte.valueOf(this.cuidByte[i]));
        }
    }

    private synchronized void initLinkClient() throws ComInitException, InvalidComException {
        try {
            if (this.mLongLinkClient == null) {
                LongLinkClient create = LongLinkClient.create(6);
                this.mLongLinkClient = create;
                create.start();
                if (this.mLongLinkDataCallback == null) {
                    this.mLongLinkDataCallback = new LongLinkDataCallback() { // from class: com.baidu.navisdk.GpsRealTime.2
                        @Override // com.baidu.platform.comapi.longlink.LongLinkDataCallback
                        public boolean onReceiveData(ELongLinkStatus eLongLinkStatus, int i, byte[] bArr, boolean z) {
                            LogUtil.out("GpsRealTime", "onReceiveData:reqId:" + i + " status:" + eLongLinkStatus + " data: " + new String(bArr));
                            return true;
                        }
                    };
                }
                this.mLongLinkClient.register(this.mLongLinkDataCallback);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private byte[] intToByte(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    private void recordLocation(Location location) {
        if (System.currentTimeMillis() - this.lastGpsTime >= 1000 && location != null) {
            this.lastGpsTime = System.currentTimeMillis();
            if (location.hasSpeed() && location.getSpeed() > this.maxV) {
                this.maxV = location.getSpeed();
            }
            try {
                if (this.mGpsData == null) {
                    this.mGpsData = new ArrayList();
                    initGpsData();
                    addFirstGps(location);
                } else {
                    addNextGps(location);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mGpsNum++;
        }
    }

    private synchronized void releaseLinkClient() {
        LongLinkClient longLinkClient = this.mLongLinkClient;
        if (longLinkClient != null) {
            try {
                longLinkClient.unRegister(this.mLongLinkDataCallback);
                this.mLongLinkClient.stop();
                this.mLongLinkClient.release();
                this.mLongLinkClient = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void reset() {
        this.mGpsData = null;
        this.firstPointTime = 0L;
        this.mGpsNum = 0;
        this.lastGps = null;
        this.lastLastGps = null;
        this.maxV = 0.0f;
        this.maxAcc = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(Location location) {
        if (!this.isStarted) {
            start();
        }
        recordLocation(location);
        checkNetwork();
    }

    private void uploadData(byte[] bArr) {
        if (bArr.length <= 0) {
            return;
        }
        try {
            initLinkClient();
            ArrayList<LongLinkFileData> arrayList = new ArrayList<>();
            LongLinkFileData longLinkFileData = new LongLinkFileData();
            longLinkFileData.fileName = "location.dat";
            String str = "filename=" + longLinkFileData.fileName;
            longLinkFileData.binData = Arrays.copyOf(bArr, bArr.length);
            arrayList.add(longLinkFileData);
            this.mLongLinkClient.sendFileData(str, arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInBackground(boolean z) {
        this.inBackground = z;
    }

    public void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        init();
        com.baidu.navisdk.util.logic.j.r().a(this.mLocationListener);
    }

    public void stop() {
        if (!this.isStarted) {
            return;
        }
        this.isStarted = false;
        reset();
        releaseLinkClient();
        com.baidu.navisdk.util.logic.j.r().b(this.mLocationListener);
    }
}
