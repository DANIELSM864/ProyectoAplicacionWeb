
package com.Anasovi.Anasovi.service;

import com.Anasovi.Anasovi.domain.Consulta;
import java.util.List;


public interface ConsultaService {

    public List<Consulta> getConsultas(boolean activos);

    // Se obtiene un Consulta, a partir del id de un consulta
    public Consulta getConsulta(Consulta consulta);

    // Se inserta un nuevo consulta si el id del consulta esta vacío
    // Se actualiza un consulta si el id del consulta NO esta vacío
    public void save(Consulta consulta);

    // Se elimina el consulta que tiene el id pasado por parámetro
    public void delete(Consulta consulta);
}
