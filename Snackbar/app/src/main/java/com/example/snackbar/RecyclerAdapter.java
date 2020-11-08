package com.example.snackbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    Context context;
    ArrayList<ItemModel> itm;

    ItemModel temp;
    ItemModel tempedit;

    int amount;

    public RecyclerAdapter(Context applicationContext, ArrayList<ItemModel> item) {
        this.context=applicationContext;
        this.itm=item;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.itemlayout , parent , false);
        return new RecyclerViewHolder(view1);



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {


        holder.tv.setText(itm.get(position).getName());
        holder.gen.setText(itm.get(position).getGender());
        holder.myeditbtn.setImageResource(itm.get(position).getImage1(R.drawable.ic_edit));
        holder.mydeletebtn.setImageResource(itm.get(position).getImage(R.drawable.ic_delete));

        if(itm.get(position).getGender()=="Female")
        {
            amount=amount+50000;

        }


        holder.myeditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempedit = new ItemModel(itm.get(position).getName(),
                        itm.get(position).getGender(),
                        itm.get(position).getImage1(R.drawable.ic_edit),
                        itm.get(position).getImage(R.drawable.ic_delete));
                edititem(position,view);
            }
        });

        holder.mydeletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp=new ItemModel(itm.get(position).getName(),

                        itm.get(position).getGender(),
                        itm.get(position).getImage1(R.drawable.ic_edit),
                        itm.get(position).getImage(R.drawable.ic_delete));
                deleteItem(position , view);

            }
        });
        Toast.makeText(context,""+amount,Toast.LENGTH_LONG).show();

    }
    private void edititem(int pos, View vi) {

        //   itm.remove(pos);

        //  tempedit.setName("Lynessa");
        //    notifyItemRemoved(pos);
        //    notifyItemRangeChanged(pos,itm.size());
        String gender=  itm.get(pos).getGender();
        Intent i= new Intent(vi.getContext(),EditActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("position",pos);
        i.putExtra("gender", gender);
        // i.putExtra("tempe", (Serializable) temp);
       // Toast.makeText(vi.getContext(), ""+pos, Toast.LENGTH_SHORT).show();


        context.startActivity(i);


        // itm.add(pos, tempedit);
        // notifyItemInserted(pos);
        // notifyItemRangeChanged(pos, itm.size());
    }

    private void deleteItem(int pos , View vi)
    {
        itm.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos,itm.size());

        Snackbar.make(vi , "Undo" , Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itm.add(pos, temp);
                notifyItemInserted(pos);
                notifyItemRangeChanged(pos, itm.size());
            }
        })
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_blue_dark))
                .show();

    }



    @Override
    public int getItemCount() {
        return itm.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView tv;

        MaterialTextView gen;

        ImageView mydeletebtn;
        ImageView myeditbtn;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.displayitems);
            gen=itemView.findViewById(R.id.gender);
            mydeletebtn=itemView.findViewById(R.id.deletebtn);

            myeditbtn=itemView.findViewById(R.id.editbtn);




        }


    }
}
