package com.winkcoo.medx.admin.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.Utils.MyProgressBar;
import com.winkcoo.medx.admin.Utils.doForMe;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.SettingsModel;
import com.winkcoo.medx.admin.model.StatusMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class RatesFragment extends Fragment {
    View view;
    Context context;
    @BindView(R.id.tv_percentage)
    TextView tv_percentage;

    @BindView(R.id.tv_update)
    TextView tv_update;


    public RatesFragment() {
        // Required empty public constructor
    }

    public static RatesFragment newInstance() {
        RatesFragment fragment = new RatesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_rates, container, false);
        context = view.getContext();
        ButterKnife.bind(this, view);
        // Api.getInstance().getServiceNameRate(TOKEN, this);

        Api.getInstance().get_setting_list(TOKEN, new ApiListener.AllSettingListtListDownloadListener() {
            @Override
            public void onAllSettingListDownloadSuccess(List<SettingsModel> response) {

                tv_percentage.setText(response.get(0).getValue() + " %");
                tv_update.setOnClickListener((View vi) -> {
                    Dialog dialog = doForMe.showDialog(context, R.layout.update_fees_dialog);
                    CardView cardSave = (CardView) dialog.findViewById(R.id.cardSave);
                    EditText ed_percentage = (EditText) dialog.findViewById(R.id.ed_percentage);
                    ed_percentage.setText(""+response.get(0).getValue());
                    cardSave.setOnClickListener((View v) -> {
                        String fees = ed_percentage.getText().toString().trim();
                        if (fees.length() > 0) {
                            MyProgressBar.with(context);

                            Api.getInstance().update_setting_percentage(TOKEN, fees, new ApiListener.SettingUpdateListener() {
                                @Override
                                public void onSettingUpdateSuccess(StatusMessage response) {
                                    MyProgressBar.dismiss();
                                    dialog.dismiss();
                                    tv_percentage.setText(fees + " %");
                                }

                                @Override
                                public void onSettingUpdateFailed(String msg) {

                                }
                            });

                        }
                    });
                });

            }

            @Override
            public void onAllSettingListDownloadFailed(String msg) {

            }
        });
        return view;
    }


}
