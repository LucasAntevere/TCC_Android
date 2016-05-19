package com.lucas.antevere.brechlivre.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lucas.antevere.brechlivre.R;
import com.lucas.antevere.brechlivre.tasks.DownloadImageTask;

import java.util.List;

public class GalleryCarousselAdapter extends RecyclerView.Adapter<GalleryCarousselAdapter.ViewHolder> {
    private List<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageView mImageView;

        public ViewHolder(View v, ViewGroup parent) {
            super(v);
            v.setOnClickListener(this);
            mImageView = (ImageView)v.findViewById(R.id.gallery_item_imageview);

            mImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v, "Abrir imagem completa", Snackbar.LENGTH_SHORT).show();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GalleryCarousselAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GalleryCarousselAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item_product, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, parent);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        new DownloadImageTask(holder.mImageView).execute(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
