package study.com.expanableview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import study.com.expanableview.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link Fragment_Tab4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Tab4 extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment_Tab1.
     */
    public static Fragment_Tab4 newInstance() {
        Fragment_Tab4 fragment = new Fragment_Tab4();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Tab4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tab4, container, false);
    }


}
