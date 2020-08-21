package com.winkcoo.medx.admin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.AllPendingTransListAdapter;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.PendingTransModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;

public class PendingTransactionsFragment extends Fragment {
    View view;
    Context context;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    List<PendingTransModel> list = new ArrayList<>();
    AllPendingTransListAdapter mAdapter;

    public PendingTransactionsFragment() {
        // Required empty public constructor
    }

    public static PendingTransactionsFragment newInstance() {
        PendingTransactionsFragment fragment = new PendingTransactionsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pending_transactions, container, false);
        context = view.getContext();
        ButterKnife.bind(this, view);
        list.clear();
        loadAndShow();
        //accept_pending_transection

        mAdapter = new AllPendingTransListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);
        mAdapter.setOnStateChange(new AllPendingTransListAdapter.onStateChangeListener() {
            @Override
            public void onChanged() {
                list.clear();
                loadAndShow();


            }
        });


        return view;
    }

    private void loadAndShow() {
        Api.getInstance().get_pendlingPaymentList_list(TOKEN, new ApiListener.allPendingPaymentListDownloadListener() {
            @Override
            public void onallPendingPaymentListDownloadSuccess(JsonElement response) {
                JSONArray array = null;
                try {
                    array = new JSONArray(response.toString());

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        JSONObject p = object.getJSONObject("patient_info");
                        JSONObject d = object.getJSONObject("dr_info");

                        // JsonElement patientEle = object.get("patient_info");
                        Toast.makeText(context, object.get("trans_id_img").toString(), Toast.LENGTH_SHORT).show();
                        list.add(new PendingTransModel(object.getInt("id"),p.get("id").toString(),p.get("name").toString(), d.get("id").toString(),object.get("created_at").toString(), object.get("full_fees").toString(), object.get("trans_id").toString(),object.get("trans_id_img").toString(),object.getString("service_details").toString()));
                        mAdapter.notifyDataSetChanged();
                    }

                    Log.i("mkl", list.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onallPendingPaymentListDownloadFailed(String msg) {
                Toast.makeText(context, "error m sg " + msg, Toast.LENGTH_SHORT).show();

            }
        });
    }
}