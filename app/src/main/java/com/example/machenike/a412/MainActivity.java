package com.example.machenike.a412;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private List<MyItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        init();
    }

    public void getData() {
        MyItem item1 = new MyItem("铁板饭", 10,R.drawable.cat);
        MyItem item2 = new MyItem("土豆丝", 11,R.drawable.bg);
        MyItem item3 = new MyItem("啦啦啦", 19,R.drawable.top);
        list.add(item1);
        list.add(item2);
        list.add(item3);
    }

    public void init() {
        listView = (ListView) findViewById(R.id.main_listview);
        button = (Button) findViewById(R.id.button_tijiao);
        final MyAdapter myAdapter = new MyAdapter(this, list);
        listView.setAdapter(myAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();
                list = myAdapter.getList();
                for (MyItem myItem : list) {
                    if (myItem.getNumber() > 0) {
                        builder.append(myItem.getName() + ":" + String.valueOf(myItem.getNumber()));
//                        Toast.makeText(MainActivity.this,myItem.getName()+":"+String.valueOf(myItem.getNumber()),Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
