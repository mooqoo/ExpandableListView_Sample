package study.com.expanableview.Model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooqoo on 10/6/15.
 */
public class ParentObject implements ParentListItem {
    private String name;
    private List<ChildObject> childObjectList;

    //Constructor
    public ParentObject(String name) {
        this.name = name;
        childObjectList = new ArrayList<ChildObject>();
    }

    @Override
    public List<ChildObject> getChildItemList() {
        return childObjectList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public int getChildListSize() {
        return childObjectList.size();
    }

    public void addChild(ChildObject childObject) {
        childObjectList.add(childObject);
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
