package com.sma.smartv3.biz.voice;

import OoOoXO0.xoXoI;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import com.androidnetworking.AndroidNetworking;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.UriUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.huawei.openalliance.ad.constant.bn;
import com.iflytek.sparkchain.core.tts.OnlineTTS;
import com.iflytek.sparkchain.core.tts.TTS;
import com.iflytek.sparkchain.core.tts.TTSCallbacks;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.network.GetAITextToAudio;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoxXI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt___StringsKt;

@XX({"SMAP\nDcsTtsPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DcsTtsPlayer.kt\ncom/sma/smartv3/biz/voice/DcsTtsPlayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,605:1\n1#2:606\n11065#3:607\n11400#3,3:608\n1855#4,2:611\n*S KotlinDebug\n*F\n+ 1 DcsTtsPlayer.kt\ncom/sma/smartv3/biz/voice/DcsTtsPlayer\n*L\n415#1:607\n415#1:608,3\n484#1:611,2\n*E\n"})
/* loaded from: classes12.dex */
public final class DcsTtsPlayer {

    @OXOo.OOXIXo
    private static final File directoryFile;
    private static boolean isPlayEnd;
    private static boolean isReplayMusic;
    private static boolean isSegmentation;
    private static boolean isTTSEnd;
    private static int mLastLength;

    @OXOo.oOoXoXO
    private static MediaPlayer mMediaPlayer;
    private static int mSegmentationIndex;

    @OXOo.OOXIXo
    private static final ArrayList<String> mSegmentationTextList;

    @OXOo.OOXIXo
    private static final File mTtsFile;

    @OXOo.OOXIXo
    private static final File mTtsFilePcm;

    @OXOo.OOXIXo
    private static final ArrayList<File> segmentationFileList;

    @OXOo.oOoXoXO
    private static OnlineTTS sparkChainTts;
    private static int textListIndex;

    @OXOo.OOXIXo
    public static final DcsTtsPlayer INSTANCE = new DcsTtsPlayer();

    @OXOo.OOXIXo
    private static final String TAG = "DcsTtsPlayer";

    @OXOo.OOXIXo
    private static final String OPENAI_TTS_URL = "https://api.openai.com/v1/audio/speech";

    static {
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        mTtsFile = new File(IXxxXO.oOoXoXO(oix0oi), "ai_tts.mp3");
        mTtsFilePcm = new File(IXxxXO.oOoXoXO(oix0oi), "ai_tts.pcm");
        directoryFile = new File(PathUtils.getExternalAppDataPath() + "/files/save_video");
        mSegmentationTextList = new ArrayList<>();
        segmentationFileList = new ArrayList<>();
        isTTSEnd = true;
        isPlayEnd = true;
    }

    private DcsTtsPlayer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void AISparkChainPlay$default(DcsTtsPlayer dcsTtsPlayer, String str, Oox.oOoXoXO oooxoxo, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        if ((i & 4) != 0) {
            str2 = "x4_lingxiaolu_en";
        }
        dcsTtsPlayer.AISparkChainPlay(str, oooxoxo, str2);
    }

    private final void downloadAiTtsV2(String str, final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        String xoIox2 = AIManager.xoIox(AIManager.f19833oIX0oI, 0, 1, null);
        if (!IIX0o.Oxx0IOOO(xoIox2, "baiduAIService")) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " downloadOpenAiTtsV2 ->  " + xoIox2 + "  " + str);
        final String str2 = NetWorkUtils.INSTANCE.getBaseUrl(GetAITextToAudio.URL) + "?model=" + xoIox2 + "&text=" + str;
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$downloadAiTtsV2$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x00bf, code lost:
            
