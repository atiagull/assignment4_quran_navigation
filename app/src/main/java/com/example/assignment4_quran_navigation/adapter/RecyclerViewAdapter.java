package com.example.assignment4_quran_navigation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment4_quran_navigation.R;
import com.example.assignment4_quran_navigation.SurahNumberAndNames;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    List<SurahNumberAndNames> surahObjectList;

    public RecyclerViewAdapter(Context context, List<SurahNumberAndNames> surahObject) {
        this.context = context;
        this.surahObjectList = surahObject;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        SurahNumberAndNames obj = surahObjectList.get(position);
        holder.txtSurahName.setText(obj.getSurahName());
    }

    @Override
    public int getItemCount() {
        return surahObjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView txtSurahName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSurahName = itemView.findViewById(R.id.txtSurahName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = this.getBindingAdapterPosition();
            SurahNumberAndNames obj = surahObjectList.get(position);
            Log.d("msg","button is clicked" + obj.getSurahNumber() + " " + obj.getSurahName());
        }
    }
}
