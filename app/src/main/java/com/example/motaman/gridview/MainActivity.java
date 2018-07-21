package com.example.motaman.gridview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new GridItems(this));

        /*

        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final TextView textView = (TextView)findViewById(R.id.spinner_textView);
        //final TextView textView1 = (TextView)findViewById(R.id.spinner_textView1);

        final ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Motaman");
        arrayList.add("Mohanna");
        arrayList.add("Hashomi");
        arrayList.add("Rami");
        arrayList.add("Mina");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textView.setText("Index: " + position + "        Name: " + arrayList.get(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(1);
            }
        });
*/
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


    class GridItems extends BaseAdapter{

        ArrayList<Items> items = new ArrayList<Items>();
        Context context;

        GridItems(Context context){

            this.context = context;
            items.add(new Items(R.drawable.almarai_fat_free_2l, "Diary Products"));
            items.add(new Items(R.drawable.cofftea_ghazaltein, "Tea"));
            items.add(new Items(R.drawable.seven_up_1l, "Beverages"));
            items.add(new Items(R.drawable.nescafe_classic, "Coffee"));

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.grid_items, parent, false);

            ImageView imageView = (ImageView)view.findViewById(R.id.coverImageView);
            TextView textView = (TextView)view.findViewById(R.id.titleTextView);

            imageView.setImageResource(items.get(position).img);
            textView.setText(items.get(position).title);

            return view;
        }
    }

}
