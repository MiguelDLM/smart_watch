package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.ai.AIAnswerActivity;
import com.sma.smartv3.ui.ai.AIChatActivity;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAIFunctionData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIFunctionData.kt\ncom/sma/smartv3/model/AIFunctionDataKt\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n87#2,7:266\n94#2,3:274\n70#2,7:277\n97#2:284\n1#3:273\n766#4:285\n857#4,2:286\n766#4:288\n857#4,2:289\n*S KotlinDebug\n*F\n+ 1 AIFunctionData.kt\ncom/sma/smartv3/model/AIFunctionDataKt\n*L\n21#1:266,7\n21#1:274,3\n21#1:277,7\n21#1:284\n21#1:273\n26#1:285\n26#1:286,2\n30#1:288\n30#1:289,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AIFunctionDataKt {
    @OOXIXo
    public static final List<AIFunction> getAIFunction() {
        String oI0IIXIo2;
        AIFunctionType aIFunctionType = AIFunctionType.AI;
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if (UtilsKt.X00IoxXI(app)) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.wenxinyiyan);
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.chatgpt);
        }
        return CollectionsKt__CollectionsKt.Oxx0xo(new AIFunction(aIFunctionType, oI0IIXIo2, R.drawable.ai_function_ai_bg, UtilsKt.oI0IIXIo(R.string.ai_desc), R.drawable.icon_ai_function_ai, 0, null, null, null, null, true, new Intent(Utils.getApp(), (Class<?>) AIChatActivity.class), 992, null), new AIFunction(AIFunctionType.HEALTH_QA, UtilsKt.oI0IIXIo(R.string.health_qa), R.drawable.ai_function_health_qa_bg, UtilsKt.oI0IIXIo(R.string.health_qa_desc), R.drawable.icon_ai_function_health_qa, 0, null, null, null, null, true, new Intent(Utils.getApp(), (Class<?>) AIChatActivity.class), 992, null), new AIFunction(AIFunctionType.PERSONAL_TRAINER, UtilsKt.oI0IIXIo(R.string.personal_trainer), R.drawable.ai_function_personal_trainer_bg, UtilsKt.oI0IIXIo(R.string.personal_trainer_desc), R.drawable.icon_ai_function_personal_trainer, 0, null, null, null, null, true, new Intent(Utils.getApp(), (Class<?>) AIChatActivity.class), 992, null), new AIFunction(AIFunctionType.TRAVEL_GUIDES, UtilsKt.oI0IIXIo(R.string.travel_guides), R.drawable.ai_function_travel_guides_bg, UtilsKt.oI0IIXIo(R.string.travel_guides_desc), R.drawable.icon_ai_function_travel_guides, R.drawable.ai_answer_bg_2, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.travel_guides_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.travel_guides_details_example), UtilsKt.oI0IIXIo(R.string.using_travel_guides), true, null, 2048, null), new AIFunction(AIFunctionType.EAT_HEALTHY, UtilsKt.oI0IIXIo(R.string.eat_healthy), R.drawable.ai_function_eat_healthy_bg, UtilsKt.oI0IIXIo(R.string.eat_healthy_desc), R.drawable.icon_ai_function_eat_healthy, R.drawable.ai_answer_bg_1, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.eat_healthy_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.eat_healthy_details_example), UtilsKt.oI0IIXIo(R.string.eat_healthy), true, null, 2048, null), new AIFunction(AIFunctionType.DEAL_REVIEWS, UtilsKt.oI0IIXIo(R.string.deal_reviews), R.drawable.ai_function_deal_reviews_bg, UtilsKt.oI0IIXIo(R.string.deal_reviews_desc), R.drawable.icon_ai_function_deal_reviews, R.drawable.ai_answer_bg_3, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.deal_reviews_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.deal_reviews_details_example), UtilsKt.oI0IIXIo(R.string.deal_reviews), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.HIGH_EQ_RESPONSE, UtilsKt.oI0IIXIo(R.string.high_eq_response), R.drawable.ai_function_high_eq_response_bg, UtilsKt.oI0IIXIo(R.string.high_eq_response_desc), R.drawable.icon_ai_function_high_eq_response, R.drawable.ai_answer_bg_2, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.high_eq_response_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.high_eq_response_details_example), UtilsKt.oI0IIXIo(R.string.high_eq_response), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.SURNAME, UtilsKt.oI0IIXIo(R.string.surname), R.drawable.ai_function_surname_bg, UtilsKt.oI0IIXIo(R.string.surname_desc), R.drawable.icon_ai_function_surname, R.drawable.ai_answer_bg_4, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.surname_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.surname_details_example), UtilsKt.oI0IIXIo(R.string.surname), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.PSYCHOLOGICAL_COUNSELOR, UtilsKt.oI0IIXIo(R.string.psychological_counselor), R.drawable.ai_function_psychological_counselor_bg, UtilsKt.oI0IIXIo(R.string.psychological_counselor_desc), R.drawable.icon_ai_function_psychological_counselor, R.drawable.ai_answer_bg_1, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.psychological_counselor_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.psychological_counselor_details_example), UtilsKt.oI0IIXIo(R.string.using_psychological_provide), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.COMPLIMENT_MASTERS, UtilsKt.oI0IIXIo(R.string.compliment_masters), R.drawable.ai_function_compliment_masters_bg, UtilsKt.oI0IIXIo(R.string.compliment_masters_desc), R.drawable.icon_ai_function_compliment_masters, R.drawable.ai_answer_bg_3, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.compliment_masters_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.compliment_masters_details_example), UtilsKt.oI0IIXIo(R.string.using_compliment_masters), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.APOLOGIZE, UtilsKt.oI0IIXIo(R.string.apologize), R.drawable.ai_function_apologize_bg, UtilsKt.oI0IIXIo(R.string.apologize_desc), R.drawable.icon_ai_function_apologize, R.drawable.ai_answer_bg_3, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.apologize_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.apologize_details_example), UtilsKt.oI0IIXIo(R.string.apologize), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.DREAM_INTERPRETATION, UtilsKt.oI0IIXIo(R.string.dream_interpretation), R.drawable.ai_function_dream_interpretation_bg, UtilsKt.oI0IIXIo(R.string.dream_interpretation_desc), R.drawable.icon_ai_function_dream_interpretation, R.drawable.ai_answer_bg_2, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.dream_interpretation_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.dream_interpretation_details_example), UtilsKt.oI0IIXIo(R.string.using_dream_interpretation), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.EVENT_PLANNING, UtilsKt.oI0IIXIo(R.string.event_planning), R.drawable.ai_function_event_planning_bg, UtilsKt.oI0IIXIo(R.string.event_planning_desc), R.drawable.icon_ai_function_event_planning, R.drawable.ai_answer_bg_5, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.event_planning_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.event_planning_details_example), UtilsKt.oI0IIXIo(R.string.using_event_planning), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.SHORT_VIDEO_SCRIPTS, UtilsKt.oI0IIXIo(R.string.short_video_scripts), R.drawable.ai_function_short_video_scripts_bg, UtilsKt.oI0IIXIo(R.string.short_video_scripts_desc), R.drawable.icon_ai_function_short_video_scripts, R.drawable.ai_answer_bg_3, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.short_video_scripts_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.short_video_scripts_details_example), UtilsKt.oI0IIXIo(R.string.short_video_scripts), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.E_MARKET_COPY, UtilsKt.oI0IIXIo(R.string.e_market_copy), R.drawable.ai_function_e_market_copy_bg, UtilsKt.oI0IIXIo(R.string.e_market_copy_desc), R.drawable.icon_ai_function_e_market_copy, R.drawable.ai_answer_bg_5, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.e_market_copy_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.e_market_copy_details_example), UtilsKt.oI0IIXIo(R.string.e_market_copy), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.DAILY_WEEKLY, UtilsKt.oI0IIXIo(R.string.daily_weekly), R.drawable.ai_function_daily_weekly_bg, UtilsKt.oI0IIXIo(R.string.daily_weekly_desc), R.drawable.icon_ai_function_daily_weekly, R.drawable.ai_answer_bg_4, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.daily_weekly_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.daily_weekly_details_example), UtilsKt.oI0IIXIo(R.string.using_daily_weekly), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.MARKET_ANALYSIS, UtilsKt.oI0IIXIo(R.string.market_analysis), R.drawable.ai_function_market_analysis_bg, UtilsKt.oI0IIXIo(R.string.market_analysis_desc), R.drawable.icon_ai_function_market_analysis, R.drawable.ai_answer_bg_1, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.market_analysis_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.market_analysis_details_example), UtilsKt.oI0IIXIo(R.string.using_market_analysis), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.MOMENTS_COPYWRITING, UtilsKt.oI0IIXIo(R.string.moments_copywriting), R.drawable.ai_function_moments_copywriting_bg, UtilsKt.oI0IIXIo(R.string.moments_copywriting_desc), R.drawable.icon_ai_function_moments_copywriting, R.drawable.ai_answer_bg_1, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.moments_copywriting_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.moments_copywriting_details_example), UtilsKt.oI0IIXIo(R.string.using_moments_copywriting), false, null, FileBrowseManager.y, null), new AIFunction(AIFunctionType.LITTLE_RED_BOOK_STYLE, UtilsKt.oI0IIXIo(R.string.little_red_book_style), R.drawable.ai_function_little_red_book_style_bg, UtilsKt.oI0IIXIo(R.string.little_red_book_style_desc), R.drawable.icon_ai_function_little_red_book_style, R.drawable.ai_answer_bg_5, UtilsKt.oI0IIXIo(R.string.content_describe), UtilsKt.oI0IIXIo(R.string.little_red_book_style_details_hint), UtilsKt.oI0IIXIo(R.string.ai_example_key) + ": " + UtilsKt.oI0IIXIo(R.string.little_red_book_style_details_example), UtilsKt.oI0IIXIo(R.string.little_red_book_style), false, null, FileBrowseManager.y, null));
    }

    @OOXIXo
    public static final List<AIFunction> getAIFunctionByCat(@OOXIXo AIFunctionCat cat) {
        IIX0o.x0xO0oo(cat, "cat");
        List<AIFunction> aIFunction = getAIFunction();
        ArrayList arrayList = new ArrayList();
        for (Object obj : aIFunction) {
            AIFunction aIFunction2 = (AIFunction) obj;
            if (!aIFunction2.isHot() && (aIFunction2.getType().getType() >>> 8) == cat.getCat()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @OOXIXo
    public static final List<AIFunction> getHotAIFunction() {
        List<AIFunction> aIFunction = getAIFunction();
        ArrayList arrayList = new ArrayList();
        for (Object obj : aIFunction) {
            if (((AIFunction) obj).isHot()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final void toAIFunction(@OOXIXo Activity context, @OOXIXo AIFunction aiFunction) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(aiFunction, "aiFunction");
        if (aiFunction.getIntent() != null) {
            Intent intent = aiFunction.getIntent();
            IIX0o.ooOOo0oXI(intent);
            intent.putExtra("mArg3", aiFunction);
            context.startActivity(aiFunction.getIntent());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", aiFunction);
        Intent intent2 = new Intent(context, (Class<?>) AIAnswerActivity.class);
        intent2.putExtras(bundle);
        context.startActivity(intent2);
    }
}
