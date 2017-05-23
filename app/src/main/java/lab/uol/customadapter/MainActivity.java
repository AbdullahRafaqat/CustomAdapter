package lab.uol.customadapter;
import android.*;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import static lab.uol.customadapter.R.*;

public class MainActivity extends Activity {

    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Contacts[] contacts_data = new Contacts[1000];
      //          {
       //     new Contacts("Ahmed", "033344928393", "Male")
       //  };
        for (int i=0; i<contacts_data.length; i++){
            contacts_data[i] = new Contacts("Fakhir","03244692032","Male");
        }

        ContactsAdapter adapter = new ContactsAdapter(this, layout.listview_item_row, contacts_data);

        listView1 = (ListView) findViewById(id.listView1);

        View header = (View) getLayoutInflater().inflate(layout.listview_header_row, null);
        listView1.addHeaderView(header);
        listView1.setAdapter(adapter);
    }
}