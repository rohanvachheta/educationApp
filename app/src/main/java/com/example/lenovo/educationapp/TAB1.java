package com.example.lenovo.educationapp;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class TAB1 extends Fragment {
    EditText getdetails,editText2,editText3,editText4;
    Button insert,show;
    SQLiteDatabase db;
    StringBuilder stringBuilder;
    ListView mylist;
    DatabaseHelper databaseHelper;

    public TAB1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab1, container, false);
        insert=(Button)view.findViewById(R.id.adddata);
        show=(Button)view.findViewById(R.id.showdata);
        getdetails=(EditText)view.findViewById(R.id.editText);
        editText2=(EditText)view.findViewById(R.id.editText2);
        editText3=view.findViewById(R.id.editText3);
        editText4=view.findViewById(R.id.editText4);
        mylist=view.findViewById(R.id.listview);
        databaseHelper=new DatabaseHelper(getActivity());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(getdetails.getText().toString(),
                        editText2.getText().toString(),
                        editText3.getText().toString() );
                if(isInserted == true)
                    Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

                //String insertquary="insert into record values('"+getdetails.getText().toString()+"','"+editText2.getText().toString()+"','"+editText3.getText().toString()+"')";
                //db.execSQL(insertquary);
                Toast.makeText(getActivity(), "inserted data ", Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getAlldata();
                if(res.getCount() == 0) {
                    // show message


                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Marks :"+ res.getString(3)+"\n\n");
                }

                // Show all data
                showMessage("Data",buffer.toString());
            }

        });

        // Inflate the layout for this fragment
        return view;

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
