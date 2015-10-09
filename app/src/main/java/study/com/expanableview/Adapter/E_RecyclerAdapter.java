package study.com.expanableview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import study.com.expanableview.Model.ChildObject;
import study.com.expanableview.Model.ParentObject;
import study.com.expanableview.R;
import study.com.expanableview.ViewHolder.MyChildViewHolder;
import study.com.expanableview.ViewHolder.MyParentViewHolder;

/**
 * Created by mooqoo on 10/6/15.
 */
public class E_RecyclerAdapter extends ExpandableRecyclerAdapter<MyParentViewHolder, MyChildViewHolder> {
    private Context context;
    private LayoutInflater mInflater;

    public E_RecyclerAdapter(Context context, List<ParentObject> parentItemList) {
        super(parentItemList);
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_parent, viewGroup, false);
        return new MyParentViewHolder(view);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_child, viewGroup, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(MyParentViewHolder myParentViewHolder, int i, ParentListItem parentListItem) {
        ParentObject parent = (ParentObject) parentListItem;
        myParentViewHolder.tv_parent_name.setText(parent.getName());
    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder myChildViewHolder, int i, Object childListItem) {
        ChildObject child = (ChildObject)  childListItem;
        myChildViewHolder.tv_child_name.setText(child.getName());
    }
}
