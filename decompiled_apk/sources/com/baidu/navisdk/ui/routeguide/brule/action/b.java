package com.baidu.navisdk.ui.routeguide.brule.action;

import android.text.TextUtils;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.g;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public class b implements com.baidu.navisdk.behavrules.action.b<com.baidu.navisdk.asr.sceneguide.a> {
    @Override // com.baidu.navisdk.behavrules.action.b
    public /* bridge */ /* synthetic */ boolean a(com.baidu.navisdk.asr.sceneguide.a aVar, List list) {
        return a2(aVar, (List<com.baidu.navisdk.behavrules.data.c>) list);
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public List<String> a() {
        return Arrays.asList("ballon_tip");
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public void a(com.baidu.navisdk.asr.sceneguide.a aVar) {
        if (com.baidu.navisdk.ui.routeguide.b.V().q() == 1 && com.baidu.navisdk.module.vehiclemanager.b.i().b() == 1) {
            com.baidu.navisdk.asr.model.a a2 = aVar.a();
            d.B().b(a2);
            if (TextUtils.isEmpty(a2.C0.f6555a)) {
                return;
            }
            TTSPlayerControl.playXDTTSText(a2.C0.f6555a, 1);
            return;
        }
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("behavRulesBNAsrSceneXDBubbleActionProcessor", "isAllMatched 气泡-->非专业驾车导航不执行");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.navisdk.behavrules.action.b
    public com.baidu.navisdk.asr.sceneguide.a a(com.baidu.navisdk.behavrules.scene.c cVar) {
        return com.baidu.navisdk.asr.sceneguide.a.a(cVar.i().b(), cVar.i().a(), cVar.m(), cVar.h());
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(com.baidu.navisdk.asr.sceneguide.a aVar, List<com.baidu.navisdk.behavrules.data.c> list) {
        if (aVar == null) {
            return false;
        }
        return aVar.a(new com.baidu.navisdk.behavrules.data.a(list));
    }
}
