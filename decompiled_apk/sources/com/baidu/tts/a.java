package com.baidu.tts;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.tts.TtsFactory;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.model.ModelManager;
import com.facebook.login.widget.ToolTipPopup;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ITts f10025a;
    public SpeechSynthesizerListener b;
    public ThreadPoolExecutor c;
    public ModelManager d;
    public TtsListener e = new C0545a();

    /* renamed from: com.baidu.tts.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0545a implements TtsListener {
        public C0545a() {
        }

        public final boolean a(x4 x4Var) {
            int ordinal;
            try {
                ordinal = x4Var.j.getTtsErrorFlyweight().f10042a.ordinal();
            } catch (Exception e) {
                LoggerProxy.d("SpeechSynthesizerAdapter", "isStopped exception=" + e.toString());
            }
            if (ordinal == 3 || ordinal == 41 || ordinal == 62) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onError(x4 x4Var) {
            SpeechError speechError;
            if (a.this.b != null) {
                if (!a(x4Var)) {
                    String a2 = a.a(a.this, x4Var);
                    a.this.getClass();
                    if (x4Var != null) {
                        TtsError ttsError = x4Var.j;
                        if (ttsError != null) {
                            int detailCode = ttsError.getDetailCode();
                            String detailMessage = ttsError.getDetailMessage();
                            speechError = new SpeechError();
                            speechError.code = detailCode;
                            speechError.description = detailMessage;
                            a.this.b.onError(a2, speechError);
                        } else {
                            LoggerProxy.d("SpeechSynthesizerAdapter", "ttsError is null");
                        }
                    }
                    speechError = new SpeechError();
                    x2 x2Var = x2.S0;
                    speechError.code = -9999;
                    speechError.description = "unknow";
                    a.this.b.onError(a2, speechError);
                }
                LoggerProxy.d("SpeechSynthesizerAdapter", "onError sn = " + x4Var.d);
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayFinished(x4 x4Var) {
            TtsError ttsError;
            a aVar = a.this;
            if (aVar.b != null) {
                String a2 = a.a(aVar, x4Var);
                a.this.getClass();
                if (x4Var != null) {
                    ttsError = x4Var.j;
                } else {
                    ttsError = null;
                }
                LoggerProxy.d("SpeechSynthesizerAdapter", "get ttsError " + ttsError);
                i2 a3 = i2.a();
                int i = a.this.f10025a.getMode().f10184a;
                a3.a(ttsError, x4Var.d);
                a.this.b.onSpeechFinish(a2);
            }
            LoggerProxy.d("SpeechSynthesizerAdapter", "onPlayFinished sn = " + x4Var.d);
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayLipData(x4 x4Var) {
            if (a.this.b != null) {
                x4Var.getClass();
                a.a(a.this, x4Var);
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayProgressUpdate(x4 x4Var) {
            a aVar = a.this;
            if (aVar.b != null) {
                a.this.b.onSpeechProgressChanged(a.a(aVar, x4Var), x4Var.f);
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayStart(x4 x4Var) {
            a aVar = a.this;
            if (aVar.b != null) {
                a.this.b.onSpeechStart(a.a(aVar, x4Var));
            }
            LoggerProxy.d("SpeechSynthesizerAdapter", "onPlayStart sn = " + x4Var.d);
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeDataArrived(x4 x4Var) {
            a aVar = a.this;
            if (aVar.b != null) {
                a.this.b.onSynthesizeDataArrived(a.a(aVar, x4Var), x4Var.g, x4Var.f, x4Var.b);
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeFinished(x4 x4Var) {
            a aVar = a.this;
            if (aVar.b != null) {
                a.this.b.onSynthesizeFinish(a.a(aVar, x4Var));
            }
            LoggerProxy.d("SpeechSynthesizerAdapter", "onSynthesizeFinished sn = " + x4Var.d);
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeStart(x4 x4Var) {
            a aVar = a.this;
            if (aVar.b != null) {
                a.this.b.onSynthesizeStart(a.a(aVar, x4Var));
            }
            LoggerProxy.d("SpeechSynthesizerAdapter", "onSynthesizeStart sn = " + x4Var.d);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public List<SpeechSynthesizeBag> f10027a;

        public b(List<SpeechSynthesizeBag> list) {
            this.f10027a = list;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            int size;
            List<SpeechSynthesizeBag> list = this.f10027a;
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    SpeechSynthesizeBag speechSynthesizeBag = this.f10027a.get(i);
                    if (speechSynthesizeBag != null) {
                        String text = speechSynthesizeBag.getText();
                        String utteranceId = speechSynthesizeBag.getUtteranceId();
                        if (TextUtils.isEmpty(utteranceId)) {
                            utteranceId = String.valueOf(i);
                            speechSynthesizeBag.setUtteranceId(utteranceId);
                        }
                        if (!Thread.currentThread().isInterrupted()) {
                            y4 y4Var = new y4(text, utteranceId);
                            y4Var.d = s2.SPEAK;
                            a.this.f10025a.speak(y4Var);
                        } else {
                            return null;
                        }
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public String f10028a;
        public String b;

        public c(String str, String str2) {
            this.f10028a = str;
            this.b = str2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            y4 y4Var = new y4(this.f10028a, this.b);
            y4Var.d = s2.SPEAK;
            a.this.f10025a.speak(y4Var);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public String f10029a;
        public String b;

        public d(String str, String str2) {
            this.f10029a = str;
            this.b = str2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            y4 y4Var = new y4(this.f10029a, this.b);
            y4Var.d = s2.SYNTHESIZE;
            a.this.f10025a.synthesize(y4Var);
            return null;
        }
    }

    public a() {
        ITts c2 = c();
        this.f10025a = c2;
        c2.setTtsListener(this.e);
    }

    public static String a(a aVar, x4 x4Var) {
        y4 y4Var;
        aVar.getClass();
        if (x4Var != null && (y4Var = x4Var.i) != null) {
            return y4Var.c;
        }
        LoggerProxy.d("SpeechSynthesizerAdapter", "getUtteranceId null");
        return null;
    }

    public ModelManager b() {
        if (this.d == null) {
            this.d = new ModelManager(e3.e().c());
        }
        return this.d;
    }

    public final ITts c() {
        return new TtsFactory().makeProxy();
    }

    public final void d() {
        ThreadPoolExecutor threadPoolExecutor = this.c;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.c.shutdownNow();
            }
            try {
                LoggerProxy.d("SpeechSynthesizerAdapter", "isTerminated=" + this.c.awaitTermination(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
                LoggerProxy.d("SpeechSynthesizerAdapter", "InterruptedException");
            }
            this.c = null;
        }
    }

    public int a(HashMap<String, String> hashMap) {
        String str = hashMap.get(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE);
        String str2 = SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE;
        String str3 = hashMap.get(str2);
        String str4 = SpeechSynthesizer.PARAM_TTS_EXT_SPEECH_MODEL_FILE;
        String str5 = hashMap.get(str4);
        LoggerProxy.d("SpeechSynthesizerAdapter", "textModelPath = " + str + " , speechModelPath = " + str3 + ", speechExtFilePath = " + str5 + ", tacSubganSpeakerAttr = " + hashMap.get(SpeechSynthesizer.PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR));
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(str2, str5);
            hashMap.put(str4, str3);
        } else {
            hashMap.put(str2, str3);
        }
        return this.f10025a.loadSuitedModel(hashMap);
    }

    public final synchronized ExecutorService a() {
        try {
            if (this.c == null) {
                this.c = new d1(15000, new a3("bdtts-SpeechSynthesizerPoolThread"), new ThreadPoolExecutor.AbortPolicy());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public final int a(Callable<Void> callable) {
        try {
            a().submit(callable);
            return 0;
        } catch (RejectedExecutionException unused) {
            Log.e("bdtts-Queue", " count=" + ((ThreadPoolExecutor) a()).getQueue().size());
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        } catch (Exception e) {
            LoggerProxy.d("SpeechSynthesizerAdapter", e.toString());
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        }
    }
}
