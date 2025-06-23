package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X00IoxXI.oIX0oI;
import XO0.XO;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.angcyo.dsladapter.DslViewHolder;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.ai.SearchFuncActivity;
import com.sma.smartv3.ui.ai.item.AITopItem;
import com.sma.smartv3.ui.me.UserInfoActivity;
import com.sma.smartv3.ui.status.item.MainStepItem;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ImageViewRound;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import oIxOXo.oxoX;

@XX({"SMAP\nAITopItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AITopItem.kt\ncom/sma/smartv3/ui/ai/item/AITopItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,114:1\n19#2:115\n15#2:116\n*S KotlinDebug\n*F\n+ 1 AITopItem.kt\ncom/sma/smartv3/ui/ai/item/AITopItem\n*L\n65#1:115\n65#1:116\n*E\n"})
/* loaded from: classes12.dex */
public class AITopItem extends MainStepItem {
    private ImageViewRound ivAvatar;

    @oOoXoXO
    private CardView mCardView;
    private TextView tvNickname;

    private final void avatarShow() {
        ImageViewRound imageViewRound = this.ivAvatar;
        ImageViewRound imageViewRound2 = null;
        if (imageViewRound == null) {
            IIX0o.XOxIOxOx("ivAvatar");
            imageViewRound = null;
        }
        ImageViewRound imageViewRound3 = this.ivAvatar;
        if (imageViewRound3 == null) {
            IIX0o.XOxIOxOx("ivAvatar");
            imageViewRound3 = null;
        }
        imageViewRound.setImageDrawable(oxoX.Oxx0IOOO(imageViewRound3.getContext(), R.drawable.pic_avatar_default));
        oIX0oI oix0oi = oIX0oI.f3233oIX0oI;
        if (IXxxXO.xxIXOIIO(oix0oi).exists()) {
            ImageViewRound imageViewRound4 = this.ivAvatar;
            if (imageViewRound4 == null) {
                IIX0o.XOxIOxOx("ivAvatar");
            } else {
                imageViewRound2 = imageViewRound4;
            }
            imageViewRound2.setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(AITopItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) UserInfoActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(AITopItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SearchFuncActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAvatarChange$lambda$3(AITopItem this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("AvatarItem onAvatarChange");
        this$0.avatarShow();
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.bindView(itemHolder);
        View v = itemHolder.v(R.id.tv_nickname);
        IIX0o.ooOOo0oXI(v);
        this.tvNickname = (TextView) v;
        View v2 = itemHolder.v(R.id.iv_avatar);
        IIX0o.ooOOo0oXI(v2);
        this.ivAvatar = (ImageViewRound) v2;
        itemHolder.click(R.id.iv_avatar, new View.OnClickListener() { // from class: o0oxo0oI.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AITopItem.bindView$lambda$0(AITopItem.this, view);
            }
        });
        this.mCardView = (CardView) itemHolder.v(R.id.search_item);
        itemHolder.click(R.id.search_item, new View.OnClickListener() { // from class: o0oxo0oI.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AITopItem.bindView$lambda$1(AITopItem.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        super.initView();
        avatarShow();
        TextView textView = this.tvNickname;
        if (textView == null) {
            IIX0o.XOxIOxOx("tvNickname");
            textView = null;
        }
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        textView.setText(((AppUser) appUser).getNickname());
        CardView cardView = this.mCardView;
        if (cardView != null) {
            cardView.setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(getMContext(), R.color.ai_search_layout_bg)));
        }
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.ai_item_top;
    }

    @XO(tag = x0xO0oo.f24652xI)
    public final void onAvatarChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: o0oxo0oI.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                AITopItem.onAvatarChange$lambda$3(AITopItem.this);
            }
        }, 1000L);
    }

    @XO(tag = x0xO0oo.f24637oo)
    public final void onNickNameChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onNickNameChange");
        initView();
    }

    @XO(tag = x0xO0oo.f24635oX)
    public final void onThemeChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onThemeChange");
        initView();
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem
    public void updateWeather() {
        super.updateWeather();
        getTvWeatherTime().setVisibility(8);
        if (getTvTemperature().getVisibility() == 4) {
            getTvTemperature().setVisibility(0);
            getTvTemperature().setText(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        }
    }
}
