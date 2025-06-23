package com.sma.smartv3.ui.musicpicker;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.AnimRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import com.sma.smartv3.co_fit.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class MusicPicker {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f23663I0Io = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f23664II0xO0 = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f23665oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f23666oxoX = 1;

    public static ArrayList<MusicResult> II0xO0(Intent data) {
        return data.getParcelableArrayListExtra("extra_result_selection");
    }

    public static ArrayList<MusicResult> oIX0oI(List<oIX0oI> selectedMusics) {
        ArrayList<MusicResult> arrayList = new ArrayList<>();
        Iterator<oIX0oI> it = selectedMusics.iterator();
        while (it.hasNext()) {
            arrayList.add(new MusicResult(it.next()));
        }
        return arrayList;
    }

    /* loaded from: classes11.dex */
    public static class Builder implements Serializable {
        protected transient Activity acc;
        protected Integer animationCloseEnter;
        protected Integer animationCloseExit;
        protected Integer animationOpenEnter;
        protected Integer animationOpenExit;
        protected int bubbleColor;
        protected int bubbleTextColor;
        protected transient Fragment frag;
        protected int handleColor;
        protected boolean hideScrollbar;
        protected Integer searchIconColor;
        protected String titleText;
        protected int trackColor;

        @StyleRes
        protected int theme = R.style.ContactPickerTheme;
        protected boolean showTrack = true;
        protected int selectionMode = 0;
        protected int loadingMode = 0;
        protected ArrayList<Long> selectedItems = new ArrayList<>();
        protected int maxSelectCount = 0;

        public Builder(@NonNull Activity act) {
            this.acc = act;
        }

        public Builder bubbleColor(@ColorInt int bubbleColor) {
            this.bubbleColor = bubbleColor;
            return this;
        }

        public Builder bubbleTextColor(@ColorInt int textColor) {
            this.bubbleTextColor = textColor;
            return this;
        }

        public Builder handleColor(@ColorInt int handleColor) {
            this.handleColor = handleColor;
            return this;
        }

        public Builder hideScrollbar(boolean hideScrollbar) {
            this.hideScrollbar = hideScrollbar;
            return this;
        }

        public Builder searchIconColor(@ColorInt Integer searchIconColor) {
            this.searchIconColor = searchIconColor;
            return this;
        }

        public Builder setActivityAnimations(@AnimRes Integer animationOpenEnter, @AnimRes Integer animationOpenExit, @AnimRes Integer animationCloseEnter, @AnimRes Integer animationCloseExit) {
            this.animationOpenEnter = animationOpenEnter;
            this.animationOpenExit = animationOpenExit;
            this.animationCloseEnter = animationCloseEnter;
            this.animationCloseExit = animationCloseExit;
            return this;
        }

        public Builder setChoiceMode(int selectionMode) {
            this.selectionMode = selectionMode;
            return this;
        }

        public Builder setLoadingType(int loadingMode) {
            this.loadingMode = loadingMode;
            return this;
        }

        public Builder setMaxSelectCount(int maxSelectCount) {
            this.maxSelectCount = maxSelectCount;
            return this;
        }

        public Builder setSelectedMusics(String... selectedContactIDs) {
            this.selectedItems.clear();
            for (String str : selectedContactIDs) {
                this.selectedItems.add(Long.valueOf(Long.parseLong(str)));
            }
            return this;
        }

        public Builder setTitleText(String titleText) {
            this.titleText = titleText;
            return this;
        }

        public void showPickerForResult(int requestCode) {
            if (this.acc != null) {
                Intent intent = new Intent(this.acc, (Class<?>) MusicPickerActivity.class);
                intent.putExtra("builder", this);
                this.acc.startActivityForResult(intent, requestCode);
                Integer num = this.animationOpenEnter;
                if (num != null && this.animationOpenExit != null) {
                    this.acc.overridePendingTransition(num.intValue(), this.animationOpenExit.intValue());
                    return;
                }
                return;
            }
            Fragment fragment = this.frag;
            if (fragment != null) {
                if (fragment.getActivity() != null) {
                    Intent intent2 = new Intent(this.frag.getActivity(), (Class<?>) MusicPickerActivity.class);
                    intent2.putExtra("builder", this);
                    this.frag.startActivityForResult(intent2, requestCode);
                    if (this.animationOpenEnter != null && this.animationOpenExit != null) {
                        this.frag.getActivity().overridePendingTransition(this.animationOpenEnter.intValue(), this.animationOpenExit.intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("Unable to find a context for intent. Is there a valid activity or fragment passed in the builder?");
        }

        public Builder showTrack(boolean showTrack) {
            this.showTrack = showTrack;
            return this;
        }

        public Builder theme(@StyleRes int theme) {
            this.theme = theme;
            return this;
        }

        public Builder trackColor(@ColorInt int trackColor) {
            this.trackColor = trackColor;
            return this;
        }

        public Builder setSelectedMusics(ArrayList<MusicResult> selectedMusics) {
            this.selectedItems.clear();
            Iterator<MusicResult> it = selectedMusics.iterator();
            while (it.hasNext()) {
                this.selectedItems.add(Long.valueOf(it.next().Oxx0IOOO()));
            }
            return this;
        }

        public Builder(@NonNull Fragment frag) {
            this.frag = frag;
        }
    }
}
