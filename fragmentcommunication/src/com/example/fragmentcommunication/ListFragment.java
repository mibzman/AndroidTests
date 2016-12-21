package com.example.fragmentcommunication;

/**
 * Created by Sam on 5/27/2015.
 */




import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment implements OnItemClickListener
{

    private View v;

    private static ListView lvOne;

    private List<String> listOfDistricts;

    private ArrayAdapter<String> adapter;

    ListItemSelectedListener itemListerner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        inflater = (LayoutInflater)getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.fragment_list_fragment, null, false);

        addListItemsToListView();

        initializeListeners();

        return v;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        itemListerner = (ListItemSelectedListener)activity;
    }

    private void addListItemsToListView()
    {
        lvOne = (ListView) v.findViewById(R.id.list);
        listOfDistricts = new ArrayList<String>();
        listOfDistricts.add("waaaa");
        listOfDistricts.add("doooo");
        listOfDistricts.add("waaaaaaaaap");
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listOfDistricts);
        lvOne.setAdapter(adapter);
    }

    private void initializeListeners()
    {
        lvOne.setOnItemClickListener(this);
    }

    public interface ListItemSelectedListener
    {
        public void listItemSelectedListener(String name);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        itemListerner.listItemSelectedListener(listOfDistricts.get(position));
    }

}