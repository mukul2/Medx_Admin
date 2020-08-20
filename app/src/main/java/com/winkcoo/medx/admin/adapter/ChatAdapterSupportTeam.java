package com.winkcoo.medx.admin.adapter;

/**
 * Created By TAOHID on 10/25/18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.model.QueryModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.winkcoo.medx.admin.data.data.MY_ID;


/**
 * Created by ravi on 16/11/17.
 */

public class ChatAdapterSupportTeam extends RecyclerView.Adapter<ChatAdapterSupportTeam.MyViewHolder> {
    private Context context;
    private List<QueryModel> contactListFiltered;
    int INCOMING = 1;
    int OUTGOING = 0;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_body, tv_date, tv_attachment_count;
        LinearLayout notification_row;
        CircleImageView image;


        public MyViewHolder(View view) {
            super(view);
            tv_body = view.findViewById(R.id.tv_body);
            tv_date = view.findViewById(R.id.tv_date);
            image = view.findViewById(R.id.image);




        }
    }


    public ChatAdapterSupportTeam(Context context, List<QueryModel> contactList) {
        this.context = context;
        this.contactListFiltered = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == INCOMING)
            //reverse happended
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_outgoing, parent, false);
        else
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_incomming, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final QueryModel contact = contactListFiltered.get(position);
        holder.tv_body.setText(contact.getMessage_body());
        holder.tv_date.setText(contact.getCreated_at());

      //  Glide.with(context).load(PHOTO_BASE+ChatActivityDr.PARTNER_PHOTO).into(holder.image);



    }

    private String getAttachmentCount(String attachment) {
        String ret = "0 attachment";
        try {
            JSONArray jsonArray = new JSONArray(attachment);
            ret = String.valueOf(jsonArray.length()) + " attachment";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private String changeDateformate(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sourceDate = null;
        try {
            sourceDate = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat targetFormat = new SimpleDateFormat("MMM dd");
        return targetFormat.format(sourceDate);
    }

    @Override
    public int getItemCount() {
        return contactListFiltered.size();

    }

    @Override
    public int getItemViewType(int position) {
        if (contactListFiltered.get(position).getMessage_sender_id()==MY_ID){
            return INCOMING;
        }else return OUTGOING;
    }


}