package com.maryann.dbrg.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.maryann.dbrg.R;
import com.maryann.dbrg.model.Iteration;

import static com.maryann.dbrg.util.DateUtil.DATE_FORMAT;

/**
 * Created by Rufo on 10/23/2016.
 */
public class ViewIterationDialog extends Dialog implements View.OnClickListener {

    private Activity m;
    private Iteration currentIteration;

    public ViewIterationDialog(Activity activity, Iteration currentIteration) {
        super(activity);
        this.m = activity;
        this.currentIteration = currentIteration;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iteration_dialog_layout);
        setTitle(m.getString(R.string.view_iteration));
        setCancelable(false);

        // init components
        EditText etIteration = (EditText) findViewById(R.id.et_iteration);
        EditText etStartDate = (EditText) findViewById(R.id.et_start_date);
        EditText etEndDate = (EditText) findViewById(R.id.et_end_date);
        EditText etIterationCount = (EditText) findViewById(R.id.et_iteration_count);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel_iteration);
        Button btnOk = (Button) findViewById(R.id.btn_ok_iteration);

        // setUp Visibility
        btnOk.setVisibility(View.GONE);

        // setUp components data display
        etIteration.setText(String.valueOf(currentIteration.getIteration()));
        etStartDate.setText(DateFormat.format(DATE_FORMAT, currentIteration.getStartDate()));
        etEndDate.setText(DateFormat.format(DATE_FORMAT, currentIteration.getEndDate()));
        etIterationCount.setText(m.getString(R.string.format_iteration, currentIteration.getReadCount(), currentIteration.getMissedCount(), currentIteration.getIterationCount()));

        // setup listener
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                dismiss();
                break;
        }
    }
}
