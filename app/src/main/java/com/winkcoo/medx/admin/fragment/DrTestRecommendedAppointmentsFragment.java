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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.PendingAppointmentAdapterDoctor;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.AppointmentModelNew;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;
import static com.winkcoo.medx.admin.data.data.commonUserModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrTestRecommendedAppointmentsFragment extends Fragment implements ApiListener.appoinetmentsDownloadListener {
    Context context;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.pendingCount)
    TextView pendingCount;
    View view;

    public DrTestRecommendedAppointmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dr_pending_appointments, container, false);
        context=view.getContext();
        ButterKnife.bind(this, view);
        Api.getInstance().getAppointments(TOKEN, "doctor", "" + commonUserModel.getId(), "2", this);


        return view;
    }

    @Override
    public void onAppointmentDownloadSuccess(List<AppointmentModelNew> status) {

        if (status != null && status.size() > 0) {
            pendingCount.setText("" + status.size());

            PendingAppointmentAdapterDoctor mAdapter = new PendingAppointmentAdapterDoctor(status);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
            recycler_view.setLayoutManager(mLayoutManager);
            recycler_view.setItemAnimator(new DefaultItemAnimator());
            recycler_view.setAdapter(mAdapter);
        } else {
            Toast.makeText(context, "No data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAppointmentDownloadFailed(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

}
