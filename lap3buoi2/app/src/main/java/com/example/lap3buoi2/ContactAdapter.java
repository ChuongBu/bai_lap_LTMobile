package com.example.lap3buoi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<ContactModel> contactList;

    public ContactAdapter(Context context, ArrayList<ContactModel> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);

        ImageView img = convertView.findViewById(R.id.img_contact);
        TextView txtName = convertView.findViewById(R.id.txt_name);
        TextView txtPhone = convertView.findViewById(R.id.txt_phone);

        ContactModel contact = contactList.get(position);
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        img.setImageResource(contact.getImage());

        return convertView;
    }
}
