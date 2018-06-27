package me.caelumterrae.todoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends AppCompatActivity {
    EditText etItemText;
    int position;
    public static final String ITEM_TEXT = "itemText";
    public static final String ITEM_POSITION = "itemPosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        etItemText = (EditText) findViewById(R.id.etItemText);

        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));

        position = getIntent().getIntExtra(ITEM_POSITION, 0);

        getSupportActionBar().setTitle("Edit Item");
    }

    public void onSaveItem(View v) {
        // Prepare intent to pass back to MainActivity
        Intent data = new Intent();
        // Pass updated item text and original position
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position); // ints work too
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the edit activity, passes intent back to main
    }
}
