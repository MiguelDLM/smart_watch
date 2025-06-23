package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.device.guide.NotificationSetGuideFragment;
import com.sma.smartv3.ui.device.x0XOIxOo;
import com.sma.smartv3.util.O0Xx;
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nNotificationSetGuideFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationSetGuideFragment.kt\ncom/sma/smartv3/ui/device/guide/NotificationSetGuideFragment\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n13309#2,2:186\n1#3:188\n*S KotlinDebug\n*F\n+ 1 NotificationSetGuideFragment.kt\ncom/sma/smartv3/ui/device/guide/NotificationSetGuideFragment\n*L\n76#1:186,2\n*E\n"})
/* loaded from: classes12.dex */
public final class NotificationSetGuideFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private CheckBox checkCall;
    private CheckBox checkSms;
    private ListView defautListView;
    private View ll;

    @oOoXoXO
    private XoI0Ixx0 mPermissionPopup;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends XIOOI.oIX0oI<x0XOIxOo> {

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ List<x0XOIxOo> f22670Oxx0xo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(List<x0XOIxOo> list, Activity activity) {
            super(activity, R.layout.item_notification, list);
            this.f22670Oxx0xo = list;
        }

        public static final void Oxx0IOOO(List list, int i, View view) {
            IIX0o.x0xO0oo(list, "$list");
            ((x0XOIxOo) list.get(i)).X0o0xo(!((x0XOIxOo) list.get(i)).oxoX());
            Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + ((x0XOIxOo) list.get(i)).I0Io(), ((x0XOIxOo) list.get(i)).oxoX());
            LogUtils.d(((x0XOIxOo) list.get(i)).toString());
        }

        @Override // XIOOI.oIX0oI, XIOOI.II0xO0
        /* renamed from: XO, reason: merged with bridge method [inline-methods] */
        public void II0xO0(@OOXIXo XIOOI.I0Io holder, @OOXIXo x0XOIxOo item, final int i) {
            IIX0o.x0xO0oo(holder, "holder");
            IIX0o.x0xO0oo(item, "item");
            final List<x0XOIxOo> list = this.f22670Oxx0xo;
            holder.oOoXoXO(R.id.iv_icon, list.get(i).oIX0oI());
            holder.o00(R.id.tv_name, list.get(i).II0xO0());
            list.get(i).X0o0xo(Xo0.f24349oIX0oI.I0Io().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + list.get(i).I0Io(), false));
            holder.xoIox(R.id.check_enabled, list.get(i).oxoX());
            oOXoIIIo.Oxx0IOOO.oIX0oI(holder, R.id.check_enabled, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.guide.Oxx0IOOO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationSetGuideFragment.oIX0oI.Oxx0IOOO(list, i, view);
                }
            });
        }

        @Override // XIOOI.II0xO0, android.widget.Adapter
        public int getCount() {
            return this.f22670Oxx0xo.size();
        }
    }

    private final void showDefaultList() {
        ListView listView;
        ApplicationInfo applicationInfo;
        ArrayList arrayList = new ArrayList();
        String[] oI0IIXIo2 = ProjectManager.f19822oIX0oI.oI0IIXIo();
        int length = oI0IIXIo2.length;
        int i = 0;
        while (true) {
            listView = null;
            Drawable drawable = null;
            if (i >= length) {
                break;
            }
            String str = oI0IIXIo2[i];
            try {
                applicationInfo = getMActivity().getPackageManager().getApplicationInfo(str, 0);
            } catch (Exception unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                x0XOIxOo x0xoixoo = new x0XOIxOo();
                x0xoixoo.XO(applicationInfo.loadIcon(getMActivity().getPackageManager()));
                x0xoixoo.Oxx0IOOO(applicationInfo.loadLabel(getMActivity().getPackageManager()).toString());
                x0xoixoo.II0XooXoX(applicationInfo.packageName);
                arrayList.add(x0xoixoo);
            } else if (ProjectManager.f19822oIX0oI.OIx00oxx()) {
                Pair<Integer, String> oIX0oI2 = O0Xx.f24313oIX0oI.oIX0oI(str);
                int intValue = oIX0oI2.component1().intValue();
                String component2 = oIX0oI2.component2();
                if (component2.length() > 0) {
                    x0XOIxOo x0xoixoo2 = new x0XOIxOo();
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        drawable = activity.getDrawable(intValue);
                    }
                    x0xoixoo2.XO(drawable);
                    x0xoixoo2.Oxx0IOOO(component2);
                    x0xoixoo2.II0XooXoX(str);
                    arrayList.add(x0xoixoo2);
                }
            }
            i++;
        }
        oIX0oI oix0oi = new oIX0oI(arrayList, getMActivity());
        ListView listView2 = this.defautListView;
        if (listView2 == null) {
            IIX0o.XOxIOxOx("defautListView");
        } else {
            listView = listView2;
        }
        listView.setAdapter((ListAdapter) oix0oi);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cd, code lost:
    
        if (com.blankj.utilcode.util.PermissionUtils.isGranted((java.lang.String[]) java.util.Arrays.copyOf(r0, r0.length)) != false) goto L28;
     */
    @Override // com.bestmafen.androidbase.base.oIX0oI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView() {
        /*
            r8 = this;
            android.view.View r0 = r8.getMView()
            r1 = 2131365833(0x7f0a0fc9, float:1.8351542E38)
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "findViewById(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            r8.ll = r0
            android.view.View r0 = r8.getMView()
            r2 = 2131363663(0x7f0a074f, float:1.8347141E38)
            android.view.View r0 = r0.findViewById(r2)
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r8.checkCall = r0
            android.view.View r0 = r8.getMView()
            r2 = 2131363674(0x7f0a075a, float:1.8347163E38)
            android.view.View r0 = r0.findViewById(r2)
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r8.checkSms = r0
            android.view.View r0 = r8.getMView()
            r2 = 2131363954(0x7f0a0872, float:1.8347731E38)
            android.view.View r0 = r0.findViewById(r2)
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            android.widget.ListView r0 = (android.widget.ListView) r0
            r8.defautListView = r0
            com.sma.smartv3.ble.ProductManager r0 = com.sma.smartv3.ble.ProductManager.f20544oIX0oI
            boolean r0 = r0.IoIOOxIIo()
            r1 = 1
            java.lang.String r2 = "checkCall"
            java.lang.String r3 = "notification_call"
            java.lang.String r4 = "ll"
            r5 = 0
            r6 = 0
            if (r0 == 0) goto L90
            android.view.View r0 = r8.ll
            if (r0 != 0) goto L61
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r4)
            r0 = r6
        L61:
            r0.setVisibility(r5)
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.I0Io()
            boolean r0 = r0.getBoolean(r3, r5)
            android.widget.CheckBox r3 = r8.checkCall
            if (r3 != 0) goto L76
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r2)
            r3 = r6
        L76:
            if (r0 == 0) goto L8b
            java.lang.String[] r0 = com.sma.smartv3.ui.device.X00xOoXI.oIX0oI()
            int r4 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r4)
            java.lang.String[] r0 = (java.lang.String[]) r0
            boolean r0 = com.blankj.utilcode.util.PermissionUtils.isGranted(r0)
            if (r0 == 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            r3.setChecked(r0)
            goto La6
        L90:
            android.view.View r0 = r8.ll
            if (r0 != 0) goto L98
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r4)
            r0 = r6
        L98:
            r4 = 8
            r0.setVisibility(r4)
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.I0Io()
            r0.put(r3, r5)
        La6:
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.I0Io()
            java.lang.String r3 = "notification_sms"
            boolean r0 = r0.getBoolean(r3, r5)
            android.widget.CheckBox r3 = r8.checkSms
            java.lang.String r4 = "checkSms"
            if (r3 != 0) goto Lbc
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r4)
            r3 = r6
        Lbc:
            if (r0 == 0) goto Ld0
            java.lang.String[] r0 = com.sma.smartv3.ui.device.X00xOoXI.II0xO0()
            int r7 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r7)
            java.lang.String[] r0 = (java.lang.String[]) r0
            boolean r0 = com.blankj.utilcode.util.PermissionUtils.isGranted(r0)
            if (r0 == 0) goto Ld0
            goto Ld1
        Ld0:
            r1 = 0
        Ld1:
            r3.setChecked(r1)
            android.widget.CheckBox r0 = r8.checkCall
            if (r0 != 0) goto Ldc
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r2)
            r0 = r6
        Ldc:
            r0.setOnCheckedChangeListener(r8)
            android.widget.CheckBox r0 = r8.checkSms
            if (r0 != 0) goto Le7
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r4)
            goto Le8
        Le7:
            r6 = r0
        Le8:
            r6.setOnCheckedChangeListener(r8)
            r8.showDefaultList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.guide.NotificationSetGuideFragment.initView():void");
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_app_guide_notification;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@OOXIXo final CompoundButton buttonView, final boolean z) {
        IIX0o.x0xO0oo(buttonView, "buttonView");
        int id = buttonView.getId();
        if (id != R.id.check_call) {
            if (id == R.id.check_sms) {
                if (z) {
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.SMS);
                    IIX0o.oO(permission, "permission(...)");
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.guide.NotificationSetGuideFragment$onCheckedChanged$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo PermissionStatus it) {
                            IIX0o.x0xO0oo(it, "it");
                            if (it == PermissionStatus.GRANTED) {
                                Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24352I0Io, z);
                                BleInitializer.f20700XO.xOOOX();
                            } else {
                                this.permissionRemind();
                                buttonView.setChecked(!z);
                            }
                        }
                    }, 3, null);
                    return;
                }
                Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24352I0Io, z);
                return;
            }
            return;
        }
        if (z) {
            PermissionUtils permission2 = PermissionUtils.permission(PermissionConstants.PHONE, PermissionConstants.CONTACTS);
            IIX0o.oO(permission2, "permission(...)");
            oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.guide.NotificationSetGuideFragment$onCheckedChanged$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                    invoke2(permissionStatus);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo PermissionStatus it) {
                    Activity mActivity;
                    IIX0o.x0xO0oo(it, "it");
                    if (it == PermissionStatus.GRANTED) {
                        Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, z);
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        bleInitializer.Ox0O();
                        mActivity = this.getMActivity();
                        bleInitializer.XIXIxO(mActivity);
                        return;
                    }
                    this.permissionRemind();
                    buttonView.setChecked(!z);
                }
            }, 3, null);
        } else {
            Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, z);
            BleInitializer.f20700XO.Ox0O();
        }
    }

    public final void permissionRemind() {
        if (this.mPermissionPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.permission_set_remind);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.guide.NotificationSetGuideFragment$permissionRemind$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    PermissionUtils.launchAppDetailsSettings();
                    return Boolean.TRUE;
                }
            });
            this.mPermissionPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mPermissionPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.oI0IIXIo(R.id.root_view);
        }
    }
}
