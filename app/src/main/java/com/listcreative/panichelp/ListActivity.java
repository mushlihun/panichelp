package com.listcreative.panichelp;


import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private LinearLayoutManager lLayout;
    String GET_JSON_DATA_HTTP_URL = "http://192.168.1.7/HiDepok/jsonData.php";
    String JSON_ID = "id";
    String JSON_NAME = "nama";
    String JSON_DESKRIPSI = "deskripsi";
    String JSON_FOTO = "foto";
    JsonArrayRequest jsonArrayRequest ;
    List<GetDataAdapter> GetDataAdapter1;
    RequestQueue requestQueue ;
    RecyclerView.Adapter recyclerViewadapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Button button;
    RecyclerView rView;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        List<ItemObject> rowListItem = getAllItemList();

        lLayout = new LinearLayoutManager(ListActivity.this);
//
        rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);
        GetDataAdapter1 = new ArrayList<>();
//
//        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(ListActivity.this, rowListItem);
//        rView.setAdapter(rcAdapter);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);

        JSON_DATA_WEB_CALL();

    }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //GetDataAdapter2.setId(json.getString(JSON_ID));

                GetDataAdapter2.setName(json.getString(JSON_NAME));

                GetDataAdapter2.setDeskripsi(json.getString(JSON_DESKRIPSI));

                GetDataAdapter2.setFoto(R.drawable.a_avator);

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new RecyclerViewAdapterJSON(GetDataAdapter1, this);

        rView.setAdapter(recyclerViewadapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final MenuItem searchItem = menu.findItem(R.id.action_search);

        if (searchItem != null) {
            searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    //some operation
                    return false;
                }
            });
            searchView.setOnSearchClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //some operation
                }
            });
            EditText searchPlate = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchPlate.setHint("Search");
            View searchPlateView = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
            searchPlateView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
            // use this method for search process
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // use this method when query submitted
                    Toast.makeText(ListActivity.this, query, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    // use this method for auto complete search process
                    return false;
                }
            });
            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        }
        return super.onCreateOptionsMenu(menu);
    }

//    private List<ItemObject> getAllItemList(){
//
//        List<ItemObject> allItems = new ArrayList<>();
//        allItems.add(new ItemObject("Peter James", "Vildansvagen 19, Lund Sweden", R.drawable.a_avator));
//        allItems.add(new ItemObject("Henry Jacobs", "3 Villa Crescent London, UK", R.drawable.a_avator));
//        allItems.add(new ItemObject("Bola Olumide", "Victoria Island Lagos, Nigeria", R.drawable.a_avator));
//        allItems.add(new ItemObject("Chidi Johnson", "New Heaven Enugu, Nigeria", R.drawable.a_avator));
//        allItems.add(new ItemObject("DeGordio Puritio", "Italion Gata, Padova, Italy", R.drawable.a_avator));
//        allItems.add(new ItemObject("Gary Cook", "San Fransisco, United States", R.drawable.a_avator));
//        allItems.add(new ItemObject("Edith Helen", "Queens Crescent, New Zealand", R.drawable.a_avator));
//        allItems.add(new ItemObject("Kingston Dude", "Ivory Lane, Abuja, Nigeria", R.drawable.a_avator));
//        allItems.add(new ItemObject("Edwin Bent", "Johnson Road, Port Harcourt, Nigeria", R.drawable.a_avator));
//        allItems.add(new ItemObject("Grace Praise", "Federal Quarters, Abuja Nigeria", R.drawable.a_avator));
//
//        return allItems;
//    }
}


