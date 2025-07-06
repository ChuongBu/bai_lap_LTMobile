package com.example.lap33;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView imgDetail;
    TextView txtName, txtDescription, txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        txtPrice = findViewById(R.id.txtPrice);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image", 0);
        String description = intent.getStringExtra("description");
        int price = intent.getIntExtra("price", 0);

        txtName.setText(name);
        txtDescription.setText(description);
        txtPrice.setText("Giá: " + price + " VNĐ");
        imgDetail.setImageResource(image);
    }
}
