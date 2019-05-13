package json.novin.com.myvolley;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import json.novin.com.myvolley.Adapter.Adapter;
import json.novin.com.myvolley.Model.Model;

public class JsonArray_aCTIVITY extends AppCompatActivity {
    private RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> models = new ArrayList<>();
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_a_ctivity);

        recyclerView = (RecyclerView) findViewById(R.id.recyClerview);
        btnSend = (Button) findViewById(R.id.btnSend);
        adapter = new Adapter(JsonArray_aCTIVITY.this, models);
        recyclerView.setLayoutManager(new LinearLayoutManager(JsonArray_aCTIVITY.this));
        recyclerView.setAdapter(adapter);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getJsonArray();
            }
        });
    }
    public void getJsonArray() {
        String url = "http://novindevelopers.ir/jsonarrayrequest.json";
        final ProgressDialog progressDialog = new ProgressDialog(JsonArray_aCTIVITY.this);
        progressDialog.setMessage("در حال دریافت اطلاعات");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Response.Listener<JSONArray> arrayListener = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {

                        JSONObject jsonObject = response.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String email =jsonObject.getString("email");
                        String phone = jsonObject.getString("phone");
                        models.add(new Model(name,email,phone));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonArray_aCTIVITY.this, "اتصال ناموفق", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,arrayListener,errorListener);
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(arrayRequest);
    }
}
