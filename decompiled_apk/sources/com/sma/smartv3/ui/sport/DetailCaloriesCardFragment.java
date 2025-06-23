package com.sma.smartv3.ui.sport;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.view.ImageViewRound;
import java.io.Serializable;
import java.util.Date;

@kotlin.jvm.internal.XX({"SMAP\nDetailCaloriesCardFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetailCaloriesCardFragment.kt\ncom/sma/smartv3/ui/sport/DetailCaloriesCardFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,102:1\n19#2:103\n15#2:104\n*S KotlinDebug\n*F\n+ 1 DetailCaloriesCardFragment.kt\ncom/sma/smartv3/ui/sport/DetailCaloriesCardFragment\n*L\n45#1:103\n45#1:104\n*E\n"})
/* loaded from: classes12.dex */
public class DetailCaloriesCardFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnShare$delegate;
    private final float mBitmapRadius;
    public Workout mWorkout;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shareCardView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$shareCardView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (CardView) mView.findViewById(R.id.base_share_cardView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (ImageViewRound) mView.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.edt_nickname);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDateTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$tvDateTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_dateTime);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCaloriesValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$tvCaloriesValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_calories_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDetailname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$tvDetailname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailCaloriesCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_detail_name);
        }
    });

    public DetailCaloriesCardFragment() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.btnShare$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.DetailCaloriesCardFragment$btnShare$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Button invoke() {
                View mView;
                mView = DetailCaloriesCardFragment.this.getMView();
                return (Button) mView.findViewById(R.id.btn_share);
            }
        });
        this.mBitmapRadius = 30.0f;
    }

    private final void avatarShow() {
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    private final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final TextView getTvCaloriesValue() {
        return (TextView) this.tvCaloriesValue$delegate.getValue();
    }

    private final TextView getTvDateTime() {
        return (TextView) this.tvDateTime$delegate.getValue();
    }

    private final TextView getTvDetailname() {
        return (TextView) this.tvDetailname$delegate.getValue();
    }

    private final TextView getTvNickname() {
        return (TextView) this.tvNickname$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DetailCaloriesCardFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.shareImage();
    }

    public final Button getBtnShare() {
        return (Button) this.btnShare$delegate.getValue();
    }

    public final float getMBitmapRadius() {
        return this.mBitmapRadius;
    }

    @OXOo.OOXIXo
    public final Workout getMWorkout() {
        Workout workout = this.mWorkout;
        if (workout != null) {
            return workout;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
        return null;
    }

    public final CardView getShareCardView() {
        return (CardView) this.shareCardView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AppUser getUserProfile() {
        return this.userProfile;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Workout");
        setMWorkout((Workout) mArg3);
        getTvDetailname().setText(ProductManager.f20544oIX0oI.xIXX(getMWorkout().getMMode()));
        getTvDateTime().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(getMWorkout().getMStart())));
        getTvNickname().setText(this.userProfile.getNickname());
        getTvCaloriesValue().setText(String.valueOf(getMWorkout().getMCalorie() / 1000));
        avatarShow();
        getBtnShare().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.oO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailCaloriesCardFragment.initView$lambda$0(DetailCaloriesCardFragment.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_share_card_calories;
    }

    public final void setMWorkout(@OXOo.OOXIXo Workout workout) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(workout, "<set-?>");
        this.mWorkout = workout;
    }

    public final void shareImage() {
        Bitmap createBitmap = Bitmap.createBitmap(getShareCardView().getWidth(), getShareCardView().getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        CardView shareCardView = getShareCardView();
        kotlin.jvm.internal.IIX0o.oO(shareCardView, "<get-shareCardView>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(shareCardView), 0.0f, 0.0f, (Paint) null);
        Bitmap roundCorner = ImageUtils.toRoundCorner(createBitmap, this.mBitmapRadius);
        kotlin.jvm.internal.IIX0o.oO(roundCorner, "toRoundCorner(...)");
        ImageUtils.save(roundCorner, com.sma.smartv3.initializer.IXxxXO.xo0x(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.PNG);
        requireActivity().setResult(-1);
        requireActivity().finish();
    }
}
