package com.derbane.demo.kitkat.fullscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

;

public class KitKatFullscreen extends Activity {

    private ListView _liMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_kat_fullscreen);

        /*
        Initialise the UiVisibility modes
         */
        final SystemUiVisibilityBuilder builder = new SystemUiVisibilityBuilder();
        builder.add("Visible (API 14)", View.SYSTEM_UI_FLAG_VISIBLE);

        builder.add("Fullscreen (API 16)", View.SYSTEM_UI_FLAG_FULLSCREEN);
        builder.add("Hide navigation (API 14)", View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        builder.add("Actual fullscreen (Fullscreen + Hide navigation)", View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        builder.add("Low profile (API 14)", View.SYSTEM_UI_FLAG_LOW_PROFILE);

        builder.add("Immersive (API 19) + Fullscreen", View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE);
        builder.add("Immersive + Hide navigation", View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE);
        builder.add("Immersive - Actual fullscreen", View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE);


        builder.add("Immersive Sticky (API 19) + Fullscreen", View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        builder.add("Immersive Sticky + Hide navigation", View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        builder.add("Immersive Sticky - Actual fullscreen", View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        _liMain = (ListView) findViewById(R.id.liMainItems);
        _liMain.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, builder.getUiTitles()));
        _liMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                _liMain.setSystemUiVisibility(builder.getVisibility(i));
            }
        });


    }

    private final class SystemUiVisibilityBuilder {

        private List<String> _uiTitles = new ArrayList<String>();
        private List<Integer> _uiVisibilities = new ArrayList<Integer>();

        public SystemUiVisibilityBuilder add(String uiTitle, int visibility) {
            _uiTitles.add(uiTitle);
            _uiVisibilities.add(visibility);
            return this;
        }

        public List<String> getUiTitles() {
            return _uiTitles;
        }

        public int getVisibility(int position) {
            return _uiVisibilities.get(position);
        }


    }

}
