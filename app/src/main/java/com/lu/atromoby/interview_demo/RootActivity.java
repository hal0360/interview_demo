package com.lu.atromoby.interview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lu.atromoby.interview_demo.interfaces.CmdView;


public abstract class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }


    protected final void clicked(int id, CmdView cmd){
        findViewById(id).setOnClickListener(cmd::exec);
    }

    protected final void clicked(View v, CmdView cmd){
        v.setOnClickListener(cmd::exec);
    }

    public final void pushActivity(Class actClass){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
    }

    protected void alert(String mess){
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }

    public final void toActivity(Class actClass){
        Intent intent = new Intent(this, actClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }
}
