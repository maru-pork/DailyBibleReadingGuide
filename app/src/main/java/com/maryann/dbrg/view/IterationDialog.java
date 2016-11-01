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
import android.widget.Toast;

import com.maryann.dbrg.R;
import com.maryann.dbrg.model.Iteration;
import com.maryann.dbrg.model.SpIterationModel;

import java.util.List;

import static com.maryann.dbrg.util.DateUtil.DATE_FORMAT;

/**
 * Created by Rufo on 10/23/2016.
 */
public abstract class IterationDialog extends Dialog implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Activity m;
    private Spinner spIteration;
    private EditText etStartDate;
    private EditText etEndDate;
    private EditText etIterationCount;

    public IterationDialog(Activity activity) {
        super(activity);
        this.m = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iteration_dialog_layout);
        setTitle(m.getString(R.string.iterations));

        // init components
        EditText etIteration = (EditText) findViewById(R.id.et_iteration);
        spIteration = (Spinner) findViewById(R.id.sp_iteration);
        etStartDate = (EditText) findViewById(R.id.et_start_date);
        etEndDate = (EditText) findViewById(R.id.et_end_date);
        etIterationCount = (EditText) findViewById(R.id.et_iteration_count);
        Button btnExport = (Button) findViewById(R.id.btn_cancel_iteration);
        Button btnRemove = (Button) findViewById(R.id.btn_ok_iteration);

        // setUp visibility
        etIteration.setVisibility(View.GONE);
        spIteration.setVisibility(View.VISIBLE);

        // setUp components data display
        btnExport.setText(m.getString(R.string.export));
        btnRemove.setText(m.getString(R.string.remove));
        spIteration.setAdapter(new ArrayAdapter<>(
                m, android.R.layout.simple_spinner_dropdown_item, setUpSpIterations()));

        // setup listener
        spIteration.setOnItemSelectedListener(this);
        btnExport.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok_iteration:
                final SpIterationModel iterationToRemove = (SpIterationModel) spIteration.getSelectedItem();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(m);
                alertDialogBuilder.setMessage(m.getString(R.string.confirm_remove, iterationToRemove));
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton(m.getString(R.string.remove), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogIn, int which) {
                                dismiss();
                                setRemoveOnClickAction(iterationToRemove.getIteration());
                            }
                        });
                alertDialogBuilder.setNegativeButton(m.getString(R.string.close), null);
                if (iterationToRemove != null) {
                    alertDialogBuilder.show();
                    dismiss();
                } else {
                    Toast.makeText(m, m.getString(R.string.warning_no_selected_iteration), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancel_iteration:
                SpIterationModel iterationToExport = (SpIterationModel) spIteration.getSelectedItem();
                if (iterationToExport != null) {
                    setExportOnClickAction(iterationToExport.getIteration());
                    dismiss();
                } else {
                    Toast.makeText(m, m.getString(R.string.warning_no_selected_iteration), Toast.LENGTH_SHORT).show();
                }
                break;
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

    public abstract void setExportOnClickAction(Integer iteration);

    public abstract List<SpIterationModel> setUpSpIterations();

    public abstract Iteration setUpIteration(Integer selectedIteration);
}
