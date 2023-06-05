
package sistemaMVC.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemaMVC.DAO.ExceptionDAO;
import sistemaMVC.DAO.ProdutoDAO;

/**
 *
 * @author norua
 */
public class ProdutoModel {
    private int id;
    private String cod;
    private String status;
    private String nome;
    private String descricao;
    private int qtd_estoque;
    private int estoque_min;
    private int estoque_max;
    private float preco_compra;
    private float preco_venda;
    private int bar_code;
    private int ncm;
    private float fator;
    private String data_cadastro;
    private String imagem;
    
    public ProdutoModel(){
        
    }

    public ProdutoModel(String cod, String status, String nome, String descricao, int qtd_estoque, int estoque_min, int estoque_max, float preco_compra, float preco_venda, int bar_code, int ncm, float fator, String data_cadastro, String imagem) {
        this.cod = cod;
        this.status = status;
        this.nome = nome;
        this.descricao = descricao;
        this.qtd_estoque = qtd_estoque;
        this.estoque_min = estoque_min;
        this.estoque_max = estoque_max;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.bar_code = bar_code;
        this.ncm = ncm;
        this.fator = fator;
        this.data_cadastro = data_cadastro;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public int getEstoque_min() {
        return estoque_min;
    }

    public void setEstoque_min(int estoque_min) {
        this.estoque_min = estoque_min;
    }

    public int getEstoque_max() {
        return estoque_max;
    }

    public void setEstoque_max(int estoque_max) {
        this.estoque_max = estoque_max;
    }

    public float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getBar_code() {
        return bar_code;
    }

    public void setBar_code(int bar_code) {
        this.bar_code = bar_code;
    }

    public int getNcm() {
        return ncm;
    }

    public void setNcm(int ncm) {
        this.ncm = ncm;
    }

    public float getFator() {
        return fator;
    }

    public void setFator(float fator) {
        this.fator = fator;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    

    
    public void cadastrarProduto(ProdutoModel produto) throws ExceptionDAO{
        new ProdutoDAO().cadastrarProduto(produto);
        
    }
    
    public List<ProdutoModel> listarProdutos() throws ExceptionDAO{
        return new ProdutoDAO().listarProdutos();
    }
    
    public void alterarProduto(ProdutoModel produto) throws ExceptionDAO{
        new ProdutoDAO().alterarProduto(produto);
        
    }
    public void excluirProduto(ProdutoModel produto) throws ExceptionDAO{
        new ProdutoDAO().excluirProduto(produto);
        
    }
    
    
    
}
