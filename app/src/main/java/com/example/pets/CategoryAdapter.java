package com.example.pets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {
    Context context;
    ArrayList<Category_class> category_List = new ArrayList<Category_class>();

    public CategoryAdapter(Context context, ArrayList<Category_class> category_List) {
        // adapter constructor
        this.context = context;
        this.category_List = category_List;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // prepare our views which will shoe data
        View view = LayoutInflater.from(context).inflate(R.layout.category_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        // here we put data in its views
        holder.text.setText(category_List.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        // get number of items inside our array
        return category_List.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        // inside this class we put (catch) views from category_row xml file
        TextView text;
        CardView card;
        ImageView img;
        public Holder(@NonNull final View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.cat_card);
            text = itemView.findViewById(R.id.text_cat);
            img = itemView.findViewById(R.id.img_arrow);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"just click",Toast.LENGTH_SHORT).show();

                    if (img.getDrawable().equals(R.drawable.down_arrow)) {
                        img.setImageResource(R.drawable.up_arrow);
                        Toast.makeText(itemView.getContext(),"inside if",Toast.LENGTH_SHORT).show();
                    } else {
                        img.setImageResource(R.drawable.down_arrow);
                        Toast.makeText(itemView.getContext(),"inside else",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}
