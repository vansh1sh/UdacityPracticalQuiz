package vansh.udacitypractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
TextView name,email,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ui);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(TextView)findViewById(R.id.tvName);
        email=(TextView)findViewById(R.id.tvEmail);
        about=(TextView)findViewById(R.id.tvAbout);
        if (savedInstanceState != null) {
            name.setText(savedInstanceState.getString("Name"));
            email.setText(savedInstanceState.getString("Email"));
            about.setText(savedInstanceState.getString("aboutInfo"));
        } else {
            SharedPreferences prefs = getSharedPreferences("DATA", MODE_PRIVATE);
            name.setText(prefs.getString("Name", "No name defined"));
            email.setText(prefs.getString("Email", "Not defined"));
            about.setText(prefs.getString("aboutInfo", "Not defined"));
        }

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("Name", name.getText().toString());
        savedInstanceState.putString("Email", email.getText().toString());
        savedInstanceState.putString("aboutInfo", about.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
