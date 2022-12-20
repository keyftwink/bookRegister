package com.example.bookregister2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApp.class.getResource("mainscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 527);
        stage.setTitle("Реестр книг");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}