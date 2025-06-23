package com.microsoft.cognitiveservices.speech;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class PhonemeLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private List<NBestPhoneme> nbestPhonemes;
    private String phoneme;

    public PhonemeLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.phoneme = jSONObject.optString("Phoneme");
        JSONObject optJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (optJSONObject != null) {
            this.accuracyScore = optJSONObject.optDouble("AccuracyScore");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("NBestPhonemes");
        if (optJSONArray != null) {
            this.nbestPhonemes = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nbestPhonemes.add(new NBestPhoneme(optJSONArray.optJSONObject(i)));
            }
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public List<NBestPhoneme> getNBestPhonemes() {
        return this.nbestPhonemes;
    }

    public String getPhoneme() {
        return this.phoneme;
    }
}
