package com.baidu.navisdk.ui.routeguide.toolbox.car;

import android.content.Context;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.toolbox.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ui.routeguide.toolbox.b {
    public b(Context context, d dVar) {
        super(context, 1, dVar);
        a aVar = new a();
        this.b = aVar;
        aVar.a(this);
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.b
    public List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> j() {
        ArrayList arrayList = new ArrayList();
        if (com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SORT.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(0);
            aVar.b("路线偏好");
            aVar.a(R.drawable.nsdk_drawable_toolbox_route_sort);
            arrayList.add(aVar);
        }
        if (com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SEARCH.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar2 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(1);
            aVar2.b("沿途搜索");
            aVar2.a(R.drawable.nsdk_drawable_toolbox_way_search);
            arrayList.add(aVar2);
        }
        if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a() && com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar3 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(2);
            aVar3.b("明星语音");
            aVar3.a(R.drawable.nsdk_drawable_toolbox_guide_voice);
            arrayList.add(aVar3);
        }
        if (com.baidu.navisdk.function.b.FUNC_TEAM_TRIP.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar4 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(3);
            aVar4.b("组队出行");
            aVar4.a(R.drawable.nsdk_drawable_location_share_toolbox_entry_icon);
            arrayList.add(aVar4);
        }
        if (com.baidu.navisdk.function.b.FUNC_ORIENTATION_CHANGE_BTN.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar5 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(4);
            aVar5.b("横屏导航");
            aVar5.a(R.drawable.nsdk_drawable_toolbox_orientation_changed_landscape);
            arrayList.add(aVar5);
        }
        if (com.baidu.navisdk.function.b.FUNC_DIY_SPEAK.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar6 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(5);
            aVar6.b("播报内容");
            aVar6.a(R.drawable.nsdk_drawable_toolbox_speak_mode);
            aVar6.c(true);
            aVar6.a("标准");
            arrayList.add(aVar6);
        }
        if (com.baidu.navisdk.function.b.FUNC_CAR_MODE_3D.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar7 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(6);
            aVar7.b("跟随车头");
            aVar7.a(R.drawable.nsdk_drawable_toolbox_car3d_mode);
            arrayList.add(aVar7);
        }
        if (com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar8 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(7);
            aVar8.b("车牌限行");
            aVar8.b(R.color.nsdk_cl_text_b_mm);
            aVar8.a(R.drawable.nsdk_drawable_toolbox_car_plate_closed);
            arrayList.add(aVar8);
        }
        return arrayList;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.b
    public int l() {
        return R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_settings;
    }
}
