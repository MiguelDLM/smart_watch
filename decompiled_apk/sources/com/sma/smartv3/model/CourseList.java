package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CourseList extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String collectFlag;

    @OOXIXo
    private final String courseClass;

    @OOXIXo
    private final String courseDiff;

    @OOXIXo
    private final String courseHeat;

    @OOXIXo
    private final String courseIntro;

    @OOXIXo
    private final String courseName;

    @OOXIXo
    private final String coursePart;

    @OOXIXo
    private final String coursePic1;

    @OOXIXo
    private final String coursePic2;

    @OOXIXo
    private final String courseTime;

    @OOXIXo
    private String courseTitle;

    @OOXIXo
    private final String courseType;

    @OOXIXo
    private final String id;
    private long onSaveTime;

    @OOXIXo
    private final String takeFlag;

    @OOXIXo
    private final String valid;
    private final int version;

    public /* synthetic */ CourseList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, long j, String str13, String str14, String str15, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "0" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) != 0 ? "" : str10, (i2 & 1024) != 0 ? "" : str11, (i2 & 2048) != 0 ? "" : str12, i, j, (i2 & 16384) != 0 ? "N" : str13, (32768 & i2) != 0 ? "N" : str14, (i2 & 65536) != 0 ? "" : str15);
    }

    @OOXIXo
    public final String component1() {
        return this.courseName;
    }

    @OOXIXo
    public final String component10() {
        return this.courseClass;
    }

    @OOXIXo
    public final String component11() {
        return this.valid;
    }

    @OOXIXo
    public final String component12() {
        return this.id;
    }

    public final int component13() {
        return this.version;
    }

    public final long component14() {
        return this.onSaveTime;
    }

    @OOXIXo
    public final String component15() {
        return this.takeFlag;
    }

    @OOXIXo
    public final String component16() {
        return this.collectFlag;
    }

    @OOXIXo
    public final String component17() {
        return this.courseTitle;
    }

    @OOXIXo
    public final String component2() {
        return this.courseType;
    }

    @OOXIXo
    public final String component3() {
        return this.courseDiff;
    }

    @OOXIXo
    public final String component4() {
        return this.coursePart;
    }

    @OOXIXo
    public final String component5() {
        return this.courseHeat;
    }

    @OOXIXo
    public final String component6() {
        return this.courseTime;
    }

    @OOXIXo
    public final String component7() {
        return this.coursePic1;
    }

    @OOXIXo
    public final String component8() {
        return this.coursePic2;
    }

    @OOXIXo
    public final String component9() {
        return this.courseIntro;
    }

    @OOXIXo
    public final CourseList copy(@OOXIXo String courseName, @OOXIXo String courseType, @OOXIXo String courseDiff, @OOXIXo String coursePart, @OOXIXo String courseHeat, @OOXIXo String courseTime, @OOXIXo String coursePic1, @OOXIXo String coursePic2, @OOXIXo String courseIntro, @OOXIXo String courseClass, @OOXIXo String valid, @OOXIXo String id, int i, long j, @OOXIXo String takeFlag, @OOXIXo String collectFlag, @OOXIXo String courseTitle) {
        IIX0o.x0xO0oo(courseName, "courseName");
        IIX0o.x0xO0oo(courseType, "courseType");
        IIX0o.x0xO0oo(courseDiff, "courseDiff");
        IIX0o.x0xO0oo(coursePart, "coursePart");
        IIX0o.x0xO0oo(courseHeat, "courseHeat");
        IIX0o.x0xO0oo(courseTime, "courseTime");
        IIX0o.x0xO0oo(coursePic1, "coursePic1");
        IIX0o.x0xO0oo(coursePic2, "coursePic2");
        IIX0o.x0xO0oo(courseIntro, "courseIntro");
        IIX0o.x0xO0oo(courseClass, "courseClass");
        IIX0o.x0xO0oo(valid, "valid");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(takeFlag, "takeFlag");
        IIX0o.x0xO0oo(collectFlag, "collectFlag");
        IIX0o.x0xO0oo(courseTitle, "courseTitle");
        return new CourseList(courseName, courseType, courseDiff, coursePart, courseHeat, courseTime, coursePic1, coursePic2, courseIntro, courseClass, valid, id, i, j, takeFlag, collectFlag, courseTitle);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseList)) {
            return false;
        }
        CourseList courseList = (CourseList) obj;
        return IIX0o.Oxx0IOOO(this.courseName, courseList.courseName) && IIX0o.Oxx0IOOO(this.courseType, courseList.courseType) && IIX0o.Oxx0IOOO(this.courseDiff, courseList.courseDiff) && IIX0o.Oxx0IOOO(this.coursePart, courseList.coursePart) && IIX0o.Oxx0IOOO(this.courseHeat, courseList.courseHeat) && IIX0o.Oxx0IOOO(this.courseTime, courseList.courseTime) && IIX0o.Oxx0IOOO(this.coursePic1, courseList.coursePic1) && IIX0o.Oxx0IOOO(this.coursePic2, courseList.coursePic2) && IIX0o.Oxx0IOOO(this.courseIntro, courseList.courseIntro) && IIX0o.Oxx0IOOO(this.courseClass, courseList.courseClass) && IIX0o.Oxx0IOOO(this.valid, courseList.valid) && IIX0o.Oxx0IOOO(this.id, courseList.id) && this.version == courseList.version && this.onSaveTime == courseList.onSaveTime && IIX0o.Oxx0IOOO(this.takeFlag, courseList.takeFlag) && IIX0o.Oxx0IOOO(this.collectFlag, courseList.collectFlag) && IIX0o.Oxx0IOOO(this.courseTitle, courseList.courseTitle);
    }

    @OOXIXo
    public final String getCollectFlag() {
        return this.collectFlag;
    }

    @OOXIXo
    public final String getCourseClass() {
        return this.courseClass;
    }

    @OOXIXo
    public final String getCourseDiff() {
        return this.courseDiff;
    }

    @OOXIXo
    public final String getCourseHeat() {
        return this.courseHeat;
    }

    @OOXIXo
    public final String getCourseIntro() {
        return this.courseIntro;
    }

    @OOXIXo
    public final String getCourseName() {
        return this.courseName;
    }

    @OOXIXo
    public final String getCoursePart() {
        return this.coursePart;
    }

    @OOXIXo
    public final String getCoursePic1() {
        return this.coursePic1;
    }

    @OOXIXo
    public final String getCoursePic2() {
        return this.coursePic2;
    }

    @OOXIXo
    public final String getCourseTime() {
        return this.courseTime;
    }

    @OOXIXo
    public final String getCourseTitle() {
        return this.courseTitle;
    }

    @OOXIXo
    public final String getCourseType() {
        return this.courseType;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    public final long getOnSaveTime() {
        return this.onSaveTime;
    }

    @OOXIXo
    public final String getTakeFlag() {
        return this.takeFlag;
    }

    @OOXIXo
    public final String getValid() {
        return this.valid;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.courseName.hashCode() * 31) + this.courseType.hashCode()) * 31) + this.courseDiff.hashCode()) * 31) + this.coursePart.hashCode()) * 31) + this.courseHeat.hashCode()) * 31) + this.courseTime.hashCode()) * 31) + this.coursePic1.hashCode()) * 31) + this.coursePic2.hashCode()) * 31) + this.courseIntro.hashCode()) * 31) + this.courseClass.hashCode()) * 31) + this.valid.hashCode()) * 31) + this.id.hashCode()) * 31) + this.version) * 31) + androidx.collection.oIX0oI.oIX0oI(this.onSaveTime)) * 31) + this.takeFlag.hashCode()) * 31) + this.collectFlag.hashCode()) * 31) + this.courseTitle.hashCode();
    }

    public final void setCourseTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.courseTitle = str;
    }

    public final void setOnSaveTime(long j) {
        this.onSaveTime = j;
    }

    @OOXIXo
    public String toString() {
        return "CourseList(courseName=" + this.courseName + ", courseType=" + this.courseType + ", courseDiff=" + this.courseDiff + ", coursePart=" + this.coursePart + ", courseHeat=" + this.courseHeat + ", courseTime=" + this.courseTime + ", coursePic1=" + this.coursePic1 + ", coursePic2=" + this.coursePic2 + ", courseIntro=" + this.courseIntro + ", courseClass=" + this.courseClass + ", valid=" + this.valid + ", id=" + this.id + ", version=" + this.version + ", onSaveTime=" + this.onSaveTime + ", takeFlag=" + this.takeFlag + ", collectFlag=" + this.collectFlag + ", courseTitle=" + this.courseTitle + HexStringBuilder.COMMENT_END_CHAR;
    }

    public CourseList(@OOXIXo String courseName, @OOXIXo String courseType, @OOXIXo String courseDiff, @OOXIXo String coursePart, @OOXIXo String courseHeat, @OOXIXo String courseTime, @OOXIXo String coursePic1, @OOXIXo String coursePic2, @OOXIXo String courseIntro, @OOXIXo String courseClass, @OOXIXo String valid, @OOXIXo String id, int i, long j, @OOXIXo String takeFlag, @OOXIXo String collectFlag, @OOXIXo String courseTitle) {
        IIX0o.x0xO0oo(courseName, "courseName");
        IIX0o.x0xO0oo(courseType, "courseType");
        IIX0o.x0xO0oo(courseDiff, "courseDiff");
        IIX0o.x0xO0oo(coursePart, "coursePart");
        IIX0o.x0xO0oo(courseHeat, "courseHeat");
        IIX0o.x0xO0oo(courseTime, "courseTime");
        IIX0o.x0xO0oo(coursePic1, "coursePic1");
        IIX0o.x0xO0oo(coursePic2, "coursePic2");
        IIX0o.x0xO0oo(courseIntro, "courseIntro");
        IIX0o.x0xO0oo(courseClass, "courseClass");
        IIX0o.x0xO0oo(valid, "valid");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(takeFlag, "takeFlag");
        IIX0o.x0xO0oo(collectFlag, "collectFlag");
        IIX0o.x0xO0oo(courseTitle, "courseTitle");
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDiff = courseDiff;
        this.coursePart = coursePart;
        this.courseHeat = courseHeat;
        this.courseTime = courseTime;
        this.coursePic1 = coursePic1;
        this.coursePic2 = coursePic2;
        this.courseIntro = courseIntro;
        this.courseClass = courseClass;
        this.valid = valid;
        this.id = id;
        this.version = i;
        this.onSaveTime = j;
        this.takeFlag = takeFlag;
        this.collectFlag = collectFlag;
        this.courseTitle = courseTitle;
    }
}
