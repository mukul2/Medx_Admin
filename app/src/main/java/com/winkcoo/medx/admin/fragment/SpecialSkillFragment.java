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
import com.winkcoo.medx.admin.adapter.SkillAdapterDoctor;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.activity.DoctorProfileActivity.SKILLS;


public class SpecialSkillFragment extends Fragment {
    View v;
    Context context;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;


    public static SpecialSkillFragment newInstance() {
        SpecialSkillFragment fragment = new SpecialSkillFragment();
        return fragment;
    }

    public SpecialSkillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_special_skill, container, false);
        context = v.getContext();
        ButterKnife.bind(this, v);

        initRecyclerView();


        return v;
    }

    private void initRecyclerView() {
        SkillAdapterDoctor mAdapter = new SkillAdapterDoctor(SKILLS);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);

    }


}
