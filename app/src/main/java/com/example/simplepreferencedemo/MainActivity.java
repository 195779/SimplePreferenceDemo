package com.example.simplepreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText_Name;
    EditText editText_Age;
    EditText editText_Sex;
    Button button_saveData;
    Button button_showData;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_Name = (EditText) findViewById(R.id.edit_text_Name);
        editText_Age = (EditText) findViewById(R.id.edit_text_Age);
        editText_Sex = (EditText) findViewById(R.id.edit_text_Sex);


        button_saveData = (Button) findViewById(R.id.saveData);
        button_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                /*通过getSharedPreferences()方法指定SharedPreference的文件名为data，并得到了Editor对象
                 * 接着向editor对象中添加三条不同类型的数据，最后调用apply()方法提交，从而完成了数据的存储
                 * 将会存储在shared_prefs目录下的data.xml中*/
                editor.putString("name",editText_Name.getText().toString());
                editor.putInt("age",Integer.parseInt(editText_Age.getText().toString()));
                editor.putString("sex",editText_Sex.getText().toString());
                editor.apply();
            }
        });


        button_showData = (Button) findViewById(R.id.showData);
        textView = (TextView) findViewById(R.id.textView01);
        button_showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myData = getSharedPreferences("data",MODE_PRIVATE);
                String name = myData.getString("name","");
                int age = myData.getInt("age",0);
                String sex = myData.getString("sex","");

                textView.setText("The name is " + name + "\n" + "The age is " + age + "\n" + "The sex is " + sex);
            }
        });
    }
}