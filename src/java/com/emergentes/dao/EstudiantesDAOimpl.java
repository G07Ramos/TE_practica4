package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends ConexionDB implements EstudiantesDAO{
    
    @Override
    public void insert(Estudiantes est) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into estudiantes (nombre,apellidos,correo) values(?,?,?)");
            ps.setString(1, est.getNombre());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getCorreo());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiantes est) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes set nombre = ?,apellidos = ?,correo = ? where id = ?");
            ps.setString(1, est.getNombre());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getCorreo());
            ps.setInt(4, est.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        } 
    }

    @Override
    public Estudiantes getById(int id) throws Exception {
        Estudiantes pro = new Estudiantes();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id=? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellidos(rs.getString("apellidos"));
                pro.setCorreo(rs.getString("correo"));
            } 
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT *FROM estudiantes");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Estudiantes>();
            while(rs.next()){
                Estudiantes pro = new Estudiantes();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellidos(rs.getString("apellidos"));
                pro.setCorreo(rs.getString("correo"));
                lista.add(pro);
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
