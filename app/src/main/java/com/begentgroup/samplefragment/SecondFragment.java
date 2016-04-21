package com.begentgroup.samplefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    ListView listView;
    ArrayAdapter<String> mAdatper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        listView = (ListView)view.findViewById(R.id.listView);
        mAdatper = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdatper);

        initData();
        return view;
    }

    private void initData() {
        for (int i = 0 ; i < 40; i++) {
            mAdatper.add("item " + i);
        }
    }

}
