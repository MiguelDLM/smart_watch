package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.MusicServerManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ServerOSSMusicItem;
import com.sma.smartv3.model.TeraBoxItemDLink;
import com.sma.smartv3.model.TeraBoxListItem;
import com.sma.smartv3.model.TransmissionMusicItem;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.work.UploadOSSWorker;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleSDCardInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nMusicManagerV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MusicManagerV2Activity.kt\ncom/sma/smartv3/ui/device/MusicManagerV2Activity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,537:1\n69#2,3:538\n72#2,5:542\n69#2,3:568\n72#2,5:572\n1#3:541\n1#3:571\n50#4,3:547\n53#4:553\n55#4,2:555\n50#4,3:577\n53#4:583\n55#4,2:585\n1549#5:550\n1620#5,2:551\n1622#5:554\n1549#5:557\n1620#5,3:558\n223#5,2:561\n1549#5:564\n1620#5,3:565\n1549#5:580\n1620#5,2:581\n1622#5:584\n1549#5:587\n1620#5,3:588\n36#6:563\n*S KotlinDebug\n*F\n+ 1 MusicManagerV2Activity.kt\ncom/sma/smartv3/ui/device/MusicManagerV2Activity\n*L\n117#1:538,3\n117#1:542,5\n409#1:568,3\n409#1:572,5\n117#1:541\n409#1:571\n131#1:547,3\n131#1:553\n131#1:555,2\n417#1:577,3\n417#1:583\n417#1:585,2\n131#1:550\n131#1:551,2\n131#1:554\n144#1:557\n144#1:558,3\n171#1:561,2\n269#1:564\n269#1:565,3\n417#1:580\n417#1:581,2\n417#1:584\n321#1:587\n321#1:588,3\n216#1:563\n*E\n"})
/* loaded from: classes12.dex */
public final class MusicManagerV2Activity extends MusicManagerActivity {
    private int downLoadIndex;
    private boolean isDownLoading;
    private boolean isStopDownLoading;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDownTipPopup;

    @OXOo.oOoXoXO
    private OSSClient mOSSClient;

