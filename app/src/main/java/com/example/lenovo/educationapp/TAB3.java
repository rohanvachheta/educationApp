package com.example.lenovo.educationapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TAB3 extends Fragment {
    public static final String URL="https://limy-masks.000webhostapp.com/phpjson";// you need to add hete the json file of your webservices
    RecyclerView recyclerView;
    ProgressBar progressBar;


    public TAB3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab3, container, false);
        recyclerView=view.findViewById(R.id.userlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar=view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);

                Log.d("onResponse: ",response);
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                User[] users=gson.fromJson(response,User[].class);
                recyclerView.setAdapter(new VollyAdapter(getActivity(),users));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        return view;
    }


    }


