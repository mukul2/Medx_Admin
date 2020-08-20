package com.winkcoo.medx.admin.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.Utils.MyProgressBar;
import com.winkcoo.medx.admin.activity.ImageViewFullScreen;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.PendingTransModel;
import com.winkcoo.medx.admin.model.StatusMessage;

import java.util.ArrayList;
import java.util.List;

import static com.winkcoo.medx.admin.data.data.CURRENCY_USD_SIGN;
import static com.winkcoo.medx.admin.data.data.TOKEN;


/**
 * Created by mukul on 3/10/2019.
 */


public class AllPendingTransListAdapter extends RecyclerView.Adapter<AllPendingTransListAdapter.MyViewHolder> {
    List<PendingTransModel> list = new ArrayList<>();

    Context context;
    public  onStateChangeListener onStateChange;
    public  interface onStateChangeListener{
        void onChanged();
    }

    public void setOnStateChange(onStateChangeListener o) {
        this.onStateChange = o;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_date,tv_payment_details,tv_amount,tv_approve,tv_type;
        ImageView img;


        public MyViewHolder(View view) {
            super(view);
            tv_approve = (TextView) view.findViewById(R.id.tv_approve);
            tv_amount = (TextView) view.findViewById(R.id.tv_amount);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_date = (TextView) view.findViewById(R.id.tv_date);
            tv_payment_details = (TextView) view.findViewById(R.id.tv_payment_details);
            tv_type = (TextView) view.findViewById(R.id.tv_type);



        }
    }


    public AllPendingTransListAdapter(List<PendingTransModel> lists) {
        this.list = lists;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pending_trans_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PendingTransModel movie = list.get(position);
        context = holder.tv_date.getContext();
        holder.tv_date.setText("Date : " + movie.getDate() );
        holder.tv_name.setText("P. Name : " + movie.getName() );
        holder.tv_payment_details.setText("Trans ID : " + movie.getPayment_details() );
        holder.tv_amount.setText("" + movie.getAmount()+CURRENCY_USD_SIGN );
        if (movie.getType()!=null&&movie.getType().length()>0 &&movie.getType().equals("null")) {
            holder.tv_type.setText("View Photos" );
            holder.tv_type.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.tv_type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImageViewFullScreen.class);
                    intent.putExtra("link", movie.getType());
                    context.startActivity(intent);
                }
            });
        }else {
            holder.tv_type.setText("No Photos" );
            holder.tv_type.setTextColor(context.getResources().getColor(R.color.textText));

        }
        holder.tv_approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyProgressBar.with(context);
                Api.getInstance().accept_pending_transection(TOKEN, movie.getPayment_details(),movie.getType(),String.valueOf(movie.getId()), new ApiListener.BasicApiListener() {
                    @Override
                    public void onBasicAPISuccess(StatusMessage response) {
                        MyProgressBar.dismiss();
                        //Toast.makeText(context,response.getMessage(), Toast.LENGTH_SHORT).show();
                        onStateChange.onChanged();

                        Api.getInstance().appNotification(movie.getPid(), "Payment Confirmed", "Your pending transaction has been verified", "pending_payment", null, "a", new ApiListener.NotificationSentListener() {
                            @Override
                            public void onNotificationSentSuccess(JsonElement status) {
                                Toast.makeText(context, ""+status.toString(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onNotificationSentFailed(String msg) {
                                //  Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                    @Override
                    public void onBasicAPIFailed(String msg) {
                        MyProgressBar.dismiss();

                        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}