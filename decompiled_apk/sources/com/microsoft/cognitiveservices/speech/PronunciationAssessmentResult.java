package com.microsoft.cognitiveservices.speech;

import XIXIX.OOXIXo;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class PronunciationAssessmentResult {
    private double accuracyScore;
    private double completenessScore;
    private ContentAssessmentResult contentAssessmentResult;
    private double fluencyScore;
    private double pronunciationScore;
    private double prosodyScore;
    private List<WordLevelTimingResult> words;

    private PronunciationAssessmentResult(PropertyCollection propertyCollection) {
        this.accuracyScore = Double.parseDouble(propertyCollection.getProperty("AccuracyScore", "-1"));
        this.pronunciationScore = Double.parseDouble(propertyCollection.getProperty("PronScore", "-1"));
        this.completenessScore = Double.parseDouble(propertyCollection.getProperty("CompletenessScore", "-1"));
        this.fluencyScore = Double.parseDouble(propertyCollection.getProperty("FluencyScore", "-1"));
        this.prosodyScore = Double.parseDouble(propertyCollection.getProperty("ProsodyScore", "-1"));
        if (!propertyCollection.getProperty("ContentAssessment_GrammarScore").isEmpty()) {
            this.contentAssessmentResult = new ContentAssessmentResult(propertyCollection);
        }
        String property = propertyCollection.getProperty(PropertyId.SpeechServiceResponse_JsonResult);
        if (property == null || property.isEmpty()) {
            return;
        }
        this.words = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(property).getJSONArray("NBest").getJSONObject(0).getJSONArray("Words");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.words.add(new WordLevelTimingResult(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
    }

    public static PronunciationAssessmentResult fromResult(SpeechRecognitionResult speechRecognitionResult) {
        Contracts.throwIfNull(speechRecognitionResult, "speechRecognitionResult cannot be null");
        if (speechRecognitionResult.getProperties().getProperty("AccuracyScore").isEmpty() && speechRecognitionResult.getProperties().getProperty("ContentAssessment_GrammarScore").isEmpty()) {
            return null;
        }
        return new PronunciationAssessmentResult(speechRecognitionResult.getProperties());
    }

    public Double getAccuracyScore() {
        return Double.valueOf(this.accuracyScore);
    }

    public Double getCompletenessScore() {
        return Double.valueOf(this.completenessScore);
    }

    public ContentAssessmentResult getContentAssessmentResult() {
        return this.contentAssessmentResult;
    }

    public Double getFluencyScore() {
        return Double.valueOf(this.fluencyScore);
    }

    public Double getPronunciationScore() {
        return Double.valueOf(this.pronunciationScore);
    }

    public Double getProsodyScore() {
        double d = this.prosodyScore;
        if (d >= OOXIXo.f3760XO) {
            return Double.valueOf(d);
        }
        return null;
    }

    public List<WordLevelTimingResult> getWords() {
        return this.words;
    }
}
