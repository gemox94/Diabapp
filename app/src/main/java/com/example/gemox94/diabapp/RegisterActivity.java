package com.example.gemox94.diabapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.gemox94.diabapp.DB.DiabappContract;
import com.example.gemox94.diabapp.DB.DiabappDbHelper;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("Registro");
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Button btn_register = (Button) findViewById(R.id.register_btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DiabappDbHelper dbHelper = new DiabappDbHelper(getBaseContext());
                SQLiteDatabase dbRol = dbHelper.getReadableDatabase();

                String[] projection = {
                        DiabappContract.Rol._ID,
                        DiabappContract.Rol.COLUMN_NAME_NAME
                };

                String selection = DiabappContract.Rol.COLUMN_NAME_NAME + " = ?";
                String[] selectionArgs = { "patient" };

                RadioButton rb_patient = (RadioButton) findViewById(R.id.register_rb_patient);

                if(!rb_patient.isChecked()) selectionArgs[0] = "doctor";

                Cursor cursor = dbRol.query(
                        DiabappContract.Rol.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                );

                cursor.moveToFirst();
                long rol_id = cursor.getLong(
                        cursor.getColumnIndexOrThrow(DiabappContract.Rol._ID)
                );

                TextInputEditText et_name       = (TextInputEditText) findViewById(R.id.register_et_name);
                TextInputEditText et_lastname   = (TextInputEditText) findViewById(R.id.register_et_lastname);
                TextInputEditText et_email      = (TextInputEditText) findViewById(R.id.register_et_email);
                TextInputEditText et_address    = (TextInputEditText) findViewById(R.id.register_et_address);
                TextInputEditText et_pass       = (TextInputEditText) findViewById(R.id.register_et_password);

                SQLiteDatabase db = dbHelper.getWritableDatabase();



                ContentValues values = new ContentValues();
                values.put(DiabappContract.User.COLUMN_NAME_NAME, et_name.getText().toString());
                values.put(DiabappContract.User.COLUMN_NAME_LASTNAME, et_lastname.getText().toString());
                values.put(DiabappContract.User.COLUMN_NAME_EMAIL, et_email.getText().toString());
                values.put(DiabappContract.User.COLUMN_NAME_ADDRESS, et_address.getText().toString());
                values.put(DiabappContract.User.COLUMN_NAME_PASSWORD, et_pass.getText().toString());
                values.put(DiabappContract.User.COLUMN_NAME_ROL_ID, rol_id);

                long row_id = db.insert(DiabappContract.User.TABLE_NAME, null, values);

                if(rol_id != -1){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this, "Error al guardar en BD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
