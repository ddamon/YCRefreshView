package org.yczbj.ycrefreshview.five;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;


import com.yc.cn.ycbannerlib.first.util.SizeUtil;

import org.yczbj.ycrefreshview.other.DataProvider;
import org.yczbj.ycrefreshview.R;
import org.yczbj.ycrefreshviewlib.YCRefreshView;
import org.yczbj.ycrefreshviewlib.item.DividerViewItemLine;


public class FiveMultiStyleActivity extends AppCompatActivity {

    private YCRefreshView recyclerView;
    private PersonWithAdAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_view);
        recyclerView = (YCRefreshView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setProgressView(R.layout.view_custom_loading_data);
        DividerViewItemLine itemDecoration = new DividerViewItemLine(Color.GRAY, SizeUtil.dip2px(this,0.5f), SizeUtil.dip2px(this,72),0);
        recyclerView.addItemDecoration(itemDecoration);
        adapter = new PersonWithAdAdapter(this);
        adapter.addAll(DataProvider.getPersonWithAds(0));
        recyclerView.setAdapterWithProgress(adapter);
    }
}
