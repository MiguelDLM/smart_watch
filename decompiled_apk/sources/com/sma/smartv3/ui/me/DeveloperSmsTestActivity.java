package com.sma.smartv3.ui.me;

import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class DeveloperSmsTestActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpSims$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatSpinner>() { // from class: com.sma.smartv3.ui.me.DeveloperSmsTestActivity$mSpSims$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatSpinner invoke() {
            return (AppCompatSpinner) DeveloperSmsTestActivity.this.findViewById(R.id.sp_sims);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEtPhone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperSmsTestActivity$mEtPhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperSmsTestActivity.this.findViewById(R.id.et_phone);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEtContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperSmsTestActivity$mEtContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperSmsTestActivity.this.findViewById(R.id.et_content);
        }
    });
    private int subId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getMEtContent() {
        return (EditText) this.mEtContent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getMEtPhone() {
        return (EditText) this.mEtPhone$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatSpinner getMSpSims() {
        return (AppCompatSpinner) this.mSpSims$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.PHONE, PermissionConstants.SMS);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperSmsTestActivity$initView$1

            /* loaded from: classes11.dex */
            public static final class oIX0oI implements AdapterView.OnItemSelectedListener {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ List<SubscriptionInfo> f23224Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ DeveloperSmsTestActivity f23225XO;

                public oIX0oI(DeveloperSmsTestActivity developerSmsTestActivity, List<SubscriptionInfo> list) {
                    this.f23225XO = developerSmsTestActivity;
                    this.f23224Oo = list;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(@OXOo.oOoXoXO AdapterView<?> adapterView, @OXOo.oOoXoXO View view, int i, long j) {
                    int subscriptionId;
                    int i2;
                    DeveloperSmsTestActivity developerSmsTestActivity = this.f23225XO;
                    subscriptionId = oxIIX0o.oIX0oI(this.f23224Oo.get(i)).getSubscriptionId();
                    developerSmsTestActivity.subId = subscriptionId;
                    i2 = this.f23225XO.subId;
                    ToastUtils.showLong(String.valueOf(i2), new Object[0]);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(@OXOo.oOoXoXO AdapterView<?> adapterView) {
                }
            }

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
                List activeSubscriptionInfoList;
                AppCompatSpinner mSpSims;
                AppCompatSpinner mSpSims2;
                CharSequence displayName;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (it != PermissionStatus.GRANTED || Build.VERSION.SDK_INT < 22) {
                    return;
                }
                Object systemService = DeveloperSmsTestActivity.this.getSystemService("telephony_subscription_service");
                kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
                activeSubscriptionInfoList = com.baidu.location.c.a.O0xOxO.oIX0oI(systemService).getActiveSubscriptionInfoList();
                LogUtils.d("subscriptionInfoList => " + activeSubscriptionInfoList);
                DeveloperSmsTestActivity developerSmsTestActivity = DeveloperSmsTestActivity.this;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(activeSubscriptionInfoList);
                List list = activeSubscriptionInfoList;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    displayName = oxIIX0o.oIX0oI(it2.next()).getDisplayName();
                    arrayList.add(displayName);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(developerSmsTestActivity, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
                mSpSims = DeveloperSmsTestActivity.this.getMSpSims();
                mSpSims.setAdapter((SpinnerAdapter) arrayAdapter);
                mSpSims2 = DeveloperSmsTestActivity.this.getMSpSims();
                mSpSims2.setOnItemSelectedListener(new oIX0oI(DeveloperSmsTestActivity.this, activeSubscriptionInfoList));
            }
        }, 3, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_sms_test;
    }

    public final void onSend(@OXOo.OOXIXo View v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.PHONE, PermissionConstants.SMS);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperSmsTestActivity$onSend$1
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
                EditText mEtPhone;
                EditText mEtContent;
                SmsManager smsManager;
                int i;
                int i2;
                int i3;
                int defaultSmsSubscriptionId;
                int i4;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (it == PermissionStatus.GRANTED) {
                    mEtPhone = DeveloperSmsTestActivity.this.getMEtPhone();
                    String obj = mEtPhone.getText().toString();
                    mEtContent = DeveloperSmsTestActivity.this.getMEtContent();
                    String obj2 = mEtContent.getText().toString();
                    if (obj.length() <= 0 || obj2.length() <= 0) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 22) {
                        i2 = DeveloperSmsTestActivity.this.subId;
                        if (i2 == -1) {
                            DeveloperSmsTestActivity developerSmsTestActivity = DeveloperSmsTestActivity.this;
                            defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
                            developerSmsTestActivity.subId = defaultSmsSubscriptionId;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Default subId ");
                            i4 = DeveloperSmsTestActivity.this.subId;
                            sb.append(i4);
                            LogUtils.d(sb.toString());
                        }
                        i3 = DeveloperSmsTestActivity.this.subId;
                        smsManager = SmsManager.getSmsManagerForSubscriptionId(i3);
                    } else {
                        smsManager = SmsManager.getDefault();
                    }
                    SmsManager smsManager2 = smsManager;
                    ArrayList<String> divideMessage = smsManager2.divideMessage(obj2);
                    kotlin.jvm.internal.IIX0o.oO(divideMessage, "divideMessage(...)");
                    Iterator<String> it2 = divideMessage.iterator();
                    while (it2.hasNext()) {
                        smsManager2.sendTextMessage(obj, null, it2.next(), null, null);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    i = DeveloperSmsTestActivity.this.subId;
                    sb2.append(i);
                    sb2.append(TokenParser.SP);
                    sb2.append(obj);
                    sb2.append(" ========> ");
                    sb2.append(obj2);
                    LogUtils.d(sb2.toString());
                }
            }
        }, 3, null);
    }
}
