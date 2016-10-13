/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxwebviewsample.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafxwebviewsample.MainApp;

/**
 * FXML Controller class
 *
 * @author arron
 */
public class RootLayoutController implements Initializable {

    // Reference to the main application
    private MainApp mainApp;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public RootLayoutController() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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

    /**
     * 个人主页
     */
    @FXML
    private void handleIndex() {
        this.mainApp.showIndexOverview();
    }

    /**
     * 个人博客
     */
    @FXML
    private void handleIndexBlog() {
        this.mainApp.showIndexBlogOverview();
    }

    /**
     * GitHub首页
     */
    @FXML
    private void handleGithubHome() {
        this.mainApp.showGithubHomeOverview();
    }

    /**
     * 个人GitHub
     */
    @FXML
    private void handleGithubMe() {
        this.mainApp.showGithubMeOverview();
    }

    /**
     * 百度
     */
    @FXML
    private void handleOtherBaidu() {
        this.mainApp.showOtherBaiduOverview();
    }

    /**
     * 微博
     */
    @FXML
    private void handleOtherWeibo() {
        this.mainApp.showOtherWeiboOverview();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

}
