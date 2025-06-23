package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class cq implements cr {
    private HandlerThread nN;
    private Handler nO;
    private a nP;

    /* loaded from: classes7.dex */
    public interface a {
        void onRequestLibraryResult(String str);

        void onResourceRequest(cp cpVar);

        void onResourceResponse(byte[] bArr);
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        private cr nR;

        public b(Looper looper, cr crVar) {
            super(looper);
            this.nR = crVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.nR.handleMessage(message);
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        String nS;
        HashMap<String, String> nT;
        byte[] nU;

        public c(String str, HashMap<String, String> hashMap, byte[] bArr) {
            this.nS = str;
            this.nT = hashMap;
            this.nU = bArr;
        }
    }

    public cq() {
        cG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("err_num")) {
            if (jSONObject.getInt("err_num") == 0 && jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("cloud_recognize")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("cloud_recognize");
                    if (jSONObject3.has("url")) {
                        T(jSONObject3.getString("url"));
                        return;
                    }
                }
            }
            T(null);
        }
    }

    private void T(String str) {
        a aVar = this.nP;
        if (aVar != null) {
            aVar.onRequestLibraryResult(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096 A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3 A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005b A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:11:0x002c, B:13:0x0037, B:14:0x003b, B:15:0x004d, B:17:0x0053, B:18:0x0057, B:19:0x0066, B:21:0x006c, B:23:0x007a, B:25:0x0089, B:26:0x0090, B:28:0x0096, B:29:0x009d, B:31:0x00a3, B:32:0x00aa, B:39:0x005b, B:41:0x0061, B:42:0x0042, B:44:0x0048), top: B:10:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.lang.String r11, java.util.HashMap<java.lang.String, java.lang.String> r12, byte[] r13) {
        /*
            r10 = this;
            java.lang.String r0 = "image_md5"
            java.lang.String r1 = "ar_type"
            java.lang.String r2 = "ar_key"
            java.lang.String r3 = "err_msg"
            java.lang.String r4 = "errorMsg"
            java.lang.String r5 = "err_code"
            java.lang.String r6 = "errorNum"
            java.lang.String r7 = "data"
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r11 = com.baidu.ar.cm.a(r11, r12, r13)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L27
            com.baidu.ar.cq$a r11 = r10.nP
            if (r11 == 0) goto L26
            r12 = 0
            r11.onResourceRequest(r12)
        L26:
            return
        L27:
            com.baidu.ar.cp r12 = new com.baidu.ar.cp
            r12.<init>()
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3f
            r13.<init>(r11)     // Catch: org.json.JSONException -> L3f
            boolean r11 = r13.has(r6)     // Catch: org.json.JSONException -> L3f
            if (r11 == 0) goto L42
            int r11 = r13.getInt(r6)     // Catch: org.json.JSONException -> L3f
        L3b:
            r12.r(r11)     // Catch: org.json.JSONException -> L3f
            goto L4d
        L3f:
            r11 = move-exception
            goto Lcf
        L42:
            boolean r11 = r13.has(r5)     // Catch: org.json.JSONException -> L3f
            if (r11 == 0) goto L4d
            int r11 = r13.getInt(r5)     // Catch: org.json.JSONException -> L3f
            goto L3b
        L4d:
            boolean r11 = r13.has(r4)     // Catch: org.json.JSONException -> L3f
            if (r11 == 0) goto L5b
            java.lang.String r11 = r13.getString(r4)     // Catch: org.json.JSONException -> L3f
        L57:
            r12.setMessage(r11)     // Catch: org.json.JSONException -> L3f
            goto L66
        L5b:
            boolean r11 = r13.has(r3)     // Catch: org.json.JSONException -> L3f
            if (r11 == 0) goto L66
            java.lang.String r11 = r13.getString(r3)     // Catch: org.json.JSONException -> L3f
            goto L57
        L66:
            boolean r11 = r13.has(r7)     // Catch: org.json.JSONException -> L3f
            if (r11 == 0) goto Ld2
            java.lang.Object r11 = r13.get(r7)     // Catch: org.json.JSONException -> L3f
            java.lang.String r11 = r11.toString()     // Catch: org.json.JSONException -> L3f
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch: org.json.JSONException -> L3f
            if (r11 != 0) goto Ld2
            org.json.JSONObject r11 = r13.getJSONObject(r7)     // Catch: org.json.JSONException -> L3f
            com.baidu.ar.cs r13 = new com.baidu.ar.cs     // Catch: org.json.JSONException -> L3f
            r13.<init>()     // Catch: org.json.JSONException -> L3f
            boolean r3 = r11.has(r2)     // Catch: org.json.JSONException -> L3f
            if (r3 == 0) goto L90
            java.lang.String r2 = r11.getString(r2)     // Catch: org.json.JSONException -> L3f
            r13.setArKey(r2)     // Catch: org.json.JSONException -> L3f
        L90:
            boolean r2 = r11.has(r1)     // Catch: org.json.JSONException -> L3f
            if (r2 == 0) goto L9d
            java.lang.String r1 = r11.getString(r1)     // Catch: org.json.JSONException -> L3f
            r13.U(r1)     // Catch: org.json.JSONException -> L3f
        L9d:
            boolean r1 = r11.has(r0)     // Catch: org.json.JSONException -> L3f
            if (r1 == 0) goto Laa
            java.lang.String r11 = r11.getString(r0)     // Catch: org.json.JSONException -> L3f
            r13.V(r11)     // Catch: org.json.JSONException -> L3f
        Laa:
            r12.a(r13)     // Catch: org.json.JSONException -> L3f
            java.lang.String r11 = "qatest"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L3f
            r13.<init>()     // Catch: org.json.JSONException -> L3f
            java.lang.String r0 = "云端识图: "
            r13.append(r0)     // Catch: org.json.JSONException -> L3f
            long r0 = java.lang.System.currentTimeMillis()     // Catch: org.json.JSONException -> L3f
            long r0 = r0 - r8
            r13.append(r0)     // Catch: org.json.JSONException -> L3f
            java.lang.String r0 = " ms"
            r13.append(r0)     // Catch: org.json.JSONException -> L3f
            java.lang.String r13 = r13.toString()     // Catch: org.json.JSONException -> L3f
            android.util.Log.e(r11, r13)     // Catch: org.json.JSONException -> L3f
            goto Ld2
        Lcf:
            r11.printStackTrace()
        Ld2:
            com.baidu.ar.cq$a r11 = r10.nP
            if (r11 == 0) goto Ld9
            r11.onResourceRequest(r12)
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.cq.b(java.lang.String, java.util.HashMap, byte[]):void");
    }

    private void cG() {
        if (isRunning()) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CloudSearchThread");
        this.nN = handlerThread;
        handlerThread.start();
        this.nO = new b(this.nN.getLooper(), this);
    }

    private void cI() {
        cm.a(new fa() { // from class: com.baidu.ar.cq.2
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                if (cq.this.nP != null) {
                    cq.this.nP.onRequestLibraryResult(null);
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    String content = iHttpResponse.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return;
                    }
                    cq.this.S(content);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void e(byte[] bArr) {
        cm.a(new fa() { // from class: com.baidu.ar.cq.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                if (cq.this.nP != null) {
                    cq.this.nP.onResourceResponse(null);
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    InputStream stream = iHttpResponse.getStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = stream.read(bArr2);
                        if (read == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    stream.close();
                    if (cq.this.nP != null) {
                        cq.this.nP.onResourceResponse(byteArray);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, bArr);
    }

    private boolean isRunning() {
        HandlerThread handlerThread = this.nN;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void cH() {
        Handler handler = this.nO;
        if (handler != null) {
            handler.removeMessages(1007);
            Handler handler2 = this.nO;
            handler2.sendMessage(handler2.obtainMessage(1009));
        }
    }

    public void d(byte[] bArr) {
        Handler handler = this.nO;
        if (handler != null) {
            handler.removeMessages(1007);
            c cVar = new c(kw.hB(), null, bArr);
            Handler handler2 = this.nO;
            handler2.sendMessage(handler2.obtainMessage(1008, cVar));
        }
    }

    @Override // com.baidu.ar.cr
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1001) {
            c cVar = (c) message.obj;
            b(cVar.nS, cVar.nT, cVar.nU);
        } else if (i == 1008) {
            e(((c) message.obj).nU);
        } else {
            if (i != 1009) {
                return;
            }
            cI();
        }
    }

    public void release() {
        HandlerThread handlerThread = this.nN;
        if (handlerThread != null) {
            handlerThread.getLooper().quit();
        }
        this.nP = null;
        this.nN = null;
        this.nO = null;
    }

    public void a(a aVar) {
        this.nP = aVar;
    }
}
