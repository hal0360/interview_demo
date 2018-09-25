package com.lu.atromoby.interview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lu.atromoby.interview_demo.global.Api;
import com.lu.atromoby.interview_demo.global.V;
import com.lu.atromoby.interview_demo.models.JsonData;
import com.lu.atromoby.interview_demo.models.Record;
import com.lu.atromoby.interview_demo.tools.CollectionView;
import com.lu.atromoby.interview_demo.tools.Item;
import com.lu.atromoby.interview_demo.tools.Popup;
import com.lu.atromoby.interview_demo.tools.RequestTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RootActivity {

    private List<Item> items;
    private CollectionView collectionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        RequestTask requestTask = new RequestTask(this, Api.GET_CARPARK_LOC, null);
        requestTask.onSuccess(r->{
            Gson gson = new Gson();
            JsonData jsonData = gson.fromJson(r.content,JsonData.class);
            setUp(jsonData.result.records);

        });
        requestTask.onFail(r->{
            alert("data fetching failed");
        });
        requestTask.fetch();

        clicked(R.id.searchButt,v->{
            Popup popup = new Popup(this, R.layout.pop_layout);
            EditText searchTxt = popup.getView(R.id.searchEdit);
            EditText filterTxt = popup.getView(R.id.filterEdit);
            popup.clicked(R.id.searchHit, ()->{
                String nameF = searchTxt.getText().toString().trim();
                List<Item> newItems = new ArrayList<>();
                for(Item item: items){
                    if(item.record.NAME.contains(nameF)){
                        newItems.add(item);
                        items = newItems;
                        collectionView.refresh(items);
                        popup.dismiss();
                        return;
                    }
                }
                alert("Not found");
                popup.dismiss();
            });

            popup.clicked(R.id.filterHit, ()->{
                String areaF = filterTxt.getText().toString().trim();
                List<Item> newItems = new ArrayList<>();


                for(Item item: items){
                    if(item.record.AREA.contains(areaF)){
                        newItems.add(item);
                    }
                }
                items = newItems;
                collectionView.refresh(items);
                popup.dismiss();
            });
            popup.show();
        });


    }

    private void setUp(List<Record> records){

        for(Record record: records){
            items.add(new Item(V.RECORD, record));
        }
        collectionView = findViewById(R.id.recordCollView);
        collectionView.init(items);

    }
}

