package study.com.expanableview.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import study.com.expanableview.R;

/**
 * Created by mooqoo on 10/6/15.
 */
public class MyChildViewHolder extends ChildViewHolder {
    public TextView tv_child_name;


    //Constructor
    public MyChildViewHolder(View itemView) {
        super(itemView);
        tv_child_name = (TextView) itemView.findViewById(R.id.tv_child_name);
    }


}
