package com.winkcoo.medx.admin.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.PrescriptionRequestAdapterDoctor;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.PrescriptionRequestModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;
import static com.winkcoo.medx.admin.data.data.commonUserModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServedPrescriptionRequestsFragment extends Fragment implements ApiListener.MyPrescriptionRequestDownloadListener {
    Context context;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.pendingCount)
    TextView pendingCount;
    View view;

    public ServedPrescriptionRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dr_pending_appointments, container, false);
        ButterKnife.bind(this, view);
        context=view.getContext();
        String userType;
        if (commonUserModel.getUserType().equals("d")) {
            userType = "doctor";


        } else {
            userType = "patient";

        }
        Api.getInstance().getMyPrescriptionRequest(TOKEN, "" + commonUserModel.getId(), userType, this);


        return view;
    }

    @Override
    public void onMyPrescriptionRequestDownloadSuccess(List<PrescriptionRequestModel> data) {
        if (data != null && data.size() > 0) {
            PrescriptionRequestAdapterDoctor mAdapter = new PrescriptionRequestAdapterDoctor(data);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recycler_view.setLayoutManager(new GridLayoutManager(context, 2));
            recycler_view.setItemAnimator(new DefaultItemAnimator());
            // recycler_view.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL, false));
            recycler_view.setAdapter(mAdapter);
            pendingCount.setText("" + data.size());
        }
    }

    @Override
    public void onMyPrescriptionRequestDownloadFailed(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

}
