package com.example.shivakumarm.szlauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {
     public List<AppInfo> appsList;
     public RAdapter(){
         appsList = new ArrayList<AppInfo>();


     }



    public void addApp(AppInfo appInfo){
         appsList.add(appInfo);
     }

    @NonNull
    @Override
    public RAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapter.ViewHolder viewHolder, int i) {
        TextView  textView = viewHolder.textView;
        textView.setText(appsList.get(i).lable);

        ImageView imageView = viewHolder.img;
        imageView.setImageDrawable(appsList.get(i).icon);
    }

    @Override
    public int getItemCount() {
        return appsList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{

        public TextView textView;
        public ImageView img;
        public ViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            img = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Context context = v.getContext();


            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(appsList.get(pos).pName.toString());
            context.startActivity(launchIntent);
            Toast.makeText(v.getContext(), appsList.get(pos).lable.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
