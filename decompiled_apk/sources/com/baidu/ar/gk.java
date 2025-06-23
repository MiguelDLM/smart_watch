package com.baidu.ar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class gk implements gh {
    private Context mContext;
    private ConcurrentHashMap<String, a> uM;
    private boolean isDebug = false;
    private boolean mh = false;
    private String uN = "";
    private boolean dm = false;
    private boolean dn = false;
    private Thread uO = new Thread(new Runnable() { // from class: com.baidu.ar.gk.2
        @Override // java.lang.Runnable
        public void run() {
            while (!gk.this.dn && !gk.this.mh) {
                if (gk.this.uM.entrySet().size() > 0) {
                    if (gk.this.eF()) {
                        gk.this.eG();
                    } else {
                        gk.this.uN = "lostConnect";
                    }
                }
            }
        }
    });

    /* loaded from: classes7.dex */
    public static class a {
        String uT;
        String uU;
        gi uV;
    }

    private void b(final String str, final String str2, final gi giVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest != null) {
            newRequest.setMethod("GET").setUrl(str).setBody((byte[]) null);
            newRequest.enqueue(new fa() { // from class: com.baidu.ar.gk.1
                @Override // com.baidu.ar.fa
                public void a(HttpException httpException) {
                    giVar.aQ(str);
                    gk.this.a(str, str2, giVar);
                }

                @Override // com.baidu.ar.fa
                public void a(IHttpResponse iHttpResponse) {
                    try {
                        File file = new File(str2);
                        file.getParentFile().mkdirs();
                        InputStream stream = iHttpResponse.getStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = stream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        stream.close();
                        if (file.exists()) {
                            giVar.aP(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        giVar.aQ(str);
                        gk.this.a(str, str2, giVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eG() {
        Iterator<Map.Entry<String, a>> it = this.uM.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            b(value.uT, value.uU, value.uV);
            it.remove();
        }
    }

    public boolean eF() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    @Override // com.baidu.ar.gh
    public void h(Context context) {
        this.mContext = context;
        this.uM = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.ar.gh
    public void pause() {
        this.dn = true;
        if (this.isDebug) {
            kf.b("OBRDownloader", "OBRDownloader stopAllTask");
        }
        this.uN = "pause";
    }

    @Override // com.baidu.ar.gh
    public void release() {
        this.mh = true;
        if (this.isDebug) {
            kf.c("OBRModule", "OBRDownloader release");
        }
        this.uN = "release";
        HttpFactory.release();
    }

    @Override // com.baidu.ar.gh
    public void resume() {
        this.dm = true;
        this.dn = false;
        this.mh = false;
        if (com.huawei.openalliance.ad.constant.aw.ag.equals(this.uN)) {
            return;
        }
        if (this.isDebug) {
            kf.b("OBRDownloader", "OBRDownloader resumeAllTask");
        }
        this.uN = com.huawei.openalliance.ad.constant.aw.ag;
    }

    @Override // com.baidu.ar.gh
    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    @Override // com.baidu.ar.gh
    public void a(String str, String str2, gi giVar) {
        b(str, str2, giVar);
    }
}
