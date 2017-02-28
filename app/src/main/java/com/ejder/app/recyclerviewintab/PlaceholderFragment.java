package com.ejder.app.recyclerviewintab;

/**
 * Created by ejder on 27.02.2017.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejder.app.recyclerviewintab.dummy.DummyContent;
import com.ejder.app.recyclerviewintab.dummy.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static FragmentManager mFragmentManager;
    private boolean mTwoPane;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;

        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView, boolean twoPane) {

        List<DummyItem> items = new ArrayList<DummyItem>(DummyContent.ITEM_MAP.values());

        SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter(items, twoPane, mFragmentManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        if (rootView.findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }

        View recyclerView = rootView.findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView, mTwoPane);

        return rootView;
    }
}