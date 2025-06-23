package X0xxXX0;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import oOoIIO0.oO;
import oOoIIO0.x0XOIxOo;

/* loaded from: classes11.dex */
public class II0xO0 extends ATInitMediation {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static volatile II0xO0 f3658II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f3659Oxx0IOOO = II0xO0.class.getSimpleName();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f3662X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public List<MediationInitCallback> f3663XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3665oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public final Object f3660I0Io = new Object();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Handler f3664oIX0oI = new Handler(Looper.getMainLooper());

    /* renamed from: II0xO0, reason: collision with root package name */
    public final AtomicBoolean f3661II0xO0 = new AtomicBoolean(false);

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3667XO;

        /* renamed from: X0xxXX0.II0xO0$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0053oIX0oI extends oO {
            public C0053oIX0oI() {
            }

            @Override // oOoIIO0.oO
            public String getImei() {
                return super.getImei();
            }

            @Override // oOoIIO0.oO
            public String getOaid() {
                return super.getOaid();
            }

            @Override // oOoIIO0.oO
            public boolean isCanUsePhoneState() {
                return super.isCanUsePhoneState();
            }
        }

        public oIX0oI(Context context) {
            this.f3667XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x0XOIxOo.Oxx0IOOO(this.f3667XO, II0xO0.this.f3662X0o0xo, new C0053oIX0oI());
                x0XOIxOo.x0XOIxOo(false);
                x0XOIxOo.oO(false);
                II0xO0.this.f3665oxoX = true;
                II0xO0.this.oxoX(true, null, null);
                Log.i(II0xO0.f3659Oxx0IOOO, "init success");
            } catch (Throwable th) {
                II0xO0.this.oxoX(false, "80000", "init fail:" + th.getMessage());
                Log.i(II0xO0.f3659Oxx0IOOO, "init fail:" + th.getMessage());
            }
        }
    }

    public static II0xO0 X0o0xo() {
        if (f3658II0XooXoX == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f3658II0XooXoX == null) {
                        f3658II0XooXoX = new II0xO0();
                    }
                } finally {
                }
            }
        }
        return f3658II0XooXoX;
    }

    public void II0XooXoX(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (this.f3665oxoX) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.f3660I0Io) {
            try {
                if (this.f3661II0xO0.get()) {
                    if (mediationInitCallback != null) {
                        this.f3663XO.add(mediationInitCallback);
                    }
                    return;
                }
                if (this.f3663XO == null) {
                    this.f3663XO = new ArrayList();
                }
                this.f3661II0xO0.set(true);
                if (map.containsKey("app_id")) {
                    this.f3662X0o0xo = (String) map.get("app_id");
                }
                if (mediationInitCallback != null) {
                    this.f3663XO.add(mediationInitCallback);
                }
                if (TextUtils.isEmpty(this.f3662X0o0xo)) {
                    oxoX(false, "80000", "AppId is empty!");
                    Log.i(f3659Oxx0IOOO, "init fail");
                } else {
                    this.f3664oIX0oI.post(new oIX0oI(context));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String Oxx0IOOO() {
        return x0XOIxOo.X0o0xo();
    }

    public String XO() {
        return "Octopus";
    }

    public final void oxoX(boolean z, String str, String str2) {
        synchronized (this.f3660I0Io) {
            try {
                int size = this.f3663XO.size();
                for (int i = 0; i < size; i++) {
                    MediationInitCallback mediationInitCallback = this.f3663XO.get(i);
                    if (mediationInitCallback != null) {
                        if (z) {
                            mediationInitCallback.onSuccess();
                        } else {
                            mediationInitCallback.onFail(str + " | " + str2);
                        }
                    }
                }
                this.f3663XO.clear();
                this.f3661II0xO0.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
