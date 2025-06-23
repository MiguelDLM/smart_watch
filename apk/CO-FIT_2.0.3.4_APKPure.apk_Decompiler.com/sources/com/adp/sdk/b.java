package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.SourceVO;
import java.security.SecureRandom;
import java.util.ArrayList;

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
        int i2 = 0;
        for (SourceVO rate : adItem.getAdSource()) {
            int rate2 = rate.getRate();
            if (rate2 > 0) {
                i2 += rate2;
            }
        }
        if (i >= i2) {
            return true;
        }
        return false;
    }

    public static SourceVO a(AdItem adItem, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        for (SourceVO next : adItem.getAdSource()) {
            if (next.getRate() > 0) {
                for (int i2 = 0; i2 < next.getRate(); i2++) {
                    arrayList.add(next);
                }
            }
        }
        return (SourceVO) arrayList.get(new SecureRandom().nextInt(arrayList.size()));
    }
}
