package com.strsar.laxmi.senser;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.strsar.laxmi.R;

import java.util.List;


public class SensorsActivity extends AppCompatActivity implements SensorEventListener {
    private LinearLayout sensorLayout;
    private TextView textView;
    private int sensorInd;

    private  SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor proximitySensor;
    private Sensor rotationSensor;
    private Sensor stepCounterSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sensor_acticty);
        sensorLayout = findViewById(R.id.sensors_layout);
        textView = findViewById(R.id.sensors);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
    }

    public void sensorsList(View view){
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String sensorInfo = "";
        for (Sensor s : sensorList){
            sensorInfo= sensorInfo + s.getName()+ "\n";
        }
        textView.setText(sensorInfo);
    }
    public boolean checkSensorAvailability(int sensorType){
        boolean isSensor = false;
        if(sensorManager.getDefaultSensor(sensorType) != null){
            isSensor = true;
        }
        Log.d("checkSensorAvailability" ,""+isSensor);
        return  isSensor;
    }
    public void lightSensor(View view){
        if(checkSensorAvailability(Sensor.TYPE_LIGHT)){
            sensorInd = Sensor.TYPE_LIGHT;
        }
    }
    public void proximitySensor(View view){
        if(checkSensorAvailability(Sensor.TYPE_PROXIMITY)){
            sensorInd = Sensor.TYPE_PROXIMITY;
        }
    }
    public void rotationSensor(View view){
        if(checkSensorAvailability(Sensor.TYPE_GAME_ROTATION_VECTOR)){
            sensorInd = Sensor.TYPE_GAME_ROTATION_VECTOR;
        }
    }
    public void stepCounterSensor(View view){
        if(checkSensorAvailability(Sensor.TYPE_GAME_ROTATION_VECTOR)){
            sensorInd = Sensor.TYPE_STEP_DETECTOR;
        }
    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        //check sensor type matches current sensor type set by button click
        if( event.sensor.getType() == sensorInd){
            //light sensor
            if(event.sensor.getType() ==  Sensor.TYPE_LIGHT){
                float valueZ = event.values[0];
                Toast.makeText(this, "luminescence "+valueZ,Toast.LENGTH_LONG).show();
                if(valueZ > 40){
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_three);
                }else{
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_two);
                }
            }else if(event.sensor.getType() ==  Sensor.TYPE_PROXIMITY){
                //proximity sensor
                float distance = event.values[0];
                Toast.makeText(this, "proximity "+distance,Toast.LENGTH_LONG).show();
                if(distance > 25){
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_three);
                }else{
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_two);
                }
            }else if(event.sensor.getType() ==  Sensor.TYPE_STEP_DETECTOR){
                //step counter
                float steps = event.values[0];
                textView.setText("steps : "+steps);
            }else if(event.sensor.getType() ==  Sensor.TYPE_GAME_ROTATION_VECTOR){
                //rotation sensor
                float[] rotMatrix = new float[9];
                float[] rotVals = new float[3];

                SensorManager.getRotationMatrixFromVector(rotMatrix, event.values);
                SensorManager.remapCoordinateSystem(rotMatrix,
                        SensorManager.AXIS_X, SensorManager.AXIS_Y, rotMatrix);

                SensorManager.getOrientation(rotMatrix, rotVals);
                float azimuth = (float) Math.toDegrees(rotVals[0]);
                float pitch = (float) Math.toDegrees(rotVals[1]);
                float roll = (float) Math.toDegrees(rotVals[2]);

                if(azimuth > 60 && azimuth < 90){
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_three);
                }else if(pitch > 10){
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_two);
                }else if(roll > 15){
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background);
                }else{
                    sensorLayout.setBackgroundResource(R.drawable.sensor_background_four);
                }
            }

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, proximitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, rotationSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, stepCounterSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}