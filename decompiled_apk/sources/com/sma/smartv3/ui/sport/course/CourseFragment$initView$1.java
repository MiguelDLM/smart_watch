package com.sma.smartv3.ui.sport.course;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.I0oOoX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.sport.course.CourseFragment$initView$1", f = "CourseFragment.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nCourseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseFragment.kt\ncom/sma/smartv3/ui/sport/course/CourseFragment$initView$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n50#2,3:128\n53#2:134\n55#2,2:136\n1549#3:131\n1620#3,2:132\n1622#3:135\n*S KotlinDebug\n*F\n+ 1 CourseFragment.kt\ncom/sma/smartv3/ui/sport/course/CourseFragment$initView$1\n*L\n55#1:128,3\n55#1:134\n55#1:136,2\n55#1:131\n55#1:132,2\n55#1:135\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseFragment$initView$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;
    final /* synthetic */ CourseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseFragment$initView$1(CourseFragment courseFragment, kotlin.coroutines.I0Io<? super CourseFragment$initView$1> i0Io) {
        super(2, i0Io);
        this.this$0 = courseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new CourseFragment$initView$1(this.this$0, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        List ooXIXxIX2;
        boolean time;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(300L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.X0o0xo().getString(XoI0Ixx0.f24494xx0X0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), CourseList.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if (!ooXIXxIX2.isEmpty()) {
            time = this.this$0.getTime(ooXIXxIX2);
            if (time) {
                this.this$0.onRefPost();
            } else {
                this.this$0.onLoadData(ooXIXxIX2);
            }
        } else {
            this.this$0.onRefPost();
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((CourseFragment$initView$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
