package applicationComForm;


import controller.ComContr;
import controller.ReadComPort;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import jssc.SerialPort;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ControllerComMyPort implements Initializable {
    @FXML
    private TextArea textarea1;
    @FXML
    private ComboBox comboBox1;
    @FXML
    private AnchorPane ap1;
    String acom;
    String textar2;
    String textar;
    String text1;
    AtomicInteger atomicInt = new AtomicInteger(0);
    private ComContr comContr;
    private ReadComPort readComPort;
    SerialPort serialPort;



    public ControllerComMyPort() {
        this.comContr = new ComContr(this);
        this.readComPort = new ReadComPort(serialPort, this);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < comContr.searcheComPort().length; i++) {
            acom = comContr.searcheComPort()[i].toString();
            comboBox1.getItems().add(acom);
            setTextarea2(acom );
        }
        setTextarea2("End Initial ControllerMyPort");
    }

        @FXML
    public void actionCom(ActionEvent actionEvent) {

            atomicInt.incrementAndGet();
                text1 = comboBox1.getValue().toString();

                comContr.initComPort(text1);
                        setTextarea2(text1 + ": Inizialized");

                System.out.println("InitPort " + atomicInt);
                atomicInt.incrementAndGet();

    }
    public String getComComboBox(){
    return  comboBox1.getValue().toString();
    }


    public void setTextarea2(String textar) {
        textarea1.appendText(textar + "\n");
    }


}
