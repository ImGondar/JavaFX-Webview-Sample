/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxwebviewsample.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafxwebviewsample.MainApp;

/**
 * FXML Controller class
 *
 * @author arron
 */
public class WebviewOverviewController implements Initializable {

    @FXML
    private WebView webView;
    
    @FXML
    private ProgressIndicator progressIndicator;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public WebviewOverviewController() {
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setUrl(String url) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);

        webEngine.setOnResized((WebEvent<Rectangle2D> event) -> {
            //To change body of generated methods, choose Tools | Templates.
            System.out.println("Window resized");
        });
        
        // 加载指示器
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("oldValue"+oldValue);                
                System.out.println("newValue"+newValue);
                if ("SUCCEEDED".equals(newValue.toString())) {
                    progressIndicator.setVisible(false);
                }else{
                    progressIndicator.setVisible(true);
                }
            }
        });
        
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
