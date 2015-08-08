package ru.vaszol.contactlist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.vaszol.contactlist.model.ContactModel;

/**
 * Created by vas on 08.08.2015.
 */
public class ContacAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private List<ContactModel> contactModels = null;

    public ContacAdapter(Context context,List<ContactModel> contactModels) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contactModels = contactModels;
    }

    @Override
    public int getCount() {
        if(contactModels!=null){
            return contactModels.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(contactModels!=null && position >=0 && position <=getCount()){
            return contactModels.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if(contactModels!=null && position >=0 && position <=getCount()){
            return contactModels.get(position).getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(view == null){
            view = inflater.inflate(R.layout.contact_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.imageView);
            viewHolder.fullName = (TextView)view.findViewById(R.id.textView);
            viewHolder.email = (TextView)view.findViewById(R.id.textView2);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        ContactModel record = contactModels.get(position);
        //выводим значения из записи
//        viewHolder.imageView.setImageResource(record.getPicture()); //TODO добавить Gravatar и скругление в стиль
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        viewHolder.fullName.setText("" + record.getName() + " "
                + record.getLastName());
        viewHolder.email.setText("" + record.getEmail());
        viewHolder.fullName.setTextColor(Color.GRAY);

        return view;
    }

    private class ViewHolder {
        public ImageView imageView;
        public TextView fullName;
        public TextView email;
    }

}
