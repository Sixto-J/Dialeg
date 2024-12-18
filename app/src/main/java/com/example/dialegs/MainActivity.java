package com.example.dialegs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

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

        //StartGameDialogFragment sgdf = new StartGameDialogFragment();
        LoginDialogFragment ldf = new LoginDialogFragment();
        //sgdf.show(getSupportFragmentManager(), "GAME_DIALOG");
        ldf.show(getSupportFragmentManager(), "LOGIN_DIALOG");


    }

    public static class StartGameDialogFragment extends DialogFragment {

    }

    public static class LoginDialogFragment extends DialogFragment{

        @Override
        public Dialog onCreateDialog (Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater.
            LayoutInflater inflater = requireActivity().getLayoutInflater();

            // Inflate and set the layout for the dialog.
            // Pass null as the parent view because it's going in the dialog layout.
            builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                    // Add action buttons
                    .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // Sign in the user.
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            LoginDialogFragment.this.getDialog().cancel();
                        }
                    });
            return builder.create();
        }
    }





/*


        @Override
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



---------------------------



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
                                        Log.i("TAG", " AFEGINT, which:" + which + " y el tamany de selecteditems es: " +
                                                selectedItems.size());

                                        imprimirlista(selectedItems);
                                    } else if (selectedItems.contains(which)) {
                                        // If the item is already in the array, remove it.
                                        Log.i("TAG", "ANTES, which:" + which + " y el tamany de selecteditems es: " + selectedItems.size());
                                        int posicion = selectedItems.indexOf(which);

                                        selectedItems.remove(posicion);
                                        Log.i("TAG", "DESPUES, which:" + which + " y el tamany de selecteditems es: " + selectedItems.size());

                                        imprimirlista(selectedItems);
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

        private void imprimirlista(ArrayList selectedI) {

            for (int i = 0; i < selectedI.size(); i++) {
                Log.i("TAG", "Selected items: " + selectedI.get(i));
            }







        }



        */


        }




