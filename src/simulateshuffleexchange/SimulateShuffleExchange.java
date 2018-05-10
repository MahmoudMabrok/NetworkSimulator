/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulateshuffleexchange;

import java.util.ArrayList;
import java.util.Observable;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author motamed
 */
public class SimulateShuffleExchange extends Application {

    // int[] first = new int[] { , ,,,, } ; 
    int[] ys = new int[]{160, 235, 297, 356, 411, 478, 532, 600};
    int[] xs = new int[]{123, 230, 350, 450, 570, 680};

    double inputX = 75;
    double outputX = 720;

    String path = "000000";

    Pane root;
    Polyline polyline = new Polyline();

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Calculate Shifte-exchange");
        btn.setAlignment(Pos.CENTER);
        Button btnOm = new Button("Calculate Omega");
        btn.setAlignment(Pos.CENTER);
        Button btnBan = new Button("Banyan ");
        btn.setAlignment(Pos.CENTER);

        HBox btnPane = new HBox(15);
        btnPane.getChildren().addAll(btn, btnOm, btnBan);

        TextField field = new TextField();
        field.setAlignment(Pos.CENTER);
        field.setPromptText("Enter Start");

        TextField field2 = new TextField();
        field2.setAlignment(Pos.CENTER);
        field2.setPromptText("Enter End");

        GridPane work = new GridPane();
        work.setAlignment(Pos.CENTER);
        work.setVgap(20);
        work.setHgap(120);

        Rectangle rectangle1 = new Rectangle(100, 100);
        Rectangle rectangle2 = new Rectangle(100, 100);
        Rectangle rectangle3 = new Rectangle(100, 100);
        Rectangle rectangle4 = new Rectangle(100, 100);
        work.addColumn(0, rectangle1, rectangle2, rectangle3, rectangle4);

        Rectangle rectangle5 = new Rectangle(100, 100);
        Rectangle rectangle6 = new Rectangle(100, 100);
        Rectangle rectangle7 = new Rectangle(100, 100);
        Rectangle rectangle8 = new Rectangle(100, 100);
        work.addColumn(1, rectangle5, rectangle6, rectangle7, rectangle8);

        Rectangle rectangle9 = new Rectangle(100, 100);
        Rectangle rectangle10 = new Rectangle(100, 100);
        Rectangle rectangle11 = new Rectangle(100, 100);
        Rectangle rectangle12 = new Rectangle(100, 100);
        work.addColumn(2, rectangle9, rectangle10, rectangle11, rectangle12);

        Circle c = new Circle(15);
        c.setFill(Color.BLUE);

        VBox inputPane = new VBox(20);
        inputPane.setLayoutX(380);
        inputPane.setLayoutY(10);
        inputPane.setAlignment(Pos.CENTER);
        inputPane.getChildren().addAll(field, field2, btnPane);

        StackPane drawPane = new StackPane();

        drawPane.getChildren().addAll(work);
        drawPane.setLayoutX(132);
        drawPane.setLayoutY(152);
        //    drawPane.setStyle("-fx-background-color:yellow");

        root = new Pane();
        root.setPadding(new Insets(50));
        root.getChildren().addAll(inputPane, drawPane);

