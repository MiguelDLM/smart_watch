package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.ad;
import java.util.List;

/* loaded from: classes10.dex */
class i extends BaseAdapter {
    private static final int Code = 2;
    private List<PermissionEntity> I;
    private Context V;
    private LayoutInflater Z;

    /* loaded from: classes10.dex */
    public static class a {
        TextView Code;

        public a(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_child_tv);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        TextView Code;

        public b(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    public i(Context context, List<PermissionEntity> list) {
        this.V = context;
        this.I = list;
        this.Z = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ad.Code(this.I)) {
            return 0;
        }
        return this.I.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ad.Code(this.I)) {
            return null;
        }
        return this.I.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ad.Code(this.I)) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (ad.Code(this.I) || this.I.get(i) == null) {
            return 0;
        }
        return this.I.get(i).V();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r8.setText(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L16;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.util.List<com.huawei.openalliance.ad.inter.data.PermissionEntity> r2 = r5.I
            java.lang.Object r2 = r2.get(r6)
            com.huawei.openalliance.ad.inter.data.PermissionEntity r2 = (com.huawei.openalliance.ad.inter.data.PermissionEntity) r2
            int r3 = r5.getItemViewType(r6)
            java.lang.String r4 = ""
            if (r3 == 0) goto L44
            if (r3 == r0) goto L15
            goto L6e
        L15:
            if (r7 != 0) goto L28
            android.view.LayoutInflater r7 = r5.Z
            int r3 = com.huawei.hms.ads.base.R.layout.hiad_permission_dialog_child_item
            android.view.View r7 = r7.inflate(r3, r8, r1)
            com.huawei.openalliance.ad.download.app.i$a r8 = new com.huawei.openalliance.ad.download.app.i$a
            r8.<init>(r7)
            r7.setTag(r8)
            goto L2e
        L28:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.i$a r8 = (com.huawei.openalliance.ad.download.app.i.a) r8
        L2e:
            if (r2 == 0) goto L35
            java.lang.String r2 = r2.Code()
            goto L36
        L35:
            r2 = r4
        L36:
            android.widget.TextView r8 = r8.Code
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L3f
            goto L40
        L3f:
            r4 = r2
        L40:
            r8.setText(r4)
            goto L6e
        L44:
            if (r7 != 0) goto L57
            android.view.LayoutInflater r7 = r5.Z
            int r3 = com.huawei.hms.ads.base.R.layout.hiad_permission_dialog_parent_item
            android.view.View r7 = r7.inflate(r3, r8, r1)
            com.huawei.openalliance.ad.download.app.i$b r8 = new com.huawei.openalliance.ad.download.app.i$b
            r8.<init>(r7)
            r7.setTag(r8)
            goto L5d
        L57:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.i$b r8 = (com.huawei.openalliance.ad.download.app.i.b) r8
        L5d:
            if (r2 == 0) goto L64
            java.lang.String r2 = r2.Code()
            goto L65
        L64:
            r2 = r4
        L65:
            android.widget.TextView r8 = r8.Code
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L3f
            goto L40
        L6e:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r8 = java.lang.Long.valueOf(r2)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            r2[r0] = r6
            java.lang.String r6 = "AppPermissionsDialog"
            java.lang.String r8 = "getView, time:%s, position:%s"
            com.huawei.hms.ads.fb.Code(r6, r8, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.download.app.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
