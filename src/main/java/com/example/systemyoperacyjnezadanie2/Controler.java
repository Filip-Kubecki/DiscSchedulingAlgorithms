package com.example.systemyoperacyjnezadanie2;

import Backend.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controler {
    @FXML LineChart<Number, Number> dataChart;
    @FXML TextField discSize;
    @FXML TextField requestSize;

    @FXML Label totalTime;
    @FXML Label allHeadMove;
    @FXML Label avgWaitingTime;
    @FXML Label killedRequests;

    boolean preGeneratedData = false;


    @FXML
    private void FCFS(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,80);
        GraphData allData = Algorytmy.FCFS(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize; i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }
        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }
    @FXML
    private void SSTF(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,20);
        GraphData allData = Algorytmy.SSTF(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize; i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }
        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }

    @FXML
    private void SCAN(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,20);
        GraphData allData = Algorytmy.SCAN(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize; i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }
        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }

    @FXML
    private void CSCAN(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,20);
        GraphData allData = Algorytmy.CSCAN(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize; i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }
        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }

    @FXML
    private void EDF(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,20);
        GraphData allData = Algorytmy.EDF(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize-allData.getAmountOfKilledRequest(); i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }
        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }

    @FXML
    private void FDSCAN(ActionEvent event) {
        dataChart.getData().clear();
        int zgloszeniaSize = Integer.parseInt(requestSize.getText());
        int DiscSize = Integer.parseInt(discSize.getText());

        ArrayList<Zgloszenie> zgloszenia = Generator.generatorHybrydowy(zgloszeniaSize, DiscSize,80);
        GraphData allData = Algorytmy.FD_SCAN(zgloszenia, zgloszenia.size(), DiscSize);
        ArrayList<TimeToHeadPosition> graphData = allData.getTimeToHeadPositionArray();

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        //populating the series with data
        for (int i = 0; i < zgloszeniaSize-allData.getAmountOfKilledRequest(); i++) {
            series.getData().add(new XYChart.Data(graphData.get(i).getTime(),graphData.get(i).getHeadPosition()));
        }

        totalTime.setText(String.valueOf(allData.getTotalTime()));
        allHeadMove.setText(String.valueOf(allData.getAllHeadMovements()));
        killedRequests.setText(String.valueOf(allData.getAmountOfKilledRequest()));
        dataChart.getData().add(series);
    }
    @FXML void exit(ActionEvent event){
        Platform.exit();
    }
}
