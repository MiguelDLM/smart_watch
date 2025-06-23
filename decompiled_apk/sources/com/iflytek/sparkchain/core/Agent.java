package com.iflytek.sparkchain.core;

import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class Agent {
    private static String TAG = "SparkChain";
    private static AtomicInteger runningCount;
    private AgentType agentType;
    private int id;
    private LLM llm;
    private Memory memory;
    private Tools tools;
    private b baseOutput = new b();
    private e result = new e();
    private d event = new d();
    private c error = new c();
    private f syncOutput = new f(this, null);
    private AtomicInteger runningStatus = new AtomicInteger(0);
    private AgentCallbacks agentCallbacks = null;
    private PluginCallbacks pluginCallbacks = null;
    private Object usrContext = null;

    /* loaded from: classes10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17442a;

        public a(String str) {
            this.f17442a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Agent.this.agentRun(this.f17442a);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements AgentBaseOutput {

        /* renamed from: a, reason: collision with root package name */
        private String f17443a = "";

        public b() {
        }

        @Override // com.iflytek.sparkchain.core.AgentBaseOutput
        public String getSid() {
            return this.f17443a;
        }
    }

    /* loaded from: classes10.dex */
    public class c implements AgentError {

        /* renamed from: a, reason: collision with root package name */
        private int f17444a = 0;
        private String b = "";

        public c() {
        }

        public c a(int i) {
            this.f17444a = i;
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AgentError
        public int getErrCode() {
            return this.f17444a;
        }

        @Override // com.iflytek.sparkchain.core.AgentError
        public String getErrMsg() {
            return this.b;
        }

        @Override // com.iflytek.sparkchain.core.AgentBaseOutput
        public String getSid() {
            return Agent.this.baseOutput.getSid();
        }

        public c a(String str) {
            this.b = str;
            return this;
        }

        public void a() {
            this.f17444a = 0;
            this.b = "";
        }
    }

    /* loaded from: classes10.dex */
    public class d implements AgentEvent {

        /* renamed from: a, reason: collision with root package name */
        private int f17445a = 0;
        private String b = "";

        public d() {
        }

        public d a(int i) {
            this.f17445a = i;
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AgentEvent
        public int getEventID() {
            return this.f17445a;
        }

        @Override // com.iflytek.sparkchain.core.AgentEvent
        public String getEventMsg() {
            return this.b;
        }

        @Override // com.iflytek.sparkchain.core.AgentBaseOutput
        public String getSid() {
            return Agent.this.baseOutput.getSid();
        }

        public d a(String str) {
            this.b = str;
            return this;
        }

        public void a() {
            this.f17445a = 0;
            this.b = "";
        }
    }

    /* loaded from: classes10.dex */
    public class e implements AgentResult {

        /* renamed from: a, reason: collision with root package name */
        private String f17446a = "";
        private String b = "";

        public e() {
        }

        public e a(String str) {
            this.f17446a = str;
            return this;
        }

        public e b(String str) {
            this.b = str;
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AgentResult
        public String getRequest() {
            return this.f17446a;
        }

        @Override // com.iflytek.sparkchain.core.AgentResult
        public String getResponse() {
            return this.b;
        }

        @Override // com.iflytek.sparkchain.core.AgentBaseOutput
        public String getSid() {
            return Agent.this.baseOutput.getSid();
        }

        public void a() {
            this.f17446a = "";
            this.b = "";
        }
    }

    /* loaded from: classes10.dex */
    public class f implements AgentSyncOutput {
        private f() {
        }

        @Override // com.iflytek.sparkchain.core.AgentError
        public int getErrCode() {
            return Agent.this.error.getErrCode();
        }

        @Override // com.iflytek.sparkchain.core.AgentError
        public String getErrMsg() {
            return Agent.this.error.getErrMsg();
        }

        @Override // com.iflytek.sparkchain.core.AgentResult
        public String getRequest() {
            return Agent.this.result.getRequest();
        }

        @Override // com.iflytek.sparkchain.core.AgentResult
        public String getResponse() {
            return Agent.this.result.getResponse();
        }

        @Override // com.iflytek.sparkchain.core.AgentBaseOutput
        public String getSid() {
            return Agent.this.baseOutput.getSid();
        }

        public /* synthetic */ f(Agent agent, a aVar) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public class g implements PluginResult {

        /* renamed from: a, reason: collision with root package name */
        private String f17448a = "";
        private String b = "";
        private String c = "";

        public g() {
        }

        public g a(String str) {
            this.f17448a = str;
            return this;
        }

        public g b(String str) {
            this.b = str;
            return this;
        }

        public g c(String str) {
            this.c = str;
            return this;
        }

        @Override // com.iflytek.sparkchain.core.PluginResult
        public String getName() {
            return this.f17448a;
        }

        @Override // com.iflytek.sparkchain.core.PluginResult
        public String getRequest() {
            return this.b;
        }

        @Override // com.iflytek.sparkchain.core.PluginResult
        public String getResponse() {
            return this.c;
        }
    }

    static {
        try {
            System.loadLibrary(Utils.TAG);
            Log.v(TAG, "loadLibrary: success");
        } catch (Exception e2) {
            Log.e(TAG, "loadLibrary:" + e2.toString());
        }
        runningCount = new AtomicInteger(0);
    }

    public Agent(AgentType agentType, LLM llm, Tools tools) {
        this.agentType = agentType;
        this.llm = llm;
        this.tools = tools;
        String tools2 = tools.toString();
        Log.v(TAG, "Plugin Info:" + tools2);
        Log.v(TAG, "Plugin Info  domain:" + this.llm.getParams().getDomain());
        this.id = agentInit(tools2, this.agentType.getValue(), this.llm.getParams().getDomain());
    }

    public native int agentInit(String str, int i, String str2);

    public native String agentRun(String str);

    public native int agentUnInit();

    public int arun(String str) {
        return arun(str, null, null);
    }

    public void finalize() throws Throwable {
        super.finalize();
        agentUnInit();
    }

    public void onAgentError(int i, String str) {
        if (this.agentCallbacks != null && this.runningStatus.get() == 2) {
            c cVar = new c();
            cVar.a(i);
            cVar.a(str);
            this.agentCallbacks.onAgentError(cVar, this.usrContext);
        }
        this.runningStatus.set(0);
        runningCount.decrementAndGet();
    }

    public void onAgentEvent(int i, String str) {
        if (this.agentCallbacks != null && this.runningStatus.get() == 2) {
            d dVar = new d();
            dVar.a(i);
            dVar.a(str);
            this.agentCallbacks.onAgentEvent(dVar, this.usrContext);
        }
        if (i == 2) {
            this.runningStatus.set(0);
            runningCount.decrementAndGet();
        }
    }

    public void onAgentResult(String str, String str2) {
        if (this.agentCallbacks == null || this.runningStatus.get() != 2) {
            return;
        }
        e eVar = new e();
        eVar.a(str);
        eVar.b(str2);
        this.agentCallbacks.onAgentResult(eVar, this.usrContext);
    }

    public void onPluginOutput(String str, String str2, String str3) {
        if (this.pluginCallbacks == null || this.runningStatus.get() != 2) {
            return;
        }
        g gVar = new g();
        gVar.a(str);
        gVar.b(str2);
        gVar.c(str3);
        this.pluginCallbacks.onPluginOutput(gVar, this.usrContext);
    }

    public String pluginRun(String str, String str2) {
        Log.i(TAG, "agent plugin called start: " + str);
        if (this.tools == null) {
            Log.e(TAG, "tools is null");
        }
        BaseTool plugin = this.tools.getPlugin(str);
        if (plugin == null) {
            Log.e(TAG, "plugin not found");
            return "plugin not found";
        }
        Log.v(TAG, "agent plugin input: " + str2);
        String obj = plugin.run(str2, new String[0]).toString();
        if (obj == null) {
            return "plugin return null";
        }
        Log.i(TAG, "agent plugin called finish: " + str);
        Log.v(TAG, "agent plugin output: " + obj);
        return obj;
    }

    public void registerAgentCallbacks(AgentCallbacks agentCallbacks) {
        this.agentCallbacks = agentCallbacks;
    }

    public void registerPluginCallbacks(PluginCallbacks pluginCallbacks) {
        this.pluginCallbacks = pluginCallbacks;
    }

    public AgentSyncOutput run(String str) {
        return run(str, null);
    }

    public int arun(String str, Memory memory) {
        return arun(str, null, memory);
    }

    public AgentSyncOutput run(String str, Memory memory) {
        String str2;
        c cVar;
        int i;
        if (memory != null) {
            this.memory = memory;
        }
        this.result.a();
        this.event.a();
        this.error.a();
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e(TAG, "SparkChain not init");
            this.error.a(initCode);
            this.error.a("SparkChain not init");
        } else {
            if (this.runningStatus.get() != 0) {
                str2 = "llm inst is running";
                Log.e(TAG, "llm inst is running");
                cVar = this.error;
                i = 20107;
            } else if (runningCount.get() >= 2) {
                str2 = "llm concurrent overflow";
                Log.e(TAG, "llm concurrent overflow");
                cVar = this.error;
                i = 20108;
            } else {
                this.runningStatus.set(1);
                runningCount.incrementAndGet();
                String agentRun = agentRun(str);
                Log.d(TAG, "agentRun ret:" + agentRun);
                String[] split = agentRun.split(x.aL);
                int parseInt = Integer.parseInt(split[0]);
                String str3 = split[1];
                if (parseInt != 0) {
                    this.error.a(parseInt);
                    this.error.a(str3);
                } else {
                    this.result.a(str);
                    this.result.b(str3);
                }
                this.runningStatus.set(0);
                runningCount.decrementAndGet();
            }
            cVar.a(i);
            this.error.a(str2);
        }
        return this.syncOutput;
    }

    public int arun(String str, Object obj) {
        return arun(str, obj, null);
    }

    public int arun(String str, Object obj, Memory memory) {
        if (obj != null) {
            this.usrContext = obj;
        }
        if (memory != null) {
            this.memory = memory;
        }
        int initCode = SparkChain.getInst().getInitCode();
        if (initCode != 0) {
            Log.e(TAG, "SparkChain not init");
            return initCode;
        }
        if (this.runningStatus.get() != 0) {
            return 20107;
        }
        if (runningCount.get() >= 2) {
            return 20108;
        }
        this.runningStatus.set(2);
        runningCount.incrementAndGet();
        new Thread(new a(str)).start();
        return 0;
    }
}
