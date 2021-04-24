package charulatha.vijayakumar.contacts;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "contact_name")
    private String mContact;

    @ColumnInfo(name = "contact_phone")
    private String mPhone;

    @ColumnInfo(name = "contact_email")
    private String mEmail;

    public Contact(@NonNull String contact, String phone, String email) {
        this.mContact = contact;
        this.mPhone = phone;
        this.mEmail = email;
    }

    public String getContact(){return this.mContact;}
    public String getPhone(){return this.mPhone;}
    public String getEmail(){return this.mEmail;}
}

