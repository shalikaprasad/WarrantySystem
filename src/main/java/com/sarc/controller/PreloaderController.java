package com.sarc.controller;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreloaderController extends Preloader {

    private Stage preloaderStage;
    private Scene scene;

    public PreloaderController() {

    }
    @Override
    public void init() throws Exception {

        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/SplashScreen.fxml"));
        scene = new Scene(root1);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.preloaderStage = primaryStage;
        preloaderStage.initStyle(StageStyle.TRANSPARENT);

        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {

        if (info instanceof ProgressNotification) {
            SplashScreenController.label.setText(((ProgressNotification) info).getProgress()*100 + " %");
            System.out.println("Value@ :" + ((ProgressNotification) info).getProgress());
            SplashScreenController.statProgressBar.setProgress(((ProgressNotification) info).getProgress());
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {

        StateChangeNotification.Type type = info.getType();
        switch (type) {

            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }

    }
}

