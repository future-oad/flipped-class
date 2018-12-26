package online.templab.flippedclass.common.websocket;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.entity.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class SeminarMonitor {

    /**
     * klassSeminarId
     */
    private Long klassSeminarId;

    /**
     * 展示组
     */
    private List<Attendance> enrollList;

    /**
     * K attendanceId
     * V preScore
     */
    private Map<String, Integer> preScoreMap;

    /**
     * 当前的展示到的Index
     */
    private Integer onPreAttendanceIndex;

    /**
     * 当前正在进行的展示
     */
    private Attendance onPreAttendance;

    /**
     * 当前提问数量
     */
    private Integer raisedQuestionsCount;

    /**
     * K attendanceId
     * V preScore
     */
    private Map<String, List<Question>> askedQuestion;

    private SeminarState state;

    public SeminarMonitor(Long klassSeminarId, List<Attendance> enrollList) {
        this.klassSeminarId = klassSeminarId;
        this.enrollList = enrollList;
        this.preScoreMap = new HashMap<>(6);
        for (Attendance enroll : enrollList) {
            preScoreMap.put(String.valueOf(enroll.getId()), -1);
        }
        this.onPreAttendanceIndex = 0;
        this.onPreAttendance = enrollList.get(0);
        this.raisedQuestionsCount = 0;
        this.askedQuestion = new HashMap<>();
        for (Attendance enroll : enrollList) {
            askedQuestion.put(String.valueOf(enroll.getId()), new LinkedList<>());
        }
        this.state = new SeminarState().setProgressState("PAUSE").setTimeStamp(0L);
    }

}
