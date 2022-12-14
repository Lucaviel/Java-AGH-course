package agh.ics.oop.gui;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    IMapElement ElementBox;
    public GuiElementBox(IMapElement element){
        this.ElementBox = element;
    }
    public VBox show(){

        String name = this.ElementBox.getName();
        ImageView imageView = null;
        try {
            Image image = new Image(new FileInputStream("src/main/resources/" + name + ".png"));
//            System.out.println(name);
            imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
        } catch (FileNotFoundException ex){
            System.out.println("Error: File not Found! " + ex.getMessage());
        }
        Label label;
        if(name.equals("grass")){
            label = new Label(name);
        }
        else{
            label = new Label(this.ElementBox.getPosition().toString());
        }

        VBox vbox = new VBox(0);
        vbox.getChildren().addAll(imageView,label);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        return vbox;
    }
}