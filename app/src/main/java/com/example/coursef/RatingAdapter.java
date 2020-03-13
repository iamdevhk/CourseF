package com.example.coursef;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;





public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    public Context mCtx;

    //we are storing all the products in a list
    private List<ratings> productList;

    //getting the context and product list with constructor

    public RatingAdapter(Context context, List<ratings> productList) {
        this.mCtx = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_rating, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        ratings product = productList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewRating.setText(String.valueOf(product.getRating()));

    }





    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice,textViewDist,textViewmail;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.texty);

        }
    }
}

