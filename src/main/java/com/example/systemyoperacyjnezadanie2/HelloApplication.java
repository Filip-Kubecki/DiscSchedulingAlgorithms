package com.example.systemyoperacyjnezadanie2;

import Backend.Algorytmy;
import Backend.Generator;
import Backend.GraphData;
import Backend.Zgloszenie;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static ArrayList<GraphData> graphData = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Symulacja");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Symulacja");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("SCAN");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Head position");
        //populating the series with data
        for (GraphData graphDatum : graphData) {
            series.getData().add(new XYChart.Data<>(graphDatum.getTime(), graphDatum.getHeadPosition()));
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ArrayList<Zgloszenie> zgloszenia = Generator.generatorNormalny(20,2000);
        graphData = Algorytmy.SCAN(zgloszenia,zgloszenia.size(),2000);
        launch();
    }
}