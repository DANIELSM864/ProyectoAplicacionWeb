package com.Anasovi.Anasovi.service.impl;

import com.Anasovi.Anasovi.dao.ConsultaDao;
import com.Anasovi.Anasovi.domain.Consulta;
import com.Anasovi.Anasovi.service.ConsultaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaDao consultaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Consulta> getConsultas(boolean activos) {
        var consultas = consultaDao.findAll();

        return consultas;
    }

    @Override
    @Transactional(readOnly = true)
    public Consulta getConsulta(Consulta consulta) {
        return consultaDao.findById(consulta.getIdConsulta()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Consulta consulta) {
        consultaDao.save(consulta);
    }

    @Override
    @Transactional
    public void delete(Consulta consulta) {
        consultaDao.delete(consulta);
    }

}
