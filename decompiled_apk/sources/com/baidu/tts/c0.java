package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.d0;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c0 extends a0 {
    public r4 b = null;
    public f0 c;
    public d0 d;
    public b0 e;
    public TtsError f;
    public p2 g;
    public p h;

    /* loaded from: classes8.dex */
    public class a implements p {
        public a() {
        }

        @Override // com.baidu.tts.p
        public void a(x4 x4Var) {
        }

        @Override // com.baidu.tts.p
        public void onError(x4 x4Var) {
        }

        @Override // com.baidu.tts.p
        public void onSynthesizeDataArrived(x4 x4Var) {
            p pVar = c0.this.f10030a;
            if (pVar != null) {
                pVar.onSynthesizeDataArrived(x4Var);
            }
        }

        @Override // com.baidu.tts.p
        public void onSynthesizeFinished(x4 x4Var) {
            p pVar = c0.this.f10030a;
            if (pVar != null) {
                pVar.onSynthesizeFinished(x4Var);
            }
        }

        @Override // com.baidu.tts.p
        public void onSynthesizeStart(x4 x4Var) {
        }
    }

    public c0(p2 p2Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.g = p2Var;
        this.h = new a();
        if (p2Var != p2.OFFLINE) {
            this.c = new f0();
        }
        if (this.g != p2.ONLINE) {
            this.d = new d0();
        }
        if (this.g == p2.MIX) {
            this.e = new b0();
        }
    }

    @Override // com.baidu.tts.a0
    public TtsError a() {
        f0 f0Var = this.c;
        if (f0Var != null) {
            f0Var.a(this.h);
            this.c.getClass();
        }
        d0 d0Var = this.d;
        if (d0Var != null) {
            d0Var.a(this.h);
            TtsError a2 = this.d.a();
            this.f = a2;
            if (a2 != null && this.g == p2.OFFLINE) {
                return c3.a().a(x2.V);
            }
        }
        i2.a().a(this.b.c(), false, null);
        if (this.f != null) {
            return c3.a().a(x2.q0);
        }
        return null;
    }

    @Override // com.baidu.tts.a0
    public TtsError b() {
        d0 d0Var = this.d;
        if (d0Var != null) {
            d0Var.b();
        }
        b0 b0Var = this.e;
        if (b0Var != null) {
            b0Var.f10039a = null;
        }
        return null;
    }

    @Override // com.baidu.tts.a0
    public int b(u4 u4Var) {
        d0 d0Var = this.d;
        if (d0Var == null) {
            return -1;
        }
        return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(u4Var.f10178a), d0Var.c[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.a0
    public <AllSynthesizerParams> void a(AllSynthesizerParams allsynthesizerparams) {
        r4 r4Var = (r4) allsynthesizerparams;
        this.b = r4Var;
        if (this.c != null) {
            e0 e0Var = r4Var.f10162a;
            e0Var.getClass();
            this.c.a((f0) e0Var);
        }
        d0 d0Var = this.d;
        if (d0Var != null) {
            d0Var.b = this.b.b;
        }
        b0 b0Var = this.e;
        if (b0Var != null) {
            b0Var.f10039a = this.b;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:258:0x01ed, code lost:
    
        if (r0 != 0) goto L165;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x016f A[Catch: Exception -> 0x012d, TryCatch #1 {Exception -> 0x012d, blocks: (B:104:0x0122, B:107:0x0128, B:109:0x0141, B:111:0x0147, B:230:0x016f, B:235:0x0185, B:238:0x0198, B:241:0x01a9, B:246:0x01be, B:248:0x01d8, B:251:0x01dd, B:253:0x01e1, B:256:0x01e7, B:265:0x017a, B:268:0x0130, B:272:0x0136, B:274:0x013e), top: B:103:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01d8 A[Catch: Exception -> 0x012d, TryCatch #1 {Exception -> 0x012d, blocks: (B:104:0x0122, B:107:0x0128, B:109:0x0141, B:111:0x0147, B:230:0x016f, B:235:0x0185, B:238:0x0198, B:241:0x01a9, B:246:0x01be, B:248:0x01d8, B:251:0x01dd, B:253:0x01e1, B:256:0x01e7, B:265:0x017a, B:268:0x0130, B:272:0x0136, B:274:0x013e), top: B:103:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01e7 A[Catch: Exception -> 0x012d, TRY_LEAVE, TryCatch #1 {Exception -> 0x012d, blocks: (B:104:0x0122, B:107:0x0128, B:109:0x0141, B:111:0x0147, B:230:0x016f, B:235:0x0185, B:238:0x0198, B:241:0x01a9, B:246:0x01be, B:248:0x01d8, B:251:0x01dd, B:253:0x01e1, B:256:0x01e7, B:265:0x017a, B:268:0x0130, B:272:0x0136, B:274:0x013e), top: B:103:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0197  */
    @Override // com.baidu.tts.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.tts.aop.tts.TtsError a(com.baidu.tts.y4 r12) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.c0.a(com.baidu.tts.y4):com.baidu.tts.aop.tts.TtsError");
    }

    @Override // com.baidu.tts.a0
    public int a(u4 u4Var) {
        d0 d0Var = this.d;
        if (d0Var == null) {
            return -1;
        }
        return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(d0Var.c[0]);
    }

    @Override // com.baidu.tts.a0
    public int a(w4 w4Var) {
        String str;
        int bdTTSReInitData;
        if (this.g == p2.ONLINE) {
            LoggerProxy.e("MultiModeSynthesizer", "current mode not support to use loadModel");
            return -1;
        }
        String str2 = w4Var.f10186a;
        String str3 = w4Var.b;
        String str4 = w4Var.c;
        String str5 = w4Var.d;
        int i = 0;
        if (this.f == null) {
            d0 d0Var = this.d;
            d0Var.getClass();
            boolean isEmpty = TextUtils.isEmpty(str4);
            boolean isEmpty2 = TextUtils.isEmpty(str3);
            boolean isEmpty3 = TextUtils.isEmpty(str2);
            boolean isEmpty4 = TextUtils.isEmpty(str5);
            if (isEmpty2 && isEmpty3) {
                x2 x2Var = x2.D0;
                i = -406;
            } else {
                Context c = e3.e().c();
                int bdTTSReInitData2 = !isEmpty3 ? EmbeddedSynthesizerEngine.bdTTSReInitData(c, ResourceTools.stringToByteArrayAddNull(str2), null, ResourceTools.stringToByteArrayAddNull(d0Var.f), d0Var.c[0]) : 0;
                if (isEmpty2) {
                    str = "OfflineSynthesizer";
                } else {
                    byte[] stringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(str3);
                    byte[] stringToByteArrayAddNull2 = ResourceTools.stringToByteArrayAddNull(str4);
                    byte[] stringToByteArrayAddNull3 = ResourceTools.stringToByteArrayAddNull(d0Var.f);
                    if (!StringTool.isEmpty(str3)) {
                        d0Var.a(str3);
                    }
                    if (isEmpty) {
                        str = "OfflineSynthesizer";
                        bdTTSReInitData = EmbeddedSynthesizerEngine.bdTTSReInitData(c, stringToByteArrayAddNull, null, stringToByteArrayAddNull3, d0Var.c[0]);
                    } else {
                        str = "OfflineSynthesizer";
                        bdTTSReInitData = EmbeddedSynthesizerEngine.bdTTSReInitData(c, stringToByteArrayAddNull2, stringToByteArrayAddNull, stringToByteArrayAddNull3, d0Var.c[0]);
                    }
                    if (bdTTSReInitData == 0) {
                        if (!StringTool.isEmpty(str3) && d0Var.b != null) {
                            d0Var.b.a(String.valueOf(EmbeddedSynthesizerEngine.bdTTSGetParam(d0Var.c[0], 6)));
                        }
                        if (!isEmpty4) {
                            try {
                                JSONObject jSONObject = new JSONObject(str5);
                                String optString = jSONObject.optString("model_speaker_id");
                                String optString2 = jSONObject.optString("model_style_id");
                                LoggerProxy.d(str, "set model_speaker_id: " + optString);
                                LoggerProxy.d(str, "set model_style_id: " + optString2);
                                try {
                                    if (!TextUtils.isEmpty(optString)) {
                                        EmbeddedSynthesizerEngine.bdTTSSetParam(d0Var.c[0], 9, Long.parseLong(optString));
                                    }
                                    if (!TextUtils.isEmpty(optString2)) {
                                        EmbeddedSynthesizerEngine.bdTTSSetParam(d0Var.c[0], 10, Long.parseLong(optString2));
                                    }
                                } catch (Exception e) {
                                    LoggerProxy.d(str, "parseLong exception = " + e.getMessage());
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    i = bdTTSReInitData;
                }
                LoggerProxy.d(str, "load model  textRet: " + bdTTSReInitData2 + " , speechRet:" + i);
                i = bdTTSReInitData2 + i;
            }
            if (i == 0) {
                a(str2, str3, str4, str5);
            }
        } else {
            a(str2, str3, str4, str5);
            TtsError a2 = this.d.a();
            this.f = a2;
            if (a2 != null) {
                return a2.getDetailCode();
            }
        }
        return i;
    }

    @Override // com.baidu.tts.a0
    public int a(v4 v4Var) {
        d0 d0Var = this.d;
        if (d0Var == null) {
            return -1;
        }
        return d0Var.a(v4Var);
    }

    @Override // com.baidu.tts.a0
    public int a(HashMap<String, String> hashMap) {
        String str;
        if (this.g == p2.ONLINE) {
            LoggerProxy.e("MultiModeSynthesizer", "current mode not support to use loadModel");
            return -1;
        }
        String str2 = hashMap.get(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE);
        String str3 = hashMap.get(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE);
        String str4 = hashMap.get(SpeechSynthesizer.PARAM_TTS_EXT_SPEECH_MODEL_FILE);
        String str5 = hashMap.get(SpeechSynthesizer.PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR);
        int i = 0;
        if (this.f == null) {
            d0 d0Var = this.d;
            d0Var.getClass();
            boolean isEmpty = TextUtils.isEmpty(str4);
            boolean isEmpty2 = TextUtils.isEmpty(str3);
            boolean isEmpty3 = TextUtils.isEmpty(str2);
            boolean isEmpty4 = TextUtils.isEmpty(str5);
            if (isEmpty2 && isEmpty3) {
                x2 x2Var = x2.D0;
                i = -406;
            } else {
                Context c = e3.e().c();
                byte[] stringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(str2);
                byte[] stringToByteArrayAddNull2 = ResourceTools.stringToByteArrayAddNull(str3);
                byte[] stringToByteArrayAddNull3 = ResourceTools.stringToByteArrayAddNull(str4);
                byte[] stringToByteArrayAddNull4 = ResourceTools.stringToByteArrayAddNull(d0Var.f);
                if (!StringTool.isEmpty(str3)) {
                    str = d0Var.a(str3);
                } else {
                    str = "";
                }
                String str6 = str;
                if (isEmpty3) {
                    stringToByteArrayAddNull = null;
                }
                int loadSuitedEngine = EmbeddedSynthesizerEngine.loadSuitedEngine(c, stringToByteArrayAddNull4, stringToByteArrayAddNull, isEmpty2 ? null : stringToByteArrayAddNull2, isEmpty ? null : stringToByteArrayAddNull3, str6, d0Var.c[0]);
                LoggerProxy.d("OfflineSynthesizer", "loadSuitedModel ret=" + loadSuitedEngine);
                if (!isEmpty2 && loadSuitedEngine == 0) {
                    if (!StringTool.isEmpty(str3) && d0Var.b != null) {
                        d0Var.b.a(String.valueOf(EmbeddedSynthesizerEngine.bdTTSGetParam(d0Var.c[0], 6)));
                    }
                    if (!isEmpty4) {
                        try {
                            JSONObject jSONObject = new JSONObject(str5);
                            String optString = jSONObject.optString("model_speaker_id");
                            String optString2 = jSONObject.optString("model_style_id");
                            LoggerProxy.d("OfflineSynthesizer", "set model_speaker_id: " + optString);
                            LoggerProxy.d("OfflineSynthesizer", "set model_style_id: " + optString2);
                            try {
                                if (!TextUtils.isEmpty(optString)) {
                                    EmbeddedSynthesizerEngine.bdTTSSetParam(d0Var.c[0], 9, Long.parseLong(optString));
                                }
                                if (!TextUtils.isEmpty(optString2)) {
                                    EmbeddedSynthesizerEngine.bdTTSSetParam(d0Var.c[0], 10, Long.parseLong(optString2));
                                }
                            } catch (Exception e) {
                                LoggerProxy.d("OfflineSynthesizer", "parseLong exception = " + e.getMessage());
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                i = loadSuitedEngine;
            }
            if (i == 0) {
                a(str2, str3, str4, str5);
            }
        } else {
            a(str2, str3, str4, str5);
            TtsError a2 = this.d.a();
            this.f = a2;
            if (a2 != null) {
                return a2.getDetailCode();
            }
        }
        return i;
    }

    public final void a(String str, String str2, String str3, String str4) {
        d0.b bVar = this.b.b;
        bVar.j = str;
        bVar.l = str2;
        bVar.m = str3;
        bVar.n = str4;
    }
}
