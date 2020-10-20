package com.example.mychatfinal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MyChatAdapter2  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    static final int View_type_sen=0;
    static final int View_type_rec=1;

   //Context context;
    List<recwrapper> rmsgs;


    public  MyChatAdapter2(List<recwrapper> rmsgs)
    {

        //  this.rmsgs=rmsgs;
        this.rmsgs=rmsgs;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == View_type_sen){
            //  return new senderwrapper(LayoutInflater.from(parent.getContext()).inflate(R.layout.msglayout,parent,false));
            //return new senderwrapper(LayoutInflater.from(parent.getContext().inf));
            return new SenderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.msglayout,parent,false));
        }
        else{
            return new RecViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.msglayout,parent,false));

        }

        //  return  null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(rmsgs.get(position).name == View_type_sen){
            ((SenderViewHolder) holder).bind(position);

        }
        else{
            ((RecViewHolder) holder).bind(position);
        }
    }

    @Override
    public int getItemCount()
    {
        return rmsgs.size();
    }

    private class SenderViewHolder extends  RecyclerView.ViewHolder
    {
        public MaterialTextView tv;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.displaymsg);
            tv.setBackgroundColor(Color.RED);
        }

        public void bind(int position) {
            recwrapper  Recwrapper = rmsgs.get(position);
            tv.setText(Recwrapper.text);

        }
    }

    private class RecViewHolder extends  RecyclerView.ViewHolder
    {
        public MaterialTextView tv;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.displaymsg);
            tv.setBackgroundColor(Color.BLUE);
        }

        public void bind(int position) {
            recwrapper Recwrapper = rmsgs.get(position);
            tv.setText(Recwrapper.text);

        }
    }
    @Override
    public int getItemViewType(int position)
    {
        return rmsgs.get(position).name;
    }
}
