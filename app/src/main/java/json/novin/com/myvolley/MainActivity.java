package json.novin.com.myvolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btnStringRequest)
        {
            startActivity(new Intent(MainActivity.this,StringRequest_Activity.class));
        }
        else if (id == R.id.btnJsonObjectRequest)
        {
           // startActivity(new Intent(MainActivity.this,JsonObjetc_Activity.class));
        }
        else if (id == R.id.btnJsonArrayRequest)
        {
          // startActivity(new Intent(MainActivity.this,JsonArray_aCTIVITY.class));
        }
        else if (id == R.id.btnImageRequest)
        {
           // startActivity(new Intent(MainActivity.this,ImageRequest_Activity.class));
        }
    }
}
