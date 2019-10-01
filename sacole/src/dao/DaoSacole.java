/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Sacole;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Administrador
 */
public class DaoSacole {
     public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (nrdeserie, preco, datadevalidade, sabor) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getNrdeserie());
            ps.setDouble(2, objeto.getPreco());
            ps.setDate(3, Date.valueOf(objeto.getDatadevalidade())); //é necessário fazer a seguinte importação import java.sql.Date;
            ps.setString(4, objeto.getSabor());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


      
        public static boolean alterar(Sacole objeto) {
        String sql = "UPDATE sacole SET nrdeserie = ?, preco = ?, datadevalidade = ?, sabor = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getNrdeserie()); 
            ps.setDouble(2, objeto.getPreco());
            ps.setDate(3, Date.valueOf(objeto.getDatadevalidade()));
            ps.setString(4, objeto.getSabor());
            ps.setInt(5, objeto.getCodigo());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        
          public static boolean excluir(Sacole objeto) {
        String sql = "DELETE FROM sacole WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
          public static List<Sacole> consultar() {
        List<Sacole> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nrdeserie, preco, datadevalidade, sabor FROM sacole";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sacole objeto = new Sacole();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNrdeserie(rs.getInt("nrdeserie"));
                objeto.setPreco(rs.getDouble("preco"));
                objeto.setDatadevalidade(rs.getDate("datadevalidade").toLocalDate());
                objeto.setSabor(rs.getString("sabor"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
          
           public static Sacole consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nrdeserie, preco, datadevalidade, sabor FROM sacole WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sacole objeto = new Sacole();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNrdeserie(rs.getInt("nrdeserie"));
                objeto.setPreco(rs.getDouble("preco"));
                objeto.setDatadevalidade(rs.getDate("datadevalidade").toLocalDate());
                objeto.setSabor(rs.getString("sabor"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
