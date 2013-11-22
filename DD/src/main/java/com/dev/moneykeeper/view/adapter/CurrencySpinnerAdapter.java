package com.dev.moneykeeper.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dev.moneykeeper.R;
import com.dev.moneykeeper.db.beans.Currency;

import java.util.List;

/**
 * Created by light on 21.11.13.
 */
public class CurrencySpinnerAdapter extends ArrayAdapter<Currency> {

    List<Currency> mData;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public CurrencySpinnerAdapter(Context context, int resource, List<Currency> objects) {
        super(context, resource, objects);

        mContext = context;
        mData = objects;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final Currency currency = mData.get(position);
        Holder holder;

        if(view == null){
            holder = new Holder();
            view = mLayoutInflater.inflate(R.layout.currency_spinner_item, null);

            holder.id = (TextView) view.findViewById(R.id.currency_id);
            holder.name = (TextView) view.findViewById(R.id.currency_name);
            holder.description = (TextView) view.findViewById(R.id.currency_description);

            boolean h = holder != null;
            boolean v = view != null;
            Log.i("NULL = ", "holder = " + h + ", view = " + v);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }


        holder.id.setText(String.valueOf(currency.getId()));
        holder.name.setText(currency.getName());
        holder.description.setText(currency.getDescription());

        return view;

        //return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final Currency currency = mData.get(position);
        Holder holder;

        if(view == null){
            holder = new Holder();
            view = mLayoutInflater.inflate(R.layout.currency_spinner_item, null);

            holder.id = (TextView) view.findViewById(R.id.currency_id);
            holder.name = (TextView) view.findViewById(R.id.currency_name);
            holder.description = (TextView) view.findViewById(R.id.currency_description);

            boolean h = holder != null;
            boolean v = view != null;
            Log.i("NULL = ", "holder = " + h + ", view = " + v);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }



        holder.id.setText(String.valueOf(currency.getId()));
        holder.name.setText(currency.getName());
        holder.description.setText(currency.getDescription());

        return view;

        //return super.getView(position, convertView, parent);
    }

    private static class Holder {
        TextView id;
        TextView name;
        TextView description;
    }
}
