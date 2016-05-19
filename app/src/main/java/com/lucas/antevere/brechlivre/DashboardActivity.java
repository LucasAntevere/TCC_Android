package com.lucas.antevere.brechlivre;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lucas.antevere.brechlivre.adapters.CarousselAdapter;
import com.lucas.antevere.brechlivre.adapters.CategoryCarrouselAdapter;
import com.lucas.antevere.brechlivre.contracts.Carrousel;
import com.lucas.antevere.brechlivre.contracts.Category;
import com.lucas.antevere.brechlivre.tasks.DashboardLoaderTask;
import com.lucas.antevere.brechlivre.utils.CircularAnimation;

import java.util.List;

public class DashboardActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarDrawerToggle(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new DashboardLoaderTask(this).execute();
    }

    public void loadCategories(List<Category> categories){
        RecyclerView recycler = (RecyclerView) findViewById(R.id.category_carrousel_recyclerview);

        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(manager);

        CategoryCarrouselAdapter adapter = new CategoryCarrouselAdapter(categories);
        recycler.setAdapter(adapter);
    }

    public void loadCarrousels(List<Carrousel> carrousels){
        LinearLayout linearLayoutBase = (LinearLayout)findViewById(R.id.dashboard_activity_parent);
        for (Carrousel c : carrousels){
            View view = getLayoutInflater().inflate(R.layout.card_mini_caroussel, null);

            ((TextView)view.findViewById(R.id.card_mini_carrousel_title)).setText(c.getTitle());
            ((TextView)view.findViewById(R.id.card_mini_carrousel_subtitle)).setText(c.getSubtitle());

            RecyclerView recycler = (RecyclerView)view.findViewById(R.id.card_mini_caroussel_recyclerview);
            recycler.setHasFixedSize(true);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

            recycler.setLayoutManager(manager);

            final CarousselAdapter adapter = new CarousselAdapter(c.getProducts());

            recycler.setAdapter(adapter);

            linearLayoutBase.addView(view);
        }
    }

}
