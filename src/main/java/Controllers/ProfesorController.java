package Controllers;

import Entities.Profesor;
import Utils.ConnectionController;

import java.util.ArrayList;

/**
 * Created by dioni on 2/17/2017.
 */
public class ProfesorController extends ConnectionController {
    public static void AddNew(int idu,int mat,String desc){
        try{
            pst=conn.prepareStatement("insert into profesor(id_user,materie,descriere) values(?,?,?)");
            pst.setInt(1,idu);
            pst.setInt(2,mat);
            pst.setString(3,desc);
            pst.executeUpdate();

        }catch (Exception ex){

        }
    }
    public static void Update(int id,int mat, String desc){
        try{
            pst=conn.prepareStatement("update profesor set materie=?,descriere=? where id=?");
            pst.setInt(1,mat);
            pst.setString(2,desc);
            pst.setInt(3,id);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static void Delete(int id){
        try{
            pst=conn.prepareStatement("delete from profesor where id=?");
            pst.setInt(1,id);
            pst.executeUpdate();

        }catch (Exception ex){

        }
    }
    public static Profesor getById(int id){
        Profesor p=new Profesor();
        try{
            pst=conn.prepareStatement("select * from profesor where id=?");
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while(rs.next()){
                p.setId(id);
                p.setDescriere(rs.getString("descriere"));
                p.setId_user(rs.getInt("id_user"));
                p.setMaterie(rs.getInt("materie"));
            }
        }catch (Exception es){

        }
        return p;
    }
    public static ArrayList<Profesor> GetByMat(int mat){
        ArrayList<Profesor> list=new ArrayList<Profesor>();
        try{
            pst=conn.prepareStatement("select * from profesor where materie=?");
            pst.setInt(1, mat);
            rs=pst.executeQuery();
            while(rs.next()){
                Profesor p =new Profesor();
                p.setId(rs.getInt("id"));
                p.setDescriere(rs.getString("descriere"));
                p.setId_user(rs.getInt("id_user"));
                p.setMaterie(rs.getInt("materie"));
                list.add(p);
            }
        }catch (Exception es){

        }
        return list;
    }
    public static ArrayList<Profesor> GetByUser(int id_u){
        ArrayList<Profesor> list=new ArrayList<Profesor>();
        try{
            pst=conn.prepareStatement("select * from profesor where id_user=?");
            pst.setInt(1, id_u);
            rs=pst.executeQuery();
            while(rs.next()){
                Profesor p =new Profesor();
                p.setId(rs.getInt("id"));
                p.setDescriere(rs.getString("descriere"));
                p.setId_user(rs.getInt("id_user"));
                p.setMaterie(rs.getInt("materie"));
                list.add(p);
            }
        }catch (Exception es){

        }
        return list;
    }
    public static ArrayList<Profesor> GetAll(){
        ArrayList<Profesor> list=new ArrayList<Profesor>();
        try{
            pst=conn.prepareStatement("select * from profesor ");

            rs=pst.executeQuery();
            while(rs.next()){
                Profesor p =new Profesor();
                p.setId(rs.getInt("id"));
                p.setDescriere(rs.getString("descriere"));
                p.setId_user(rs.getInt("id_user"));
                p.setMaterie(rs.getInt("materie"));
                list.add(p);
            }
        }catch (Exception es){

        }
        return list;
    }

}
