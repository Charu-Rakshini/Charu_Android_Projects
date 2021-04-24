package charulatha.vijayakumar.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private final LayoutInflater mInflater;
    private List<Contact> mContacts; // Cached copy of Contact
    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;

    ContactListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        if (mContacts != null) {
            Contact current = mContacts.get(position);
            holder.contactItemView.setText(current.getContact());
            holder.contactPhoneView.setText(current.getPhone());
        } else {
            // Covers the case of data not being ready yet.
            holder.contactItemView.setText("No Contact");
        }

        holder.contactItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mInflater.getContext(), NewContactActivity.class);
               //startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    void setContacts(List<Contact> contacts){
        mContacts = contacts;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mContacts has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mContacts != null)
            return mContacts.size();
        else return 0;
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        private final TextView contactItemView,contactPhoneView;

        private ContactViewHolder(View itemView) {
            super(itemView);
            contactItemView = itemView.findViewById(R.id.textViewName);
            contactPhoneView = itemView.findViewById(R.id.textViewPhone);
        }
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            Contact contact = new Contact(data.getStringExtra(NewContactActivity.EXTRA_REPLY),data.getStringExtra(NewContactActivity.EXTRA_REPLY),data.getStringExtra(NewContactActivity.EXTRA_REPLY));
//            mContactViewModel.insert(contact);
//        } else {
//            Toast.makeText(
//                    mInflater.getContext(),
//                    R.string.empty_not_saved,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
}
