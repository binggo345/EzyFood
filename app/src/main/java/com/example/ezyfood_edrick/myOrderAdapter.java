package com.example.ezyfood_edrick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class myOrderAdapter extends BaseAdapter {
    private final List<databaseOrder> databasesOrder;
    private final Context context;
    public myOrderAdapter(Context context, List<databaseOrder> databasesOrder) {
        this.databasesOrder = databasesOrder;
        this.context = context;
    }
    @Override
    public int getCount() {
        return databasesOrder.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final databaseOrder databaseOrder = databasesOrder.get(i);
        if(view == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.layout_myorder, null);
        }

        final ImageView MOimageView = (ImageView) view.findViewById(R.id.ImageMyOrder);
        final TextView MOnameView = (TextView) view.findViewById(R.id.nameMyorder);
        final TextView MOpriceView = (TextView) view.findViewById(R.id.priceMyOrder);
        final Button delete = (Button) view.findViewById(R.id.delete_btn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.databasesOrder.remove(i);
                ((myOrder)context).total();
                notifyDataSetChanged();
            }
        });

        MOimageView.setImageResource(databaseOrder.getImage());
        MOnameView.setText(databaseOrder.getName());
        MOpriceView.setText(databaseOrder.getPrice() + " x " + databaseOrder.getQuantity());
        return view;
    }
}
