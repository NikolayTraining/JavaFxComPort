package controller;



import applicationComForm.ControllerComMyPort;
import javafx.application.Platform;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ReadComPort implements SerialPortEventListener {
    private SerialPort serialPort;
    private String data;
   private   ControllerComMyPort controllerComMyPort;

    public ReadComPort(SerialPort serialPort, ControllerComMyPort controllerComMyPort) {
        this.serialPort = serialPort;
        this.controllerComMyPort = controllerComMyPort;
    }


    @Override
        public void serialEvent(SerialPortEvent event) {
            System.out.println("ComReader Open:");

            if (event.isRXCHAR() && event.getEventValue() >0 ) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            data = serialPort.readString();

                                System.out.println("data Out: " + data);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        controllerComMyPort.setTextarea2(data);
                                    }
                                });

                            } catch(SerialPortException e){
                                e.printStackTrace();
                            }
                    }
                });
                thread.start();

            }
        }


}
