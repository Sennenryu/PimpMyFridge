package model;
import com.fazecast.jSerialComm.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.lang.String;


public class ArduinoConnection {
    SerialPort port;
    public SerialPort InitPort() {
        SerialPort[] ports = SerialPort.getCommPorts();
        SerialPort port = ports[1];
        if (!port.openPort()) {
            System.out.println("Echec de la connection");
        }
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        this.port = port;
        return port;
    }

    public String ReadData(SerialPort port){
        Scanner data = new Scanner(port.getInputStream());
        return data.nextLine();
    }

    public void SendData( int data) {
        try {
            this.port.getOutputStream().write(data);
            this.port.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}