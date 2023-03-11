package vidmots.bouncedown;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Pallur extends ImageView implements Leikhlutur {
    public Pallur() {
        FXML_Lestur.lesa(this, "pallur-view.fxml");
    }

    public void afram() {
        setTranslateY(getTranslateY() - 15);

        // Get the bounds of the visible area
        double sceneWidth = getScene().getWidth();


        // Check if the node is out of bounds
        if (getY() + getTranslateY() < -460) {
            // Calculate the new y-coordinate to bring the node back into the visible area
            double newY = 400.0;
            Random r = new Random();
            double newX = r.nextDouble() * sceneWidth;

            // Update the node's translation and layout coordinates
            setTranslateY(newY - getY());
            relocate(newX, newY);
        }
    }
}

