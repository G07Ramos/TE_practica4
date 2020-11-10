package com.emergentes.dao;

import com.emergentes.modelo.Inscripciones;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesDAOimpl extends ConexionDB implements InscripcionesDAO{
    
    @Override
    public void insert(Inscripciones ins) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into inscripciones (id_curso,id_estudiante,nota_final) values (?,?,?)");
            ps.setInt(1,ins.getId_curso()); 
            ps.setInt(2,ins.getId_estudiante()); 
            ps.setInt(3,ins.getNota_final()); 
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Inscripciones ins) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE inscripciones set id_curso=?, id_estudiante=?, nota_final=? where id=?");
            ps.setInt(1,ins.getId_curso()); 
            ps.setInt(2,ins.getId_estudiante()); 
            ps.setInt(3,ins.getNota_final()); 
            ps.setInt(4,ins.getId()); 
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM inscripciones WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        } 
    }

    @Override
    public Inscripciones getById(int id) throws Exception {
        Inscripciones ins = new Inscripciones();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT *FROM inscripciones WHERE id=? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ins.setId(rs.getInt("id"));
                ins.setId_curso(rs.getInt("id_curso"));
                ins.setId_estudiante(rs.getInt("id_estudiante"));
                ins.setNota_final(rs.getInt("nota_final"));
            } 
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return ins;
    }

    @Override
    public List<Inscripciones> getAll() throws Exception {
        List<Inscripciones> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT i.id as id, c.descripcion as curso,concat(e.apellidos,' ',e.nombre) as nombre,i.nota_final as nota_final from inscripciones i left join estudiantes e on i.id_estudiante = e.id left join curso c on i.id_curso = c.id");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Inscripciones>();
            while(rs.next()){
                Inscripciones ins = new Inscripciones();
                ins.setId(rs.getInt("id"));
                ins.setCurso(rs.getString("curso"));
                ins.setNombre(rs.getString("nombre"));
                ins.setNota_final(rs.getInt("nota_final"));
                lista.add(ins);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
}
