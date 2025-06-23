package com.iflytek.sparkchain.core;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class LLM {
    private static final String TAG = "SparkChain";
    static AtomicInteger sessionId = new AtomicInteger(0);
    private LLMCallbacks cbs;
    private HashMap<Integer, Object> contextMap;
    private int index;
    private Memory memory;
    private d modelType;
    private String name;
    private LLMConfig params;

    /* loaded from: classes10.dex */
    public class LLMBaseOutputImpl implements LLMBaseOutput {
        String sid = "";

        public LLMBaseOutputImpl() {
        }

        public void clear() {
            this.sid = "";
        }

        @Override // com.iflytek.sparkchain.core.LLMBaseOutput
        public String getSid() {
            return this.sid;
        }

        public LLMBaseOutputImpl setSid(String str) {
            this.sid = str;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public class LLMErrorImpl implements LLMError {
        String sid = "";
        int errCode = 0;
        String errMsg = "";

        public LLMErrorImpl() {
        }

        public void clear() {
            this.sid = "";
            this.errCode = 0;
            this.errMsg = "";
        }

        @Override // com.iflytek.sparkchain.core.LLMError
        public int getErrCode() {
            return this.errCode;
        }

        @Override // com.iflytek.sparkchain.core.LLMError
        public String getErrMsg() {
            return this.errMsg;
        }

        @Override // com.iflytek.sparkchain.core.LLMBaseOutput
        public String getSid() {
            return this.sid;
        }

        public void setErrCode(int i) {
            this.errCode = i;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }
    }

    /* loaded from: classes10.dex */
    public class LLMEventImpl implements LLMEvent {
        String sid = "";
        int eventID = 0;
        String eventMsg = "";

        public LLMEventImpl() {
        }

        public void clear() {
            this.sid = "";
            this.eventID = 0;
            this.eventMsg = "";
        }

        @Override // com.iflytek.sparkchain.core.LLMEvent
        public int getEventID() {
            return this.eventID;
        }

        @Override // com.iflytek.sparkchain.core.LLMEvent
        public String getEventMsg() {
            return this.eventMsg;
        }

        @Override // com.iflytek.sparkchain.core.LLMBaseOutput
        public String getSid() {
            return this.sid;
        }

        public void setEventID(int i) {
            this.eventID = i;
        }

        public void setEventMsg(String str) {
            this.eventMsg = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }
    }

    /* loaded from: classes10.dex */
    public class LLMOutputImpl implements LLMOutput {
        byte[] bytes;
        String sid = "";
        String role = "";
        String content = "";
        String raw = "";
        String functionCall = "";
        int status = 0;
        int completionTokens = 0;
        int promptTokens = 0;
        int totalTokens = 0;
        int errCode = 0;
        String errMsg = "";

        public LLMOutputImpl() {
        }

        public void appendContent(String str) {
            this.content += str;
        }

        public void clear() {
            this.sid = "";
            this.role = "";
            this.content = "";
            this.raw = "";
            this.functionCall = "";
            this.status = 0;
            this.completionTokens = 0;
            this.promptTokens = 0;
            this.totalTokens = 0;
            this.errCode = 0;
            this.errMsg = "";
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getCompletionTokens() {
            return this.completionTokens;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getContent() {
            return this.content;
        }

        @Override // com.iflytek.sparkchain.core.LLMError
        public int getErrCode() {
            return this.errCode;
        }

        @Override // com.iflytek.sparkchain.core.LLMError
        public String getErrMsg() {
            return this.errMsg;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getFunctionCall() {
            return this.functionCall;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public byte[] getImage() {
            return this.bytes;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getPromptTokens() {
            return this.promptTokens;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getRaw() {
            return this.raw;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getRole() {
            return this.role;
        }

        @Override // com.iflytek.sparkchain.core.LLMBaseOutput
        public String getSid() {
            return this.sid;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getStatus() {
            return this.status;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getTotalTokens() {
            return this.totalTokens;
        }

        public void setCompletionTokens(int i) {
            this.completionTokens = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setErrCode(int i) {
            this.errCode = i;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setFunctionCall(String str) {
            this.functionCall = str;
        }

        public void setPromptTokens(int i) {
            this.promptTokens = i;
        }

        public void setRaw(String str) {
            this.raw = str;
        }

        public void setRole(String str) {
            this.role = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTotalTokens(int i) {
            this.totalTokens = i;
        }
    }

    /* loaded from: classes10.dex */
    public class LLMResultImpl implements LLMResult {
        byte[] bytes;
        String sid = "";
        String role = "";
        String content = "";
        String raw = "";
        String functionCall = "";
        int status = 0;
        int completionTokens = 0;
        int promptTokens = 0;
        int totalTokens = 0;

        public LLMResultImpl() {
        }

        public void appendContent(String str) {
            this.content += str;
        }

        public void clear() {
            this.sid = "";
            this.role = "";
            this.content = "";
            this.raw = "";
            this.functionCall = "";
            this.status = 0;
            this.completionTokens = 0;
            this.promptTokens = 0;
            this.totalTokens = 0;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getCompletionTokens() {
            return this.completionTokens;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getContent() {
            return this.content;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getFunctionCall() {
            return this.functionCall;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public byte[] getImage() {
            return this.bytes;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getPromptTokens() {
            return this.promptTokens;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getRaw() {
            return this.raw;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public String getRole() {
            return this.role;
        }

        @Override // com.iflytek.sparkchain.core.LLMBaseOutput
        public String getSid() {
            return this.sid;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getStatus() {
            return this.status;
        }

        @Override // com.iflytek.sparkchain.core.LLMResult
        public int getTotalTokens() {
            return this.totalTokens;
        }

        public void setCompletionTokens(int i) {
            this.completionTokens = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setFunctionCall(String str) {
            this.functionCall = str;
        }

        public void setPromptTokens(int i) {
            this.promptTokens = i;
        }

        public void setRaw(String str) {
            this.raw = str;
        }

        public void setRole(String str) {
            this.role = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTotalTokens(int i) {
            this.totalTokens = i;
        }
    }

    public LLM() {
        this(d.TEXT_GENERATION, LLMConfig.builder(), null);
    }

    public int addSystemPrompt(String str) {
        return llmAddSystemPrompt(str);
    }

    public int arun(String str) {
        return arun(str, (Object) null);
    }

    public int arunWithJson(String str) {
        return arunWithJson(str, null);
    }

    public void clearHistory() {
        llmClearHistory();
    }

    public void finalize() throws Throwable {
        super.finalize();
        llmDestroy();
    }

    public String getName() {
        return this.name;
    }

    public LLMConfig getParams() {
        return this.params;
    }

    public native int llmARun(String str, String str2, String str3, int i);

    public native int llmARunImage(String str, byte[] bArr, int i);

    public native int llmARunWithJson(String str, int i);

    public native int llmAddSystemPrompt(String str);

    public native void llmClearHistory();

    public native int llmCreate(int i, LLMConfig lLMConfig, Memory memory);

    public native int llmDestroy();

    public void llmErrorCallback(LLMErrorImpl lLMErrorImpl, int i) {
        Log.i("SparkChain", "Java llmErrorCallback");
        LLMCallbacks lLMCallbacks = this.cbs;
        if (lLMCallbacks != null) {
            lLMCallbacks.onLLMError(lLMErrorImpl, this.contextMap.get(Integer.valueOf(i)));
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void llmEventCallback(LLMEventImpl lLMEventImpl, int i) {
        Log.i("SparkChain", "Java llmEventCallback");
        LLMCallbacks lLMCallbacks = this.cbs;
        if (lLMCallbacks != null) {
            lLMCallbacks.onLLMEvent(lLMEventImpl, this.contextMap.get(Integer.valueOf(i)));
        }
    }

    public void llmResultCallback(LLMResultImpl lLMResultImpl, int i) {
        Log.i("SparkChain", "Java llmResultCallback");
        LLMCallbacks lLMCallbacks = this.cbs;
        if (lLMCallbacks != null) {
            lLMCallbacks.onLLMResult(lLMResultImpl, this.contextMap.get(Integer.valueOf(i)));
        }
        if (lLMResultImpl.getStatus() == 2) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public native LLMOutputImpl llmRun(String str, String str2, String str3, int i);

    public native LLMOutputImpl llmRunImage(String str, byte[] bArr, int i);

    public native LLMOutputImpl llmRunWithJson(String str, int i);

    public native int llmStop();

    public void registerLLMCallbacks(LLMCallbacks lLMCallbacks) {
        this.cbs = lLMCallbacks;
    }

    public LLMOutput run(String str) {
        return run(str, 60);
    }

    public LLMOutputImpl runWithJson(String str) {
        return runWithJson(str, 60);
    }

    public int stop() {
        return llmStop();
    }

    public LLM(LLMConfig lLMConfig) {
        this(d.TEXT_GENERATION, lLMConfig, null);
    }

    public int arun(String str, LLMTools lLMTools, Object obj) {
        if (str == null) {
            Log.e("SparkChain", "question is null object");
            return 18501;
        }
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e("SparkChain", "SparkChain not init");
            return initCode;
        }
        String type = lLMTools.getType();
        String description = lLMTools.getDescription();
        int incrementAndGet = sessionId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return llmARun(str, type, description, incrementAndGet);
    }

    public int arunWithJson(String str, Object obj) {
        if (str == null) {
            Log.e("SparkChain", "question is null xxx object");
            return 18501;
        }
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e("SparkChain", "SparkChain not init");
            return initCode;
        }
        int incrementAndGet = sessionId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return llmARunWithJson(str, incrementAndGet);
    }

    public LLMOutput run(String str, int i) {
        String str2;
        LLMOutputImpl lLMOutputImpl;
        int initCode = SparkChain.getInst().getInitCode();
        if (str == null) {
            str2 = "question is null object";
            Log.e("SparkChain", "question is null object");
            lLMOutputImpl = new LLMOutputImpl();
            initCode = 18501;
        } else {
            if (initCode == 0) {
                return llmRun(str, "", "", i);
            }
            str2 = "SparkChain not init";
            Log.e("SparkChain", "SparkChain not init");
            lLMOutputImpl = new LLMOutputImpl();
        }
        lLMOutputImpl.setErrCode(initCode);
        lLMOutputImpl.setErrMsg(str2);
        return lLMOutputImpl;
    }

    public LLMOutputImpl runWithJson(String str, int i) {
        String str2;
        LLMOutputImpl lLMOutputImpl;
        int initCode = SparkChain.getInst().getInitCode();
        if (str == null) {
            str2 = "body is null object";
            Log.e("SparkChain", "body is null object");
            lLMOutputImpl = new LLMOutputImpl();
            initCode = 18501;
        } else {
            if (initCode == 0) {
                return llmRunWithJson(str, i);
            }
            str2 = "SparkChain not init";
            Log.e("SparkChain", "SparkChain not init");
            lLMOutputImpl = new LLMOutputImpl();
        }
        lLMOutputImpl.setErrCode(initCode);
        lLMOutputImpl.setErrMsg(str2);
        return lLMOutputImpl;
    }

    public LLM(LLMConfig lLMConfig, Memory memory) {
        this(d.TEXT_GENERATION, lLMConfig, memory);
    }

    public int arun(String str, Object obj) {
        if (str == null) {
            Log.e("SparkChain", "question is null object");
            return 18501;
        }
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e("SparkChain", "SparkChain not init");
            return initCode;
        }
        int incrementAndGet = sessionId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return llmARun(str, "", "", incrementAndGet);
    }

    public LLMOutput run(String str, LLMTools lLMTools, int i) {
        String str2;
        LLMOutputImpl lLMOutputImpl;
        int initCode = SparkChain.getInst().getInitCode();
        if (str == null) {
            str2 = "question is null object";
            Log.e("SparkChain", "question is null object");
            lLMOutputImpl = new LLMOutputImpl();
            lLMOutputImpl.setErrCode(18501);
        } else {
            if (initCode == 0) {
                return llmRun(str, lLMTools.getType(), lLMTools.getDescription(), i);
            }
            str2 = "SparkChain not init";
            Log.e("SparkChain", "SparkChain not init");
            lLMOutputImpl = new LLMOutputImpl();
            lLMOutputImpl.setErrCode(initCode);
        }
        lLMOutputImpl.setErrMsg(str2);
        return lLMOutputImpl;
    }

    public LLM(Memory memory) {
        this(d.TEXT_GENERATION, LLMConfig.builder(), memory);
    }

    public int arun(String str, byte[] bArr) {
        return arun(str, bArr, (Object) null);
    }

    public LLMOutput run(String str, byte[] bArr) {
        return run(str, bArr, 60);
    }

    public LLM(d dVar, LLMConfig lLMConfig, Memory memory) {
        this.name = "LLM";
        this.contextMap = new HashMap<>();
        this.params = lLMConfig == null ? LLMConfig.builder() : lLMConfig;
        this.memory = memory;
        this.index = llmCreate(dVar.getValue(), this.params, this.memory);
    }

    public int arun(String str, byte[] bArr, Object obj) {
        if (str == null) {
            Log.e("SparkChain", "question is null object");
            return 18501;
        }
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e("SparkChain", "SparkChain not init");
            return initCode;
        }
        int incrementAndGet = sessionId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return llmARunImage(str, bArr, incrementAndGet);
    }

    public LLMOutput run(String str, byte[] bArr, int i) {
        String str2;
        LLMOutputImpl lLMOutputImpl;
        int initCode = SparkChain.getInst().getInitCode();
        if (str == null) {
            str2 = "question is null object";
            Log.e("SparkChain", "question is null object");
            lLMOutputImpl = new LLMOutputImpl();
            lLMOutputImpl.setErrCode(18501);
        } else {
            if (initCode == 0) {
                return llmRunImage(str, bArr, i);
            }
            str2 = "SparkChain not init";
            Log.e("SparkChain", "SparkChain not init");
            lLMOutputImpl = new LLMOutputImpl();
            lLMOutputImpl.setErrCode(initCode);
        }
        lLMOutputImpl.setErrMsg(str2);
        return lLMOutputImpl;
    }
}
