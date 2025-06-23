package com.baidu.navisdk.ui.routeguide.motor.toolbox;

import android.content.Context;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.toolbox.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ui.routeguide.toolbox.b {
    public b(Context context, d dVar) {
        super(context, 2, dVar);
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
        if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a() && com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar2 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(2);
            aVar2.b("明星语音");
            aVar2.a(R.drawable.nsdk_drawable_toolbox_guide_voice);
            arrayList.add(aVar2);
        }
        if (com.baidu.navisdk.function.b.FUNC_TEAM_TRIP.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar3 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(3);
            aVar3.b("组队出行");
            aVar3.a(R.drawable.nsdk_drawable_location_share_toolbox_entry_icon);
            arrayList.add(aVar3);
        }
        if (com.baidu.navisdk.function.b.FUNC_ORIENTATION_CHANGE_BTN.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar4 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(4);
            aVar4.b("横屏导航");
            aVar4.a(R.drawable.nsdk_drawable_toolbox_orientation_changed_landscape);
            arrayList.add(aVar4);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar5 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(6);
        aVar5.b("跟随车头");
        aVar5.a(R.drawable.nsdk_drawable_toolbox_car3d_mode);
        arrayList.add(aVar5);
        if (com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar6 = new com.baidu.navisdk.ui.routeguide.toolbox.bean.a(7);
            aVar6.b("车牌限行");
            aVar6.b(R.color.nsdk_cl_text_b_mm);
            aVar6.a(R.drawable.nsdk_drawable_toolbox_car_plate_closed);
            arrayList.add(aVar6);
        }
        return arrayList;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.b
    public int l() {
        return R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_settings;
    }
}
