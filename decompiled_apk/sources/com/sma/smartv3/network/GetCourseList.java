package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetCourseList {

    @OOXIXo
    public static final String COURSE_DIFF = "courseDiff";

    @OOXIXo
    public static final String COURSE_PART = "coursePart";

    @OOXIXo
    public static final String COURSE_TYPE = "courseType";

    @OOXIXo
    public static final GetCourseList INSTANCE = new GetCourseList();

    @OOXIXo
    public static final String URL = "/course/appSearch";

    private GetCourseList() {
    }
}
