package com.adp.sdk.dto;

public class ButtonVO {
    private String chose;
    private String fontSize;
    private String height;
    private boolean isCustom;
    private String position;
    private String text;
    private String time;
    private String type;
    private String width;

    public String getChose() {
        return this.chose;
    }

    public String getFontSize() {
        return this.fontSize;
    }

    public String getHeight() {
        return this.height;
    }

    public String getPosition() {
        return this.position;
    }

    public String getText() {
        return this.text;
    }

    public String getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public String getWidth() {
        return this.width;
    }

    public boolean isCustom() {
        return this.isCustom;
    }

    public void setChose(String str) {
        this.chose = str;
    }

    public void setCustom(boolean z) {
        this.isCustom = z;
    }

    public void setFontSize(String str) {
        this.fontSize = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }
}
