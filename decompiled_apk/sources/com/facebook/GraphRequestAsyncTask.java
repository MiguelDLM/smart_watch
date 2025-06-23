package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<? extends GraphResponse>> {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();

    @OXOo.oOoXoXO
    private final HttpURLConnection connection;

    @OXOo.oOoXoXO
    private Exception exception;

    @OXOo.OOXIXo
    private final GraphRequestBatch requests;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public GraphRequestAsyncTask(@OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch requests) {
        IIX0o.x0xO0oo(requests, "requests");
        this.connection = httpURLConnection;
        this.requests = requests;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ List<? extends GraphResponse> doInBackground(Void[] voidArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground2(voidArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @OXOo.oOoXoXO
    public final Exception getException() {
        return this.exception;
    }

    @OXOo.OOXIXo
    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(List<? extends GraphResponse> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            onPostExecute2((List<GraphResponse>) list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.os.AsyncTask
    @VisibleForTesting(otherwise = 4)
    public void onPreExecute() {
        Handler handler;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onPreExecute();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isDebugEnabled()) {
                Utility utility = Utility.INSTANCE;
                String str = TAG;
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                IIX0o.oO(format, "java.lang.String.format(format, *args)");
                Utility.logd(str, format);
            }
            if (this.requests.getCallbackHandler() == null) {
                if (Thread.currentThread() instanceof HandlerThread) {
                    handler = new Handler();
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                this.requests.setCallbackHandler(handler);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        String str = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @OXOo.oOoXoXO
    @VisibleForTesting(otherwise = 4)
    /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public List<GraphResponse> doInBackground2(@OXOo.OOXIXo Void... params) {
        List<GraphResponse> executeConnectionAndWait;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(params, "params");
            try {
                HttpURLConnection httpURLConnection = this.connection;
                if (httpURLConnection == null) {
                    executeConnectionAndWait = this.requests.executeAndWait();
                } else {
                    executeConnectionAndWait = GraphRequest.Companion.executeConnectionAndWait(httpURLConnection, this.requests);
                }
                return executeConnectionAndWait;
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(@OXOo.OOXIXo List<GraphResponse> result) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(result, "result");
            super.onPostExecute((GraphRequestAsyncTask) result);
            Exception exc = this.exception;
            if (exc != null) {
                Utility utility = Utility.INSTANCE;
                String str = TAG;
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                IIX0o.oO(format, "java.lang.String.format(format, *args)");
                Utility.logd(str, format);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@OXOo.OOXIXo GraphRequest... requests) {
        this((HttpURLConnection) null, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(requests, requests.length)));
        IIX0o.x0xO0oo(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@OXOo.OOXIXo Collection<GraphRequest> requests) {
        this((HttpURLConnection) null, new GraphRequestBatch(requests));
        IIX0o.x0xO0oo(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@OXOo.OOXIXo GraphRequestBatch requests) {
        this((HttpURLConnection) null, requests);
        IIX0o.x0xO0oo(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequest... requests) {
        this(httpURLConnection, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(requests, requests.length)));
        IIX0o.x0xO0oo(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo Collection<GraphRequest> requests) {
        this(httpURLConnection, new GraphRequestBatch(requests));
        IIX0o.x0xO0oo(requests, "requests");
    }
}
