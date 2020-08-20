package com.winkcoo.medx.admin.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.Utils.MyProgressBar;
import com.winkcoo.medx.admin.Utils.doForMe;
import com.winkcoo.medx.admin.adapter.BlogCategoryListAdapterAdmin;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.BlogCategoryNameID;
import com.winkcoo.medx.admin.model.StatusMessage;
import com.winkcoo.medx.admin.widgets.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogCategoryFragments extends Fragment implements ApiListener.BlogCategoryDownloadListener {
    View view;
    Context context;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.floatingAdd)
    FloatingActionButton floatingAdd;


    public BlogCategoryFragments() {
        // Required empty public constructor
    }

    public static BlogCategoryFragments newInstance() {
        BlogCategoryFragments fragment = new BlogCategoryFragments();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_blog_category_fragments, container, false);
        ButterKnife.bind(this, view);
        context = view.getContext();
        //addBlogCategory
        downlaod();
        floatingAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //blog_category_add_dialog
                Dialog dialog= doForMe.showDialog(context,R.layout.blog_category_add_dialog);
                EditText ed_name=(EditText)dialog.findViewById(R.id.ed_name);
                CardView cardSave=(CardView) dialog.findViewById(R.id.cardSave);
                cardSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=ed_name.getText().toString().trim();
                        if (name.length()>0){
                            MyProgressBar.with(context);
                            Api.getInstance().addBlogCategory(TOKEN, name, new ApiListener.BlogCategoryPostListener() {
                                @Override
                                public void onBlogCategoryPostSuccess(StatusMessage list) {
                                    MyProgressBar.dismiss();
                                    if (list.isStatus()==true){
                                        dialog.dismiss();
                                        downlaod();

                                    }else {
                                        Toast.makeText(context, "Error Occured", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onBlogCategoryPostFailed(String msg) {
                                    MyProgressBar.dismiss();

                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }
                });

            }
        });
        return view;
    }
    public  void  downlaod(){
        Api.getInstance().BlogCategoryNameID(TOKEN, this);

    }

    @Override
    public void onBlogCategoryDownloadSuccess(List<BlogCategoryNameID> list) {
        BlogCategoryListAdapterAdmin mAdapter = new BlogCategoryListAdapterAdmin(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBlogCategoryDownloadFailed(String msg) {

    }
}
