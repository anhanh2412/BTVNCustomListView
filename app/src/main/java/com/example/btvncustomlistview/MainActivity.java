package com.example.btvncustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.btvncustomlistview.model.model.Contact;
import com.example.btvncustomlistview.model.model.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edit_namebh, edit_namecs, edit_time;
    Button bt_add, bt_update;
    ListView lv_show;
    ArrayList<Contact> contacts;
    CustomAdapter adapter;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidth();
        setEvenAdd();
        setEvenUpdate();
        
    }
    void setWidth(){
        edit_namebh = findViewById(R.id.edit_namebh);
        edit_namecs = findViewById(R.id.edit_namecs);
        edit_time = findViewById(R.id.edit_time);
        bt_add = findViewById(R.id.bt_add);
        bt_update = findViewById(R.id.bt_update);
        lv_show = findViewById(R.id.lv_show);
        contacts = new ArrayList<>();
        adapter = new CustomAdapter(this, contacts);
        lv_show.setAdapter(adapter);


        lv_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "fgiowernvfd", Toast.LENGTH_LONG).show();
                edit_namebh.setText(contacts.get(position).getNameBH());
                edit_namecs.setText(contacts.get(position).getNameCS());
                edit_time.setText(contacts.get(position).getTime());
                number = position;
            }
        });
        
        lv_show.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "LONG CLICK", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        
    }

    void setEvenAdd(){
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameBH = edit_namebh.getText().toString().trim();
                String nameCS = edit_namecs.getText().toString().trim();
                String time = edit_time.getText().toString();

                if(TextUtils.isEmpty(nameBH) == true || TextUtils.isEmpty(nameCS) == true || TextUtils.isEmpty(time) == true){
                    Toast.makeText(MainActivity.this, "please", Toast.LENGTH_LONG).show();
                }else{
                    Contact contact = new Contact(nameBH,nameCS,time);
                    contacts.add(contact);
                    edit_namebh.setText("");
                    edit_namecs.setText("");
                    edit_time.setText("");
                }
                adapter.notifyDataSetChanged();
            }
        });
    }


    void setEvenUpdate(){
        


        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namebh = edit_namebh.getText().toString();
                String namecs = edit_namecs.getText().toString();
                String time = edit_time.getText().toString();

                Contact contact = new Contact(namebh,namecs,time);
                contacts.set(number,contact);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
