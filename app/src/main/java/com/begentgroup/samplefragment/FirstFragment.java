package com.begentgroup.samplefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String KEY_MESSAGE = "message";
    public static final String KEY_AGE = "age";

    public static FirstFragment newInstance(String message, int age) {
        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString(KEY_MESSAGE, message);
        b.putInt(KEY_AGE, age);
        f.setArguments(b);
        return f;
    }


    public FirstFragment() {
        // Required empty public constructor
    }

    String message;
    int age;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null) {
            message = b.getString(KEY_MESSAGE);
            age = b.getInt(KEY_AGE);
        }
    }

    TextView messageView;
    EditText inputView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        messageView = (TextView)view.findViewById(R.id.text_message);
        messageView.setText(message);
        inputView = (EditText)view.findViewById(R.id.edit_input);
        Button btn = (Button)view.findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageView.setText(inputView.getText().toString());
            }
        });

        btn = (Button)view.findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OtherActivity.class));
            }
        });
        return view;
    }

}
