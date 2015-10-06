package study.com.expanableview.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/6/15.
 */
public class MyParentViewHolder extends ParentViewHolder {
    public TextView tv_parent_name;

    //Constructor
    public MyParentViewHolder(View itemView) {
        super(itemView);
        tv_parent_name = (TextView) itemView.findViewById(R.id.tv_parent_name);
    }
}
