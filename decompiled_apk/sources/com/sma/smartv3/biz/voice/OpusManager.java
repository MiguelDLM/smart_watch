package com.sma.smartv3.biz.voice;

import com.bestmafen.baseble.data.BleReadable;
import com.blankj.utilcode.util.FileIOUtils;
import com.sma.smartv3.biz.voice.OpusManager;
import com.smart.opus.OpusConstants;
import com.smart.opus.SmartOpus;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleAudioPacket;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOpusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpusManager.kt\ncom/sma/smartv3/biz/voice/OpusManager\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,180:1\n289#2,7:181\n277#2,5:188\n298#2:193\n289#2,7:197\n277#2,5:204\n298#2:209\n1864#3,3:194\n1864#3,3:210\n*S KotlinDebug\n*F\n+ 1 OpusManager.kt\ncom/sma/smartv3/biz/voice/OpusManager\n*L\n94#1:181,7\n94#1:188,5\n94#1:193\n109#1:197,7\n109#1:204,5\n109#1:209\n97#1:194,3\n113#1:210,3\n*E\n"})
/* loaded from: classes12.dex */
public final class OpusManager {

    @OXOo.OOXIXo
    private final String TAG = "OpusManager";

    @OXOo.oOoXoXO
    private OnDecodeStreamCallback mOnDecodeStreamCallback;

    @OXOo.oOoXoXO
    private OnStateCallback mOnStateCallback;

    @OXOo.oOoXoXO
    private SmartOpus mOpus;

    @OXOo.oOoXoXO
    private com.jieli.jl_audio_decode.opus.OpusManager mOpusManager;

    /* loaded from: classes12.dex */
    public interface OnDecodeStreamCallback extends OnStateCallback {
        void onDecodeStream(@OXOo.OOXIXo byte[] bArr);
    }

    /* loaded from: classes12.dex */
    public interface OnStateCallback {
        void onComplete(@OXOo.OOXIXo String str);

        void onError(int i, @OXOo.OOXIXo String str);

        void onStart();
    }

