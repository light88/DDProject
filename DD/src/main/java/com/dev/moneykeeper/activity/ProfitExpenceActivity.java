package com.dev.moneykeeper.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dev.moneykeeper.R;
import com.dev.moneykeeper.db.beans.Currency;
import com.dev.moneykeeper.db.dao.CurrencyDao;
import com.dev.moneykeeper.view.adapter.CurrencySpinnerAdapter;

import java.util.List;

/**
 * Created by light on 10/26/13.
 */
public class ProfitExpenceActivity extends SherlockActivity {

    CurrencyDao currencyDao;
    Context mContext;

    Button mAddCurrencyButton;
    Button mSaveButton;
    Button mCancelButton;
    EditText mAmount;
    Spinner mCurrencySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        setTitle("Profits");
        setContentView(R.layout.profit_expence_activity);

        getSherlock().getActionBar().setDisplayHomeAsUpEnabled(true);

        currencyDao = new CurrencyDao(mContext);


        initViews();
    }



    private void initViews(){
        mAddCurrencyButton = (Button) findViewById(R.id.add_currency_btn);
        mAddCurrencyButton.setOnClickListener(addCurrencyListener);

        mSaveButton = (Button) findViewById(R.id.save);
        mCancelButton = (Button) findViewById(R.id.cancel);
        mAmount = (EditText) findViewById(R.id.amount);
        mCurrencySpinner = (Spinner) findViewById(R.id.spinner_currency);

        initCurrencySpinner(mCurrencySpinner);
    }

    List<Currency> mCurrencyList;
    CurrencySpinnerAdapter mCurrencySpinnerAdapter;

    private void initCurrencySpinner(Spinner currencySpinner) {

        mCurrencyList = currencyDao.getAll();
        mCurrencySpinnerAdapter = new CurrencySpinnerAdapter(mContext, R.layout.currency_spinner_item, mCurrencyList);
        currencySpinner.setAdapter(mCurrencySpinnerAdapter);
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

    View.OnClickListener addCurrencyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder alert = new AlertDialog.Builder(mContext);

            alert.setTitle("Title");
            alert.setMessage("Message");

            // Set an EditText view to get user input
            final EditText input = new EditText(mContext);
            alert.setView(input);

            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String value = input.getText().toString();

                    if(!TextUtils.isEmpty(value)){
                        Currency currency = new Currency();
                        currency.setName(value);
                        currency.setDescription("descritption  wrhgjrst jf");

                        currencyDao.add(currency);

                        mCurrencyList.clear();
                        mCurrencyList.addAll(currencyDao.getAll());
                        mCurrencySpinnerAdapter.notifyDataSetChanged();

                    }

                    // Do something with value!
                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                }
            });

            alert.show();

        }
    };

    View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO persist data
        }
    };

    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ProfitExpenceActivity.this.finish();
        }
    };

    private void persist(){

    }

}
