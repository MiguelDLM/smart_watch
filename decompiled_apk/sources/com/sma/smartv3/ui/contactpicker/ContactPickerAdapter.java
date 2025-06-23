package com.sma.smartv3.ui.contactpicker;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.l4digital.fastscroll.FastScroller;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.contactpicker.ContactPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ContactPickerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FastScroller.xxIXOIIO, Filterable {
    private ContactPicker.Builder builder;
    private List<Contact> contactItemList;
    private List<Contact> contactItemListOriginal;
    private String currentFilterQuery;
    private ContactSelectListener listener;

    /* loaded from: classes12.dex */
    public interface ContactSelectListener {
        void onContactSelected(Contact contact, int totalSelectedContacts);
    }

    /* loaded from: classes12.dex */
    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private AppCompatCheckBox cbSelectedState;
        private final View mView;
        private TextView tvContactName;
        private TextView tvNumber;
        private RoundLetterView vRoundLetterView;

        public ContactViewHolder(View view) {
            super(view);
            this.mView = view;
            this.vRoundLetterView = (RoundLetterView) view.findViewById(R.id.vRoundLetterView);
            this.tvContactName = (TextView) view.findViewById(R.id.tvContactName);
            this.tvNumber = (TextView) view.findViewById(R.id.tvNumber);
            this.cbSelectedState = (AppCompatCheckBox) view.findViewById(R.id.cbSelectedState);
        }
    }

    public ContactPickerAdapter(ContactPicker.Builder builder, List<Contact> contactItemList, ContactSelectListener listener) {
        this.builder = builder;
        this.contactItemList = contactItemList;
        this.contactItemListOriginal = contactItemList;
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Contact> getFilteredResults(String constraint) {
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.contactItemListOriginal) {
            if (contact.getDisplayName().toLowerCase().contains(constraint)) {
                arrayList.add(contact);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Contact getItem(int pos) {
        return this.contactItemList.get(pos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemPosition(List<Contact> list, long mid) {
        Iterator<Contact> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getId() == mid) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void highlightTerm(TextView tv, String query, String originalString) {
        if (query != null && !query.isEmpty()) {
            int indexOf = originalString.toLowerCase().indexOf(query.toLowerCase());
            int length = query.length() + indexOf;
            if (indexOf != -1) {
                SpannableString spannableString = new SpannableString(originalString);
                spannableString.setSpan(new TextAppearanceSpan(null, 1, -1, new ColorStateList(new int[][]{new int[0]}, new int[]{ViewCompat.MEASURED_STATE_MASK}), null), indexOf, length, 33);
                tv.setText(spannableString);
                return;
            }
            tv.setText(originalString);
            return;
        }
        tv.setText(originalString);
    }

    public void filterOnText(String query) {
        this.currentFilterQuery = query;
        getFilter().filter(this.currentFilterQuery);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: com.sma.smartv3.ui.contactpicker.ContactPickerAdapter.2
            @Override // android.widget.Filter
            public Filter.FilterResults performFiltering(CharSequence constraint) {
                List filteredResults;
                if (constraint.length() == 0) {
                    filteredResults = ContactPickerAdapter.this.contactItemListOriginal;
                    ContactPickerAdapter.this.currentFilterQuery = null;
                } else {
                    filteredResults = ContactPickerAdapter.this.getFilteredResults(constraint.toString().toLowerCase());
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = filteredResults;
                return filterResults;
            }

            @Override // android.widget.Filter
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                ContactPickerAdapter.this.contactItemList = (List) results.values;
                ContactPickerAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Contact> list = this.contactItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<Contact> getSelectedContacts() {
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.contactItemListOriginal) {
            if (contact.isSelected()) {
                arrayList.add(contact);
            }
        }
        return arrayList;
    }

    public int getSelectedContactsCount() {
        if (getSelectedContacts() != null) {
            return getSelectedContacts().size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        if (holder instanceof ContactViewHolder) {
            ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
            final Contact item = getItem(i);
            String displayName = item.getDisplayName();
            contactViewHolder.tvContactName.setText(displayName);
            if (TextUtils.isEmpty(displayName)) {
                displayName = "";
            } else {
                contactViewHolder.vRoundLetterView.setTitleText(String.valueOf(displayName.charAt(0)));
                contactViewHolder.vRoundLetterView.setBackgroundColor(item.getBackgroundColor());
            }
            if (item.getPhoneNumbers().size() > 0) {
                String replaceAll = item.getPhoneNumbers().get(0).getNumber().replaceAll("\\s+", "");
                if (!replaceAll.equals(displayName.replaceAll("\\s+", ""))) {
                    contactViewHolder.tvNumber.setVisibility(0);
                    contactViewHolder.tvNumber.setText(replaceAll);
                } else {
                    contactViewHolder.tvNumber.setVisibility(8);
                }
            } else if (item.getEmails().size() > 0) {
                String replaceAll2 = item.getEmails().get(0).replaceAll("\\s+", "");
                if (!replaceAll2.equals(displayName.replaceAll("\\s+", ""))) {
                    contactViewHolder.tvNumber.setVisibility(0);
                    contactViewHolder.tvNumber.setText(replaceAll2);
                } else {
                    contactViewHolder.tvNumber.setVisibility(8);
                }
            } else {
                contactViewHolder.tvNumber.setVisibility(8);
            }
            highlightTerm(contactViewHolder.tvContactName, this.currentFilterQuery, contactViewHolder.tvContactName.getText().toString());
            if (item.isSelected()) {
                contactViewHolder.cbSelectedState.setChecked(true);
            } else {
                contactViewHolder.cbSelectedState.setChecked(false);
            }
            contactViewHolder.mView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.contactpicker.ContactPickerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ContactPickerAdapter.this.builder.maxSelectCount != 0) {
                        if (ContactPickerAdapter.this.getSelectedContactsCount() > ContactPickerAdapter.this.builder.maxSelectCount) {
                            return;
                        }
                        if (ContactPickerAdapter.this.getSelectedContactsCount() == ContactPickerAdapter.this.builder.maxSelectCount) {
                            ContactPickerAdapter contactPickerAdapter = ContactPickerAdapter.this;
                            if (((Contact) ContactPickerAdapter.this.contactItemList.get(contactPickerAdapter.getItemPosition(contactPickerAdapter.contactItemList, item.getId()))).isSelected()) {
                                ContactPickerAdapter.this.setContactSelected(item.getId());
                            } else {
                                return;
                            }
                        } else {
                            ContactPickerAdapter.this.setContactSelected(item.getId());
                        }
                    } else {
                        ContactPickerAdapter.this.setContactSelected(item.getId());
                    }
                    if (ContactPickerAdapter.this.listener != null) {
                        ContactPickerAdapter.this.listener.onContactSelected(ContactPickerAdapter.this.getItem(i), ContactPickerAdapter.this.getSelectedContactsCount());
                    }
                    ContactPickerAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_contact_pick_item, viewGroup, false));
    }

    public void setAllSelected(boolean isAll) {
        for (Contact contact : this.contactItemList) {
            contact.setSelected(isAll);
            ContactSelectListener contactSelectListener = this.listener;
            if (contactSelectListener != null) {
                contactSelectListener.onContactSelected(contact, getSelectedContactsCount());
            }
        }
        notifyDataSetChanged();
    }

    public void setContactSelected(long id) {
        this.contactItemList.get(getItemPosition(this.contactItemList, id)).setSelected(!this.contactItemList.get(r2).isSelected());
    }

    @Override // com.l4digital.fastscroll.FastScroller.xxIXOIIO
    public String getSectionText(int position) {
        try {
            return String.valueOf(this.contactItemList.get(position).getDisplayName().charAt(0));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }
}
