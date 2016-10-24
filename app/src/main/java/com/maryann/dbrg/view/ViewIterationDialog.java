package com.maryann.dbrg.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.maryann.dbrg.R;
import com.maryann.dbrg.model.Iteration;
import com.maryann.dbrg.model.SpIterationModel;

import java.util.List;

import static com.maryann.dbrg.util.DateUtil.DATE_FORMAT;

/**
 * Created by Rufo on 10/23/2016.
 */
public abstract class ViewIterationDialog extends Dialog implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    public Activity m;
    private Spinner spIteration;
    private EditText etStartDate;
    private EditText etEndDate;
    private EditText etIterationCount;

    public ViewIterationDialog(Activity activity) {
        super(activity);
        this.m = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iteration_dialog_layout);
        setTitle(m.getString(R.string.view_iteration));
        setCancelable(false);

        // init components
        EditText etIteration = (EditText) findViewById(R.id.et_iteration);
        spIteration = (Spinner) findViewById(R.id.sp_iteration);
        etStartDate = (EditText) findViewById(R.id.et_start_date);
        etEndDate = (EditText) findViewById(R.id.et_end_date);
        etIterationCount = (EditText) findViewById(R.id.et_iteration_count);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel_iteration);
        Button btnRemove = (Button) findViewById(R.id.btn_remove);

        // setUp visibility
        etIteration.setVisibility(View.GONE);
        spIteration.setVisibility(View.VISIBLE);
        btnRemove.setVisibility(View.VISIBLE);

        // setUp components data display
        spIteration.setAdapter(new ArrayAdapter<>(
                m, android.R.layout.simple_spinner_dropdown_item, setUpSpIterations()));

        // setup listener
        spIteration.setOnItemSelectedListener(this);
        btnCancel.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_remove:
                final SpIterationModel selectedIteration = (SpIterationModel) spIteration.getSelectedItem();
                new AlertDialog.Builder(m)
                        .setMessage(m.getString(R.string.confirm_remove, selectedIteration))
                        .setCancelable(false)
                        .setPositiveButton(m.getString(R.string.remove), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogIn, int which) {
                                dismiss();
                                setRemoveOnClickAction(selectedIteration.getIteration());
                            }
                        })
                        .setNegativeButton(m.getString(R.string.cancel), null)
                        .show();
            default:
                dismiss();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final SpIterationModel selectedIteration = (SpIterationModel) spIteration.getSelectedItem();
        Iteration iteration = setUpIteration(selectedIteration.getIteration());

        etStartDate.setText(DateFormat.format(DATE_FORMAT, iteration.getStartDate()));
        etEndDate.setText(DateFormat.format(DATE_FORMAT, iteration.getEndDate()));
        etIterationCount.setText(m.getString(R.string.format_iteration, iteration.getReadCount(), iteration.getMissedCount(), iteration.getIterationCount()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // intentionally blank
    }

    public abstract void setRemoveOnClickAction(Integer iteration);

    public abstract List<SpIterationModel> setUpSpIterations();

    public abstract Iteration setUpIteration(Integer selectedIteration);
}
