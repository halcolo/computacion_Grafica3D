package sample;

import com.javafx.experiments.importers.Importer3D;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;


public class Escene extends Application {

    @Override
    public void start(Stage firstScene) throws Exception {
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try{
                escene3D(firstScene, "../model/chair/chair2.obj", "images/product/Diapositiva1.PNG", 300.0, 1);
            } catch (IOException e){
                e.printStackTrace();
            }
        }));

        timeline1.setCycleCount(1);
        timeline1.play();

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try{
                escene3D(firstScene, "../model/poly_chair/poly_chair2.obj", "images/product/Diapositiva2.PNG", 200.0, 2);
            } catch (IOException e){
                e.printStackTrace();
            }
        }));

        timeline2.setCycleCount(1);
        timeline2.setDelay(Duration.millis(10000));
        timeline2.play();

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try{
                escene3D(firstScene, "../model/modern_chair/modern_chair.obj", "images/product/Diapositiva3.PNG", 50.0, 3);
            } catch (IOException e){
                e.printStackTrace();
            }
        }));

        timeline3.setCycleCount(1);
        timeline3.setDelay(Duration.millis(20000));
        timeline3.play();

        Timeline timeline4 = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try{
                escene3D(firstScene, "../model/office_chair/Office_chair.obj", "images/product/Diapositiva4.PNG", 200.0, 4);
            } catch (IOException e){
                e.printStackTrace();
            }
        }));

        timeline4.setCycleCount(1);
        timeline4.setDelay(Duration.millis(30000));
        timeline4.play();

        Timeline timeline5 = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try{
                escene3D(firstScene, "../model/wood_chair/Chair.obj", "images/product/Diapositiva5.PNG", 12.0, 5);
            } catch (IOException e){
                e.printStackTrace();
            }
        }));

        timeline5.setCycleCount(1);
        timeline5.setDelay(Duration.millis(40000));
        timeline5.play();
    }

    private void escene3D (Stage escenary1,
                           String url,
                           String bg,
                           Double scale,
                           Integer option) throws IOException {

        AmbientLight light1 = new AmbientLight();
        Node model = Importer3D.load(getClass().getResource(url).toExternalForm());
        model.setScaleX(scale);
        model.setScaleY(scale);
        model.setScaleZ(scale);

        ImageView imageView = new ImageView();
        Image bgimage=new Image(bg);
        imageView.setX(-640.0);
        imageView.setY(-360);
        imageView.setImage(bgimage);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        imageView.setScaleZ(-500.0);
        Group root = new Group(imageView, model, light1);

        Scene scene1 = new Scene(root, 1280, 720, true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth()/-2);
        camera.setTranslateY(scene1.getHeight()/-2);

        if (option == 1) {
            RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
            rt.setCycleCount(Animation.INDEFINITE);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.setAxis(new Point3D(0, 1, 0));
            rt.play();

        } else if (option == 2) {

            RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
            rt.setCycleCount(Animation.INDEFINITE);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.setAxis(new Point3D(0, 1, 0));
            rt.play();

            ScaleTransition st = new ScaleTransition(Duration.seconds(10), model);
            st.setFromX(scale);
            st.setToX(300);
            st.setFromY(scale);
            st.setToY(300);
            st.setFromZ(scale);
            st.setToZ(300);

        } else if (option == 3) {

            RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
            rt.setCycleCount(Animation.INDEFINITE);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.setAxis(new Point3D(1, 1, 1));
            rt.play();

            FadeTransition fadeTransition =
                    new FadeTransition(Duration.millis(3000), model);
            fadeTransition.setFromValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(2);
            fadeTransition.setAutoReverse(true);
        } else if (option == 4) {
            RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
            rt.setCycleCount(Animation.INDEFINITE);
            rt.setFromAngle(360);
            rt.setToAngle(0);
            rt.setAxis(new Point3D(0, 1, 1));
            rt.play();
        } else {
            RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
            rt.setCycleCount(Animation.INDEFINITE);
            rt.setFromAngle(360);
            rt.setToAngle(180);
            rt.setAxis(new Point3D(1, 1, 0));
            rt.play();

        }
        ScaleTransition st = new ScaleTransition(Duration.seconds(10));


        scene1.setCamera(camera);

        escenary1.setTitle("JavaFx Chairs 3D");
        escenary1.setScene(scene1);

        escenary1.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
