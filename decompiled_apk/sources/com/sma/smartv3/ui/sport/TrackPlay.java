package com.sma.smartv3.ui.sport;

import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.maps.model.LatLng;
import com.sma.smartv3.model.CustomLatLng;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public final class TrackPlay {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f23871I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<CustomLatLng> f23872II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final double f23873II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<CustomLatLng> f23874OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public SourceType f23875Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f23876X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f23877XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f23878oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Handler f23879oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f23880oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f23881xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f23882xxIXOIIO;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class SourceType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ SourceType[] $VALUES;
        public static final SourceType BAIDU = new SourceType(oOoIIO0.oIX0oI.f32063xoIox, 0);
        public static final SourceType GOOGLE = new SourceType("GOOGLE", 1);

        private static final /* synthetic */ SourceType[] $values() {
            return new SourceType[]{BAIDU, GOOGLE};
        }

        static {
            SourceType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private SourceType(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<SourceType> getEntries() {
            return $ENTRIES;
        }

        public static SourceType valueOf(String str) {
            return (SourceType) Enum.valueOf(SourceType.class, str);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void I0Io(float f);

        void II0xO0();

        void oIX0oI(@OXOo.OOXIXo ArrayList<LatLng> arrayList, float f);

        void onStart();

        void oxoX(@OXOo.OOXIXo ArrayList<com.baidu.mapapi.model.LatLng> arrayList, float f, int i);
    }

    public TrackPlay(@OXOo.OOXIXo oIX0oI onPlayListener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onPlayListener, "onPlayListener");
        this.f23878oIX0oI = "TrackPlay";
        this.f23873II0xO0 = 1.0E-4d;
        this.f23871I0Io = 30;
        this.f23880oxoX = 30000;
        this.f23877XO = 30;
        this.f23875Oxx0IOOO = SourceType.BAIDU;
        this.f23872II0XooXoX = new ArrayList<>();
        this.f23874OOXIXo = new ArrayList<>();
        this.f23879oOoXoXO = new Handler(Looper.getMainLooper());
        this.f23882xxIXOIIO = onPlayListener;
    }

    public static final void IIXOooo(TrackPlay this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        try {
            LogUtils.d(this$0.f23878oIX0oI + " play -> stop");
            oIX0oI oix0oi = this$0.f23882xxIXOIIO;
            if (oix0oi != null) {
                oix0oi.II0xO0();
            }
            this$0.f23881xoIox = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void IXxxXO(final TrackPlay this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int size = this$0.f23874OOXIXo.size();
        for (int i = 0; i < size && this$0.f23881xoIox; i++) {
            CustomLatLng customLatLng = this$0.f23874OOXIXo.get(i);
            kotlin.jvm.internal.IIX0o.oO(customLatLng, "get(...)");
            final CustomLatLng customLatLng2 = customLatLng;
            if (i != 0) {
                CustomLatLng customLatLng3 = this$0.f23874OOXIXo.get(i - 1);
                kotlin.jvm.internal.IIX0o.oO(customLatLng3, "get(...)");
                final CustomLatLng customLatLng4 = customLatLng3;
                this$0.f23879oOoXoXO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.Ioxxx
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrackPlay.Oxx0xo(TrackPlay.this, customLatLng4, customLatLng2);
                    }
                });
            }
            this$0.f23879oOoXoXO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.xxIO
                @Override // java.lang.Runnable
                public final void run() {
                    TrackPlay.oI0IIXIo(TrackPlay.this, arrayList, customLatLng2, arrayList2);
                }
            });
            try {
                Thread.sleep(this$0.f23877XO);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this$0.f23879oOoXoXO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.XX0xXo
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrackPlay.OxxIIOOXO(TrackPlay.this);
                    }
                });
            }
        }
        this$0.f23879oOoXoXO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.o0xxxXXxX
            @Override // java.lang.Runnable
            public final void run() {
                TrackPlay.IIXOooo(TrackPlay.this);
            }
        });
    }

    public static final void Oo(TrackPlay this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        oIX0oI oix0oi = this$0.f23882xxIXOIIO;
        if (oix0oi != null) {
            oix0oi.onStart();
        }
    }

    public static final void Oxx0xo(TrackPlay this$0, CustomLatLng startPoint, CustomLatLng endPoint) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(startPoint, "$startPoint");
        kotlin.jvm.internal.IIX0o.x0xO0oo(endPoint, "$endPoint");
        oIX0oI oix0oi = this$0.f23882xxIXOIIO;
        if (oix0oi != null) {
            oix0oi.I0Io((float) this$0.II0XooXoX(startPoint, endPoint));
        }
    }

    public static final void OxxIIOOXO(TrackPlay this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d(this$0.f23878oIX0oI + " play -> error stop");
        oIX0oI oix0oi = this$0.f23882xxIXOIIO;
        if (oix0oi != null) {
            oix0oi.II0xO0();
        }
        this$0.f23881xoIox = false;
    }

    public static final void oI0IIXIo(TrackPlay this$0, ArrayList baiduPoints, CustomLatLng endPoint, ArrayList googlePoints) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(baiduPoints, "$baiduPoints");
        kotlin.jvm.internal.IIX0o.x0xO0oo(endPoint, "$endPoint");
        kotlin.jvm.internal.IIX0o.x0xO0oo(googlePoints, "$googlePoints");
        try {
            if (this$0.f23875Oxx0IOOO == SourceType.BAIDU) {
                baiduPoints.add(new com.baidu.mapapi.model.LatLng(endPoint.getLatitude(), endPoint.getLongitude()));
                oIX0oI oix0oi = this$0.f23882xxIXOIIO;
                if (oix0oi != null) {
                    oix0oi.oxoX(baiduPoints, baiduPoints.size() / this$0.f23874OOXIXo.size(), endPoint.getColor());
                }
            } else {
                googlePoints.add(new LatLng(endPoint.getLatitude(), endPoint.getLongitude()));
                oIX0oI oix0oi2 = this$0.f23882xxIXOIIO;
                if (oix0oi2 != null) {
                    oix0oi2.oIX0oI(googlePoints, googlePoints.size() / this$0.f23874OOXIXo.size());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final double II0XooXoX(CustomLatLng customLatLng, CustomLatLng customLatLng2) {
        float f;
        double oOoXoXO2 = oOoXoXO(customLatLng, customLatLng2);
        if (oOoXoXO2 == Double.MAX_VALUE) {
            if (customLatLng2.getLatitude() > customLatLng.getLatitude()) {
                return XIXIX.OOXIXo.f3760XO;
            }
            return 180.0d;
        }
        if (oOoXoXO2 == XIXIX.OOXIXo.f3760XO) {
            if (customLatLng2.getLongitude() > customLatLng.getLongitude()) {
                return -90.0d;
            }
            return 90.0d;
        }
        if ((customLatLng2.getLatitude() - customLatLng.getLatitude()) * oOoXoXO2 < XIXIX.OOXIXo.f3760XO) {
            f = 180.0f;
        } else {
            f = 0.0f;
        }
        return ((180 * (Math.atan(oOoXoXO2) / 3.141592653589793d)) + f) - 90;
    }

    public final int OOXIXo() {
        return this.f23874OOXIXo.size();
    }

    public final void OxI() {
        this.f23881xoIox = false;
    }

    public final ArrayList<CustomLatLng> Oxx0IOOO(ArrayList<CustomLatLng> arrayList) {
        boolean z;
        boolean z2;
        double ooOOo0oXI2;
        ArrayList<CustomLatLng> arrayList2;
        double x0XOIxOo2;
        boolean z3;
        boolean z4;
        CustomLatLng customLatLng;
        ArrayList<CustomLatLng> arrayList3 = arrayList;
        int size = arrayList.size() * this.f23871I0Io;
        this.f23876X0o0xo = size;
        if (size > this.f23880oxoX) {
            return arrayList3;
        }
        ArrayList<CustomLatLng> arrayList4 = new ArrayList<>();
        int size2 = arrayList.size() - 1;
        int i = 0;
        while (i < size2) {
            CustomLatLng customLatLng2 = arrayList3.get(i);
            kotlin.jvm.internal.IIX0o.oO(customLatLng2, "get(...)");
            CustomLatLng customLatLng3 = customLatLng2;
            i++;
            CustomLatLng customLatLng4 = arrayList3.get(i);
            kotlin.jvm.internal.IIX0o.oO(customLatLng4, "get(...)");
            CustomLatLng customLatLng5 = customLatLng4;
            double oOoXoXO2 = oOoXoXO(customLatLng3, customLatLng5);
            if (customLatLng3.getLatitude() > customLatLng5.getLatitude()) {
                z = true;
            } else {
                z = false;
            }
            if (customLatLng3.getLongitude() > customLatLng5.getLongitude()) {
                z2 = true;
            } else {
                z2 = false;
            }
            double xxIXOIIO2 = xxIXOIIO(oOoXoXO2, customLatLng3);
            if (z2) {
                ooOOo0oXI2 = ooOOo0oXI(oOoXoXO2);
            } else {
                ooOOo0oXI2 = (-1) * ooOOo0oXI(oOoXoXO2);
            }
            if (z) {
                arrayList2 = arrayList4;
                x0XOIxOo2 = x0XOIxOo(oOoXoXO2);
            } else {
                arrayList2 = arrayList4;
                x0XOIxOo2 = (-1) * x0XOIxOo(oOoXoXO2);
            }
            double latitude = customLatLng3.getLatitude();
            double longitude = customLatLng3.getLongitude();
            while (true) {
                if (latitude > customLatLng5.getLatitude()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 ^ z) {
                    break;
                }
                if (longitude > customLatLng5.getLongitude()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!(z4 ^ z2)) {
                    if (oOoXoXO2 == Double.MAX_VALUE) {
                        customLatLng = new CustomLatLng(latitude, longitude, 0L, 0, 0, 28, null);
                    } else if (oOoXoXO2 == XIXIX.OOXIXo.f3760XO) {
                        longitude -= ooOOo0oXI2;
                        customLatLng = new CustomLatLng(latitude, longitude, 0L, 0, 0, 28, null);
                        if (customLatLng.getLatitude() == XIXIX.OOXIXo.f3760XO || customLatLng.getLongitude() != XIXIX.OOXIXo.f3760XO) {
                            customLatLng.setColor(customLatLng3.getColor());
                            arrayList2.add(customLatLng);
                            x0XOIxOo2 = x0XOIxOo2;
                        }
                    } else {
                        customLatLng = new CustomLatLng(latitude, (latitude - xxIXOIIO2) / oOoXoXO2, 0L, 0, 0, 28, null);
                    }
                    latitude -= x0XOIxOo2;
                    if (customLatLng.getLatitude() == XIXIX.OOXIXo.f3760XO) {
                    }
                    customLatLng.setColor(customLatLng3.getColor());
                    arrayList2.add(customLatLng);
                    x0XOIxOo2 = x0XOIxOo2;
                }
            }
            arrayList4 = arrayList2;
            arrayList3 = arrayList;
        }
        ArrayList<CustomLatLng> arrayList5 = arrayList4;
        this.f23876X0o0xo = arrayList5.size() * this.f23871I0Io;
        return arrayList5;
    }

    public final void o00(@OXOo.OOXIXo ArrayList<CustomLatLng> source, @OXOo.OOXIXo SourceType type) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(source, "source");
        kotlin.jvm.internal.IIX0o.x0xO0oo(type, "type");
        this.f23875Oxx0IOOO = type;
        this.f23872II0XooXoX.clear();
        this.f23872II0XooXoX.addAll(source);
        this.f23874OOXIXo.clear();
        this.f23874OOXIXo.addAll(Oxx0IOOO(this.f23872II0XooXoX));
    }

    public final boolean oO() {
        return this.f23881xoIox;
    }

    public final double oOoXoXO(CustomLatLng customLatLng, CustomLatLng customLatLng2) {
        if (customLatLng2.getLongitude() == customLatLng.getLongitude()) {
            return Double.MAX_VALUE;
        }
        return (customLatLng2.getLatitude() - customLatLng.getLatitude()) / (customLatLng2.getLongitude() - customLatLng.getLongitude());
    }

    public final double ooOOo0oXI(double d) {
        if (d == Double.MAX_VALUE || d == XIXIX.OOXIXo.f3760XO) {
            return this.f23873II0xO0;
        }
        double d2 = 1;
        return Math.abs(((this.f23873II0xO0 * d2) / d) / Math.sqrt(d2 + (d2 / (d * d))));
    }

    public final double x0XOIxOo(double d) {
        if (d == Double.MAX_VALUE || d == XIXIX.OOXIXo.f3760XO) {
            return this.f23873II0xO0;
        }
        return Math.abs((this.f23873II0xO0 * d) / Math.sqrt(1 + (d * d)));
    }

    public final void x0xO0oo() {
        this.f23881xoIox = true;
        int i = this.f23876X0o0xo;
        int i2 = this.f23880oxoX;
        if (i > i2) {
            this.f23877XO = i2 / this.f23874OOXIXo.size();
        }
        if (this.f23877XO < 5) {
            this.f23877XO = 5;
        }
        LogUtils.d(this.f23878oIX0oI + " play -> start ss:" + this.f23872II0XooXoX.size() + " fs:" + this.f23874OOXIXo.size() + " st:" + this.f23875Oxx0IOOO + " pt:" + this.f23876X0o0xo + " it:" + this.f23877XO);
        this.f23879oOoXoXO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.O00XxXI
            @Override // java.lang.Runnable
            public final void run() {
                TrackPlay.Oo(TrackPlay.this);
            }
        });
        new Thread(new Runnable() { // from class: com.sma.smartv3.ui.sport.XI0oooXX
            @Override // java.lang.Runnable
            public final void run() {
                TrackPlay.IXxxXO(TrackPlay.this);
            }
        }).start();
    }

    public final int xoIox() {
        return this.f23877XO;
    }

    public final void xoXoI(int i) {
        this.f23877XO = i;
    }

    public final double xxIXOIIO(double d, CustomLatLng customLatLng) {
        return customLatLng.getLatitude() - (d * customLatLng.getLongitude());
    }
}
