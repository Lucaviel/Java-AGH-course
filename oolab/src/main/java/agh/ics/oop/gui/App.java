package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application implements IPositionChangeObserver{
    private GridPane grid = new GridPane();
    VBox box;
    private GrassField map;
    private static final int width = 600;
    private static final int moveDelay = 300;
    private static final int height = 600;
    private static final int cellWidth = 40;
    private static final int cellHeight = 40;

    public void start(Stage primaryStage) throws IllegalArgumentException {
        this.grid.setGridLinesVisible(true);
        this.grid.setAlignment(Pos.BASELINE_CENTER);
        Button btn = new Button();
        btn.setText("Start");
        final TextField textField = new TextField();
        HBox hBox = new HBox(10);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        VBox vBox = new VBox(20);
        vBox.getChildren().add(grid);
        vBox.getChildren().add(hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            SimulationEngine engine = new SimulationEngine(this.map, positions, this);
            engine.setDelay(moveDelay);
            Thread firstThread = new Thread(engine);
            firstThread.start();
            btn.setOnAction((e) -> {
                Thread engineThread = new Thread(engine);
                String textFieldText = textField.getText();
                String[] args = textFieldText.split(" ");
                OptionsParser optionParser = new OptionsParser();
                MoveDirection[] directions = optionParser.parser(args);
                engine.setMoves(directions);
                engineThread.start();
            });
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }

    public void render () {
        Platform.runLater(() -> {
            Node gr = grid.getChildren().get(0);
            grid.getRowConstraints().clear();
            grid.getColumnConstraints().clear();
            grid.getChildren().clear();
            grid.add(gr, 0, 0);
            grid.setGridLinesVisible(true);
            int minY = this.map.getLowerLeftDrawLimit().y;
            int minX = this.map.getLowerLeftDrawLimit().x;
            int maxY = this.map.getUpperRightDrawLimit().y;
            int maxX = this.map.getUpperRightDrawLimit().x;

            Label xyLabel = new Label("y\\x");
            GridPane.setHalignment(xyLabel, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            grid.getRowConstraints().add(new RowConstraints(cellHeight));
            grid.add(xyLabel, 0, 0, 1, 1);
            for (int i = minY; i <= maxY; i++) {
                Label label2 = new Label(Integer.toString(i));
                grid.add(label2, 0, maxY - i + 1, 1, 1);
                grid.getRowConstraints().add(new RowConstraints(cellHeight));
                GridPane.setHalignment(label2, HPos.CENTER);
            }
            for (int i = minX; i <= maxX; i++) {
                Label label3 = new Label(Integer.toString(i));
                grid.add(label3, i - minX + 1, 0, 1, 1);
                grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
                GridPane.setHalignment(label3, HPos.CENTER);
            }
            int x = 0;
            int y = 0;
            for (int a = minX; a <= maxX; a++) {
                x += 1;
                y = 0;
                for (int b = maxY; b >= minY; b--) {
                    y += 1;
                    Object obiekt = map.objectAt(new Vector2d(a, b));
                    if (obiekt != null) {
                        AbstractWorldMapElement el = (AbstractWorldMapElement) obiekt;
                        box = new GuiElementBox(el).show();
                        grid.add(box, x, y, 1, 1);
                    }
                }
            } });
        }
        @Override
        public void positionChanged (Vector2d oldPosition, Vector2d newPosition){
            this.render();
        }
}

