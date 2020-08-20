package com.winkcoo.medx.admin.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.Utils.MyProgressBar;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.StatusMessage;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;

public class SendDoctorsNotificationActivity extends AppCompatActivity {
    @BindView(R.id.cardSubmit)
    CardView cardSubmit;
    @BindView(R.id.ed_body)
    EditText ed_body;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notification);
        ButterKnife.bind(this);
        cardSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body = ed_body.getText().toString().trim();
                if (body.length() > 0) {
                    MyProgressBar.with(context);
                    Api.getInstance().notice_add_by_user_type(TOKEN, "d", body, new ApiListener.NotificationPostListener() {
                        @Override
                        public void onNotificationPostSuccess(StatusMessage list) {
                            MyProgressBar.dismiss();
                            if (list != null) {
                                Toast.makeText(context, list.getMessage(), Toast.LENGTH_SHORT).show();
                                onBackPressed();
                            } else {
                                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNotificationPostFailed(String msg) {
                            MyProgressBar.dismiss();

                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
