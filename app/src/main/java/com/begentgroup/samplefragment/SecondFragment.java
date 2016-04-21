package com.begentgroup.samplefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    public interface OnMessageCallback {
        public void receiveMessage(String message);
    }

    OnMessageCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMessageCallback) {
            callback = (OnMessageCallback)context;
        } else {
            callback = null;
        }
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String)listView.getItemAtPosition(position);
                // ....

//                ((MainActivity)getActivity()).receiveText(text);
                if (callback != null) {
                    callback.receiveMessage(text);
                }
            }
        });

        initData();
        return view;
    }

    private void initData() {
        for (int i = 0 ; i < 40; i++) {
            mAdatper.add("item " + i);
        }
    }

}
