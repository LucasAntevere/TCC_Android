package com.lucas.antevere.brechlivre.tasks;

import android.os.AsyncTask;

import com.lucas.antevere.brechlivre.ProductActivity;
import com.lucas.antevere.brechlivre.contracts.Product;

public class ProductLoaderTask extends AsyncTask<String, Void, Product> {

    private ProductActivity mActivity;

    public ProductLoaderTask(ProductActivity activity){
        mActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        mActivity.setLoading(true);

        super.onPreExecute();
    }

    @Override
    protected Product doInBackground(String... params) {
        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Product("1", "Título", "Descrição", "Outro");
    }

    @Override
    protected void onPostExecute(Product product) {
        mActivity.showProduct(product);
        mActivity.setLoading(false);
    }
}
