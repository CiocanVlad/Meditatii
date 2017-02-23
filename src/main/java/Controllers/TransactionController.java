package Controllers;

import Entities.Transactions;
import Utils.ConnectionController;

import java.util.ArrayList;

/**
 * Created by dioni on 2/22/2017.
 */
public class TransactionController extends ConnectionController {
    public static void SendFunds(int id_user,int credits,String desc){
        try{
            pst=conn.prepareStatement("INSERT into transactions(id_user,credits,date,description,status) values(?,?,?,?,?)");
            pst.setInt(1,id_user);
            pst.setInt(2,credits);
            pst.setTimestamp(3,getCurent());
            pst.setString(4,desc);
            pst.setInt(5,0);
            pst.executeUpdate();
        }catch(Exception ex){

        }
    }
    public static void UpdateStatus(int id,int status){
        try{
            pst=conn.prepareStatement("update transactions set status=? where id=?");
            pst.setInt(1,status);
            pst.setInt(2,id);
            pst.executeUpdate();
        }catch (Exception ex){

        }
    }
    public static ArrayList<Transactions> getAll(){
        ArrayList<Transactions> list =new ArrayList<Transactions>();
        try{
            pst=conn.prepareStatement("select * from transactions");
            rs=pst.executeQuery();
            while(rs.next()){
                Transactions t=new Transactions();
                t.setId(rs.getInt("id"));
                t.setCredits(rs.getInt("credits"));
                t.setId_user(rs.getInt("id_user"));
                t.setDate(rs.getTimestamp("date"));
                t.setDescription(rs.getString("description"));
                t.setStatus(rs.getInt("status"));
                list.add(t);
            }
        }catch (Exception ex){

        }
        return list;
    }
    public static Transactions getByID(int id){
        Transactions t=new Transactions();
        try{
        pst=conn.prepareStatement("select * from transactions where id=?");
            pst.setInt(1,id);
        rs=pst.executeQuery();
        while(rs.next()){

            t.setId(rs.getInt("id"));
            t.setCredits(rs.getInt("credits"));
            t.setId_user(rs.getInt("id_user"));
            t.setDate(rs.getTimestamp("date"));
            t.setDescription(rs.getString("description"));
            t.setStatus(rs.getInt("status"));

        }
    }catch (Exception ex){

    }

        return t;
    }

}
