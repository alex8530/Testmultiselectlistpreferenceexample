package com.example.testmultiselectlistpreferenceexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorItemViewHolder> {

    public static final String TAG = "ColorsAdapter";

    private Context mContext;
    private List<ColorItem> arrayListItem;
    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private int positionSelected;

    public ColorsAdapter(Context mContext
            , List<ColorItem> arrayListItem
    ) {
        this.mContext = mContext;
        this.arrayListItem = arrayListItem;
        positionSelected = -1;

        layoutInflater = LayoutInflater.from(this.mContext);
    }


    @NonNull
    @Override
    public ColorItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = layoutInflater.inflate(R.layout.color_item, parent, false);

        return new ColorItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorItemViewHolder ColorItemViewHolder, int position) {
        ColorItemViewHolder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return arrayListItem.size();
    }


    public void add(int index, ColorItem item) {
        if (item == null || index > arrayListItem.size()) {
            return;
        }
        this.arrayListItem.add(index, item);
        notifyItemInserted(index);
        notifyDataSetChanged();
    }

    public void add(ColorItem item) {
        if (item == null) {
            return;
        }
        int lastItemIndex = this.arrayListItem.size();
        this.arrayListItem.add(item);
        notifyItemInserted(lastItemIndex);
        notifyDataSetChanged();
    }

    public void addAll(List<ColorItem> arrayListItem) {
        if (arrayListItem == null || arrayListItem.size() == 0) {
            return;
        }
        int lastItemIndex = this.arrayListItem.size();
        this.arrayListItem.addAll(arrayListItem);
        notifyItemRangeInserted(lastItemIndex, arrayListItem.size());

    }

    public void clear() {
        arrayListItem.clear();
        notifyDataSetChanged();
    }

    public ColorItem getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }
        return arrayListItem.get(position);
    }

    public List<ColorItem> getAllCategories() {
        return arrayListItem;
    }

    public int getPositionSelected() {
        return positionSelected;
    }

    public void setPositionSelected(int positionSelected) {
        this.positionSelected = positionSelected;
    }


    class ColorItemViewHolder extends RecyclerView.ViewHolder {

        private TextView colorNameTextView;

        public ColorItemViewHolder(@NonNull View itemView) {
            super(itemView);

            colorNameTextView = itemView.findViewById(R.id.colorNameTextView);
        }

        public void onBind(final int position) {
            ColorItem ColorItem = arrayListItem.get(position);
            if (ColorItem == null) {
                return;
            }

            colorNameTextView.setText(ColorItem.getColorName());

        }
    }
}