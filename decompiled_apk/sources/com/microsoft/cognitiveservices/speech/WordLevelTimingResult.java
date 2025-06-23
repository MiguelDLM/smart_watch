package com.microsoft.cognitiveservices.speech;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class WordLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private String errorType;
    private List<PhonemeLevelTimingResult> phonemes;
    private List<SyllableLevelTimingResult> syllables;
    private String word;

    public WordLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.word = jSONObject.optString("Word");
        JSONObject optJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (optJSONObject != null) {
            this.accuracyScore = optJSONObject.optDouble("AccuracyScore");
            this.errorType = optJSONObject.optString("ErrorType");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("Phonemes");
        if (optJSONArray != null) {
            this.phonemes = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.phonemes.add(new PhonemeLevelTimingResult(optJSONArray.optJSONObject(i)));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("Syllables");
        if (optJSONArray2 != null) {
            this.syllables = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                this.syllables.add(new SyllableLevelTimingResult(optJSONArray2.optJSONObject(i2)));
            }
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public List<PhonemeLevelTimingResult> getPhonemes() {
        return this.phonemes;
    }

    public List<SyllableLevelTimingResult> getSyllables() {
        return this.syllables;
    }

    public String getWord() {
        return this.word;
    }
}
