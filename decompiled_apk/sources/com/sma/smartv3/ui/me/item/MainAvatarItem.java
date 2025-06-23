package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ImageViewRound;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMainAvatarItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainAvatarItem.kt\ncom/sma/smartv3/ui/me/item/MainAvatarItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,124:1\n19#2:125\n15#2:126\n19#2:127\n15#2:128\n*S KotlinDebug\n*F\n+ 1 MainAvatarItem.kt\ncom/sma/smartv3/ui/me/item/MainAvatarItem\n*L\n50#1:125\n50#1:126\n97#1:127\n97#1:128\n*E\n"})
/* loaded from: classes11.dex */
public class MainAvatarItem extends BaseDslItem {
    private RelativeLayout avatarRl;
    public String avatarUrl;
    private final boolean initEvent = true;
    public ImageViewRound ivAvatar;

    @oOoXoXO
    private View.OnClickListener mOnClick;
    public TextView tvNickname;
    public TextView userID;

    private final void downloadImage(File file) {
        if (getAvatarUrl().length() > 0) {
            NetWorkUtils.INSTANCE.getImage(getAvatarUrl(), file, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.item.MainAvatarItem$downloadImage$1
                @Override // xxxI.II0xO0
                public void handleError(@OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@oOoXoXO String str) {
                    x0xO0oo.II0xO0(x0xO0oo.f24638oo0xXOI0I, null, 2, null);
                }
            });
        }
    }

    public final void avatarShow() {
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setVisibility(0);
            getIvAvatar().setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(oix0oi)));
        } else {
            downloadImage(IXxxXO.xxIXOIIO(oix0oi));
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.iv_avatar);
        IIX0o.ooOOo0oXI(v);
        setIvAvatar((ImageViewRound) v);
        View v2 = itemHolder.v(R.id.edt_nickname);
        IIX0o.ooOOo0oXI(v2);
        setTvNickname((TextView) v2);
        View v3 = itemHolder.v(R.id.userID);
        IIX0o.ooOOo0oXI(v3);
        setUserID((TextView) v3);
        itemHolder.click(R.id.userID, this.mOnClick);
        itemHolder.click(R.id.iv_avatar, this.mOnClick);
    }

    @OOXIXo
    public final String getAvatarUrl() {
        String str = this.avatarUrl;
        if (str != null) {
            return str;
        }
        IIX0o.XOxIOxOx("avatarUrl");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OOXIXo
    public final ImageViewRound getIvAvatar() {
        ImageViewRound imageViewRound = this.ivAvatar;
        if (imageViewRound != null) {
            return imageViewRound;
        }
        IIX0o.XOxIOxOx("ivAvatar");
        return null;
    }

    @oOoXoXO
    public final View.OnClickListener getMOnClick() {
        return this.mOnClick;
    }

    @OOXIXo
    public final TextView getTvNickname() {
        TextView textView = this.tvNickname;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tvNickname");
        return null;
    }

    @OOXIXo
    public final TextView getUserID() {
        TextView textView = this.userID;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx(SDKConstants.PARAM_USER_ID);
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        getTvNickname().setText(appUser2.getNickname());
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("initView " + appUser2.getNickname());
        setAvatarUrl(appUser2.getAvatarUrl());
        getUserID().setText(appUser2.getIdentity());
        TextView userID = getUserID();
        if (appUser2.getIdentity().length() == 0) {
            i = 4;
        } else {
            i = 0;
        }
        userID.setVisibility(i);
        avatarShow();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.me_item_avatar;
    }

    @XO0.XO(tag = x0xO0oo.f24652xI)
    public final void onAvatarChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("AvatarItem onAvatarChange");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (xo0.XO().getBoolean(XoI0Ixx0.f24363IO, true)) {
            SPUtils XO2 = xo0.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            setAvatarUrl(((AppUser) appUser).getAvatarUrl());
            downloadImage(IXxxXO.xxIXOIIO(X00IoxXI.oIX0oI.f3233oIX0oI));
            return;
        }
        getIvAvatar().setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(X00IoxXI.oIX0oI.f3233oIX0oI)));
        x0xO0oo.II0xO0(x0xO0oo.f24638oo0xXOI0I, null, 2, null);
    }

    @XO0.XO(tag = x0xO0oo.f24637oo)
    public final void onNicknameChange(@OOXIXo String nickname) {
        IIX0o.x0xO0oo(nickname, "nickname");
        getTvNickname().setText(nickname);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onNicknameChange " + nickname);
    }

    @XO0.XO(tag = x0xO0oo.f24657xX0IIXIx0)
    public final void onNoLoginChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("AvatarItem NoLogin Change");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24635oX)
    public final void onThemeChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("AvatarItem THEME_CHANGE");
        initView();
    }

    public final void setAvatarUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.avatarUrl = str;
    }

    public final void setIvAvatar(@OOXIXo ImageViewRound imageViewRound) {
        IIX0o.x0xO0oo(imageViewRound, "<set-?>");
        this.ivAvatar = imageViewRound;
    }

    public final void setMOnClick(@oOoXoXO View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
    }

    public final void setTvNickname(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tvNickname = textView;
    }

    public final void setUserID(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.userID = textView;
    }
}
