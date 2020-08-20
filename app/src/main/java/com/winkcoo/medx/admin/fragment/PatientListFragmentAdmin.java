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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.DrLitsAdapterAdmin;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.CommonUserModel;
import com.winkcoo.medx.admin.widgets.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.loginResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientListFragmentAdmin extends Fragment implements ApiListener.UserDownloadListener{
    View view;
    Context context;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static PatientListFragmentAdmin newInstance() {
        PatientListFragmentAdmin fragment = new PatientListFragmentAdmin();
        return fragment;
    }
    public PatientListFragmentAdmin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_patient_list_fragment_admin, container, false);
        context = view.getContext();
        ButterKnife.bind(this, view);
        Api.getInstance().getUsersList("Bearer " + loginResponse.getAccessToken(), "p", this);
        return view;
    }
    @Override
    public void onUserDownloadSuccess(List<CommonUserModel> data) {

        DrLitsAdapterAdmin mAdapter = new DrLitsAdapterAdmin(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onUserDownloadFailed(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
