package com.example.machenike.a412;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<MyItem> list;

    public MyAdapter(Context context,List<MyItem> list){
        this.context=context;
        this.list=list;
    }

    public List<MyItem> getList() {
        return list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //判断view是都为空
        if (view==null){
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.listview_item,null);
            final MyItem myItem=list.get(i);
            ImageView imageView=(ImageView)view.findViewById(R.id.list_item_imageview_photo);
            imageView.setImageResource(myItem.getImage_id());
            TextView name=(TextView)view.findViewById(R.id.list_item_name);
            name.setText(myItem.getName());
            TextView price=(TextView)view.findViewById(R.id.list_item_price);
            price.setText(String.valueOf(myItem.getPrice()));
            final TextView number=(TextView)view.findViewById(R.id.list_item_number);
            ImageButton add=(ImageButton)view.findViewById(R.id.list_item_button_add);
            ImageButton jian=(ImageButton)view.findViewById(R.id.list_item_button_jian);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int num=myItem.getNumber()+1;
                    myItem.setNumber(num);
                    number.setText(String.valueOf(num));
                }
            });
            jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int num=myItem.getNumber();
                    if (num>0){
                        num=num-1;
                        number.setText(String.valueOf(num));
                        myItem.setNumber(num);
                    }else {
                        Toast.makeText(context,"已经是最小值",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        return view;
    }
}
