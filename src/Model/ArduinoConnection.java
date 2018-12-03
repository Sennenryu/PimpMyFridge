package Model;

import com.fazecast.jSerialComm.*;
import java.util.Scanner;
import java.lang.String;


public class ArduinoConnection {

    public SerialPort InitPort() {
        SerialPort[] ports = SerialPort.getCommPorts();
        SerialPort port = ports[0];
        if (!port.openPort()) {
            System.out.println("Echec de la connection");
        }
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        return port;
    }

    public String ReadData(SerialPort port){
        Scanner data = new Scanner(port.getInputStream());
        return data.nextLine();
    }
}