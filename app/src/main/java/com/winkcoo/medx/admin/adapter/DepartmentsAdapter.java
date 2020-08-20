package com.winkcoo.medx.admin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.data.data;
import com.winkcoo.medx.admin.model.DeptModel;

import java.util.ArrayList;
import java.util.List;

;


/**
 * Created by mukul on 3/10/2019.
 */


public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.MyViewHolder> {
    List<DeptModel> list = new ArrayList<>();
    DeptSelectListsner deptSelectListsner;

    public void setDeptSelectListsner(DeptSelectListsner deptSelectListsner) {
        this.deptSelectListsner = deptSelectListsner;
    }

    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        CardView card;


        public MyViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            card = (CardView) view.findViewById(R.id.card);


        }
    }


    public DepartmentsAdapter(List<DeptModel> lists) {
        this.list = lists;

    }    public DepartmentsAdapter(List<DeptModel> lists, DeptSelectListsner listsner) {
        this.list = lists;
        this.deptSelectListsner=listsner;

    }
    public  interface DeptSelectListsner{
        public  void onSelected(int i);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hospitals_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final DeptModel movie = list.get(position);
        context = holder.tv_name.getContext();
        holder.tv_name.setText(movie.getName());
        holder.card.setCardBackgroundColor(Color.parseColor(data.getColorCode(position)));




    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}