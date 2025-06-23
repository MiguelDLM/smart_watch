package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.co_fit.R;
import java.util.List;

/* loaded from: classes12.dex */
public final class XX0 extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public Activity f21389II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.oOoXoXO
    public CommonAdapter<String> f21390xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RecyclerView f21391xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XX0(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21389II0XooXoX = activity;
        LayoutInflater.from(activity).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_list_recycler);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f21391xxIXOIIO = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(Oxx0IOOO(), 1, false));
        Oxx0xo(48);
        xxIXOIIO().findViewById(R.id.pop_list_closure).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.I0oOoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.xXxxox0I(XX0.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_list_data_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oxxXoxO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.IIX0o(XX0.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_list_app_recording).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.ooXIXxIX(view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_list_bluetooth_recording).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oxXx0IX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.xI(view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_list_clear_recording).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xo0x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.oo0xXOI0I(view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_list_stop_play).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xXOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0.oo(view);
            }
        });
        x0xO0oo(false);
        setHeight(-2);
    }

    public static final void IIX0o(XX0 this$0, View view) {
        List<String> datas;
        List<String> datas2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        CommonAdapter<String> commonAdapter = this$0.f21390xoIox;
        if (commonAdapter != null && (datas2 = commonAdapter.getDatas()) != null) {
            datas2.clear();
        }
        CommonAdapter<String> commonAdapter2 = this$0.f21390xoIox;
        if (commonAdapter2 != null && (datas = commonAdapter2.getDatas()) != null) {
            datas.add(0, "清除完毕");
        }
        CommonAdapter<String> commonAdapter3 = this$0.f21390xoIox;
        if (commonAdapter3 != null) {
            commonAdapter3.notifyDataSetChanged();
        }
    }

    public static final void oo(View view) {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "点击按钮, 停止播放");
        DcsTtsPlayer.INSTANCE.stop();
        com.sma.smartv3.util.xoxXI.f24733oIX0oI.xxIXOIIO();
    }

    public static final void oo0xXOI0I(View view) {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "点击按钮, 执行结束录制");
        VoiceManager.INSTANCE.stopRecording();
    }

    public static final void ooXIXxIX(View view) {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "点击按钮, 执行app录音");
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setRecordBluetooth(false);
        voiceManager.startRecord();
    }

    public static final void xI(View view) {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "点击按钮, 执行蓝牙录音");
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setRecordBluetooth(true);
        voiceManager.startRecord();
    }

    public static final void xXxxox0I(XX0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public final void IO(@OXOo.oOoXoXO CommonAdapter<String> commonAdapter) {
        this.f21390xoIox = commonAdapter;
        this.f21391xxIXOIIO.setAdapter(commonAdapter);
    }

    @OXOo.OOXIXo
    public final Activity IoOoX() {
        return this.f21389II0XooXoX;
    }

    public final void X00IoxXI(@OXOo.OOXIXo Activity activity) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "<set-?>");
        this.f21389II0XooXoX = activity;
    }

    @OXOo.OOXIXo
    public final RecyclerView Xx000oIo() {
        return this.f21391xxIXOIIO;
    }

    @OXOo.oOoXoXO
    public final CommonAdapter<String> oOXoIIIo() {
        return this.f21390xoIox;
    }

    @Override // OOOI.I0Io
    public void xoXoI(@OXOo.OOXIXo View anchor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (Oxx0IOOO().isFinishing()) {
                return;
            }
            showAtLocation(anchor, 17, 0, (-anchor.getHeight()) * 2);
            Oox.oIX0oI<kotlin.oXIO0o0XI> OOXIXo2 = OOXIXo();
            if (OOXIXo2 != null) {
                OOXIXo2.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ XX0(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_list2 : i);
    }
}
