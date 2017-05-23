package lab.uol.customadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Abdullah on 4/7/2017.
 */
public class ContactsAdapter extends ArrayAdapter<Contacts> {
    Context context;
    int layoutResourceId;
    Contacts data[] = null;

    public ContactsAdapter(Context context, int layoutResourceId, Contacts[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactsHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ContactsHolder();
            holder.txtName = (TextView)row.findViewById(R.id.txtName);
            holder.txtPhone = (TextView)row.findViewById(R.id.txtPhone);
            holder.gender = (TextView) row.findViewById(R.id.txtGender);

            row.setTag(holder);
        }
        else
        {
            holder = (ContactsHolder) row.getTag();
        }

        Contacts contacts = data[position];
        holder.txtName.setText(contacts.name);
        holder.txtPhone.setText(contacts.phone);
        holder.gender.setText(contacts.gender);

        return row;
    }

    static class ContactsHolder
    {
        TextView txtName;
        TextView txtPhone;
        TextView gender;
    }
}

