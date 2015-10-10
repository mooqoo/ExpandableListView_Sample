package study.com.expanableview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import study.com.expanableview.Adapter.ViewPagerAdapter;
import study.com.expanableview.Model.ChildObject;
import study.com.expanableview.Model.ParentObject;
import study.com.expanableview.Widget.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = "main";

    //global variables
    ViewPagerAdapter adapter_viewPager;
    String[] tabName = {"Name1","Name2", "Name3"};

    //Data to display
    List<ParentObject> parentList = new ArrayList<ParentObject>();

    //View
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.pager) ViewPager viewPager;
    @Bind(R.id.tabs) SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init data for expandable view
        initData();

        //Bind View
        ButterKnife.bind(this);

        //setup toolbar
        setupToolbar();

        //setup sliding tab
        setupSlidingTab();
    }

    private void setupToolbar() {
        //find the toolbar and setting it as the Toolbar for the activity
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupSlidingTab() {
        // Creating The ViewPagerAdapter and Passing Fragment Manager, and tabName
        adapter_viewPager =  new ViewPagerAdapter(getSupportFragmentManager(),tabName);

        // Assigning ViewPager View and setting the adapter
        //viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter_viewPager);

        // Assiging the Sliding Tab Layout View
        //tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });
        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);
    }

    private void initData() {
        //Create the Parent Data List first
        parentList.add(new ParentObject("Parent 1"));
        parentList.add(new ParentObject("Parent 2"));
        parentList.add(new ParentObject("Parent 3"));

        //add child lsit to Parent
        for(ParentObject parent: parentList)    {
            int childNum = new Random().nextInt(6)+2;
            for(int i=0; i<childNum; i++)   {
                parent.addChild(new ChildObject("child " + i));
            }
        }
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

    //getter
    public List<ParentObject> getParentList() {
        return parentList;
    }
}
