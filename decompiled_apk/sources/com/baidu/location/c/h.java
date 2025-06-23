package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.location.c.a.IIX0o;
import com.baidu.location.c.a.IoOoX;
import com.baidu.location.c.a.oo0xXOI0I;
import com.baidu.location.c.k;
import com.baidu.location.pb.CellCommonValue;
import com.baidu.location.pb.CellValue;
import com.baidu.location.pb.CellValueList;
import com.baidu.location.pb.LteCellValue;
import com.baidu.location.pb.NrCellValue;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.protobuf.micro.ByteStringMicro;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class h {
    private k e;
    private b f;
    private TelephonyManager g;

    /* renamed from: a, reason: collision with root package name */
    private final String f5706a = "NetLocDataManager";
    private final int b = 2000;
    private final int c = 100;
    private final int d = 30000;
    private ConnectivityManager h = null;
    private WifiManager i = null;
    private Handler j = null;
    private String k = null;
    private boolean l = false;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f5707a = new h();
    }

    /* loaded from: classes7.dex */
    public class b extends g {
        private long b = 0;
        private boolean c = false;

        public b() {
        }

        @Override // com.baidu.location.c.g
        public void a(String str) {
        }

        @Override // com.baidu.location.c.g
        public boolean a(Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", true);
                h.this.n = System.currentTimeMillis() / 1000;
                if (h.this.j == null) {
                    return true;
                }
                h.this.j.post(new j(this, booleanExtra));
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                if (!((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) || System.currentTimeMillis() - this.b < 5000) {
                    return false;
                }
                this.b = System.currentTimeMillis();
                if (!this.c) {
                    this.c = true;
                    return false;
                }
                if (h.this.j == null) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.baidu.location.c.g
        public boolean a(List<CellInfo> list) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Comparator<m> {
        private d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(m mVar, m mVar2) {
            return mVar.g - mVar2.g;
        }
    }

    private synchronized String s() {
        String str;
        str = this.k;
        return (str == null || str.length() == 0) ? null : this.k.replace("\n", "");
    }

    private int t() {
        SignalStrength signalStrength;
        try {
            TelephonyManager telephonyManager = this.g;
            if (telephonyManager == null) {
                return Integer.MAX_VALUE;
            }
            signalStrength = telephonyManager.getSignalStrength();
            return com.baidu.location.e.o.a(signalStrength, "getLteRssnr");
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    public int a(CellIdentityNr cellIdentityNr) {
        try {
            return com.baidu.location.e.o.a(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public long b(p pVar) {
        long j;
        long j2;
        List<ScanResult> list = pVar.f5714a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            j = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            j = 0;
        }
        boolean z = j > 0;
        if (!z) {
            return 0L;
        }
        int size = pVar.f5714a.size();
        if (size > 16) {
            size = 16;
        }
        long j3 = 2147483647L;
        for (int i = 0; i < size; i++) {
            if (pVar.f5714a.get(i) != null && pVar.f5714a.get(i).level != 0 && z) {
                try {
                    j2 = (j - pVar.f5714a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j2 = 0;
                }
                if (j2 < j3) {
                    j3 = j2;
                }
            }
        }
        if (!z) {
            j3 = 0;
        }
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public long c(p pVar) {
        long j;
        long j2;
        if (pVar.a() == 0) {
            return 0L;
        }
        try {
            j = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            j = 0;
        }
        boolean z = j > 0;
        if (!z) {
            return 0L;
        }
        int size = pVar.f5714a.size();
        if (size > 16) {
            size = 16;
        }
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        for (int i = 0; i < size; i++) {
            if (pVar.f5714a.get(i) != null && pVar.f5714a.get(i).level != 0 && z) {
                try {
                    j2 = (j - pVar.f5714a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j2 = 0;
                }
                j5 += j2;
                j3++;
                if (j2 > j4) {
                    j4 = j2;
                }
            }
        }
        return j3 > 1 ? (j5 - j4) / (j3 - 1) : j4;
    }

    public synchronized void d() {
        try {
            c();
            if (this.e != null) {
                this.e = null;
            }
            this.g = null;
            this.i = null;
            this.f = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean e() {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.d();
        }
        return false;
    }

    public synchronized com.baidu.location.c.a f() {
        if (this.e == null) {
            return null;
        }
        a(this.g, com.baidu.location.e.o.aJ, com.baidu.location.e.o.aK, com.baidu.location.e.o.aL, com.baidu.location.e.o.aM);
        return this.e.d(30000);
    }

    public int g() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = this.h;
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            return activeNetworkInfo.getSubtype();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String h() {
        int i = -1;
        try {
            TelephonyManager telephonyManager = this.g;
            if (telephonyManager != null) {
                i = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + i;
    }

    public void i() {
        this.p = 0L;
    }

    public boolean j() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.m;
        if (currentTimeMillis - j > 0 && currentTimeMillis - j <= 5000) {
            return false;
        }
        this.m = currentTimeMillis;
        i();
        return k();
    }

    public boolean k() {
        long currentTimeMillis = System.currentTimeMillis();
        k kVar = this.e;
        long c2 = kVar != null ? kVar.c() : 0L;
        long j = currentTimeMillis - c2;
        if (j > 0) {
            long j2 = this.p;
            if (j <= j2 + 5000 || currentTimeMillis - (this.n * 1000) <= j2 + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && j < 25000) {
                return false;
            }
            if (l() && !m() && j <= this.p + 10000) {
                return false;
            }
        }
        return a(c2);
    }

    public boolean l() {
        try {
            ConnectivityManager connectivityManager = this.h;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean m() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public String n() {
        WifiManager wifiManager = this.i;
        if (wifiManager == null) {
            return "";
        }
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (!this.i.isScanAlwaysAvailable()) {
                    return "";
                }
            }
            return "&wifio=1";
        } catch (Exception | NoSuchMethodError unused) {
            return "";
        }
    }

    public String o() {
        k kVar = this.e;
        if (kVar == null || com.baidu.location.e.o.f == 4) {
            return null;
        }
        return kVar.e();
    }

    public WifiInfo p() {
        k kVar;
        if (com.baidu.location.e.o.f == 4 || (kVar = this.e) == null) {
            return null;
        }
        return kVar.f();
    }

    public String q() {
        p r;
        if (com.baidu.location.b.e.b().df == 0 || (r = r()) == null || r.a() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : r.f5714a) {
            if (scanResult != null && scanResult.level != 0 && scanResult.BSSID != null) {
                arrayList.add(scanResult);
            }
        }
        Collections.sort(arrayList, new c());
        int min = Math.min(com.baidu.location.b.e.b().dh, arrayList.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(((ScanResult) arrayList.get(i)).BSSID.replace(":", "") + "," + b(((ScanResult) arrayList.get(i)).SSID));
            sb.append(x.aL);
        }
        return sb.toString();
    }

    public p r() {
        k kVar = this.e;
        return (kVar == null || com.baidu.location.e.o.f == 4) ? new p(null, 0L) : kVar.g();
    }

    private String c(String str) {
        return str != null ? (str.contains("&") || str.contains(x.aL)) ? str.replace("&", "_").replace(x.aL, "_") : str : str;
    }

    public int a(p pVar) {
        int i;
        for (int i2 = 0; i2 < pVar.a(); i2++) {
            if (pVar.f5714a.get(i2) != null && (i = -pVar.f5714a.get(i2).level) > 0) {
                return i;
            }
        }
        return 0;
    }

    public String b(com.baidu.location.c.a aVar) {
        if (this.e == null) {
            return null;
        }
        return this.e.c(aVar) + "&cl_list=" + s();
    }

    private String b(String str) {
        if (str != null && str.length() > com.baidu.location.b.e.b().dg) {
            str = str.substring(0, com.baidu.location.b.e.b().dg);
        }
        return str != null ? (str.contains("&") || str.contains(x.aL)) ? str.replace("&", "_").replace(x.aL, "_") : str : str;
    }

    public int a(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        i = Integer.parseInt(matcher.group(1));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i;
        }
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.b(aVar);
        }
        return null;
    }

    public void b() {
        if (this.e == null) {
            this.e = new k();
        }
        b bVar = new b();
        this.f = bVar;
        this.e.a(bVar);
    }

    public void c() {
        k kVar = this.e;
        if (kVar != null) {
            kVar.b();
        }
    }

    @SuppressLint({"NewApi"})
    public boolean b(long j) {
        p r;
        try {
            if ((!this.i.isWifiEnabled() && !this.i.isScanAlwaysAvailable()) || l() || (r = r()) == null) {
                return false;
            }
            return a(r, j);
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(aVar, telephonyManager);
        }
        return null;
    }

    public static h a() {
        return a.f5707a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        m mVar;
        CellSignalStrength cellSignalStrength;
        int cellConnectionStatus;
        int ssRsrp;
        int ssRsrp2;
        int ssRsrq;
        int ssSinr;
        int csiRsrp;
        int csiRsrq;
        int csiSinr;
        long elapsedRealtimeNanos;
        long timestampMillis;
        String mccString;
        String mncString;
        long nci;
        int pci;
        int tac;
        String cellIdentityNr;
        int nrarfcn;
        CellIdentity cellIdentity;
        long elapsedRealtimeNanos2;
        long currentTimeMillis;
        long timestampMillis2;
        int rsrp;
        int rsrp2;
        int rsrq;
        int rssnr;
        int cqi;
        int rssi;
        int earfcn;
        String mccString2;
        String mncString2;
        int cellConnectionStatus2;
        int bandwidth;
        CellIdentityTdscdma cellIdentity2;
        String mccString3;
        String mncString3;
        int cellConnectionStatus3;
        long timestampMillis3;
        long elapsedRealtimeNanos3;
        long currentTimeMillis2;
        long timestampMillis4;
        String mccString4;
        String mncString4;
        int cellConnectionStatus4;
        long timestampMillis5;
        int cellConnectionStatus5;
        long elapsedRealtimeNanos4;
        long currentTimeMillis3;
        long timestampMillis6;
        String mccString5;
        String mncString5;
        int cellConnectionStatus6;
        int i = Build.VERSION.SDK_INT;
        m mVar2 = null;
        CellIdentityNr cellIdentityNr2 = null;
        try {
            if (cellInfo instanceof CellInfoGsm) {
                m mVar3 = new m();
                CellIdentityGsm cellIdentity3 = ((CellInfoGsm) cellInfo).getCellIdentity();
                mVar3.f5713a = 1;
                if (cellInfo.isRegistered()) {
                    mVar3.d = 1;
                }
                if (i >= 28) {
                    mccString5 = cellIdentity3.getMccString();
                    mVar3.b = mccString5;
                    mncString5 = cellIdentity3.getMncString();
                    mVar3.c = mncString5;
                    cellConnectionStatus6 = cellInfo.getCellConnectionStatus();
                    mVar3.f = cellConnectionStatus6;
                } else {
                    mVar3.b = cellIdentity3.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity3.getMcc());
                    mVar3.c = cellIdentity3.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity3.getMnc()) : null;
                }
                if (i >= 30) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    timestampMillis6 = cellInfo.getTimestampMillis();
                    elapsedRealtimeNanos4 = elapsedRealtime - timestampMillis6;
                    currentTimeMillis3 = System.currentTimeMillis();
                } else {
                    elapsedRealtimeNanos4 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    currentTimeMillis3 = System.currentTimeMillis();
                }
                mVar3.e = currentTimeMillis3 - elapsedRealtimeNanos4;
                mVar = mVar3;
            } else {
                if (cellInfo instanceof CellInfoCdma) {
                    m mVar4 = new m();
                    CellIdentityCdma cellIdentity4 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    mVar4.f5713a = 2;
                    mVar4.c = cellIdentity4.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity4.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        mVar4.d = 1;
                    }
                    if (i >= 28) {
                        cellConnectionStatus5 = cellInfo.getCellConnectionStatus();
                        mVar4.f = cellConnectionStatus5;
                    }
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            mVar4.b = networkOperator.substring(0, 3);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        if (i >= 30) {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            timestampMillis5 = cellInfo.getTimestampMillis();
                            mVar4.e = System.currentTimeMillis() - (elapsedRealtime2 - timestampMillis5);
                        } else {
                            mVar4.e = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                        }
                    } catch (Error unused2) {
                        mVar4.e = System.currentTimeMillis();
                    }
                    return mVar4;
                }
                if (!(cellInfo instanceof CellInfoWcdma)) {
                    try {
                        if (i >= 29 && com.baidu.location.c.a.IIXOooo.oIX0oI(cellInfo)) {
                            m mVar5 = new m();
                            cellIdentity2 = IIX0o.oIX0oI(cellInfo).getCellIdentity();
                            mVar5.f5713a = 5;
                            if (cellInfo.isRegistered()) {
                                mVar5.d = 1;
                            }
                            mccString3 = cellIdentity2.getMccString();
                            mVar5.b = mccString3;
                            mncString3 = cellIdentity2.getMncString();
                            mVar5.c = mncString3;
                            cellConnectionStatus3 = cellInfo.getCellConnectionStatus();
                            mVar5.f = cellConnectionStatus3;
                            if (i >= 30) {
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                timestampMillis3 = cellInfo.getTimestampMillis();
                                elapsedRealtimeNanos2 = elapsedRealtime3 - timestampMillis3;
                                currentTimeMillis = System.currentTimeMillis();
                                mVar2 = mVar5;
                            } else {
                                elapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                currentTimeMillis = System.currentTimeMillis();
                                mVar2 = mVar5;
                            }
                        } else if (cellInfo instanceof CellInfoLte) {
                            n nVar = new n();
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            CellIdentityLte cellIdentity5 = cellInfoLte.getCellIdentity();
                            CellSignalStrengthLte cellSignalStrength2 = cellInfoLte.getCellSignalStrength();
                            nVar.f5713a = 3;
                            if (cellInfo.isRegistered()) {
                                nVar.d = 1;
                            }
                            nVar.h = cellIdentity5.getCi();
                            nVar.i = cellIdentity5.getPci();
                            nVar.j = cellIdentity5.getTac();
                            nVar.r = cellSignalStrength2.getTimingAdvance();
                            if (i >= 28) {
                                mccString2 = cellIdentity5.getMccString();
                                nVar.b = mccString2;
                                mncString2 = cellIdentity5.getMncString();
                                nVar.c = mncString2;
                                cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                                nVar.f = cellConnectionStatus2;
                                bandwidth = cellIdentity5.getBandwidth();
                                nVar.l = bandwidth;
                            } else {
                                if (cellIdentity5.getMcc() != Integer.MAX_VALUE) {
                                    nVar.b = String.valueOf(cellIdentity5.getMcc());
                                }
                                if (cellIdentity5.getMnc() != Integer.MAX_VALUE) {
                                    nVar.c = String.valueOf(cellIdentity5.getMnc());
                                }
                            }
                            if (i >= 24) {
                                earfcn = cellIdentity5.getEarfcn();
                                nVar.k = earfcn;
                            }
                            if (i >= 29) {
                                rssi = cellSignalStrength2.getRssi();
                                nVar.m = Math.abs(rssi);
                            }
                            if (i >= 26) {
                                rsrp = cellSignalStrength2.getRsrp();
                                nVar.n = Math.abs(rsrp);
                                rsrp2 = cellSignalStrength2.getRsrp();
                                nVar.g = Math.abs(rsrp2);
                                rsrq = cellSignalStrength2.getRsrq();
                                nVar.o = rsrq;
                                rssnr = cellSignalStrength2.getRssnr();
                                if (rssnr == Integer.MAX_VALUE && cellInfo.isRegistered()) {
                                    rssnr = t();
                                }
                                nVar.p = rssnr;
                                cqi = cellSignalStrength2.getCqi();
                                nVar.q = cqi;
                            }
                            if (i >= 30) {
                                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                                timestampMillis2 = cellInfo.getTimestampMillis();
                                elapsedRealtimeNanos2 = elapsedRealtime4 - timestampMillis2;
                            } else {
                                elapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            }
                            currentTimeMillis = System.currentTimeMillis();
                            mVar2 = nVar;
                        } else {
                            if (i < 29 || !oo0xXOI0I.oIX0oI(cellInfo)) {
                                return null;
                            }
                            o oVar = new o();
                            try {
                                cellIdentity = IoOoX.oIX0oI(cellInfo).getCellIdentity();
                                cellIdentityNr2 = com.baidu.location.c.a.II0xO0.oIX0oI(cellIdentity);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            cellSignalStrength = IoOoX.oIX0oI(cellInfo).getCellSignalStrength();
                            CellSignalStrengthNr oIX0oI2 = com.baidu.location.c.a.xxIXOIIO.oIX0oI(cellSignalStrength);
                            if (cellIdentityNr2 != null) {
                                oVar.f5713a = 6;
                                mccString = cellIdentityNr2.getMccString();
                                oVar.b = mccString;
                                mncString = cellIdentityNr2.getMncString();
                                oVar.c = mncString;
                                nci = cellIdentityNr2.getNci();
                                oVar.h = nci;
                                pci = cellIdentityNr2.getPci();
                                oVar.i = pci;
                                tac = cellIdentityNr2.getTac();
                                oVar.j = tac;
                                if (tac == Integer.MAX_VALUE) {
                                    try {
                                        oVar.j = a(cellIdentityNr2);
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (oVar.j == Integer.MAX_VALUE) {
                                    try {
                                        cellIdentityNr = cellIdentityNr2.toString();
                                        oVar.j = a(cellIdentityNr);
                                    } catch (Throwable unused4) {
                                    }
                                }
                                nrarfcn = cellIdentityNr2.getNrarfcn();
                                oVar.k = nrarfcn;
                            }
                            if (cellInfo.isRegistered()) {
                                oVar.d = 1;
                            }
                            cellConnectionStatus = cellInfo.getCellConnectionStatus();
                            oVar.f = cellConnectionStatus;
                            ssRsrp = oIX0oI2.getSsRsrp();
                            oVar.l = Math.abs(ssRsrp);
                            ssRsrp2 = oIX0oI2.getSsRsrp();
                            oVar.g = Math.abs(ssRsrp2);
                            ssRsrq = oIX0oI2.getSsRsrq();
                            oVar.m = Math.abs(ssRsrq);
                            ssSinr = oIX0oI2.getSsSinr();
                            oVar.n = ssSinr;
                            csiRsrp = oIX0oI2.getCsiRsrp();
                            oVar.o = Math.abs(csiRsrp);
                            csiRsrq = oIX0oI2.getCsiRsrq();
                            oVar.p = Math.abs(csiRsrq);
                            csiSinr = oIX0oI2.getCsiSinr();
                            oVar.q = csiSinr;
                            if (i >= 30) {
                                long elapsedRealtime5 = SystemClock.elapsedRealtime();
                                timestampMillis = cellInfo.getTimestampMillis();
                                elapsedRealtimeNanos = elapsedRealtime5 - timestampMillis;
                            } else {
                                elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            }
                            oVar.e = System.currentTimeMillis() - elapsedRealtimeNanos;
                            mVar = oVar;
                        }
                        mVar2.e = currentTimeMillis - elapsedRealtimeNanos2;
                        return mVar2;
                    } catch (Error unused5) {
                        mVar2.e = System.currentTimeMillis();
                        return mVar2;
                    }
                }
                m mVar6 = new m();
                CellIdentityWcdma cellIdentity6 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                mVar6.f5713a = 4;
                if (cellInfo.isRegistered()) {
                    mVar6.d = 1;
                }
                if (i >= 28) {
                    mccString4 = cellIdentity6.getMccString();
                    mVar6.b = mccString4;
                    mncString4 = cellIdentity6.getMncString();
                    mVar6.c = mncString4;
                    cellConnectionStatus4 = cellInfo.getCellConnectionStatus();
                    mVar6.f = cellConnectionStatus4;
                } else {
                    mVar6.b = cellIdentity6.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity6.getMcc());
                    mVar6.c = cellIdentity6.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity6.getMnc()) : null;
                }
                if (i >= 30) {
                    long elapsedRealtime6 = SystemClock.elapsedRealtime();
                    timestampMillis4 = cellInfo.getTimestampMillis();
                    elapsedRealtimeNanos3 = elapsedRealtime6 - timestampMillis4;
                    currentTimeMillis2 = System.currentTimeMillis();
                } else {
                    elapsedRealtimeNanos3 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    currentTimeMillis2 = System.currentTimeMillis();
                }
                mVar6.e = currentTimeMillis2 - elapsedRealtimeNanos3;
                mVar = mVar6;
            }
        } catch (Error unused6) {
            telephonyManager.e = System.currentTimeMillis();
            mVar = telephonyManager;
        }
        return mVar;
    }

    public p a(int i) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.e(i);
        }
        return null;
    }

    public String a(int i, p pVar) {
        if (i == 0) {
            return null;
        }
        int i2 = 1;
        if (pVar.a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = pVar.f5714a.size();
        int i3 = com.baidu.location.e.o.N;
        if (size > i3) {
            size = i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            if (pVar.f5714a.get(i5) != null) {
                if ((i2 & i) != 0 && pVar.f5714a.get(i5).BSSID != null) {
                    stringBuffer.append(i4 == 0 ? "&ssid=" : "|");
                    stringBuffer.append(pVar.f5714a.get(i5).BSSID.replace(":", ""));
                    stringBuffer.append(x.aL);
                    stringBuffer.append(c(pVar.f5714a.get(i5).SSID));
                    i4++;
                }
                i2 <<= 1;
            }
        }
        return stringBuffer.toString();
    }

    public String a(int i, boolean z, p pVar, int i2) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(i, z, pVar, i2);
        }
        return null;
    }

    public String a(WifiInfo wifiInfo, String str) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(wifiInfo, str);
        }
        return null;
    }

    public String a(com.baidu.location.c.a aVar) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(aVar);
        }
        return null;
    }

    public String a(p pVar, int i, String str, boolean z, int i2) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(pVar, i, str, z, i2);
        }
        return null;
    }

    private String a(List<CellInfo> list, TelephonyManager telephonyManager, int i, int[] iArr, boolean z, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i != 1 && com.baidu.location.b.e.b().bW != 1) {
            return null;
        }
        boolean z2 = com.baidu.location.b.e.b().bW != 1 && z;
        Iterator<CellInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), telephonyManager));
        }
        return a(a(arrayList, i2), iArr, z2);
    }

    private String a(List<m> list, int[] iArr, boolean z) {
        if (list == null || list.size() == 0) {
            return null;
        }
        CellValueList cellValueList = new CellValueList();
        for (m mVar : list) {
            CellValue cellValue = new CellValue();
            CellCommonValue cellCommonValue = new CellCommonValue();
            cellCommonValue.setCellType(mVar.f5713a);
            String str = mVar.b;
            if (str != null) {
                cellCommonValue.setMcc(ByteStringMicro.copyFromUtf8(str));
            }
            String str2 = mVar.c;
            if (str2 != null) {
                cellCommonValue.setMnc(ByteStringMicro.copyFromUtf8(str2));
            }
            cellCommonValue.setRegistered(mVar.d);
            cellCommonValue.setTimestamp(mVar.e);
            int i = mVar.f;
            if (i != Integer.MAX_VALUE) {
                cellCommonValue.setCellconnectionstatus(i);
            }
            if (!z) {
                cellValue.setCellCommonValue(cellCommonValue);
            }
            if (mVar instanceof n) {
                LteCellValue lteCellValue = new LteCellValue();
                n nVar = (n) mVar;
                int i2 = nVar.h;
                if (i2 != Integer.MAX_VALUE && (!z || iArr[0] == 1)) {
                    lteCellValue.setCi(i2);
                }
                int i3 = nVar.i;
                if (i3 != Integer.MAX_VALUE && (!z || iArr[1] == 1)) {
                    lteCellValue.setPci(i3);
                }
                int i4 = nVar.j;
                if (i4 != Integer.MAX_VALUE && (!z || iArr[2] == 1)) {
                    lteCellValue.setTac(i4);
                }
                int i5 = nVar.k;
                if (i5 != Integer.MAX_VALUE && (!z || iArr[3] == 1)) {
                    lteCellValue.setEarfcn(i5);
                }
                int i6 = nVar.l;
                if (i6 != Integer.MAX_VALUE && (!z || iArr[4] == 1)) {
                    lteCellValue.setBandwidth(i6);
                }
                int i7 = nVar.m;
                if (i7 != Integer.MAX_VALUE && (!z || iArr[5] == 1)) {
                    lteCellValue.setRssi(i7);
                }
                int i8 = nVar.n;
                if (i8 != Integer.MAX_VALUE && (!z || iArr[6] == 1)) {
                    lteCellValue.setRsrp(i8);
                }
                int i9 = nVar.o;
                if (i9 != Integer.MAX_VALUE && (!z || iArr[7] == 1)) {
                    lteCellValue.setRsrq(i9);
                }
                int i10 = nVar.p;
                if (i10 != Integer.MAX_VALUE && (!z || iArr[8] == 1)) {
                    lteCellValue.setRssnr(i10);
                }
                int i11 = nVar.q;
                if (i11 != Integer.MAX_VALUE && (!z || iArr[9] == 1)) {
                    lteCellValue.setCqi(i11);
                }
                int i12 = nVar.r;
                if (i12 != Integer.MAX_VALUE && (!z || iArr[10] == 1)) {
                    lteCellValue.setTimingadvance(i12);
                }
                cellValue.setLteCellValue(lteCellValue);
            } else if (mVar instanceof o) {
                NrCellValue nrCellValue = new NrCellValue();
                o oVar = (o) mVar;
                long j = oVar.h;
                if (j != Long.MAX_VALUE && (!z || iArr[0] == 1)) {
                    nrCellValue.setCi(j);
                }
                int i13 = oVar.i;
                if (i13 != Integer.MAX_VALUE && (!z || iArr[1] == 1)) {
                    nrCellValue.setPci(i13);
                }
                int i14 = oVar.j;
                if (i14 != Integer.MAX_VALUE && (!z || iArr[2] == 1)) {
                    nrCellValue.setTac(i14);
                }
                int i15 = oVar.k;
                if (i15 != Integer.MAX_VALUE && (!z || iArr[11] == 1)) {
                    nrCellValue.setNrarfcn(i15);
                }
                int i16 = oVar.l;
                if (i16 != Integer.MAX_VALUE && (!z || iArr[12] == 1)) {
                    nrCellValue.setSsrsrp(i16);
                }
                int i17 = oVar.m;
                if (i17 != Integer.MAX_VALUE && (!z || iArr[13] == 1)) {
                    nrCellValue.setSsrsrq(i17);
                }
                int i18 = oVar.n;
                if (i18 != Integer.MAX_VALUE && (!z || iArr[14] == 1)) {
                    nrCellValue.setSssinr(i18);
                }
                int i19 = oVar.o;
                if (i19 != Integer.MAX_VALUE && (!z || iArr[15] == 1)) {
                    nrCellValue.setCsirsrp(i19);
                }
                int i20 = oVar.p;
                if (i20 != Integer.MAX_VALUE && (!z || iArr[16] == 1)) {
                    nrCellValue.setCsirsrq(i20);
                }
                int i21 = oVar.q;
                if (i21 != Integer.MAX_VALUE && (!z || iArr[17] == 1)) {
                    nrCellValue.setCsisinr(i21);
                }
                cellValue.setNrCellValue(nrCellValue);
            }
            cellValueList.addCellValue(cellValue);
        }
        return Base64.encodeToString(cellValueList.toByteArray(), 0);
    }

    private static List<m> a(List<m> list, int i) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new d());
        list.size();
        return list.subList(0, Math.min(list.size(), i));
    }

    public synchronized void a(Context context) {
        try {
            if (this.e == null) {
                return;
            }
            try {
                this.g = (TelephonyManager) context.getSystemService("phone");
                this.i = (WifiManager) context.getSystemService("wifi");
                this.h = (ConnectivityManager) context.getSystemService("connectivity");
                if (Looper.myLooper() != null) {
                    this.j = new Handler();
                }
                this.e.a(k.a.GET_ALL_DATA);
                this.e.a(100);
                this.e.b(2000);
                this.e.b(true);
                this.e.c(30);
                this.e.a(false);
                this.e.a(context, new ArrayList());
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(TelephonyManager telephonyManager, int i, int[] iArr, boolean z, int i2) {
        if (telephonyManager != null) {
            try {
                this.k = a(telephonyManager.getAllCellInfo(), telephonyManager, i, iArr, z, i2);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        if (currentTimeMillis >= 0 && currentTimeMillis <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return false;
        }
        this.o = System.currentTimeMillis();
        if (com.baidu.location.e.o.f != 4) {
            a(0);
        }
        k kVar = this.e;
        return kVar != null && kVar.c() - j > 0;
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a(aVar, aVar2);
        }
        return false;
    }

    private boolean a(p pVar, long j) {
        long j2;
        List<ScanResult> list;
        long j3;
        try {
            j2 = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            j2 = 0;
        }
        boolean z = j2 > 0;
        if (!z || (list = pVar.f5714a) == null || list.size() == 0) {
            return false;
        }
        int size = pVar.f5714a.size();
        if (size > 16) {
            size = 16;
        }
        long j4 = 0;
        long j5 = 0;
        for (int i = 0; i < size; i++) {
            if (pVar.f5714a.get(i) != null && pVar.f5714a.get(i).level != 0 && z) {
                try {
                    j3 = (j2 - pVar.f5714a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j3 = 0;
                }
                j4 += j3;
                if (j3 > j5) {
                    j5 = j3;
                }
            }
        }
        return j5 * 1000 > j || (j4 / ((long) size)) * 1000 > j;
    }

    public boolean a(p pVar, p pVar2, float f) {
        boolean a2 = pVar2.a(pVar, f);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.c.c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || c(pVar2) - c(pVar) <= 30) {
            return a2;
        }
        return false;
    }
}
