package com.dev.moneykeeper.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.dev.moneykeeper.R;
import com.dev.moneykeeper.callback.SlidingMenuClickCallback;

import java.util.ArrayList;
import java.util.List;

public class SlidingMenuFragment extends SherlockFragment implements AdapterView.OnItemClickListener {

    private static final String TAG = "SlidingMenuFragment";

    ListView slidingMenuList;

    List<SlidingMenuCustomItem> slidingMenuItems;

    // callback for changing pages
    SlidingMenuClickCallback slidingMenuClickCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        slidingMenuClickCallback = (SlidingMenuClickCallback)activity;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO replace menu items to resources

        slidingMenuItems = new ArrayList<SlidingMenuCustomItem>();
        slidingMenuItems.add(new SlidingMenuCustomItem("Hello World", R.drawable.ic_launcher));
        slidingMenuItems.add(new SlidingMenuCustomItem("About", R.drawable.ic_launcher));
        slidingMenuItems.add(new SlidingMenuCustomItem("Input", R.drawable.ic_launcher));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.sliding_menu, null);
        slidingMenuList = (ListView) root.findViewById(R.id.sliding_menu_list);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        SlidingMenuCustomAdapter adapter = new SlidingMenuCustomAdapter(getActivity(),
                R.layout.sliding_menu_row, slidingMenuItems);

        slidingMenuList.setAdapter(adapter);

    }


    @Override
    public void onResume() {
        super.onResume();
        slidingMenuList.setOnItemClickListener(this); // assign itemclick listener
    }

    @Override
    public void onPause() {
        super.onPause();
        slidingMenuList.setOnItemClickListener(null); // clear listener, prevent memory leak
    }

    @Override
    public void onDestroy() {
        // TODO clear all resources

        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, String.format("onItemClick, position = %d", position));
        slidingMenuClickCallback.OnSlidingMenuClick(position);
    }

    private class SlidingMenuCustomItem {
        public String title;
        public int iconRes;

        public SlidingMenuCustomItem(String title, int iconRes) {
            this.title = title;
            this.iconRes = iconRes;
        }
    }

    public class SlidingMenuCustomAdapter extends ArrayAdapter<SlidingMenuCustomItem> {


        public SlidingMenuCustomAdapter(Context context, int resource, List<SlidingMenuCustomItem> objects) {
            super(context, resource, objects);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.sliding_menu_row, null);
            }
            ImageView icon = (ImageView) convertView.findViewById(R.id.sliding_menu_row_icon);
            icon.setImageResource(getItem(position).iconRes);
            TextView title = (TextView) convertView.findViewById(R.id.sliding_menu_row_title);
            title.setText(getItem(position).title);

            return convertView;
        }

    }
}
