module vidmots.bouncedown {
    requires javafx.controls;
    requires javafx.fxml;


    opens vidmots.bouncedown to javafx.fxml;
    exports vidmots.bouncedown;
}
