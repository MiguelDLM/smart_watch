package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.recg.ImgRecognitionClient;
import com.baidu.ar.recg.RecognitionResult;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class hm implements hg {
    private static final String TAG = "hm";
    private static volatile boolean wu = false;
    private static volatile boolean wv = false;
    private HandlerThread nN;
    private Handler nO;
    private hl ws;
    private List<hk> wt;

    /* loaded from: classes7.dex */
    public class a {
        hi wf;
        String ww;

        public a(hi hiVar, String str) {
            this.wf = hiVar;
            this.ww = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        private hg wy;

        public b(Looper looper, hg hgVar) {
            super(looper);
            this.wy = hgVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.wy.handleMessage(message);
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        String nS;
        HashMap<String, Object> nT;

        public c(String str, HashMap<String, Object> hashMap) {
            this.nS = str;
            this.nT = hashMap;
        }
    }

    public hm() {
        cG();
    }

    private static void F(boolean z) {
        wv = z;
    }

    private void b(int i, int i2, byte[] bArr) {
        RecognitionResult recognitionResult;
        String str;
        boolean z;
        String str2;
        List<hk> list;
        if (wu) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                recognitionResult = ImgRecognitionClient.recogniseImage(bArr, i, i2);
            } catch (Throwable unused) {
                recognitionResult = null;
            }
            Log.e("qatest", "本地识图: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (recognitionResult != null && (list = this.wt) != null && list.size() > 0) {
                String str3 = recognitionResult.fileName;
                if (!TextUtils.isEmpty(str3)) {
                    for (hk hkVar : this.wt) {
                        if (str3.equals(hkVar.fd())) {
                            str = hkVar.getArKey();
                            str2 = hkVar.cJ();
                            z = true;
                            break;
                        }
                    }
                }
            }
            str = "";
            z = false;
            str2 = "";
            if (this.ws == null || wv) {
                return;
            }
            this.ws.onYuvImageSearch(z, str, str2);
        }
    }

    private void br(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            if (file.exists()) {
                List<hk> bs = bs(km.h(file));
                this.wt = bs;
                if (bs != null) {
                    if (bs.size() > 0) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hl hlVar = this.ws;
        if (hlVar != null) {
            hlVar.onFeatureJsonParse(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.baidu.ar.hk> bs(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.hm.bs(java.lang.String):java.util.List");
    }

    private void bt(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            wu = true;
            hl hlVar = this.ws;
            if (hlVar != null) {
                hlVar.onFeatureFilesInit(true);
            }
        } catch (Throwable unused) {
            hl hlVar2 = this.ws;
            if (hlVar2 != null) {
                hlVar2.onFeatureFilesInit(false);
            }
        }
    }

    private void c(hi hiVar, String str) {
        File r = r(str, hiVar.eZ().substring(hiVar.eZ().lastIndexOf("/")));
        boolean a2 = (!r.exists() || r.length() <= 0) ? false : a(r.getParentFile(), r);
        hl hlVar = this.ws;
        if (hlVar != null) {
            hlVar.onFeatureFilesUnzip(a2);
        }
    }

    private void cG() {
        if (isRunning()) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("FeatureSearchThread");
        this.nN = handlerThread;
        handlerThread.start();
        this.nO = new b(this.nN.getLooper(), this);
    }

    private void cb() {
        HandlerThread handlerThread = this.nN;
        if (handlerThread != null) {
            handlerThread.getLooper().quit();
        }
        hl hlVar = this.ws;
        if (hlVar != null) {
            hlVar.onThreadQuit();
            this.ws = null;
        }
        this.nN = null;
        this.nO = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r3.equals(r7.fa()) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.baidu.ar.hi r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.eZ()
            java.lang.String r1 = r7.eZ()
            java.lang.String r2 = "/"
            int r1 = r1.lastIndexOf(r2)
            java.lang.String r0 = r0.substring(r1)
            java.io.File r8 = r6.r(r8, r0)
            com.baidu.ar.km.f(r8)
            com.baidu.ar.ihttp.Downloader r0 = new com.baidu.ar.ihttp.Downloader
            java.lang.String r1 = r7.eZ()
            r0.<init>(r1)
            r1 = 1
            r2 = 0
            java.lang.String r3 = r8.getAbsolutePath()     // Catch: java.io.IOException -> L2e com.baidu.ar.ihttp.HttpException -> L30
            r4 = 0
            r0.download(r3, r4)     // Catch: java.io.IOException -> L2e com.baidu.ar.ihttp.HttpException -> L30
            r0 = 1
            goto L35
        L2e:
            r0 = move-exception
            goto L31
        L30:
            r0 = move-exception
        L31:
            r0.printStackTrace()
            r0 = 0
        L35:
            if (r0 == 0) goto L66
            java.lang.String r3 = com.baidu.ar.kp.o(r8)     // Catch: java.lang.Exception -> L4c
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L4c
            if (r4 != 0) goto L4e
            java.lang.String r4 = r7.fa()     // Catch: java.lang.Exception -> L4c
            boolean r0 = r3.equals(r4)     // Catch: java.lang.Exception -> L4c
            if (r0 == 0) goto L4e
            goto L4f
        L4c:
            r1 = move-exception
            goto L63
        L4e:
            r1 = 0
        L4f:
            if (r1 != 0) goto L61
            com.baidu.ar.km.f(r8)     // Catch: java.lang.Exception -> L5c
            java.lang.String r0 = com.baidu.ar.hm.TAG     // Catch: java.lang.Exception -> L5c
            java.lang.String r2 = "handleDownloadResource md5 failed"
            com.baidu.ar.kf.b(r0, r2)     // Catch: java.lang.Exception -> L5c
            goto L61
        L5c:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L63
        L61:
            r0 = r1
            goto L66
        L63:
            r1.printStackTrace()
        L66:
            if (r0 == 0) goto L79
            java.io.File r0 = r8.getParentFile()
            boolean r0 = r6.a(r0, r8)
            if (r0 != 0) goto L79
            java.lang.String r8 = com.baidu.ar.hm.TAG
            java.lang.String r1 = "handleDownloadResource unzip failed"
            com.baidu.ar.kf.b(r8, r1)
        L79:
            com.baidu.ar.hl r8 = r6.ws
            if (r8 == 0) goto L84
            java.lang.String r7 = r7.fa()
            r8.onResourceDownload(r0, r7)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.hm.d(com.baidu.ar.hi, java.lang.String):void");
    }

    private void ff() {
        List<hk> list = this.wt;
        if (list != null) {
            list.clear();
            this.wt = null;
        }
        wu = false;
        hl hlVar = this.ws;
        if (hlVar != null) {
            hlVar.onFeaturesClear(true);
        }
    }

    private boolean isRunning() {
        HandlerThread handlerThread = this.nN;
        return handlerThread != null && handlerThread.isAlive();
    }

    private File r(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + str2);
    }

    public void a(int i, int i2, byte[] bArr) {
        Handler handler = this.nO;
        if (handler != null) {
            handler.removeMessages(1006);
            Handler handler2 = this.nO;
            handler2.sendMessage(handler2.obtainMessage(1006, i, i2, bArr));
        }
    }

    public void fe() {
        F(true);
        Handler handler = this.nO;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1005));
        }
    }

    @Override // com.baidu.ar.hg
    public void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        switch (message.what) {
            case 1001:
                c cVar = (c) message.obj;
                c(cVar.nS, cVar.nT);
                return;
            case 1002:
                a aVar = (a) message.obj;
                d(aVar.wf, aVar.ww);
                return;
            case 1003:
                br((String) message.obj);
                return;
            case 1004:
                bt((String) message.obj);
                return;
            case 1005:
                ff();
                return;
            case 1006:
                b(message.arg1, message.arg2, (byte[]) message.obj);
                return;
            case 1007:
                cb();
                return;
            case 1008:
                a aVar2 = (a) message.obj;
                c(aVar2.wf, aVar2.ww);
                return;
            default:
                return;
        }
    }

    public void onDetected(gy gyVar) {
        dc dcVar;
        String str;
        String str2;
        List<hk> list;
        if (gyVar == null || gyVar.eR() == null) {
            return;
        }
        boolean z = true;
        if (gyVar.eR().size() >= 1 && (dcVar = gyVar.eR().get(0)) != null && (dcVar instanceof hf)) {
            String fileName = ((hf) dcVar).eW().getFileName();
            if (!TextUtils.isEmpty(fileName) && (list = this.wt) != null) {
                for (hk hkVar : list) {
                    if (fileName.equals(hkVar.fd())) {
                        str = hkVar.getArKey();
                        str2 = hkVar.cJ();
                        break;
                    }
                }
            }
            str = "";
            str2 = "";
            z = false;
            if (this.ws == null || wv) {
                return;
            }
            this.ws.onYuvImageSearch(z, str, str2);
        }
    }

    public void q(String str, String str2) {
        F(false);
        Handler handler = this.nO;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, str));
            Handler handler2 = this.nO;
            handler2.sendMessage(handler2.obtainMessage(1004, str2));
        }
    }

    public void quit() {
        Handler handler = this.nO;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1007));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[Catch: JSONException -> 0x0078, TryCatch #0 {JSONException -> 0x0078, blocks: (B:14:0x0060, B:16:0x006d, B:19:0x0074, B:20:0x0088, B:22:0x008e, B:23:0x0092, B:24:0x00a1, B:26:0x00a7, B:28:0x00b6, B:29:0x00bd, B:31:0x00c3, B:32:0x00ca, B:34:0x00d0, B:35:0x00d7, B:42:0x0096, B:44:0x009c, B:45:0x007a, B:47:0x0080), top: B:13:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7 A[Catch: JSONException -> 0x0078, TryCatch #0 {JSONException -> 0x0078, blocks: (B:14:0x0060, B:16:0x006d, B:19:0x0074, B:20:0x0088, B:22:0x008e, B:23:0x0092, B:24:0x00a1, B:26:0x00a7, B:28:0x00b6, B:29:0x00bd, B:31:0x00c3, B:32:0x00ca, B:34:0x00d0, B:35:0x00d7, B:42:0x0096, B:44:0x009c, B:45:0x007a, B:47:0x0080), top: B:13:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096 A[Catch: JSONException -> 0x0078, TryCatch #0 {JSONException -> 0x0078, blocks: (B:14:0x0060, B:16:0x006d, B:19:0x0074, B:20:0x0088, B:22:0x008e, B:23:0x0092, B:24:0x00a1, B:26:0x00a7, B:28:0x00b6, B:29:0x00bd, B:31:0x00c3, B:32:0x00ca, B:34:0x00d0, B:35:0x00d7, B:42:0x0096, B:44:0x009c, B:45:0x007a, B:47:0x0080), top: B:13:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.lang.String r13, java.util.HashMap<java.lang.String, java.lang.Object> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "md5"
            java.lang.String r1 = "ar_code_url"
            java.lang.String r2 = "url"
            java.lang.String r3 = "data"
            java.lang.String r4 = "err_msg"
            java.lang.String r5 = "errorMsg"
            java.lang.String r6 = "err_code"
            java.lang.String r7 = "errorNum"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            if (r14 == 0) goto L4c
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L20:
            boolean r9 = r14.hasNext()
            java.lang.String r10 = "&"
            if (r9 == 0) goto L45
            java.lang.Object r9 = r14.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r11 = r9.getKey()
            r8.append(r11)
            java.lang.String r11 = "="
            r8.append(r11)
            java.lang.Object r9 = r9.getValue()
            r8.append(r9)
            r8.append(r10)
            goto L20
        L45:
            int r14 = r8.lastIndexOf(r10)
            r8.deleteCharAt(r14)
        L4c:
            java.lang.String r14 = r8.toString()
            java.lang.String r13 = com.baidu.ar.kn.w(r13, r14)
            com.baidu.ar.hj r14 = new com.baidu.ar.hj
            r14.<init>()
            boolean r8 = android.text.TextUtils.isEmpty(r13)
            if (r8 == 0) goto L60
            return
        L60:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: org.json.JSONException -> L78
            r8.<init>(r13)     // Catch: org.json.JSONException -> L78
            boolean r13 = r8.has(r7)     // Catch: org.json.JSONException -> L78
            r9 = 0
            r10 = 1
            if (r13 == 0) goto L7a
            int r13 = r8.getInt(r7)     // Catch: org.json.JSONException -> L78
            if (r13 != 0) goto L74
            r9 = 1
        L74:
            r14.E(r9)     // Catch: org.json.JSONException -> L78
            goto L88
        L78:
            r13 = move-exception
            goto Ldb
        L7a:
            boolean r13 = r8.has(r6)     // Catch: org.json.JSONException -> L78
            if (r13 == 0) goto L88
            int r13 = r8.getInt(r6)     // Catch: org.json.JSONException -> L78
            if (r13 != 0) goto L74
            r9 = 1
            goto L74
        L88:
            boolean r13 = r8.has(r5)     // Catch: org.json.JSONException -> L78
            if (r13 == 0) goto L96
            java.lang.String r13 = r8.getString(r5)     // Catch: org.json.JSONException -> L78
        L92:
            r14.bd(r13)     // Catch: org.json.JSONException -> L78
            goto La1
        L96:
            boolean r13 = r8.has(r4)     // Catch: org.json.JSONException -> L78
            if (r13 == 0) goto La1
            java.lang.String r13 = r8.getString(r4)     // Catch: org.json.JSONException -> L78
            goto L92
        La1:
            boolean r13 = r8.has(r3)     // Catch: org.json.JSONException -> L78
            if (r13 == 0) goto Lde
            org.json.JSONObject r13 = r8.getJSONObject(r3)     // Catch: org.json.JSONException -> L78
            com.baidu.ar.hi r3 = new com.baidu.ar.hi     // Catch: org.json.JSONException -> L78
            r3.<init>()     // Catch: org.json.JSONException -> L78
            boolean r4 = r13.has(r2)     // Catch: org.json.JSONException -> L78
            if (r4 == 0) goto Lbd
            java.lang.String r2 = r13.getString(r2)     // Catch: org.json.JSONException -> L78
            r3.bb(r2)     // Catch: org.json.JSONException -> L78
        Lbd:
            boolean r2 = r13.has(r1)     // Catch: org.json.JSONException -> L78
            if (r2 == 0) goto Lca
            java.lang.String r1 = r13.getString(r1)     // Catch: org.json.JSONException -> L78
            r3.ba(r1)     // Catch: org.json.JSONException -> L78
        Lca:
            boolean r1 = r13.has(r0)     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto Ld7
            java.lang.String r13 = r13.getString(r0)     // Catch: org.json.JSONException -> L78
            r3.bc(r13)     // Catch: org.json.JSONException -> L78
        Ld7:
            r14.a(r3)     // Catch: org.json.JSONException -> L78
            goto Lde
        Ldb:
            r13.printStackTrace()
        Lde:
            com.baidu.ar.hl r13 = r12.ws
            if (r13 == 0) goto Le5
            r13.onResourceRequest(r14)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.hm.c(java.lang.String, java.util.HashMap):void");
    }

    public void a(hi hiVar, String str) {
        if (this.nO != null) {
            a aVar = new a(hiVar, str);
            Handler handler = this.nO;
            handler.sendMessage(handler.obtainMessage(1002, aVar));
        }
    }

    public void b(hi hiVar, String str) {
        if (this.nO != null) {
            a aVar = new a(hiVar, str);
            Handler handler = this.nO;
            handler.sendMessage(handler.obtainMessage(1008, aVar));
        }
    }

    public void a(hl hlVar) {
        this.ws = hlVar;
    }

    public void b(String str, HashMap<String, Object> hashMap) {
        Handler handler = this.nO;
        if (handler != null) {
            handler.removeMessages(1007);
            c cVar = new c(str, hashMap);
            Handler handler2 = this.nO;
            handler2.sendMessage(handler2.obtainMessage(1001, cVar));
        }
    }

    private boolean a(File file, File file2) {
        km.a(new File(file.toString() + "/fea"));
        boolean b2 = kx.b(file2, file);
        if (!b2) {
            kf.b(TAG, "handleDownloadResource unzip failed");
        }
        return b2;
    }
}
