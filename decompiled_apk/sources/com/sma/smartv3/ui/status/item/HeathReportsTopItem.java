package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.HealthyReport;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHeathReportsTopItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeathReportsTopItem.kt\ncom/sma/smartv3/ui/status/item/HeathReportsTopItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,105:1\n19#2:106\n15#2:107\n*S KotlinDebug\n*F\n+ 1 HeathReportsTopItem.kt\ncom/sma/smartv3/ui/status/item/HeathReportsTopItem\n*L\n33#1:106\n33#1:107\n*E\n"})
/* loaded from: classes12.dex */
public final class HeathReportsTopItem extends BaseDslItem {

    @OXOo.oOoXoXO
    private ImageView ivAvatar;

    @OXOo.OOXIXo
    private final AppUser mAppUser;
    private Context mContext;

    @OXOo.oOoXoXO
    private final HealthyReport mHealthyReport;
    private final boolean showUser;
    private final long time;

    @OXOo.oOoXoXO
    private TextView tv_abnormal;

    @OXOo.oOoXoXO
    private TextView tv_height_weight;

    @OXOo.oOoXoXO
    private TextView tv_name;

    @OXOo.oOoXoXO
    private TextView tv_report_times;

    @OXOo.oOoXoXO
    private TextView tv_this_content;

