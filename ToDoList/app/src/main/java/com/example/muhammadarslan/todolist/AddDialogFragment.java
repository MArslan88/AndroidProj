package com.example.muhammadarslan.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Muhammad Arslan on 10/15/2017.
 */

public class AddDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View mainView = inflater.inflate(R.layout.dialog, null);
        final Dialog addDialog = builder.setView(mainView)
                .setTitle("To Do List")
                .setPositiveButton("Add", null)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AddDialogFragment.this.getDialog().cancel();
                    }
                })
                .create();
        addDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                Button positiveButton = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        boolean closeDialog = false;
                        EditText nameEditText = (EditText) mainView.findViewById(R.id.nameEdt);
                        EditText ageEditText = (EditText) mainView.findViewById(R.id.ageEdt);

                        String nameString = nameEditText.getText().toString().trim();
                        String ageString = ageEditText.getText().toString().trim();

                        if (TextUtils.isEmpty(nameString) || TextUtils.isEmpty(ageString)) {
                            Toast.makeText(getActivity(), "Plz fill all fields", Toast.LENGTH_SHORT).show();
                        } else {
                            int age = Integer.parseInt(ageString);
                            ToDoList student = new ToDoList(nameString, age);
                            student.save();
                            closeDialog = true;
                        }
                        if (closeDialog) {
                            addDialog.dismiss();
                        }
                    }
                });
            }
        });

        return addDialog;


    }
}
