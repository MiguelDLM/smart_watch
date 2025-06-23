package com.iflytek.sparkchain.core;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes10.dex */
public class QAParam {

    @SerializedName("header")
    private Header header;

    @SerializedName("parameter")
    private Parameter parameter;

    @SerializedName("payload")
    private Payload payload;

    /* loaded from: classes10.dex */
    public static class Chat {

        @SerializedName("chat_id")
        private String chat_id;

        @SerializedName("max_tokens")
        private int max_tokens;

        @SerializedName("temperature")
        private double temperature;

        public String getChat_id() {
            return this.chat_id;
        }

        public int getMax_tokens() {
            return this.max_tokens;
        }

        public double getTemperature() {
            return this.temperature;
        }

        public void setChat_id(String str) {
            this.chat_id = str;
        }

        public void setMax_tokens(int i) {
            this.max_tokens = i;
        }

        public void setTemperature(double d) {
            this.temperature = d;
        }
    }

    /* loaded from: classes10.dex */
    public static class Header {
        private String app_id;
        private String bot_id;

        public String getApp_id() {
            return this.app_id;
        }

        public String getBot_id() {
            return this.bot_id;
        }

        public void setApp_id(String str) {
            this.app_id = str;
        }

        public void setBot_id(String str) {
            this.bot_id = str;
        }
    }

    /* loaded from: classes10.dex */
    public static class Message {

        @SerializedName("text")
        private List<Text> text;

        public List<Text> getText() {
            return this.text;
        }

        public void setText(List<Text> list) {
            this.text = list;
        }
    }

    /* loaded from: classes10.dex */
    public static class Parameter {

        @SerializedName("chat")
        private Chat chat;

        @SerializedName("prompt")
        private String prompt;

        @SerializedName("repo")
        private Repo repo;

        public Chat getChat() {
            return this.chat;
        }

        public String getPrompt() {
            return this.prompt;
        }

        public Repo getRepo() {
            return this.repo;
        }

        public void setChat(Chat chat) {
            this.chat = chat;
        }

        public void setPrompt(String str) {
            this.prompt = str;
        }

        public void setRepo(Repo repo) {
            this.repo = repo;
        }
    }

    /* loaded from: classes10.dex */
    public static class Payload {

        @SerializedName("message")
        private Message message;

        public Message getMessage() {
            return this.message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    /* loaded from: classes10.dex */
    public static class Repo {

        @SerializedName("score")
        private double score;

        @SerializedName("top_k")
        private int top_k;

        public double getScore() {
            return this.score;
        }

        public int getTop_k() {
            return this.top_k;
        }

        public void setScore(double d) {
            this.score = d;
        }

        public void setTop_k(int i) {
            this.top_k = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class Text {

        @SerializedName("content")
        private String content;

        @SerializedName("role")
        private String role;

        public String getContent() {
            return this.content;
        }

        public String getRole() {
            return this.role;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setRole(String str) {
            this.role = str;
        }
    }

    public Header getHeader() {
        return this.header;
    }

    public Parameter getParameter() {
        return this.parameter;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
