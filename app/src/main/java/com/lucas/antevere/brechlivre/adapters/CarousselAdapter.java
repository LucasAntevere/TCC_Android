package com.lucas.antevere.brechlivre.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucas.antevere.brechlivre.contracts.Product;
import com.lucas.antevere.brechlivre.ProductActivity;
import com.lucas.antevere.brechlivre.R;
import com.lucas.antevere.brechlivre.tasks.DownloadImageTask;

import java.util.List;

public class CarousselAdapter extends RecyclerView.Adapter<CarousselAdapter.ViewHolder> {
    private List<Product> mDataset;

    private final int IMAGE_WIDTH = 250;
    private final int IMAGE_HEIGHT = 250;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mTitle;
        public TextView mSubtitle;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mImageView = (ImageView) v.findViewById(R.id.card_mini_image_view);
            mTitle = (TextView) v.findViewById(R.id.card_mini_title);
            mSubtitle = (TextView) v.findViewById(R.id.card_mini_subtitle);
        }

        @Override
        public void onClick(View v) {
            Intent productActivity = new Intent(v.getContext(), ProductActivity.class);
            productActivity.putExtra(ProductActivity.PRODUCT_ID_EXTRA_NAME, mDataset.get(getPosition()).getID());
            v.getContext().startActivity(productActivity);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CarousselAdapter(List<Product> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CarousselAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_mini, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        new DownloadImageTask(holder.mImageView, IMAGE_WIDTH, IMAGE_HEIGHT).execute(mDataset.get(position).getImageUrl());
        holder.mTitle.setText(mDataset.get(position).getTitle());
        holder.mSubtitle.setText(mDataset.get(position).getCategory());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
