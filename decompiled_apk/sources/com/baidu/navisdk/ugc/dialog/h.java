package com.baidu.navisdk.ugc.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaRecorder;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes8.dex */
public class h extends com.baidu.navisdk.ugc.dialog.f {
    private static WeakReference<h> s;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private boolean h;
    private RotateAnimation i;
    private int j;
    private int k;
    private Timer l;
    private MediaRecorder m;
    private i n;
    private InterfaceC0371h o;
    private String p;
    private com.baidu.navisdk.util.worker.loop.a q;
    private final com.baidu.navisdk.util.worker.loop.a r;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (!h.this.h) {
                return;
            }
            int i = message.what;
            if (i == 1000) {
                h.this.k();
                return;
            }
            h.d(h.this);
            if (h.this.j > 3) {
                h.this.j = 1;
            }
            String str = "";
            for (int i2 = 0; i2 < h.this.j; i2++) {
                str = str + FileUtils.FILE_EXTENSION_SEPARATOR;
            }
            if (h.this.c != null && h.this.d != null) {
                h.this.c.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_sounds_record_title) + str);
                h.this.d.setText("剩下" + i + "\"");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            if (message.what == 5556 && i == 1) {
                h.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            h.this.k();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnShowListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (h.this.o != null && h.this.o.a()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_Sound", "onShow dismiss");
                }
                h.this.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class g extends TimerTask {
        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!h.this.h) {
                return;
            }
            h.j(h.this);
            if (h.this.k <= 0) {
                if (h.this.q != null) {
                    h.this.q.sendEmptyMessage(1000);
                }
            } else if (h.this.q != null) {
                h.this.q.sendEmptyMessage(h.this.k);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.dialog.h$h, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0371h {
        boolean a();
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(int i, String str, boolean z);
    }

    public h(Activity activity, int i2) {
        super(activity, R.style.BNDialog);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.j = 0;
        this.k = 20;
        this.p = null;
        this.q = new a("UGCSRD");
        this.r = new b("UgcModule_Sound");
        s = new WeakReference<>(this);
        this.f8029a = i2 != 1;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_ugc_report_sounds_dialog, null);
        setContentView(inflate);
        this.c = (TextView) inflate.findViewById(R.id.nsdk_ugc_report_sounds_title);
        this.d = (TextView) inflate.findViewById(R.id.nsdk_ugc_report_sounds_lefttime);
        this.e = (ImageView) inflate.findViewById(R.id.nsdk_ugc_report_sounds_record_process);
        this.f = (ImageView) inflate.findViewById(R.id.nsdk_ugc_report_sounds_start_iview);
        TextView textView = (TextView) inflate.findViewById(R.id.nsdk_ugc_report_sounds_startorstop_tview);
        this.g = textView;
        textView.setText("点击开始");
        this.d.setVisibility(4);
        this.e.setVisibility(8);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_269dp);
        attributes.height = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_255dp);
        window.setAttributes(attributes);
        window.setGravity(17);
        d();
        c();
    }

    public static /* synthetic */ int d(h hVar) {
        int i2 = hVar.j;
        hVar.j = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int j(h hVar) {
        int i2 = hVar.k;
        hVar.k = i2 - 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f8029a && this.b) {
            com.baidu.navisdk.asr.d.B().b(true);
        }
        super.cancel();
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.baidu.navisdk.util.worker.loop.a aVar = this.q;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.q = null;
        }
        f();
        s = null;
        this.n = null;
        this.o = null;
    }

    @Override // android.app.Dialog
    public void hide() {
        super.hide();
        com.baidu.navisdk.util.listener.a.b(this.r);
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog
    public void show() {
        super.show();
        com.baidu.navisdk.util.listener.a.a(this.r);
    }

    private String b() {
        return m0.j().b() + "/" + new Object().hashCode() + ".amr";
    }

    private void c() {
        if (this.i == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.i = rotateAnimation;
            rotateAnimation.setDuration(1000L);
            this.i.setRepeatMode(1);
            this.i.setRepeatCount(-1);
        }
    }

    private void d() {
        setOnDismissListener(new c());
        setOnShowListener(new d());
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setOnClickListener(new e());
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setOnClickListener(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.h) {
            k();
        } else {
            h();
        }
    }

    private void f() {
        g();
        try {
            try {
                Timer timer = this.l;
                if (timer != null) {
                    timer.cancel();
                }
                MediaRecorder mediaRecorder = this.m;
                if (mediaRecorder != null) {
                    try {
                        mediaRecorder.stop();
                    } catch (Exception unused) {
                    }
                    this.m.release();
                    this.m = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.m = null;
            this.l = null;
            this.i = null;
            j.b(this.f);
            j.b(this.e);
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.clearAnimation();
                this.e = null;
            }
        } catch (Throwable th) {
            this.m = null;
            this.l = null;
            throw th;
        }
    }

    private void g() {
        com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
        TTSPlayerControl.resumeVoiceTTSOutput();
    }

    private void h() {
        com.baidu.navisdk.ugc.utils.e.f8333a.b(com.baidu.navisdk.framework.a.c().a());
        this.h = true;
        TTSPlayerControl.stopVoiceTTSOutput();
        TTSPlayerControl.pauseVoiceTTSOutput();
        TTSPlayerControl.cancelAudio();
        TextView textView = this.c;
        if (textView != null && this.d != null && this.e != null && this.f != null && this.g != null) {
            textView.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_sounds_record_title));
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.g.setText("点击停止");
            if (this.i == null) {
                c();
            }
            this.d.setText("剩下20\"");
            this.e.startAnimation(this.i);
        }
        if (this.l == null) {
            this.l = new Timer("UgcSoundsRecordDialog");
        }
        this.k = 20;
        this.l.schedule(new g(), 1000L, 1000L);
        try {
            if (this.m == null) {
                this.m = new MediaRecorder();
            }
            this.m = new MediaRecorder();
            this.p = b();
            this.m.setAudioSource(1);
            this.m.setOutputFormat(1);
            this.m.setOutputFile(this.p);
            this.m.setAudioEncoder(1);
            this.m.prepare();
            this.m.start();
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_Sound", "MediaRecorder error:" + e2);
            }
        } catch (NoSuchFieldError e3) {
            e3.printStackTrace();
        }
    }

    public static void i() {
        h hVar;
        WeakReference<h> weakReference = s;
        if (weakReference == null || (hVar = weakReference.get()) == null || !hVar.h) {
            return;
        }
        hVar.k();
    }

    public static void j() {
        h hVar;
        i();
        WeakReference<h> weakReference = s;
        if (weakReference == null || (hVar = weakReference.get()) == null) {
            return;
        }
        hVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.h) {
            f();
            i iVar = this.n;
            if (iVar != null) {
                iVar.a(20 - this.k, this.p, true);
                this.n = null;
            }
        }
    }

    public void a(i iVar) {
        this.n = iVar;
    }

    public void a(InterfaceC0371h interfaceC0371h) {
        this.o = interfaceC0371h;
    }

    public static h a() {
        WeakReference<h> weakReference = s;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
