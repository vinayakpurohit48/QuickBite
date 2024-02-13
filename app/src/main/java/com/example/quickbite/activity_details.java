package com.example.quickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class activity_details extends AppCompatActivity {
    Button button ;
    ImageView detailImage;
    int quantity = 1,showprice;
    TextView Desc,showtime,detailname,price,showquantity,increment,decrement;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        button = (Button) findViewById(R.id.btnplaceoder);
        detailImage = (ImageView) findViewById(R.id.detailImage);
        Desc = (TextView) findViewById(R.id.desc);
        showtime = (TextView) findViewById(R.id.showtime);
        price = (TextView) findViewById(R.id.price);
        detailname = (TextView) findViewById(R.id.detailName);
        showquantity = (TextView) findViewById(R.id.quantity);
        increment = (TextView) findViewById(R.id.incrementButton);
        decrement = (TextView) findViewById(R.id.decrementButton);


        showquantity.setText(""+quantity);
        Intent intent = this.getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int desc = intent.getIntExtra("desc", R.string.maggieDesc);
            int image = intent.getIntExtra("image", R.drawable.maggi);
            showprice = intent.getIntExtra("showprice",100);

            detailname.setText(name);
            showtime.setText("⌛" +time);
            Desc.setText(desc);
            price.setText("₹ "+showprice*quantity);
            detailImage.setImageResource(image);
        }
        
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity < 20){
                    quantity++;
                    showquantity.setText(""+quantity);
                    price.setText("₹ "+showprice*quantity);
                }else {
                    Toast.makeText(activity_details.this, "!! Max 20 item you can select at a time !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity > 1){
                    quantity--;
                    showquantity.setText(""+quantity);
                    price.setText("₹ "+showprice*quantity);
                } else {
                    Toast.makeText(activity_details.this, "!! Quantity Can't to less than 1 !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_details.this, "Order Placed..!👍", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

}