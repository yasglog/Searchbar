package com.example.recyclecard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class myviewholder extends RecyclerView.ViewHolder
{

    TextView t1;
    public myviewholder(@NonNull View itemView) {
        super(itemView);
        t1=itemView.findViewById(R.id.t1);
    }
}
