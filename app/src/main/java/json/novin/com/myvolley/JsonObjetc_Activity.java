package json.novin.com.myvolley;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjetc_Activity extends AppCompatActivity {
    private Button btnSend;
    private TextView textName, textEmail, textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object_);

        btnSend = (Button) findViewById(R.id.btnSend);
        textName = (TextView) findViewById(R.id.textName);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textPhone = (TextView) findViewById(R.id.textPhone);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJsonObject();

            }
        });
    }
    public  void  getJsonObject(){
        String url = "http://192.168.56.1/jsonTest/JsonObjectRequest.json";
        final ProgressDialog progressDialog = new ProgressDialog(JsonObjetc_Activity.this);
        progressDialog.setMessage("در حال دریافت اطلاعات");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Response.Listener<JSONObject>jsonObjectListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name = response.getString("name");
                    String email = response.getString("email");
                    String phone = response.getString("phone");

                    textName.setText(name);
                    textEmail.setText(email);
                    textPhone.setText(phone);

                    progressDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();


                }
                progressDialog.dismiss();

            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonObjetc_Activity.this, "اتصال ناموفق", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        };
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null,jsonObjectListener,errorListener);
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}