        //input circle 
        Circle[] inputs = new Circle[8];
        Circle[] outputs = new Circle[8];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new Circle(inputX, (double) ys[i], 6);
            outputs[i] = new Circle(outputX, (double) ys[i], 6);
        }
        root.getChildren().addAll(inputs);
        root.getChildren().addAll(outputs);

        btn.setOnAction(w -> {

            int start = Integer.parseInt(field.getText());
            int end = Integer.parseInt(field2.getText());

            if ((start <= 7 && start >= 0)
                    && (end <= 7 && end >= 0)) {
                path = competePath(start, end);
                System.out.println(path);
            } else {
                btn.setText("Error Select one from (0 - 7 )");
                System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                root.getChildren().remove(polyline);
                root.getChildren().remove(c);
                return;
            }

            root.getChildren().remove(polyline);

            polyline.setStroke(Color.AQUA);
            ObservableList<Double> lists = polyline.getPoints();
            lists.clear();

            lists.add(inputX);
            lists.add((double) ys[start]);

            for (int i = 0; i < path.length(); i++) {
                int val = Integer.parseInt("" + path.charAt(i));
                int x = xs[i];

                lists.add((double) x);
                int y = ys[val];
                lists.add((double) y);
            }

            lists.add(outputX);
            lists.add((double) ys[end]);

            root.getChildren().remove(c);
            root.getChildren().addAll(c, polyline);
            PathTransition pt = new PathTransition();
            pt.setNode(c);
            pt.setPath(polyline);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setRate(0.1);
            pt.play();

        });

        btnOm.setOnAction(e -> {
            int start = Integer.parseInt(field.getText());
            int end = Integer.parseInt(field2.getText());

          int   newStart = Covert.shuffle(start);
            if (( newStart <= 7 &&  newStart  >= 0)
                    && (end <= 7 && end >= 0)) {
                path = competePath( newStart, end);
                System.out.println(path );
            } else {
                btn.setText("Error Select one from (0 - 7 )");
                System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                root.getChildren().remove(polyline);
                root.getChildren().remove(c);
                return;
            }

            root.getChildren().remove(polyline);

            polyline.setStroke(Color.AQUA);
            ObservableList<Double> lists = polyline.getPoints();
            lists.clear();

            lists.add(inputX);
            lists.add((double) ys[start]);

            for (int i = 0; i < path.length(); i++) {
                int val = Integer.parseInt("" + path.charAt(i));
                int x = xs[i];

                lists.add((double) x);
                int y = ys[val];
                lists.add((double) y);
            }

            lists.add(outputX);
            lists.add((double) ys[end]);

            root.getChildren().remove(c);
            root.getChildren().addAll(c, polyline);
            PathTransition pt = new PathTransition();
            pt.setNode(c);
            pt.setPath(polyline);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setRate(0.1);
            pt.play();
        });
        
        btnBan.setOnAction(e->{
          int start = Integer.parseInt(field.getText());
            int end = Integer.parseInt(field2.getText());

          int   newEnd = Covert.shuffle(end);        
            if (( start <= 7 &&  start  >= 0)
                    && (newEnd <= 7 && newEnd >= 0)) {
                path = competePath( start, newEnd);
                System.out.println(path );
            } else {
                btn.setText("Error Select one from (0 - 7 )");
                System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                root.getChildren().remove(polyline);
                root.getChildren().remove(c);
                return;
            }

            root.getChildren().remove(polyline);

            polyline.setStroke(Color.AQUA);
            ObservableList<Double> lists = polyline.getPoints();
            lists.clear();

            lists.add(inputX);
            lists.add((double) ys[start]);

            for (int i = 0; i < path.length(); i++) {
                int val = Integer.parseInt("" + path.charAt(i));
                int x = xs[i];

                lists.add((double) x);
                int y = ys[val];
                lists.add((double) y);
            }

            lists.add(outputX);
            lists.add((double) ys[end]);

            root.getChildren().remove(c);
            root.getChildren().addAll(c, polyline);
            PathTransition pt = new PathTransition();
            pt.setNode(c);
            pt.setPath(polyline);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setRate(0.1);
            pt.play();
        });
        

        root.setOnMouseClicked(e -> {
            System.out.println(e.getX() + "  " + e.getY());
        }
        );

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("NetWork Simulation");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public String getPath(Node root, int destination) {

        int c = 0;
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);
        Node temp = root;
        while ((temp.right != null)) {
            c++;
            if (temp.right != null) {
                list.add(temp.right);
            }
            if (temp.left != null) {
                list.add(temp.left);
            }
            temp = list.get(c);
            // here left is null , check right if it is null so leaf node 
            if (temp.right == null && temp.left == null
                    && temp.current == destination) {
                return temp.path;
            }

        }
        for (int i = c; i < list.size(); i++) {
            if (list.get(i).current == destination) {
                return list.get(i).path;
            }

        }

        return "Not Found ";
    }

    public String competePath(int start, int end) {

        //create root node 
        Node node = new Node(start);
        node.path = String.valueOf(start);
        node.nn();

        Node temp1 = node.right.right;
        Node temp2 = node.left.right;

        for (int i = 0; i < 2; i++) {
            temp1.nn();
            temp2.nn();
        }

        temp1.finalDest();
        temp2.finalDest();

        return getPath(node, end);
    }

}
