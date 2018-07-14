    package com.example.lenovo.educationapp;

    import android.app.Activity;
    import android.content.Intent;
    import android.support.annotation.NonNull;
    import android.support.annotation.Nullable;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;

    class CustomVote extends ArrayAdapter<String> {  Activity context;
        String[] ids;
        String[] names;
        String[] alarm;
        String[] duration;


        public CustomVote(@NonNull Activity context, int resource, String[] i, String[] n , String[] v, String[] p) {
            super(context, R.layout.sqlitedatabaseadapter,i);

            this.context=context;
            ids=i;
            names=n;
            alarm=v;
            duration=p;


        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.sqlitedatabaseadapter,null,true);
            TextView tvId=(TextView) view.findViewById(R.id.id);
            TextView tvName=(TextView) view.findViewById(R.id.name);
            TextView tvVote=(TextView) view.findViewById(R.id.alarm);
            TextView textView=(TextView) view.findViewById(R.id.duration);
            Button button=view.findViewById(R.id.button_send_database);
            tvId.setText(ids[position]);
            tvName.setText(names[position]);
            tvVote.setText(alarm[position]);
            textView.setText(duration[position]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent  intent=new Intent(context,Mp3.class);
                    intent.putExtra("url",alarm[position]);
                    context.startActivity(intent);
                }
            });


            return view;

        }

    }
