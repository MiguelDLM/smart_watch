package com.bytedance.android.openliveplugin;

import com.bytedance.sdk.openadsdk.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class LiveApiUtils {
    public static Map<String, Integer> getCJPayAnimationResourceMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("TTCJPayKeyActivityAddInAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_add_in_animation));
        hashMap.put("TTCJPayKeyActivityRemoveOutAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_remove_out_animation));
        hashMap.put("TTCJPayKeyActivityFadeInAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_fade_in_animation));
        hashMap.put("TTCJPayKeyActivityFadeOutAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_fade_out_animation));
        hashMap.put("TTCJPayKeySlideInFromBottomAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_in_from_bottom_with_bezier));
        hashMap.put("TTCJPayKeySlideOutToBottomAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_out_to_bottom_with_bezier));
        hashMap.put("TTCJPayKeySlideRightInAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_right_in));
        hashMap.put("TTCJPayKeyFragmentUpInAnimationResource", Integer.valueOf(R.anim.cj_pay_fragment_up_in_animation));
        hashMap.put("TTCJPayKeyFragmentDownOutAnimationResource", Integer.valueOf(R.anim.cj_pay_fragment_down_out_animation));
        return hashMap;
    }
}
