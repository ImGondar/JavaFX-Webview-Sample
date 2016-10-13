/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxwebviewsample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafxwebviewsample.view.WebviewOverviewController;
import javafxwebviewsample.view.RootLayoutController;

/**
 *
 * @author arron
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public static final String APP_NAME = "宏观经济";

    private static final String[] URLS = new String[]{
        "http://www.helloarron.com/",
        "http://blog.helloarron.com",
        "https://github.com/",
        "https://github.com/ArronYR",
        "https://www.baidu.com/",
        "http://www.weibo.com/"
    };

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle(APP_NAME);
        // this.primaryStage.setMaximized(true);
        this.primaryStage.setMinWidth(960);
        this.primaryStage.setMinHeight(640);

        // 执行初始化
        this.initRootLayout();
        // 显示首页
        this.showIndexOverview();
    }

    /**
     * 初始化
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            this.rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            this.primaryStage.show();

        } catch (Exception e) {
        }
    }

    /**
     * 加载WebView
     *
     * @param url
     */
    public void showWebviewOverview(String url) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/WebviewOverview.fxml"));
            AnchorPane webviewOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(webviewOverview);

            // Give the controller access to the main app.
            WebviewOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setUrl(url);
        } catch (Exception e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 显示个人主页
     */
    public void showIndexOverview() {
        this.showWebviewOverview(URLS[0]);
    }

    /**
     * 显示个人博客
     */
    public void showIndexBlogOverview() {
        this.showWebviewOverview(URLS[1]);
    }

    /**
     * 显示GitHub主页
     */
    public void showGithubHomeOverview() {
        this.showWebviewOverview(URLS[2]);
    }

    /**
     * 显示个人GitHub
     */
    public void showGithubMeOverview() {
        this.showWebviewOverview(URLS[3]);
    }

    /**
     * 显示其他项中的百度
     */
    public void showOtherBaiduOverview() {
        this.showWebviewOverview(URLS[4]);
    }

    /**
     * 显示其他项中的微博
     */
    public void showOtherWeiboOverview() {
        this.showWebviewOverview(URLS[5]);
    }
}
