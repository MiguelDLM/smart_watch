package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public final class ContentAssessmentResult {
    private double grammarScore;
    private double topicScore;
    private double vocabularyScore;

    public ContentAssessmentResult(PropertyCollection propertyCollection) {
        this.grammarScore = Double.parseDouble(propertyCollection.getProperty("ContentAssessment_GrammarScore"));
        this.vocabularyScore = Double.parseDouble(propertyCollection.getProperty("ContentAssessment_VocabularyScore"));
        this.topicScore = Double.parseDouble(propertyCollection.getProperty("ContentAssessment_TopicScore"));
    }

    public Double getGrammarScore() {
        return Double.valueOf(this.grammarScore);
    }

    public Double getTopicScore() {
        return Double.valueOf(this.topicScore);
    }

    public Double getVocabularyScore() {
        return Double.valueOf(this.vocabularyScore);
    }
}
