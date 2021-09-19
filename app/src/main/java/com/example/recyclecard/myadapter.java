package com.example.recyclecard;

import static java.lang.String.valueOf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class myadapter extends RecyclerView.Adapter<myviewholder> implements Filterable {

ArrayList<Model> data;
ArrayList<Model>backup;
Context context;

    public myadapter(ArrayList<Model> data,Context context) {
        this.data = data;
        //this.context=context;
        backup=new ArrayList<>(data);
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlelrow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp = data.get(position);


        // holder.t1.setText( valueOf(data.get(position).getNumber()));
        //holder.t1.setText(data.get(position).getNumber());
        holder.t1.setText(valueOf(data.get(position).getA()));
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Main2Activity.class);
                intent.putExtra("mi",valueOf(temp.getA()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Model>filterdata=new ArrayList<>();
            if (keyword.toString().isEmpty())
                filterdata.addAll(backup);

            else {
                for (Model obj:backup){
                    if (obj.getA().toString().contains(keyword.toString()))
                        filterdata.add(obj);
                }

            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filterdata;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
             data.clear();
             data.addAll((ArrayList<Model>)filterResults.values);
             notifyDataSetChanged();
        }
    };
}
