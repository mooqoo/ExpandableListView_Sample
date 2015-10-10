package study.com.expanableview.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import study.com.expanableview.Model.ChildObject;
import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/6/15.
 */
public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ViewHolder>{
    public static final String TAG = "RecyclerChildAdapter";
    public List<ChildObject> childObjects;

    //Constructor
    public ChildRecyclerAdapter(List<ChildObject> childObjects) {
        this.childObjects = childObjects;
        Log.i(TAG,"MyRecyclerAdapter Constructor: childObjects size = " + childObjects.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_child, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, childObjects);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(TAG,"onBindViewHolder: childObjects.get(position).getName() = " + childObjects.get(position).getName());
        holder.tv_child_name.setText(childObjects.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return childObjects.size();
    }

    //ViewHolder Class
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        List<ChildObject> childObjects;

        @Bind(R.id.tv_child_name) TextView tv_child_name;

        //Constructor
        public ViewHolder(View view, List<ChildObject> childObjects) {
            super(view);
            ButterKnife.bind(this, view);
            this.childObjects = childObjects;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Click: item " + childObjects.get(getPosition()).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}