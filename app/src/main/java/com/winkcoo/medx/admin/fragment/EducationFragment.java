package com.winkcoo.medx.admin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.adapter.EducationsAdapterDoctor;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.activity.DoctorProfileActivity.EDUCATION;


public class EducationFragment extends Fragment {
    View v;
    Context context;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;



    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        return fragment;
    }

    public EducationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_education, container, false);
        ButterKnife.bind(this,v);
        context=v.getContext();
        ButterKnife.bind(this,v);


        initRecyclerView();




        return v;
    }

    private void initRecyclerView() {
        EducationsAdapterDoctor mAdapter = new EducationsAdapterDoctor(EDUCATION);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);
    }


}
