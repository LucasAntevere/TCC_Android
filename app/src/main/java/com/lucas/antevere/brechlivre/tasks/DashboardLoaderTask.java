package com.lucas.antevere.brechlivre.tasks;

import android.os.AsyncTask;

import com.lucas.antevere.brechlivre.contracts.Dashboard;
import com.lucas.antevere.brechlivre.DashboardActivity;
import com.lucas.antevere.brechlivre.service.DashboardService;

public class DashboardLoaderTask extends AsyncTask<Void, Void, Dashboard> {

    private DashboardActivity mActivity;

    public DashboardLoaderTask(DashboardActivity a){
        mActivity = a;
    }

    @Override
    protected Dashboard doInBackground(Void... params) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DashboardService dashService = new DashboardService();
        return dashService.Get();
    }

    @Override
    protected void onPreExecute() {
        mActivity.setLoading(true);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Dashboard dashboard) {
        mActivity.setLoading(false);

        mActivity.loadFeaturedCards(dashboard.getFeaturedCards());
        mActivity.loadCategories(dashboard.getCategories());
        mActivity.loadCarrousels(dashboard.getCarrousels());


        super.onPostExecute(dashboard);
    }
}
