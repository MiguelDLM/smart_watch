package me.zheteng.countrycodeselector;

import OoOoXO0.xoXoI;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CountryCodeSelectorFragment extends DialogFragment implements TextWatcher {
    private static final String TAG = "CCSFragment";
    private CountryListAdapter mAdapter;
    private List<Country> mCountryList;
    private oIX0oI mOnCountrySelectListener;
    private RecyclerView mRecyclerView;
    private int mThemeColor;
    private int mType;

    /* loaded from: classes6.dex */
    public class CountryListAdapter extends RecyclerView.Adapter {
        public static final int VIEW_TYPE_ITEM = 2;
        public static final int VIEW_TYPE_SEARCH = 1;
        int mActive;
        List<Country> mFilteredList = new ArrayList();
        List<Country> mList;

        public CountryListAdapter() {
        }

        private int getListSize() {
            List<Country> list = this.mFilteredList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return getListSize() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 1 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof CountryViewHolder) {
                CountryViewHolder countryViewHolder = (CountryViewHolder) viewHolder;
                Country country = this.mFilteredList.get(i - 1);
                countryViewHolder.itemView.setTag(country);
                countryViewHolder.countryName.setText(country.X0o0xo());
                countryViewHolder.countryNameEnglish.setText(country.XO());
                if (country.oIX0oI().length() > 1) {
                    countryViewHolder.countryCode.setText(xoXoI.f2668X0o0xo + country.oIX0oI());
                } else {
                    countryViewHolder.countryCode.setText("");
                }
                if (TextUtils.equals(country.X0o0xo(), country.XO())) {
                    countryViewHolder.countryNameEnglish.setVisibility(8);
                } else {
                    countryViewHolder.countryNameEnglish.setVisibility(0);
                }
                if (i == this.mActive) {
                    countryViewHolder.active.setVisibility(0);
                    countryViewHolder.countryName.setTextColor(CountryCodeSelectorFragment.this.mThemeColor);
                    return;
                } else {
                    countryViewHolder.active.setVisibility(4);
                    countryViewHolder.countryName.setTextColor(ContextCompat.getColor(CountryCodeSelectorFragment.this.getActivity(), android.R.color.black));
                    return;
                }
            }
            if (viewHolder instanceof SearchViewHolder) {
                ((SearchViewHolder) viewHolder).search.requestFocus();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RecyclerView.ViewHolder searchViewHolder;
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                searchViewHolder = new CountryViewHolder(from.inflate(R.layout.ccs_item_country, viewGroup, false));
            } else {
                searchViewHolder = new SearchViewHolder(from.inflate(R.layout.ccs_item_search, viewGroup, false));
            }
            return searchViewHolder;
        }

        public void setFilter(String str) {
            this.mFilteredList.clear();
            for (Country country : this.mList) {
                if (!TextUtils.isEmpty(str) && !country.oIX0oI().toLowerCase().startsWith(str.toLowerCase())) {
                    if (!(xoXoI.f2668X0o0xo + country.oIX0oI().toLowerCase()).startsWith(str.toLowerCase()) && !country.X0o0xo().toLowerCase().contains(str.toLowerCase()) && !TextUtils.isEmpty(country.XO()) && !country.XO().toLowerCase().contains(str.toLowerCase())) {
                    }
                }
                this.mFilteredList.add(country);
            }
            notifyDataSetChanged();
        }

        public void setList(List<Country> list) {
            this.mList = list;
            if (list != null) {
                this.mFilteredList.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView active;
        TextView countryCode;
        TextView countryName;
        TextView countryNameEnglish;

        public CountryViewHolder(View view) {
            super(view);
            this.countryName = (TextView) view.findViewById(R.id.country_name);
            this.countryNameEnglish = (TextView) view.findViewById(R.id.country_name_english);
            this.countryCode = (TextView) view.findViewById(R.id.county_code);
            this.active = (ImageView) view.findViewById(R.id.active);
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Country country = (Country) this.itemView.getTag();
            Intent intent = new Intent(PhoneInputView.f30984OxI);
            intent.putExtra(PhoneInputView.f30983O0xOxO, country);
            LocalBroadcastManager.getInstance(CountryCodeSelectorFragment.this.getActivity()).sendBroadcast(intent);
            if (CountryCodeSelectorFragment.this.mOnCountrySelectListener != null) {
                CountryCodeSelectorFragment.this.mOnCountrySelectListener.oIX0oI(country);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class SearchViewHolder extends RecyclerView.ViewHolder {
        EditText search;

        /* loaded from: classes6.dex */
        public class oIX0oI implements TextView.OnEditorActionListener {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ CountryCodeSelectorFragment f30980XO;

            public oIX0oI(CountryCodeSelectorFragment countryCodeSelectorFragment) {
                this.f30980XO = countryCodeSelectorFragment;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == 6;
            }
        }

        public SearchViewHolder(View view) {
            super(view);
            EditText editText = (EditText) view.findViewById(R.id.search);
            this.search = editText;
            editText.getBackground().setColorFilter(CountryCodeSelectorFragment.this.mThemeColor, PorterDuff.Mode.SRC_ATOP);
            this.search.addTextChangedListener(CountryCodeSelectorFragment.this);
            this.search.setOnEditorActionListener(new oIX0oI(CountryCodeSelectorFragment.this));
        }
    }

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void oIX0oI(Country country);
    }

    public static CountryCodeSelectorFragment newInstance(Intent intent) {
        Bundle extras = intent.getExtras();
        CountryCodeSelectorFragment countryCodeSelectorFragment = new CountryCodeSelectorFragment();
        countryCodeSelectorFragment.setArguments(extras);
        return countryCodeSelectorFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public oIX0oI getOnCountrySelectListener() {
        return this.mOnCountrySelectListener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.mThemeColor = arguments.getInt(PhoneInputView.f30985X0IIOO, ContextCompat.getColor(getActivity(), R.color.ccs_default_color));
        this.mType = arguments.getInt(PhoneInputView.f30986XI0IXoo);
        this.mCountryList = II0xO0.oIX0oI(getActivity()).oxoX(getContext());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ccs_fragment_country_code_selector, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CountryListAdapter countryListAdapter = new CountryListAdapter();
        this.mAdapter = countryListAdapter;
        this.mRecyclerView.setAdapter(countryListAdapter);
        this.mAdapter.setList(this.mCountryList);
        if (this.mType == 1) {
            getDialog().setTitle(R.string.ccs_choose_a_country);
            getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.ccs_dialog_width), getResources().getDimensionPixelSize(R.dimen.ccs_dialog_height));
        }
        return inflate;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mAdapter.setFilter(charSequence.toString());
    }

    public void setOnCountrySelectListener(oIX0oI oix0oi) {
        this.mOnCountrySelectListener = oix0oi;
    }
}
