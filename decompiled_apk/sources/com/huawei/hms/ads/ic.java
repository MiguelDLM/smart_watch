package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;

/* loaded from: classes10.dex */
public class ic extends ib<kg> implements io {
    public ic(Context context, kg kgVar) {
        super(context, kgVar);
    }

    @Override // com.huawei.hms.ads.ib
    public void V(final String str) {
        ((kg) I()).B();
        fb.V("PPSImageViewPresenter", "onMaterialLoaded - begin to load image");
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(this.Code);
        com.huawei.openalliance.ad.utils.z.Code(this.V, sourceParam, new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.ic.1
            @Override // com.huawei.openalliance.ad.utils.an
            public void Code() {
                fb.V("PPSImageViewPresenter", "onMaterialLoaded - image load failed");
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ic.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((kg) ic.this.I()).Code(-9);
                    }
                });
                ic icVar = ic.this;
                icVar.V(icVar.Code);
            }

            @Override // com.huawei.openalliance.ad.utils.an
            public void Code(String str2, final Drawable drawable) {
                if (TextUtils.equals(str2, str)) {
                    fb.V("PPSImageViewPresenter", "onMaterialLoaded - image load success");
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ic.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((kg) ic.this.I()).Code(drawable);
                            ((kg) ic.this.I()).Z();
                        }
                    });
                } else {
                    Code();
                    ic icVar = ic.this;
                    cy.Code(icVar.V, 5, "url not equals filePath", icVar.Code);
                }
            }
        });
    }
}
