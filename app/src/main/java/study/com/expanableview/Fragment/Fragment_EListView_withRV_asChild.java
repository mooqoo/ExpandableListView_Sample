package study.com.expanableview.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import study.com.expanableview.Adapter.E_ListAdapter_withRV_asChild;
import study.com.expanableview.MainActivity;
import study.com.expanableview.Model.ParentObject;
import study.com.expanableview.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link Fragment_EListView_withRV_asChild#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_EListView_withRV_asChild extends Fragment {

    //View
    @Bind(R.id.elv) ExpandableListView elv;

    //Data
    List<ParentObject> parentList;
    //Adapter
    E_ListAdapter_withRV_asChild adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment_Tab1.
     */
    public static Fragment_EListView_withRV_asChild newInstance() {
        Fragment_EListView_withRV_asChild fragment = new Fragment_EListView_withRV_asChild();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_EListView_withRV_asChild() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        //get parentList;
        parentList = ((MainActivity)getActivity()).getParentList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elistview_withrv_aschild, container, false);

        //bind view with butterknife
        ButterKnife.bind(this, view);

        //setupData();
        setupExpandableListViewWithRecyclerViewChild();

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void setupExpandableListViewWithRecyclerViewChild() {
        // declare adapter
        adapter = new E_ListAdapter_withRV_asChild(getActivity(), parentList);
        elv.setAdapter(adapter);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), "Child is clicked", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //Toast.makeText(getApplicationContext(), "Group is Clicked", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        elv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO: Do your stuff
                //Toast.makeText(getApplicationContext(), "Child is Collapsed", Toast.LENGTH_LONG).show();
            }
        });

        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO: Do your stuff
                //Toast.makeText(getApplicationContext(), "Child is Expanded", Toast.LENGTH_LONG).show();
            }
        });
    }
}
