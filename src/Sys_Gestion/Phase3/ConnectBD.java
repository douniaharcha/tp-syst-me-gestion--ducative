package Sys_Gestion.Phase3;

import Sys_Gestion.Models.Enseignant;

import java.sql.*;
import java.util.List;

import static Sys_Gestion.Services.DB.enseignants;
import static Sys_Gestion.Services.EnseignantService.deleteEnsById;


public class ConnectBD {



    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://localhost:5432/education";
        String username = "postgres";
        String password = "dounia";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("connected to postgresql server");

           /* String sql="INSERT INTO Enseignant (id_Ens,nom,prénom,email,grade) VALUES(?,?,?,?,?)";

            PreparedStatement st=connection.prepareStatement(sql);

            st.setInt(1,2);
            st.setString(2,"idrissi");
            st.setString(3,"souad");
            st.setString(4,"idrissi@gmail.com");
            st.setString(5,"chef filière");

            st.setInt(1,3);
            st.setString(2,"bachane");
            st.setString(3,"ritaje");
            st.setString(4,"bachane@gmail.com");
            st.setString(5,"enseignant");


            int rows=st.executeUpdate();
            if(rows>0){
                System.out.println("A new teacher has been insert .");
            }*/



           String sql="SELECT * FROM Enseignant";
            Statement st=connection.createStatement();
            ResultSet result =st.executeQuery(sql);
            while(result.next()){
                int id_Ens=result.getInt("id_Ens");
                String nom=result.getString("nom");
                String prénom=result.getString("prénom");
                String email=result.getString("email");
                String grade=result.getString("grade");
                System.out.println(" "+id_Ens+" "+nom+" "+prénom+" "+email+" "+grade);



            connection.close();
        }/* catch (Exception e) {
            System.out.println("error in connecting to postgresql server");
            e.printStackTrace();

        }*/


    } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void updateEns(int id_Ens,String nom,String prénom,String email,String grade)
    {
        try{
            String query="UPDATE Enseignant SET nom= "+nom+", prénom= "+prénom+
                    ", email= "+email+", grade="+grade+" WHERE id_Ens= "+id_Ens;
            Connection connection = null;
            Statement st;
            st=connection.createStatement();
            st.executeUpdate(query);
            System.out.println("well edited teacher");
            

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEnsById(int id_Ens){
        try{

            String query="DELETE FROM Enseignant WHERE id_Ens="+id_Ens;
            Connection connection = null;
            Statement st;
            st=connection.createStatement();
            st.executeUpdate(query);

            System.out.println("well deleted teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }



        }
