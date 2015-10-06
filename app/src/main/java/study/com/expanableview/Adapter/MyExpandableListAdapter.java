package study.com.expanableview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import study.com.expanableview.Model.ChildObject;
import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/3/15.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    public static final String TAG = "ExpandableAdapter";

    private Context context;
    private List<String> headerArray;
    private HashMap<String, List<String>> childArray;
    private LayoutInflater infalInflater;

    //for RecyclerView child
    private HashMap<String, List<ChildObject>> childObjectArray;

    //Conctructor for RecyclerView child
    public MyExpandableListAdapter(Context context, List<String> headerArray, HashMap<String, List<ChildObject>> childObjectArray, boolean ignore) {
        this.context = context;
        this.headerArray = headerArray;
        this.childObjectArray = childObjectArray;
        infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Conctructor
    public MyExpandableListAdapter(Context context, List<String> headerArray, HashMap<String, List<String>> childArray) {
        this.context = context;
        this.headerArray = headerArray;
        this.childArray = childArray;
        infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        //Log.i(TAG,"getGroupCount = " + headerArray.size());
        return headerArray.size();
    }

    @Override
    public int getChildrenCount(int i) {
        //Log.i(TAG,"getChildrenCount = " + childArray.get(this.headerArray.get(i)).size());
        //return childArray.get(this.headerArray.get(i)).size();
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return headerArray.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return childArray.get(headerArray.get(i)).get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if (view == null) {
            view = infalInflater.inflate(R.layout.item_parent, null);
        }
        TextView textViewHeader = (TextView) view.findViewById(R.id.tv_parent_name);
        textViewHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
//        final String childText = (String) getChild(i, i2);

        //if (view == null) {
        //    view = infalInflater.inflate(R.layout.item_recycler_child, null);
            //setup recyclerview here
        //}
        view = infalInflater.inflate(R.layout.item_recycler_child, null);
        RecyclerView rv_child = (RecyclerView)view.findViewById(R.id.rv_child);
        if(rv_child==null)
            Log.e(TAG,"rv_child is NULL!!!");
        rv_child.setAdapter(new MyRecyclerAdapter(childObjectArray.get(headerArray.get(i))));
        rv_child.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        Log.i(TAG,"getChildView: childObjectArray size = " + childObjectArray.get(headerArray.get(i)).size());
        //TextView textViewChild = (TextView) view.findViewById(R.id.tv_child_name);
        //textViewChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
