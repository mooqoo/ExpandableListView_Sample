package study.com.expanableview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import study.com.expanableview.Adapter.E_RecyclerAdapter;
import study.com.expanableview.MainActivity;
import study.com.expanableview.Model.ParentObject;
import study.com.expanableview.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link Fragment_ERecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_ERecyclerView extends Fragment {

    //Bind view
    @Bind(R.id.rv) RecyclerView rv;

    //data list
    List<ParentObject> parentList;
    //adapter
    E_RecyclerAdapter adapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment_Tab1.
     */
    public static Fragment_ERecyclerView newInstance() {
        Fragment_ERecyclerView fragment = new Fragment_ERecyclerView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_ERecyclerView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        //get parentList from activity
        parentList = ((MainActivity)getActivity()).getParentList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_erecyclerview, container, false);

        //bind view with butterknife
        ButterKnife.bind(this, view);

        //setup ExpandableRecyclerView
        setupExpandableRecyclerView();

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    private void setupExpandableRecyclerView() {
        //create expandable adapter
        adapter = new E_RecyclerAdapter(getActivity(), parentList);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
