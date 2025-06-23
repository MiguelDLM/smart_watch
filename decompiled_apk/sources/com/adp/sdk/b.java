package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.SourceVO;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class b {
    public static ArrayList<SourceVO> a(AdItem adItem, SourceVO sourceVO) {
        ArrayList<SourceVO> arrayList = new ArrayList<>();
        for (int i = 0; i < adItem.getAdSource().size(); i++) {
            if (!(sourceVO.getId() + "").equals(adItem.getAdSource().get(i).getId() + "")) {
                SourceVO sourceVO2 = new SourceVO();
                sourceVO2.setId(adItem.getAdSource().get(i).getId());
                sourceVO2.setRate(adItem.getAdSource().get(i).getRate());
                sourceVO2.setSource(adItem.getAdSource().get(i).getSource());
                sourceVO2.setShowAfterTimeOut(adItem.getAdSource().get(i).isShowAfterTimeOut());
                sourceVO2.setPrice(adItem.getAdSource().get(i).getPrice());
                arrayList.add(sourceVO2);
            }
        }
        return arrayList;
    }

    public static boolean a(AdItem adItem, int i) {
        Iterator<SourceVO> it = adItem.getAdSource().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int rate = it.next().getRate();
            if (rate > 0) {
                i2 += rate;
            }
        }
        return i >= i2;
    }

    public static SourceVO a(AdItem adItem, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        for (SourceVO sourceVO : adItem.getAdSource()) {
            if (sourceVO.getRate() > 0) {
                for (int i2 = 0; i2 < sourceVO.getRate(); i2++) {
                    arrayList.add(sourceVO);
                }
            }
        }
        return (SourceVO) arrayList.get(new SecureRandom().nextInt(arrayList.size()));
    }
}
