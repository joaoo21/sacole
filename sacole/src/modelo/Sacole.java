/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Sacole {
    private int codigo;
    private int nrdeserie;
    private Double preco;
    private LocalDate datadevalidade;
    private String sabor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNrdeserie() {
        return nrdeserie;
    }

    public void setNrdeserie(Integer nrdeserie) {
        this.nrdeserie = nrdeserie;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDatadevalidade() {
        return datadevalidade;
    }

    public void setDatadevalidade(LocalDate datadevalidade) {
        this.datadevalidade = datadevalidade;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return sabor;
    }


    
}
