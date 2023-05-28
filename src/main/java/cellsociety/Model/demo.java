//package cellsociety.Model;
//
//import cellsociety.Model.CellState.percolateCellState;
//import cellsociety.Model.Percolation.PercolateSimulator;
//import cellsociety.Model.SchellingSegregation.SegregateSimulator;
//import cellsociety.View.Statistics.PercolationStat;
//import cellsociety.View.Statistics.StatisticsView;
//import java.util.Random;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class demo extends Application {
//
//  private final String TITLE = "Demo";
//  private final Paint BACKGROUND = Color.WHITE;
//  private final double SECOND_DELAY = 1;
//  private final int SCENEWIDTH = 800;
//  private final int SCENEHEIGHT = 800;
//  private final Simulator s = new PercolateSimulator(20, 20);
//  private NumberAxis xAxis = new NumberAxis(0, 30, 1);
//  private NumberAxis yAxis = new NumberAxis(0, 500, 50);
//  private LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
//  private StatisticsView sView = new PercolationStat(chart, s);
//  private Scene myScene;
//
//  public static void main(String[] args) {
//    launch(args);
//  }
//
//  public void start(Stage stage) {
//    myScene = setUpScene(SCENEWIDTH, SCENEHEIGHT, BACKGROUND);
//    stage.setScene(myScene);
//    stage.setTitle("Demo");
//    stage.show();
//
//    Timeline animation = new Timeline();
//    animation.setCycleCount(Timeline.INDEFINITE);
//    animation.getKeyFrames().add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(stage)));
//    animation.play();
//
//  }
//
//  public Scene setUpScene(int width, int height, Paint background) {
//    Group root = new Group();
//
//    myScene = new Scene(root, width, height, background);
//
//    for (int i = 0; i < 20; i++) {
//      for (int j = 0; j < 20; j++) {
//        Random r = new Random();
//        switch (r.nextInt(12)) {
//          case 0, 3, 8, 10, 11:
//            s.getCell(i, j).setCurrentState(CellState.percolateCellState.BLOCK);
//            break;
//          case 1, 4, 5, 6, 7, 9:
//            s.getCell(i, j).setCurrentState(CellState.percolateCellState.OPEN);
//            break;
//          case 2:
//            s.getCell(i, j).setCurrentState(percolateCellState.PERCOLATE);
//            break;
//
//        }
//
//      }
//    }
//
////        for(int i=0; i<20; i++){
////            for(int j=0; j<20; j++){
////                Cell c = s.getGrid().getCell(i, j);
////                Enum state = c.getCurrentState();
////                Rectangle r = new Rectangle(i*40, j*40, 40, 40);
////
////                if(state.equals(CellState.segregateCellState.EMPTY)){
////                    r.setFill(Color.WHITE);
////                }
////                else if(state.equals(CellState.segregateCellState.X)){
////                    r.setFill(Color.RED);
////                }
////                else{
////                    r.setFill(Color.BLUE);
////                }
////
////                root.getChildren().add(r);
////            }
////        }
//
//    return myScene;
//  }
//
//  public void step(Stage stage) {
//    s.simulate();
//    sView.updateStat();
//
//    Group root = new Group();
//
//    root.getChildren().add(sView.getChart());
//
////    for (int i = 0; i < 20; i++) {
////      for (int j = 0; j < 20; j++) {
////        Cell c = s.getGrid().getCell(i, j);
////        Enum state = c.getCurrentState();
////        Rectangle r = new Rectangle(i * 40, j * 40, 40, 40);
////
////        if (state.equals(CellState.percolateCellState.OPEN)) {
////          r.setFill(Color.WHITE);
////        } else if (state.equals(CellState.percolateCellState.BLOCK)) {
////          r.setFill(Color.BLACK);
////        } else {
////          r.setFill(Color.BLUE);
////        }
////
////        root.getChildren().add(r);
////      }
////    }
//    Scene anotherScene = new Scene(root, 800, 800, BACKGROUND);
//
//    stage.setScene(anotherScene);
//    stage.show();
//
//  }
//}
