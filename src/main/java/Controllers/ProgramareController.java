package Controllers;

import Entities.Programare;
import Utils.ConnectionController;

import java.util.ArrayList;


/**
 * Created by dioni on 2/22/2017.
 */
public class ProgramareController extends ConnectionController {
    public static void New(int id_elev,int id_prof,int duration,String  time){
        try{
            pst=conn.prepareStatement("insert into programari(id_elev,id_profesor,duration,time,status) values(?,?,?,?,?)");
            pst.setInt(1,id_elev);
            pst.setInt(2,id_prof);
            pst.setInt(3,duration);
            pst.setTimestamp(4,getFromString(time));
            pst.setInt(5,1);
            pst.executeUpdate();
        }catch(Exception ex){

        }
    }
    public static void Cancel(int id){
        try{
            pst=conn.prepareStatement("update programari set status=? where id=?");
            pst.setInt(1,0);
            pst.setInt(2,id);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static ArrayList<Programare> getUpcommingP(int id_prof){
        ArrayList<Programare> list=new ArrayList<Programare>();
        try{
            pst=conn.prepareStatement("select * from programari where id_prof=? and time >= CURDATE()");
            pst.setInt(1,id_prof);
            rs=pst.executeQuery();
            while(rs.next()){
                Programare p=new Programare();
                p.setId(rs.getInt("id"));
                p.setId_prof(rs.getInt("id_prof"));
                p.setId_elev(rs.getInt("id_elev"));
                p.setDuration(rs.getInt("duration"));
                p.setTime(getFromTimestamp(rs.getTimestamp("time")));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        }catch(Exception ex){

        }
        return list;
    }
    public static ArrayList<Programare> getUpcommingS(int id_elev){
        ArrayList<Programare> list=new ArrayList<Programare>();
        try{
            pst=conn.prepareStatement("select * from programari where id_elev=? and time >= CURDATE()");
            pst.setInt(1,id_elev);
            rs=pst.executeQuery();
            while(rs.next()){
                Programare p=new Programare();
                p.setId(rs.getInt("id"));
                p.setId_prof(rs.getInt("id_prof"));
                p.setId_elev(rs.getInt("id_elev"));
                p.setDuration(rs.getInt("duration"));
                p.setTime(getFromTimestamp(rs.getTimestamp("time")));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        }catch(Exception ex){

        }
        return list;
    }

}
