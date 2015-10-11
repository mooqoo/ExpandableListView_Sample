<!-- link -->
[expandable_recycler_view]:https://github.com/bignerdranch/expandable-recycler-view
[bignerdranch]:https://github.com/bignerdranch
[ExpandableListView]:http://developer.android.com/reference/android/widget/ExpandableListView.html
[SlidingTabLayout_my_sample]:https://github.com/mooqoo/SlidingTabLayout_Sample
[ExpandableListView_tutorial]:http://techlovejump.com/android-expandable-listview-tutorial/
[BaseExpandableListAdapter]:http://developer.android.com/reference/android/widget/BaseExpandableListAdapter.html
[ExpandableRecyclerView]:https://github.com/bignerdranch/expandable-recycler-view

# ExpandableListView_Sample

This project explore the different ways to create an expandable listview and how they are implemented.

In this project, I use the [ExpandableListView][ExpandableListView] provided by Android API and also [ExpandableRecyclerView][expandable_recycler_view]created by [bignerdranch][bignerdranch].

I use a SlidingTabLayout to display each expandable list inside its own Fragment. To see how to implement a SlidingTabLayout, you can take a look at my [SlidingTabLayout sample][SlidingTabLayout_my_sample].

Here's what the project looks like:
![app layout](https://cloud.githubusercontent.com/assets/6467567/10414352/ae8de1f6-7002-11e5-9b58-cc7fc9b7ba6d.png)
![app layout](https://cloud.githubusercontent.com/assets/6467567/10414354/b015fc66-7002-11e5-8dd9-3d58f5d333bc.png)


ExpandableListView
==================
[this][ExpandableListView_tutorial] is a tutorial for ExpandableListView.

xml
---
 1.    create a layout xml that contains ExpandableListView.
 2.    create a xml for the list group item for ExpandableListView.
 3.    create a xml for the list child item for each individual group of ExpandableListView.

data
----
 1.    create a list for parent group.
 2.    create a list for **each** child group.
 3.    create a new HashMap to associate each child list with its corresponding parent item.

ExpandableListAdapter
---------------------
In order to build your own Custom Expandable List Adapter, create your own adapter and extends [BaseExpandableListAdapter][BaseExpandableListAdapter].

 1.    pass data to adapter through constructor.
 2.    inflate the view for parent in **getGroupView**.
 3.    inflate the view for child in **getChildView**.
 4.    implement all the method from BaseExpandableListAdapter.

Setup ExpandavleListView
------------------------
 1.    get the ExpandavleListView instance from xml.
 2.    load/init data for ExpandableListView.
 3.    init CustomExpandableListAdapter with data.
 4.    set the adapter for ExpandavleListView.
 5.    set clickListener and collapse/expand Listener for ExpandavleListView.
 
 
ExpandableRecyclerView
======================
[ExpandableRecyclerView][ExpandableRecyclerView] is a library written to allow for an expanded view to be attached to each ViewHolder. To allow for full functionality of a normal RecyclerView, the RecyclerView has been modified to use two types of ViewHolders, a child and a parent with the ability to customize each separately.

How to use
----------
 1.   add dependencies to app's build.gradle file
 2.   create xml for parent/child list item layout
 3.   create ViewHolder for parent/child class which extends ParentViewHolder/ChildViewHolder
 4.   create ParentObject which implements the ParentListItem
 5.   create CustomExpandableRecyclerAdapter by extending ExpandableRecyclerAdapter<MyParentViewHolder, MyChildViewHolder>
 6.   get instance for RecyclerView and set the layoutManager and adapter.
