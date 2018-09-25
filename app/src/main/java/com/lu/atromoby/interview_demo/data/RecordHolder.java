package com.lu.atromoby.interview_demo.data;

import android.content.Intent;
import android.widget.TextView;

import com.lu.atromoby.interview_demo.MapsActivity;
import com.lu.atromoby.interview_demo.R;
import com.lu.atromoby.interview_demo.models.Record;
import com.lu.atromoby.interview_demo.tools.CollectionView;
import com.lu.atromoby.interview_demo.tools.Item;
import com.lu.atromoby.interview_demo.tools.ItemHolder;

public class RecordHolder extends ItemHolder {

    private TextView area, serveTime, name, address;
    private Record record;

    public RecordHolder(CollectionView cv) {
        super(cv, R.layout.carpark_card);
        area = findView(R.id.parkArea);
        serveTime = findView(R.id.serveTime);
        name = findView(R.id.parkName);
        address = findView(R.id.address);

        clicked(card, ()->{
            Intent i = new Intent(context, MapsActivity.class);
            i.putExtra("thisRec", this.record);
            context.startActivity(i);
        });
    }

    @Override
    public void init(Item item) {
        area.setText(item.record.AREA);
        serveTime.setText(item.record.SERVICETIME);
        name.setText(item.record.NAME);
        address.setText(item.record.ADDRESS);
        this.record = item.record;
    }

    @Override
    public void cleanUp() {

    }
}