    @OXOo.oOoXoXO
    private List<ServerOSSMusicItem> mSeverMusicCheckList;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAddPhoneBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$mAddPhoneBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) MusicManagerV2Activity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAddTeraBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$mAddTeraBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) MusicManagerV2Activity.this.findViewById(R.id.btn_bottom_tera_box);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAddServerBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$mAddServerBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) MusicManagerV2Activity.this.findViewById(R.id.btn_bottom_server);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO musicInformation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$musicInformation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MusicManagerV2Activity.this.findViewById(R.id.task_panel_music_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDownloadingProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$tvDownloadingProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerV2Activity.this.findViewById(R.id.task_panel_music_downloading_tv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO musicRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$musicRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MusicManagerV2Activity.this.findViewById(R.id.music_v2_recycler_layout);
        }
    });

    @OXOo.OOXIXo
    private List<TeraBoxListItem> checkList = new ArrayList();

    @OXOo.OOXIXo
    private List<TeraBoxItemDLink> mDLinkList = new ArrayList();

    @OXOo.OOXIXo
    private List<TransmissionMusicItem> mTransmissionMusicList = new ArrayList();

    @OXOo.OOXIXo
    private String access_tokens = "";

    @OXOo.OOXIXo
    private String refresh_tokens = "";

    @OXOo.OOXIXo
    private String mOSSBucket = "";

    @kotlin.jvm.internal.XX({"SMAP\nMusicManagerV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MusicManagerV2Activity.kt\ncom/sma/smartv3/ui/device/MusicManagerV2Activity$downOSSMusicLink$1\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,537:1\n36#2:538\n*S KotlinDebug\n*F\n+ 1 MusicManagerV2Activity.kt\ncom/sma/smartv3/ui/device/MusicManagerV2Activity$downOSSMusicLink$1\n*L\n482#1:538\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OSSCompletedCallback<GetObjectRequest, GetObjectResult> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ ServerOSSMusicItem f21956II0xO0;

        public oIX0oI(ServerOSSMusicItem serverOSSMusicItem) {
            this.f21956II0xO0 = serverOSSMusicItem;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@OXOo.oOoXoXO GetObjectRequest getObjectRequest, @OXOo.OOXIXo GetObjectResult result) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            long contentLength = result.getContentLength();
            if (contentLength > 0) {
                int i = (int) contentLength;
                byte[] bArr = new byte[i];
                int i2 = 0;
                while (i2 < contentLength) {
                    try {
                        i2 += result.getObjectContent().read(bArr, i2, i - i2);
                        if (!MusicManagerV2Activity.this.isStopDownLoading()) {
                            MusicManagerV2Activity.this.refreshTaskPanelDownLoad((i2 * 100) / i);
                        }
                    } catch (Exception e) {
                        OSSLog.logInfo(e.toString());
                    }
                }
                try {
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), this.f21956II0xO0.getTitle()));
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    if (!MusicManagerV2Activity.this.isStopDownLoading()) {
                        MusicManagerV2Activity musicManagerV2Activity = MusicManagerV2Activity.this;
                        musicManagerV2Activity.setMDownSuccessSize(musicManagerV2Activity.getMDownSuccessSize() + 1);
                        List list = MusicManagerV2Activity.this.mTransmissionMusicList;
                        String absolutePath = new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), this.f21956II0xO0.getTitle()).getAbsolutePath();
                        kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                        String uri = new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), this.f21956II0xO0.getTitle()).toURI().toString();
                        kotlin.jvm.internal.IIX0o.oO(uri, "toString(...)");
                        String uri2 = Uri.fromFile(new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), this.f21956II0xO0.getTitle())).toString();
                        kotlin.jvm.internal.IIX0o.oO(uri2, "toString(...)");
                        list.add(new TransmissionMusicItem(absolutePath, uri, uri2, this.f21956II0xO0.getTitle()));
                        MusicManagerV2Activity.this.severMusicNextMusic();
                    }
                } catch (Exception e2) {
                    OSSLog.logInfo(e2.toString());
                    OI0.oIX0oI.f1507oIX0oI.II0xO0(MusicManagerV2Activity.this.getTAG() + " FileOutputStream " + e2);
                    if (!MusicManagerV2Activity.this.isStopDownLoading()) {
                        ToastUtils.showLong("Music DownLoad Error", new Object[0]);
                        MusicManagerV2Activity.this.severMusicNextMusic();
                    } else {
                        MusicManagerV2Activity.this.onMusicFileTransferStop();
                    }
                }
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onFailure(@OXOo.oOoXoXO GetObjectRequest getObjectRequest, @OXOo.OOXIXo ClientException clientException, @OXOo.OOXIXo ServiceException serviceException) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(clientException, "clientException");
            kotlin.jvm.internal.IIX0o.x0xO0oo(serviceException, "serviceException");
            if (!MusicManagerV2Activity.this.isStopDownLoading()) {
                ToastUtils.showLong("Music DownLoad Error", new Object[0]);
                MusicManagerV2Activity.this.severMusicNextMusic();
            } else {
                MusicManagerV2Activity.this.onMusicFileTransferStop();
            }
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.II0xO0(MusicManagerV2Activity.this.getTAG() + " ErrorCode " + serviceException.getErrorCode());
            oix0oi.II0xO0(MusicManagerV2Activity.this.getTAG() + " RequestId  " + serviceException.getRequestId());
            oix0oi.II0xO0(MusicManagerV2Activity.this.getTAG() + " HostId   " + serviceException.getHostId());
            oix0oi.II0xO0(MusicManagerV2Activity.this.getTAG() + " RawMessag   " + serviceException.getRawMessage());
        }
    }

    public MusicManagerV2Activity() {
        setMMusicItemLayout(R.layout.item_music_v2);
        setTransferTip(R.string.music_down_transmit_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downLastSeverMusic() {
        String str = this.mOSSBucket;
        List<ServerOSSMusicItem> list = this.mSeverMusicCheckList;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
        ServerOSSMusicItem serverOSSMusicItem = list.get(this.downLoadIndex);
        OSSClient oSSClient = this.mOSSClient;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(oSSClient);
        downOSSMusicLink(str, serverOSSMusicItem, oSSClient);
    }

    private final void downOSSMusicLink(String str, ServerOSSMusicItem serverOSSMusicItem, OSSClient oSSClient) {
        oSSClient.asyncGetObject(new GetObjectRequest(str, serverOSSMusicItem.getPath()), new oIX0oI(serverOSSMusicItem));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downSuccess(TeraBoxListItem teraBoxListItem) {
        List<TransmissionMusicItem> list = this.mTransmissionMusicList;
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        String absolutePath = new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), teraBoxListItem.getServer_filename()).getAbsolutePath();
        kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        String uri = new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), teraBoxListItem.getServer_filename()).toURI().toString();
        kotlin.jvm.internal.IIX0o.oO(uri, "toString(...)");
        String uri2 = Uri.fromFile(new File(com.sma.smartv3.initializer.IXxxXO.xII(oix0oi), teraBoxListItem.getServer_filename())).toString();
        kotlin.jvm.internal.IIX0o.oO(uri2, "toString(...)");
        list.add(new TransmissionMusicItem(absolutePath, uri, uri2, teraBoxListItem.getServer_filename()));
        nextMusic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Button getMAddPhoneBottom() {
        return (Button) this.mAddPhoneBottom$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Button getMAddServerBottom() {
        return (Button) this.mAddServerBottom$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Button getMAddTeraBottom() {
        return (Button) this.mAddTeraBottom$delegate.getValue();
    }

    private final View getMusicInformation() {
        return (View) this.musicInformation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMusicRecyclerView() {
        return (View) this.musicRecyclerView$delegate.getValue();
    }

    private final TextView getTvDownloadingProgress() {
        return (TextView) this.tvDownloadingProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nextMusic() {
        if (this.isStopDownLoading) {
            return;
        }
        int i = this.downLoadIndex + 1;
        this.downLoadIndex = i;
        if (i >= this.mDLinkList.size()) {
            transmissionMusic();
        } else {
            downLoadLink();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMusicFileTransferStop$lambda$5(MusicManagerV2Activity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMusicRecyclerView().setVisibility(0);
        this$0.getTaskPanel().setVisibility(8);
        this$0.getMAddPhoneBottom().setEnabled(true);
        this$0.getMAddTeraBottom().setEnabled(true);
        this$0.getMAddServerBottom().setEnabled(true);
        this$0.showLoadPopup(false);
        this$0.browToDirDeviceFile();
        if (this$0.mTransmissionMusicList.size() > 0) {
            List<TransmissionMusicItem> list = this$0.mTransmissionMusicList;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(FileUtils.delete(((TransmissionMusicItem) it.next()).getPath())));
            }
            this$0.mTransmissionMusicList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTaskPanelDownLoad(final int i) {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.oX0I0O
            @Override // java.lang.Runnable
            public final void run() {
                MusicManagerV2Activity.refreshTaskPanelDownLoad$lambda$6(MusicManagerV2Activity.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskPanelDownLoad$lambda$6(MusicManagerV2Activity this$0, int i) {
        List list;
        Integer num;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getTvProgressTip().setText(R.string.tera_box_music_downloading);
        TextView tvTotalProgress = this$0.getTvTotalProgress();
        StringBuilder sb = new StringBuilder();
        sb.append(this$0.downLoadIndex + 1);
        sb.append("/ ");
        if (this$0.mSeverMusicCheckList != null && this$0.mDLinkList.size() == 0) {
            list = this$0.mSeverMusicCheckList;
            if (list == null) {
                num = null;
                sb.append(num);
                tvTotalProgress.setText(sb.toString());
                this$0.getPbProgress().setProgress(i);
                TextView tvDownloadingProgress = this$0.getTvDownloadingProgress();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
                tvDownloadingProgress.setText(sb2.toString());
            }
        } else {
            list = this$0.mDLinkList;
        }
        num = Integer.valueOf(list.size());
        sb.append(num);
        tvTotalProgress.setText(sb.toString());
        this$0.getPbProgress().setProgress(i);
        TextView tvDownloadingProgress2 = this$0.getTvDownloadingProgress();
        StringBuilder sb22 = new StringBuilder();
        sb22.append(i);
        sb22.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        tvDownloadingProgress2.setText(sb22.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void severMusicNextMusic() {
        if (this.isStopDownLoading) {
            return;
        }
        int i = this.downLoadIndex + 1;
        this.downLoadIndex = i;
        List<ServerOSSMusicItem> list = this.mSeverMusicCheckList;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
        if (i >= list.size()) {
            transmissionMusic();
        } else {
            downLastSeverMusic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopDownLoadRefreshProgress() {
        getTvProgressTip().setText(R.string.tera_box_music_downloading);
        getTvTotalProgress().setText("");
        getPbProgress().setProgress(0);
        getTvDownloadingProgress().setText("");
    }

    private final void transmissionMusic() {
        String title;
        List<ServerOSSMusicItem> list;
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.x00IOx
            @Override // java.lang.Runnable
            public final void run() {
                MusicManagerV2Activity.transmissionMusic$lambda$2(MusicManagerV2Activity.this);
            }
        });
        if (this.mDLinkList.size() == 0 && (list = this.mSeverMusicCheckList) != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
            if (list.size() - getMDownSuccessSize() >= 0) {
                List<ServerOSSMusicItem> list2 = this.mSeverMusicCheckList;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(list2);
                ToastUtils.showLong(getString(R.string.download_error_tip, Integer.valueOf(list2.size() - getMDownSuccessSize()), Integer.valueOf(getMDownSuccessSize())), new Object[0]);
            }
        } else if (this.mDLinkList.size() - getMDownSuccessSize() >= 0) {
            ToastUtils.showLong(getString(R.string.download_error_tip, Integer.valueOf(this.mDLinkList.size() - getMDownSuccessSize()), Integer.valueOf(getMDownSuccessSize())), new Object[0]);
        }
        if (this.mTransmissionMusicList.size() > 0) {
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            List<TransmissionMusicItem> list3 = this.mTransmissionMusicList;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list3, 10));
            for (TransmissionMusicItem transmissionMusicItem : list3) {
                if (transmissionMusicItem.getTitle().length() > 50) {
                    StringBuilder sb = new StringBuilder();
                    String substring = transmissionMusicItem.getTitle().substring(0, 50);
                    kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
                    sb.append(substring);
                    sb.append(".mp3");
                    title = sb.toString();
                } else {
                    title = transmissionMusicItem.getTitle();
                }
                arrayList.add(new ox0I(transmissionMusicItem.getUrl(), transmissionMusicItem.getUri(), title));
            }
            deviceFileManager.oOXoIIIo(arrayList);
            DeviceFileManager.f21743oIX0oI.X00IoxXI(getMSDCardBean());
            return;
        }
        getTaskPanel().setVisibility(8);
        onMusicFileTransferStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transmissionMusic$lambda$2(MusicManagerV2Activity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMusicInformation().setVisibility(0);
        this$0.getTvDownloadingProgress().setText("");
        this$0.isDownLoading = false;
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this$0.mDownTipPopup;
        if (xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public boolean doTransfer(@OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        if (this.isDownLoading) {
            ToastUtils.showLong(getString(isTransferTip()), new Object[0]);
            return false;
        }
        return super.doTransfer(action);
    }

    public final void downLoadLink() {
        if (this.mDLinkList.size() > 0 && !this.isStopDownLoading) {
            downLoadingShowView();
            refreshTaskPanelDownLoad(0);
            TeraBoxItemDLink teraBoxItemDLink = this.mDLinkList.get(this.downLoadIndex);
            for (final TeraBoxListItem teraBoxListItem : this.checkList) {
                if (teraBoxListItem.getFs_id() == teraBoxItemDLink.getFs_id()) {
                    this.isDownLoading = true;
                    MusicServerManager.f20080oIX0oI.oxoX(teraBoxItemDLink.getDlink(), this.access_tokens, teraBoxListItem.getServer_filename(), new Oox.oOoXoXO<Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$downLoadLink$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num) {
                            invoke2(num);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.oOoXoXO Integer num) {
                            if (num != null && num.intValue() == -1) {
                                if (MusicManagerV2Activity.this.isStopDownLoading()) {
                                    return;
                                }
                                ToastUtils.showLong("Music DownLoad Error", new Object[0]);
                                MusicManagerV2Activity.this.nextMusic();
                                return;
                            }
                            X0.oOoXoXO oooxoxo = new X0.oOoXoXO(0, 100);
                            if (num != null && oooxoxo.xxIXOIIO(num.intValue())) {
                                if (MusicManagerV2Activity.this.isStopDownLoading()) {
                                    return;
                                }
                                MusicManagerV2Activity musicManagerV2Activity = MusicManagerV2Activity.this;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
                                musicManagerV2Activity.refreshTaskPanelDownLoad(num.intValue());
                                return;
                            }
                            if (num != null && num.intValue() == 200) {
                                if (MusicManagerV2Activity.this.isStopDownLoading()) {
                                    return;
                                }
                                MusicManagerV2Activity musicManagerV2Activity2 = MusicManagerV2Activity.this;
                                musicManagerV2Activity2.setMDownSuccessSize(musicManagerV2Activity2.getMDownSuccessSize() + 1);
                                MusicManagerV2Activity.this.downSuccess(teraBoxListItem);
                                return;
                            }
                            MusicManagerV2Activity.this.onMusicFileTransferStop();
                            ToastUtils.showLong("Music Error " + num, new Object[0]);
                        }
                    });
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        onMusicFileTransferStop();
    }

    public final void downLoadingShowView() {
        getTvCancel().setVisibility(0);
        getTvRetry().setVisibility(8);
        getTaskPanel().setVisibility(0);
        getMusicInformation().setVisibility(8);
        getTvDownloadingProgress().setVisibility(0);
    }

    @OXOo.OOXIXo
    public final String getAccess_tokens() {
        return this.access_tokens;
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void getDeviceFileList() {
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.XoI0Ixx0 getMDownTipPopup() {
        return this.mDownTipPopup;
    }

    @OXOo.OOXIXo
    public final String getMOSSBucket() {
        return this.mOSSBucket;
    }

    @OXOo.oOoXoXO
    public final OSSClient getMOSSClient() {
        return this.mOSSClient;
    }

    @OXOo.oOoXoXO
    public final List<ServerOSSMusicItem> getMSeverMusicCheckList() {
        return this.mSeverMusicCheckList;
    }

    @OXOo.OOXIXo
    public final String getRefresh_tokens() {
        return this.refresh_tokens;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        Button mAddServerBottom = getMAddServerBottom();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        int i2 = 8;
        if (projectManager.I0xX0()) {
            i = 0;
        } else {
            i = 8;
        }
        mAddServerBottom.setVisibility(i);
        Button mAddTeraBottom = getMAddTeraBottom();
        if (projectManager.OxO()) {
            i2 = 0;
        }
        mAddTeraBottom.setVisibility(i2);
    }

    public final boolean isDownLoading() {
        return this.isDownLoading;
    }

    public final boolean isStopDownLoading() {
        return this.isStopDownLoading;
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_music_manager_v2;
    }

    public final void onBottomServerClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) ServerMusicActivity.class));
    }

    public final void onBottomTeraBoxClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        String string = xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24397OoO);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        this.access_tokens = string;
        String string2 = xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24386OIOoIIOIx);
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        this.refresh_tokens = string2;
        showLoadPopup(false);
        String str = this.access_tokens;
        if (str != null && str.length() > 0) {
            MusicServerManager.f20080oIX0oI.Oxx0xo(this.access_tokens, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onBottomTeraBoxClick$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    if (!z && MusicManagerV2Activity.this.getRefresh_tokens() != null && MusicManagerV2Activity.this.getRefresh_tokens().length() > 0) {
                        MusicServerManager musicServerManager = MusicServerManager.f20080oIX0oI;
                        String refresh_tokens = MusicManagerV2Activity.this.getRefresh_tokens();
                        final MusicManagerV2Activity musicManagerV2Activity = MusicManagerV2Activity.this;
                        musicServerManager.Oo(refresh_tokens, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onBottomTeraBoxClick$1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z2) {
                                MusicManagerV2Activity.this.dismissLoadPopup();
                                MusicManagerV2Activity musicManagerV2Activity2 = MusicManagerV2Activity.this;
                                musicManagerV2Activity2.startActivity(new Intent(musicManagerV2Activity2, (Class<?>) TeraBoxFileManagerActivity.class));
                            }
                        });
                        return;
                    }
                    MusicManagerV2Activity.this.dismissLoadPopup();
                    MusicManagerV2Activity musicManagerV2Activity2 = MusicManagerV2Activity.this;
                    musicManagerV2Activity2.startActivity(new Intent(musicManagerV2Activity2, (Class<?>) TeraBoxFileManagerActivity.class));
                }
            });
        } else {
            dismissLoadPopup();
            startActivity(new Intent(this, (Class<?>) TeraBoxFileManagerActivity.class));
        }
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void onCancel(@OXOo.OOXIXo View view) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        boolean z = this.isDownLoading;
        Integer valueOf = Integer.valueOf(R.string.cancel);
        if (z) {
            if (this.mDownTipPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
                xoI0Ixx02.IoOoX(R.string.cancle_download);
                xoI0Ixx02.xI(Integer.valueOf(R.string.cancle_download_tip));
                xoI0Ixx02.oo0xXOI0I(1);
                xoI0Ixx02.X00IoxXI(valueOf, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onCancel$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onCancel$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        List list;
                        View musicRecyclerView;
                        Button mAddPhoneBottom;
                        Button mAddTeraBottom;
                        Button mAddServerBottom;
                        MusicManagerV2Activity.this.setDownLoading(false);
                        MusicManagerV2Activity.this.setStopDownLoading(true);
                        MusicManagerV2Activity.this.stopDownLoadRefreshProgress();
                        MusicServerManager.f20080oIX0oI.oIX0oI();
                        list = MusicManagerV2Activity.this.mDLinkList;
                        list.clear();
                        List<ServerOSSMusicItem> mSeverMusicCheckList = MusicManagerV2Activity.this.getMSeverMusicCheckList();
                        if (mSeverMusicCheckList != null) {
                            mSeverMusicCheckList.clear();
                        }
                        musicRecyclerView = MusicManagerV2Activity.this.getMusicRecyclerView();
                        musicRecyclerView.setVisibility(0);
                        MusicManagerV2Activity.this.getTaskPanel().setVisibility(8);
                        mAddPhoneBottom = MusicManagerV2Activity.this.getMAddPhoneBottom();
                        mAddPhoneBottom.setEnabled(true);
                        mAddTeraBottom = MusicManagerV2Activity.this.getMAddTeraBottom();
                        mAddTeraBottom.setEnabled(true);
                        mAddServerBottom = MusicManagerV2Activity.this.getMAddServerBottom();
                        mAddServerBottom.setEnabled(true);
                        if (MusicManagerV2Activity.this.mTransmissionMusicList.size() > 0) {
                            List list2 = MusicManagerV2Activity.this.mTransmissionMusicList;
                            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Boolean.valueOf(FileUtils.delete(((TransmissionMusicItem) it.next()).getPath())));
                            }
                            MusicManagerV2Activity.this.mTransmissionMusicList.clear();
                        }
                        return Boolean.TRUE;
                    }
                });
                this.mDownTipPopup = xoI0Ixx02;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mDownTipPopup;
            if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mDownTipPopup) != null) {
                xoI0Ixx0.IIXOooo();
                return;
            }
            return;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx04 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
        xoI0Ixx04.IoOoX(R.string.cancel_transfer);
        xoI0Ixx04.xI(Integer.valueOf(R.string.cancel_transfer_music_tip));
        xoI0Ixx04.oo0xXOI0I(1);
        xoI0Ixx04.X00IoxXI(valueOf, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onCancel$2$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        });
        xoI0Ixx04.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$onCancel$2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                Button mAddPhoneBottom;
                Button mAddTeraBottom;
                Button mAddServerBottom;
                DeviceFileManager.f21743oIX0oI.IO();
                MusicManagerV2Activity.this.getTaskPanel().setVisibility(8);
                mAddPhoneBottom = MusicManagerV2Activity.this.getMAddPhoneBottom();
                mAddPhoneBottom.setEnabled(true);
                mAddTeraBottom = MusicManagerV2Activity.this.getMAddTeraBottom();
                mAddTeraBottom.setEnabled(true);
                mAddServerBottom = MusicManagerV2Activity.this.getMAddServerBottom();
                mAddServerBottom.setEnabled(true);
                return Boolean.TRUE;
            }
        });
        xoI0Ixx04.IIXOooo();
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void onMusicFileTransferStart() {
        super.onMusicFileTransferStart();
        getTaskPanel().setVisibility(0);
        getMAddPhoneBottom().setEnabled(false);
        getMAddTeraBottom().setEnabled(false);
        getMAddServerBottom().setEnabled(false);
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void onMusicFileTransferStop() {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.XO0o
            @Override // java.lang.Runnable
            public final void run() {
                MusicManagerV2Activity.onMusicFileTransferStop$lambda$5(MusicManagerV2Activity.this);
            }
        });
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void preventUse(boolean z) {
        super.preventUse(z);
        getMAddPhoneBottom().setEnabled(!z);
        getMAddTeraBottom().setEnabled(!z);
        getMAddServerBottom().setEnabled(!z);
    }

    public final void setAccess_tokens(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.access_tokens = str;
    }

    public final void setDownLoading(boolean z) {
        this.isDownLoading = z;
    }

    public final void setMDownTipPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0) {
        this.mDownTipPopup = xoI0Ixx0;
    }

    public final void setMOSSBucket(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mOSSBucket = str;
    }

    public final void setMOSSClient(@OXOo.oOoXoXO OSSClient oSSClient) {
        this.mOSSClient = oSSClient;
    }

    public final void setMSeverMusicCheckList(@OXOo.oOoXoXO List<ServerOSSMusicItem> list) {
        this.mSeverMusicCheckList = list;
    }

    public final void setRefresh_tokens(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.refresh_tokens = str;
    }

    public final void setStopDownLoading(boolean z) {
        this.isStopDownLoading = z;
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24426XXXI)
    public final void severMusicCheckList(@OXOo.OOXIXo Object data) {
        Collection ooXIXxIX2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        this.mDLinkList.clear();
        List<ServerOSSMusicItem> list = this.mSeverMusicCheckList;
        if (list != null) {
            list.clear();
        }
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24426XXXI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), ServerOSSMusicItem.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<ServerOSSMusicItem> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        this.mSeverMusicCheckList = o0Xo0XII;
        if (o0Xo0XII != null && o0Xo0XII.isEmpty()) {
            return;
        }
        preventUse(false);
        MusicServerManager.f20080oIX0oI.OxxIIOOXO(new Oox.oOoXoXO<Pair<? extends UploadOSSWorker.StsRamData, ? extends Integer>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$severMusicCheckList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Pair<? extends UploadOSSWorker.StsRamData, ? extends Integer> pair) {
                invoke2((Pair<UploadOSSWorker.StsRamData, Integer>) pair);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Pair<UploadOSSWorker.StsRamData, Integer> pair) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "pair");
                Integer second = pair.getSecond();
                MusicManagerV2Activity musicManagerV2Activity = MusicManagerV2Activity.this;
                int intValue = second.intValue();
                if (intValue == 0 || intValue == 1) {
                    UploadOSSWorker.StsRamData first = pair.getFirst();
                    musicManagerV2Activity.setMOSSClient(MusicServerManager.f20080oIX0oI.II0xO0(first));
                    if (first == null || musicManagerV2Activity.getMOSSClient() == null) {
                        return;
                    }
                    musicManagerV2Activity.downLoadingShowView();
                    musicManagerV2Activity.refreshTaskPanelDownLoad(0);
                    musicManagerV2Activity.downLoadIndex = 0;
                    musicManagerV2Activity.setDownLoading(true);
                    musicManagerV2Activity.setMOSSBucket(first.getBucket());
                    musicManagerV2Activity.downLastSeverMusic();
                }
            }
        });
    }

    @Override // com.sma.smartv3.ui.device.MusicManagerActivity
    public void showFreeSpace() {
        int i;
        TextView tvFreeSpace = getTvFreeSpace();
        if (ProductManager.f20544oIX0oI.OXxx0OO()) {
            i = 0;
        } else {
            i = 8;
        }
        tvFreeSpace.setVisibility(i);
        BleSDCardInfo bleSDCardInfo = (BleSDCardInfo) BleCache.getObject$default(BleCache.INSTANCE, BleKey.SDCARD_INFO, BleSDCardInfo.class, null, 4, null);
        getTvFreeSpace().setText(getString(R.string.storage_item) + TokenParser.SP + TextConvertKt.OO0x0xX(bleSDCardInfo, false, 2, null));
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24416XIXIxO)
    public final void teraBoxCheckList(@OXOo.OOXIXo Object data) {
        Collection ooXIXxIX2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24416XIXIxO)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), TeraBoxListItem.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.checkList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().remove(com.sma.smartv3.util.XoI0Ixx0.f24416XIXIxO);
        if (this.access_tokens.length() == 0) {
            String string = xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24397OoO);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            this.access_tokens = string;
        }
        if (this.checkList.size() == 0) {
            return;
        }
        getMAddPhoneBottom().setEnabled(false);
        getMAddTeraBottom().setEnabled(false);
        getMAddServerBottom().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        List<TeraBoxListItem> list = this.checkList;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Boolean.valueOf(arrayList.add(Long.valueOf(((TeraBoxListItem) it2.next()).getFs_id()))));
        }
        this.mDLinkList.clear();
        List<ServerOSSMusicItem> list2 = this.mSeverMusicCheckList;
        if (list2 != null) {
            list2.clear();
        }
        this.isStopDownLoading = false;
        MusicServerManager.f20080oIX0oI.xxIXOIIO(this.access_tokens, arrayList, new Oox.oOoXoXO<List<? extends TeraBoxItemDLink>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerV2Activity$teraBoxCheckList$2
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends TeraBoxItemDLink> list3) {
                invoke2((List<TeraBoxItemDLink>) list3);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<TeraBoxItemDLink> list3) {
                if (list3 != null) {
                    MusicManagerV2Activity.this.mDLinkList = CollectionsKt___CollectionsKt.o0Xo0XII(list3);
                    MusicManagerV2Activity.this.downLoadIndex = 0;
                    MusicManagerV2Activity.this.setMDownSuccessSize(0);
                    ToastUtils.showLong(MusicManagerV2Activity.this.getString(R.string.music_down_transmit_tip), new Object[0]);
                    MusicManagerV2Activity.this.downLoadLink();
                    return;
                }
                MusicManagerV2Activity.this.onMusicFileTransferStop();
                ToastUtils.showLong(R.string.get_music_down_link_error);
            }
        });
    }
}
