package com.Anasovi.Anasovi.service.impl;

import com.Anasovi.Anasovi.dao.DonacionDao;
import com.Anasovi.Anasovi.domain.Donacion;
import com.Anasovi.Anasovi.service.DonacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DonacionServiceImpl implements DonacionService {

    @Autowired
    private DonacionDao donacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Donacion> getDonacions(boolean activos) {
        var donacions = donacionDao.findAll();

        return donacions;
    }

    @Override
    @Transactional(readOnly = true)
    public Donacion getDonacion(Donacion donacion) {
        return donacionDao.findById(donacion.getCedula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Donacion donacion) {
        donacionDao.save(donacion);
    }

    @Override
    @Transactional
    public void delete(Donacion donacion) {
        donacionDao.delete(donacion);
    }

}
