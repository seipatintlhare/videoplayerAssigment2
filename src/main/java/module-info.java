module com.example.video {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.video to javafx.fxml;
    exports com.example.video;
}