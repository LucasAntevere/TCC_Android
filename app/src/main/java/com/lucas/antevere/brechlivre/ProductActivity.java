package com.lucas.antevere.brechlivre;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.lucas.antevere.brechlivre.adapters.GalleryCarousselAdapter;
import com.lucas.antevere.brechlivre.contracts.Product;
import com.lucas.antevere.brechlivre.tasks.ProductLoaderTask;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends BaseActivity {

    public static String PRODUCT_ID_EXTRA_NAME = "product_id";
    private RecyclerView mGalleryRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarDrawerToggle(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra(PRODUCT_ID_EXTRA_NAME)){
                Toast.makeText(getApplicationContext(), intent.getStringExtra(PRODUCT_ID_EXTRA_NAME), Toast.LENGTH_SHORT).show();

                //setTitle("Harry Potter e a Criança Amaldiçoada");
                new ProductLoaderTask(this).execute(intent.getStringExtra(PRODUCT_ID_EXTRA_NAME));
            }
        }

        mGalleryRecyclerview = (RecyclerView)findViewById(R.id.product_images_recyclerview);

        List<String> urls = new ArrayList<>();
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");
        urls.add("http://d.gr-assets.com/books/1373467575l/3950967.jpg");

        showGallery(urls);
    }

    public void showProduct(Product product){

    }

    private void showGallery(List<String> urls){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mGalleryRecyclerview.setLayoutManager(manager);
        GalleryCarousselAdapter adapter = new GalleryCarousselAdapter(urls);
        mGalleryRecyclerview.setAdapter(adapter);
    }

}