    public HeathReportsTopItem(long j, boolean z, @OXOo.oOoXoXO HealthyReport healthyReport) {
        this.time = j;
        this.showUser = z;
        this.mHealthyReport = healthyReport;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        Context context = itemHolder.getContext();
        IIX0o.oO(context, "<get-context>(...)");
        this.mContext = context;
        View view = itemHolder.view(R.id.iv_avatar);
        IIX0o.x0XOIxOo(view, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivAvatar = (ImageView) view;
        View view2 = itemHolder.view(R.id.tv_name);
        IIX0o.x0XOIxOo(view2, "null cannot be cast to non-null type android.widget.TextView");
        this.tv_name = (TextView) view2;
        View view3 = itemHolder.view(R.id.tv_height_weight);
        IIX0o.x0XOIxOo(view3, "null cannot be cast to non-null type android.widget.TextView");
        this.tv_height_weight = (TextView) view3;
        View view4 = itemHolder.view(R.id.tv_abnormal);
        IIX0o.x0XOIxOo(view4, "null cannot be cast to non-null type android.widget.TextView");
        this.tv_abnormal = (TextView) view4;
        View view5 = itemHolder.view(R.id.tv_report_times);
        IIX0o.x0XOIxOo(view5, "null cannot be cast to non-null type android.widget.TextView");
        this.tv_report_times = (TextView) view5;
        View view6 = itemHolder.view(R.id.tv_this_content);
        IIX0o.x0XOIxOo(view6, "null cannot be cast to non-null type android.widget.TextView");
        this.tv_this_content = (TextView) view6;
    }

    @OXOo.oOoXoXO
    public final ImageView getIvAvatar() {
        return this.ivAvatar;
    }

    @OXOo.OOXIXo
    public final AppUser getMAppUser() {
        return this.mAppUser;
    }

    @OXOo.oOoXoXO
    public final HealthyReport getMHealthyReport() {
        return this.mHealthyReport;
    }

    public final boolean getShowUser() {
        return this.showUser;
    }

    public final long getTime() {
        return this.time;
    }

    @OXOo.oOoXoXO
    public final TextView getTv_abnormal() {
        return this.tv_abnormal;
    }

    @OXOo.oOoXoXO
    public final TextView getTv_height_weight() {
        return this.tv_height_weight;
    }

    @OXOo.oOoXoXO
    public final TextView getTv_name() {
        return this.tv_name;
    }

    @OXOo.oOoXoXO
    public final TextView getTv_report_times() {
        return this.tv_report_times;
    }

    @OXOo.oOoXoXO
    public final TextView getTv_this_content() {
        return this.tv_this_content;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        Context context;
        Integer num;
        String string;
        String string2;
        String string3;
        String str = null;
        int i2 = 0;
        if (this.showUser) {
            ImageView imageView = this.ivAvatar;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = this.tv_name;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.tv_height_weight;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.tv_abnormal;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.tv_report_times;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            HealthyReport healthyReport = this.mHealthyReport;
            if (healthyReport != null) {
                if (healthyReport != null && healthyReport.getMUserGender() == 0) {
                    string = Utils.getApp().getString(R.string.female);
                } else {
                    string = Utils.getApp().getString(R.string.male);
                }
                IIX0o.ooOOo0oXI(string);
                if (this.mAppUser.getUnit() == 0) {
                    Context context2 = this.mContext;
                    if (context2 == null) {
                        IIX0o.XOxIOxOx("mContext");
                        context2 = null;
                    }
                    Resources resources = context2.getResources();
                    HealthyReport healthyReport2 = this.mHealthyReport;
                    IIX0o.ooOOo0oXI(healthyReport2);
                    string2 = resources.getString(R.string.f_cm, Float.valueOf(healthyReport2.getMUserHeight()));
                } else {
                    HealthyReport healthyReport3 = this.mHealthyReport;
                    IIX0o.ooOOo0oXI(healthyReport3);
                    int[] oIX0oI2 = Xx000oIo.XO.oIX0oI(healthyReport3.getMUserHeight());
                    Context context3 = this.mContext;
                    if (context3 == null) {
                        IIX0o.XOxIOxOx("mContext");
                        context3 = null;
                    }
                    string2 = context3.getResources().getString(R.string.d_feet_d_inch, Integer.valueOf(oIX0oI2[0]), Integer.valueOf(oIX0oI2[1]));
                }
                IIX0o.ooOOo0oXI(string2);
                if (this.mAppUser.getUnit() == 0) {
                    Context context4 = this.mContext;
                    if (context4 == null) {
                        IIX0o.XOxIOxOx("mContext");
                        context4 = null;
                    }
                    Resources resources2 = context4.getResources();
                    HealthyReport healthyReport4 = this.mHealthyReport;
                    IIX0o.ooOOo0oXI(healthyReport4);
                    string3 = resources2.getString(R.string.f_kg, Float.valueOf(healthyReport4.getMUserWeight()));
                } else {
                    Context context5 = this.mContext;
                    if (context5 == null) {
                        IIX0o.XOxIOxOx("mContext");
                        context5 = null;
                    }
                    Resources resources3 = context5.getResources();
                    HealthyReport healthyReport5 = this.mHealthyReport;
                    IIX0o.ooOOo0oXI(healthyReport5);
                    string3 = resources3.getString(R.string.f_lbs, Float.valueOf(Float.parseFloat(TextConvertKt.oo0xXOI0I(Xx000oIo.XO.I0Io(healthyReport5.getMUserWeight()), true))));
                }
                IIX0o.ooOOo0oXI(string3);
                TextView textView5 = this.tv_height_weight;
                if (textView5 != null) {
                    textView5.setText(string + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.height) + TokenParser.SP + string2 + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.weight) + TokenParser.SP + string3);
                }
            }
            if (this.ivAvatar != null) {
                Context context6 = this.mContext;
                if (context6 == null) {
                    IIX0o.XOxIOxOx("mContext");
                    context6 = null;
                }
                RequestBuilder error = Glide.with(context6).load(this.mAppUser.getAvatarUrl()).error(R.drawable.pic_avatar_default);
                ImageView imageView2 = this.ivAvatar;
                IIX0o.ooOOo0oXI(imageView2);
                error.into(imageView2);
            }
            TextView textView6 = this.tv_name;
            if (textView6 != null) {
                textView6.setText(this.mAppUser.getNickname());
            }
        } else {
            TextView textView7 = this.tv_report_times;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.tv_this_content;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
        }
        HealthyReport healthyReport6 = this.mHealthyReport;
        if (healthyReport6 != null) {
            i = healthyReport6.getMAbnormalNumber();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView9 = this.tv_abnormal;
            if (textView9 != null) {
                Context context7 = this.mContext;
                if (context7 == null) {
                    IIX0o.XOxIOxOx("mContext");
                    context7 = null;
                }
                Resources resources4 = context7.getResources();
                HealthyReport healthyReport7 = this.mHealthyReport;
                if (healthyReport7 != null) {
                    num = Integer.valueOf(healthyReport7.getMAbnormalNumber());
                } else {
                    num = null;
                }
                textView9.setText(resources4.getString(R.string.abnormal_hint, num));
            }
            TextView textView10 = this.tv_abnormal;
            if (textView10 != null) {
                Context context8 = this.mContext;
                if (context8 == null) {
                    IIX0o.XOxIOxOx("mContext");
                    context8 = null;
                }
                textView10.setTextColor(context8.getResources().getColorStateList(R.color.v2_step_progress_color));
            }
        } else {
            TextView textView11 = this.tv_abnormal;
            if (textView11 != null) {
                Context context9 = this.mContext;
                if (context9 == null) {
                    IIX0o.XOxIOxOx("mContext");
                    context9 = null;
                }
                textView11.setText(context9.getResources().getString(R.string.normal_indicators));
            }
            TextView textView12 = this.tv_abnormal;
            if (textView12 != null) {
                Context context10 = this.mContext;
                if (context10 == null) {
                    IIX0o.XOxIOxOx("mContext");
                    context10 = null;
                }
                textView12.setTextColor(context10.getResources().getColorStateList(R.color.green));
            }
        }
        TextView textView13 = this.tv_report_times;
        if (textView13 != null) {
            if (this.time > 0) {
                if (textView13 != null) {
                    if (textView13 != null && (context = textView13.getContext()) != null) {
                        str = context.getString(R.string.report_times, com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(Long.valueOf(this.time)));
                    }
                    textView13.setText(str);
                }
            } else {
                i2 = 8;
            }
            textView13.setVisibility(i2);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.heath_reports_top_item;
    }

    public final void setIvAvatar(@OXOo.oOoXoXO ImageView imageView) {
        this.ivAvatar = imageView;
    }

    public final void setTv_abnormal(@OXOo.oOoXoXO TextView textView) {
        this.tv_abnormal = textView;
    }

    public final void setTv_height_weight(@OXOo.oOoXoXO TextView textView) {
        this.tv_height_weight = textView;
    }

    public final void setTv_name(@OXOo.oOoXoXO TextView textView) {
        this.tv_name = textView;
    }

    public final void setTv_report_times(@OXOo.oOoXoXO TextView textView) {
        this.tv_report_times = textView;
    }

    public final void setTv_this_content(@OXOo.oOoXoXO TextView textView) {
        this.tv_this_content = textView;
    }

    public /* synthetic */ HeathReportsTopItem(long j, boolean z, HealthyReport healthyReport, int i, IIXOooo iIXOooo) {
        this(j, (i & 2) != 0 ? false : z, healthyReport);
    }
}
