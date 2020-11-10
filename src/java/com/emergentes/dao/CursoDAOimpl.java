package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOimpl extends ConexionDB implements CursoDAO{
    
    @Override
    public void insert(Curso curs) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into curso (descripcion) values(?)");
            ps.setString(1, curs.getDescripcion());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Curso curs) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE curso set descripcion = ? where id = ?");
            ps.setString(1, curs.getDescripcion());
            ps.setInt(2, curs.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM curso WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        } 
    }

    @Override
    public Curso getById(int id) throws Exception {
        Curso curs = new Curso();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM curso WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                curs.setId(rs.getInt("id"));
                curs.setDescripcion(rs.getString("descripcion"));
            } 
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return curs;
    }

    @Override
    public List<Curso> getAll() throws Exception {
        List<Curso> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT *FROM curso");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Curso>();
            while(rs.next()){
                Curso curs = new Curso();
                curs.setId(rs.getInt("id"));
                curs.setDescripcion(rs.getString("descripcion"));
                lista.add(curs);
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
