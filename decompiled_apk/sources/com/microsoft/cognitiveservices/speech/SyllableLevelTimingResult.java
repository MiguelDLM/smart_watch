package com.microsoft.cognitiveservices.speech;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class SyllableLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private String grapheme;
    private String syllable;

    public SyllableLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.syllable = jSONObject.optString("Syllable");
        this.grapheme = jSONObject.optString("Grapheme");
        JSONObject optJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (optJSONObject != null) {
            this.accuracyScore = optJSONObject.optDouble("AccuracyScore");
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public String getGrapheme() {
        return this.grapheme;
    }

    public String getSyllable() {
        return this.syllable;
    }
}
