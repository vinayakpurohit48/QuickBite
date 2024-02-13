package com.example.quickbite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] imageList = {R.drawable.burgur, R.drawable.pizza, R.drawable.noddles, R.drawable.pasta};
    int[] descList = {R.string.burgerDesc, R.string.pizzaDesc, R.string.noodelsDesc, R.string.pastaDesc};
    String[] nameList = {"Burgur", "Pizza", "Noodles", "Pasta"};
    String[] timeList = {"30 mins", "2 mins", "45 mins", "10mins"};
    String[] price = {"20", "40","57", "54"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        CustomeListView customeListView = new CustomeListView(getApplicationContext(),nameList,imageList,price);
        listView.setAdapter(customeListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, activity_details.class);
                intent.putExtra("name",nameList[position]);
                intent.putExtra("time", timeList[position]);
                intent.putExtra("desc", descList[position]);
                intent.putExtra("image", imageList[position]);
                intent.putExtra("showprice",price[position]);
                startActivity(intent);
            }
        });
    }
}