package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class b2 {

    /* renamed from: a, reason: collision with root package name */
    public String f10041a;
    public long b;
    public String c;
    public String f;
    public v1 g;
    public volatile int d = 0;
    public volatile int e = 9;
    public CopyOnWriteArraySet<String> h = new CopyOnWriteArraySet<>();

    public b2(String str) {
        this.f10041a = str;
    }

    public boolean a(e1 e1Var) {
        c2 b = e2.a().b(this.f);
        if (this.d == 0) {
            a(b);
            Map<String, String> b2 = e1Var.b("select * from fsFileInfo where absPath=?", new String[]{this.f10041a});
            q2 q2Var = q2.STATE;
            String mapValue = DataTool.getMapValue(b2, "state");
            if (StringTool.isEmpty(mapValue)) {
                this.e = 9;
            } else {
                this.e = Integer.parseInt(mapValue);
            }
        } else if (this.d == 8 || this.d == 7) {
            a(b);
        }
        if (this.d == 7 && this.e != 7) {
            this.e = 7;
            e1Var.a(this.f10041a, this.e);
        }
        LoggerProxy.d("FsFileInfoFlyweight", "fileId=" + this.f + "--filestate=" + this.d + "--dbstate=" + this.e);
        return (this.d == 4 || this.d == 5 || this.d == 7) ? false : true;
    }

    public int a(c2 c2Var) {
        File file = new File(this.f10041a);
        if (file.exists()) {
            this.b = file.length();
            if (this.b == Long.parseLong(c2Var.b())) {
                this.c = MD5.getInstance().getBigFileMd5(file);
                Map<String, String> map = c2Var.b;
                q2 q2Var = q2.MD5;
                if (DataTool.getMapValue(map, "md5").equalsIgnoreCase(this.c)) {
                    this.d = 7;
                } else {
                    this.d = 3;
                }
            } else {
                this.d = 2;
            }
        } else {
            this.d = 1;
        }
        return this.d;
    }
}