    public OpusManager() {
        try {
            this.mOpusManager = new com.jieli.jl_audio_decode.opus.OpusManager();
        } catch (Exception e) {
            e.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " OpusManager -> init error！！！");
        }
        try {
            SmartOpus smartOpus = new SmartOpus();
            this.mOpus = smartOpus;
            smartOpus.decoderInit(OpusConstants.SampleRate.Companion._16000(), OpusConstants.Channels.Companion.mono());
        } catch (Exception e2) {
            e2.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " Opus -> init error！！！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decodeStream(byte[] bArr) {
        OnDecodeStreamCallback onDecodeStreamCallback;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> decodeStream");
        BleReadable.Companion companion = BleReadable.Companion;
        int length = bArr.length;
        ArrayList arrayList = new ArrayList();
        int i = length / 40;
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                BleReadable.Companion companion2 = BleReadable.Companion;
                int i3 = 40 * i2;
                i2++;
                byte[] xxOXOOoIX2 = kotlin.collections.ooOOo0oXI.xxOXOOoIX(bArr, i3, 40 * i2);
                int length2 = xxOXOOoIX2.length;
                Object newInstance = BleAudioPacket.class.newInstance();
                BleReadable bleReadable = (BleReadable) newInstance;
                bleReadable.setMBytes(kotlin.collections.ooOOo0oXI.xxOXOOoIX(xxOXOOoIX2, 0, length2));
                bleReadable.decode();
                IIX0o.oO(newInstance, "also(...)");
                arrayList.add(bleReadable);
            }
        }
        int i4 = 0;
        for (Object obj : arrayList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            BleAudioPacket bleAudioPacket = (BleAudioPacket) obj;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("decodeStream packet ");
            sb.append(i4);
            sb.append(": ");
            sb.append(bleAudioPacket);
            sb.append("  ");
            sb.append(this.mOnDecodeStreamCallback != null);
            oix0oi.oIX0oI(sb.toString());
            SmartOpus smartOpus = this.mOpus;
            byte[] decode$default = smartOpus != null ? SmartOpus.decode$default(smartOpus, bleAudioPacket.getMData(), OpusConstants.FrameSize.Companion._320(), 0, 4, (Object) null) : null;
            if (decode$default != null && (onDecodeStreamCallback = this.mOnDecodeStreamCallback) != null) {
                onDecodeStreamCallback.onDecodeStream(decode$default);
            }
            i4 = i5;
        }
    }

    public final void decodeFile(@OXOo.OOXIXo final String inFilePath, @OXOo.OOXIXo String outFilePath, @OXOo.OOXIXo OnStateCallback callback) {
        IIX0o.x0xO0oo(inFilePath, "inFilePath");
        IIX0o.x0xO0oo(outFilePath, "outFilePath");
        IIX0o.x0xO0oo(callback, "callback");
        this.mOnStateCallback = callback;
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.OpusManager$decodeFile$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(inFilePath);
                        OpusManager opusManager = this;
                        IIX0o.ooOOo0oXI(readFile2BytesByChannel);
                        opusManager.decodeStream(readFile2BytesByChannel);
                    }
                }, 31, null);
                return;
            }
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> jl decodeFile");
        com.jieli.jl_audio_decode.opus.OpusManager opusManager = this.mOpusManager;
        if (opusManager != null) {
            opusManager.decodeFile(inFilePath, outFilePath, new com.jieli.jl_audio_decode.callback.OnStateCallback() { // from class: com.sma.smartv3.biz.voice.OpusManager$decodeFile$1
                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onComplete(@OXOo.OOXIXo String outFilePath2) {
                    OpusManager.OnStateCallback onStateCallback;
                    IIX0o.x0xO0oo(outFilePath2, "outFilePath");
                    onStateCallback = OpusManager.this.mOnStateCallback;
                    if (onStateCallback != null) {
                        onStateCallback.onComplete(outFilePath2);
                    }
                }

                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onError(int i, @OXOo.OOXIXo String message) {
                    OpusManager.OnStateCallback onStateCallback;
                    IIX0o.x0xO0oo(message, "message");
                    onStateCallback = OpusManager.this.mOnStateCallback;
                    if (onStateCallback != null) {
                        onStateCallback.onError(i, message);
                    }
                }

                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onStart() {
                    OpusManager.OnStateCallback onStateCallback;
                    onStateCallback = OpusManager.this.mOnStateCallback;
                    if (onStateCallback != null) {
                        onStateCallback.onStart();
                    }
                }
            });
        }
    }

    public final void release() {
        com.jieli.jl_audio_decode.opus.OpusManager opusManager = this.mOpusManager;
        if (opusManager != null) {
            opusManager.release();
        }
        SmartOpus smartOpus = this.mOpus;
        if (smartOpus != null) {
            smartOpus.decoderRelease();
        }
    }

    public final void startDecodeStream(@OXOo.OOXIXo OnDecodeStreamCallback callback) {
        com.jieli.jl_audio_decode.opus.OpusManager opusManager;
        IIX0o.x0xO0oo(callback, "callback");
        this.mOnDecodeStreamCallback = callback;
        BleCache bleCache = BleCache.INSTANCE;
        if ((IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) && (opusManager = this.mOpusManager) != null) {
            opusManager.startDecodeStream(new com.jieli.jl_audio_decode.callback.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.OpusManager$startDecodeStream$1
                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onComplete(@OXOo.OOXIXo String p0) {
                    OpusManager.OnDecodeStreamCallback onDecodeStreamCallback;
                    IIX0o.x0xO0oo(p0, "p0");
                    onDecodeStreamCallback = OpusManager.this.mOnDecodeStreamCallback;
                    if (onDecodeStreamCallback != null) {
                        onDecodeStreamCallback.onComplete(p0);
                    }
                }

                @Override // com.jieli.jl_audio_decode.callback.OnDecodeStreamCallback
                public void onDecodeStream(@OXOo.OOXIXo byte[] p0) {
                    OpusManager.OnDecodeStreamCallback onDecodeStreamCallback;
                    IIX0o.x0xO0oo(p0, "p0");
                    onDecodeStreamCallback = OpusManager.this.mOnDecodeStreamCallback;
                    if (onDecodeStreamCallback != null) {
                        onDecodeStreamCallback.onDecodeStream(p0);
                    }
                }

                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onError(int i, @OXOo.OOXIXo String p1) {
                    OpusManager.OnDecodeStreamCallback onDecodeStreamCallback;
                    IIX0o.x0xO0oo(p1, "p1");
                    onDecodeStreamCallback = OpusManager.this.mOnDecodeStreamCallback;
                    if (onDecodeStreamCallback != null) {
                        onDecodeStreamCallback.onError(i, p1);
                    }
                }

                @Override // com.jieli.jl_audio_decode.callback.OnStateCallback
                public void onStart() {
                    OpusManager.OnDecodeStreamCallback onDecodeStreamCallback;
                    onDecodeStreamCallback = OpusManager.this.mOnDecodeStreamCallback;
                    if (onDecodeStreamCallback != null) {
                        onDecodeStreamCallback.onStart();
                    }
                }
            });
        }
    }

    public final void stopDecodeStream() {
        com.jieli.jl_audio_decode.opus.OpusManager opusManager;
        BleCache bleCache = BleCache.INSTANCE;
        if ((IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) && (opusManager = this.mOpusManager) != null) {
            opusManager.stopEncodeStream();
        }
    }

    public final void writeAudioStream(@OXOo.OOXIXo final byte[] data) {
        IIX0o.x0xO0oo(data, "data");
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.OpusManager$writeAudioStream$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        OpusManager.this.decodeStream(data);
                    }
                }, 31, null);
                return;
            }
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> jl decodeStream");
        com.jieli.jl_audio_decode.opus.OpusManager opusManager = this.mOpusManager;
        if (opusManager != null) {
            opusManager.writeAudioStream(data);
        }
    }

    public final void decodeStream(@OXOo.OOXIXo String opus, @OXOo.OOXIXo String pcmPath, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(opus, "opus");
        IIX0o.x0xO0oo(pcmPath, "pcmPath");
        IIX0o.x0xO0oo(callback, "callback");
        BleReadable.Companion companion = BleReadable.Companion;
        byte[] readFile2BytesByStream = FileIOUtils.readFile2BytesByStream(opus);
        IIX0o.oO(readFile2BytesByStream, "readFile2BytesByStream(...)");
        int length = readFile2BytesByStream.length;
        ArrayList arrayList = new ArrayList();
        int i = length / 40;
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                BleReadable.Companion companion2 = BleReadable.Companion;
                int i3 = 40 * i2;
                i2++;
                byte[] xxOXOOoIX2 = kotlin.collections.ooOOo0oXI.xxOXOOoIX(readFile2BytesByStream, i3, 40 * i2);
                int length2 = xxOXOOoIX2.length;
                Object newInstance = BleAudioPacket.class.newInstance();
                BleReadable bleReadable = (BleReadable) newInstance;
                bleReadable.setMBytes(kotlin.collections.ooOOo0oXI.xxOXOOoIX(xxOXOOoIX2, 0, length2));
                bleReadable.decode();
                IIX0o.oO(newInstance, "also(...)");
                arrayList.add(bleReadable);
            }
        }
        boolean z = false;
        int i4 = 0;
        for (Object obj : arrayList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            BleAudioPacket bleAudioPacket = (BleAudioPacket) obj;
            SmartOpus smartOpus = this.mOpus;
            byte[] decode$default = smartOpus != null ? SmartOpus.decode$default(smartOpus, bleAudioPacket.getMData(), OpusConstants.FrameSize.Companion._320(), 0, 4, (Object) null) : null;
            if (decode$default != null) {
                FileIOUtils.writeFileFromBytesByStream(pcmPath, decode$default, true);
            }
            z = arrayList.size() - 1 == i4;
            i4 = i5;
        }
        callback.invoke(Boolean.valueOf(z));
    }
}
