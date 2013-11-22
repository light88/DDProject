package com.dev.moneykeeper.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.dev.moneykeeper.R;

/**
 * Created by light on 10/26/13.
 */
public class InputFragment extends SherlockFragment {

    private static String mTitle = "Input";

    Context mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        activity.setTitle(mTitle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment_layout, null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.input_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.input_show: {
                Toast.makeText(mContext, "Show click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ProfitExpenceActivity.class);
                mContext.startActivity(intent);
                return true;
//                break;
            }
            case R.id.input_hide: {
                Toast.makeText(mContext, "Hide click", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