                r0 = r1.invoke(java.lang.Boolean.FALSE);
             */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.lang.Void doInBackground() {
                /*
                    r7 = this;
                    java.lang.String r0 = r1
                    com.androidnetworking.common.ANRequest$GetRequestBuilder r0 = com.androidnetworking.AndroidNetworking.get(r0)
                    com.androidnetworking.common.Priority r1 = com.androidnetworking.common.Priority.LOW
                    com.androidnetworking.common.ANRequest$GetRequestBuilder r0 = r0.setPriority(r1)
                    java.lang.String r1 = com.sma.smartv3.biz.voice.DcsTtsPlayer.access$getOPENAI_TTS_URL$p()
                    com.androidnetworking.common.ANRequest$GetRequestBuilder r0 = r0.setTag(r1)
                    com.androidnetworking.common.ANRequest r0 = r0.build()
                    com.androidnetworking.common.ANResponse r0 = r0.executeForOkHttpResponse()
                    Oox.oOoXoXO<java.lang.Boolean, kotlin.oXIO0o0XI> r1 = r2
                    r2 = 0
                    okhttp3.Response r3 = r0.getOkHttpResponse()     // Catch: java.lang.Exception -> L29
                    if (r3 == 0) goto L2c
                    r3.headers()     // Catch: java.lang.Exception -> L29
                    goto L2c
                L29:
                    r0 = move-exception
                    goto Lc8
                L2c:
                    okhttp3.Response r3 = r0.getOkHttpResponse()     // Catch: java.lang.Exception -> L29
                    if (r3 == 0) goto L3b
                    int r3 = r3.code()     // Catch: java.lang.Exception -> L29
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L29
                    goto L3c
                L3b:
                    r3 = r2
                L3c:
                    okhttp3.Response r4 = r0.getOkHttpResponse()     // Catch: java.lang.Exception -> L29
                    if (r4 == 0) goto L47
                    okhttp3.ResponseBody r4 = r4.body()     // Catch: java.lang.Exception -> L29
                    goto L48
                L47:
                    r4 = r2
                L48:
                    if (r3 != 0) goto L4c
                    goto Lbd
                L4c:
                    int r3 = r3.intValue()     // Catch: java.lang.Exception -> L29
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r3 != r5) goto Lbd
                    if (r4 == 0) goto L5b
                    java.io.InputStream r3 = r4.byteStream()     // Catch: java.lang.Exception -> L29
                    goto L5c
                L5b:
                    r3 = r2
                L5c:
                    if (r3 == 0) goto Lb2
                    byte[] r4 = kotlin.io.oIX0oI.x0xO0oo(r3)     // Catch: java.lang.Throwable -> Lab
                    kotlin.io.II0xO0.oIX0oI(r3, r2)     // Catch: java.lang.Exception -> L29
                    OI0.oIX0oI r3 = OI0.oIX0oI.f1507oIX0oI     // Catch: java.lang.Exception -> L29
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L29
                    r5.<init>()     // Catch: java.lang.Exception -> L29
                    java.lang.String r6 = com.sma.smartv3.biz.voice.DcsTtsPlayer.access$getTAG$p()     // Catch: java.lang.Exception -> L29
                    r5.append(r6)     // Catch: java.lang.Exception -> L29
                    java.lang.String r6 = " downloadOpenAiTtsV2 -> "
                    r5.append(r6)     // Catch: java.lang.Exception -> L29
                    okhttp3.Response r0 = r0.getOkHttpResponse()     // Catch: java.lang.Exception -> L29
                    if (r0 == 0) goto L83
                    okhttp3.Headers r0 = r0.headers()     // Catch: java.lang.Exception -> L29
                    goto L84
                L83:
                    r0 = r2
                L84:
                    r5.append(r0)     // Catch: java.lang.Exception -> L29
                    java.lang.String r0 = ", "
                    r5.append(r0)     // Catch: java.lang.Exception -> L29
                    int r0 = r4.length     // Catch: java.lang.Exception -> L29
                    r5.append(r0)     // Catch: java.lang.Exception -> L29
                    java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L29
                    r3.oIX0oI(r0)     // Catch: java.lang.Exception -> L29
                    com.sma.smartv3.biz.voice.DcsTtsPlayer r0 = com.sma.smartv3.biz.voice.DcsTtsPlayer.INSTANCE     // Catch: java.lang.Exception -> L29
                    java.io.File r0 = r0.getMTtsFile()     // Catch: java.lang.Exception -> L29
                    com.blankj.utilcode.util.FileIOUtils.writeFileFromBytesByStream(r0, r4)     // Catch: java.lang.Exception -> L29
                    if (r1 == 0) goto Ld5
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L29
                    java.lang.Object r0 = r1.invoke(r0)     // Catch: java.lang.Exception -> L29
                    kotlin.oXIO0o0XI r0 = (kotlin.oXIO0o0XI) r0     // Catch: java.lang.Exception -> L29
                    goto Ld5
                Lab:
                    r0 = move-exception
                    throw r0     // Catch: java.lang.Throwable -> Lad
                Lad:
                    r4 = move-exception
                    kotlin.io.II0xO0.oIX0oI(r3, r0)     // Catch: java.lang.Exception -> L29
                    throw r4     // Catch: java.lang.Exception -> L29
                Lb2:
                    if (r1 == 0) goto Ld5
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L29
                    java.lang.Object r0 = r1.invoke(r0)     // Catch: java.lang.Exception -> L29
                    kotlin.oXIO0o0XI r0 = (kotlin.oXIO0o0XI) r0     // Catch: java.lang.Exception -> L29
                    goto Ld5
                Lbd:
                    if (r1 == 0) goto Ld5
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L29
                    java.lang.Object r0 = r1.invoke(r0)     // Catch: java.lang.Exception -> L29
                    kotlin.oXIO0o0XI r0 = (kotlin.oXIO0o0XI) r0     // Catch: java.lang.Exception -> L29
                    goto Ld5
                Lc8:
                    r0.printStackTrace()
                    if (r1 == 0) goto Ld5
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE
                    java.lang.Object r0 = r1.invoke(r0)
                    kotlin.oXIO0o0XI r0 = (kotlin.oXIO0o0XI) r0
                Ld5:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.DcsTtsPlayer$downloadAiTtsV2$1.doInBackground():java.lang.Void");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void downloadAiTtsV2$default(DcsTtsPlayer dcsTtsPlayer, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.downloadAiTtsV2(str, oooxoxo);
    }

    private final void downloadOpenAiTts(final String str, final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " downloadOpenAiTts -> " + str);
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$downloadOpenAiTts$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x010a, code lost:
            
                r0 = r1.invoke(java.lang.Boolean.FALSE);
             */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.lang.Void doInBackground() {
                /*
                    Method dump skipped, instructions count: 289
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.DcsTtsPlayer$downloadOpenAiTts$1.doInBackground():java.lang.Void");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void downloadOpenAiTts$default(DcsTtsPlayer dcsTtsPlayer, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.downloadOpenAiTts(str, oooxoxo);
    }

    @kotlin.OOXIXo(message = "")
    private static /* synthetic */ void getMSegmentationTextList$annotations() {
    }

    public static /* synthetic */ void play$default(DcsTtsPlayer dcsTtsPlayer, String str, boolean z, boolean z2, Oox.oOoXoXO oooxoxo, String str2, int i, Object obj) {
        boolean z3;
        if ((i & 2) != 0) {
            z = ProductManager.f20544oIX0oI.OXOo();
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        if ((i & 8) != 0) {
            oooxoxo = null;
        }
        Oox.oOoXoXO oooxoxo2 = oooxoxo;
        if ((i & 16) != 0) {
            str2 = "x4_lingxiaolu_en";
        }
        dcsTtsPlayer.play(str, z4, z3, oooxoxo2, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playAssetsFile$default(DcsTtsPlayer dcsTtsPlayer, String str, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.playAssetsFile(str, z, oooxoxo);
    }

    public static final void playAssetsFile$lambda$3(boolean z, Uri uri, Oox.oOoXoXO oooxoxo, MediaPlayer mp) {
        IIX0o.x0xO0oo(uri, "$uri");
        IIX0o.x0xO0oo(mp, "mp");
        if (z) {
            mp.reset();
            mp.setDataSource(Utils.getApp(), uri);
            mp.prepare();
            mp.start();
            return;
        }
        INSTANCE.clearSegmentation();
        if (oooxoxo != null) {
        }
    }

    public static final boolean playAssetsFile$lambda$4(Oox.oOoXoXO oooxoxo, MediaPlayer mediaPlayer, int i, int i2) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " playAssetsFile error " + i);
        if (oooxoxo != null) {
        }
        INSTANCE.clearSegmentation();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playNew$default(DcsTtsPlayer dcsTtsPlayer, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.playNew(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playOld$default(DcsTtsPlayer dcsTtsPlayer, String str, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = ProductManager.f20544oIX0oI.OXOo();
        }
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.playOld(str, z, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playUri$default(DcsTtsPlayer dcsTtsPlayer, Uri uri, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        dcsTtsPlayer.playUri(uri, oooxoxo);
    }

    public static final void playUri$lambda$0(Oox.oOoXoXO oooxoxo, MediaPlayer mediaPlayer) {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(" play complete   mSegmentationIndex = ");
        sb.append(mSegmentationIndex);
        sb.append("   segmentationFileList = ");
        ArrayList<File> arrayList = segmentationFileList;
        sb.append(arrayList.size());
        oix0oi.oIX0oI(sb.toString());
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            if (mSegmentationIndex >= arrayList.size()) {
                isPlayEnd = true;
                if (isReplayMusic) {
                    isReplayMusic = false;
                } else {
                    INSTANCE.saveSegmentationFileMusic();
                }
                if (oooxoxo != null) {
                }
                x0xO0oo.oIX0oI(x0xO0oo.f24653xI0oxI00, bn.b.V);
                return;
            }
            try {
                if (mSegmentationIndex < arrayList.size() && arrayList.get(mSegmentationIndex) != null && UriUtils.file2Uri(arrayList.get(mSegmentationIndex)) != null) {
                    mediaPlayer.reset();
                    oix0oi.oIX0oI(str + " AISparkChainPlay    mSegmentationIndex = " + mSegmentationIndex + "   segmentationFileList.size = " + arrayList.size() + TokenParser.SP);
                    mediaPlayer.setDataSource(Utils.getApp(), UriUtils.file2Uri(arrayList.get(mSegmentationIndex)));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    mSegmentationIndex = mSegmentationIndex + 1;
                    return;
                }
                INSTANCE.clearSegmentation();
                if (oooxoxo != null) {
                }
                x0xO0oo.oIX0oI(x0xO0oo.f24653xI0oxI00, bn.b.V);
                return;
            } catch (Exception unused) {
                DcsTtsPlayer dcsTtsPlayer = INSTANCE;
                dcsTtsPlayer.stop();
                dcsTtsPlayer.initSegmentation();
                return;
            }
        }
        if (isSegmentation) {
            mSegmentationIndex++;
            ArrayList<String> arrayList2 = mSegmentationTextList;
            if (arrayList2.size() <= mSegmentationIndex) {
                INSTANCE.clearSegmentation();
                if (oooxoxo != null) {
                }
                x0xO0oo.oIX0oI(x0xO0oo.f24653xI0oxI00, bn.b.V);
                return;
            }
            mediaPlayer.reset();
            Application app = Utils.getApp();
            DcsTtsPlayer dcsTtsPlayer2 = INSTANCE;
            String str2 = arrayList2.get(mSegmentationIndex);
            IIX0o.oO(str2, "get(...)");
            mediaPlayer.setDataSource(app, dcsTtsPlayer2.getDirectConnectionUri(str2));
            mediaPlayer.prepare();
            mediaPlayer.start();
            return;
        }
        x0xO0oo.oIX0oI(x0xO0oo.f24653xI0oxI00, bn.b.V);
        if (oooxoxo != null) {
        }
    }

    public static final boolean playUri$lambda$1(Oox.oOoXoXO oooxoxo, MediaPlayer mediaPlayer, int i, int i2) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " play error " + i);
        if (oooxoxo != null) {
        }
        INSTANCE.clearSegmentation();
        return true;
    }

    private final void saveSegmentationFileMusic() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " saveSegmentationFileMusic");
        ArrayList<File> arrayList = segmentationFileList;
        if (arrayList != null && arrayList.size() > 0) {
            xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$saveSegmentationFileMusic$1
                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    File file;
                    ArrayList arrayList2;
                    String str;
                    File file2;
                    file = DcsTtsPlayer.directoryFile;
                    if (!file.exists()) {
                        file2 = DcsTtsPlayer.directoryFile;
                        FileUtils.createOrExistsDir(file2);
                    }
                    arrayList2 = DcsTtsPlayer.segmentationFileList;
                    ArrayList arrayList3 = new ArrayList(OxxIIOOXO.xo0x(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        boolean copy = FileUtils.copy((File) it.next(), new File(PathUtils.getExternalAppDataPath() + "/files/save_video/record_" + System.currentTimeMillis() + ".mp3"));
                        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                        StringBuilder sb = new StringBuilder();
                        str = DcsTtsPlayer.TAG;
                        sb.append(str);
                        sb.append(" saveSegmentationFileMusic b = ");
                        sb.append(copy);
                        oix0oi.oIX0oI(sb.toString());
                        arrayList3.add(oXIO0o0XI.f29392oIX0oI);
                    }
                }
            }, 31, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void segmentationText$default(DcsTtsPlayer dcsTtsPlayer, String str, Oox.oOoXoXO oooxoxo, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = null;
        }
        if ((i2 & 4) != 0) {
            i = 400;
        }
        dcsTtsPlayer.segmentationText(str, oooxoxo, i);
    }

    public static /* synthetic */ void setVolume$default(DcsTtsPlayer dcsTtsPlayer, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        dcsTtsPlayer.setVolume(f, f2);
    }

    public final void AISparkChainPlay(@OXOo.OOXIXo final String tmpText, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo final String pronounist) {
        IIX0o.x0xO0oo(tmpText, "tmpText");
        IIX0o.x0xO0oo(pronounist, "pronounist");
        if (AISparkChainManager.f19871oIX0oI.o0xxxXXxX() != 0) {
            return;
        }
        final File file = new File(IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI), "ai_tts_" + System.currentTimeMillis() + ".mp3");
        segmentationFileList.add(file);
        xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$AISparkChainPlay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                int i;
                ArrayList arrayList;
                String str2;
                ArrayList arrayList2;
                ArrayList arrayList3;
                DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                DcsTtsPlayer.isTTSEnd = false;
                if (dcsTtsPlayer.getSparkChainTts() == null) {
                    dcsTtsPlayer.setSparkChainTts(new OnlineTTS(pronounist));
                }
                String str3 = "x4_lingxiaolu_en";
                if (!IIX0o.Oxx0IOOO(pronounist, "x4_lingxiaoying_assist") && !IIX0o.Oxx0IOOO(pronounist, "x4_lingxiaolu_en")) {
                    str3 = pronounist;
                }
                OnlineTTS sparkChainTts2 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts2 != null) {
                    sparkChainTts2.vcn(str3);
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = DcsTtsPlayer.TAG;
                sb.append(str);
                sb.append(" AISparkChainPlay  pronounist = ");
                sb.append(str3);
                sb.append(" , mSegmentationIndex = ");
                i = DcsTtsPlayer.mSegmentationIndex;
                sb.append(i);
                sb.append(" tmpText = ");
                sb.append(tmpText);
                sb.append("  list.size = ");
                arrayList = DcsTtsPlayer.segmentationFileList;
                sb.append(arrayList.size());
                oix0oi.oIX0oI(sb.toString());
                OnlineTTS sparkChainTts3 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts3 != null) {
                    final File file2 = file;
                    final Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    final String str4 = pronounist;
                    sparkChainTts3.registerCallbacks(new TTSCallbacks() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$AISparkChainPlay$1.1
                        @Override // com.iflytek.sparkchain.core.tts.TTSCallbacks
                        public void onError(@OXOo.OOXIXo TTS.TTSError error, @OXOo.OOXIXo Object usrTag) {
                            String str5;
                            IIX0o.x0xO0oo(error, "error");
                            IIX0o.x0xO0oo(usrTag, "usrTag");
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb2 = new StringBuilder();
                            str5 = DcsTtsPlayer.TAG;
                            sb2.append(str5);
                            sb2.append(" AISparkChainPlay   onError  code = ");
                            sb2.append(error.getCode());
                            sb2.append("   errMsg = ");
                            sb2.append(error.getErrMsg());
                            oix0oi2.II0xO0(sb2.toString());
                            Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo2;
                            if (oooxoxo3 != null) {
                                oooxoxo3.invoke(Boolean.FALSE);
                            }
                        }

                        @Override // com.iflytek.sparkchain.core.tts.TTSCallbacks
                        public /* synthetic */ void onEvent(TTS.TTSEvent tTSEvent, Object obj) {
                            com.iflytek.sparkchain.core.tts.oIX0oI.oIX0oI(this, tTSEvent, obj);
                        }

                        @Override // com.iflytek.sparkchain.core.tts.TTSCallbacks
                        public void onResult(@OXOo.OOXIXo TTS.TTSResult result, @OXOo.OOXIXo Object usrTag) {
                            String str5;
                            String str6;
                            int i2;
                            int i3;
                            ArrayList arrayList4;
                            String str7;
                            int i4;
                            ArrayList arrayList5;
                            ArrayList arrayList6;
                            int i5;
                            boolean z;
                            ArrayList arrayList7;
                            ArrayList arrayList8;
                            int i6;
                            ArrayList arrayList9;
                            int i7;
                            ArrayList arrayList10;
                            IIX0o.x0xO0oo(result, "result");
                            IIX0o.x0xO0oo(usrTag, "usrTag");
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb2 = new StringBuilder();
                            str5 = DcsTtsPlayer.TAG;
                            sb2.append(str5);
                            sb2.append("  result.status = ");
                            sb2.append(result.getStatus());
                            sb2.append(" , result.sid =  ");
                            sb2.append(result.getSid());
                            sb2.append(" , path = ");
                            sb2.append(file2.getAbsolutePath());
                            oix0oi2.oIX0oI(sb2.toString());
                            try {
                                FileIOUtils.writeFileFromBytesByStream(file2, result.getData(), true);
                                if (result.getStatus() == 2) {
                                    i6 = DcsTtsPlayer.mSegmentationIndex;
                                    if (i6 == 0) {
                                        arrayList9 = DcsTtsPlayer.segmentationFileList;
                                        if (arrayList9.size() > 0) {
                                            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞分段播放 , 第一段开始播放");
                                            DcsTtsPlayer dcsTtsPlayer2 = DcsTtsPlayer.INSTANCE;
                                            i7 = DcsTtsPlayer.mSegmentationIndex;
                                            DcsTtsPlayer.mSegmentationIndex = i7 + 1;
                                            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞播放语音, 转语音成功, 执行播放");
                                            arrayList10 = DcsTtsPlayer.segmentationFileList;
                                            Uri file2Uri = UriUtils.file2Uri((File) arrayList10.get(0));
                                            IIX0o.oO(file2Uri, "file2Uri(...)");
                                            DcsTtsPlayer.playUri$default(dcsTtsPlayer2, file2Uri, null, 2, null);
                                            Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo2;
                                            if (oooxoxo3 != null) {
                                                oooxoxo3.invoke(Boolean.TRUE);
                                            }
                                        }
                                    }
                                }
                                if (result.getStatus() == 2) {
                                    z = DcsTtsPlayer.isPlayEnd;
                                    if (z) {
                                        DcsTtsPlayer dcsTtsPlayer3 = DcsTtsPlayer.INSTANCE;
                                        arrayList7 = DcsTtsPlayer.segmentationFileList;
                                        arrayList8 = DcsTtsPlayer.segmentationFileList;
                                        Uri file2Uri2 = UriUtils.file2Uri((File) arrayList7.get(arrayList8.size() - 1));
                                        IIX0o.oO(file2Uri2, "file2Uri(...)");
                                        DcsTtsPlayer.playUri$default(dcsTtsPlayer3, file2Uri2, null, 2, null);
                                    }
                                }
                                if (result.getStatus() == 2) {
                                    DcsTtsPlayer dcsTtsPlayer4 = DcsTtsPlayer.INSTANCE;
                                    DcsTtsPlayer.isTTSEnd = true;
                                    i2 = DcsTtsPlayer.textListIndex;
                                    DcsTtsPlayer.textListIndex = i2 + 1;
                                    i3 = DcsTtsPlayer.textListIndex;
                                    arrayList4 = DcsTtsPlayer.mSegmentationTextList;
                                    if (i3 < arrayList4.size()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        str7 = DcsTtsPlayer.TAG;
                                        sb3.append(str7);
                                        sb3.append("  textListIndex = ");
                                        i4 = DcsTtsPlayer.textListIndex;
                                        sb3.append(i4);
                                        sb3.append("  mSegmentationTextList = ");
                                        arrayList5 = DcsTtsPlayer.mSegmentationTextList;
                                        sb3.append(arrayList5.size());
                                        sb3.append(TokenParser.SP);
                                        oix0oi2.oIX0oI(sb3.toString());
                                        arrayList6 = DcsTtsPlayer.mSegmentationTextList;
                                        i5 = DcsTtsPlayer.textListIndex;
                                        Object obj = arrayList6.get(i5);
                                        IIX0o.oO(obj, "get(...)");
                                        dcsTtsPlayer4.AISparkChainPlay((String) obj, oooxoxo2, str4);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                OI0.oIX0oI oix0oi3 = OI0.oIX0oI.f1507oIX0oI;
                                StringBuilder sb4 = new StringBuilder();
                                str6 = DcsTtsPlayer.TAG;
                                sb4.append(str6);
                                sb4.append(" AISparkChainPlay  onResult -> error  e = ");
                                sb4.append(e);
                                sb4.append("   ");
                                oix0oi3.II0xO0(sb4.toString());
                            }
                        }
                    });
                }
                OnlineTTS sparkChainTts4 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts4 != null) {
                    sparkChainTts4.aue("lame");
                }
                OnlineTTS sparkChainTts5 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts5 != null) {
                    sparkChainTts5.sfl(1);
                }
                OnlineTTS sparkChainTts6 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts6 != null) {
                    sparkChainTts6.pitch(50);
                }
                OnlineTTS sparkChainTts7 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts7 != null) {
                    sparkChainTts7.speed(50);
                }
                OnlineTTS sparkChainTts8 = dcsTtsPlayer.getSparkChainTts();
                if (sparkChainTts8 != null) {
                    sparkChainTts8.bgs(0);
                }
                OnlineTTS sparkChainTts9 = dcsTtsPlayer.getSparkChainTts();
                Integer valueOf = sparkChainTts9 != null ? Integer.valueOf(sparkChainTts9.aRun(tmpText, file.getName())) : null;
                if (valueOf != null && 18311 == valueOf.intValue()) {
                    arrayList2 = DcsTtsPlayer.segmentationFileList;
                    arrayList3 = DcsTtsPlayer.segmentationFileList;
                    arrayList2.remove(arrayList3.size() - 1);
                }
                StringBuilder sb2 = new StringBuilder();
                str2 = DcsTtsPlayer.TAG;
                sb2.append(str2);
                sb2.append(" AISparkChainPlay  ret = ");
                sb2.append(valueOf);
                sb2.append("  -->");
                oix0oi.oIX0oI(sb2.toString());
            }
        }, 30, null);
    }

    public final void clearSegmentation() {
        if (isSegmentation) {
            isSegmentation = false;
            initSegmentation();
        }
    }

    public final void deleteReplayMusic() {
        File[] listFiles;
        boolean z;
        File file = mTtsFile;
        if (file.exists()) {
            file.delete();
        }
        File file2 = mTtsFilePcm;
        if (file2.exists()) {
            file2.delete();
        }
        if (ProductManager.f20544oIX0oI.oO0OX0() && (listFiles = directoryFile.listFiles()) != null) {
            if (listFiles.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file3 : listFiles) {
                    arrayList.add(Boolean.valueOf(file3.delete()));
                }
            }
        }
    }

    @OXOo.OOXIXo
    public final Uri getAssetFileUri(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String fileName) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(fileName, "fileName");
        AssetManager assets = context.getAssets();
        File file = new File(context.getCacheDir(), fileName);
        try {
            InputStream open = assets.open(fileName);
            IIX0o.oO(open, "open(...)");
            if (!file.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                open.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Uri fromFile = Uri.fromFile(file);
        IIX0o.oO(fromFile, "fromFile(...)");
        return fromFile;
    }

    @OXOo.OOXIXo
    public final Uri getDirectConnectionUri(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("https://tts.baidu.com/text2audio?tex=%s&ctp=1&cuid=7c828b054cdfeb09cee156233da30b2b.wav&lan=zh&per=100&spd=4&pit=6&vol=15&pdt=139&rate=4&xml=0", Arrays.copyOf(new Object[]{content}, 1));
        IIX0o.oO(format, "format(...)");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " contentLen -> " + content.length());
        Uri parse = Uri.parse(format);
        IIX0o.oO(parse, "parse(...)");
        return parse;
    }

    @OXOo.OOXIXo
    public final File getMTtsFile() {
        return mTtsFile;
    }

    @OXOo.OOXIXo
    public final File getMTtsFilePcm() {
        return mTtsFilePcm;
    }

    @OXOo.oOoXoXO
    public final OnlineTTS getSparkChainTts() {
        return sparkChainTts;
    }

    public final void initSegmentation() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + "  initSegmentation");
        stop();
        mSegmentationIndex = 0;
        mLastLength = 0;
        textListIndex = 0;
        mSegmentationTextList.clear();
        Iterator<T> it = segmentationFileList.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        segmentationFileList.clear();
    }

    public final boolean isPlay() {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public final boolean isReplayMusic() {
        return isReplayMusic;
    }

    public final void play(@OXOo.OOXIXo String text, boolean z, boolean z2, @OXOo.oOoXoXO Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo String rtasrLanguage) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(rtasrLanguage, "rtasrLanguage");
        if (!AIManager.f19833oIX0oI.XxX0x0xxx()) {
            return;
        }
        String IIOIX2 = OxI.IIOIX(OxI.IIOIX(OxI.IIOIX(text, "\n", "", false, 4, null), xoXoI.f2670oxoX, "", false, 4, null), "*", "", false, 4, null);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.oo0xXOI0I(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), text, null, 2, null);
            return;
        }
        if (productManager.oO0OX0()) {
            isSegmentation = z2;
            ArrayList<String> arrayList = mSegmentationTextList;
            if (arrayList.size() == 0) {
                AISparkChainPlay(IIOIX2, oooxoxo, rtasrLanguage);
            } else if (isTTSEnd) {
                AISparkChainPlay(IIOIX2, oooxoxo, rtasrLanguage);
                textListIndex++;
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + "   tmpText = " + IIOIX2);
            arrayList.add(IIOIX2);
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " isUseAIService -> " + productManager.XOx());
        if (productManager.XOx()) {
            playNew(IIOIX2, oooxoxo);
        } else {
            isSegmentation = z2;
            playOld(IIOIX2, z, oooxoxo);
        }
    }

    public final void playAssetsFile(@OXOo.OOXIXo String assetPath, final boolean z, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(assetPath, "assetPath");
        try {
            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
            }
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            final Uri assetFileUri = getAssetFileUri(app, assetPath);
            if (assetFileUri == null) {
                return;
            }
            stop();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " playAssetsFile  " + assetPath);
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
            }
            MediaPlayer mediaPlayer2 = mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setDataSource(Utils.getApp(), assetFileUri);
            }
            MediaPlayer mediaPlayer3 = mMediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sma.smartv3.biz.voice.II0xO0
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer4) {
                        DcsTtsPlayer.playAssetsFile$lambda$3(z, assetFileUri, oooxoxo, mediaPlayer4);
                    }
                });
            }
            MediaPlayer mediaPlayer4 = mMediaPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.sma.smartv3.biz.voice.I0Io
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer5, int i, int i2) {
                        boolean playAssetsFile$lambda$4;
                        playAssetsFile$lambda$4 = DcsTtsPlayer.playAssetsFile$lambda$4(Oox.oOoXoXO.this, mediaPlayer5, i, i2);
                        return playAssetsFile$lambda$4;
                    }
                });
            }
            MediaPlayer mediaPlayer5 = mMediaPlayer;
            if (mediaPlayer5 != null) {
                mediaPlayer5.prepare();
            }
            MediaPlayer mediaPlayer6 = mMediaPlayer;
            if (mediaPlayer6 != null) {
                mediaPlayer6.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(TAG + " playAssetsFile error " + e.getLocalizedMessage());
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.FALSE);
            }
            clearSegmentation();
        }
    }

    public final void playNew(@OXOo.OOXIXo String text, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(text, "text");
        downloadAiTtsV2(text, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$playNew$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            @OXOo.oOoXoXO
            public final oXIO0o0XI invoke(boolean z) {
                if (z) {
                    DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                    Uri file2Uri = UriUtils.file2Uri(dcsTtsPlayer.getMTtsFile());
                    IIX0o.oO(file2Uri, "file2Uri(...)");
                    DcsTtsPlayer.playUri$default(dcsTtsPlayer, file2Uri, null, 2, null);
                    return oXIO0o0XI.f29392oIX0oI;
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    return oooxoxo2.invoke(Boolean.FALSE);
                }
                return null;
            }
        });
    }

    public final void playOld(@OXOo.OOXIXo String text, boolean z, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(text, "text");
        String language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(" play -> ");
        sb.append(language);
        sb.append(", ");
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        if (z) {
            downloadOpenAiTts(text, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$playOld$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }

                @OXOo.oOoXoXO
                public final oXIO0o0XI invoke(boolean z2) {
                    if (z2) {
                        DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                        Uri file2Uri = UriUtils.file2Uri(dcsTtsPlayer.getMTtsFile());
                        IIX0o.oO(file2Uri, "file2Uri(...)");
                        DcsTtsPlayer.playUri$default(dcsTtsPlayer, file2Uri, null, 2, null);
                        return oXIO0o0XI.f29392oIX0oI;
                    }
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        return oooxoxo2.invoke(Boolean.FALSE);
                    }
                    return null;
                }
            });
            return;
        }
        String IIOIX2 = OxI.IIOIX(OxI.IIOIX(text, xoXoI.f2670oxoX, "", false, 4, null), "*", "", false, 4, null);
        boolean z2 = false;
        if (isSegmentation) {
            ArrayList<String> arrayList = mSegmentationTextList;
            if (arrayList.size() == 0) {
                if (IIOIX2.length() >= 80) {
                    IIOIX2 = IIOIX2.substring(0, 80);
                    IIX0o.oO(IIOIX2, "substring(...)");
                }
                mLastLength = 0;
                arrayList.add(IIOIX2);
                playUri(getDirectConnectionUri(IIOIX2), oooxoxo);
                return;
            }
            int length = mLastLength + ((String) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList)).length();
            mLastLength = length;
            String substring = IIOIX2.substring(length, IIOIX2.length());
            IIX0o.oO(substring, "substring(...)");
            arrayList.add(substring);
            return;
        }
        if (IIOIX2.length() > 500) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" content.length  ->  ");
            if (IIOIX2.length() > 500) {
                z2 = true;
            }
            sb2.append(z2);
            oix0oi.oIX0oI(sb2.toString());
            segmentationText(IIOIX2, oooxoxo, 500);
            return;
        }
        playUri(getDirectConnectionUri(IIOIX2), oooxoxo);
    }

    public final void playUri(@OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(uri, "uri");
        try {
            isPlayEnd = false;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " playUri -> " + uri);
            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
            }
            stop();
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
            }
            MediaPlayer mediaPlayer2 = mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setDataSource(Utils.getApp(), uri);
            }
            MediaPlayer mediaPlayer3 = mMediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sma.smartv3.biz.voice.oxoX
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer4) {
                        DcsTtsPlayer.playUri$lambda$0(Oox.oOoXoXO.this, mediaPlayer4);
                    }
                });
            }
            MediaPlayer mediaPlayer4 = mMediaPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.sma.smartv3.biz.voice.X0o0xo
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer5, int i, int i2) {
                        boolean playUri$lambda$1;
                        playUri$lambda$1 = DcsTtsPlayer.playUri$lambda$1(Oox.oOoXoXO.this, mediaPlayer5, i, i2);
                        return playUri$lambda$1;
                    }
                });
            }
            MediaPlayer mediaPlayer5 = mMediaPlayer;
            if (mediaPlayer5 != null) {
                mediaPlayer5.prepare();
            }
            MediaPlayer mediaPlayer6 = mMediaPlayer;
            if (mediaPlayer6 != null) {
                mediaPlayer6.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(TAG + " play error " + e.getLocalizedMessage());
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.FALSE);
            }
            clearSegmentation();
        }
    }

    public final void release() {
        if (mMediaPlayer != null) {
            stop();
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mMediaPlayer = null;
        }
    }

    public final void replayMusic() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            File file = mTtsFilePcm;
            if (file.exists()) {
                xoxXI xoxxi = xoxXI.f24733oIX0oI;
                String absolutePath = file.getAbsolutePath();
                IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                xoxxi.I0Io(absolutePath, ErrorCode.ERROR_TTS_INVALID_PARA);
                return;
            }
            ToastUtils.showLong("音频文件不存在", new Object[0]);
            return;
        }
        if (productManager.oO0OX0()) {
            File file2 = directoryFile;
            if (file2.exists()) {
                File[] listFiles = file2.listFiles();
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " saveSegmentationFileMusic files.size = " + listFiles.length);
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.sma.smartv3.biz.voice.DcsTtsPlayer$replayMusic$1
                    @Override // java.util.Comparator
                    public int compare(@OXOo.OOXIXo File file1, @OXOo.OOXIXo File file22) {
                        IIX0o.x0xO0oo(file1, "file1");
                        IIX0o.x0xO0oo(file22, "file2");
                        return IIX0o.OxxIIOOXO(file1.lastModified(), file22.lastModified());
                    }
                });
                ArrayList<File> arrayList = segmentationFileList;
                IIX0o.ooOOo0oXI(listFiles);
                kotlin.collections.OxI.xxIO(arrayList, listFiles);
                mSegmentationIndex++;
                isReplayMusic = true;
                Uri file2Uri = UriUtils.file2Uri((File) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList));
                IIX0o.oO(file2Uri, "file2Uri(...)");
                playUri$default(this, file2Uri, null, 2, null);
                return;
            }
            ToastUtils.showLong("音频文件不存在", new Object[0]);
            return;
        }
        File file3 = mTtsFile;
        if (file3.exists()) {
            isReplayMusic = true;
            Uri file2Uri2 = UriUtils.file2Uri(file3);
            IIX0o.oO(file2Uri2, "file2Uri(...)");
            playUri$default(this, file2Uri2, null, 2, null);
            return;
        }
        ToastUtils.showLong("音频文件不存在", new Object[0]);
    }

    public final void segmentationText(@OXOo.OOXIXo String text, @OXOo.oOoXoXO Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, int i) {
        IIX0o.x0xO0oo(text, "text");
        isSegmentation = true;
        ArrayList<String> arrayList = mSegmentationTextList;
        arrayList.add(StringsKt___StringsKt.oOI0IXOO(text, i));
        String substring = text.substring(((String) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).length(), text.length());
        IIX0o.oO(substring, "substring(...)");
        arrayList.add(substring);
        playUri(getDirectConnectionUri((String) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)), oooxoxo);
    }

    public final void setReplayMusic(boolean z) {
        isReplayMusic = z;
    }

    public final void setSparkChainTts(@OXOo.oOoXoXO OnlineTTS onlineTTS) {
        sparkChainTts = onlineTTS;
    }

    public final void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public final void stop() {
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + "  stop");
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.reset();
            }
            OnlineTTS onlineTTS = sparkChainTts;
            if (onlineTTS != null) {
                onlineTTS.stop();
            }
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().IO0XoXxO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AndroidNetworking.cancel(OPENAI_TTS_URL);
    }
}
