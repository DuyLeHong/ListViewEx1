package com.duyle.listviewex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityChonNgonNgu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngon_ngu);

        ListView lvChonNgonNgu = findViewById(R.id.lv_language);

        ArrayList<NgonNguModel> arrNgonNgu = new ArrayList<>();
        arrNgonNgu.add(new NgonNguModel("Tiếng Việt", R.mipmap.ic_flag_vn));
        arrNgonNgu.add(new NgonNguModel("Tiếng Anh", R.mipmap.ic_flag_eng));
        arrNgonNgu.add(new NgonNguModel("Tiếng Hàn", R.mipmap.ic_flag_kr));
        arrNgonNgu.add(new NgonNguModel("Tiếng Nhật", R.mipmap.ic_flag_japan));

        AdapterNgonNgu adapterNgonNgu = new AdapterNgonNgu(this, arrNgonNgu);

        lvChonNgonNgu.setAdapter(adapterNgonNgu);
    }

    private class AdapterNgonNgu extends BaseAdapter {

        Activity activity;
        ArrayList<NgonNguModel> list;

        public AdapterNgonNgu(Activity activity, ArrayList<NgonNguModel> list) {
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_ngonngu, viewGroup, false);

            NgonNguModel ngonNguModel = list.get(i);

            ImageView ivAvatar = view.findViewById(R.id.ivAvatar);
            TextView tvName = view.findViewById(R.id.txtName);

            ivAvatar.setImageResource(ngonNguModel.getIconId());
            tvName.setText(ngonNguModel.getName());

            return view;
        }
    }
}