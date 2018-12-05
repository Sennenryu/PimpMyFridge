package model;

import java.lang.*;

public class Point {

    private float temperatureExt;
    private float temperatureInt;
    private float humidite;
    private float consigne;
    private boolean rosee;
    private double ptderosee;


    public float getTemperatureExt() {
        return temperatureExt;
    }


    public float getTemperatureInt() {
        return temperatureInt;
    }


    public float getHumidite() {
        return humidite;
    }

    public boolean getRosee(){
        return rosee;
    }

    public float getConsigne() {
        return consigne;
    }


    public double getPtderosee() {
        return ptderosee;
    }


    public double Magnus(float T,float RH){
        double alpha =((17.27*T)/(237.7+T))+Math.log(RH/100);
        double Tr = (237.7*alpha)/(17.27-alpha);
        return Tr ;
    }

    public void SavePoint(String data){
        int i = 0;
        for (String value : data.split(";")){
            switch(i) {
                case 0:
                    this.temperatureExt = Float.parseFloat(value);
                    break;
                case 1:
                    this.temperatureInt = Float.parseFloat(value);
                    break;
                case 2:
                    this.humidite = Float.parseFloat(value);
                    break;
                case 3:
                    this.consigne = Float.parseFloat(value);
            }
            i++;
        }
        if (Magnus(this.temperatureInt, this.humidite)>this.temperatureInt) {
            this.rosee = true;
        }
        else {
            this.rosee = false;
        }
        this.ptderosee = Magnus(this.temperatureInt, this.humidite);
    }
}
