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
import com.winkcoo.medx.admin.adapter.WidhdrawListDoctorAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllWidthdrawFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    Context context;
    View view;

    public AllWidthdrawFragment() {
        // Required empty public constructor
    }

    boolean isLoaded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_widthdraw, container, false);
        ButterKnife.bind(this, view);
        context = view.getContext();

        // Toast.makeText(context, "widh draw "+PaymentsHistoryActivity.ALL_COLLECTION_WIDTHDRAWL.getWidthdrawModel().size(), Toast.LENGTH_SHORT).show();


        if (true) {
            WidhdrawListDoctorAdapter mAdapter = new WidhdrawListDoctorAdapter(UsersBillFragment.ALL_COLLECTION_WIDTHDRAWL.getWidthdrawModel());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
            recycler_view.setLayoutManager(mLayoutManager);
            recycler_view.setItemAnimator(new DefaultItemAnimator());
            recycler_view.setAdapter(mAdapter);

            isLoaded = true;
        }
        //add_withdrawal_request




        return view;
    }
}
