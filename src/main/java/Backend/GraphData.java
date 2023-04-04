package Backend;

public class GraphData {
    int time;
    int headPosition;

    public GraphData(int time, int headPosition) {
        this.time = time;
        this.headPosition = headPosition;
    }

    public int getTime() {
        return time;
    }

    public int getHeadPosition() {
        return headPosition;
    }
}
