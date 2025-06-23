package com.sma.smartv3.ui.device.fragment;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.DeleteCallback;
import com.jieli.jl_filebrowse.interfaces.FileObserver;
import com.jieli.jl_filebrowse.interfaces.SimpleFileObserver;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.pop.xOOOX;
import com.sma.smartv3.ui.device.DeviceFileManager;
import com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment;
import com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$mDeviceFileCallback$2;
import com.sma.smartv3.util.oO;
import com.sma.smartv3.util.x0xO0oo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;

/* loaded from: classes12.dex */
public class BaseJLFileManageFragment extends BaseDSLRecyclerFragment {
    private boolean isNeedToDownloadFile;
    private boolean isSync;

    @oOoXoXO
    private XoI0Ixx0 mDeleteTipPopup;

    @oOoXoXO
    private XoI0Ixx0 mErrorPopup;

    @oOoXoXO
    private Handler mHandler111;

    @oOoXoXO
    private I0X0x0oIo mLoadingPopup;

    @oOoXoXO
    private xOOOX mProgressPop;

    @oOoXoXO
    private SDCardBean mSDCardBean;
    private int onFileReceiverSize;
    private int progress1111;
    private int retryFrequency;

    @OOXIXo
    private final List<FileStruct> mFiles = new ArrayList();

    @OOXIXo
    private final String TAG = "BaseJLFileManageActivity";
    private final int loadTimeOut = 255;

