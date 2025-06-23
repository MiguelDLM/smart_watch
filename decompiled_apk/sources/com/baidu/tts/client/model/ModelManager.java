package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.e3;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.m3;
import com.baidu.tts.n1;
import com.baidu.tts.o1;
import com.baidu.tts.o3;
import com.baidu.tts.p1;
import com.baidu.tts.q2;
import com.baidu.tts.q3;
import com.baidu.tts.t3;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import com.baidu.tts.v3;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ModelManager {

    /* renamed from: a, reason: collision with root package name */
    public m3 f10063a;
    public Context mContext;

    public ModelManager(Context context) {
        this.f10063a = new m3(context);
        this.mContext = context;
        e3.e().setContext(context);
    }

    public final Conditions a(AvailableConditions availableConditions) {
        Conditions conditions = new Conditions();
        LibEngineParams engineParams = getEngineParams();
        conditions.setVersion(engineParams.getVersion());
        conditions.setDomains(engineParams.getDomain());
        conditions.setLanguages(engineParams.getLanguage());
        conditions.setQualitys(engineParams.getQuality());
        if (availableConditions != null) {
            conditions.setSpeakers(availableConditions.getSpeakers());
            conditions.setGenders(availableConditions.getGenders());
        }
        return conditions;
    }

    public String checkModelsUpdate(Set<String> set) {
        int i;
        m3 m3Var = this.f10063a;
        m3Var.getClass();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        if (set != null && set.size() != 0 && !set.isEmpty()) {
            try {
                Iterator<String> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    Conditions conditions = new Conditions();
                    conditions.appendId(next);
                    ModelBags modelBags = m3Var.a(conditions, false).get();
                    JSONArray json = modelBags.toJson();
                    if (!modelBags.isEmpty()) {
                        jSONArray2.put(json.get(0));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        if (Pattern.compile("^[0-9]+$").matcher(next).find()) {
                            jSONObject.put("id", Integer.valueOf(next));
                            jSONObject.put("needUpdate", 2);
                            jSONArray.put(jSONObject);
                        } else {
                            LoggerProxy.e("GetServerModelsWork", "params error id " + next + " is not int");
                        }
                    }
                }
                if (jSONArray2.length() != 0) {
                    m3Var.d.getClass();
                    BasicHandler basicHandler = new BasicHandler(new FutureTask(new o3(jSONArray2)));
                    basicHandler.start();
                    String str = (String) basicHandler.get();
                    if (!str.equals("")) {
                        JSONArray jSONArray3 = new JSONArray(str);
                        for (i = 0; i < jSONArray3.length(); i++) {
                            jSONArray.put(jSONArray3.get(i));
                        }
                    } else {
                        LoggerProxy.d("GetServerModelsWork", "servers return result is empty");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONArray.toString();
        }
        return "params error";
    }

    public DownloadHandler download(String str, OnDownloadListener onDownloadListener) {
        DownloadHandler downloadHandler;
        o1.a aVar;
        ExecutorService executorService;
        n1 n1Var = new n1();
        n1Var.f10137a = str;
        n1Var.b = onDownloadListener;
        p1 p1Var = this.f10063a.e;
        p1Var.getClass();
        if (StringTool.isEmpty(n1Var.f10137a)) {
            return null;
        }
        String str2 = n1Var.f10137a;
        synchronized (p1Var) {
            try {
                downloadHandler = p1Var.b.get(str2);
                if (downloadHandler == null) {
                    downloadHandler = new DownloadHandler(p1Var.c);
                    p1Var.b.put(str2, downloadHandler);
                }
            } catch (Exception unused) {
                downloadHandler = null;
            }
        }
        if (downloadHandler == null) {
            return null;
        }
        downloadHandler.reset(n1Var);
        o1 o1Var = p1Var.f10148a;
        synchronized (o1Var) {
            LoggerProxy.d("Downloader", "download handler=" + downloadHandler);
            aVar = new o1.a(downloadHandler);
            synchronized (o1Var) {
                try {
                    if (o1Var.d == null) {
                        o1Var.d = Executors.newSingleThreadExecutor();
                    }
                    executorService = o1Var.d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return downloadHandler;
        }
        downloadHandler.setCheckFuture(executorService.submit(aVar));
        return downloadHandler;
    }

    public LibEngineParams getEngineParams() {
        this.f10063a.d.getClass();
        return new LibEngineParams(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new q3(this.f10063a.d.f10185a.b, set)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions) {
        return this.f10063a.a(conditions, false);
    }

    public BasicHandler<ModelBags> getLocalModelsAvailable(AvailableConditions availableConditions) {
        return this.f10063a.a(a(availableConditions), true);
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        this.f10063a.d.getClass();
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new t3()));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> set) {
        return this.f10063a.a(set);
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        this.f10063a.d.getClass();
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new v3(conditions)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelBags> getServerModelsAvailable(AvailableConditions availableConditions) {
        return getServerModels(a(availableConditions));
    }

    public String getSpeechExtModelFileAbsPath(String str) {
        m3 m3Var = this.f10063a;
        q2 q2Var = q2.SPEECH_EXT_DATA_ID;
        return m3Var.a("speech_ext_data_id", str);
    }

    public String getSpeechModelFileAbsPath(String str) {
        m3 m3Var = this.f10063a;
        q2 q2Var = q2.SPEECH_DATA_ID;
        return m3Var.a("speech_data_id", str);
    }

    public String getTacSubganSpeakerAttr(String str) {
        m3 m3Var = this.f10063a;
        q2 q2Var = q2.TAC_SUBGAN_SPEAKER_ATTR;
        Map<String, String> a2 = m3Var.b.a(str);
        if (a2 != null && !a2.isEmpty()) {
            return DataTool.getMapValue(a2, "tac_subgan_speaker_attr");
        }
        return null;
    }

    public String getTextModelFileAbsPath(String str) {
        m3 m3Var = this.f10063a;
        q2 q2Var = q2.TEXT_DATA_ID;
        return m3Var.a("text_data_id", str);
    }

    public boolean isModelFileValid(String str) {
        return this.f10063a.a(str);
    }

    public boolean isModelValid(String str) {
        return this.f10063a.b(str);
    }

    public int stop() {
        p1 p1Var = this.f10063a.e;
        Iterator<DownloadHandler> it = p1Var.b.values().iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        p1Var.f10148a.stop();
        return 0;
    }
}
