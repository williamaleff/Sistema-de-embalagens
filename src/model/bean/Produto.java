/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author William Alefe <alefewilliam@gmail.com>
 */
public class Produto {
    private int id;
    private String codprod;
    private String logixprod;
    private String descprod;
    private String tipo;
    private String pesoprod;
    private String embalagem;
    private String pesopalete;
    private String paletizacao;
    private String logixetiqueta;
    private String descetiqueta;
    private String versao;
    private String vigencia;
    private String DataDeInsercao;
    private String imagem;
    
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getLogixprod() {
        return logixprod;
    }

    public void setLogixprod(String logixprod) {
        this.logixprod = logixprod;
    }

    public String getDescprod() {
        return descprod;
    }

    public void setDescprod(String descprod) {
        this.descprod = descprod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPesoprod() {
        return pesoprod;
    }

    public void setPesoprod(String pesoprod) {
        this.pesoprod = pesoprod;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getPesopalete() {
        return pesopalete;
    }

    public void setPesopalete(String pesopalete) {
        this.pesopalete = pesopalete;
    }

    public String getPaletizacao() {
        return paletizacao;
    }

    public void setPaletizacao(String paletizacao) {
        this.paletizacao = paletizacao;
    }

    public String getLogixetiqueta() {
        return logixetiqueta;
    }

    public void setLogixetiqueta(String logixetiqueta) {
        this.logixetiqueta = logixetiqueta;
    }

    public String getDescetiqueta() {
        return descetiqueta;
    }

    public void setDescetiqueta(String descetiqueta) {
        this.descetiqueta = descetiqueta;
    }
    
    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
    
    public String getDataDeInsercao() {
        return DataDeInsercao;
    }

    public void setDataDeInsercao(String DataDeInsercao) {
        this.DataDeInsercao = DataDeInsercao;
    }
    
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
