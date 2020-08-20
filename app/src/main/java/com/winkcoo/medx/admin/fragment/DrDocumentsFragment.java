package com.winkcoo.medx.admin.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.DocumentLitsAdapterDoctor;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.DocumentModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;
import static com.winkcoo.medx.admin.data.data.commonUserModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrDocumentsFragment extends Fragment implements ApiListener.DoctorDocDownloadListener {
    View view;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    Context context;


    public DrDocumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dr_documents, container, false);
        ButterKnife.bind(this, view);
        context = view.getContext();
        Api.getInstance().getAllDocumentOFSingleDoc(TOKEN, "" + commonUserModel.getId(), this);
        return view;
    }


    @Override
    public void onDoctorDocDownloadSuccess(List<DocumentModel> data) {
        //DocumentLitsAdapterDoctor


        //

        LinearLayoutManager layoutManager
                = new GridLayoutManager(context, 2);
        recycler_view.setLayoutManager(layoutManager);
        DocumentLitsAdapterDoctor mAdapter = new DocumentLitsAdapterDoctor(data);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);
    }

    @Override
    public void onDoctorDocDownloadFailed(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
