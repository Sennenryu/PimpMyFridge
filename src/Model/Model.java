package Model;

import com.fazecast.jSerialComm.SerialPort;

public class Model{

    private Point SavedPoint[]={null,null,null,null,null,null,null,null,null,null};
    private SerialPort port;
    ArduinoConnection connection = new ArduinoConnection();

   public Model() {
       for (int i = 0; i < 10; i++) {
           Point point = new Point();
           SavedPoint[i] = point;
       }
       port = connection.InitPort();
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

       for(int i=this.SavedPoint.length-1;i>0;i--){
           this.  SavedPoint[i]=this.SavedPoint[i-1];
       }
       SavedPoint[0]= point;
   }


}
