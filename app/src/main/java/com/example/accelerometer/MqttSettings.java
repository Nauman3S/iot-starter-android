package com.example.accelerometer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MqttSettings extends AppCompatActivity {


    private EditText broker, port, topic, username, password;
    private Button connect;
    private String serverURI;
    private String mqttTopic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_settings);

        broker = findViewById(R.id.txtBroker);
        port = findViewById(R.id.txtPort);
        topic = findViewById(R.id.txtTopic);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.pwPassword);
        connect = findViewById(R.id.btnConnect);


        SharedPreferences sharedPref = this.getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
        String mqttTopic = sharedPref.getString("Topic","");
        //String mqttBroker = sharedPref.getString("Broker","");
        //String mqttPort = sharedPref.getString("Port","");
        String mqttUsername = sharedPref.getString("Username","");
        String mqttPassword = sharedPref.getString("Password","");

        topic.setText(mqttTopic);
        username.setText(mqttUsername);
        password.setText(mqttPassword);
    }


    public void connectMqtt(View v){
        serverURI = broker.getText().toString()+":"+port.getText().toString();
        Log.d("URI",serverURI);

        SharedPreferences sharedPref = this.getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        mqttTopic = topic.getText().toString();
        editor.putString("Topic",mqttTopic);
        editor.putString("serverURI",serverURI);
        editor.putString("Broker",broker.getText().toString());
        editor.putString("Port",port.getText().toString());
        editor.putString("Username",username.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.apply();

//        Toast.makeText(MqttSettings.this,)

    }

}