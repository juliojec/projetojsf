package br.com.projetojsf.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private static final Object LOCK = new Object();
    
    private String frase;
    private Map<String, Integer> resultadoAnalise;
    private int quantidadePalavrasDistintas;
    private boolean analiseConcluida;
    
    public UsuarioBean() {
        this.frase = "";
        this.resultadoAnalise = new HashMap<>();
        this.quantidadePalavrasDistintas = 0;
        this.analiseConcluida = false;
    }
    
    /**
     * Método para analisar a frase digitada pelo usuário
     */
    public void analisarFrase() {
        if (frase == null || frase.trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "Atenção", "Por favor, digite uma frase para análise."));
            return;
        }
        
        try {
            synchronized (LOCK) {
                processarAnalise();
            }
            
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Sucesso", "Análise concluída com sucesso!"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro", "Erro ao processar a análise: " + e.getMessage()));
        }
    }
    
    private void processarAnalise() {
        resultadoAnalise.clear();
        
        String fraseProcessada = frase.toLowerCase()
            .replaceAll("[^a-zA-ZÀ-ÿ0-9\\s]", "")
            .trim();
        
        String[] palavras = fraseProcessada.split("\\s+");
        
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                resultadoAnalise.put(palavra, 
                    resultadoAnalise.getOrDefault(palavra, 0) + 1);
            }
        }
        
        quantidadePalavrasDistintas = resultadoAnalise.size();
        analiseConcluida = true;
    }
    
    public void limparAnalise() {
        this.frase = "";
        this.resultadoAnalise.clear();
        this.quantidadePalavrasDistintas = 0;
        this.analiseConcluida = false;
    }
    
    public String getFrase() {
        return frase;
    }
    
    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    public Map<String, Integer> getResultadoAnalise() {
        return resultadoAnalise;
    }
    
    public int getQuantidadePalavrasDistintas() {
        return quantidadePalavrasDistintas;
    }
    
    public boolean isAnaliseConcluida() {
        return analiseConcluida;
    }
}