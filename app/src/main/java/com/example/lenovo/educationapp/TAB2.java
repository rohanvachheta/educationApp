package com.example.lenovo.educationapp;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TAB2 extends Fragment {
    DatabaseHelper databaseHelper;
    ListView listView;
    String name,marks,pucs;
    Button senddata;


    public TAB2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab2, container, false);
        listView=(ListView)view.findViewById(R.id.listview);
        senddata=view.findViewById(R.id.button_send_database);

        call();
        Button button=view.findViewById(R.id.butoonnn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();

            }
        });
        return view;
    }

    private void call() {

        databaseHelper=new DatabaseHelper(getActivity());
        ArrayList <String> thelist=new ArrayList<>( );
        Cursor cursor=databaseHelper.getAlldata();
        String[] id=new String[cursor.getCount()];
        final String[] names=new String[cursor.getCount()];
        final String[] alarm=new String[cursor.getCount()];
        String[] duration=new String[cursor.getCount()];
        int x=0;

        cursor.moveToFirst();
        while(cursor.isAfterLast()==false)
        {
            id[x]=cursor.getString(0);
            names[x]=cursor.getString(1);
            alarm[x]=cursor.getString(2);
            duration[x]=cursor.getString(3);


            x++;
            cursor.moveToNext();

            CustomVote customVote=new CustomVote(getActivity(),R.layout.fragment_tab2,id,names,alarm,duration);
            listView.setAdapter(customVote);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(), "names"+names[i], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),Mp3.class);
                    intent.putExtra("url",alarm[i]);
                    startActivity(intent);
                }
            });


        }


    }


}
