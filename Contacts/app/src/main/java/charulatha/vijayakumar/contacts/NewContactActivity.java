package charulatha.vijayakumar.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//public class NewContactActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_contact);
//    }
//}

public class NewContactActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.roomcontactssample.REPLY";

    private EditText mEditContactView, mEditContactPhoneView, mEditContactEmailView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        mEditContactView = findViewById(R.id.edit_contact);
        mEditContactPhoneView = findViewById(R.id.edit_phone);
        mEditContactEmailView = findViewById(R.id.edit_email);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditContactView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String contact = mEditContactView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, contact);
                    String phone = mEditContactPhoneView.getText().toString();
                    replyIntent.putExtra("phone",phone);
//                    replyIntent.putExtra(EXTRA_R, phone);
                    String email = mEditContactEmailView.getText().toString();
                    //replyIntent.putExtra(EXTRA_REPLY, email);
                    replyIntent.putExtra("email",email);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
