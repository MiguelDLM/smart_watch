package com.alimm.tanx.core.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.xXOx;
import x0xO.II0xO0;
import x0xO.XO;

public class TanxJsBridge implements NotConfused {
    private static final String TAG = "TanxJsBridge";
    Context context;
    public HashMap<String, JsHandler> messageHandlers;
    public HashMap<String, Callback> responseCallbacks;
    private Integer uniqueId = 0;
    private final WebView webView;

    @SuppressLint({"SetJavaScriptEnabled"})
    public TanxJsBridge(Context context2, WebView webView2) {
        this.context = context2;
        this.webView = webView2;
        this.responseCallbacks = new HashMap<>();
        this.messageHandlers = new HashMap<>();
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setAllowFileAccess(false);
        webView2.addJavascriptInterface(this, PrerollVideoResponse.NORMAL);
    }

    private void dispatch(HashMap<String, Object> hashMap) {
        String format = String.format("MamaBridge.handleMessageFromNative('%s');", new Object[]{new JSONObject((Map<String, Object>) hashMap).toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace(xXOx.f21930X0o0xo, "\\r").replace("\f", "\\f").replace(" ", "\\u2028").replace(" ", "\\u2029")});
        try {
            if (!tanxc_if.tanxc_if(this.webView)) {
                this.webView.post(new I0Io(this, format));
                return;
            }
            LogUtils.e(TAG, "webView已经回收，无法分发数据，终止！！！！");
            LogUtils.e(TAG, "jsBridge dispatch failed");
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        } catch (Throwable th) {
            LogUtils.e(TAG, "jsBridge dispatch failed");
            throw th;
        }
    }

    private void flush(String str) {
        oIX0oI oix0oi;
        if (str == null) {
            System.out.println("Javascript give data is null");
            return;
        }
        HashMap hashMap = (HashMap) JSON.parseObject(str, HashMap.class);
        String str2 = (String) hashMap.get(XO.f35438XO);
        if (str2 != null) {
            oix0oi = new oIX0oI(this, str2);
        } else {
            new II0xO0
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: CONSTRUCTOR  (r2v1 ? I:com.alimm.tanx.core.bridge.II0xO0) =  call: com.alimm.tanx.core.bridge.II0xO0.<init>():void type: CONSTRUCTOR in method: com.alimm.tanx.core.bridge.TanxJsBridge.flush(java.lang.String):void, dex: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v1 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 38 more
                */
            /*
                this = this;
                if (r6 != 0) goto L_0x000a
                java.io.PrintStream r6 = java.lang.System.out
                java.lang.String r0 = "Javascript give data is null"
                r6.println(r0)
                return
            L_0x000a:
                java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
                java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r6, r0)
                java.util.HashMap r0 = (java.util.HashMap) r0
                java.lang.String r1 = "callbackId"
                java.lang.Object r1 = r0.get(r1)
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x0022
                com.alimm.tanx.core.bridge.oIX0oI r2 = new com.alimm.tanx.core.bridge.oIX0oI
                r2.<init>(r5, r1)
                goto L_0x0027
            L_0x0022:
                com.alimm.tanx.core.bridge.II0xO0 r2 = new com.alimm.tanx.core.bridge.II0xO0
                r2.<init>()
            L_0x0027:
                java.lang.String r1 = "TanxJsBridge"
                com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r6)
                java.lang.String r6 = "handlerName"
                java.lang.Object r6 = r0.get(r6)
                java.lang.String r6 = (java.lang.String) r6
                java.lang.String r3 = "data"
                java.lang.Object r0 = r0.get(r3)
                com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0
                java.util.HashMap<java.lang.String, com.alimm.tanx.core.bridge.JsHandler> r3 = r5.messageHandlers
                java.lang.Object r6 = r3.get(r6)
                com.alimm.tanx.core.bridge.JsHandler r6 = (com.alimm.tanx.core.bridge.JsHandler) r6
                if (r6 != 0) goto L_0x0051
                java.lang.String r6 = "jsHandler is null"
                com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r6)
                r6 = 0
                r0 = 0
                r2.call(r6, r0)
                return
            L_0x0051:
                java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x007a }
                r1.<init>()     // Catch:{ Exception -> 0x007a }
                if (r0 == 0) goto L_0x007c
                java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x007a }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x007a }
            L_0x0060:
                boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x007a }
                if (r3 == 0) goto L_0x007c
                java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x007a }
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x007a }
                java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x007a }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x007a }
                java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x007a }
                r1.put(r4, r3)     // Catch:{ Exception -> 0x007a }
                goto L_0x0060
            L_0x007a:
                r6 = move-exception
                goto L_0x0080
            L_0x007c:
                r6.handler(r1, r2)     // Catch:{ Exception -> 0x007a }
                goto L_0x0083
            L_0x0080:
                r6.printStackTrace()
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.bridge.TanxJsBridge.flush(java.lang.String):void");
        }

        private String getFromAssets(Context context2, String str) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context2).open(str)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return sb.toString();
                    }
                    sb.append(readLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$dispatch$2(String str) {
            this.webView.evaluateJavascript(str, (ValueCallback) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$flush$0(String str, boolean z, AbstractMap abstractMap) {
            HashMap hashMap = new HashMap();
            hashMap.put(XO.f35437Oxx0IOOO, str);
            hashMap.put(XO.f35436II0XooXoX, abstractMap);
            hashMap.put("success", Boolean.valueOf(z));
            dispatch(hashMap);
        }

        public void call(String str, HashMap<String, String> hashMap, Callback callback) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(XO.f35439xoIox, str);
            if (hashMap != null) {
                hashMap2.put("data", hashMap);
            }
            if (callback != null) {
                this.uniqueId = Integer.valueOf(this.uniqueId.intValue() + 1);
                String str2 = "native_cb_" + this.uniqueId;
                this.responseCallbacks.put(str2, callback);
                hashMap2.put(XO.f35438XO, str2);
            }
            dispatch(hashMap2);
        }

        public void injectJavascript() {
            String fromAssets = getFromAssets(this.context, "mama.js");
            WebView webView2 = this.webView;
            webView2.loadUrl(II0xO0.f35433xoIox + fromAssets);
        }

        public void postEvent(String str, Map<String, Object> map) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventName", str);
            hashMap.put("eventData", map);
            dispatch(hashMap);
        }

        @JavascriptInterface
        public void postMessage(String str) {
            flush(str);
        }

        public void ready() {
        }

        public void register(String str, JsHandler jsHandler) {
            this.messageHandlers.put(str, jsHandler);
        }

        public void remove(String str) {
            this.messageHandlers.remove(str);
        }
    }
