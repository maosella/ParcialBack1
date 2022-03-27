package com.company.servicios;


import com.company.dao.IDao;
import com.company.entidades.Estudiante;

import java.util.List;

public class EstudianteService {

    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteIDao() {
        return estudianteIDao;
    }

    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    /*metodos pasamanos*/

    public Estudiante guardarEstudiante(Estudiante e){ // delegarle la responsabilidad al DAO
        return estudianteIDao.guardar(e);
    }

    public void eliminarEstudiante(Integer id) { // delegarle la respons}
        estudianteIDao.eliminar(id);
    }
    public Estudiante buscarEstudiante(Integer id){
        return estudianteIDao.buscar(id);
    }
    public List<Estudiante> buscarTodos(){
        return estudianteIDao.buscarTodos();
    }
}


