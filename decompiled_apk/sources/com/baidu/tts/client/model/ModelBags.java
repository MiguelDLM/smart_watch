package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ModelBags {

    /* renamed from: a, reason: collision with root package name */
    public TtsError f10059a;
    public List<ModelInfo> b;

    public void addModelInfo(ModelInfo modelInfo) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(modelInfo);
    }

    public List<ModelInfo> getModelInfos() {
        return this.b;
    }

    public TtsError getTtsError() {
        return this.f10059a;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.b);
    }

    public void parseJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            ModelInfo modelInfo = new ModelInfo();
            modelInfo.parseJson(optJSONObject);
            addModelInfo(modelInfo);
        }
    }

    public void setList(List<Map<String, String>> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> map : list) {
                ModelInfo modelInfo = new ModelInfo();
                modelInfo.setMap(map);
                arrayList.add(modelInfo);
            }
            this.b = arrayList;
        }
    }

    public void setModelInfos(List<ModelInfo> list) {
        this.b = list;
    }

    public void setTtsError(TtsError ttsError) {
        this.f10059a = ttsError;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            Iterator<ModelInfo> it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray;
    }
}
