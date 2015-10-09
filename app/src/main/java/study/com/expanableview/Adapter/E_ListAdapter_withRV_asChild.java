package study.com.expanableview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import study.com.expanableview.Model.ChildObject;
import study.com.expanableview.Model.ParentObject;
import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/3/15.
 */
public class E_ListAdapter_withRV_asChild extends BaseExpandableListAdapter {
    public static final String TAG = "ExpandableAdapter";

    //Global Varaible
    private Context context;
    private LayoutInflater infalInflater;
    private List<ParentObject> parentList;

    //Conctructor for RecyclerView child
    public E_ListAdapter_withRV_asChild(Context context, List<ParentObject> parentList) {
        this.context = context;
        this.parentList = parentList;
        infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        //Log.i(TAG,"getGroupCount = " + headerArray.size());
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        //Log.i(TAG,"getChildrenCount = " + childArray.get(this.headerArray.get(i)).size());
        return parentList.get(i).getChildListSize();
        //return 1;  //this is for recyclerChild
    }

    @Override
    public Object getGroup(int i) {
        return parentList.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return parentList.get(i).getChildItemList().get(i2);
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
        String headerTitle = ((ParentObject) getGroup(i)).getName();
        if (view == null) {
            view = infalInflater.inflate(R.layout.item_parent, null);
        }
        TextView textViewHeader = (TextView) view.findViewById(R.id.tv_parent_name);
        textViewHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        final String childText = ((ChildObject)getChild(i, i2)).getName();

        if (view == null) {
            view = infalInflater.inflate(R.layout.item_child, null);
        }

        TextView textViewChild = (TextView) view.findViewById(R.id.tv_child_name);
        textViewChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
