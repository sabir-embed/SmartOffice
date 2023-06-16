package com.at.smartoffice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.Mqtt3Client;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;

import java.util.UUID;
import java.util.function.Consumer;


public class MainActivity extends AppCompatActivity {
    final String TAG = "devdx";
    Mqtt3Client mqttClient = null;
    Mqtt3ConnAck mqtt3ConnAck;
    String code="";
    byte[] payload = new byte[18];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code = connect();

        if(code!=null){
            if(code.equals("SUCCESS")){
                mqttClient.toAsync().subscribeWith()
                        .topicFilter("/devices/2692/events/device_alerts_v3")
                        .qos(MqttQos.AT_LEAST_ONCE)
                        .callback(new Consumer<Mqtt3Publish>() {
                            @Override
                            public void accept(Mqtt3Publish mqtt3Publish) {

                            }
                        });
            }else{
                Log.d(TAG, "onCreate: Connection UNSUCCESSFUL");
            }

        }else{
            Log.d(TAG, "onCreate: CONNECT NULL");
        }


    }


    public String connect(){
        mqttClient =  Mqtt3Client.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("bytebeam.micelio.com")
                .serverPort(1883)
                .build();
        try {
            if (mqttClient != null) {
                mqtt3ConnAck = mqttClient.toBlocking().connect();
            } else {
                Log.d(TAG, "connect: NULL CLIENT");
            }
        }catch (Exception e ){
            Log.d(TAG, "connect: CATCH "+e.getMessage());
        }

        return mqtt3ConnAck.toString();
    }

}

