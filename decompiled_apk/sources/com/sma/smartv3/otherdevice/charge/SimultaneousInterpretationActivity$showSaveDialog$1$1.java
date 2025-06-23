package com.sma.smartv3.otherdevice.charge;

import android.os.Handler;
import android.widget.TextView;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.pop.OooI;
import java.io.File;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class SimultaneousInterpretationActivity$showSaveDialog$1$1 extends Lambda implements Oox.x0xO0oo<String, String, kotlin.oXIO0o0XI> {
    final /* synthetic */ SimultaneousInterpretationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimultaneousInterpretationActivity$showSaveDialog$1$1(SimultaneousInterpretationActivity simultaneousInterpretationActivity) {
        super(2);
        this.this$0 = simultaneousInterpretationActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(SimultaneousInterpretationActivity this$0) {
        String str;
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        OooI oooI;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        str = this$0.TAG;
        sb.append(str);
        sb.append(" mAIRecords = ");
        sb.append(this$0.getMAIRecords());
        oix0oi.oIX0oI(sb.toString());
        i0X0x0oIo = this$0.mLoadPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
        oooI = this$0.mTranslationSavePopup;
        if (oooI != null) {
            oooI.dismiss();
        }
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str, String str2) {
        invoke2(str, str2);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo String title, @OXOo.OOXIXo String location) {
        TextView mBtnTv;
        TextView mTopTv;
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
        if (this.this$0.getRecordingTime() > 0) {
            this.this$0.showLoadPopup();
            if (this.this$0.getMAIRecords() == null) {
                this.this$0.setMAIRecords(new AIRecords(0, 0L, null, this.this$0.getMAIFunctionType(), this.this$0.getMAIRecordsType(), "", null, 0, 0, 0, null, null, null, null, null, 0, null, 131015, null));
            }
            AIRecords mAIRecords = this.this$0.getMAIRecords();
            if (mAIRecords != null) {
                mAIRecords.setMAITitle(title);
            }
            AIRecords mAIRecords2 = this.this$0.getMAIRecords();
            if (mAIRecords2 != null) {
                mAIRecords2.setMTranslateLanguage(this.this$0.getMLeftLanguage().getName());
            }
            AIRecords mAIRecords3 = this.this$0.getMAIRecords();
            if (mAIRecords3 != null) {
                mAIRecords3.setMTranslateToLanguage(this.this$0.getMRightLanguage().getName());
            }
            AIRecords mAIRecords4 = this.this$0.getMAIRecords();
            if (mAIRecords4 != null) {
                mAIRecords4.setMLocation(location);
            }
            AIRecords mAIRecords5 = this.this$0.getMAIRecords();
            if (mAIRecords5 != null) {
                mAIRecords5.setMAudioDuration(this.this$0.getRecordingTime());
            }
            AIRecords mAIRecords6 = this.this$0.getMAIRecords();
            if (mAIRecords6 != null) {
                mTopTv = this.this$0.getMTopTv();
                mAIRecords6.setMContent(mTopTv.getText().toString());
            }
            AIRecords mAIRecords7 = this.this$0.getMAIRecords();
            if (mAIRecords7 != null) {
                mBtnTv = this.this$0.getMBtnTv();
                mAIRecords7.setMExtraInfo(mBtnTv.getText().toString());
            }
            File file = new File(PathUtils.getExternalAppDataPath() + "/files/" + System.currentTimeMillis() + "_record.pcm");
            FileUtils.copy(VoiceManager.INSTANCE.getMPcmFile(), file);
            AIRecords mAIRecords8 = this.this$0.getMAIRecords();
            if (mAIRecords8 != null) {
                String absolutePath = file.getAbsolutePath();
                kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                mAIRecords8.setMAudioPath(absolutePath);
            }
            this.this$0.saveDBRecord();
            SimultaneousInterpretationActivity simultaneousInterpretationActivity = this.this$0;
            AIRecords mAIRecords9 = simultaneousInterpretationActivity.getMAIRecords();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords9);
            if (simultaneousInterpretationActivity.addSendRecord(mAIRecords9) > 0) {
                ToastUtils.showLong(this.this$0.getString(R.string.save) + TokenParser.SP + this.this$0.getString(R.string.success_save), new Object[0]);
            } else {
                ToastUtils.showLong(this.this$0.getString(R.string.save) + TokenParser.SP + this.this$0.getString(R.string.fail), new Object[0]);
            }
            Handler mHandler = this.this$0.getMHandler();
            final SimultaneousInterpretationActivity simultaneousInterpretationActivity2 = this.this$0;
            mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oXIO0o0XI
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousInterpretationActivity$showSaveDialog$1$1.invoke$lambda$0(SimultaneousInterpretationActivity.this);
                }
            }, 1500L);
            return;
        }
        ToastUtils.showLong(this.this$0.getString(R.string.save) + TokenParser.SP + this.this$0.getString(R.string.fail) + " , " + this.this$0.getString(R.string.recording_translate_error_tip), new Object[0]);
    }
}
