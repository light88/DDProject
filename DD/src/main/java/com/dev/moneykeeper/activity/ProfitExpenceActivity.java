package com.dev.moneykeeper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

/**
 * Created by light on 10/26/13.
 */
public class ProfitExpenceActivity extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Profits");
        setContentView(R.layout.profit_expence_activity);

        getSherlock().getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                ProfitExpenceActivity.this.finish();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
