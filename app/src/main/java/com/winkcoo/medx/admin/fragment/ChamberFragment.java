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
import com.winkcoo.medx.admin.adapter.ChambersListAdapterDr;
import com.winkcoo.medx.admin.model.DaysTimeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.activity.DoctorProfileActivity.CHAMBERLIST;


public class ChamberFragment extends Fragment {
    View v;
    Context context;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    List<DaysTimeModel> list = new ArrayList<>();
    List<DaysTimeModel> listReserved = new ArrayList<>();
    List<String> days = new ArrayList<>();
    List<String> timeRange = new ArrayList<>();


    public static ChamberFragment newInstance() {
        ChamberFragment fragment = new ChamberFragment();
        return fragment;
    }

    public ChamberFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_chamber, container, false);
        context = v.getContext();

        ButterKnife.bind(this, v);

        //dayAddDialog

        //CHAMBERLIST
        ChambersListAdapterDr mAdapter=new  ChambersListAdapterDr(CHAMBERLIST);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);

        return v;
    }


}
