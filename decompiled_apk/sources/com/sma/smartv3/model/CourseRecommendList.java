package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CourseRecommendList extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final CourseDetails course;

    @OOXIXo
    private String courseTitle;
    private final int id;

    public /* synthetic */ CourseRecommendList(int i, String str, CourseDetails courseDetails, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "" : str, courseDetails);
    }

    public static /* synthetic */ CourseRecommendList copy$default(CourseRecommendList courseRecommendList, int i, String str, CourseDetails courseDetails, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = courseRecommendList.id;
        }
        if ((i2 & 2) != 0) {
            str = courseRecommendList.courseTitle;
        }
        if ((i2 & 4) != 0) {
            courseDetails = courseRecommendList.course;
        }
        return courseRecommendList.copy(i, str, courseDetails);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.courseTitle;
    }

    @OOXIXo
    public final CourseDetails component3() {
        return this.course;
    }

    @OOXIXo
    public final CourseRecommendList copy(int i, @OOXIXo String courseTitle, @OOXIXo CourseDetails course) {
        IIX0o.x0xO0oo(courseTitle, "courseTitle");
        IIX0o.x0xO0oo(course, "course");
        return new CourseRecommendList(i, courseTitle, course);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseRecommendList)) {
            return false;
        }
        CourseRecommendList courseRecommendList = (CourseRecommendList) obj;
        return this.id == courseRecommendList.id && IIX0o.Oxx0IOOO(this.courseTitle, courseRecommendList.courseTitle) && IIX0o.Oxx0IOOO(this.course, courseRecommendList.course);
    }

    @OOXIXo
    public final CourseDetails getCourse() {
        return this.course;
    }

    @OOXIXo
    public final String getCourseTitle() {
        return this.courseTitle;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return (((this.id * 31) + this.courseTitle.hashCode()) * 31) + this.course.hashCode();
    }

    public final void setCourseTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.courseTitle = str;
    }

    @OOXIXo
    public String toString() {
        return "CourseRecommendList(id=" + this.id + ", courseTitle=" + this.courseTitle + ", course=" + this.course + HexStringBuilder.COMMENT_END_CHAR;
    }

    public CourseRecommendList(int i, @OOXIXo String courseTitle, @OOXIXo CourseDetails course) {
        IIX0o.x0xO0oo(courseTitle, "courseTitle");
        IIX0o.x0xO0oo(course, "course");
        this.id = i;
        this.courseTitle = courseTitle;
        this.course = course;
    }
}
