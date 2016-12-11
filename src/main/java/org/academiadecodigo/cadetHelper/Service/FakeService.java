package org.academiadecodigo.cadetHelper.Service;

import org.academiadecodigo.cadetHelper.Dao.FakeCadetDao;
import org.academiadecodigo.cadetHelper.Model.Cadet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class FakeService {

    @Autowired
    private FakeCadetDao fakeCadetDao;

    public Map getAllCadets(){
        return this.fakeCadetDao.getAllCadets();
    }
}
