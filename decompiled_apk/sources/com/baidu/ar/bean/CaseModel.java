package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.ARType;

/* loaded from: classes7.dex */
public class CaseModel {
    public String mCaseId;
    public String mCasePath;
    public ARType mCaseType;

    public CaseModel(ARType aRType, String str, String str2) {
        this.mCaseType = aRType;
        this.mCasePath = str;
        this.mCaseId = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof CaseModel) {
            return (!TextUtils.isEmpty(this.mCasePath) && this.mCasePath.equals(((CaseModel) obj).mCasePath)) || (TextUtils.isEmpty(this.mCasePath) && !TextUtils.isEmpty(this.mCaseId) && this.mCaseId.equals(((CaseModel) obj).mCaseId));
        }
        return false;
    }
}
