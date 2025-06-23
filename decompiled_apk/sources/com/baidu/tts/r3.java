package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import com.baidu.tts.tools.StringTool;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class r3 implements Callable<ModelBags> {

    /* renamed from: a, reason: collision with root package name */
    public Conditions f10161a;
    public e1 b;
    public m3 c;
    public boolean d;

    public r3(e1 e1Var, Conditions conditions, m3 m3Var, boolean z) {
        this.f10161a = conditions;
        this.b = e1Var;
        this.c = m3Var;
        this.d = z;
    }

    @Override // java.util.concurrent.Callable
    public ModelBags call() throws Exception {
        String[] strArr;
        String str;
        List<Map<String, String>> a2;
        e1 e1Var = this.b;
        Conditions conditions = this.f10161a;
        e1Var.getClass();
        String version = conditions.getVersion();
        if (!StringTool.isEmpty(version)) {
            strArr = new String[]{version, version};
            str = "version_min <= ? and version_max >= ?";
        } else {
            strArr = null;
            str = null;
        }
        String[] domainArray = conditions.getDomainArray();
        String[] languageArray = conditions.getLanguageArray();
        String[] qualityArray = conditions.getQualityArray();
        String[] genderArray = conditions.getGenderArray();
        String[] speakerArray = conditions.getSpeakerArray();
        String[] modelIdsArray = conditions.getModelIdsArray();
        String buildConditions = SqlTool.buildConditions("and", str, SqlTool.buildInCondition(ClientCookie.DOMAIN_ATTR, domainArray), SqlTool.buildInCondition("language", languageArray), SqlTool.buildInCondition("quality", qualityArray), SqlTool.buildInCondition("gender", genderArray), SqlTool.buildInCondition(TtsStatsUploadBag.KEY_SPEAKER, speakerArray), SqlTool.buildInCondition("id", modelIdsArray));
        if (StringTool.isEmpty(buildConditions)) {
            a2 = null;
        } else {
            a2 = e1Var.a("select * from speechModel where " + buildConditions, DataTool.connect(strArr, domainArray, languageArray, qualityArray, genderArray, speakerArray, modelIdsArray));
        }
        ModelBags modelBags = new ModelBags();
        modelBags.setList(a2);
        if (this.d) {
            Iterator<ModelInfo> it = modelBags.getModelInfos().iterator();
            while (it.hasNext()) {
                if (!this.c.b(it.next().getServerId())) {
                    it.remove();
                }
            }
        }
        LoggerProxy.d("GetLocalModelsWork", "GetLocalModels " + modelBags.toJson().toString() + ", condition " + this.f10161a.getJSONConditions().toString());
        return modelBags;
    }
}
