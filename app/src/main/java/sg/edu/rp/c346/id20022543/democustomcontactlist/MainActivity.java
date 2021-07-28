package sg.edu.rp.c346.id20022543.democustomcontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact> alContactList;
    CustomAdapter caContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.listViewContacts);
        alContactList = new ArrayList<>(); //create arraylist before custom adapter as CA needs the arraylist.
        Contact item1 = new Contact("Mary",65,1234567,'F');
        Contact item2 = new Contact("Ken",65,7654321,'M');
        Contact item3 = new Contact("Osmos",65,7654321,'A');

        alContactList.add(item1);
        alContactList.add(item2);
        alContactList.add(item3);

        caContact = new CustomAdapter(MainActivity.this,R.layout.row,alContactList);    //Create the custom adapter. Context: MainActivity, layout:the id of the row layout, objects: the arraylist
        lvContact.setAdapter(caContact); //listview needs adapter. Lisview needs adapater -> adapter needs arraylist

    }
}

























