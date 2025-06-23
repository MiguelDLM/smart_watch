package com.sma.smartv3.ui.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.garmin.fit.X0xOO;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iflytek.sparkchain.core.rtasr.RTASR;
import com.iflytek.sparkchain.core.rtasr.RTASRCallbacks;
import com.iflytek.sparkchain.plugins.utils.Utils;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.entity.Languages;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

@RequiresApi(api = 23)
/* loaded from: classes12.dex */
public class TestRecordingActivity extends AppCompatActivity {
    private AudioManager audioManager;
    TextView chatOutputText;
    private AudioRecord mAudioRecord;
    private int mBufferSize;
    private RTASR mRTASR;
    private AudioDeviceInfo targetAudioDevice;
    private final String rtAsrApiKey = "0c997b55309fdb251dcb1b8cc6c87959";
    private boolean isRecording = false;
    xxIXOIIO scoStateReceiver = new xxIXOIIO(this, null);
    Handler handler = new Handler();
    boolean isrun = false;
    File outputFile = new File(PathUtils.getExternalAppDataPath() + "/files/recorddemo.pcm");

    /* loaded from: classes12.dex */
    public class I0Io implements View.OnClickListener {
        public I0Io() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            TestRecordingActivity.this.stopRecording();
            TestRecordingActivity.this.audioManager.stopBluetoothSco();
        }
    }

    /* loaded from: classes12.dex */
    public class II0XooXoX implements RTASRCallbacks {

        /* loaded from: classes12.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ RTASR.RtAsrResult f22986XO;

            public oIX0oI(final RTASR.RtAsrResult val$result) {
                this.f22986XO = val$result;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestRecordingActivity.this.chatOutputText.setText(TestRecordingActivity.this.chatOutputText.getText().toString() + "data:" + this.f22986XO.getData() + "\nstatus:" + this.f22986XO.getStatus() + "\nsrc:" + this.f22986XO.getTransResult().getSrc() + "\ndst:" + this.f22986XO.getTransResult().getDst() + "\ntransstatus:" + this.f22986XO.getTransResult().getStatus() + "\n\n");
            }
        }

        public II0XooXoX() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onBeginOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onEndOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onError(RTASR.RtAsrError error, Object usrTag) {
            Log.d(Utils.TAG, "errorcode:" + error.getCode());
            Log.d(Utils.TAG, "errortag:" + ((String) usrTag));
            TestRecordingActivity.this.isrun = false;
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onResult(RTASR.RtAsrResult result, Object usrTag) {
            Log.d(Utils.TAG, "data:" + result.getData());
            Log.d(Utils.TAG, "RawResult:" + result.getRawResult());
            Log.d(Utils.TAG, "data status:" + result.getStatus());
            Log.d(Utils.TAG, "src:" + result.getTransResult().getSrc());
            Log.d(Utils.TAG, "dst:" + result.getTransResult().getDst());
            Log.d(Utils.TAG, "transstatus:" + result.getTransResult().getStatus());
            Log.d(Utils.TAG, "sid:" + result.getSid());
            Log.d(Utils.TAG, "tag:" + ((String) usrTag));
            TestRecordingActivity.this.runOnUiThread(new oIX0oI(result));
            if (result.getStatus() == 3) {
                TestRecordingActivity.this.isrun = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class II0xO0 implements View.OnClickListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            TestRecordingActivity.this.chatOutputText.setText("");
            TestRecordingActivity.this.start();
        }
    }

    /* loaded from: classes12.dex */
    public class Oxx0IOOO implements Runnable {
        public Oxx0IOOO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TestRecordingActivity.this.chatOutputText.setText(TestRecordingActivity.this.chatOutputText.getText().toString() + "\n  开始解析录音文件  \n");
        }
    }

    /* loaded from: classes12.dex */
    public class X0o0xo implements RTASRCallbacks {

        /* loaded from: classes12.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ RTASR.RtAsrResult f22991XO;

            public oIX0oI(final RTASR.RtAsrResult val$result) {
                this.f22991XO = val$result;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestRecordingActivity.this.chatOutputText.setText(this.f22991XO.getData());
            }
        }

        public X0o0xo() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onBeginOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onEndOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onError(RTASR.RtAsrError error, Object usrTag) {
            TestRecordingActivity.this.isrun = false;
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onResult(RTASR.RtAsrResult result, Object usrTag) {
            TestRecordingActivity.this.runOnUiThread(new oIX0oI(result));
            if (result.getStatus() == 3) {
                TestRecordingActivity.this.isrun = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class XO implements Runnable {
        public XO() {
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0051: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:82), block:B:26:0x0051 */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "SparkChain"
                r1 = 0
                com.sma.smartv3.ui.launcher.TestRecordingActivity r2 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                android.media.AudioRecord r2 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$500(r2)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                r2.startRecording()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                com.sma.smartv3.ui.launcher.TestRecordingActivity r3 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                java.io.File r3 = r3.outputFile     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
                com.sma.smartv3.ui.launcher.TestRecordingActivity r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                int r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$600(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                byte[] r3 = new byte[r1]     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r4.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.String r5 = "111111111111111111 mBufferSize  "
                r4.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity r5 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                int r5 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$600(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r4.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                android.util.Log.d(r0, r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            L37:
                com.sma.smartv3.ui.launcher.TestRecordingActivity r4 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                boolean r4 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$700(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                if (r4 == 0) goto L55
                com.sma.smartv3.ui.launcher.TestRecordingActivity r4 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                android.media.AudioRecord r4 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$500(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r5 = 0
                r4.read(r3, r5, r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r2.write(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r2.flush()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                goto L37
            L50:
                r0 = move-exception
                r1 = r2
                goto Lbe
            L53:
                r1 = move-exception
                goto L9d
            L55:
                com.sma.smartv3.ui.launcher.TestRecordingActivity r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                android.media.AudioRecord r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$500(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r1.stop()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                android.media.AudioRecord r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$500(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r1.release()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity.access$800(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r1.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.String r3 = "111111111111111111 closeBluetooth  isRecording = "
                r1.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity r3 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                boolean r3 = com.sma.smartv3.ui.launcher.TestRecordingActivity.access$700(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r1.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity r1 = com.sma.smartv3.ui.launcher.TestRecordingActivity.this     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                com.sma.smartv3.ui.launcher.TestRecordingActivity.access$900(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r2.flush()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
                r2.close()     // Catch: java.io.IOException -> L92
                goto Lbd
            L92:
                r0 = move-exception
                r0.printStackTrace()
                goto Lbd
            L97:
                r0 = move-exception
                goto Lbe
            L99:
                r2 = move-exception
                r6 = r2
                r2 = r1
                r1 = r6
            L9d:
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L50
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
                r3.<init>()     // Catch: java.lang.Throwable -> L50
                java.lang.String r4 = "111111111111111111 m  6 e "
                r3.append(r4)     // Catch: java.lang.Throwable -> L50
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L50
                r3.append(r1)     // Catch: java.lang.Throwable -> L50
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L50
                android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L50
                if (r2 == 0) goto Lbd
                r2.close()     // Catch: java.io.IOException -> L92
            Lbd:
                return
            Lbe:
                if (r1 == 0) goto Lc8
                r1.close()     // Catch: java.io.IOException -> Lc4
                goto Lc8
            Lc4:
                r1 = move-exception
                r1.printStackTrace()
            Lc8:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.launcher.TestRecordingActivity.XO.run():void");
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
        }
    }

    /* loaded from: classes12.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(Utils.TAG, "111111111111111111   SCO Audio  开始  " + TestRecordingActivity.this.audioManager.isBluetoothScoOn());
            TestRecordingActivity.this.chatOutputText.setText("SCO Audio State:   开始 --> 连接");
            TestRecordingActivity.this.audioManager.startBluetoothSco();
            if (!Build.BRAND.equals("HUAWEI") && !RomUtils.isOppo()) {
                TestRecordingActivity.this.audioManager.setMode(2);
                TestRecordingActivity.this.audioManager.setMicrophoneMute(false);
                TestRecordingActivity.this.audioManager.setSpeakerphoneOn(false);
            } else {
                TestRecordingActivity.this.audioManager.setMode(2);
                TestRecordingActivity.this.audioManager.setMicrophoneMute(false);
                TestRecordingActivity.this.audioManager.setSpeakerphoneOn(false);
            }
            TestRecordingActivity.this.startRecording();
        }
    }

    /* loaded from: classes12.dex */
    public class xxIXOIIO extends BroadcastReceiver {
        public xxIXOIIO() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                if (intExtra != -1) {
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                Log.d(Utils.TAG, "111111111111111111 SCO Audio State: CONNECTING   连接中状态  ");
                                TestRecordingActivity.this.chatOutputText.setText("SCO Audio State: CONNECTING   连接中状态--> 连接中-->");
                                return;
                            }
                            return;
                        }
                        TestRecordingActivity.this.audioManager.setBluetoothScoOn(true);
                        TestRecordingActivity.this.chatOutputText.setText("SCO Audio State: CONNECTED   处理连接后状态 -->  正常可以用了---->  打开!!!");
                        Log.d(Utils.TAG, "111111111111111111 SCO Audio State: CONNECTED  处理连接后状态");
                        return;
                    }
                    Log.d(Utils.TAG, "111111111111111111 SCO Audio State: DISCONNECTED   断开 ");
                    TestRecordingActivity.this.chatOutputText.setText("SCO Audio State: DISCONNECTED   断开");
                    return;
                }
                TestRecordingActivity.this.chatOutputText.setText("SCO Audio State: ERROR  错误");
                Log.d(Utils.TAG, "111111111111111111 SCO Audio State: ERROR  错误");
            }
        }

        public /* synthetic */ xxIXOIIO(TestRecordingActivity testRecordingActivity, oIX0oI oix0oi) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeBluetooth() {
        this.audioManager.setBluetoothScoOn(false);
        this.audioManager.stopBluetoothSco();
        this.audioManager.setMode(0);
    }

    private int initSDK() {
        RTASR rtasr = new RTASR("0c997b55309fdb251dcb1b8cc6c87959");
        this.mRTASR = rtasr;
        rtasr.registerCallbacks(new X0o0xo());
        this.mRTASR.transType(PrerollVideoResponse.NORMAL);
        this.mRTASR.lang("cn");
        this.mRTASR.targetLang(Languages.DEFAULT_LANGUAGE);
        return this.mRTASR.start("xdx");
    }

    private void initSDK2() {
    }

    private void initialRecorder() {
        this.mBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            ToastUtils.showLong("没有录音权限");
            return;
        }
        AudioRecord audioRecord = new AudioRecord(0, 16000, 16, 2, this.mBufferSize);
        this.mAudioRecord = audioRecord;
        if (audioRecord.getState() != 1) {
            Log.e("AudioRecord", "Initialization failed.");
        } else {
            Log.d("AudioRecord", "Initialized successfully.");
        }
    }

    private void listener() {
        findViewById(R.id.start_init).setOnClickListener(new oIX0oI());
        findViewById(R.id.test_btn).setOnClickListener(new II0xO0());
        findViewById(R.id.test_btn2).setOnClickListener(new I0Io());
        IntentFilter intentFilter = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(this, this.scoStateReceiver, intentFilter, 2);
        } else {
            registerReceiver(this.scoStateReceiver, intentFilter);
        }
    }

    private void setStartBluetooth() {
        this.handler.postDelayed(new oxoX(), 100L);
        Log.d(Utils.TAG, "getMode 当前的数据是 111:" + this.audioManager.getMode() + "   Build.BRAND = " + Build.BRAND + "  ,  Build.VERSION.SDK_INT  = " + Build.VERSION.SDK_INT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        setStartBluetooth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecording() {
        if (!this.isRecording) {
            this.isRecording = true;
            Log.d(Utils.TAG, "111111111111111111 isRecording  " + this.isRecording);
            initialRecorder();
            new Thread(new XO()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecording() {
        if (this.isRecording) {
            this.isRecording = false;
        }
    }

    private void testRtasr(byte[] bytes, int mBufferSize) {
        if (this.mRTASR == null) {
            initSDK();
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            byte[] bArr = new byte[mBufferSize];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (-1 != read) {
                    if (read > 0) {
                        this.mRTASR.write((byte[]) bArr.clone());
                    }
                } else {
                    byteArrayInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void testRtasr2() {
        runOnUiThread(new Oxx0IOOO());
        if (this.isrun) {
            return;
        }
        this.isrun = true;
        RTASR rtasr = new RTASR("0c997b55309fdb251dcb1b8cc6c87959");
        this.mRTASR = rtasr;
        rtasr.registerCallbacks(new II0XooXoX());
        this.mRTASR.transType(PrerollVideoResponse.NORMAL);
        this.mRTASR.lang("cn");
        if (this.mRTASR.start("tag") == 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.outputFile);
                byte[] bArr = new byte[X0xOO.f13583O0o0];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (-1 != read) {
                        if (read > 0) {
                            this.mRTASR.write((byte[]) bArr.clone());
                        }
                    } else {
                        fileInputStream.close();
                        this.mRTASR.stop();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void init() {
        listener();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        AudioDeviceInfo[] devices;
        int type;
        int type2;
        int id;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spark_api_rtasr);
        this.chatOutputText = (TextView) findViewById(R.id.chat_output_text);
        initSDK2();
        init();
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.audioManager = audioManager;
        if (Build.VERSION.SDK_INT >= 28) {
            devices = audioManager.getDevices(1);
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                type = audioDeviceInfo.getType();
                if (type == 7) {
                    this.targetAudioDevice = audioDeviceInfo;
                }
                TextView textView = this.chatOutputText;
                StringBuilder sb = new StringBuilder();
                sb.append((Object) this.chatOutputText.getText());
                sb.append("\n  当前的音频输入设备 type =>  ");
                type2 = audioDeviceInfo.getType();
                sb.append(type2);
                sb.append("  id =   ");
                id = audioDeviceInfo.getId();
                sb.append(id);
                textView.setText(sb.toString());
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.audioManager.stopBluetoothSco();
        unregisterReceiver(this.scoStateReceiver);
    }

    public void playUri(Uri uri) {
    }
}
