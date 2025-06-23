package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.QrcodeTypeInfo;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes12.dex */
public final class AddQrcodeActivity extends BaseActivity {
    private QrcodeTypeInfo mQrcodeTypeInfo;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xx0X0 mSelectPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return AddQrcodeActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int REQUEST_CODE = 1;
    private static final int REQUEST_ADD_QRCODE = 2;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final int oIX0oI() {
            return AddQrcodeActivity.REQUEST_ADD_QRCODE;
        }

        public oIX0oI() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createQrcodeTypeInfo(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("createQrcode -> mQrcodeTypeInfo=");
        QrcodeTypeInfo qrcodeTypeInfo = this.mQrcodeTypeInfo;
        QrcodeTypeInfo qrcodeTypeInfo2 = null;
        if (qrcodeTypeInfo == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
            qrcodeTypeInfo = null;
        }
        sb.append(qrcodeTypeInfo);
        sb.append(", content=");
        sb.append(str);
        LogUtils.d(sb.toString());
        com.sma.smartv3.util.XIo0oOXIx xIo0oOXIx = com.sma.smartv3.util.XIo0oOXIx.f24335oIX0oI;
        Pair<Integer, byte[]> XO2 = xIo0oOXIx.XO(str);
        if (XO2 != null) {
            Integer num = (Integer) XO2.first;
            byte[] bArr = (byte[]) XO2.second;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
            if (num.intValue() > 57) {
                ToastUtils.showLong(getString(R.string.conten_too_long) + " , " + getString(R.string.qrcode_tip), new Object[0]);
                return;
            }
            QrcodeTypeInfo qrcodeTypeInfo3 = this.mQrcodeTypeInfo;
            if (qrcodeTypeInfo3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
                qrcodeTypeInfo3 = null;
            }
            qrcodeTypeInfo3.setWidth(num.intValue());
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(bArr);
            qrcodeTypeInfo3.setData(bArr);
            qrcodeTypeInfo3.setDateTime(System.currentTimeMillis());
            File OI02 = com.sma.smartv3.initializer.IXxxXO.OI0(X00IoxXI.oIX0oI.f3233oIX0oI);
            StringBuilder sb2 = new StringBuilder();
            QrcodeTypeInfo qrcodeTypeInfo4 = this.mQrcodeTypeInfo;
            if (qrcodeTypeInfo4 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
                qrcodeTypeInfo4 = null;
            }
            sb2.append(qrcodeTypeInfo4.getDateTime());
            sb2.append(".jpg");
            xIo0oOXIx.I0Io(str, 512, 512, new File(OI02, sb2.toString()));
            Intent intent = new Intent();
            QrcodeTypeInfo qrcodeTypeInfo5 = this.mQrcodeTypeInfo;
            if (qrcodeTypeInfo5 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
            } else {
                qrcodeTypeInfo2 = qrcodeTypeInfo5;
            }
            setResult(-1, intent.putExtra("qrcode", qrcodeTypeInfo2));
            finish();
        }
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.QrcodeTypeInfo");
        this.mQrcodeTypeInfo = (QrcodeTypeInfo) mArg3;
        StringBuilder sb = new StringBuilder();
        sb.append("mQrcodeTypeInfo -> ");
        QrcodeTypeInfo qrcodeTypeInfo = this.mQrcodeTypeInfo;
        if (qrcodeTypeInfo == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
            qrcodeTypeInfo = null;
        }
        sb.append(qrcodeTypeInfo);
        LogUtils.d(sb.toString());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        QrcodeTypeInfo qrcodeTypeInfo = this.mQrcodeTypeInfo;
        QrcodeTypeInfo qrcodeTypeInfo2 = null;
        if (qrcodeTypeInfo == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
            qrcodeTypeInfo = null;
        }
        textView.setText(qrcodeTypeInfo.getName());
        TextView textView2 = (TextView) findViewById(R.id.tv_tip1);
        QrcodeTypeInfo qrcodeTypeInfo3 = this.mQrcodeTypeInfo;
        if (qrcodeTypeInfo3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mQrcodeTypeInfo");
        } else {
            qrcodeTypeInfo2 = qrcodeTypeInfo3;
        }
        textView2.setText(getString(R.string.qrcode_sycn_tip1, qrcodeTypeInfo2.getName()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qrcode_add;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == REQUEST_CODE) {
            com.sma.smartv3.pop.xx0X0 xx0x0 = this.mSelectPopup;
            if (xx0x0 != null) {
                xx0x0.dismiss();
            }
            xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new AddQrcodeActivity$onActivityResult$1(this, intent), 31, null);
        }
    }

    public final void onSelect(@OXOo.OOXIXo View v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
        if (this.mSelectPopup == null) {
            com.sma.smartv3.pop.xx0X0 xx0x0 = new com.sma.smartv3.pop.xx0X0(getMContext());
            xx0x0.xI(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity$onSelect$1$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.STORAGE, PermissionConstants.CAMERA);
                    kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                    final AddQrcodeActivity addQrcodeActivity = AddQrcodeActivity.this;
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity$onSelect$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            if (it == PermissionStatus.GRANTED) {
                                com.sma.smartv3.util.XIo0oOXIx xIo0oOXIx = com.sma.smartv3.util.XIo0oOXIx.f24335oIX0oI;
                                final AddQrcodeActivity addQrcodeActivity2 = AddQrcodeActivity.this;
                                xIo0oOXIx.xoIox(addQrcodeActivity2, false, new Oox.oOoXoXO<String, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity.onSelect.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str) {
                                        invoke2(str);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.oOoXoXO String str) {
                                        if (str != null) {
                                            AddQrcodeActivity.this.createQrcodeTypeInfo(str);
                                        }
                                    }
                                });
                            }
                        }
                    }, 3, null);
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity$onSelect$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.STORAGE, PermissionConstants.CAMERA);
                    kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                    final AddQrcodeActivity addQrcodeActivity = AddQrcodeActivity.this;
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AddQrcodeActivity$onSelect$1$2.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                            int i;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            if (it == PermissionStatus.GRANTED) {
                                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                Intent intent = new Intent("android.intent.action.PICK", uri);
                                AddQrcodeActivity addQrcodeActivity2 = AddQrcodeActivity.this;
                                intent.setDataAndType(uri, "image/*");
                                i = AddQrcodeActivity.REQUEST_CODE;
                                addQrcodeActivity2.startActivityForResult(intent, i);
                            }
                        }
                    }, 3, null);
                }
            });
            this.mSelectPopup = xx0x0;
        }
        com.sma.smartv3.pop.xx0X0 xx0x02 = this.mSelectPopup;
        if (xx0x02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xx0x02.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
