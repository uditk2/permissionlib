package project.mpermissions;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import project.mpermissions.callbacks.PermissionRequestCallback;
import project.mpermissions.exceptions.ActivityAttachException;
import project.mpermissions.handlers.PermissionHandler;
import project.mpermissions.helpers.PermissionHelper;
import project.mpermissions.types.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            PermissionHandler.attachToActivity(this);
        }catch (ActivityAttachException e){
            Log.d("MAIN", e.getMessage());
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        PermissionHandler.requestPermission(this, new PermissionRequestCallback() {
            @Override
            public void onPermissionDenied(List<Permission> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission has been denied", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAllPermissionsGranted() {
                Toast.makeText(MainActivity.this, "Permission has been accepted", Toast.LENGTH_LONG).show();
            }
        }, Permission.ACCESS_COARSE_LOCATION);
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
}
