package com.example.lenovo.educationapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class VollyAdapter extends RecyclerView.Adapter<VollyAdapter.GitHubViewHolder> {
    private Context context; 
    private User[] data;
    boolean prepared=false;
    boolean started=false;
    MediaPlayer mediaplayer;
    DatabaseHelper databaseHelper;
    public VollyAdapter(Context context, User[] data) {
        this.context=context;
        this.data=data;


    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.servicelayout,parent,false);
        return new GitHubViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final GitHubViewHolder holder, int position) {
        final User user=data[position];
        databaseHelper=new DatabaseHelper(context);


        holder.name.setText("name:" + user.getAlarm());
       //holder.timing.setText("timing"+user.getTiming());
       // holder.loop.setText("loop:"+user.getRepeat());//you need to addd in User element in User class
       // holder.autoplay.setText("autoplay:"+user.getAutoPlay());
//        holder.media_location.setText("media_location"+user.getLocation());

        final MediaPlayer mediaPlayer = new MediaPlayer();
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Mp3.class);
                intent.putExtra("url",user.getLocation());
                context.startActivity(intent);
            }
        });

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelper.insertData(user.getAlarm(),
                        "",
                        "" );
                if(isInserted == true) {
                    Toast.makeText(context,user.getAlarm(),Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(context,"Data not Inserted",Toast.LENGTH_LONG).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GitHubViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,timing,loop,autoplay,media_location,time_interval;
        Button play,download;

        public GitHubViewHolder(View itemView) {
            super(itemView);
           // media_location=itemView.findViewById(R.id.volly_autoplay);
           name=itemView.findViewById(R.id.volly_name);
           play=itemView.findViewById(R.id.volly_play_button);
         //  button=itemView.findViewById(R.id.volly_play_button);
           // download=itemView.findViewById(R.id.volly_download);


        }
    }

}
