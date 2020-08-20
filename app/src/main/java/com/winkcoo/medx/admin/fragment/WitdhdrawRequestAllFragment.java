package com.winkcoo.medx.admin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.AllWidhdrawListDoctorAdapter;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.WitdhdrawFull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class WitdhdrawRequestAllFragment extends Fragment {
    View view;
    Context context;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    List<WitdhdrawFull> responseALL = new ArrayList<>();
    AllWidhdrawListDoctorAdapter mAdapter;
    public WitdhdrawRequestAllFragment() {
        // Required empty public constructor
    }

    public static WitdhdrawRequestAllFragment newInstance() {
        WitdhdrawRequestAllFragment fragment = new WitdhdrawRequestAllFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_witdhdraw_request_all, container, false);
        context = view.getContext() ;
        ButterKnife.bind(this,view);

        downlaodData();

        mAdapter = new AllWidhdrawListDoctorAdapter(responseALL);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);

        mAdapter.setOnStateChange(new AllWidhdrawListDoctorAdapter.onStateChangeListener() {
            @Override
            public void onChanged() {
                downlaodData();
            }
        });

        return  view;
    }

    private void downlaodData() {
        Api.getInstance().all_withdrawal_request(TOKEN, new ApiListener.AllWitdhdrawListtListDownloadListener() {
            @Override
            public void onAllWitdhdrawListDownloadSuccess(List<WitdhdrawFull> response) {
                responseALL.clear();
                responseALL.addAll(response);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAllWitdhdrawListDownloadFailed(String msg) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
