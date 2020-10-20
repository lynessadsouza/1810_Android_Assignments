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

public class MyChatAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    static final int View_type_sen=0;
    static final int View_type_rec=1;

   // Context context;
    List<senderwrapper> smsgs;
  //  List<recwrapper> rmsgs;


    public  MyChatAdapter(List<senderwrapper> smsgs)
    {
        //this.context=context;
      //  this.rmsgs=rmsgs;
        this.smsgs=smsgs;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == View_type_rec){
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

        if(smsgs.get(position).name == View_type_rec){
            ((SenderViewHolder) holder).bind(position);

        }
        else{
            ((RecViewHolder) holder).bind(position);
        }
    }

    @Override
    public int getItemCount() {
       return smsgs.size();
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
            senderwrapper Senderwrapper = smsgs.get(position);
                tv.setText(Senderwrapper.text);

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
            senderwrapper Senderwrapper = smsgs.get(position);
            tv.setText(Senderwrapper.text);

        }
    }
    @Override
    public int getItemViewType(int position) {
        return smsgs.get(position).name;
    }
}