    @OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.sma.smartv3.ui.device.fragment.II0xO0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean mHandler$lambda$1;
            mHandler$lambda$1 = BaseJLFileManageFragment.mHandler$lambda$1(BaseJLFileManageFragment.this, message);
            return mHandler$lambda$1;
        }
    });

    @OOXIXo
    private final X0IIOO mDeviceFileCallback$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BaseJLFileManageFragment$mDeviceFileCallback$2.oIX0oI>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$mDeviceFileCallback$2

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements DeviceFileManager.oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ BaseJLFileManageFragment f22652oIX0oI;

            public oIX0oI(BaseJLFileManageFragment baseJLFileManageFragment) {
                this.f22652oIX0oI = baseJLFileManageFragment;
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void I0Io(int i) {
                this.f22652oIX0oI.refreshTaskPanel(i, 0);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void II0xO0(int i, int i2, @OOXIXo String msg) {
                IIX0o.x0xO0oo(msg, "msg");
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void X0o0xo(int i, boolean z) {
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void XO(int i) {
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oIX0oI(int i) {
                DeviceFileManager.oIX0oI.C0943oIX0oI.oIX0oI(this, i);
                if (DeviceFileManager.f21743oIX0oI.OxI()) {
                    this.f22652oIX0oI.dismissLoadPopup();
                }
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oxoX(int i, int i2) {
                this.f22652oIX0oI.refreshTaskPanel(i, i2);
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final oIX0oI invoke() {
            return new oIX0oI(BaseJLFileManageFragment.this);
        }
    });

    @OOXIXo
    private final I0Io mFileObserver = new I0Io();

    @OOXIXo
    private Runnable myTask = new oxoX();

    @XX({"SMAP\nBaseJLFileManageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseJLFileManageFragment.kt\ncom/sma/smartv3/ui/device/fragment/BaseJLFileManageFragment$mFileObserver$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n1#2:548\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class I0Io implements FileObserver {
        public I0Io() {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void OnFlayCallback(boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> OnFlayCallback " + z);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onFileReadFailed " + i);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStart() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onFileReadStart");
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(BaseJLFileManageFragment.this.getMSDCardBean());
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onFileReadStop " + z + TokenParser.SP + currentReadFile.getName());
            if (!z) {
                BaseJLFileManageFragment baseJLFileManageFragment = BaseJLFileManageFragment.this;
                baseJLFileManageFragment.loadMore(baseJLFileManageFragment.getMSDCardBean());
            } else if (OxI.oX0I0O(currentReadFile.getName(), "music", true)) {
                BaseJLFileManageFragment.this.showList();
            }
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReceiver(@OOXIXo List<FileStruct> fileStructs) {
            IIX0o.x0xO0oo(fileStructs, "fileStructs");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onFileReceiver size:" + fileStructs.size() + ", " + fileStructs);
            BaseJLFileManageFragment.this.getMFiles().addAll(fileStructs);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(@OOXIXo List<SDCardBean> list) {
            Object obj;
            IIX0o.x0xO0oo(list, "list");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onSdCardStatusChange " + list);
            BaseJLFileManageFragment baseJLFileManageFragment = BaseJLFileManageFragment.this;
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SDCardBean) obj).isOnline()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            baseJLFileManageFragment.setMSDCardBean((SDCardBean) obj);
            BaseJLFileManageFragment baseJLFileManageFragment2 = BaseJLFileManageFragment.this;
            baseJLFileManageFragment2.getCurrentInfo(baseJLFileManageFragment2.getMSDCardBean());
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements DeleteCallback {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ int f22650II0xO0;

        public II0xO0(int i) {
            this.f22650II0xO0 = i;
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onError(int i, @OOXIXo FileStruct file) {
            IIX0o.x0xO0oo(file, "file");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onDeviceFileDeleteError " + i + ", " + file);
            BaseJLFileManageFragment.this.dismissLoadPopup();
            ToastUtils.showLong(i + '-' + file.getName() + BaseJLFileManageFragment.this.getString(R.string.failed_to_delete), new Object[0]);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onFinish() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onDeviceFileDeleteFinish");
            BaseJLFileManageFragment.this.getMFiles().remove(this.f22650II0xO0);
            BaseJLFileManageFragment.this.showList();
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onSuccess(@OOXIXo FileStruct p0) {
            IIX0o.x0xO0oo(p0, "p0");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseJLFileManageFragment.this.TAG + " -> onDeviceFileDelete " + p0);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends SimpleFileObserver {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f22653I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SDCardBean f22654II0xO0;

        public oIX0oI(SDCardBean sDCardBean, String str) {
            this.f22654II0xO0 = sDCardBean;
            this.f22653I0Io = str;
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            super.onFileReadFailed(i);
            FileBrowseManager.getInstance().removeFileObserver(this);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            super.onFileReadStop(z);
            FileBrowseManager.getInstance().removeFileObserver(this);
            BaseJLFileManageFragment.this.browToDir(this.f22654II0xO0, this.f22653I0Io);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(@OOXIXo List<? extends SDCardBean> onLineCards) {
            IIX0o.x0xO0oo(onLineCards, "onLineCards");
            super.onSdCardStatusChange(onLineCards);
            FileBrowseManager.getInstance().removeFileObserver(this);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            BaseJLFileManageFragment baseJLFileManageFragment = BaseJLFileManageFragment.this;
            baseJLFileManageFragment.setProgress1111(baseJLFileManageFragment.getProgress1111() + 1);
            BaseJLFileManageFragment.this.taskProgress();
            if (BaseJLFileManageFragment.this.getProgress1111() <= 100 && (handler = BaseJLFileManageFragment.this.mHandler111) != null) {
                handler.postDelayed(this, 40L);
            }
        }
    }

    private final void append(SDCardBean sDCardBean, FileStruct fileStruct) {
        int appenBrowse = FileBrowseManager.getInstance().appenBrowse(fileStruct, sDCardBean);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> appendToDir " + appenBrowse);
        if (appenBrowse == 0) {
            this.mFiles.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void browToDir(SDCardBean sDCardBean, String str) {
        Object obj;
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return;
        }
        while (currentReadFile.getParent() != null) {
            FileBrowseManager.getInstance().backBrowse(sDCardBean, false);
            currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
            IIX0o.oO(currentReadFile, "getCurrentReadFile(...)");
        }
        List<FileStruct> childFileStructs = currentReadFile.getChildFileStructs();
        IIX0o.oO(childFileStructs, "getChildFileStructs(...)");
        Iterator<T> it = childFileStructs.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                FileStruct fileStruct = (FileStruct) obj;
                if (!fileStruct.isFile() && OxI.oX0I0O(fileStruct.getName(), str, true)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FileStruct fileStruct2 = (FileStruct) obj;
        if (fileStruct2 != null) {
            append(sDCardBean, fileStruct2);
            return;
        }
        if (!currentReadFile.isLoadFinished(false)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> browseToDir add simpleFileObserver");
            oIX0oI oix0oi = new oIX0oI(sDCardBean, str);
            FileBrowseManager.getInstance().addFileObserver(oix0oi);
            FileBrowseManager.getInstance().setPageSize(30);
            if (FileBrowseManager.getInstance().loadMore(sDCardBean) != 0) {
                FileBrowseManager.getInstance().removeFileObserver(oix0oi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadPopup() {
        I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentInfo(SDCardBean sDCardBean) {
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> getCurrentInfo folder " + currentReadFile.getName());
        if (OxI.oX0I0O(currentReadFile.getName(), "music", true) && currentReadFile.getLevel() == 1) {
            if (!currentReadFile.isLoadFinished(false) && currentReadFile.getChildFileStructs().size() < 1) {
                loadMore(sDCardBean);
                return;
            } else {
                currentReadFile.isLoadFinished(false);
                return;
            }
        }
        browToDir(sDCardBean, "music");
    }

    private final BaseJLFileManageFragment$mDeviceFileCallback$2.oIX0oI getMDeviceFileCallback() {
        return (BaseJLFileManageFragment$mDeviceFileCallback$2.oIX0oI) this.mDeviceFileCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore(SDCardBean sDCardBean) {
        int loadMore = FileBrowseManager.getInstance().loadMore(sDCardBean);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> loadMoreFile " + loadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$1(BaseJLFileManageFragment this$0, Message it) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(it, "it");
        if (it.what == this$0.loadTimeOut) {
            this$0.dismissLoadPopup();
            if (!DeviceFileManager.f21743oIX0oI.OxI()) {
                this$0.showErrorPop();
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " loadTimeOut retryFrequency=" + this$0.retryFrequency);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTaskPanel(int i, int i2) {
    }

    public static /* synthetic */ void showDeleteTipPopup$default(BaseJLFileManageFragment baseJLFileManageFragment, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i = R.string.tip;
            }
            if ((i4 & 2) != 0) {
                i2 = R.string.clear_ai_chat_list;
            }
            if ((i4 & 4) != 0) {
                i3 = R.string.confirm;
            }
            baseJLFileManageFragment.showDeleteTipPopup(i, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDeleteTipPopup");
    }

    private final void showErrorPop() {
        XoI0Ixx0 xoI0Ixx0;
        if (this.mErrorPopup == null) {
            final XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.bt3_connect_error);
            xoI0Ixx02.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$showErrorPop$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$showErrorPop$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    BaseJLFileManageFragment.I0Io i0Io;
                    BaseJLFileManageFragment.I0Io i0Io2;
                    BaseJLFileManageFragment.showLoadPopup$default(BaseJLFileManageFragment.this, false, 1, null);
                    BaseJLFileManageFragment baseJLFileManageFragment = BaseJLFileManageFragment.this;
                    baseJLFileManageFragment.setRetryFrequency(baseJLFileManageFragment.getRetryFrequency() + 1);
                    if (BaseJLFileManageFragment.this.getRetryFrequency() > 2) {
                        BaseJLFileManageFragment.this.setRetryFrequency(0);
                        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
                        i0Io = BaseJLFileManageFragment.this.mFileObserver;
                        fileBrowseManager.removeFileObserver(i0Io);
                        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                        deviceFileManager.IXxxXO();
                        Application application = xoI0Ixx02.Oxx0IOOO().getApplication();
                        IIX0o.oO(application, "getApplication(...)");
                        deviceFileManager.o00(application);
                        FileBrowseManager fileBrowseManager2 = FileBrowseManager.getInstance();
                        i0Io2 = BaseJLFileManageFragment.this.mFileObserver;
                        fileBrowseManager2.addFileObserver(i0Io2);
                    }
                    DeviceFileManager.f21743oIX0oI.oO();
                    return Boolean.TRUE;
                }
            });
            this.mErrorPopup = xoI0Ixx02;
        }
        XoI0Ixx0 xoI0Ixx03 = this.mErrorPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mErrorPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    public static /* synthetic */ void showLoadPopup$default(BaseJLFileManageFragment baseJLFileManageFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            baseJLFileManageFragment.showLoadPopup(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadPopup");
    }

    public static /* synthetic */ void syncFailed$default(BaseJLFileManageFragment baseJLFileManageFragment, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            baseJLFileManageFragment.syncFailed(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncFailed");
    }

    public static /* synthetic */ void syncProgress$default(BaseJLFileManageFragment baseJLFileManageFragment, float f, float f2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                f = 0.0f;
            }
            if ((i & 2) != 0) {
                f2 = 100.0f;
            }
            baseJLFileManageFragment.syncProgress(f, f2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncProgress");
    }

    public final void add() {
        if (!DeviceFileManager.f21743oIX0oI.OxI()) {
            showErrorPop();
        } else {
            doTransfer(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$add$1
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
                    BaseJLFileManageFragment.this.getFile();
                }
            });
        }
    }

    public void confirmDeleteFile() {
    }

    public final void deleteFile(int i) {
        Integer num;
        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
        SDCardBean sDCardBean = this.mSDCardBean;
        boolean z = true;
        List<FileStruct> XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.mFiles.get(i));
        SDCardBean sDCardBean2 = this.mSDCardBean;
        if (sDCardBean2 != null) {
            num = Integer.valueOf(sDCardBean2.getType());
        } else {
            num = null;
        }
        IIX0o.ooOOo0oXI(num);
        if (num.intValue() <= 1) {
            z = false;
        }
        fileBrowseManager.deleteFile(sDCardBean, XOxIOxOx2, z, new II0xO0(i));
    }

    public final boolean doTransfer(@OOXIXo Oox.oIX0oI<oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        if (DeviceFileManager.f21743oIX0oI.X0IIOO()) {
            ToastUtils.showLong(getString(R.string.transfering), new Object[0]);
            return false;
        }
        action.invoke();
        return true;
    }

    public void getFile() {
    }

    @OOXIXo
    public final List<FileStruct> getMFiles() {
        return this.mFiles;
    }

    @oOoXoXO
    public final xOOOX getMProgressPop() {
        return this.mProgressPop;
    }

    @oOoXoXO
    public final SDCardBean getMSDCardBean() {
        return this.mSDCardBean;
    }

    @OOXIXo
    public final Runnable getMyTask() {
        return this.myTask;
    }

    public final int getOnFileReceiverSize() {
        return this.onFileReceiverSize;
    }

    public final int getProgress1111() {
        return this.progress1111;
    }

    public final int getRetryFrequency() {
        return this.retryFrequency;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final boolean isNeedToDownloadFile() {
        return this.isNeedToDownloadFile;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public int layoutId() {
        return R.layout.activity_app_store;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        FileBrowseManager.getInstance().removeFileObserver(this.mFileObserver);
        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
        deviceFileManager.XxX0x0xxx(getMDeviceFileCallback());
        deviceFileManager.IXxxXO();
        super.onDestroy();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void setMProgressPop(@oOoXoXO xOOOX xooox) {
        this.mProgressPop = xooox;
    }

    public final void setMSDCardBean(@oOoXoXO SDCardBean sDCardBean) {
        this.mSDCardBean = sDCardBean;
    }

    public final void setMyTask(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "<set-?>");
        this.myTask = runnable;
    }

    public final void setNeedToDownloadFile(boolean z) {
        this.isNeedToDownloadFile = z;
    }

    public final void setOnFileReceiverSize(int i) {
        this.onFileReceiverSize = i;
    }

    public final void setProgress1111(int i) {
        this.progress1111 = i;
    }

    public final void setRetryFrequency(int i) {
        this.retryFrequency = i;
    }

    public final void setSync(boolean z) {
        this.isSync = z;
    }

    public final void showDeleteTipPopup(int i, int i2, int i3) {
        if (this.mDeleteTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(i);
            xoI0Ixx0.xI(Integer.valueOf(i2));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$showDeleteTipPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(i3, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment$showDeleteTipPopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    BaseJLFileManageFragment.this.confirmDeleteFile();
                    return Boolean.TRUE;
                }
            });
            this.mDeleteTipPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void showInstallingPopup() {
        syncData();
        if (this.mHandler111 == null) {
            this.mHandler111 = new Handler(Looper.getMainLooper());
        }
        this.progress1111 = 0;
        Handler handler = this.mHandler111;
        if (handler != null) {
            handler.postDelayed(this.myTask, 50L);
        }
    }

    public void showList() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showList -> size:" + this.mFiles.size() + ", " + this.mFiles);
        this.mHandler.removeMessages(this.loadTimeOut);
        dismissLoadPopup();
        XoI0Ixx0 xoI0Ixx0 = this.mErrorPopup;
        if (xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
    }

    public final void showLoadPopup(boolean z) {
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new I0X0x0oIo(getMActivity());
        }
        I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            if (z) {
                i0X0x0oIo.xXxxox0I(R.string.music_transfer_load_title);
                i0X0x0oIo.xxX(Integer.valueOf(R.string.music_transfer_load_tip));
                this.mHandler.sendEmptyMessageDelayed(this.loadTimeOut, 25000L);
            } else {
                i0X0x0oIo.xXxxox0I(0);
                i0X0x0oIo.xxX(null);
            }
        }
        I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
    }

    public final void syncData() {
        if (this.mProgressPop == null) {
            FragmentActivity requireActivity = requireActivity();
            IIX0o.oO(requireActivity, "requireActivity(...)");
            xOOOX xooox = new xOOOX(requireActivity, 0, 2, null);
            xooox.xxX(R.string.app_store_install_title);
            xooox.XIxXXX0x0(0);
            this.mProgressPop = xooox;
            xooox.x0xO0oo(false);
            xOOOX xooox2 = this.mProgressPop;
            if (xooox2 != null) {
                xooox2.IIXOooo();
            }
            syncProgress$default(this, 0.0f, 0.0f, 3, null);
        }
    }

    public final void syncFailed(int i) {
        xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.dismiss();
        }
        this.mProgressPop = null;
        ToastUtils.showLong(oO.f24511oIX0oI.I0Io(i), new Object[0]);
    }

    public final void syncProgress(float f, float f2) {
        xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.XIxXXX0x0((int) ((f / f2) * 100));
        }
        if (f2 == f) {
            xOOOX xooox2 = this.mProgressPop;
            if (xooox2 != null) {
                xooox2.dismiss();
            }
            this.mProgressPop = null;
            BleInitializer.f20700XO.IXO(false);
            this.isSync = false;
            if (f != 0.0f || f2 != 0.0f) {
                x0xO0oo.II0xO0("add_app_store_success", null, 2, null);
            }
        }
    }

    public void taskProgress() {
        syncProgress(this.progress1111, 100.0f);
        if (this.progress1111 > 100) {
            xOOOX xooox = this.mProgressPop;
            if (xooox != null) {
                xooox.dismiss();
            }
            Handler handler = this.mHandler111;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mHandler111 = null;
        }
    }
}
