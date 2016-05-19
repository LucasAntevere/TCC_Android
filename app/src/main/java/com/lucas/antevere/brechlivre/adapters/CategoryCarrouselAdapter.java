package com.lucas.antevere.brechlivre.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lucas.antevere.brechlivre.contracts.Category;
import com.lucas.antevere.brechlivre.BaseActivity;
import com.lucas.antevere.brechlivre.R;

import java.util.List;

public class CategoryCarrouselAdapter extends RecyclerView.Adapter<CategoryCarrouselAdapter.ViewHolder>{
    private List<Category> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageButton mImageButton;
        public TextView mTitle;
        public ViewGroup mParent;

        public ViewHolder(View v, ViewGroup parent) {
            super(v);
            v.setOnClickListener(this);
            mTitle = (TextView) v.findViewById(R.id.category_item_title);
            mImageButton = (ImageButton) v.findViewById(R.id.category_item_button);
            mParent = parent;

            mImageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v, "Abrir categoria", Snackbar.LENGTH_SHORT).show();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CategoryCarrouselAdapter(List<Category> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoryCarrouselAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, parent);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(mDataset.get(position).getName());

        try {
            int iconID = holder.mParent.getResources().getIdentifier(mDataset.get(position).getIconName(), "drawable", BaseActivity.class.getPackage().getName());
            Drawable icon = holder.mParent.getResources().getDrawable(iconID);
            icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            holder.mImageButton.setImageDrawable(icon);
        }catch (Exception ex){

        }

        //holder.mImageButton.getBackground().setColorFilter(Color.parseColor(mDataset.get(position).getColor()), PorterDuff.Mode.MULTIPLY);

        GradientDrawable back  = (GradientDrawable)holder.mImageButton.getBackground();
        back.setStroke(5, Color.WHITE);
        back.setColor(Color.parseColor(mDataset.get(position).getColor()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
