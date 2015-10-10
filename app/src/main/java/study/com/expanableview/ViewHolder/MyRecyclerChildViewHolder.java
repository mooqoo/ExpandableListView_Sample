package study.com.expanableview.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/10/15.
 */
public class MyRecyclerChildViewHolder extends ChildViewHolder  {

    public RecyclerView rv_child;


    //Constructor
    public MyRecyclerChildViewHolder(View itemView) {
        super(itemView);
        rv_child = (RecyclerView) itemView.findViewById(R.id.rv_child);
    }
}
