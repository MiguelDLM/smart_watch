package com.alibaba.sdk.android.oss.model;

import java.util.Map;

public class GetObjectTaggingResult extends OSSResult {
    private Map<String, String> tags;

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }
}
