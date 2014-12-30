package com.example.osdevlab.simpletutorial;


import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by osdevlab on 12/29/14.
 */
public class FragmentOne extends Fragment {

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout with fragment_one.xml
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //create Button 'buttonPress' and link with button id from fragment_one.xml
        Button buttonPress = (Button) view.findViewById(R.id.button);

        //returns the Activity the Fragment is currently associated with
        //In Fragment, this step requires to pass context to other class.
        //see example below for context.getSystemService
        context = getActivity();

        /*define OnClickListener here*/
        buttonPress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //ConnectivityManager is the class that answers queries about the state of network connectivity
                //example here for context is context.getSystemService instead of getSystemService
                ConnectivityManager connMgr = (ConnectivityManager)
                        context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    // small popup to show the status of network connection
                    Toast.makeText(context, "Internet is connected",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(context, "Internet is not connected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
