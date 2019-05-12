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
import com.android.volley.toolbox.StringRequest;

public class StringRequest_Activity extends AppCompatActivity {
    private Button btnSend;
    private TextView textRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request_);


        btnSend = (Button)findViewById(R.id.btnSend);
        textRequest = (TextView)findViewById(R.id.textRequest);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getString();
            }
        });

    }
    public void getString() {
        String url = "http://novindevelopers.ir/stringrequest.php";

        final ProgressDialog progressDialog = new ProgressDialog(StringRequest_Activity.this);
        progressDialog.setMessage("در حال دریافت اطلاعات");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                textRequest.setText(response);
                progressDialog.dismiss();
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(StringRequest_Activity.this, "اتصال ناموفق", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };

        StringRequest request = new StringRequest(Request.Method.GET,url,listener,errorListener);
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}
