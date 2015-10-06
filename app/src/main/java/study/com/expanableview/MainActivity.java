package study.com.expanableview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import study.com.expanableview.Adapter.MyExpandableListAdapter;


public class MainActivity extends ActionBarActivity {

    //Header Group
    List<String> headersArrayList = new ArrayList<String>();
    //Child Group
    List<String> childArrayList_1 = new ArrayList<String>();
    List<String> childArrayList_2 = new ArrayList<String>();
    List<String> childArrayList_3 = new ArrayList<String>();
    //HashMap that ties Child Group to Header Group
    HashMap<String, List<String>> childArrayList = new HashMap<String, List<String>>();
    //Custom ExpandableAdapter
    MyExpandableListAdapter adapter;

    //Bind View with ButterKnife
    @Bind(R.id.elv) ExpandableListView elv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind View
        ButterKnife.bind(this);

        setupData();
        setupExpandableListView();
    }

    private void setupData() {
        //setup Header List Data
        headersArrayList.add("Parent_1");
        headersArrayList.add("Parent_2");
        headersArrayList.add("Parent_3");

        //setup Child List Data
        //Child 1
        childArrayList_1.add("Child_1_1");
        childArrayList_1.add("Child_1_2");
        childArrayList_1.add("Child_1_3");
        //Child 2
        childArrayList_2.add("Child_2_1");
        //Child 3
        childArrayList_3.add("Child_3_1");
        childArrayList_3.add("Child_3_2");

        //associate the child list with header item.
        childArrayList.put("Parent_1",childArrayList_1);
        childArrayList.put("Parent_2",childArrayList_2);
        childArrayList.put("Parent_3",childArrayList_3);
    }

    private void setupExpandableListView() {
        // declare adapter
        adapter = new MyExpandableListAdapter(this, headersArrayList, childArrayList);

        elv.setAdapter(adapter);

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Child is clicked", Toast.LENGTH_LONG).show();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
