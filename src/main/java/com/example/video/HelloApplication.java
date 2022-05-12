package com.example.video;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.Callable;

public class HelloApplication extends Application {
    MediaView mediaView;
    Media media;
    MediaPlayer player;


    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        VBox vbox = new VBox();

        Image back = new Image("/bac.png");
        Image next = new Image("/ne.png");
        Image play = new Image("/pl.png");
        Image pause = new Image("/pau.png");
        Image stop = new Image("/stp.png");
        Image vl = new Image("/vlm.png");



        String style = getClass().getResource("/style.css").toExternalForm();
        String src = getClass().getResource("/math.mp4").toExternalForm();

        Media media = new Media(src);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView();
        mediaView.setMediaPlayer(player);
        mediaView.setFitHeight(650);
        mediaView.setFitWidth(1300);


        Label med = new Label("Media");
        Label stp = new Label("Playback");
        Label aud = new Label("Audio");
        Label vid = new Label("Video");
        Label sub = new Label("Subtitle");
        Label tool = new Label("Tools");
        Label view = new Label("View");
        Label hlp = new Label("Help");

        HBox hBo1 = new HBox(20, med,stp,aud,vid,sub,tool,view,hlp);
        hBo1.setId("controls");

        med.setOnMouseClicked(event -> {

        });

        stp.setOnMouseClicked(event -> {

        });

        aud.setOnMouseClicked(event -> {

        });

        vid.setOnMouseClicked(event -> {

        });

        sub.setOnMouseClicked(event -> {

        });

        tool.setOnMouseClicked(event -> {

        });

        view.setOnMouseClicked(event -> {

        });

        hlp.setOnMouseClicked(event -> {

        });



        ImageView one = new ImageView(back);
        one.setFitHeight(30);
        one.setFitWidth(30);
        ImageView two = new ImageView(next);
        two.setFitHeight(30);
        two.setFitWidth(30);
        ImageView three = new ImageView(play);
        three.setFitHeight(30);
        three.setFitWidth(30);
        ImageView four = new ImageView(pause);
        four.setFitHeight(30);
        four.setFitWidth(30);
        ImageView five = new ImageView(stop);
        five.setFitHeight(30);
        five.setFitWidth(30);
        ImageView fv = new ImageView(vl);
        fv.setFitHeight(20);
        fv.setFitWidth(20);


        one.setOnMouseClicked(ActionEvent->
        {



        });

        fv.setOnMouseClicked(ActionEvent->
        {



        });



        two.setOnMouseClicked(ActionEvent->
        {


        });

        three.setOnMouseClicked(ActionEvent->
        {
            player.play();

        });

        four.setOnMouseClicked(ActionEvent->
        {
            player.pause();

        });

        five.setOnMouseClicked(ActionEvent->
        {
            if(player.getStatus() != player.getStatus().READY) {
                player.seek(Duration.seconds(0.0));

            }});

        //ProgressBar progressBar = new ProgressBar();


        Slider volume = new Slider();
        volume.setOnDragDetected(ActionEvent->{
            volume.setValue(player.getVolume()*100);
            volume.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    player.setVolume(volume.getValue()/100);
                }
            });
        });

//        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
//            @Override
//            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
//                progressBar(newValue.toSeconds());
//            }
//        });
        Slider progressBar = new Slider();

        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                //progressBar.setValue(newValue.toSeconds());
                progressBar.setValue(newValue.toSeconds());
            }
        });
        progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                player.seek(Duration.seconds(progressBar.getValue()));
            }
        });

        progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                player.seek(Duration.seconds(progressBar.getValue()));
            }
        });

        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                Duration total=media.getDuration();
                progressBar.setMax(total.toSeconds());
            }
        });
//        Label lbCurrentTime = new Label();
//
//        // time display
//        public void bindCurrentTimeLabel(){
//            lbCurrentTime.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return getTime(mpVideo.getCurrentTime()) + " / ";
//                }
//            },player.currentTimeProperty()));
//        }
//
//        public String getTime(Duration ){
//            Duration duration;
//            int hours = (int) time.toHours();
//            int minutes = (int) time.toMinutes();
//            int seconds = (int) time.toSeconds();
//
//            if (seconds > 59) seconds = seconds % 60;
//            if (minutes > 59) minutes = minutes % 60;
//            if (hours > 59) hours = hours % 60;
//
//            if(hours > 0 ) return String.format("%d:%02d%02d",
//                    hours, minutes, seconds);
//
//            else return String.format("%02d:%02d",
//                    minutes,seconds);
//        }
//
//
//
//
//        bindCurrentTimeLabel();



        HBox hBox2 = new HBox();
        Slider time = new Slider();

        hBox2.getChildren().add(time);
        hBox2.setVisible(true);
        //root.setBottom(hBox2);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setId("hbox");

        hBox.setSpacing(10);

        hBox.getChildren().addAll(five, one, three, four, two, fv, volume);
        hBox.setVisible(true);

        vbox.setSpacing(10);

        //root.getChildren().addAll(hBo1,mediaView,hBox);
        hBo1.setVisible(true);
        //root.setTop(hBo1);

        root.getStylesheets().add(style);
        Scene scene = new Scene(root,400, 300);
       // root.setBottom(hBox);
        vbox.getChildren().addAll(mediaView,progressBar);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        root.setTop(hBo1);
        root.setBottom(hBox);
        //root.setCenter(mediaView);
        stage.setTitle("welcome to my video players!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}