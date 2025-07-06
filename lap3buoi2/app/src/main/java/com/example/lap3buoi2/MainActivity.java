package com.example.lap3buoi2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewContact;
    ArrayList<ContactModel> contactList;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContact = findViewById(R.id.listViewContact);

        // Khởi tạo danh sách liên hệ
        contactList = new ArrayList<>();
        contactList.add(new ContactModel("Lê Trọng Tấn Phát", "0901234567", R.drawable.user1));
        contactList.add(new ContactModel("Nguyễn Văn Hưng", "0912345678", R.drawable.user2));
        contactList.add(new ContactModel("Trần Thị Thảo", "0987654321", R.drawable.user3));

        // Gắn adapter vào ListView
        contactAdapter = new ContactAdapter(this, contactList);
        listViewContact.setAdapter(contactAdapter);
    }
}
