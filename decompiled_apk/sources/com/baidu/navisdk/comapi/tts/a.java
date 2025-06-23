package com.baidu.navisdk.comapi.tts;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f6752a = Collections.synchronizedMap(new LinkedHashMap());
    private TTSPlayerControl.e b = new c();

    /* renamed from: com.baidu.navisdk.comapi.tts.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0186a extends f<d, String> {
        public C0186a(String str, d dVar) {
            super(str, dVar);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (getInData() != null && !TextUtils.isEmpty(getInData().c)) {
                g.TTS.e("TTSJniStat", "add, recordPstrTag = " + getInData().c);
                a.this.f6752a.put(getInData().b, getInData().c);
                return null;
            }
            g.TTS.e("add", "pStrTag is null");
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f<d, String> {
        public b(String str, d dVar) {
            super(str, dVar);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            g gVar = g.TTS;
            if (gVar.d()) {
                gVar.e("TTSJniStat", "recordAddResult(),execute,speechInfo" + getInData());
            }
            if (getInData() == null || getInData().d == 1) {
                return null;
            }
            if (a.this.f6752a.containsKey(getInData().b)) {
                a aVar = a.this;
                aVar.a((String) aVar.f6752a.get(getInData().b), getInData().d);
                a.this.f6752a.remove(getInData().b);
                return null;
            }
            if (!gVar.d()) {
                return null;
            }
            gVar.e("TTSJniStat", "recordAddResult(),execute,no speechId = " + getInData().b);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends TTSPlayerControl.f {

        /* renamed from: com.baidu.navisdk.comapi.tts.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0187a extends f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6756a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0187a(String str, String str2, String str3) {
                super(str, str2);
                this.f6756a = str3;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                g gVar = g.TTS;
                if (gVar.d()) {
                    gVar.e("TTSJniStat", "onPlayEnd speechId = " + this.f6756a + " statMap =" + a.this.f6752a.toString());
                }
                if (a.this.f6752a.containsKey(this.f6756a)) {
                    Iterator it = a.this.f6752a.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        it.remove();
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (!TextUtils.equals(str, this.f6756a)) {
                            a.this.a(str2, 0);
                        } else {
                            a.this.a(str2, 1);
                            break;
                        }
                    }
                    return null;
                }
                if (gVar.d()) {
                    gVar.e("TTSJniStat", "onPlayEnd, speechId not contains = " + this.f6756a);
                }
                return null;
            }
        }

        public c() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            com.baidu.navisdk.util.worker.c.a().b(new C0187a("TTSJniStat onPlayEnd", null, str), new e(101, 0));
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f6757a;
        private String b;
        private String c;
        private int d;
        private int e;

        public d(String str, String str2, String str3, int i, int i2) {
            this.f6757a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = i2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("SpeechInfo{");
            stringBuffer.append("speech='");
            stringBuffer.append(this.f6757a);
            stringBuffer.append('\'');
            stringBuffer.append(", speechId='");
            stringBuffer.append(this.b);
            stringBuffer.append('\'');
            stringBuffer.append(", pStrTag='");
            stringBuffer.append(this.c);
            stringBuffer.append('\'');
            stringBuffer.append(", result=");
            stringBuffer.append(this.d);
            stringBuffer.append(", bPreempt=");
            stringBuffer.append(this.e);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public void b(d dVar) {
        com.baidu.navisdk.util.worker.c.a().b(new b("TTSJniStat recordAddResult", dVar), new e(101, 0));
    }

    public void a() {
        TTSPlayerControl.addTTSPlayStateListener(this.b);
    }

    public void a(d dVar) {
        com.baidu.navisdk.util.worker.c.a().b(new C0186a("TTSJniStat add", dVar), new e(101, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        g gVar = g.TTS;
        if (gVar.d()) {
            gVar.e("TTSJniStat", "setJNIPlayResult, pstrTag:" + str + ",reason:" + i);
        }
        if (i == 1) {
            JNIStatisticsControl.sInstance.setTTSTextPlayResult(str, "Success");
            return;
        }
        JNIStatisticsControl.sInstance.setTTSTextPlayResult(str, "Fail_" + i);
    }
}
