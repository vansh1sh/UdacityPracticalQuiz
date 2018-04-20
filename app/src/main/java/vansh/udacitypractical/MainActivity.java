package vansh.udacitypractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.editText);
        email=(EditText)findViewById(R.id.editText2);
        about=(EditText)findViewById(R.id.editText3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("DATA", MODE_PRIVATE).edit();
                editor.putString("Name", name.getText().toString());
                editor.putString("Email", email.getText().toString());
                editor.putString("aboutInfo", about.getText().toString());
                editor.commit();
                Intent it=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(it);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Toast.makeText(getApplicationContext(),"Redirecting to profile page", Toast.LENGTH_SHORT).show();
                Intent it=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(it);
                break;
        }
        return true;
    }
}

