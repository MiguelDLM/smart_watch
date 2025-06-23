package com.sma.smartv3.biz.voice;

import android.os.Build;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToLongFunction;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class VoiceManager$savePcmFile$1 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    public static final VoiceManager$savePcmFile$1 INSTANCE = new VoiceManager$savePcmFile$1();

    public VoiceManager$savePcmFile$1() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invoke$lambda$0(Oox.oOoXoXO tmp0, Object obj) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj)).longValue();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Comparator comparingLong;
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        if (voiceManager.getMSavePcmTime().length() > 0) {
            Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            File file = new File(PathUtils.getExternalAppDataPath() + "/files/save_pcm");
            if (!file.exists()) {
                FileUtils.createOrExistsDir(file);
            }
            FileUtils.copy(voiceManager.getMPcmFile(), new File(PathUtils.getExternalAppDataPath() + "/files/save_pcm/record_" + voiceManager.getMSavePcmTime() + ".pcm"));
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    final AnonymousClass1 anonymousClass1 = new Oox.oOoXoXO<File, Long>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$savePcmFile$1.1
                        @Override // Oox.oOoXoXO
                        @OXOo.OOXIXo
                        public final Long invoke(File file2) {
                            return Long.valueOf(file2.lastModified());
                        }
                    };
                    comparingLong = Comparator.comparingLong(new ToLongFunction() { // from class: com.sma.smartv3.biz.voice.oOoXoXO
                        @Override // java.util.function.ToLongFunction
                        public final long applyAsLong(Object obj) {
                            long invoke$lambda$0;
                            invoke$lambda$0 = VoiceManager$savePcmFile$1.invoke$lambda$0(Oox.oOoXoXO.this, obj);
                            return invoke$lambda$0;
                        }
                    });
                    IIX0o.oO(comparingLong, "comparingLong(...)");
                    kotlin.collections.ooOOo0oXI.IOOXOOOOo(listFiles, comparingLong);
                } else {
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$savePcmFile$1.2
                        @Override // java.util.Comparator
                        public int compare(@OXOo.OOXIXo File file1, @OXOo.OOXIXo File file2) {
                            IIX0o.x0xO0oo(file1, "file1");
                            IIX0o.x0xO0oo(file2, "file2");
                            return IIX0o.OxxIIOOXO(file1.lastModified(), file2.lastModified());
                        }
                    });
                }
                if (listFiles.length > 10) {
                    ((File) ArraysKt___ArraysKt.XXOXXx(listFiles)).delete();
                }
            }
            voiceManager.setMSavePcmTime("");
        }
    }
}
