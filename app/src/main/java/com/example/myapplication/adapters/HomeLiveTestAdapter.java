package com.example.myapplication.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


/**
 * Created by Vishnu Saini on.
 */

public class HomeLiveTestAdapter extends RecyclerView.Adapter<HomeLiveTestAdapter.MyViewHolder> {
    private Activity context;
    private View.OnClickListener onClickListener;

    public HomeLiveTestAdapter(Activity context, View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_test_home, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.lin_homeLiveTest.setOnClickListener(onClickListener);
        holder.lin_homeLiveTest.setTag(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout lin_homeLiveTest;


        public MyViewHolder(View view) {
            super(view);

            lin_homeLiveTest=view.findViewById(R.id.lin_homeLiveTest);


        }
    }
}
