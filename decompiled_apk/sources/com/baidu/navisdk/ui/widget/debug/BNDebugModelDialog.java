package com.baidu.navisdk.ui.widget.debug;

import XXO0.oIX0oI;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.documentfile.provider.DocumentFile;
import com.baidu.navisdk.behavrules.scene.d;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.baidu.navisdk.ui.widget.StatusButton;
import com.baidu.navisdk.ui.widget.debug.ActivityResultUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.q0;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.loop.a;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.google.android.exoplayer2.C;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BNDebugModelDialog extends Dialog {
    public static final boolean ANTI_CHEAT_DEBUG_SHOW = false;
    private ArrayAdapter<String> adapter;
    private CmdDebugModeGetURL cmdDebug;
    private final int[] hDivider;
    private final Activity mActivity;
    private DebugUrlAdapter mAdapter;
    private StatusButton mAntiCheatBtn;
    private View mAntiCheatView;
    private StatusButton mArRecordBox;
    private Button mBlueToothBlankBtn;
    private EditText mBlueToothBlankEt;
    private TextView mBuildTimeTv;
    private View mBuildView;
    private Button mCalcRoadVersionBtn;
    private EditText mCalcRoadVersionEt;
    private View mCalcRoadVersionView;
    private StatusButton mChallengeModeDebugBtn;
    private View mChallengeModeDebugView;
    protected ImageView mCloseIV;
    private Button mCloudConfigDecryptBtn;
    private StatusButton mCommuteDebugBtn;
    private View mCommuteDebugView;
    private Button mCreateRouteBtn;
    private StatusButton mCruiserDebugBtn;
    private View mCruiserDebugView;
    private StatusButton mDrivingToolOpenBtn;
    private Button mDrivingToolStartBtn;
    private ExpandableListView mELUrlDebugView;
    private Button mFutureTripEtaBtn;
    private EditText mFutureTripEtaEditText;
    private View mFutureTripEtaView;
    private StatusButton mGpsVdrBtn;
    private View mGpsVdrView;
    private List<DebugModeMessageBean> mGuideMsg;
    private final Handler mHandler;
    private StatusButton mHttpsDebugBtn;
    private View mHttpsDebugView;
    private StatusButton mIMEnvStatusButton;
    private StatusButton mImageLogBtn;
    private View mImageLogView;
    private EditText mInputEdt;
    private StatusButton mJavaLogBtn;
    private View mJavaLogView;
    private StatusButton mLaneLineStatus;
    private StatusButton mLeakBtn;
    private View mLeakView;
    private StatusButton mMockVdrBtn;
    private View mMockVdrView;
    private StatusButton mMonkeyBtn;
    private View mMonkeyView;
    private Button mMuitipleBtn;
    private StatusButton mNativeLogBtn;
    private View mNativeLogView;
    private StatusButton mNotificationDebugBtn;
    private View mNotificationDebugView;
    protected DialogInterface.OnCancelListener mOnCancelListener;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mPanelContainer;
    private RelativeLayout mRLGPSDebugView;
    private RelativeLayout mRLUrlDebugExpandView;
    private RelativeLayout mRLUrlDebugView;
    private View mRelaceMapRsBtn;
    private StatusButton mRootScreenBtn;
    private View mRootScreenView;
    private Button mRouteGuideVersionBtn;
    private EditText mRouteGuideVersionEt;
    private Spinner mRouteListSp;
    private LinearLayout mRouteLl;
    private StatusButton mSBGPSDebugView;
    private View mSceneGuideSelectBtn;
    private RelativeLayout mShowPullBtn;
    private Button mSingleDtBtn;
    private StatusButton.onStatusButtonClickListener mStatusButtonClickListener;
    private Button mStopDtBtn;
    private ImageView mTTSSpeedDownIv;
    private Button mTTSSpeedResetBtn;
    private TextView mTTSSpeedTv;
    private ImageView mTTSSpeedUpIv;
    private StatusButton mTTSVocoderBtn;
    private View mTTSVocoderView;
    private ImageView mTTSVolDownIv;
    private Button mTTSVolResetBtn;
    private TextView mTTSVolTv;
    private ImageView mTTSVolUpIv;
    private TextView mTVGPSDebugView;
    private TextView mTVUrlDebugColseView;
    private TextView mTVUrlDebugReverseView;
    private TextView mTVUrlDebugSaveColseView;
    private TextView mTVUrlDebugView;
    private Spinner mTaskListSp;
    private StatusButton mUseTextureBtn;
    private View mUseTextureView;
    private StatusButton mUserTestStatusButton;
    private TextView mUserTestTv;
    private RelativeLayout mUserTestView;
    private StatusButton mVDRBtn;
    private View mVDRView;
    private StatusButton mVmsrSwitchView;
    private StatusButton mVmsrVerifyView;
    private StatusButton qaCruiserBtn;
    private View qaCruiserView;

    /* renamed from: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog$35, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass35 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild;

        static {
            int[] iArr = new int[StatusButton.StatusButtonChild.values().length];
            $SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild = iArr;
            try {
                iArr[StatusButton.StatusButtonChild.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[StatusButton.StatusButtonChild.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[StatusButton.StatusButtonChild.MID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class DebugUrlAdapter extends BaseExpandableListAdapter {
        ViewHolder mViewHolder;

        /* loaded from: classes8.dex */
        public class ViewHolder {
            CheckBox mCb;
            TextView mTVUrl;

            private ViewHolder() {
            }
        }

        public DebugUrlAdapter() {
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i, int i2) {
            return ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).serList.get(i2);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i, int i2) {
            return i2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            DebugModeMessageSerBean debugModeMessageSerBean = ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).serList.get(i2);
            if (view == null) {
                View inflate = JarUtils.inflate(BNDebugModelDialog.this.mActivity, R.layout.nsdk_layout_debug_url_children, null);
                ViewHolder viewHolder = new ViewHolder();
                this.mViewHolder = viewHolder;
                viewHolder.mTVUrl = (TextView) inflate.findViewById(R.id.second_textview);
                this.mViewHolder.mCb = (CheckBox) inflate.findViewById(R.id.child_check_box);
                inflate.setTag(this.mViewHolder);
                view = inflate;
            } else {
                this.mViewHolder = (ViewHolder) view.getTag();
            }
            this.mViewHolder.mTVUrl.setText(debugModeMessageSerBean.key + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + debugModeMessageSerBean.value);
            this.mViewHolder.mCb.setFocusable(false);
            this.mViewHolder.mCb.setClickable(false);
            this.mViewHolder.mCb.setChecked(debugModeMessageSerBean.flag);
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i) {
            return ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).serList.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i) {
            return BNDebugModelDialog.this.mGuideMsg.get(i);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return BNDebugModelDialog.this.mGuideMsg.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i) {
            return i;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = JarUtils.inflate(BNDebugModelDialog.this.mActivity, R.layout.nsdk_layout_debug_url_parent, null);
            }
            TextView textView = (TextView) view.findViewById(R.id.parent_textview);
            if (i >= 0) {
                try {
                    if (i < BNDebugModelDialog.this.mGuideMsg.size()) {
                        textView.setText(((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).mSceneName);
                    }
                } catch (Exception unused) {
                }
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i, int i2) {
            LogUtil.e("wangyang", "selectable");
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public SpinnerSelectedListener() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* loaded from: classes8.dex */
    public class SpinnerURLSelectedListener implements AdapterView.OnItemSelectedListener {
        public SpinnerURLSelectedListener() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public BNDebugModelDialog(Activity activity) {
        super(activity);
        View view = null;
        this.mPanelContainer = null;
        this.mOnCancelListener = null;
        this.mJavaLogBtn = null;
        this.mNativeLogBtn = null;
        this.mBuildTimeTv = null;
        this.mBuildView = null;
        this.mJavaLogView = null;
        this.mNativeLogView = null;
        this.mMonkeyView = null;
        this.mMonkeyBtn = null;
        this.mAntiCheatView = null;
        this.mAntiCheatBtn = null;
        this.mGuideMsg = null;
        this.mOnClickListener = null;
        this.mStatusButtonClickListener = null;
        this.mTTSVocoderView = null;
        this.mTTSVocoderBtn = null;
        this.mTTSSpeedUpIv = null;
        this.mTTSSpeedDownIv = null;
        this.mTTSSpeedResetBtn = null;
        this.mTTSSpeedTv = null;
        this.mTTSVolTv = null;
        this.mTTSVolUpIv = null;
        this.mTTSVolDownIv = null;
        this.mTTSVolResetBtn = null;
        this.mNotificationDebugView = null;
        this.mNotificationDebugBtn = null;
        this.mRootScreenView = null;
        this.mRootScreenBtn = null;
        this.mImageLogView = null;
        this.mImageLogBtn = null;
        this.mCalcRoadVersionView = null;
        this.mCalcRoadVersionEt = null;
        this.mCalcRoadVersionBtn = null;
        this.mRouteGuideVersionEt = null;
        this.mRouteGuideVersionBtn = null;
        this.mBlueToothBlankEt = null;
        this.mBlueToothBlankBtn = null;
        this.mCloudConfigDecryptBtn = null;
        this.mHttpsDebugView = null;
        this.mHttpsDebugBtn = null;
        this.mVDRView = null;
        this.mVDRBtn = null;
        this.mLeakView = null;
        this.mLeakBtn = null;
        this.mGpsVdrView = null;
        this.mGpsVdrBtn = null;
        this.mCommuteDebugView = null;
        this.mCommuteDebugBtn = null;
        this.mCruiserDebugView = null;
        this.mCruiserDebugBtn = null;
        this.mChallengeModeDebugView = null;
        this.mChallengeModeDebugBtn = null;
        this.mFutureTripEtaView = null;
        this.mFutureTripEtaBtn = null;
        this.mFutureTripEtaEditText = null;
        this.mMockVdrView = null;
        this.mMockVdrBtn = null;
        this.mUseTextureView = null;
        this.mUseTextureBtn = null;
        this.qaCruiserView = null;
        this.qaCruiserBtn = null;
        this.mRelaceMapRsBtn = null;
        this.mSceneGuideSelectBtn = null;
        this.mLaneLineStatus = null;
        this.mArRecordBox = null;
        this.hDivider = new int[]{R.id.bnav_rg_menu_h_divider_1, R.id.bnav_rg_menu_h_divider_2, R.id.bnav_rg_menu_h_divider_3, R.id.bnav_rg_menu_h_divider_4, R.id.bnav_rg_menu_h_divider_5, R.id.bnav_rg_menu_h_divider_6, R.id.bnav_rg_menu_h_divider_7, R.id.bnav_rg_menu_h_divider_8, R.id.bnav_rg_menu_h_divider_9};
        this.mHandler = new a("DMD") { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.1
            @Override // com.baidu.navisdk.util.worker.loop.a
            public void onMessage(Message message) {
                if (1405 == message.what) {
                    if (message.arg1 != 0) {
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "url配置请求失败 + error msg = " + message.arg1);
                        return;
                    }
                    BNDebugModelDialog bNDebugModelDialog = BNDebugModelDialog.this;
                    bNDebugModelDialog.mGuideMsg = bNDebugModelDialog.cmdDebug.getGuideMsg();
                    if (BNDebugModelDialog.this.mGuideMsg != null && BNDebugModelDialog.this.mGuideMsg.size() > 0) {
                        if (BNDebugModelDialog.this.mAdapter == null) {
                            BNDebugModelDialog.this.mAdapter = new DebugUrlAdapter();
                            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
                        }
                        BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
                    }
                }
            }
        };
        this.mActivity = activity;
        Window window = getWindow();
        requestWindowFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().gravity = 17;
        try {
            view = JarUtils.oldInflate(activity, R.layout.nsdk_layout_debug_mode_dialog, null);
        } catch (Exception unused) {
        }
        if (view == null) {
            return;
        }
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        getWindow().getAttributes().gravity = 17;
        this.cmdDebug = new CmdDebugModeGetURL();
        findView();
        setCloseIVListener();
        initListener();
        initButtonStatus();
    }

    private void addNewSwitchBtnItem(String str, boolean z, String str2, StatusButton.onStatusButtonClickListener onstatusbuttonclicklistener) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_debug_mode_switch_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.text);
        StatusButton statusButton = (StatusButton) inflate.findViewById(R.id.btn);
        statusButton.setAllBtnClickListener(onstatusbuttonclicklistener);
        if (BNSettingManager.getBoolean(str, z)) {
            statusButton.setLeftBtnChecked();
        } else {
            statusButton.setRightBtnChecked();
        }
        statusButton.setLeftButtonText(b.h(R.string.nsdk_string_open));
        statusButton.setRightButtonText(b.h(R.string.nsdk_string_close));
        statusButton.setMidBtnGone(true);
        textView.setText(str2);
        this.mPanelContainer.addView(inflate, new ViewGroup.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_menu_item_height)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decryptCloudConfigFile() {
        c.a().a((com.baidu.navisdk.util.worker.b) new com.baidu.navisdk.util.worker.b<String, Boolean>("decryptCloudConfigFile", null) { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.32
            @Override // com.baidu.navisdk.util.worker.b
            public void callback(final Boolean bool) {
                c.a().a((f) new f<Boolean, String>("BNImageLoaderEngine-submit-2", bool) { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.32.1
                    @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                    public String execute() {
                        if (bool.booleanValue() && com.baidu.navisdk.framework.a.c().a() != null) {
                            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "解码成功！请在/BaiduMap/bnav/cache/中查看");
                        }
                        return null;
                    }
                }, new e(99, 0));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v1 */
            /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Writer] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Writer] */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileWriter, java.io.Writer] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x00ac -> B:22:0x00af). Please report as a decompilation issue!!! */
            @Override // com.baidu.navisdk.util.worker.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.lang.Boolean execute() {
                /*
                    r9 = this;
                    java.lang.String r0 = "EncryptData"
                    java.lang.StringBuffer r1 = new java.lang.StringBuffer
                    r1.<init>()
                    com.baidu.navisdk.module.cloudconfig.g r2 = new com.baidu.navisdk.module.cloudconfig.g
                    r2.<init>()
                    java.io.File r3 = r2.g()
                    java.io.File r4 = new java.io.File
                    java.lang.String r5 = r3.getParent()
                    java.lang.String r6 = "initConfig_decrypt"
                    r4.<init>(r5, r6)
                    boolean r5 = r4.exists()
                    if (r5 == 0) goto L24
                    r4.delete()
                L24:
                    r5 = 1024(0x400, float:1.435E-42)
                    char[] r5 = new char[r5]
                    r6 = 0
                    r4.createNewFile()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
                    java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
                    java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
                    r8.<init>(r3)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
                    r7.<init>(r8)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
                L36:
                    int r3 = r7.read(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    r8 = -1
                    if (r3 == r8) goto L46
                    r8 = 0
                    r1.append(r5, r8, r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    goto L36
                L42:
                    r0 = move-exception
                    goto L89
                L44:
                    r1 = move-exception
                    goto L8c
                L46:
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    java.lang.String r2 = r2.i()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    java.lang.String r1 = com.baidu.navisdk.util.common.a.a(r2, r1)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    if (r2 == 0) goto L6a
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    r2.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    java.lang.String r3 = "decrypt content: "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    r2.append(r1)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    com.baidu.navisdk.util.common.LogUtil.e(r0, r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                L6a:
                    java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    r2.<init>(r4)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                    r2.write(r1)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L86
                    r2.close()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L86
                    r7.close()     // Catch: java.io.IOException -> L79
                    goto L7d
                L79:
                    r0 = move-exception
                    r0.printStackTrace()
                L7d:
                    r2.close()     // Catch: java.io.IOException -> L81
                    goto Laf
                L81:
                    r0 = move-exception
                    goto Lac
                L83:
                    r0 = move-exception
                L84:
                    r6 = r2
                    goto L89
                L86:
                    r1 = move-exception
                L87:
                    r6 = r7
                    goto L95
                L89:
                    r1 = r6
                    r6 = r7
                    goto Lb5
                L8c:
                    r2 = r6
                    goto L87
                L8e:
                    r0 = move-exception
                    goto L92
                L90:
                    r1 = move-exception
                    goto L94
                L92:
                    r1 = r6
                    goto Lb5
                L94:
                    r2 = r6
                L95:
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb2
                    com.baidu.navisdk.util.common.LogUtil.e(r0, r1)     // Catch: java.lang.Throwable -> Lb2
                    if (r6 == 0) goto La6
                    r6.close()     // Catch: java.io.IOException -> La2
                    goto La6
                La2:
                    r0 = move-exception
                    r0.printStackTrace()
                La6:
                    if (r2 == 0) goto Laf
                    r2.close()     // Catch: java.io.IOException -> L81
                    goto Laf
                Lac:
                    r0.printStackTrace()
                Laf:
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    return r0
                Lb2:
                    r0 = move-exception
                    r7 = r6
                    goto L84
                Lb5:
                    if (r6 == 0) goto Lbf
                    r6.close()     // Catch: java.io.IOException -> Lbb
                    goto Lbf
                Lbb:
                    r2 = move-exception
                    r2.printStackTrace()
                Lbf:
                    if (r1 == 0) goto Lc9
                    r1.close()     // Catch: java.io.IOException -> Lc5
                    goto Lc9
                Lc5:
                    r1 = move-exception
                    r1.printStackTrace()
                Lc9:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.AnonymousClass32.execute():java.lang.Boolean");
            }
        }, new e(99, 0));
    }

    private int getSpeIndexFromUrl(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith(BNWebViewClient.URL_HTTP_PREFIX)) {
            i = 7;
            if (str.length() > 7) {
                str = str.substring(7);
                return str.indexOf("/") + i;
            }
        }
        if (str.startsWith(BNWebViewClient.URL_HTTPS_PREFIX)) {
            i = 8;
            if (str.length() > 8) {
                str = str.substring(8);
                return str.indexOf("/") + i;
            }
        }
        i = 0;
        return str.indexOf("/") + i;
    }

    private String getUrlHost(String str) {
        int speIndexFromUrl = getSpeIndexFromUrl(str);
        if (speIndexFromUrl < 0 || str == null || str.length() <= speIndexFromUrl + 1) {
            return null;
        }
        return str.substring(0, speIndexFromUrl);
    }

    private String getUrlWithNoHost(String str) {
        int i;
        int speIndexFromUrl = getSpeIndexFromUrl(str);
        if (speIndexFromUrl < 0 || str == null || str.length() <= (i = speIndexFromUrl + 1)) {
            return null;
        }
        return str.substring(i);
    }

    private void initListener() {
        initStatusButtonClickListener();
        StatusButton statusButton = this.mJavaLogBtn;
        if (statusButton != null) {
            statusButton.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton2 = this.mNotificationDebugBtn;
        if (statusButton2 != null) {
            statusButton2.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton3 = this.mRootScreenBtn;
        if (statusButton3 != null) {
            statusButton3.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton4 = this.mImageLogBtn;
        if (statusButton4 != null) {
            statusButton4.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton5 = this.mHttpsDebugBtn;
        if (statusButton5 != null) {
            statusButton5.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton6 = this.mNativeLogBtn;
        if (statusButton6 != null) {
            statusButton6.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton7 = this.mMonkeyBtn;
        if (statusButton7 != null) {
            statusButton7.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton8 = this.mTTSVocoderBtn;
        if (statusButton8 != null) {
            statusButton8.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton9 = this.mSBGPSDebugView;
        if (statusButton9 != null) {
            statusButton9.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton10 = this.mUserTestStatusButton;
        if (statusButton10 != null) {
            statusButton10.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton11 = this.mDrivingToolOpenBtn;
        if (statusButton11 != null) {
            statusButton11.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton12 = this.mVmsrSwitchView;
        if (statusButton12 != null) {
            statusButton12.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton13 = this.mVmsrVerifyView;
        if (statusButton13 != null) {
            statusButton13.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        ImageView imageView = this.mTTSSpeedUpIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        int parseInt = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
                        if (parseInt < 9) {
                            TextView textView = BNDebugModelDialog.this.mTTSSpeedTv;
                            StringBuilder sb = new StringBuilder();
                            int i = parseInt + 1;
                            sb.append(i);
                            sb.append("");
                            textView.setText(sb.toString());
                            BNSettingManager.setTTSSpeedParam(i);
                            return;
                        }
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "当前为最高语速");
                    }
                }
            });
        }
        ImageView imageView2 = this.mTTSSpeedDownIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        int parseInt = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
                        if (parseInt > 0) {
                            TextView textView = BNDebugModelDialog.this.mTTSSpeedTv;
                            StringBuilder sb = new StringBuilder();
                            int i = parseInt - 1;
                            sb.append(i);
                            sb.append("");
                            textView.setText(sb.toString());
                            BNSettingManager.setTTSSpeedParam(i);
                            return;
                        }
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "当前为最低语速");
                    }
                }
            });
        }
        Button button = this.mTTSSpeedResetBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        BNDebugModelDialog.this.mTTSSpeedTv.setText(String.valueOf(5));
                    }
                    BNSettingManager.setTTSSpeedParam(5);
                }
            });
        }
        ImageView imageView3 = this.mTTSVolUpIv;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSVolTv != null) {
                        int parseInt = Integer.parseInt(BNDebugModelDialog.this.mTTSVolTv.getText().toString());
                        if (parseInt < 15) {
                            TextView textView = BNDebugModelDialog.this.mTTSVolTv;
                            StringBuilder sb = new StringBuilder();
                            int i = parseInt + 1;
                            sb.append(i);
                            sb.append("");
                            textView.setText(sb.toString());
                            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                            if (o != null) {
                                o.setTTSVolParam(i);
                                return;
                            }
                            return;
                        }
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "当前为最高音量");
                    }
                }
            });
        }
        ImageView imageView4 = this.mTTSVolDownIv;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSVolTv != null) {
                        int parseInt = Integer.parseInt(BNDebugModelDialog.this.mTTSVolTv.getText().toString());
                        if (parseInt > 0) {
                            TextView textView = BNDebugModelDialog.this.mTTSVolTv;
                            StringBuilder sb = new StringBuilder();
                            int i = parseInt - 1;
                            sb.append(i);
                            sb.append("");
                            textView.setText(sb.toString());
                            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                            if (o != null) {
                                o.setTTSVolParam(i);
                                return;
                            }
                            return;
                        }
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "当前为最低音量");
                    }
                }
            });
        }
        Button button2 = this.mTTSVolResetBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mTTSVolTv != null) {
                        BNDebugModelDialog.this.mTTSVolTv.setText(String.valueOf(9));
                    }
                    VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                    if (o != null) {
                        o.setTTSVolParam(9);
                    }
                }
            });
        }
        Button button3 = this.mCalcRoadVersionBtn;
        if (button3 != null && this.mCalcRoadVersionEt != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.27
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String obj = BNDebugModelDialog.this.mCalcRoadVersionEt.getText().toString();
                    if ("100".equals(obj)) {
                        try {
                            Thread.currentThread();
                            Thread.sleep(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                        } catch (Exception unused) {
                        }
                    }
                    if (l0.c(obj)) {
                        obj = "0";
                    }
                    JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("AndroidRpVer", obj);
                    BNSettingManager.setDebugModeCalcRoadVersion(obj);
                }
            });
        }
        Button button4 = this.mRouteGuideVersionBtn;
        if (button4 != null && this.mRouteGuideVersionEt != null) {
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.28
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String obj = BNDebugModelDialog.this.mRouteGuideVersionEt.getText().toString();
                    if (l0.c(obj)) {
                        obj = "0";
                    }
                    JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("RgDicVer", obj);
                    BNSettingManager.setDebugModeRouteGuideVersion(obj);
                }
            });
        }
        Button button5 = this.mBlueToothBlankBtn;
        if (button5 != null) {
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.29
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String obj = BNDebugModelDialog.this.mBlueToothBlankEt.getText().toString();
                    if (l0.c(obj)) {
                        obj = "-1";
                    }
                    int intValue = Integer.valueOf(obj).intValue();
                    if (intValue >= -1 && intValue <= 7) {
                        BNSettingManager.putInt("BlueToothBlankRate", intValue);
                    } else {
                        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "请输入-1到7之间的数字");
                    }
                }
            });
        }
        Button button6 = this.mCloudConfigDecryptBtn;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.30
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BNDebugModelDialog.this.decryptCloudConfigFile();
                }
            });
        }
        StatusButton statusButton14 = this.mVDRBtn;
        if (statusButton14 != null) {
            statusButton14.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton15 = this.mLeakBtn;
        if (statusButton15 != null) {
            statusButton15.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton16 = this.mGpsVdrBtn;
        if (statusButton16 != null) {
            statusButton16.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton17 = this.mCommuteDebugBtn;
        if (statusButton17 != null) {
            statusButton17.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton18 = this.mCruiserDebugBtn;
        if (statusButton18 != null) {
            statusButton18.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton19 = this.mChallengeModeDebugBtn;
        if (statusButton19 != null) {
            statusButton19.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton20 = this.mMockVdrBtn;
        if (statusButton20 != null) {
            statusButton20.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton21 = this.mUseTextureBtn;
        if (statusButton21 != null) {
            statusButton21.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton22 = this.qaCruiserBtn;
        if (statusButton22 != null) {
            statusButton22.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton23 = this.mLaneLineStatus;
        if (statusButton23 != null) {
            statusButton23.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        StatusButton statusButton24 = this.mIMEnvStatusButton;
        if (statusButton24 != null) {
            statusButton24.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
        Button button7 = this.mFutureTripEtaBtn;
        if (button7 != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDebugModelDialog.this.mFutureTripEtaEditText != null && BNDebugModelDialog.this.mFutureTripEtaEditText.getText() != null && !TextUtils.isEmpty(BNDebugModelDialog.this.mFutureTripEtaEditText.getText().toString())) {
                        BNSettingManager.setFutureTripEtaDebugUrl(BNDebugModelDialog.this.mFutureTripEtaEditText.getText().toString());
                    } else {
                        TipTool.onCreateDebugToast(BNDebugModelDialog.this.getContext(), "what's your problem ?");
                    }
                }
            });
        }
        StatusButton statusButton25 = this.mArRecordBox;
        if (statusButton25 != null) {
            statusButton25.setAllBtnClickListener(this.mStatusButtonClickListener);
        }
    }

    private void initStatusButtonClickListener() {
        this.mStatusButtonClickListener = new StatusButton.onStatusButtonClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.20
            /* JADX WARN: Removed duplicated region for block: B:286:0x0446  */
            /* JADX WARN: Removed duplicated region for block: B:288:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.navisdk.ui.widget.StatusButton.onStatusButtonClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(com.baidu.navisdk.ui.widget.StatusButton r8, com.baidu.navisdk.ui.widget.StatusButton.StatusButtonChild r9) {
                /*
                    Method dump skipped, instructions count: 1138
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.AnonymousClass20.onClick(com.baidu.navisdk.ui.widget.StatusButton, com.baidu.navisdk.ui.widget.StatusButton$StatusButtonChild):void");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mapReplaceChangeVersion() {
        String str = this.mActivity.getFilesDir().getAbsoluteFile() + "/cfg/a/DVVersion.cfg";
        try {
            JSONObject jSONObject = new JSONObject(s.e(str));
            JSONArray jSONArray = jSONObject.getJSONArray("assets");
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONArray.getJSONObject(i).put("version", MaterialSearchView.f18521Xx000oIo);
            }
            s.b(str, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceMap() {
        ActivityResultUtil.getInstance().startActivityForResult(com.baidu.navisdk.framework.a.c().b(), new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 4112, new ActivityResultUtil.Callback() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.34
            @Override // com.baidu.navisdk.ui.widget.debug.ActivityResultUtil.Callback
            public void onActivityForResult(int i, int i2, Intent intent) {
                if (i == 4112 && i2 == -1) {
                    if (q0.a(DocumentFile.fromTreeUri(BNDebugModelDialog.this.mActivity, intent.getData()), DocumentFile.fromFile(new File(BNDebugModelDialog.this.mActivity.getFilesDir().getAbsolutePath() + "/cfg/a/")), BNDebugModelDialog.this.mActivity)) {
                        BNDebugModelDialog.this.mapReplaceChangeVersion();
                        TipTool.toast("替换成功，重启生效");
                    } else {
                        TipTool.toast("替换失败");
                    }
                }
            }
        });
    }

    public static void resetDebugStatus() {
        String debugModeCalcRoadVersion = BNSettingManager.getDebugModeCalcRoadVersion();
        if (!"0".equals(debugModeCalcRoadVersion)) {
            JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("AndroidRpVer", debugModeCalcRoadVersion);
        }
        BNSettingManager.setShowJavaLog(false);
        if (JNIGuidanceControl.getInstance().IsMapLoggerOpen()) {
            JNIGuidanceControl.getInstance().SetMapLoggerOpen(false);
        }
        if (BNSettingManager.isRootScreenOpen()) {
            BNSettingManager.setRootScreenOpen(false);
        }
        if (BNSettingManager.isUseHttpsOfflineURL()) {
            BNSettingManager.setUseHttpsOfflineURL(false);
        }
        if (BNSettingManager.isShowNativeLog()) {
            BNSettingManager.setShowNativeLog(false);
        }
        if (BNSettingManager.isMonkey()) {
            BNSettingManager.setMonkey(false);
        }
        if (BNSettingManager.isGPSDebug()) {
            BNSettingManager.setGPSDebug(false);
        }
        if (BNSettingManager.isShowingDrivingTool()) {
            BNSettingManager.setShowingDrivingTool(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synUrlHostOneMoudlue(DebugModeMessageSerBean debugModeMessageSerBean) {
        if (debugModeMessageSerBean != null && debugModeMessageSerBean.key.equals("UGCEventUpload")) {
            if (debugModeMessageSerBean.flag) {
                String urlHost = getUrlHost(debugModeMessageSerBean.value);
                String urlWithNoHost = getUrlWithNoHost(com.baidu.navisdk.util.http.b.d().a("UgcEventFeedback"));
                if (urlHost == null) {
                    return;
                }
                if (urlWithNoHost != null) {
                    com.baidu.navisdk.util.http.b.d().a("UgcEventFeedback", urlHost + "/" + urlWithNoHost);
                }
                String urlWithNoHost2 = getUrlWithNoHost(com.baidu.navisdk.util.http.b.d().a("ugcRcEventCounts"));
                if (urlWithNoHost2 != null) {
                    com.baidu.navisdk.util.http.b.d().a("ugcRcEventCounts", urlHost + "/" + urlWithNoHost2);
                }
                String urlWithNoHost3 = getUrlWithNoHost(com.baidu.navisdk.util.http.b.d().a("UgcGetEventDetail"));
                if (urlWithNoHost3 != null) {
                    com.baidu.navisdk.util.http.b.d().a("UgcGetEventDetail", urlHost + "/" + urlWithNoHost3);
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.http.b.d().a("UgcEventFeedback", com.baidu.navisdk.util.http.b.d().a("UgcEventFeedback"));
            com.baidu.navisdk.util.http.b.d().a("ugcRcEventCounts", com.baidu.navisdk.util.http.b.d().a("ugcRcEventCounts"));
            com.baidu.navisdk.util.http.b.d().a("UgcGetEventDetail", com.baidu.navisdk.util.http.b.d().a("UgcGetEventDetail"));
        }
    }

    public void findView() {
        View view;
        View view2;
        RelativeLayout relativeLayout;
        StatusButton statusButton;
        this.mPanelContainer = (LinearLayout) findViewById(R.id.bnav_rg_menu_func_panel);
        this.mCloseIV = (ImageView) findViewById(R.id.iv_dialog_close);
        this.mBuildView = findViewById(R.id.bnav_rg_menu_factory_build_item);
        this.mJavaLogView = findViewById(R.id.bnav_rg_menu_factory_java_log);
        View findViewById = findViewById(R.id.bnav_rg_menu_factory_native_log);
        this.mNativeLogView = findViewById;
        findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                BNMapController.getInstance().getMapController().a(0, (ArrayList<Bundle>) null);
                return false;
            }
        });
        this.mMonkeyView = findViewById(R.id.bnav_rg_menu_factory_monkey);
        this.mBuildTimeTv = (TextView) findViewById(R.id.bnav_rg_menu_build_item_tv);
        this.mJavaLogBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_java_log_checkbox);
        this.mNativeLogBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_native_log_checkbox);
        this.mMonkeyBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_monkey_checkbox);
        this.mTTSVocoderView = findViewById(R.id.bnav_rg_menu_factory_tts_vocoder_debug);
        this.mTTSVocoderBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_tts_vocoder_checkbox);
        this.mAntiCheatView = findViewById(R.id.bnav_rg_menu_factory_antic);
        this.mAntiCheatBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_antic_checkbox);
        this.mTTSSpeedUpIv = (ImageView) findViewById(R.id.bnav_rg_menu_tts_speed_debug_up_iv);
        this.mTTSSpeedDownIv = (ImageView) findViewById(R.id.bnav_rg_menu_tts_speed_debug_down_iv);
        this.mTTSSpeedResetBtn = (Button) findViewById(R.id.bnav_rg_menu_tts_speed_debug_reset_btn);
        this.mTTSSpeedTv = (TextView) findViewById(R.id.bnav_rg_menu_tts_speed_num_debug_tv);
        this.mTTSVolTv = (TextView) findViewById(R.id.bnav_rg_menu_tts_vol_num_debug_tv);
        this.mTTSVolUpIv = (ImageView) findViewById(R.id.bnav_rg_menu_tts_vol_debug_up_iv);
        this.mTTSVolDownIv = (ImageView) findViewById(R.id.bnav_rg_menu_tts_vol_debug_down_iv);
        this.mTTSVolResetBtn = (Button) findViewById(R.id.bnav_rg_menu_tts_vol_debug_reset_btn);
        this.mVmsrSwitchView = (StatusButton) findViewById(R.id.bnav_rg_menu_vmsr_switch_checkbox);
        this.mVmsrVerifyView = (StatusButton) findViewById(R.id.bnav_rg_menu_vmsr_verify_checkbox);
        this.mRLGPSDebugView = (RelativeLayout) findViewById(R.id.bnav_rg_menu_factory_gps_debug);
        this.mTVGPSDebugView = (TextView) findViewById(R.id.bnav_rg_menu_gps_debug_tv);
        this.mSBGPSDebugView = (StatusButton) findViewById(R.id.bnav_rg_menu_gps_checkbox);
        this.mUserTestView = (RelativeLayout) findViewById(R.id.bnav_rg_menu_performstat_user_test);
        this.mUserTestTv = (TextView) findViewById(R.id.bnav_rg_menu_performstat_user_test_tv);
        this.mUserTestStatusButton = (StatusButton) findViewById(R.id.bnav_rg_performstat_user_test_checkbox);
        this.mIMEnvStatusButton = (StatusButton) findViewById(R.id.bnav_rg_menu_im_env_status);
        this.mRLUrlDebugView = (RelativeLayout) findViewById(R.id.bnav_rg_menu_factory_debug_url);
        this.mTVUrlDebugView = (TextView) findViewById(R.id.bnav_rg_menu_factory_debug_url_tv);
        this.mRLUrlDebugExpandView = (RelativeLayout) findViewById(R.id.bnav_rl_expandable_debug_url);
        this.mELUrlDebugView = (ExpandableListView) findViewById(R.id.bnav_rg_expandable_debug_url);
        this.mNotificationDebugView = findViewById(R.id.bnav_rg_menu_factory_notification_layout);
        this.mNotificationDebugBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_java_notification_checkbox);
        this.mRootScreenView = findViewById(R.id.bnav_rg_menu_factory_root_switch);
        this.mRootScreenBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_root_screen_checkbox);
        this.mImageLogView = findViewById(R.id.bnav_rg_menu_factory_image_switch);
        this.mImageLogBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_image_log_checkbox);
        this.mCalcRoadVersionView = findViewById(R.id.bnav_rg_calc_road_version_rl);
        this.mCalcRoadVersionEt = (EditText) findViewById(R.id.bnav_rg_calc_road_version_et);
        this.mCalcRoadVersionBtn = (Button) findViewById(R.id.bnav_rg_calc_road_version_btn);
        this.mCalcRoadVersionEt.setText(BNSettingManager.getDebugModeCalcRoadVersion());
        this.mRouteGuideVersionEt = (EditText) findViewById(R.id.bnav_rg_routeguide_version_et);
        this.mRouteGuideVersionBtn = (Button) findViewById(R.id.bnav_rg_routeguide_version_btn);
        this.mRouteGuideVersionEt.setText(BNSettingManager.getDebugModeRouteGuideVersion());
        this.mBlueToothBlankEt = (EditText) findViewById(R.id.bnav_rg_bluetooth_sample_level_et);
        this.mBlueToothBlankBtn = (Button) findViewById(R.id.bnav_rg_bluetooth_sample_level_btn);
        this.mBlueToothBlankEt.setText(BNSettingManager.getInt("BlueToothBlankRate", -1) + "");
        this.mCloudConfigDecryptBtn = (Button) findViewById(R.id.bnav_rg_cloud_config_decrypt_btn);
        this.mHttpsDebugView = findViewById(R.id.bnav_rg_menu_factory_https_layout);
        this.mHttpsDebugBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_java_https_checkbox);
        this.mVDRView = findViewById(R.id.bnav_rg_menu_vdr_switch);
        this.mVDRBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_vdr_checkbox);
        this.mLeakView = findViewById(R.id.bnav_rg_menu_leak_switch);
        this.mLeakBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_leak_checkbox);
        this.mGpsVdrView = findViewById(R.id.bnav_rg_menu_vdr_gps_switch);
        this.mGpsVdrBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_vdr_gps_checkbox);
        this.mCommuteDebugView = findViewById(R.id.bnav_rg_menu_commute_switch);
        this.mCommuteDebugBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_commute_checkbox);
        this.mCruiserDebugView = findViewById(R.id.bnav_rg_menu_cruiser_trajectory_sync_switch);
        this.mCruiserDebugBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_cruiser_trajectory_sync_checkbox);
        this.mChallengeModeDebugView = findViewById(R.id.bnav_rg_menu_challenge_mode_switch);
        this.mChallengeModeDebugBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_challenge_mode_checkbox);
        this.mFutureTripEtaView = findViewById(R.id.bnav_rg_future_trip_eta_rl);
        this.mFutureTripEtaBtn = (Button) findViewById(R.id.bnav_rg_future_trip_eta_btn);
        EditText editText = (EditText) findViewById(R.id.bnav_rg_future_trip_eta_et);
        this.mFutureTripEtaEditText = editText;
        editText.setText(BNSettingManager.getFutureTripEtaDebugUrl());
        this.mMockVdrView = findViewById(R.id.bnav_rg_menu_mock_vdr_switch);
        this.mMockVdrBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_mock_vdr_checkbox);
        this.mUseTextureView = findViewById(R.id.bnav_rg_menu_use_textureview_switch);
        this.mUseTextureBtn = (StatusButton) findViewById(R.id.bnav_rg_menu_use_textureview_checkbox);
        this.qaCruiserView = findViewById(R.id.QA_cruiser_switch);
        this.qaCruiserBtn = (StatusButton) findViewById(R.id.QA_cruiser_checkbox);
        this.mLaneLineStatus = (StatusButton) findViewById(R.id.bnav_rg_menu_laneline_checkbox);
        this.mArRecordBox = (StatusButton) findViewById(R.id.bnav_ar_record_checkbox);
        if (BNSettingManager.isArRecordEnable()) {
            this.mArRecordBox.setRightBtnChecked();
        } else {
            this.mArRecordBox.setLeftBtnChecked();
        }
        View findViewById2 = findViewById(R.id.bnav_rg_replace_maprs_btn);
        this.mRelaceMapRsBtn = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                BNDebugModelDialog.this.replaceMap();
            }
        });
        View findViewById3 = findViewById(R.id.bnav_rg_sceneguide_sd_btn);
        this.mSceneGuideSelectBtn = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                final Activity b = com.baidu.navisdk.framework.a.c().b();
                ActivityResultUtil.getInstance().startActivityForResult(com.baidu.navisdk.framework.a.c().b(), intent, 4110, new ActivityResultUtil.Callback() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.4.1
                    @Override // com.baidu.navisdk.ui.widget.debug.ActivityResultUtil.Callback
                    public void onActivityForResult(int i, int i2, Intent intent2) {
                        if (i == 4110 && i2 == -1) {
                            Iterator<com.baidu.navisdk.behavrules.scene.b> it = com.baidu.navisdk.behavrules.c.c().a().iterator();
                            while (it.hasNext()) {
                                it.next().b();
                            }
                            com.baidu.navisdk.module.brule.business.util.b.f7047a = true;
                            d a2 = new com.baidu.navisdk.behavrules.f().a(q0.a(intent2.getData(), b), com.baidu.navisdk.module.brule.b.a());
                            if (a2 != null) {
                                Toast.makeText(b, "配置文件设置成功", 0).show();
                                a2.c();
                            } else {
                                Toast.makeText(b, "配置文件设置失败", 0).show();
                            }
                        }
                    }
                });
            }
        });
        this.mELUrlDebugView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.5
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public boolean onChildClick(ExpandableListView expandableListView, View view3, int i, int i2, long j) {
                if (BNDebugModelDialog.this.mGuideMsg != null) {
                    DebugModeMessageSerBean debugModeMessageSerBean = ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).serList.get(i2);
                    debugModeMessageSerBean.flag = !debugModeMessageSerBean.flag;
                    BNDebugModelDialog.this.cmdDebug.changedSwitchStatusToSDCard(debugModeMessageSerBean);
                    if (debugModeMessageSerBean.type == 0) {
                        if (debugModeMessageSerBean.flag) {
                            com.baidu.navisdk.util.http.b.d().a(debugModeMessageSerBean.key, debugModeMessageSerBean.value);
                            JNIGuidanceControl.getInstance().loadUrlAddrConfigParams(debugModeMessageSerBean.key, com.baidu.navisdk.util.http.b.d().b(debugModeMessageSerBean.key));
                        } else {
                            JNIGuidanceControl.getInstance().resetUrlAddrConfigParams(debugModeMessageSerBean.key);
                        }
                    } else if (debugModeMessageSerBean.flag) {
                        com.baidu.navisdk.util.http.b.d().a(debugModeMessageSerBean.key, debugModeMessageSerBean.value);
                    } else {
                        com.baidu.navisdk.util.http.b.d().a(debugModeMessageSerBean.key, com.baidu.navisdk.util.http.b.d().a(debugModeMessageSerBean.key));
                    }
                    BNDebugModelDialog.this.synUrlHostOneMoudlue(debugModeMessageSerBean);
                    BNDebugModelDialog.this.mAdapter.notifyDataSetChanged();
                    BNDebugModelDialog.this.mELUrlDebugView.expandGroup(i);
                    return false;
                }
                return false;
            }
        });
        this.mInputEdt = (EditText) findViewById(R.id.bnav_rg_expandable_debug_input);
        this.mTVUrlDebugColseView = (TextView) findViewById(R.id.bnav_rg_expandable_close_tv);
        this.mTVUrlDebugSaveColseView = (TextView) findViewById(R.id.bnav_rg_expandable_save_close);
        this.mTVUrlDebugReverseView = (TextView) findViewById(R.id.bnav_rg_expandable_reverse);
        StatusButton statusButton2 = (StatusButton) findViewById(R.id.bnav_rg_menu_driving_tool_checkbox);
        this.mDrivingToolOpenBtn = statusButton2;
        if (statusButton2 != null) {
            statusButton2.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mDrivingToolOpenBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mDrivingToolOpenBtn.setMidBtnGone(true);
            this.mDrivingToolOpenBtn.setRightBtnChecked();
        }
        this.mDrivingToolStartBtn = (Button) findViewById(R.id.bnav_rg_menu_start_driving_btn);
        this.mShowPullBtn = (RelativeLayout) findViewById(R.id.bnav_rg_menu_pull_list_rl);
        Button button = this.mDrivingToolStartBtn;
        if (button != null) {
            button.setVisibility(8);
            this.mDrivingToolStartBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    BNDebugModelDialog.this.dismiss();
                    BNDebugModelDialog.this.setStartButtonState(false);
                    BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(8);
                    BNDebugModelDialog.this.mDrivingToolOpenBtn.setVisibility(0);
                    if (BNDebugModelDialog.this.mShowPullBtn != null) {
                        BNDebugModelDialog.this.mShowPullBtn.setVisibility(8);
                    }
                    com.baidu.navisdk.util.drivertool.b.n().i.clear();
                }
            });
        }
        setStartButtonState(false);
        RelativeLayout relativeLayout2 = this.mShowPullBtn;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        Button button2 = (Button) findViewById(R.id.bnav_rg_menu_single_driving_btn);
        this.mSingleDtBtn = button2;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    BNDebugModelDialog.this.dismiss();
                }
            });
        }
        this.mRouteLl = (LinearLayout) findViewById(R.id.bnav_menu_route_ll);
        Button button3 = (Button) findViewById(R.id.bnav_rg_menu_multiple_btn);
        this.mMuitipleBtn = button3;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.navisdk.util.drivertool.b.n().F = false;
                    BNDebugModelDialog.this.mMuitipleBtn.setVisibility(8);
                    BNDebugModelDialog.this.mRouteLl.setVisibility(0);
                    BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(0);
                    BNDebugModelDialog.this.mSingleDtBtn.setVisibility(8);
                    BNDebugModelDialog.this.mStopDtBtn.setVisibility(8);
                    com.baidu.navisdk.util.drivertool.b.n().c();
                }
            });
        }
        Button button4 = (Button) findViewById(R.id.bnav_rg_menu_stop_driving_btn);
        this.mStopDtBtn = button4;
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (BNDebugModelDialog.this.mTaskListSp != null) {
                        BNDebugModelDialog.this.mTaskListSp.setSelection(0);
                    }
                }
            });
        }
        Spinner spinner = (Spinner) findViewById(R.id.bnav_rg_menu_task_list_sp);
        this.mTaskListSp = spinner;
        if (spinner != null) {
            com.baidu.navisdk.util.drivertool.b.n().d();
            this.mTaskListSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.10
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view3, int i, long j) {
                    String str;
                    List<String> list = com.baidu.navisdk.util.drivertool.b.n().g;
                    if (list != null) {
                        String str2 = list.get(i);
                        com.baidu.navisdk.util.drivertool.b.n().C = !"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(str2);
                        if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(str2)) {
                            str = com.baidu.navisdk.util.drivertool.b.n().l.get(str2);
                            com.baidu.navisdk.util.drivertool.b.n().p = str;
                        } else {
                            str = null;
                        }
                        if (com.baidu.navisdk.util.drivertool.b.n().e()) {
                            com.baidu.navisdk.util.drivertool.b.n().F = false;
                            BNDebugModelDialog.this.setStartButtonState(true);
                            BNSettingManager.setShowingDrivingTool(true);
                            com.baidu.navisdk.util.drivertool.d.f();
                            com.baidu.navisdk.util.drivertool.d.b = true;
                        } else {
                            BNDebugModelDialog.this.setStartButtonState(false);
                            BNSettingManager.setShowingDrivingTool(false);
                            com.baidu.navisdk.util.drivertool.d.b = false;
                        }
                        if (BNDebugModelDialog.this.mSingleDtBtn.getVisibility() == 0) {
                            if (com.baidu.navisdk.util.drivertool.b.n().C) {
                                BNDebugModelDialog.this.setSingleButtonState(true);
                                BNSettingManager.setShowingDrivingTool(true);
                                com.baidu.navisdk.util.drivertool.d.f();
                                com.baidu.navisdk.util.drivertool.b.n().F = true;
                                com.baidu.navisdk.util.drivertool.d.b = true;
                            } else {
                                BNDebugModelDialog.this.setSingleButtonState(false);
                                BNSettingManager.setShowingDrivingTool(false);
                                com.baidu.navisdk.util.drivertool.d.b = false;
                            }
                        }
                        if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(str2)) {
                            com.baidu.navisdk.util.drivertool.b.n().s = "0";
                            if (!com.baidu.navisdk.util.drivertool.b.n().F) {
                                com.baidu.navisdk.util.drivertool.b.n().c();
                            }
                        }
                        LogUtil.e("drivingTool", "taskId is + " + str);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        Spinner spinner2 = (Spinner) findViewById(R.id.bnav_rg_menu_road_line_sp);
        this.mRouteListSp = spinner2;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.11
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view3, int i, long j) {
                    List<String> list = com.baidu.navisdk.util.drivertool.b.n().h;
                    if (list != null) {
                        String str = list.get(i);
                        if ("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(str)) {
                            com.baidu.navisdk.util.drivertool.b.n().D = false;
                        } else {
                            com.baidu.navisdk.util.drivertool.b.n().D = true;
                            com.baidu.navisdk.util.drivertool.b.n().r = str;
                        }
                        if (com.baidu.navisdk.util.drivertool.b.n().e()) {
                            BNDebugModelDialog.this.setStartButtonState(true);
                            BNSettingManager.setShowingDrivingTool(true);
                            com.baidu.navisdk.util.drivertool.d.f();
                            com.baidu.navisdk.util.drivertool.b.n().F = false;
                            com.baidu.navisdk.util.drivertool.d.b = true;
                        } else {
                            BNDebugModelDialog.this.setStartButtonState(false);
                            BNSettingManager.setShowingDrivingTool(false);
                            com.baidu.navisdk.util.drivertool.d.b = false;
                        }
                        List<String> list2 = com.baidu.navisdk.util.drivertool.b.n().i;
                        if (list2 != null && list2.size() > 0) {
                            if (list2.contains(str)) {
                                com.baidu.navisdk.util.drivertool.b.n().s = "1";
                            } else {
                                com.baidu.navisdk.util.drivertool.b.n().s = "0";
                            }
                        } else {
                            com.baidu.navisdk.util.drivertool.b.n().s = "0";
                        }
                        String str2 = com.baidu.navisdk.util.drivertool.b.n().m.get(str);
                        com.baidu.navisdk.util.drivertool.b.n().q = str2;
                        LogUtil.e("drivingTool", "routeId is + " + str2);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        Button button5 = (Button) findViewById(R.id.bnav_rg_menu_new_road_btn);
        this.mCreateRouteBtn = button5;
        if (button5 != null) {
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (g.a(1500L)) {
                        return;
                    }
                    com.baidu.navisdk.util.drivertool.b.n().s = "1";
                    com.baidu.navisdk.util.drivertool.b.n().c();
                }
            });
        }
        RelativeLayout relativeLayout3 = this.mRLUrlDebugView;
        if (relativeLayout3 != null && this.mTVUrlDebugView != null) {
            relativeLayout3.setVisibility(0);
            this.mTVUrlDebugView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (BNDebugModelDialog.this.cmdDebug.getGuideMsg() != null && BNDebugModelDialog.this.cmdDebug.getGuideMsg().size() > 0) {
                        BNDebugModelDialog bNDebugModelDialog = BNDebugModelDialog.this;
                        bNDebugModelDialog.mGuideMsg = bNDebugModelDialog.cmdDebug.getGuideMsg();
                        if (BNDebugModelDialog.this.mAdapter == null) {
                            BNDebugModelDialog.this.mAdapter = new DebugUrlAdapter();
                            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
                        }
                        BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
                        return;
                    }
                    if (y.d(BNDebugModelDialog.this.mActivity)) {
                        BNDebugModelDialog.this.cmdDebug.requestDebugModeUrl(BNDebugModelDialog.this.mHandler);
                    } else {
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mActivity, "网络未连接");
                    }
                }
            });
            this.mTVUrlDebugColseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(8);
                }
            });
            this.mTVUrlDebugSaveColseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    BNDebugModelDialog.this.cmdDebug.flush();
                    BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(8);
                }
            });
            this.mTVUrlDebugReverseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    BNDebugModelDialog.this.cmdDebug.reset();
                    com.baidu.navisdk.util.http.b.d().b();
                    BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(8);
                }
            });
        }
        View view3 = this.mBuildView;
        if (view3 != null && this.mBuildTimeTv != null) {
            view3.setVisibility(0);
            this.mBuildTimeTv.setText("BuildTime:(" + a0.c() + oIX0oI.I0Io.f4095I0Io);
        }
        View view4 = this.mJavaLogView;
        if (view4 != null && this.mJavaLogBtn != null) {
            view4.setVisibility(0);
            this.mJavaLogBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mJavaLogBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mJavaLogBtn.setMidBtnGone(true);
        }
        View view5 = this.mNotificationDebugView;
        if (view5 != null && this.mNotificationDebugBtn != null) {
            view5.setVisibility(0);
            this.mNotificationDebugBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mNotificationDebugBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mNotificationDebugBtn.setMidBtnGone(true);
        }
        View view6 = this.mRootScreenView;
        if (view6 != null && this.mRootScreenBtn != null) {
            view6.setVisibility(0);
            this.mRootScreenBtn.setLeftButtonText("开启");
            this.mRootScreenBtn.setRightButtonText("关闭");
            this.mRootScreenBtn.setMidBtnGone(true);
        }
        View view7 = this.mImageLogView;
        if (view7 != null && this.mImageLogBtn != null) {
            view7.setVisibility(0);
            this.mImageLogBtn.setLeftButtonText("开启");
            this.mImageLogBtn.setRightButtonText("关闭");
            this.mImageLogBtn.setMidBtnGone(true);
        }
        View view8 = this.mHttpsDebugView;
        if (view8 != null && this.mHttpsDebugBtn != null) {
            view8.setVisibility(0);
            this.mHttpsDebugBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mHttpsDebugBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mHttpsDebugBtn.setMidBtnGone(true);
        }
        View view9 = this.mNativeLogView;
        if (view9 != null && this.mNativeLogBtn != null) {
            view9.setVisibility(0);
            this.mNativeLogBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mNativeLogBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mNativeLogBtn.setMidBtnGone(true);
        }
        View view10 = this.mMonkeyView;
        if (view10 != null && this.mMonkeyBtn != null) {
            view10.setVisibility(0);
            this.mMonkeyBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mMonkeyBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mMonkeyBtn.setMidBtnGone(true);
        }
        if (this.mTTSVocoderView != null && (statusButton = this.mTTSVocoderBtn) != null) {
            statusButton.setLeftButtonText("0");
            this.mTTSVocoderBtn.setMidButtonText("1");
            this.mTTSVocoderBtn.setRightButtonText("2");
        }
        StatusButton statusButton3 = this.mVmsrSwitchView;
        if (statusButton3 != null) {
            statusButton3.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mVmsrSwitchView.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mVmsrSwitchView.setMidBtnGone(true);
        }
        StatusButton statusButton4 = this.mVmsrVerifyView;
        if (statusButton4 != null) {
            statusButton4.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mVmsrVerifyView.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mVmsrVerifyView.setMidBtnGone(true);
        }
        RelativeLayout relativeLayout4 = this.mRLGPSDebugView;
        if (relativeLayout4 != null && this.mSBGPSDebugView != null) {
            relativeLayout4.setVisibility(0);
            this.mSBGPSDebugView.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mSBGPSDebugView.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mSBGPSDebugView.setMidBtnGone(true);
        }
        if (this.mUserTestStatusButton != null && (relativeLayout = this.mUserTestView) != null) {
            relativeLayout.setVisibility(0);
            this.mUserTestStatusButton.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mUserTestStatusButton.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mUserTestStatusButton.setMidBtnGone(true);
        }
        StatusButton statusButton5 = this.mIMEnvStatusButton;
        if (statusButton5 != null) {
            statusButton5.setLeftButtonText("线上");
            this.mIMEnvStatusButton.setMidButtonText("RD");
            this.mIMEnvStatusButton.setRightButtonText("QA");
        }
        View view11 = this.mVDRView;
        if (view11 != null && this.mVDRBtn != null) {
            view11.setVisibility(0);
            this.mVDRBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mVDRBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mVDRBtn.setMidBtnGone(true);
        }
        View view12 = this.mLeakView;
        if (view12 != null && this.mLeakBtn != null) {
            view12.setVisibility(0);
            this.mLeakBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mLeakBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mLeakBtn.setMidBtnGone(true);
            if (BNSettingManager.isLeakEnabled()) {
                this.mLeakBtn.setLeftBtnChecked();
            } else {
                this.mLeakBtn.setRightBtnChecked();
            }
        }
        View view13 = this.mGpsVdrView;
        if (view13 != null && this.mGpsVdrBtn != null) {
            view13.setVisibility(0);
            this.mGpsVdrBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mGpsVdrBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mGpsVdrBtn.setMidBtnGone(true);
            if (BNSettingManager.getGpsCloseVdrFunctionNormal() == 1) {
                this.mGpsVdrBtn.setLeftBtnChecked();
            } else {
                this.mGpsVdrBtn.setRightBtnChecked();
            }
        }
        View view14 = this.mCommuteDebugView;
        if (view14 != null && this.mCommuteDebugBtn != null) {
            view14.setVisibility(0);
            this.mCommuteDebugBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mCommuteDebugBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mCommuteDebugBtn.setMidBtnGone(true);
            if (BNSettingManager.getBoolean(SettingParams.Key.COMMUTE_DEBUG, false)) {
                this.mCommuteDebugBtn.setLeftBtnChecked();
            } else {
                this.mCommuteDebugBtn.setRightBtnChecked();
            }
        }
        View view15 = this.mCruiserDebugView;
        if (view15 != null && this.mCruiserDebugBtn != null) {
            view15.setVisibility(0);
            this.mCruiserDebugBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mCruiserDebugBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mCruiserDebugBtn.setMidBtnGone(true);
            if (BNSettingManager.getBoolean(SettingParams.Key.SYNC_EDOG_TRAJECTORY_TO_MAP, false)) {
                this.mCruiserDebugBtn.setLeftBtnChecked();
            } else {
                this.mCruiserDebugBtn.setRightBtnChecked();
            }
        }
        View view16 = this.mChallengeModeDebugView;
        if (view16 != null && this.mChallengeModeDebugBtn != null) {
            view16.setVisibility(0);
            this.mChallengeModeDebugBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mChallengeModeDebugBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mChallengeModeDebugBtn.setMidBtnGone(true);
            if (BNSettingManager.getBoolean(SettingParams.Key.CHALLENGE_MODE_DEBUG, false)) {
                this.mChallengeModeDebugBtn.setLeftBtnChecked();
            } else {
                this.mChallengeModeDebugBtn.setRightBtnChecked();
            }
        }
        this.mInputEdt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.17
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String trim = editable.toString().trim();
                int size = BNDebugModelDialog.this.mGuideMsg.size();
                for (int i = 0; i < size; i++) {
                    if (BNDebugModelDialog.this.mGuideMsg.get(i) != null && !TextUtils.isEmpty(((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).mSceneName) && !TextUtils.isEmpty(trim) && ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(i)).mSceneName.contains(trim)) {
                        BNDebugModelDialog.this.mELUrlDebugView.smoothScrollToPositionFromTop(i, 0);
                        return;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        View view17 = this.mMockVdrView;
        if (view17 != null && this.mMockVdrBtn != null) {
            view17.setVisibility(0);
            this.mMockVdrBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mMockVdrBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mMockVdrBtn.setMidBtnGone(true);
        }
        if (this.mUseTextureBtn != null && (view2 = this.mUseTextureView) != null) {
            view2.setVisibility(0);
            this.mUseTextureBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mUseTextureBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mUseTextureBtn.setMidBtnGone(true);
        }
        if (this.qaCruiserBtn != null && (view = this.qaCruiserView) != null) {
            view.setVisibility(0);
            this.qaCruiserBtn.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.qaCruiserBtn.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.qaCruiserBtn.setMidBtnGone(true);
        }
        StatusButton statusButton6 = this.mLaneLineStatus;
        if (statusButton6 != null) {
            statusButton6.setLeftButtonText(b.h(R.string.nsdk_string_open));
            this.mLaneLineStatus.setRightButtonText(b.h(R.string.nsdk_string_close));
            this.mLaneLineStatus.setMidBtnGone(true);
        }
    }

    public void initButtonStatus() {
        VoiceInterfaceImplProxy o;
        VoiceInterfaceImplProxy o2;
        if (this.mJavaLogBtn != null) {
            if (BNSettingManager.isShowJavaLog()) {
                this.mJavaLogBtn.setLeftBtnChecked();
            } else {
                this.mJavaLogBtn.setRightBtnChecked();
            }
        }
        if (this.mImageLogBtn != null) {
            if (JNIGuidanceControl.getInstance().IsMapLoggerOpen()) {
                this.mImageLogBtn.setLeftBtnChecked();
            } else {
                this.mImageLogBtn.setRightBtnChecked();
            }
        }
        if (this.mRootScreenBtn != null) {
            if (BNSettingManager.isRootScreenOpen()) {
                this.mRootScreenBtn.setLeftBtnChecked();
            } else {
                this.mRootScreenBtn.setRightBtnChecked();
            }
        }
        if (this.mHttpsDebugBtn != null) {
            if (BNSettingManager.isUseHttpsOfflineURL()) {
                this.mHttpsDebugBtn.setLeftBtnChecked();
            } else {
                this.mHttpsDebugBtn.setRightBtnChecked();
            }
        }
        if (this.mNativeLogBtn != null) {
            if (BNSettingManager.isShowNativeLog()) {
                this.mNativeLogBtn.setLeftBtnChecked();
            } else {
                this.mNativeLogBtn.setRightBtnChecked();
            }
        }
        if (this.mMonkeyBtn != null) {
            if (BNSettingManager.isMonkey()) {
                this.mMonkeyBtn.setLeftBtnChecked();
            } else {
                this.mMonkeyBtn.setRightBtnChecked();
            }
        }
        if (this.mTTSVocoderBtn != null) {
            if (BNSettingManager.getTTSVocoderParam().equals("0")) {
                this.mTTSVocoderBtn.setLeftBtnChecked();
            } else if (BNSettingManager.getTTSVocoderParam().equals("1")) {
                this.mTTSVocoderBtn.setMidBtnChecked();
            } else {
                this.mTTSVocoderBtn.setRightBtnChecked();
            }
        }
        if (this.mSBGPSDebugView != null) {
            if (BNSettingManager.isGPSDebug()) {
                this.mSBGPSDebugView.setLeftBtnChecked();
            } else {
                this.mSBGPSDebugView.setRightBtnChecked();
            }
        }
        StatusButton statusButton = this.mUserTestStatusButton;
        if (statusButton != null) {
            statusButton.setRightBtnChecked();
        }
        if (this.mDrivingToolOpenBtn != null) {
            if (BNSettingManager.isShowingDrivingTool()) {
                this.mDrivingToolOpenBtn.setLeftBtnChecked();
                updateDrivingToolView();
            } else {
                this.mDrivingToolOpenBtn.setRightBtnChecked();
            }
        }
        if (this.mTTSSpeedTv != null && (o2 = com.baidu.navisdk.framework.interfaces.c.p().o()) != null) {
            this.mTTSSpeedTv.setText(o2.getTTSSpeedParam() + "");
        }
        if (this.mTTSVolTv != null && (o = com.baidu.navisdk.framework.interfaces.c.p().o()) != null) {
            this.mTTSVolTv.setText(o.getTTSVolParam() + "");
        }
        StatusButton statusButton2 = this.mVmsrSwitchView;
        if (statusButton2 != null) {
            if (com.baidu.navisdk.module.vmsr.c.h) {
                statusButton2.setLeftBtnChecked();
            } else {
                statusButton2.setRightBtnChecked();
            }
        }
        StatusButton statusButton3 = this.mVmsrVerifyView;
        if (statusButton3 != null) {
            if (com.baidu.navisdk.module.vmsr.c.i) {
                statusButton3.setLeftBtnChecked();
            } else {
                statusButton3.setRightBtnChecked();
            }
        }
        if (this.mVDRBtn != null) {
            if (BNSettingManager.isVDREnabled()) {
                this.mVDRBtn.setLeftBtnChecked();
            } else {
                this.mVDRBtn.setRightBtnChecked();
            }
        }
        if (this.mMockVdrBtn != null) {
            if (BNSettingManager.isVDRMockForDebugEnabled()) {
                this.mMockVdrBtn.setLeftBtnChecked();
            } else {
                this.mMockVdrBtn.setRightBtnChecked();
            }
        }
        if (this.mUseTextureBtn != null) {
            if (BNSettingManager.isUseTextureViewDebugEnabled()) {
                this.mUseTextureBtn.setLeftBtnChecked();
            } else {
                this.mUseTextureBtn.setRightBtnChecked();
            }
        }
        StatusButton statusButton4 = this.qaCruiserBtn;
        if (statusButton4 != null) {
            statusButton4.setRightBtnChecked();
        }
        if (this.mLaneLineStatus != null) {
            if (BNSettingManager.isLaneLineDebugEnabled()) {
                this.mLaneLineStatus.setLeftBtnChecked();
            } else {
                this.mLaneLineStatus.setRightBtnChecked();
            }
        }
        if (this.mIMEnvStatusButton != null) {
            int i = this.mActivity.getSharedPreferences("map_pref", 0).getInt("im_env", 0);
            if (i == 1) {
                this.mIMEnvStatusButton.setMidBtnChecked();
            } else if (i == 2) {
                this.mIMEnvStatusButton.setRightBtnChecked();
            } else {
                this.mIMEnvStatusButton.setLeftBtnChecked();
            }
        }
        addNewSwitchBtnItem(SettingParams.Key.TRUCK_CHALLENGE_MODE_H5_USE_DEBUG_URL, false, "挑战模式h5-debug", new StatusButton.onStatusButtonClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.33
            @Override // com.baidu.navisdk.ui.widget.StatusButton.onStatusButtonClickListener
            public void onClick(StatusButton statusButton5, StatusButton.StatusButtonChild statusButtonChild) {
                int i2 = AnonymousClass35.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[statusButtonChild.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        BNSettingManager.putBoolean(SettingParams.Key.TRUCK_CHALLENGE_MODE_H5_USE_DEBUG_URL, false);
                        return;
                    }
                    return;
                }
                BNSettingManager.putBoolean(SettingParams.Key.TRUCK_CHALLENGE_MODE_H5_USE_DEBUG_URL, true);
            }
        });
    }

    public void setCloseGone() {
        this.mCloseIV.setVisibility(8);
    }

    public void setCloseIVListener() {
        this.mCloseIV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BNDebugModelDialog bNDebugModelDialog = BNDebugModelDialog.this;
                DialogInterface.OnCancelListener onCancelListener = bNDebugModelDialog.mOnCancelListener;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(bNDebugModelDialog);
                }
                BNDebugModelDialog.this.dismiss();
            }
        });
    }

    public void setCloseVisible() {
        this.mCloseIV.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
        super.setOnCancelListener(onCancelListener);
    }

    public void setRouteSpinnerCLickable(boolean z) {
        Spinner spinner = this.mRouteListSp;
        if (spinner != null) {
            spinner.setClickable(z);
        }
    }

    public void setSingleButtonState(boolean z) {
        Button button = this.mSingleDtBtn;
        if (button == null) {
            return;
        }
        if (z) {
            button.setBackgroundColor(-16711936);
            this.mSingleDtBtn.setClickable(true);
        } else {
            button.setBackgroundColor(-7829368);
            this.mSingleDtBtn.setClickable(false);
        }
    }

    public void setStartButtonState(boolean z) {
        Button button = this.mDrivingToolStartBtn;
        if (button == null) {
            return;
        }
        if (z) {
            button.setBackgroundColor(-16711936);
            this.mDrivingToolStartBtn.setClickable(true);
        } else {
            button.setBackgroundColor(-7829368);
            this.mDrivingToolStartBtn.setClickable(false);
        }
    }

    public void updatRouteListView() {
        List<String> list;
        if (this.mRouteListSp != null && (list = com.baidu.navisdk.util.drivertool.b.n().h) != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.mActivity, android.R.layout.simple_spinner_item, list);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mRouteListSp.setAdapter((SpinnerAdapter) arrayAdapter);
            if (com.baidu.navisdk.util.drivertool.b.n().h != null && com.baidu.navisdk.util.drivertool.b.n().s.equals("1")) {
                this.mRouteListSp.setSelection(com.baidu.navisdk.util.drivertool.b.n().h.size() - 1, true);
            }
        }
        setRouteSpinnerCLickable(true);
    }

    public void updateDrivingToolView() {
        this.mDrivingToolOpenBtn.setVisibility(8);
        this.mSingleDtBtn.setVisibility(0);
        this.mShowPullBtn.setVisibility(0);
        this.mRouteLl.setVisibility(8);
        this.mMuitipleBtn.setVisibility(0);
        com.baidu.navisdk.util.drivertool.b.n().F = true;
        com.baidu.navisdk.util.drivertool.b.n().q = "0";
    }

    public void updateTaskListView() {
        String str;
        String str2;
        Map<String, String> map;
        String[] split;
        if (this.mTaskListSp != null && com.baidu.navisdk.util.drivertool.b.n().g != null) {
            String lastDrivingInfo = BNSettingManager.getLastDrivingInfo();
            String str3 = null;
            if (lastDrivingInfo != null && (split = lastDrivingInfo.split(",")) != null && split.length > 0) {
                str = split[0];
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && (map = com.baidu.navisdk.util.drivertool.b.n().l) != null && map.size() > 0) {
                Iterator<String> it = map.values().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next())) {
                        str2 = "ok";
                        break;
                    }
                }
            }
            str2 = null;
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.mActivity, android.R.layout.simple_spinner_item, com.baidu.navisdk.util.drivertool.b.n().g);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mTaskListSp.setAdapter((SpinnerAdapter) arrayAdapter);
            if (!TextUtils.isEmpty(str2)) {
                this.mTaskListSp.setSelection(0, true);
                c.a().a((f) new f<String, String>("updateTaskListView-" + BNDebugModelDialog.class.getSimpleName(), str3) { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog.18
                    @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                    public String execute() {
                        BNDebugModelDialog.this.updateTaskSpinnerView();
                        return null;
                    }
                }, new e(99, 0));
            }
        }
    }

    public void updateTaskSpinnerView() {
        int i;
        try {
            i = com.baidu.navisdk.util.drivertool.b.n().i();
            try {
                Spinner spinner = this.mTaskListSp;
                if (spinner != null) {
                    spinner.setSelection(i);
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = -1;
        }
        LogUtil.e("drivingTool", "getSelectedTaskIndex index is " + i);
    }
}
