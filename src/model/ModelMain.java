package model;

import com.fazecast.jSerialComm.SerialPort;

import java.sql.Savepoint;
import java.util.ArrayList;

public class ModelMain {

    private int nbVal = 100;

    public Point getSavedPoint(int i) {
        return SavedPoint.get(i);
    }

    public int getSize(){
        return SavedPoint.size();
    }

    ArrayList<Point> SavedPoint = new ArrayList<Point>();

    private SerialPort port;
    ArduinoConnection connection = new ArduinoConnection();

   public ModelMain() {
       port = connection.InitPort();
       connection.ReadData(port);
       connection.ReadData(port);
       this.mesure(this.connection, port);
   }

   public void ReadData(){

       mesure(connection,port);
   }

   public void mesure(ArduinoConnection connections, SerialPort ports){

       Point point = new Point();
       point.SavePoint(connections.ReadData(ports));
       this.SaveData(point);
   }

   private void SaveData(Point point){
       SavedPoint.add(point);
       if (SavedPoint.size()>1000){
           SavedPoint.remove(0);
       }
   }

   public void addConsigneJ() {
       this.connection.SendData(1);
   }

   public void removeConsigneJ() {
        this.connection.SendData(0);
    }

    public int getnbVal() {
        return nbVal;
    }

    public void setnbVal(int nbVal) {
        nbVal = nbVal;
    }
}
