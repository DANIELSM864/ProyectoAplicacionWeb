
package com.Anasovi.Anasovi.service;

import com.Anasovi.Anasovi.domain.Donacion;
import java.util.List;


public interface DonacionService {

    public List<Donacion> getDonacions(boolean activos);

    // Se obtiene un Donacion, a partir del id de un donacion
    public Donacion getDonacion(Donacion donacion);

    // Se inserta un nuevo donacion si el id del donacion esta vacío
    // Se actualiza un donacion si el id del donacion NO esta vacío
    public void save(Donacion donacion);

    // Se elimina el donacion que tiene el id pasado por parámetro
    public void delete(Donacion donacion);
}
