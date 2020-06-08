package com.example.dell.myapplication;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dell.myapplication.GongZhongHaoInfo;
import com.example.dell.myapplication.R;

import java.util.List;

public class MyBaseNetQuiclAdapyer extends BaseQuickAdapter<GongZhongHaoInfo.DataBean, BaseViewHolder> {
    public MyBaseNetQuiclAdapyer(@Nullable List<GongZhongHaoInfo.DataBean> data) {
        super(R.layout.activity_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GongZhongHaoInfo.DataBean item) {
        helper.setText(R.id.item_tv,item.getName());
    }
}
