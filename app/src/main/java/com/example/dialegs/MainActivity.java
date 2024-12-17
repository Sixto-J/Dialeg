package com.example.dialegs;

import static android.app.PendingIntent.getActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new StartGameDialogFragment().show(getSupportFragmentManager(), "GAME_DIALOG");



    }

    public static class StartGameDialogFragment extends DialogFragment {




        /*@Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction.
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_start_game)
                    .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // START THE GAME!
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancels the dialog.
                        }
                    });
            // Create the AlertDialog object and return it.
            return builder.create();
        }*/


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            ArrayList selectedItems = new ArrayList();  // Where we track the selected items
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Set the dialog title.
            builder.setTitle(R.string.pick_toppings)
                    // Specify the list array, the items to be selected by default (null for
                    // none), and the listener through which to receive callbacks when items
                    // are selected.
                    .setMultiChoiceItems(R.array.toppings, null,
                            new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which,
                                                    boolean isChecked) {
                                    if (isChecked) {
                                        // If the user checks the item, add it to the selected
                                        // items.
                                        selectedItems.add(which);
                                        Log.i("TAG"," AFEGINT, which:"+which+" y el tamany de selecteditems es: "+selectedItems.size());

                                    } else if (selectedItems.contains(which)) {
                                        // If the item is already in the array, remove it.
                                        Log.i("TAG","ANTES, which:"+which+" y el tamany de selecteditems es: "+selectedItems.size());
                                        selectedItems.remove(which);
                                        Log.i("TAG","DESPUES, which:"+which+" y el tamany de selecteditems es: "+selectedItems.size());


                                    }
                                }
                            })
                    // Set the action buttons
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // User taps OK, so save the selectedItems results
                            // somewhere or return them to the component that opens the
                            // dialog.

                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            return builder.create();
        }









    }

}