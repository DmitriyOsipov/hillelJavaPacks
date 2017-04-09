package Ex16.writersStat;

/**
 * Created by Dreamer on 09.04.2017.
 */
public class StatInfo {
    private String fileName;
    private double fileSizeBytes;
    private double remainedTimeMs;
    private double speed;

    public StatInfo(String fileName, double fileSizeBytes, double remainedTimeMs) {
        this.fileName = fileName;
        this.fileSizeBytes = fileSizeBytes;
        this.remainedTimeMs = remainedTimeMs;
        speed = fileSizeBytes/remainedTimeMs;
    }

    public String getFileName() {
        return fileName;
    }

    public double getFileSizeBytes() {
        return fileSizeBytes;
    }

    public double getRemainedTimeMs() {
        return remainedTimeMs;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFileSizeMBytes() {
        return fileSizeBytes/1024/1024;
    }

    public double getRemainedTimeSec() {
        return remainedTimeMs/1000;
    }

    public double getSpeedMbPS() {
        return getFileSizeMBytes()/getRemainedTimeSec();
    }
}
