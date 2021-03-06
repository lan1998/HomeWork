package com.example.dell.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dell.myapplication.ArticalInfo2;
import com.example.dell.myapplication.Constants;
import com.example.dell.myapplication.GsonUtil;
import com.example.dell.myapplication.R;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MultiPulit2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        init();

    }

    private void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MultiPulit2Activity.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MultiPulit2Activity.this, LinearLayoutManager.VERTICAL));

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS).
                readTimeout(10, TimeUnit.SECONDS);
        Request.Builder request = new Request.Builder().url(Constants.ARTICAL_URL);
        Call call = builder.build().newCall(request.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "获取数据失败" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr = response.body().string();
                ArticalInfo2 articalInfo = GsonUtil.str2Bean(jsonStr, ArticalInfo2.class);
                final ArticalInfo2.DataBean data = articalInfo.getData();
                final List<ArticalInfo2.DataBean.DatasBean> datas = data.getDatas();
                for (int i = 0; i < datas.size(); i++) {
                    ArticalInfo2.DataBean.DatasBean datasBean = datas.get(i);
                    if (i == 0) {
                        datasBean.setType(ArticalInfo2.DataBean.DatasBean.MULTI_3);
                    } else if (i % 2 == 0) {
                        datasBean.setType(ArticalInfo2.DataBean.DatasBean.MULTI_1);
                    } else {
                        datasBean.setType(ArticalInfo2.DataBean.DatasBean.MULTI_2);
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MultiQuick2Adapter adapter = new MultiQuick2Adapter(MultiPulit2Activity.this, datas);
                        mRecyclerView.setAdapter(adapter);
                    }
                });
            }
        });


    }
}
