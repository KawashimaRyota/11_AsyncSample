package com.example.asyncsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);

        //画面部品ListViewを取得
        ListView lvCityList = findViewById(R.id.lvCityList);
        //SimpleAdapterで使用するListオブジェクトを用意
        List<Map<String, String>> cityList = new ArrayList<>();
        //都市データを格納するMapオブジェクトの用意とcityListへのデータ登録
        Map<String, String> city = new HashMap<>();
        city.put("name", "大阪");
        city.put("id", "270000");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "神戸");
        city.put("id", "280010");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "豊岡");
        city.put("id", "280020");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "京都");
        city.put("id", "260010");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "舞鶴");
        city.put("id", "260020");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "奈良");
        city.put("id", "290010");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "風屋");
        city.put("id", "290020");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "和歌山");
        city.put("id", "300010");
        cityList.add(city);
        city = new HashMap<>();
        city.put("name", "潮岬");
        city.put("id", "300020");
        cityList.add(city);
        //SimpleAdapterで使用するfrom-to用変数の用意
        String[] from = {"name"};
        int[] to = {android.R.id.text1};
        //SimpleAdapterを設定
        SimpleAdapter adapter = new SimpleAdapter(WeatherInfoActivity.this, cityList, android.R.layout.simple_list_item_1, from, to);
        //ListViewにSimpleAdapterを設定
        lvCityList.setAdapter(adapter);
        //ListViewにリスナを設定
        lvCityList.setOnItemClickListener(new ListItemClickListener());
    }

    /**
     * リストが選択された時の処理を記述したメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //ListVIewでタップされた行の都市名と都市IDを取得
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String cityName = item.get("name");
            String cityId = item.get("id");
            //取得した都市名をtvCityNameに設定
            TextView tvCityName = findViewById(R.id.tvCityName);
            tvCityName.setText(cityName + "の天気：");
        }
    }
}
