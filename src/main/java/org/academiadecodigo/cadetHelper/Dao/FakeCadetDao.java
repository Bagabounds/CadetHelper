package org.academiadecodigo.cadetHelper.Dao;

import org.academiadecodigo.cadetHelper.Model.Cadet;
import org.springframework.stereotype.Repository;


import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class FakeCadetDao {
    private static Map<String,Cadet> cadets;

    static {
        cadets = new LinkedHashMap<String,Cadet>(){
            {
                put("Tomas" , new Cadet("Tomas","tomas@gmail.com" ,"123"));
            }
        };

    }

    public Map<String, Cadet> getAllCadets(){
        return cadets;
    }
}
