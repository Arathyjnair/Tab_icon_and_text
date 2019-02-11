package com.example.user.tabicntxt;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private int[] tabIcons = {R.drawable.ic_favorite_black_24dp,R.drawable.ic_phone_black_24dp,R.drawable.ic_people_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //to come the arrow in the actionbar like(<-)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//white screen
        viewpager=(ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewpager);

        tablayout=(TabLayout) findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(viewpager);
        setupTabIcons();

    }
    private void setupTabIcons() {
        tablayout.getTabAt(0).setIcon(tabIcons[0]);
        tablayout.getTabAt(1).setIcon(tabIcons[1]);
        tablayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewpager)
    {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new oneFragment(),"ONE");
        adapter.addFragment(new TwoFragment(),"TWO");
        adapter.addFragment(new ThreeFragment(),"THREE");

        viewpager.setAdapter(adapter);
    }
    class  ViewPagerAdapter extends FragmentPagerAdapter
    {
        //LIST FOR FRAGMENTS
        private final List<Fragment> mFragmentList = new ArrayList<>();
        //TITLE FOR FRAGMENT
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment,String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
    }
}
