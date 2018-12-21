package online.templab.flippedclass.service.impl;

import online.templab.flippedclass.dao.RoundDao;
import online.templab.flippedclass.entity.Round;
import online.templab.flippedclass.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Round 业务 实现类
 *
 * @author chenr
 */
@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundDao roundDao;

    @Override
    public int insert(Round round) {
        return roundDao.insert(round);
    }

    @Override
    public Boolean update(Round round) {
        int line = roundDao.updateByRoundIdSelective(round);
        return line == 1;
    }

    @Override
    public List<Round> listByCourseId(Long courseId) {
        return roundDao.selectByCourseId(courseId);
    }

    @Override
    public List<Round> listByCourseIdKlassId(Long courseId, Long klassId) {
        return roundDao.selectByCourseIdKlassId(courseId, klassId);
    }

    @Override
    public Round get(Long id) {
        return roundDao.getOne(id);
    }
}
