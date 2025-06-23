package o0IXXIx;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.uriaction.i;
import com.jieli.jl_rcsp.util.CrashHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class oxoX implements Thread.UncaughtExceptionHandler {

    /* renamed from: I0Io, reason: collision with root package name */
    public static oxoX f31097I0Io = new oxoX();

    /* renamed from: II0xO0, reason: collision with root package name */
    public Context f31098II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f31099oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Throwable f31101XO;

        public oIX0oI(Throwable th) {
            this.f31101XO = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            oxoX.this.Oxx0IOOO(this.f31101XO);
            Looper.loop();
        }
    }

    public static oxoX oIX0oI() {
        return f31097I0Io;
    }

    public final void I0Io(String str) {
        String oIX0oI2;
        try {
            PackageInfo packageInfo = this.f31098II0xO0.getPackageManager().getPackageInfo(this.f31098II0xO0.getPackageName(), 1);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(i.Code, com.octopus.ad.internal.xoIox.oIX0oI().oO());
            jSONObject.put("packageName", this.f31098II0xO0.getPackageName());
            jSONObject.put(TTDownloadField.TT_VERSION_NAME, packageInfo.versionName);
            jSONObject.put("versionCode", String.valueOf(packageInfo.versionCode));
            jSONObject.put(bn.f.Code, "1.5.9.16");
            jSONObject.put("sdkTag", "OctopusAd");
            jSONObject2.put("oaid", oOoIIO0.x0XOIxOo.oxoX(this.f31098II0xO0));
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put(IAdInterListener.AdProdType.PRODUCT_CPU, Build.CPU_ABI);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, jSONObject2);
            jSONObject.put("crashMessage", str);
            String oIX0oI3 = I0Io.oIX0oI("aHR0cDovL3Nka2xvZy5hZGludGwuY24vc2RrL2NyYXNoUmVwb3J0");
            if (!TextUtils.isEmpty(oIX0oI3) && (oIX0oI2 = XO.oIX0oI(oIX0oI3, jSONObject.toString().getBytes())) != null) {
                II0XooXoX.oIX0oI(CrashHandler.TAG, "post:" + oIX0oI2);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            e.printStackTrace();
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void II0xO0(Context context) {
        this.f31099oIX0oI = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f31098II0xO0 = context.getApplicationContext();
    }

    public final void Oxx0IOOO(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        I0Io(obj);
        XO(obj);
    }

    public final boolean X0o0xo(Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new oIX0oI(th)).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void XO(String str) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                Log.e(CrashHandler.TAG, "sdcard unmounted,skip dump exception");
                return;
            }
            Context context = this.f31098II0xO0;
            if (context == null) {
                return;
            }
            File oIX0oI2 = OOXIXo.oIX0oI(context);
            II0XooXoX.oIX0oI("OctopusAd", "CrashHandler storagePath == " + oIX0oI2);
            if (oIX0oI2 != null) {
                String str2 = oIX0oI2.getPath() + "/Octopus/log/";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
                File file2 = new File(str2 + "crash_" + format + ".trace");
                file2.createNewFile();
                FileWriter fileWriter = new FileWriter(file2, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(format);
                bufferedWriter.write("\r\n");
                bufferedWriter.write("------------------crash----------------------");
                bufferedWriter.write("\r\n");
                bufferedWriter.write(str);
                bufferedWriter.write("\r\n");
                bufferedWriter.write("-------------------end-----------------------");
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            X0o0xo(th);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f31099oIX0oI;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
