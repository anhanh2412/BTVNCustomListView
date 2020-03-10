package com.example.btvncustomlistview.model.model;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.btvncustomlistview.MainActivity;
import com.example.btvncustomlistview.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.btvncustomlistview.R.drawable.music;

public class CustomAdapter extends ArrayAdapter<Contact> {
    Context context;
    int resource;
    ArrayList<Contact> arrayList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_row_layout, parent, false);
        TextView text_namebh = convertView.findViewById(R.id.text_namebh);
        TextView text_namecs = convertView.findViewById(R.id.text_namecs);
        TextView text_time = convertView.findViewById(R.id.text_time);
        ImageView img_anh = convertView.findViewById(R.id.img_anh);
        ImageButton bt_dialog = convertView.findViewById(R.id.bt_dialog);

        Contact contact = arrayList.get(position);

        text_namebh.setText(contact.getNameBH());
        text_namecs.setText(contact.getNameCS());
        text_time.setText(contact.getTime());
        img_anh.setBackgroundResource(music);

        bt_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(position);

            }
        });
        return convertView;
    }

    void showDialog(final int position){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_layout);
        Button bt_delete = dialog.findViewById(R.id.bt_delete);

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
