package sg.edu.rp.c346.id20022543.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter  extends ArrayAdapter{

    Context parent_context; //store the constructor of Contact in the context
    int layout_id; //store the row layout id
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects){ //customAdapter constructor
        super(context,resource,objects); //pass in the parameters

        //Storing everything passed into the array
        parent_context = context;
        layout_id = resource;
        contactList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //get the layout inflater tools to convert xml file to code
        View rowView = inflater.inflate(layout_id,parent,false); //To change contents in the row.xml file. It means make changes from the file layout_id and change it to a code called rowView and put the code under the parent(the entire listview page)
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivgender = rowView.findViewById(R.id.imageView);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode()); //Start with an empty string to change the int getCountrycode to a string
        tvNum.setText(currentItem.getPhoneNum() + "");
        if(currentItem.getGender() == 'M' || currentItem.getGender() == 'm') {
            ivgender.setImageResource(R.drawable.male);
        } else if(currentItem.getGender() == 'F' || currentItem.getGender() == 'f') {
            ivgender.setImageResource(R.drawable.female);
        } else {
            ivgender.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}
