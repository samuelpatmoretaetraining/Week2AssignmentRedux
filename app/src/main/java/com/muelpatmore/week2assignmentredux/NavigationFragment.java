package com.muelpatmore.week2assignmentredux;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment {

    private Button btnClassic, btnRock, btnPop;

    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnClassic = (Button) view.findViewById(R.id.btnClassic);
        btnRock = (Button) view.findViewById(R.id.btnRock);
        btnPop = (Button) view.findViewById(R.id.btnPop);

    }


}
