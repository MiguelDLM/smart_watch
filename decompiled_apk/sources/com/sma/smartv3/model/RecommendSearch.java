package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class RecommendSearch extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final ArrayList<CourseRecommendList> courseRecommendList;
    private final int id;
    private long onCreateTime;

    @OOXIXo
    private final String recommendIntro;

    @OOXIXo
    private final String recommendTitle;

    @OOXIXo
    private final String recommendType;

    public /* synthetic */ RecommendSearch(int i, String str, String str2, String str3, long j, ArrayList arrayList, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "体态改善，拉伸训练" : str, (i2 & 4) != 0 ? "INDEX" : str2, (i2 & 8) != 0 ? "111111" : str3, (i2 & 16) != 0 ? 0L : j, arrayList);
    }

    public static /* synthetic */ RecommendSearch copy$default(RecommendSearch recommendSearch, int i, String str, String str2, String str3, long j, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recommendSearch.id;
        }
        if ((i2 & 2) != 0) {
            str = recommendSearch.recommendTitle;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = recommendSearch.recommendType;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = recommendSearch.recommendIntro;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            j = recommendSearch.onCreateTime;
        }
        long j2 = j;
        if ((i2 & 32) != 0) {
            arrayList = recommendSearch.courseRecommendList;
        }
        return recommendSearch.copy(i, str4, str5, str6, j2, arrayList);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.recommendTitle;
    }

    @OOXIXo
    public final String component3() {
        return this.recommendType;
    }

    @OOXIXo
    public final String component4() {
        return this.recommendIntro;
    }

    public final long component5() {
        return this.onCreateTime;
    }

    @OOXIXo
    public final ArrayList<CourseRecommendList> component6() {
        return this.courseRecommendList;
    }

    @OOXIXo
    public final RecommendSearch copy(int i, @OOXIXo String recommendTitle, @OOXIXo String recommendType, @OOXIXo String recommendIntro, long j, @OOXIXo ArrayList<CourseRecommendList> courseRecommendList) {
        IIX0o.x0xO0oo(recommendTitle, "recommendTitle");
        IIX0o.x0xO0oo(recommendType, "recommendType");
        IIX0o.x0xO0oo(recommendIntro, "recommendIntro");
        IIX0o.x0xO0oo(courseRecommendList, "courseRecommendList");
        return new RecommendSearch(i, recommendTitle, recommendType, recommendIntro, j, courseRecommendList);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendSearch)) {
            return false;
        }
        RecommendSearch recommendSearch = (RecommendSearch) obj;
        return this.id == recommendSearch.id && IIX0o.Oxx0IOOO(this.recommendTitle, recommendSearch.recommendTitle) && IIX0o.Oxx0IOOO(this.recommendType, recommendSearch.recommendType) && IIX0o.Oxx0IOOO(this.recommendIntro, recommendSearch.recommendIntro) && this.onCreateTime == recommendSearch.onCreateTime && IIX0o.Oxx0IOOO(this.courseRecommendList, recommendSearch.courseRecommendList);
    }

    @OOXIXo
    public final ArrayList<CourseRecommendList> getCourseRecommendList() {
        return this.courseRecommendList;
    }

    public final int getId() {
        return this.id;
    }

    public final long getOnCreateTime() {
        return this.onCreateTime;
    }

    @OOXIXo
    public final String getRecommendIntro() {
        return this.recommendIntro;
    }

    @OOXIXo
    public final String getRecommendTitle() {
        return this.recommendTitle;
    }

    @OOXIXo
    public final String getRecommendType() {
        return this.recommendType;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.recommendTitle.hashCode()) * 31) + this.recommendType.hashCode()) * 31) + this.recommendIntro.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.onCreateTime)) * 31) + this.courseRecommendList.hashCode();
    }

    public final void setOnCreateTime(long j) {
        this.onCreateTime = j;
    }

    @OOXIXo
    public String toString() {
        return "RecommendSearch(id=" + this.id + ", recommendTitle=" + this.recommendTitle + ", recommendType=" + this.recommendType + ", recommendIntro=" + this.recommendIntro + ", onCreateTime=" + this.onCreateTime + ", courseRecommendList=" + this.courseRecommendList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public RecommendSearch(int i, @OOXIXo String recommendTitle, @OOXIXo String recommendType, @OOXIXo String recommendIntro, long j, @OOXIXo ArrayList<CourseRecommendList> courseRecommendList) {
        IIX0o.x0xO0oo(recommendTitle, "recommendTitle");
        IIX0o.x0xO0oo(recommendType, "recommendType");
        IIX0o.x0xO0oo(recommendIntro, "recommendIntro");
        IIX0o.x0xO0oo(courseRecommendList, "courseRecommendList");
        this.id = i;
        this.recommendTitle = recommendTitle;
        this.recommendType = recommendType;
        this.recommendIntro = recommendIntro;
        this.onCreateTime = j;
        this.courseRecommendList = courseRecommendList;
    }
}
