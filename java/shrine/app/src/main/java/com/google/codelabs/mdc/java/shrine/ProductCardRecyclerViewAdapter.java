package com.google.codelabs.mdc.java.shrine;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.codelabs.mdc.java.shrine.network.ImageRequester;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<ProductEntry> productList;
    private ImageRequester imageRequester;

    ProductCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shr_product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

//    This method code tells our RecyclerView's adapter what to do with each card, using a ViewHolder.
//    Here it sets the text data on each of the ViewHolder's TextViews, and calls an ImageRequester to get an image from a URL.
//    The ImageRequester is a class we've provided for your convenience, and it uses the Volley library
//            (That's a topic outside the scope of this codelab, but feel free to explore the code on your own).
    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
       if(productList != null && position < productList.size()) {
           ProductEntry product = productList.get(position);
           holder.productTitle.setText(product.title);
           holder.productPrice.setText(product.price);
           imageRequester.setImageFromUrl(holder.productImage, product.url);
       }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
