package com.baidu.mapclient.liteapp.routeresult;

import android.view.View;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.szabh.navi.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class LongDistanceController implements View.OnClickListener {
    public View rootView;
    List<View> views = new ArrayList();

    public LongDistanceController(View view) {
        this.rootView = view;
        setView(R.id.city);
        setView(R.id.route);
        setView(R.id.service);
        setView(R.id.checkpoint);
        setView(R.id.weather);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setSelect(view);
        int id = view.getId();
        if (id == R.id.city) {
            BaiduNaviManagerFactory.getRouteResultManager().handleCityClick(view.isSelected());
            return;
        }
        if (id == R.id.route) {
            BaiduNaviManagerFactory.getRouteResultManager().handleRouteClick(view.isSelected());
            return;
        }
        if (id == R.id.service) {
            BaiduNaviManagerFactory.getRouteResultManager().handleServiceClick(view.isSelected());
        } else if (id == R.id.checkpoint) {
            BaiduNaviManagerFactory.getRouteResultManager().handleCheckpointClick(view.isSelected());
        } else if (id == R.id.weather) {
            BaiduNaviManagerFactory.getRouteResultManager().handleWeatherClick(view.isSelected());
        }
    }

    public void setSelect(View view) {
        for (int i = 0; i < this.views.size(); i++) {
            if (this.views.get(i).equals(view)) {
                this.views.get(i).setSelected(!this.views.get(i).isSelected());
            } else {
                this.views.get(i).setSelected(false);
            }
        }
    }

    public void setView(int i) {
        View findViewById = this.rootView.findViewById(i);
        findViewById.setOnClickListener(this);
        this.views.add(findViewById);
    }
}
