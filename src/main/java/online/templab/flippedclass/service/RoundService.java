package online.templab.flippedclass.service;

import online.templab.flippedclass.entity.Round;

import java.util.List;

/**
 * Round 业务 接口类
 *
 * @author chenr
 */
public interface RoundService {

    /**
     * 插入一个 Round并插入klass_seminar表
     *
     * @param round
     * @return 成功则返回 true ,失败则返回 false
     */
    int insert(Round round);

    /**
     * 根据 id 更新一个 Round, 并更新其讨论课下的班级klass_round表
     *
     * @param round
     * @return 成功则返回 true ,失败则返回 false
     */
    Boolean update(Round round);

    /**
     * 老师功能
     * 根据 courseId 查找该 course 的所有 round, 并注入round下所有seminar
     *
     * @param courseId
     * @return
     */
    List<Round> listByCourseId(Long courseId);

    /**
     * 学生功能
     * 根据 courseId和klassId 查找该 course 的所有 round, 并注入round下所有seminar和其班级的klassRounds
     * klassRounds注入班级
     *
     * @param courseId
     * @return
     */
    List<Round> listByCourseIdKlassId(Long courseId, Long klassId);

    /**
     * 根据 id 获得一个 round，并注入round下所有seminar和klassRounds
     * klassRounds注入班级
     *
     * @param id
     * @return
     */
    Round get(Long id);

}
