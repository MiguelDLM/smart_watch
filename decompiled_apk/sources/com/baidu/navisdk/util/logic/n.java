package com.baidu.navisdk.util.logic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import androidx.documentfile.provider.DocumentFile;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.q0;
import com.baidu.navisdk.util.logic.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public class n {
    private static volatile n g;
    private static final String h = Environment.getExternalStorageDirectory().getPath() + "/NaviTracker";

    /* renamed from: a, reason: collision with root package name */
    private DocumentFile f9337a;
    private Context b;
    private Thread c;
    private List<Location> d;
    private final String[] e = {"1倍速", "2倍速", "4倍速"};
    public long f = 1000;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    boolean isVDREnabled = BNSettingManager.isVDREnabled();
                    if (isVDREnabled) {
                        BNSettingManager.enableVDRg(false);
                    }
                    for (int i = 0; i < n.this.d.size(); i++) {
                        if (!n.this.c.isInterrupted()) {
                            Thread.sleep(n.this.f);
                            j.r().a((Location) n.this.d.get(i), j.g.SOURCE_RAW_GPS);
                        } else {
                            Log.e("trackMock", "give point thread stop");
                            throw new InterruptedException();
                        }
                    }
                    if (isVDREnabled) {
                        BNSettingManager.enableVDRg(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f9339a;
        final /* synthetic */ DocumentFile b;
        final /* synthetic */ DocumentFile[] c;

        public b(String[] strArr, DocumentFile documentFile, DocumentFile[] documentFileArr) {
            this.f9339a = strArr;
            this.b = documentFile;
            this.c = documentFileArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            DocumentFile documentFile;
            n nVar = n.this;
            if (i == this.f9339a.length - 1) {
                documentFile = this.b;
            } else {
                documentFile = this.c[i];
            }
            nVar.f9337a = documentFile;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {

        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                n nVar = n.this;
                ArrayList a2 = nVar.a(nVar.f9337a);
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            n.this.a(250L);
                        }
                    } else {
                        n.this.a(500L);
                    }
                } else {
                    n nVar2 = n.this;
                    nVar2.a(nVar2.f);
                }
                JNIGuidanceControl.getInstance().setGetPointsFrequency((int) n.this.f);
                n.this.a((ArrayList<Location>) a2);
                Toast.makeText(n.this.b, "选中文件为：" + n.this.f9337a.getName() + "选中速度为" + n.this.e[i] + "时间间隔为" + n.this.f, 1).show();
            }
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog.Builder builder = new AlertDialog.Builder(n.this.b);
            builder.setItems(n.this.e, new a());
            builder.create().show();
        }
    }

    public n(Context context) {
        this.b = context;
        c();
    }

    private void c() {
        this.c = new Thread(new a(), "TrackMock: givePoint");
        new Handler();
        this.d = new ArrayList();
    }

    public void b() {
        Thread thread = this.c;
        if (thread == null || thread.isInterrupted()) {
            return;
        }
        this.c.interrupt();
    }

    public static n a(Context context) {
        if (g == null) {
            synchronized (n.class) {
                try {
                    if (g == null) {
                        g = new n(context);
                    }
                } finally {
                }
            }
        }
        g.b = context;
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Location> a(DocumentFile documentFile) {
        if (documentFile == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList<>();
        ArrayList<DocumentFile> arrayList2 = new ArrayList();
        if (documentFile.isDirectory()) {
            arrayList2.addAll(Arrays.asList(documentFile.listFiles()));
        } else {
            arrayList2.add(documentFile);
        }
        for (DocumentFile documentFile2 : arrayList2) {
            if (documentFile2.isFile()) {
                for (String str : q0.a(documentFile2.getUri(), this.b).split("\\r?\\n")) {
                    arrayList.add(a(str));
                }
            }
        }
        return arrayList;
    }

    private static Location a(String str) {
        String[] split = str.split(",");
        if (5 >= split.length) {
            return null;
        }
        try {
            Location location = new Location("txt");
            location.setLongitude(Double.parseDouble(split[1]));
            location.setLatitude(Double.parseDouble(split[2]));
            location.setSpeed(Float.parseFloat(split[3]));
            location.setBearing(Float.parseFloat(split[4]));
            location.setAccuracy(Float.parseFloat(split[5]));
            if (split.length > 10) {
                location.setTime(Long.parseLong(split[split.length - 5].replace(":", "")));
            } else {
                location.setTime(Long.parseLong(split[split.length - 3].replace(":", "")));
            }
            return location;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<Location> arrayList) {
        c();
        this.d = arrayList;
        this.c.start();
    }

    public void a(long j) {
        this.f = j;
    }

    public static void a(Location location) {
        j.r().a(location, j.g.SOURCE_RAW_GPS);
    }

    public void a(Uri uri) {
        if (uri == null) {
            TipTool.onCreateDebugToast(this.b, "地址找不到了，出错了");
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this.b, uri);
        DocumentFile[] listFiles = fromTreeUri.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            int length = listFiles.length;
            String[] strArr = new String[length + 1];
            for (int i = 0; i < listFiles.length; i++) {
                strArr[i] = listFiles[i].getName();
            }
            strArr[length] = "↑ 楼上全要了喵~";
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setTitle("选择复现轨迹");
            builder.setSingleChoiceItems(strArr, -1, new b(strArr, fromTreeUri, listFiles));
            builder.setNeutralButton("选择速度", new c());
            builder.create().show();
            return;
        }
        Toast.makeText(this.b, "请先放置轨迹至:" + h, 1).show();
    }

    public void a() {
        this.f9337a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = 1000L;
        b();
    }
}
